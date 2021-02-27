package ec.edu.ups.libreria.negocio;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.libreria.DAO.AutorDAO;
import ec.edu.ups.libreria.DAO.CategoriaDAO;
import ec.edu.ups.libreria.DAO.LibroDAO;
import ec.edu.ups.libreria.modelo.Categoria;

@Stateless
public class GestionLibroON implements GestionLibroONLocal {

	@Inject
	private CategoriaDAO daocategoria;
	
	
	@Inject 
	private AutorDAO daoAutor;
	
	@Inject 
	private LibroDAO daoLibro;
	
	private Categoria categoria = new Categoria();
	
}
