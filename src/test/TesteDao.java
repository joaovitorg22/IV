package test;

import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.meuempregado.dao.GenericDao;
import com.meuempregado.model.Contrato;
import com.meuempregado.model.Empregado;
import com.meuempregado.model.EmpregadorEntity;
import com.meuempregado.model.ImpostoEmpregado;
import com.meuempregado.service.ImpostoEmpregadoService;

public class TesteDao {
	public void insertEmpregado() {
		
		for(int i = 1; i<20; i++) {
			Empregado empregado = new Empregado();
			empregado.setNomeCompleto("Empregado " + i);
			
			GenericDao<Empregado> g = new GenericDao<>(Empregado.class);
			g.inserir(empregado);
			
		}
		
	}
	public void insertEmpregador() {
		
		for(int i = 1; i<20; i++) {
			EmpregadorEntity empregador = new EmpregadorEntity();
			empregador.setNome("Empregador " + i);
			
			Random rd = new Random();
			
			int num1, num2, num3, num4;
			
			num1 = rd.nextInt(900)+100;
			num2 = rd.nextInt(900)+100;
			num3 = rd.nextInt(900)+100;
			num4 = rd.nextInt(80)+10;
			
			
			
			empregador.setCpf(num1+"."+num2+"."+num3+"-"+num4);
			
			GenericDao<EmpregadorEntity> g = new GenericDao<>(EmpregadorEntity.class);
			g.inserir(empregador);
			
		}
		
	}
	public void insertContrato() {
		for(int i = 1; i<20; i++) {
			Random rd = new Random();
			Double salario = rd.nextInt(2000)+950+rd.nextDouble();
			EmpregadorEntity empregador = new EmpregadorEntity();
			empregador.setId_empregador(new Long(rd.nextInt(19)+20));
			System.out.println(empregador.getId_empregador());
			Empregado empregado = new Empregado();
			empregado.setId(i);
			Contrato contrato = new Contrato(null, empregador, empregado, salario, true);
			
			GenericDao<Contrato> g = new GenericDao<>(Contrato.class);
			g.inserir(contrato);
		}
	}
	public void calcular() {
		ImpostoEmpregadoService imp = new ImpostoEmpregadoService();
		imp.calcularImpostos();
	}
	public void listarImpostos(){
		ImpostoEmpregadoService is = new ImpostoEmpregadoService();
		List<ImpostoEmpregado> lista = is.selecionar(2);
		System.out.println(lista.size());
	}
}
