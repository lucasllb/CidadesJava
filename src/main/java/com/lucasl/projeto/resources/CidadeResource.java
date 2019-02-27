package com.lucasl.projeto.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucasl.projeto.dao.CidadeDao;
import com.lucasl.projeto.domain.Cidade;
import com.lucasl.projeto.dto.CidadeDTO;
import com.lucasl.projeto.services.CidadeService;

@RestController
@RequestMapping(value="/cidades")
@ComponentScan(basePackages = "com.lucasl.projeto")
public class CidadeResource {
	
	@Autowired
	private CidadeService service;
	
	@Autowired
	private CidadeDao entidadeDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findAll(){
		List<Cidade> list = service.findAll();
		List<CidadeDTO> listDto = list.stream().map(x -> new CidadeDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
	@RequestMapping(value="/countAll",method=RequestMethod.GET)
	public ResponseEntity<Long> countAll() {
		long qtd = entidadeDao.countById();
		return ResponseEntity.ok().body(qtd);
	}
	
	/*item 5*/
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<CidadeDTO> findById(@PathVariable String id){
		Cidade obj = service.findById(id);
		return ResponseEntity.ok().body(new CidadeDTO(obj));
	}
	
	/*item 7*/
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody CidadeDTO objDto){
		Cidade obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIbgeid()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/*item 8*/
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/retornaSomenteCapitais",method=RequestMethod.GET)
	public ResponseEntity<List<Cidade>> retornaSomenteCapitais() {
		List<Cidade> cidades = entidadeDao.retornaSomenteCapitais();
		return ResponseEntity.ok().body(cidades);
	}
	
	
	@RequestMapping(value="/uf/{estado}", method=RequestMethod.GET)
	public ResponseEntity<Long> retornaCidadesPorEstado(@PathVariable String estado) {
		long qtd = entidadeDao.retornaCidadesPorEstado(estado);
		return ResponseEntity.ok().body(qtd);
	}
	
	
	@RequestMapping(value="/query/{coluna}/{string}", method=RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> consulta(@PathVariable String coluna, @PathVariable String string) {
		List<Cidade> list = entidadeDao.consultaColuna(coluna, string);
		List<CidadeDTO> listDto = list.stream().map(x -> new CidadeDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
	@RequestMapping(value="/registroUnicoBaseadoEmColuna/{coluna}", method=RequestMethod.GET)
	public ResponseEntity<Long> registroUnicoBaseadoEmColuna(@PathVariable String coluna) {
		long qtd = entidadeDao.registroUnicoBaseadoEmColuna(coluna);
		return ResponseEntity.ok().body(qtd);
	}
	

	@RequestMapping(value="/retornaEstadoMenorMaior",method=RequestMethod.GET)
	public ResponseEntity<String[]> retornaEstadoMenorMaior() {
		String[] list = entidadeDao.retornaEstadoMenorMaior();
		return ResponseEntity.ok().body(list);
	}
	
	
	@RequestMapping(value="/retornaCidadesMaisDistantes",method=RequestMethod.GET)
	public ResponseEntity<String[]> cidadesMaisDistantes() {
		String[] list = entidadeDao.cidadesMaisDistantes();
		return ResponseEntity.ok().body(list);
	}
	
	
	@RequestMapping(value="/retornaNomeCidadesPorEstado/{estado}",method=RequestMethod.GET)
	public ResponseEntity<List<String>> retornaNomeCidadePorEstado(@PathVariable String estado) {
		List<String> list = entidadeDao.retornaNomeCidadePorEstado(estado);
		return ResponseEntity.ok().body(list);
	}
	
	
}
