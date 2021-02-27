package ec.edu.ups.libreria.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.libreria.DAO.AutorDAO;
import ec.edu.ups.libreria.DAO.CategoriaDAO;
import ec.edu.ups.libreria.DAO.LibroDAO;
import ec.edu.ups.libreria.modelo.Autor;
import ec.edu.ups.libreria.modelo.Categoria;
import ec.edu.ups.libreria.modelo.Libro;

@Stateless
public class GestionLibroON implements GestionLibroONLocal {

	@Inject
	private CategoriaDAO daocategoria;
	
	
	@Inject 
	private AutorDAO daoAutor;
	
	@Inject 
	private LibroDAO daoLibro;
	
	private Libro libro = new Libro();
	

	public boolean ingresarLibro(Libro libro) {
		daoLibro.insertLibro(libro);
		return true;
	}
	
	public int idLibro() throws SQLException {
		int d = daoLibro.contarLibro();
		return d;
	}
	
	public Libro buscarLibro(String nombre) throws SQLException {
		libro = daoLibro.buscarProducto(nombre);
		return libro;
	}
	public List<Libro> getListLibro() {

		try {
			List<Libro> libro = daoLibro.getListLibro();
			System.out.println("Libro "+ libro.size());
			return libro;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ArrayList<Libro>();
		}

	}
	
	public List<Autor> getListAutor() {

		try {
			List<Autor> autor = daoAutor.getListAutor();
			System.out.println("Autor "+ autor.size());
			return autor;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ArrayList<Autor>();
		}

	}
	
	public List<Categoria> getListCategoria() {

		try {
			List<Categoria> categoria = daocategoria.getListCategoria();
			System.out.println("Autor "+ categoria.size());
			return categoria;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ArrayList<Categoria>();
		}

	}
}
