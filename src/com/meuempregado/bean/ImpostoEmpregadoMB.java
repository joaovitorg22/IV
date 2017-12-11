package com.meuempregado.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.ImpostoEmpregado;
import com.meuempregado.service.ImpostoEmpregadoService;

@ManagedBean(name = "impostoEmpregadoMB")
@SessionScoped
public class ImpostoEmpregadoMB implements Serializable{
	private static final long serialVersionUID = -8601847806759673229L;
	
	private Integer idEmpregado = 2;
	private ImpostoEmpregadoService service = new ImpostoEmpregadoService();
	
	public List<ImpostoEmpregado> listAll() {
		List<ImpostoEmpregado> retorno = service.selecionar(idEmpregado);
		
		return retorno;
	}

}
