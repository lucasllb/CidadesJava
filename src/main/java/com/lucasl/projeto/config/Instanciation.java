package com.lucasl.projeto.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucasl.projeto.domain.Cidade;
import com.lucasl.projeto.repository.CidadeRepository;

@Configuration
public class Instanciation implements CommandLineRunner {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	/*item 1*/
	@Override
	public void run(String... args) throws Exception {
		cidadeRepository.deleteAll();
		
		List<String[]> listaRegistros = new ArrayList<String[]>();
        File arquivoCSV = new File("C:\\cidades.csv");
        FileReader fr = new FileReader(arquivoCSV);
        BufferedReader br = new BufferedReader(fr);
        String linha;
        int cont = 1;
        while ((linha = br.readLine()) != null) {
        	if(cont != 1) {
        		String registro[] = linha.split(",");
                listaRegistros.add(registro);
                Cidade cidade = new Cidade(listaRegistros);
                cidadeRepository.save(cidade);
                listaRegistros.remove(registro);
        	} else {
        		cont ++;
        	}
        }
	}
}
