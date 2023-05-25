package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public class VentanaPrincipal extends JFrame {
	private Controlador c;
	private JScrollPane sp;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 455);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem menuPrintLibros = new JMenuItem("Ver Libros");
		menuPrintLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.gestionarEvento("Ver libros");
			}
		});
		
		JMenuItem menuModificarLibros = new JMenuItem("Modificar Libros");
		menuModificarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.gestionarEvento("Modificar libros");
			}
		});
		menuBar.add(menuModificarLibros);
		menuBar.add(menuPrintLibros);
		
		JMenuItem menuAddLibro = new JMenuItem("Añadir Libro");
		menuAddLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.gestionarEvento("Añadir libro");
			}
		});
		menuBar.add(menuAddLibro);
		
		sp = new JScrollPane();
		getContentPane().add(sp, BorderLayout.CENTER);
	}

	public void setControlador(Controlador c) {
		this.c=c;
		
	}

	public void cargarPanel(JPanel jp) {
		sp.setViewportView(jp);
	}

}
