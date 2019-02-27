package com.lucasl.projeto.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.lucasl.projeto.domain.Cidade;
import com.lucasl.projeto.dto.CidadeDTO;
import com.lucasl.projeto.repository.CidadeRepository;
import com.lucasl.projeto.services.exception.ObjectNotFoundExcption;

@Service
@ComponentScan(basePackages = "com.lucasl.projeto")
public class CidadeService {
	
	@Autowired
	private CidadeRepository repo;

	public List<Cidade> findAll(){
		return repo.findAll();
	}	
	
	public Cidade findById(String id) {  
		Optional<Cidade> obj = repo.findById(id);  
		return obj.orElseThrow(() -> new ObjectNotFoundExcption("Objeto não encontrado"));
	} 
	
	public Cidade insert(Cidade obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public Cidade fromDTO(CidadeDTO objDto) {
		return new Cidade(objDto.getIbgeid(), objDto.getUf(), objDto.getName(), objDto.getCapital(),
				          objDto.getLon(), objDto.getLat(), objDto.getNo_accents(), objDto.getAlternative_names(),
				          objDto.getMicroregion(), objDto.getMesoregion());
	}
	
}
