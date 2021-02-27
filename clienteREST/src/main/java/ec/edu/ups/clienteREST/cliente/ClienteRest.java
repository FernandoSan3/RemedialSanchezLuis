package ec.edu.ups.clienteREST.cliente;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import ec.edu.ups.clienteREST.modelo.Libro;



@Stateless
public class ClienteRest {

	private String WS_GET_consulta = "http://localhost:8080/libreria/ws/libreria/consulta";
	//http://localhost:8080/libreria/ws/libreria/consulta?nombre=TEE
	private String WS_GET_reserva = "http://localhost:8080/practicaExamen/ws/movimientos/getProducto";
	
	public Libro getProducto(String nombre) {
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(WS_GET_consulta).queryParam("nombre", nombre);

		Libro producto = target.request().get(Libro.class);

		client.close();

		return producto;
	}
	
	public String crearPersona(Libro libro) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(WS_GET_reserva);
		target.request().post(Entity.json(persona), Libro.class);
		return "OK";
	}
}
