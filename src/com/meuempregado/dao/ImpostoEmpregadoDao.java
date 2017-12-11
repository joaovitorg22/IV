package com.meuempregado.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.meuempregado.model.Empregado;
import com.meuempregado.model.ImpostoEmpregado;
import com.meuempregado.util.ConnectDao;

public class ImpostoEmpregadoDao implements InterfaceImpostoEmpregadoDao{

	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<ImpostoEmpregado> buscarPorEmpregado(Empregado empregado){
		
		em = ConnectDao.getInstance().createEntityManager();
		
		List<ImpostoEmpregado> retorno = new ArrayList<>();
		
		Query q = em.createQuery("select imposto from ImpostoEmpregado imposto where imposto.contrato.empregado.id = :id")
				.setParameter("id", empregado.getId());
		
		retorno = (List<ImpostoEmpregado>) q.getResultList();
		
		return retorno;
	}
	
	public Date obterUltimoProcessamento() {
		em = ConnectDao.getInstance().createEntityManager();
		Query q = em.createNativeQuery("select MAX(mes) as result from tb_impostoEmpregado");
		Date retorno = (Date) q.getSingleResult();
		return retorno;
	}
	
}
