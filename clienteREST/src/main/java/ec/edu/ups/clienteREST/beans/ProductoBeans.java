package ec.edu.ups.clienteREST.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.clienteREST.cliente.ClienteRest;
import ec.edu.ups.clienteREST.modelo.Libro;

@ManagedBean
@ViewScoped
public class ProductoBeans implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Libro libro = new Libro();
	
	
	//private ec.edu.ups.practicaExamenFerreteria.modeloejemplo.Producto  productoServidor = new ec.edu.ups.practicaExamenFerreteria.modeloejemplo.Producto ();
	//@Inject 
	//private VehiculosCli dao;
	/*
	@Inject
	private ClienteSOAPDAO clienteSOAPDAOs;
	*/
	//ClienteSOAPDAO clienteSOAP = new ClienteSOAPDAO();
	
	//clienteSOAP.kd("Cemento Guapan 15 kg");
	
	private ClienteRest cliente= new ClienteRest();
	
	
	public void buscar() {
		Libro per = null;
		//Producto product = null;
		System.out.println(libro.getNombre());
		per = cliente.getProducto(libro.getNombre());
		
		libro.setStock(per.getStock());
	
		//if (product == null) {
			//FacesUtils.msgError("Error", "No se encontro la persona");
			//produc.getNombre()System.out.println("No se encontro la persona");
		//} else {
			//productoServidor = per;
		//}
		 
	}
	
	public void reservar() {
		
	}


	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
	}


	public ClienteRest getCliente() {
		return cliente;
	}


	public void setCliente(ClienteRest cliente) {
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		return "ProductoBeans [libro=" + libro + ", cliente=" + cliente + "]";
	}
	
	
	
	




	
	
	
}
