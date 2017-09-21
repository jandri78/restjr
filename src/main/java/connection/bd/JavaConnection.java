package connection.bd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javarevolutions.ws.rest.vo.VOCDR;



public class JavaConnection {

	
	public List<VOCDR> conectadb(){
	
		String URL = "jdbc:mysql://localhost/platziprofesores";
	
		List<VOCDR> CDRlist = new ArrayList<VOCDR>();
		
		try {
			System.out.println("intentando conectar");
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(URL, "platziprofesores", "platziprofesores");
			System.out.println("conectado OK "+con);
			
			PreparedStatement consulta = con.prepareStatement("SELECT * FROM teacher");
			
			ResultSet resultado  = consulta.executeQuery();
			
			while(resultado.next()){
				
				VOCDR cdr = new VOCDR();
				
				cdr.setServer(resultado.getString(1));
				cdr.setNumero(resultado.getString(2));
				cdr.setDuracion(resultado.getString(1));
				cdr.setRing(resultado.getString(2));
				
				CDRlist.add(cdr);
				//guardado en lista
			    //System.out.println("server "+resultado.getString(7)+ "\t Numero "+resultado.getString(8)+"\t duracion "+resultado.getString(21)+"\t ring "+resultado.getString(22));
			   }
			
		} catch (SQLException e) {
			System.out.println("Error MYSQL");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			System.out.println("ERRROR 404");
		}
		
		
		return CDRlist;
	}
	
	public  void conectadb2(){
		
		String URL = "jdbc:mysql://localhost/platziprofesores";
	
		
		try {
			System.out.println("intentando conectar");
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(URL, "platziprofesores", "platziprofesores");
			System.out.println("conectado OK "+con);
			
			PreparedStatement consulta = con.prepareStatement("SELECT * FROM teacher");
			
			ResultSet resultado  = consulta.executeQuery();
			
			while(resultado.next()){
				
				System.out.println("server "+resultado.getString(1)+ "\t Numero "+resultado.getString(2)+"\t duracion "+resultado.getString(1)+"\t ring "+resultado.getString(2));
			   
			}
			
		} catch (SQLException e) {
			System.out.println("Error MYSQL");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			System.out.println("ERRROR 404");
			System.out.println(e.getMessage());
		}
		
	}
}



