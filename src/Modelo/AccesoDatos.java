package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccesoDatos {
	//EN SQLITE DOUBLE ES REAL 
	public static void creaTabla() {
		try(Connection con = DriverManager.getConnection("jdbc:sqlite:mislibros.db")){
			Statement stmt = con.createStatement();
			String creaTabla = "CREATE TABLE IF NOT EXISTS libros(id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, "
					+ "autor TEXT, editorial TEXT, tematica TEXT, precio REAL);";
			String eliminaTabla = "DROP TABLE IF EXISTS libros;";
			//stmt.executeUpdate(eliminaTabla);
			stmt.executeUpdate(creaTabla);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<Libro> mostrarDatos(){
		ArrayList<Libro> listaP = new ArrayList<>();
		try(Connection con = DriverManager.getConnection("jdbc:sqlite:mislibros.db")){
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM libros;");
			
			while(rs.next()) {
				listaP.add(new Libro(rs.getString("titulo"), rs.getString("autor"), rs.getString("editorial"),rs.getString("tematica"),
						rs.getDouble("precio")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listaP;
	}
	
	public static ArrayList<Integer> mostrarId(){
		ArrayList<Integer> listaI = new ArrayList<>();
		try(Connection con = DriverManager.getConnection("jdbc:sqlite:mislibros.db")){
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id FROM libros;");
			while(rs.next()) {
				listaI.add(rs.getInt("id"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listaI;
	}
	
	
	public static void insert(String titulo, String autor, String editorial, String tematica, Double precio) {
		try(Connection con = DriverManager.getConnection("jdbc:sqlite:mislibros.db")){
			String insertaPersona = "INSERT INTO libros(titulo, autor, editorial,tematica,precio) VALUES (?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(insertaPersona);
			stmt.setString(1, titulo);
			stmt.setString(2, autor);
			stmt.setString(3, editorial);
			stmt.setString(4, tematica);
			stmt.setDouble(5, precio);
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void deleteAll() {
		try(Connection con =DriverManager.getConnection("jdbc:sqlite:mislibros.bd")){
			Statement stmt= con.createStatement();
			stmt.executeUpdate("DELETE FROM libros;");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void changeDatos(Integer id, Libro l) {
		try(Connection con = DriverManager.getConnection("jdbc:sqlite:mislibros.db")){
			Statement stmt = con.createStatement();
			stmt.executeUpdate("UPDATE libros SET titulo = '"+l.getTitulo()+"', autor = '"+l.getAutor()
					+"', editorial='"+l.getEditorial()+"', tematica='"+l.getTematica()+"', precio = "+l.getPrecio()+" WHERE id= "+id+";");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Libro> selectByTitle(String titulo) {
		ArrayList <Libro> listaP = new ArrayList<>();
		try(Connection con = DriverManager.getConnection("jdbc:sqlite:mislibros.db")){
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM libros WHERE titulo = '"+titulo+"';");
			
			while(rs.next()) {
				listaP.add(new Libro(rs.getString("titulo"), rs.getString("autor"),rs.getString("editorial"),rs.getString("tematica"),
						rs.getDouble("precio")));
			}
			//listaP.sort((x,y)->x.getNombre().compareTo(y.getNombre()));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listaP;
	}
	
	public static Libro selectById(Integer id){
		Libro l=null;
		try(Connection con = DriverManager.getConnection("jdbc:sqlite:mislibros.db")){
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM libros WHERE id = "+id+";");
			
			while(rs.next()) {
				l= new Libro(rs.getString("titulo"), rs.getString("autor"), rs.getString("editorial"), 
						rs.getString("tematica"), rs.getDouble("precio"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}

}
