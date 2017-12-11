package com.meuempregado.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.meuempregado.model.Empregado;

public class junitEmpregado {

	@Test
	public void TesteUnit() throws Exception {
		
		/*Empregado e = new Empregado();
		//e.setId(1);
		e.setNomeCompleto("Your mother");
		e.setDataNascimento(new Date());
		e.setCpf("111.111.111-11");
		e.setRg("11.111.111-1");
		e.setTelefoneFixo("(41)1111-1111");
		e.setTelefoneCelular("(41)11111-1111");
		e.setCep("83750000");
		e.setEnderecoRua("St. Highway to Hell");
		e.setEnderecoNumero(666);
		e.setComplemento("House");
		e.setBairro("Heaven");
		e.setCidade("Lapa");
		e.setUf("PR");
		e.setEmail("yourmother@outlook.com");
		e.setSenha("666");
		e.setAtivo(true);
		e.setSexo(false);
		e.setDescricao("Facear");*/
		
		//-------------------------------------------
		//Instanciando Service do Empregado
		EmpregadoService es = new EmpregadoService();
		
		//Instanciando variáveis para teste
		Empregado mostrar = new Empregado();
		List<Empregado> listar = new ArrayList<>();
		//-------------------------------------------

		/*Método de inserir informações no banco de dados*/
		//es.inserir(e);
		
		/*Método de alterar informações no banco de dados*/
		//es.alterar(e);
		
		//-------------------------------------------
		
		/*Método para listar todos os registros do banco de dados*/
		listar = es.listar();
		
		/*Método para listar empregados a partir de um campo de pesquisa. Filtrando por(cidade, bairro, endereço ou cep)*/
		//listar = es.filtrar("Duque");
		
		/*Método para buscar cep através de WebService*/
		/*mostrar.setCep("81900400");
		es.buscarCEP(mostrar);*/
		
		//----------------Mostra informações no console-----------------
		//System.out.println(mostrar);
		System.out.println(listar);
	}
	
}