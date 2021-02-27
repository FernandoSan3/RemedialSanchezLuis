package ec.edu.ups.libreria.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="Libro", schema="public")
public class Libro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_libro")
	private int id_libro;
	
	@Column(name="nombre")
	private String nombre;

	@Column(name="stock")
	private int stock;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_categoria")
	private Categoria categoria;

	
	@OneToMany(mappedBy="libro")
	private List<Autor> listaFacturas;



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



	public List<Autor> getListaFacturas() {
		return listaFacturas;
	}



	public void setListaFacturas(List<Autor> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}
	
	
	
	
	
}
