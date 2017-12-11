package com.meuempregado.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_empregado")
public class Empregado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	private Integer id;
	
	private String nomeCompleto;
	private String dataNascimento;
	private String cpf;
	private String rg;
	private String telefoneFixo;
	private String telefoneCelular;
	
	private String cep;
	private String enderecoRua;
	private Integer enderecoNumero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	
	private Boolean ativo; //true-Ativo false-Inativo
	private Boolean sexo; //true-Masculino false-Feminino
	
	private String descricao;/*atributo para realizar a descrição das funções que o empregado podera realizar e experiências
	*profissionais
	**/
	//Construtor vazio
	public Empregado() {
		
	}
	
	//Construtor para alteração de dados. (Para buscar o registro que vai ser alterado, precisa do id do registro)
	public Empregado(Integer id, String nomeCompleto, String dataNascimento, String cpf, String rg, String telefoneFixo,
			String telefoneCelular, String cep, String enderecoRua, Integer enderecoNumero, String complemento,
			String bairro, String cidade, String uf, Boolean ativo, Boolean sexo,String descricao) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.telefoneFixo = telefoneFixo;
		this.telefoneCelular = telefoneCelular;
		this.cep = cep;
		this.enderecoRua = enderecoRua;
		this.enderecoNumero = enderecoNumero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.ativo = ativo;
		this.sexo = sexo;
		this.descricao = descricao;
	}
	
	/*Construtor para inserir novos Empregados. (Não há necessidade de id por parâmetro, pois a função AUTO INCREMENT 
	*do banco de dados seta automaticamente o id do próximo registro)
	**/
	public Empregado(String nomeCompleto, String dataNascimento, String cpf, String rg, String telefoneFixo,
			String telefoneCelular, String cep, String enderecoRua, Integer enderecoNumero, String complemento,
			String bairro, String cidade, String uf, Boolean ativo, Boolean sexo, String descricao) {
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.telefoneFixo = telefoneFixo;
		this.telefoneCelular = telefoneCelular;
		this.cep = cep;
		this.enderecoRua = enderecoRua;
		this.enderecoNumero = enderecoNumero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.ativo = ativo;
		this.sexo = sexo;
		this.descricao = descricao;
	}

	//Método toString
	@Override
	public String toString() {
		return "Empregado [id=" + id + ", nomeCompleto=" + nomeCompleto + ", dataNascimento=" + dataNascimento
				+ ", cpf=" + cpf + ", rg=" + rg + ", telefoneFixo=" + telefoneFixo + ", telefoneCelular="
				+ telefoneCelular + ", cep=" + cep + ", enderecoRua=" + enderecoRua + ", enderecoNumero="
				+ enderecoNumero + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", uf=" + uf + ", ativo=" + ativo + ", sexo=" + sexo
				+ ", descricao="+  descricao + "]\n";
	}
	
	//Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEnderecoRua() {
		return enderecoRua;
	}

	public void setEnderecoRua(String enderecoRua) {
		this.enderecoRua = enderecoRua;
	}

	public Integer getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(Integer enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Boolean getSexo() {
		return sexo;
	}

	public void setSexo(Boolean sexo) {
		this.sexo = sexo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}