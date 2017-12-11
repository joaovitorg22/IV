package test;


import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.meuempregado.model.Empregado;
import com.meuempregado.model.Ponto;
import com.meuempregado.service.EmpregadoService;
import com.meuempregado.service.PontoService;
import com.meuempregado.util.ConnectDao;

public class postoTest {
	@Test
	public void ad(){
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd.MM.yyyy");
		EmpregadoService es = new EmpregadoService();
		Empregado e = new Empregado("ale", dataFormatada.format(gc.getTime()), "1111", "2222", "21312","21321","12321321","PUTA QUE PARIu",32,"casa","adsad","wqe2","pr",true,true,"leo");
		
		es.inserir(e);
	}
	
	public void inserir(List<Ponto> lista, int id) {
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd.MM.yyyy");
		SimpleDateFormat horarioFormatado = new SimpleDateFormat("HH:mm");
		PontoService pService = new PontoService();
		if(lista.size() == 0){	
			Ponto ponto = new Ponto();
			lista.get(0).setIdFuncionario(id);
			lista.get(0).setData(dataFormatada.format(gc.getTime()));
			lista.get(0).setHoraEntrada(horarioFormatado.format(gc.getTime()));
			ponto = (Ponto) lista;
			//pService.inserir(ponto);
		}else{
			if(lista.get(0).getHoraEntradaAlmoco() == null){
				lista.get(0).setHoraEntradaAlmoco(horarioFormatado.format(gc.getTime()));
			}else if(lista.get(0).getHoraSaidaAlmoco() == null){
				lista.get(0).setHoraSaidaAlmoco(horarioFormatado.format(gc.getTime()));
			}else if(lista.get(0).getHoraSaida() == null){
				lista.get(0).setHoraSaida(horarioFormatado.format(gc.getTime()));
			}
			Ponto ponto = new Ponto();
			ponto = lista.get(0);
			pService.alterar(ponto);
		}
	}

	
	public void buscarPonto() {
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd.MM.yyyy");
		EntityManager em = ConnectDao.getInstance().createEntityManager();
		Ponto ponto = new Ponto();
		int id = 4;
		
		String hql = "FROM Ponto p WHERE p.data LIKE :data AND p.idFuncionario LIKE :id";
		List<Ponto> lista = em.createQuery(hql).setParameter("data", dataFormatada.format(gc.getTime()))
		.setParameter("id", id).getResultList();
		
		inserir(lista, id);
	}
	
	public void testeas() {
		EntityManager em = ConnectDao.getInstance().createEntityManager();
		int id = 1;
		
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd.MM.yyyy");
		SimpleDateFormat horarioFormatado = new SimpleDateFormat("HH:mm");
		
		Ponto ponto = new Ponto();
		
		//ponto = em.find(Ponto.class, "WHERE idFuncionario = "+id +"AND data =" + dataFormatada.format(gc.getTime()));
		ponto = (Ponto) em.createQuery("SELECT * FROM meuempregadop.tb_ponto WHERE idFuncionario = '1' AND data = '10.11.2017'");
		
		if(ponto.getData().isEmpty()) {
			System.out.println("NULO");
		}else {
			System.out.println("COPULADO");
		}
		em.close();
	}

}
