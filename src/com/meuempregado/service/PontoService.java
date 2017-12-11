package com.meuempregado.service;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import com.meuempregado.dao.FactoryDao;
import com.meuempregado.dao.PontoDao;
import com.meuempregado.model.Ponto;


public class PontoService{

	//Pegar por parametro o empregado.id onde esta 1
	public void inserir(int id) {
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd.MM.yyyy");
		SimpleDateFormat horarioFormatado = new SimpleDateFormat("HH:mm");
		
		PontoDao pDao = new PontoDao();
		Ponto ponto = new Ponto();
		ponto = pDao.buscarPonto(id);
		if(ponto.getData() == null){	
			ponto.setIdFuncionario(id);
			ponto.setData(dataFormatada.format(gc.getTime()));
			ponto.setHoraEntrada(horarioFormatado.format(gc.getTime()));
			FactoryDao.createGenericDao(Ponto.class).inserir(ponto);			
		}else{
			if(ponto.getHoraEntradaAlmoco() == null){
				ponto.setHoraEntradaAlmoco(horarioFormatado.format(gc.getTime()));
			}else if(ponto.getHoraSaidaAlmoco() == null){
				ponto.setHoraSaidaAlmoco(horarioFormatado.format(gc.getTime()));
			}else if(ponto.getHoraSaida() == null){
				ponto.setHoraSaida(horarioFormatado.format(gc.getTime()));
				
				
				
					   String timeString2=ponto.getHoraEntrada();
					   String timeString1=ponto.getHoraSaida(); 
					
					   String[] fractions1=timeString1.split(":");
					   String[] fractions2=timeString2.split(":");
					   Integer hours1=Integer.parseInt(fractions1[0]);
					   Integer hours2=Integer.parseInt(fractions2[0]);
					   Integer minutes1=Integer.parseInt(fractions1[1]);
					   Integer minutes2=Integer.parseInt(fractions2[1]);      
					   int hourDiff=hours1-hours2;
					   int minutesDiff=minutes1-minutes2;
					   if (minutesDiff < 0) {
					       minutesDiff = 60 + minutesDiff;
					       hourDiff--;
					   }
					   if (hourDiff < 0) {
					       hourDiff = 24 + hourDiff ;
					   }
					   System.out.println("There are " + hourDiff + " and " + minutesDiff + " of difference");

				
				ponto.setHorasTrabalhadas(hourDiff+":"+minutesDiff);
				System.out.println(ponto.getHoraSaida());
			}
			alterar(ponto);
		}
		
	}

	public void excluir(Integer id) {
		FactoryDao.createGenericDao(Ponto.class).excluir(id);
	}

	public void alterar(Ponto entity) {
		FactoryDao.createGenericDao(Ponto.class).alterar(entity);
	}

	public List<Ponto> listar(){
		return FactoryDao.createGenericDao(Ponto.class).listarTodos();
	}

	public Ponto buscarPorId(Integer id) {
		return FactoryDao.createGenericDao(Ponto.class).buscarPorId(id);
	}

	public List<Ponto> listarTodos(Class<Ponto> c, String where, Object... args) {
		return FactoryDao.createGenericDao(Ponto.class).listarTodos(c, where, args);
	}
}
