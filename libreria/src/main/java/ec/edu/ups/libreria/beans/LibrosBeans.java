package ec.edu.ups.libreria.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;


import ec.edu.ups.libreria.DAO.AutorDAO;
import ec.edu.ups.libreria.DAO.CategoriaDAO;
import ec.edu.ups.libreria.DAO.LibroDAO;
import ec.edu.ups.libreria.core.FacesUtils;
import ec.edu.ups.libreria.modelo.Autor;
import ec.edu.ups.libreria.modelo.Categoria;
import ec.edu.ups.libreria.modelo.Libro;


@ManagedBean
@ViewScoped
public class LibrosBeans {

	private List<Categoria> listaCategoria = new ArrayList<>();
	private List<Autor> listaAutor= new ArrayList<>();
	
	@Inject
	private LibroDAO daoLibro;
	
	@Inject
	private AutorDAO daoAutor;
	
	@Inject
	private CategoriaDAO daoCategoria;
	
	private Libro libro = new Libro();
	private Autor autor = new Autor();
	private Categoria categoia = new Categoria();
	
	@PostConstruct
	public void init() {
		listaCategoria = daoCategoria.getListCategoria();
		listaAutor = daoAutor.getListAutor();
	}
	
	public void crearLibro() throws Exception {
		Categoria categori = null;
		Autor auto = null;
		try {

			if (libro == null) {
				FacesUtils.msgError("Error", "LIBRO NULL");
			}
			libro.setId_libro(daoLibro.contarLibro());
			libro.setNombre(libro.getNombre());
			libro.setStock(libro.getStock());
			
			if(autor.getNombre() == null) {
				FacesUtils.msgError("Error", "SELECCIONE UN AUTOR");
			} else {
				daoLibro.insertLibro(libro);
				auto = daoAutor.buscarAutor(autor.getNombre());
				
				autor.setId_autor(auto.getId_autor());
				autor.setNombre(autor.getNombre());
				autor.setLibros(libro);
				
			}
			
			if(categoia.getNombre() == null) {
				FacesUtils.msgError("Error", "SELECCIONE UNa Categoria");
			} else {
				
			
			
			categori = daoCategoria.buscarCategoria(categoia.getNombre());
			categoia.setId_categoria(categori.getId_categoria());
			categoia.setNombre(categoia.getNombre());
			categoia.setLibros(libro);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	public List<Autor> getListaAutor() {
		return listaAutor;
	}

	public void setListaAutor(List<Autor> listaAutor) {
		this.listaAutor = listaAutor;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Categoria getCategoia() {
		return categoia;
	}

	public void setCategoia(Categoria categoia) {
		this.categoia = categoia;
	}
	
	
	
}
