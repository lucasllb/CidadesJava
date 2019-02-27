package com.lucasl.projeto.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lucasl.projeto.domain.Cidade;

@Service
public interface InterfaceCidadeDao {
	public long countById();
	
	public List<Cidade> retornaSomenteCapitais();
	
	public long retornaCidadesPorEstado(String estado);
	
	public List<Cidade> consultaColuna(String coluna, String string);
	
	public List<String> retornaNomeCidadePorEstado(String estado);
	
	public long registroUnicoBaseadoEmColuna(String coluna);
	
	public String[] retornaEstadoMenorMaior();
	
	public String[] cidadesMaisDistantes();
	
}
