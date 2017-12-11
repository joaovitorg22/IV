package com.meuempregado.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_contrato")
public class Contrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idContrato")
	private Integer idContrato;
	
	@Column(name = "salario", columnDefinition="Decimal(10,2) default '0.00'")
	private double salario;
	
	@Column(name = "status")
	private boolean status;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contrato")
	private List<ImpostoEmpregado> impostoEmpregado;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_empregador")
	private EmpregadorEntity empregador;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private Empregado empregado;
	
	public Contrato() {
		
	}
	public Contrato(Integer idContrato, EmpregadorEntity empregador, Empregado empregado, double salario, boolean status) {
		super();
		this.idContrato = idContrato;
		this.empregador = empregador;
		this.empregado = empregado;
		this.salario = salario;
		this.status = status;
	}


	public Integer getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}
	public EmpregadorEntity getEmpregador() {
		return empregador;
	}
	public void setEmpregador(EmpregadorEntity empregador) {
		this.empregador = empregador;
	}
	public Empregado getEmpregado() {
		return empregado;
	}
	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
