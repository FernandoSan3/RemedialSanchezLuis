package ec.edu.ups.libreria.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.libreria.modelo.Libro;
import ec.edu.ups.libreria.negocio.GestionLibroONLocal;

@Path("libreria")
public class ClienteServiceRES {
	
	@Inject
	private GestionLibroONLocal on;
	
	
	private Libro libro = new Libro();;


	@GET
	@Produces("application/json")
	@Path("consulta")
	public Libro consulta(@QueryParam ("nombre") String nombre) {
		Mensaje mensaje = new Mensaje();
		Libro libro = null;
		try {
			libro = on.buscarLibro(nombre);
			mensaje.setCode("OK");
			mensaje.setMessage("Eliminado Correctamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mensaje.setCode("Error");
			mensaje.setMessage("Eliminado Incorrectamente");
			
		}
		return libro;
	}
 
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("reservarLibro")
	public Mensaje reservarLibro(Libro libro) {
		Mensaje mensaje = new Mensaje();
		int reserva = 1;
		try {
			
			
			if(libro.getStock() >= 0) {
				libro.setStock(libro.getStock() - reserva);
				
			}else {
				libro.setStock(libro.getStock());
				mensaje.setCode("ERROR");
				mensaje.setMessage("FUERA DE STOCK LIBRO");
				return mensaje;
			}
			System.out.println(libro);
			libro.setNombre(libro.getNombre());
			libro.setId_libro(libro.getId_libro());
			mensaje.setCode("OK");
			mensaje.setMessage("RESERVA CORRECTA ");
			return mensaje;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mensaje.setCode("ERROR");
			mensaje.setMessage(e.getMessage());
			return mensaje;
		}
	}
	
	
	@GET
	@Produces("application/json")
	@Path("getProduct")
	public List<Libro> getProducto(){
		return on.getListLibro();
	}
	

	
}
