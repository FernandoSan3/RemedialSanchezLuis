package ec.edu.ups.clienteREST.modelo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {


	private int id_libro;
	
	private String nombre;

	private int stock;
	
	private Categoria categoria;


	public int getId_libro() {
		return id_libro;
	}



	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}



	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	@Override
	public String toString() {
		return "Libro [id_libro=" + id_libro + ", nombre=" + nombre + ", stock=" + stock + ", categoria=" + categoria
				+ "]";
	}
	
}
