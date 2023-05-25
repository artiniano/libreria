package Modelo;

public class Libro {
	private String titulo;
	private String autor;
	private String editorial;
	private String tematica;
	private Double precio;
	
	public Libro(String titulo, String autor, String editorial, String tematica, Double precio) {
		this.titulo=titulo;
		this.autor=autor;
		this.editorial=editorial;
		this.tematica=tematica;
		this.precio=precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", tematica=" + tematica
				+ ", precio=" + precio + "]";
	}

}
