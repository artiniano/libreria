package Main;

import Controlador.Controlador;
import Modelo.AccesoDatos;
import Vista.AddLibro;
import Vista.ModificarLibros;
import Vista.PrintLibros;
import Vista.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		generarBaseDatos();
		
		VentanaPrincipal vp = new VentanaPrincipal();
		Controlador c = new Controlador();
		AddLibro al = new AddLibro();
		PrintLibros pl = new PrintLibros();
		ModificarLibros ml = new ModificarLibros();
		
		vp.setVisible(true);
		
		c.setVentanaPrincipal(vp);
		c.setAddLibro(al);
		c.setPrintLibros(pl);
		c.setModificarLibros(ml);
		
		vp.setControlador(c);
		al.setControlador(c);
		pl.setControlador(c);
		ml.setControlador(c);
	}

	private static void generarBaseDatos() {
		AccesoDatos.creaTabla();
		//AccesoDatos.insert("Fundamentos álgebra", "Felipe Zaldívar", "FCE", "Matemáticas", 19.90);
	}

}
