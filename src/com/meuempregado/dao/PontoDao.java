package com.meuempregado.dao;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import com.meuempregado.model.Ponto;
import com.meuempregado.util.ConnectDao;

public class PontoDao {
	GregorianCalendar gc = new GregorianCalendar();
	SimpleDateFormat dataFormatada = new SimpleDateFormat("dd.MM.yyyy");
	SimpleDateFormat horarioFormatado = new SimpleDateFormat("HH:mm");
	private EntityManager em;
	
	// Mudar o "int id" para "Empregado empregado"
	public Ponto buscarPonto(int id){
		EntityManager em = ConnectDao.getInstance().createEntityManager();
		
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd.MM.yyyy");
		
		Ponto ponto = new Ponto();
		
		String hql = "FROM Ponto p WHERE p.data LIKE :data AND p.idFuncionario LIKE :id";
		
		List<Ponto> lista = em.createQuery(hql).setParameter("data", dataFormatada.format(gc.getTime()))
		.setParameter("id", id).getResultList();
		
		if(lista.size() != 0){
			ponto = lista.get(0);
		}
		return ponto;
	}
}