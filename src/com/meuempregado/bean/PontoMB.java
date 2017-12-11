package com.meuempregado.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.meuempregado.model.Ponto;
import com.meuempregado.service.PontoService;

@ManagedBean(name = "pontoMB")
@SessionScoped
public class PontoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3902671187847866543L;

	private Ponto ponto;
	private List<Ponto> listaPontos;
	private PontoService pService;
	
	@PostConstruct
	private void inicializar() {
		pService = new PontoService();
		listaPontos = pService.listar();
	}

	// INSERIR A PASSAGEM DO EMPREGADO.ID
	public void inserir() {
		this.pService.inserir(3);
		this.ponto = new Ponto();
		listaPontos = pService.listar();
	}

	public List<Ponto> getListaPontos() {
		return listaPontos;
	}

	public void onRowEdit(RowEditEvent event) {
		ponto = new Ponto();
		ponto = (Ponto) event.getObject();
		ponto.setIdFuncionario(3);
		pService.alterar(ponto);
		FacesMessage msg = new FacesMessage("Horario Editado");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edição Cancelada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
