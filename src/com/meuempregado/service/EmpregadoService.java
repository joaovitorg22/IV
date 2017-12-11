package com.meuempregado.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.lavieri.modelutil.cep.WebServiceCep;

import com.meuempregado.dao.FactoryDao;
import com.meuempregado.dao.GenericDao;
import com.meuempregado.model.Empregado;
import com.meuempregado.util.ConnectDao;

public class EmpregadoService{

	

	//Método de inserção de um novo Empregado
	public void inserir(Empregado entity) {
		FactoryDao.createGenericDao(Empregado.class).inserir(entity);
	}

	public void excluir(Integer id) {
		//NÃO SERÁ EXCLUÍDO NENHUM REGISTRO
	}

	//Método de alteração das informações do objeto "entity" do tipo Empregado que for passado por parâmetro
	public void alterar(Empregado entity) {
		FactoryDao.createGenericDao(Empregado.class).alterar(entity);
	}

	//Método que busca todos os registros da base de dados
	public List<Empregado> listar() {
		return FactoryDao.createGenericDao(Empregado.class).listarTodos();
	}

	//Método que busca pelo id o registro da base de dados
	public Empregado obter(Integer id) {
		return FactoryDao.createGenericDao(Empregado.class).buscarPorId(id);
	}
	
	//Método que filtra registros direto da base de dados, através de um parâmetro em um campo de pesquisa. (cidade, bairro, endereço ou cep);
	public List<Empregado> filtrar(String parametro){
		//Faz uma lista do tipo empregado
		List<Empregado> listaResultado = new ArrayList<Empregado>();
		
		//verificação da string que foi passada por parâmetro e dependendo vai atribuir na lista o resultado.
		if(parametro != null && parametro.trim().length() > 0) {
			EntityManager em = ConnectDao.getInstance().createEntityManager();
			//Query
			String hql = "select e from Empregado e where (e.cidade like :p) or (e.bairro like :p) or (e.enderecoRua like :p) or (e.cep like :p)";
			Query query = em.createQuery(hql);
			query.setParameter("p", "%"+parametro+"%");
			listaResultado = (List<Empregado>) query.getResultList();
		}else {
			listaResultado = listar();
		}
		
		//Retorna o que foi atribuída à lista do tipo Empregado
		return listaResultado;
	}
	
	//Método de busca de informações de endereço através de WebService.
	public Empregado buscarCEP(Empregado e) throws Exception {
		WebServiceCep ws = WebServiceCep.searchCep(e.getCep());
		if(ws.isCepNotFound()==true) {
			throw new Exception("Não foi encontrado nenhuma informação através deste CEP.");
		}else {
			e.setCep(ws.getCep());
			e.setEnderecoRua(ws.getLogradouroFull());
			e.setBairro(ws.getBairro());
			e.setCidade(ws.getCidade());
			e.setUf(ws.getUf());			
		}
		return e;
	}
	
}