package com.meuempregado.dao;


public class FactoryDao {
		
	public static <E> InterfaceGenericDao<E> createGenericDao(Class<E> entityClass){
		return new GenericDao<E>(entityClass);
	}
	
	public static InterfaceImpostoEmpregadoDao createImpostoEmpregadoDao(){
		return new ImpostoEmpregadoDao();
	}
}