package com.meuempregado.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "tb_ponto")
public class Ponto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPonto;
	private int idFuncionario;
	private String data;
	private String horaEntrada;
	private String horaEntradaAlmoco;
	private String horaSaidaAlmoco;
	private String horaSaida;
	private String horasTrabalhadas;
	

	public String getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(String horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public Ponto() {
		// TODO Auto-generated constructor stub
	}
	
	public Ponto(int idPonto, int idFuncionario, String data, String horaEntrada, String horaEntradaAlmoco,
			String horaSaidaAlmoco, String horaSaida,String horasTrabalhadas) {
		this.idPonto = idPonto;
		this.idFuncionario = idFuncionario;
		this.data = data;
		this.horaEntrada = horaEntrada;
		this.horaEntradaAlmoco = horaEntradaAlmoco;
		this.horaSaidaAlmoco = horaSaidaAlmoco;
		this.horaSaida = horaSaida;
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public int getIdPonto() {
		return idPonto;
	}
	public void setIdPonto(int idPonto) {
		this.idPonto = idPonto;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public String getHoraEntradaAlmoco() {
		return horaEntradaAlmoco;
	}
	public void setHoraEntradaAlmoco(String horaEntradaAlmoco) {
		this.horaEntradaAlmoco = horaEntradaAlmoco;
	}
	public String getHoraSaidaAlmoco() {
		return horaSaidaAlmoco;
	}
	public void setHoraSaidaAlmoco(String horaSaidaAlmoco) {
		this.horaSaidaAlmoco = horaSaidaAlmoco;
	}
	public String getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}
}
