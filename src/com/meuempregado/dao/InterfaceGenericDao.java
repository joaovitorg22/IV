package com.meuempregado.dao;

import java.util.List;

public interface InterfaceGenericDao<E>{
	
	void inserir(E entity);
	void alterar(E entity);
	void excluir(Integer id);
	List<E> listarTodos();
	List<E> listarTodos(Class<E> c,String where, Object... args);
	E buscarPorId(Integer id);
	Integer contarTodos();
}