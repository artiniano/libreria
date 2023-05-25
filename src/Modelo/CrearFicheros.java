package Modelo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CrearFicheros {
	
	public static void crearTexto(ArrayList<Libro> lista) {
		try(BufferedWriter bw=new BufferedWriter(new FileWriter("personas.txt"))){
			for(Libro l:lista) {
				bw.write(l.getTitulo()+","+l.getAutor()+l.getEditorial()+l.getTematica()+l.getPrecio()+"\n");
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void crearXML(ArrayList<Libro> lista) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		Document doc;
		try {
			db= dbf.newDocumentBuilder();
			doc = db.newDocument();
			Element raiz = doc.createElement("libros");
			doc.appendChild(raiz);
			Element libro, titulo, autor, editorial, tematica;
			Attr edad;
			for(Libro l:lista) {
				libro=doc.createElement("libro");
				
				//añado atributo
				libro.setAttribute("precio", l.getPrecio()+"");
				raiz.appendChild(libro);
				
				
				titulo=doc.createElement("titulo");
				titulo.setTextContent(l.getTitulo());
				libro.appendChild(titulo);
				
				
				autor=doc.createElement("autor");
				autor.setTextContent(l.getAutor());
				libro.appendChild(autor);
				
				editorial=doc.createElement("editorial");
				editorial.setTextContent(l.getEditorial());
				libro.appendChild(editorial);
				
				tematica=doc.createElement("tematica");
				tematica.setTextContent(l.getTematica());
				libro.appendChild(tematica);
			}
			
			//se genera el archivo XML
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result =new StreamResult(new File("libros.xml"));
			t.transform(source, result);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void crearObjectOutput(ArrayList<Libro> lista) {
		try(ObjectOutputStream dout = new ObjectOutputStream(new FileOutputStream("personas.dat"))){
			for(Libro l:lista) {
				dout.writeObject(l);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
