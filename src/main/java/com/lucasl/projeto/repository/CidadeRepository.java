package com.lucasl.projeto.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucasl.projeto.domain.Cidade;

@Repository
@ComponentScan(basePackages = "com.lucasl.projeto")
public interface CidadeRepository extends MongoRepository<Cidade, String>{

}
