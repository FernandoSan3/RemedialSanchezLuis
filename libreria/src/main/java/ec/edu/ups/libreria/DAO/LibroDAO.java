package ec.edu.ups.libreria.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.libreria.modelo.Libro;

@Stateless
public class LibroDAO {

	@Inject
	private EntityManager em;

	@Inject
	private Connection con;
	
	@Inject
	private AutorDAO daoAutor;
	
	@Inject
	private CategoriaDAO daoCategoria;
	
	public boolean insertLibro(Libro libro) {
		em.persist(libro);
		return true;
	}
	
	public Libro readLibro(int id_libro) {
		Libro libro = em.find(Libro.class, id_libro);
		return libro;
	}
	
	public boolean updateLibro(Libro libro) throws SQLException {
		em.merge(libro);
		return true;
	}

	public boolean deleteLibro(int id_libro) throws SQLException {
		em.remove(em.find(Libro.class, id_libro));
		return true;
	}
	

	public int contarLibro() throws SQLException {
		int s;
		String sql = "SELECT MAX (id_libro) FROM Libro";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet res = ps.executeQuery();
		res.next();
		s = res.getInt(1) + 1;
		ps.execute();
		ps.close();
		return s;
	}
	
	public Libro buscarProducto(String nombre_producto) throws SQLException {
		Libro libro = new Libro();
		String sql = "SELECT * FROM Libro c WHERE  c.nombre=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, nombre_producto);
		ResultSet res = ps.executeQuery();
		res.next();
		libro.setId_libro(res.getInt("id_libro"));
		libro.setNombre(res.getString("nombre"));
		libro.setStock(res.getInt("stock"));
		libro.setCategoria(daoCategoria.readCategoria(res.getInt("id_categoria")));
		ps.execute();
		ps.close();
		return libro;
	}
	
	public List<Libro> getListLibro() {
		String jpdl = "SELECT v FROM Libro v ";
		
		Query q = em.createQuery(jpdl, Libro.class);
		
		return (List<Libro>) q.getResultList();
	}
	
	

}
