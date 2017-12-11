package com.meuempregado.model;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "tb_empregador")
public class EmpregadorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_empregador;
	
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "rg")
	private String rg;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "orgao_emissor")
	private String orgao_emissor;
	
	@Column(name = "telefone_celular")
	private String telefone_celular;
	
	@Column(name = "telefone_fixo")
	private String telefone_fixo;
	
	@Column(name = "data_de_nascimento")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date  data;
	
	@Column(name = "sexo")
	private boolean sexo;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "senha")
	private String senha;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empregador")
	private List<Contrato> listImpostoEmpregado;
	
	
	public EmpregadorEntity() {
		
	}
	public EmpregadorEntity(Long id_empregador, String nome, String rg, String cpf, String orgao_emissor,
			String telefone_celular, String telefone_fixo, Date data, boolean sexo, String email, String senha) {
		
		this.id_empregador = id_empregador;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.orgao_emissor = orgao_emissor;
		this.telefone_celular = telefone_celular;
		this.telefone_fixo = telefone_fixo;
		this.data = data;
		this.sexo = sexo;
		this.email = email;
		this.senha = senha;
		
	}

	
	public EmpregadorEntity(long long1, String string, String string2, String string3, String string4, String string5,
			String string6, Date date, boolean boolean1, String string7) {
		// TODO Auto-generated constructor stub
	}


	public Long getId_empregador() {
		return id_empregador;
	}
	public void setId_empregador(Long id_empregador) {
		this.id_empregador = id_empregador;
	}
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}

	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	public String getOrgao_emissor() {
		return orgao_emissor;
	}
	public void setOrgao_emissor(String orgao_emissor) {
		this.orgao_emissor = orgao_emissor;
	}

	
	public String getTelefone_celular() {
		return telefone_celular;
	}
	public void setTelefone_celular(String telefone_celular) {
		this.telefone_celular = telefone_celular;
	}

	
	public String getTelefone_fixo() {
		return telefone_fixo;
	}
	public void setTelefone_fixo(String telefone_fixo) {
		this.telefone_fixo = telefone_fixo;
	}

	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	
	public boolean isSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	

}