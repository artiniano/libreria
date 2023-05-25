package Vista;

import javax.swing.JPanel;

import Controlador.Controlador;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddLibro extends JPanel {

	private Controlador c;
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textEditorial;
	private JTextField textTematica;
	private JTextField textPrecio;
	
	public AddLibro() {
		setLayout(new MigLayout("", "[][][][][][grow]", "[][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Título: ");
		add(lblNewLabel, "cell 3 2");
		
		textTitulo = new JTextField();
		add(textTitulo, "cell 5 2,growx");
		textTitulo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Autor: ");
		add(lblNewLabel_1, "cell 3 4");
		
		textAutor = new JTextField();
		add(textAutor, "cell 5 4,growx");
		textAutor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Editorial: ");
		add(lblNewLabel_2, "cell 3 6");
		
		textEditorial = new JTextField();
		add(textEditorial, "cell 5 6,growx");
		textEditorial.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Temática: ");
		add(lblNewLabel_3, "cell 3 8");
		
		textTematica = new JTextField();
		add(textTematica, "cell 5 8,growx");
		textTematica.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Precio: ");
		add(lblNewLabel_4, "cell 3 10");
		
		textPrecio = new JTextField();
		add(textPrecio, "cell 5 10,growx");
		textPrecio.setColumns(10);
		
		JButton btnAdd = new JButton("Añadir");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textTitulo.getText().equals("") ||textAutor.getText().equals("")|| textEditorial.getText().equals("") 
						|| textTematica.getText().equals("")||textPrecio.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Faltan campos", "Error", 2);
					limpiarEt();
				}
				else{
					c.addLibro(textTitulo.getText(), textAutor.getText(), textEditorial.getText(), textTematica.getText(), textPrecio.getText());
					JOptionPane.showMessageDialog(null, "Libro añadido con éxito", "Éxito", 1);
					limpiarEt();
				}
			}
		});
		add(btnAdd, "cell 3 13");

	}

	protected void limpiarEt() {
		textTitulo.setText("");
		textAutor.setText("");
		textEditorial.setText("");
		textTematica.setText("");
		textPrecio.setText("");
		
	}

	public void setControlador(Controlador c) {
		this.c=c;
		
	}

}
