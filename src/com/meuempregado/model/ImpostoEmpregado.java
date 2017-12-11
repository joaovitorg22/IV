package com.meuempregado.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_impostoEmpregado")
public class ImpostoEmpregado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1778530759456031358L;

	@Id
	@Column(name = "idImpostoEmpregado")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idImpostoEmpregado = 0;
	
	@Column(name = "mes")
	@Temporal(TemporalType.DATE)
	private Date mes = null;
	
	@Column(name = "salario")
	private Double salario;
	
	@Column(name = "inss")
	private Double inss;
	
	@Column(name = "irf")
	private Double irf;
	
	@Column(name = "total")
	private Double total;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idContrato")
	private Contrato contrato = new Contrato();
	
	
	
	
	public ImpostoEmpregado() {
	}
	public ImpostoEmpregado(Integer idImpostoEmpregado, Contrato contrato, Date mes, double salario, double inss,
			double irf, double total) {
		super();
		this.idImpostoEmpregado = idImpostoEmpregado;
		this.contrato = contrato;
		this.mes = mes;
		this.salario = salario;
		this.inss = inss;
		this.irf = irf;
		this.total = total;
	}
	
	
	public Integer getIdImpostoEmpregado() {
		return idImpostoEmpregado;
	}
	public void setIdImpostoEmpregado(Integer idImpostoEmpregado) {
		this.idImpostoEmpregado = idImpostoEmpregado;
	}
	public Contrato getContrato() {
		return contrato;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	public Date getMes() {
		return mes;
	}
	public void setMes(Date mes) {
		this.mes = mes;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public double getInss() {
		return inss;
	}
	public void setInss(double inss) {
		this.inss = inss;
	}
	public double getIrf() {
		return irf;
	}
	public void setIrf(double irf) {
		this.irf = irf;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getMesFormated() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
		return sdf.format(this.mes);
	}
	public String getSalarioFormated() {
		DecimalFormat dcm = new DecimalFormat("#0.00");
		return dcm.format(salario);
	}
	public String getInssFormated() {
		DecimalFormat dcm = new DecimalFormat("#0.00");
		return dcm.format(inss);
	}
	public String getIrfFormated() {
		DecimalFormat dcm = new DecimalFormat("#0.00");
		return dcm.format(irf);
	}
	public String getTotalFormated() {
		DecimalFormat dcm = new DecimalFormat("#0.00");
		return dcm.format(total);
	}
	
	
	
	
	
}
