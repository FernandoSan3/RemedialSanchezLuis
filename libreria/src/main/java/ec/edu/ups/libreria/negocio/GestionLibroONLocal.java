package ec.edu.ups.libreria.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.libreria.modelo.Autor;
import ec.edu.ups.libreria.modelo.Categoria;
import ec.edu.ups.libreria.modelo.Libro;

@Local
public interface GestionLibroONLocal {

	public boolean ingresarLibro(Libro libro);
	public int idLibro() throws SQLException ;
	public Libro buscarLibro(String nombre) throws SQLException ;
	public List<Libro> getListLibro() ;
	public List<Autor> getListAutor();
	public List<Categoria> getListCategoria();
}
