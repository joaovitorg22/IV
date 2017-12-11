package com.meuempregado.dao;

import java.util.List;

import com.meuempregado.model.Empregado;
import com.meuempregado.model.ImpostoEmpregado;

public interface InterfaceImpostoEmpregadoDao {

	public List<ImpostoEmpregado> buscarPorEmpregado(Empregado empregado);
	
}
