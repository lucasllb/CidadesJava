package com.lucasl.projeto.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.lucasl.projeto.domain.Cidade;
import com.lucasl.projeto.repository.InterfaceCidadeDao;
import com.lucasl.projeto.services.CidadeService;

@Service
public class CidadeDao implements InterfaceCidadeDao {
	
	@Autowired
	private CidadeService service;
	
	@Autowired
	MongoTemplate mongoTemplate;
	/*item 11*/
	public long countById() {
		Query query = new Query();
		query.addCriteria(Criteria.where("ibgeid").exists(true));
		long quantidade = mongoTemplate.count(query, Cidade.class);
		return quantidade;
	}

	/*item 2*/
	public List<Cidade> retornaSomenteCapitais() {
		Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC, "name"));
		query.addCriteria(Criteria.where("capital").is("true"));
		List<Cidade> cidades = mongoTemplate.find(query, Cidade.class);
		return cidades;
	}

	/*item 4*/
	public long retornaCidadesPorEstado(String estado) {
		Query q = new Query();
		q.addCriteria(Criteria.where("uf").is(estado));
		long quantidade = mongoTemplate.count(q, Cidade.class);
		return quantidade;
	}

	/*item 9*/
	@Override
	public List<Cidade> consultaColuna(String text, String string) {
		Query query = new Query();
		query.addCriteria(Criteria.where(text).is(string));
		List<Cidade> cidades = mongoTemplate.find(query, Cidade.class);
		return cidades;
	}

	/*item 10*/
	@Override
	public long registroUnicoBaseadoEmColuna(String text) {
		Query query = new Query();
		query.addCriteria(Criteria.where(text).exists(true));
		List<String> list = mongoTemplate.findDistinct(query, text, Cidade.class, String.class);
		long count = list.size();
		return count;
	}

	/*item 3*/
	@Override
	public String[] retornaEstadoMenorMaior() {
		Query query = new Query();
		query.addCriteria(Criteria.where("uf").exists(true));
		List<String> list = mongoTemplate.findDistinct(query, "uf", Cidade.class, String.class);
		String[] estados = new String[2];
		Long[] valores = {Long.MAX_VALUE, Long.MIN_VALUE};
		for(String s : list) {
			Query q = new Query();
			q.addCriteria(Criteria.where("uf").is(s));
			long quantidade = mongoTemplate.count(q, Cidade.class);
			System.out.println("uf"+ s + " qtd "+quantidade);
			if(quantidade < valores[0]) {
				valores[0] = quantidade;
				estados[0] = s;
			}else if(quantidade >= valores[1]) {
				valores[1] = quantidade;
				estados[1] = s;
			}
			
		}		
		String[] resposta = {estados[0],String.valueOf(valores[0]),estados[1],String.valueOf(valores[1])};
		
		return resposta;
	}

	/*item 12*/
	@Override
	public String[] cidadesMaisDistantes() {
		List<Cidade> list = service.findAll();
		String[] cidades = new String[2];
		double[] valores = {Long.MIN_VALUE};
		for(Cidade cidade : list) {
			for(Cidade c :list) {
				if(cidade != c) {
					double lon1 = Double.parseDouble(cidade.getLon());
					double lon2 = Double.parseDouble(c.getLon());
					double lat1 = Double.parseDouble(cidade.getLat());
					double lat2 = Double.parseDouble(c.getLat());
					double theta = lon1 - lon2;
					double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
					dist = Math.acos(dist);
					dist = Math.toDegrees(dist);
					dist = dist * 60 * 1.1515;
					dist = dist * 1.609344;
					if(dist > valores[0]) {
						valores[0] = dist;
						cidades[0] = cidade.getName();
						cidades[1] = c.getName();
					}
				}
			}	
		}
		String[] resposta = {cidades[0],cidades[1],String.valueOf(valores[0])};
		
		return resposta;
	}

	/*item 6*/
	@Override
	public List<String> retornaNomeCidadePorEstado(String estado) {
		Query q = new Query();
		q.addCriteria(Criteria.where("uf").is(estado));
		List<String> list = mongoTemplate.findDistinct(q,"name", Cidade.class, String.class);
		return list;
	}
	
}
