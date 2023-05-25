package Controlador;

import java.util.ArrayList;

import Modelo.AccesoDatos;
import Modelo.Libro;
import Vista.AddLibro;
import Vista.ModificarLibros;
import Vista.PrintLibros;
import Vista.VentanaPrincipal;

public class Controlador {
	private VentanaPrincipal vp;
	private AddLibro al;
	private PrintLibros pl;
	private ModificarLibros ml;

	public void setVentanaPrincipal(VentanaPrincipal vp) {
		this.vp=vp;
	}

	public void setAddLibro(AddLibro al) {
		this.al=al;
		
	}

	public void setPrintLibros(PrintLibros pl) {
		this.pl=pl;
		
	}
	
	public void gestionarEvento(String s) {
		switch(s) {
			case "Añadir libro": 
				//cargar
				vp.cargarPanel(al);
				break;
				
			case "Ver libros": 
				//cargar y limpiar
				vp.cargarPanel(pl);
				pl.limpiarTabla();
				//llenar la tabla
				for(Libro l:AccesoDatos.mostrarDatos()) {
					Object[] datos= {l.getTitulo(), l.getAutor(),l.getEditorial(),l.getTematica(),l.getPrecio()};
					pl.addRow(datos);
				}
				break;
			case "Modificar libros":
				vp.cargarPanel(ml);
				break;
			default: 
				break;
		}
	}

	public void addLibro(String titulo, String autor, String editorial, String tematica, String precio) {
		AccesoDatos.insert(titulo, autor, editorial, tematica, Double.parseDouble(precio));
		
	}

	public void setModificarLibros(ModificarLibros ml) {
		this.ml=ml;		
	}

	public Libro enviarItem(String s) {
		return AccesoDatos.selectById(Integer.parseInt(s));
	}
	
	public void actualizar(Integer id, Libro libro) {
		AccesoDatos.changeDatos(id, libro);
		
	}

	public ArrayList<Libro> selectAll() {
		return AccesoDatos.mostrarDatos();
	}

}
