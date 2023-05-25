package Vista;

import javax.swing.JPanel;

import Controlador.Controlador;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class PrintLibros extends JPanel {

	private Controlador c;
	private DefaultTableModel modelo;
	private JTable table;
	
	public PrintLibros() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		
		modelo= new DefaultTableModel(0,5);
		String[] titulos= {"Titulo", "Autor", "Editorial", "Temática", "Precio"};
		modelo.setColumnIdentifiers(titulos);
		
		table = new JTable(modelo);
		scrollPane.setViewportView(table);

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
}
