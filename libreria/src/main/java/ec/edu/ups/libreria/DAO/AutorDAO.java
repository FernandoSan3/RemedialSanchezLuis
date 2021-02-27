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

import ec.edu.ups.libreria.modelo.Autor;
import ec.edu.ups.libreria.modelo.Categoria;

@Stateless
public class AutorDAO {

	@Inject
	private EntityManager em;

	@Inject
	private Connection con;
	
	@Inject
	private LibroDAO daolibro;
	
	
	public boolean insertautor(Autor autor) {
		em.persist(autor);
		return true;
	}
	
	public Autor readCategoria(int id_autor) {
		Autor autor = em.find(Autor.class, id_autor);
		return autor;
	}


	public Autor buscarAutor(String nombre) throws SQLException {
		Autor categoria = new Autor();
		String sql = "SELECT * FROM Autor c WHERE  c.nombre=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, nombre);
		ResultSet res = ps.executeQuery();
		res.next();
		categoria.setId_autor(res.getInt("id_autor"));
		categoria.setNombre(res.getString("nombre"));
		categoria.setLibros(daolibro.readLibro(res.getInt("id_libro")));
		ps.execute();
		ps.close();
		return categoria;
	}
	
	public List<Autor> getListAutor() {
		String jpdl = "SELECT v FROM Autor v ";
		
		Query q = em.createQuery(jpdl, Categoria.class);
		
		return (List<Autor>) q.getResultList();
	}
}


