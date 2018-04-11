package edu.curso.dao;

import java.util.List;

import edu.curso.entidades.BO;

public interface BODao {
	
	void adicionar(BO b);
	List<BO> pesquisarPorNome(String nome);

}
