package com.meuempregado.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meuempregado.dao.FactoryDao;
import com.meuempregado.dao.ImpostoEmpregadoDao;
import com.meuempregado.model.Contrato;
import com.meuempregado.model.Empregado;
import com.meuempregado.model.ImpostoEmpregado;

public class ImpostoEmpregadoService{
	
	
	private double calcularInss(double salario) {
		
		double retorno = 0;
		
		if(salario <= 1659.38) {
			retorno = (salario * 8) / 100;
		}
		else if(salario<=2765.66) {
			retorno = (salario * 9) / 100;
		}
		else{
			retorno = (salario * 11) / 100;
		}
		
		return retorno;
	}
	private double calcularIrf(double salario) {
		
		double retorno = 0;
		
		if(salario <= 1903.98) {
			retorno = 0;
		}
		else if(salario <= 2679.29) {
			retorno = ((salario * 7.5) / 100) - 134.08;
		}
		else if(salario <= 3572.43) {
			retorno = ((salario * 15) / 100) - 335.03;
		}
		else if(salario <= 4463.81) {
			retorno = ((salario * 22.5) / 100) - 602.96;
		}
		else {
			retorno = ((salario * 27.5) / 100) - 826.15;
		}
		
		if(retorno<10)
			retorno = 0;
		
		return retorno;
	}
	
	
	
	
	public void calcularImpostos() {
		List<Contrato> listaContrato;
		List<ImpostoEmpregado> listaImposto;
		ImpostoEmpregado imposto;
		double salario, inss, irf, total;
		Date lastExec, atualDate = new Date();
		
		
		lastExec = new ImpostoEmpregadoDao().obterUltimoProcessamento();
		
		
		if(atualDate.getDate()==1 && (lastExec==null || (lastExec.getMonth()!=atualDate.getMonth() && lastExec.before(atualDate)))) {
			
			
			
			listaContrato = FactoryDao.createGenericDao(Contrato.class).listarTodos();
			listaImposto = new ArrayList<>();
			
			for (Contrato contrato : listaContrato) {
				salario = contrato.getSalario();
				inss = calcularInss(salario);
				irf = calcularIrf(salario);
				total = inss + irf;
				
				imposto = new ImpostoEmpregado(null, contrato, atualDate, salario, inss, irf, total);
				listaImposto.add(imposto);
			}
			
			for (ImpostoEmpregado impostoEmpregado : listaImposto) {
				FactoryDao.createGenericDao(ImpostoEmpregado.class).inserir(impostoEmpregado);
			}
		}
	}
	public List<ImpostoEmpregado> selecionar(){
		return FactoryDao.createGenericDao(ImpostoEmpregado.class).listarTodos();
	}
	public List<ImpostoEmpregado> selecionar(Integer idEmpregado){
		
		
		Empregado empregado = new Empregado();
		empregado.setId(idEmpregado);
		List<ImpostoEmpregado> retorno;
		
		
		retorno = FactoryDao.createImpostoEmpregadoDao().buscarPorEmpregado(empregado);
		
		
		for (ImpostoEmpregado impostoEmpregado : retorno) {
			impostoEmpregado.setContrato(FactoryDao.createGenericDao(Contrato.class).buscarPorId(impostoEmpregado.getContrato().getIdContrato()));
		}
		
		return retorno;
	}

	
}
