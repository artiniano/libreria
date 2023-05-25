package Vista;

import javax.swing.JPanel;

import Controlador.Controlador;
import Modelo.AccesoDatos;
import Modelo.Libro;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ModificarLibros extends JPanel {
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textEditorial;
	private JTextField textTematica;
	private JTextField textPrecio;
	private JTable table;
	private DefaultTableModel modelo;
	private Controlador c;
	private JComboBox<String> comboBox;
	public ModificarLibros() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 157, 213, 208);
		add(panel);
		panel.setLayout(new MigLayout("", "[][][grow]", "[][][][][][][][]"));
		
		JLabel lblTtulo = new JLabel("Título:");
		panel.add(lblTtulo, "cell 0 1");
		
		textTitulo = new JTextField();
		panel.add(textTitulo, "cell 2 1,growx");
		textTitulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Autor: ");
		panel.add(lblNewLabel_2, "cell 0 2");
		
		textAutor = new JTextField();
		panel.add(textAutor, "cell 2 2,growx");
		textAutor.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Editorial: ");
		panel.add(lblNewLabel_1, "cell 0 3");
		
		textEditorial = new JTextField();
		panel.add(textEditorial, "cell 2 3,growx");
		textEditorial.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Temática:");
		panel.add(lblNewLabel_3, "cell 0 4");
		
		textTematica = new JTextField();
		panel.add(textTematica, "cell 2 4,growx");
		textTematica.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Precio:");
		panel.add(lblNewLabel_4, "cell 0 5");
		
		textPrecio = new JTextField();
		panel.add(textPrecio, "cell 2 5,growx");
		textPrecio.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Modificar libro");
		lblNewLabel.setBounds(40, 60, 177, 15);
		add(lblNewLabel);
		
		//los comboBox se tendrían que declarar como JComboBox<String> o el tipo de dato que almacene, pero también deja JComboBox 
		comboBox = new JComboBox<>();
		fillComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st = (String) comboBox.getSelectedItem();
				if(st.equals("Libros")) {
					ArrayList<Libro> lista = c.selectAll();
					printLibro(lista);
				}
				else{
					Libro l = c.enviarItem(st);
					printLibro(l);
				}
			}
		});
		comboBox.setBounds(159, 55, 94, 24);
		add(comboBox);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo=c.enviarItem(comboBox.getSelectedItem()+"").getTitulo();
				String autor= c.enviarItem(comboBox.getSelectedItem()+"").getAutor();
				String editorial=c.enviarItem(comboBox.getSelectedItem()+"").getEditorial();
				String tematica=c.enviarItem(comboBox.getSelectedItem()+"").getTematica();
				Double precio = c.enviarItem(comboBox.getSelectedItem()+"").getPrecio();
				Integer id=Integer.parseInt(comboBox.getSelectedItem()+"");
				if(!textTitulo.getText().equals("")) titulo = textTitulo.getText();
				if(!textAutor.getText().equals("")) autor = textAutor.getText();
				if(!textEditorial.getText().equals("")) editorial = textEditorial.getText();
				if(!textTematica.getText().equals("")) tematica = textTematica.getText();
				if(!textPrecio.getText().equals("")) precio = Double.parseDouble(textPrecio.getText());
				c.actualizar(id, new Libro(titulo,autor,editorial,tematica,precio));
			}
		});
		panel.add(btnActualizar, "cell 0 7");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(300, 90, 306, 279);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultTableModel(0,5);
		String[] titulos = {"Título", "Autor", "Editorial", "Temática", "Precio" };
		modelo.setColumnIdentifiers(titulos);
		table = new JTable(modelo);
		scrollPane.setViewportView(table);

	}
	
	public void fillComboBox() {
		comboBox.removeAllItems();
		comboBox.addItem("Libros");
		for(Integer i: AccesoDatos.mostrarId()) {
			comboBox.addItem(i+"");
		}
		
	}

	public void limpiarTabla() {
		int a = modelo.getRowCount()-1;
		if(a!=-1) {
			for(int i=a;i>=0;i--) {
				modelo.removeRow(i);
			}
		}
	}
	public void addRow(Object[] datos) {
		modelo.addRow(datos);
	}

	public void setControlador(Controlador c) {
		this.c=c;
		
	}

	public void printLibro(Libro l) {
		limpiarTabla();
		Object[]datos= {l.getTitulo(),l.getAutor(),l.getEditorial(),l.getTematica(),l.getPrecio()};
		addRow(datos);
		
	}
	
	public void printLibro(ArrayList<Libro> lista) {
		limpiarTabla();
		for(Libro l:lista) {
			Object[]datos= {l.getTitulo(),l.getAutor(),l.getEditorial(),l.getTematica(),l.getPrecio()};
			addRow(datos);
		}
	}
}
