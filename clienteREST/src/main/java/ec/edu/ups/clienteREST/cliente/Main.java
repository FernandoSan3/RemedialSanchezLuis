package ec.edu.ups.clienteREST.cliente;



public class Main {
	public static void main(String args[]) {
		
		ClienteRest vehiculoCli= new ClienteRest();
		
		/*Vehiculo vehiculo = vehiculoCli.getVehiculo("123-ABC");
		System.out.println(vehiculo);
		
		Persona persona = vehiculoCli.getPersona("0105885876");
		System.out.println(persona);

		
		
		System.out.println(vehiculoCli.listarVehiculos("0105885875"));
		*/
		
		//System.out.println(vehiculoCli.listarVehiculos("GUAPAN"));
		
		//System.out.println(vehiculoCli.getCategorias("GUAPAN"));
		
		System.out.println(vehiculoCli.getProducto("TEE"));
		
		/*Producto producto = vehiculoCli.getProducto("Cemento Guapan 15 kg");
		System.out.println(producto.getNombre());
		System.out.println(producto.getPrecio());
		System.out.println(producto.getStock());
		System.out.println(producto.getProveedor().getNombre());
		
		*/
		/*Persona p = new Persona();
		p.setNombre("Marlyn Chacon");
		p.setEdad(23.5);
		p.setCedula("0105885876");
		*/
		//p.setPersonaId(6);
		//p.setFecha("19-12-1995");
		
		//System.out.println( vehiculoCli.crearPersona(p));
	}
}
