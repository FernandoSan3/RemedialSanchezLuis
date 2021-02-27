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

import ec.edu.ups.libreria.modelo.Categoria;

@Stateless
public class CategoriaDAO {

	@Inject
	private EntityManager em;

	@Inject
	private Connection con;
	
	

	public boolean insertCategoria(Categoria categoria) {
		em.persist(categoria);
		return true;
	}
	
	public Categoria readCategoria(int id_categoria) {
		Categoria categoria = em.find(Categoria.class, id_categoria);
		return categoria;
	}


	public Categoria buscarCategoria(String nombre) throws SQLException {
		Categoria categoria = new Categoria();
		String sql = "SELECT * FROM Categoria c WHERE  c.nombre=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, nombre);
		ResultSet res = ps.executeQuery();
		res.next();
		categoria.setId_categoria(res.getInt("id_categoria"));
		categoria.setNombre(res.getString("nombre"));
		ps.execute();
		ps.close();
		return categoria;
	}
	
	public List<Categoria> getListCategoria() {
		String jpdl = "SELECT v FROM Categoria v ";
		
		Query q = em.createQuery(jpdl, Categoria.class);
		
		return (List<Categoria>) q.getResultList();
	}
	
	
}
