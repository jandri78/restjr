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
	
		String URL = "jdbc:mysql://10.170.0.231/cdr_sansay";
	
		List<VOCDR> CDRlist = new ArrayList<VOCDR>();
		
		try {
			System.out.println("intentando conectar");
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(URL, "consulta2", "Qu3ry");
			System.out.println("conectado OK "+con);
			
			PreparedStatement consulta = con.prepareStatement("SELECT * FROM cdr_sansay.cdr_g4c limit 200;");
			
			ResultSet resultado  = consulta.executeQuery();
			
			while(resultado.next()){
				
				VOCDR cdr = new VOCDR();
				
				cdr.setServer(resultado.getString(7));
				cdr.setNumero(resultado.getString(8));
				cdr.setDuracion(resultado.getString(21));
				cdr.setRing(resultado.getString(22));
				
				CDRlist.add(cdr);
				
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
		
		String URL = "jdbc:mysql://10.170.0.231/cdr_sansay";
	
		
		try {
			System.out.println("intentando conectar");
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(URL, "consulta2", "Qu3ry");
			System.out.println("conectado OK "+con);
			
			PreparedStatement consulta = con.prepareStatement("SELECT * FROM cdr_sansay.cdr_g4c limit 200;");
			
			ResultSet resultado  = consulta.executeQuery();
			
			while(resultado.next()){
				
				System.out.println("server "+resultado.getString(7)+ "\t Numero "+resultado.getString(8)+"\t duracion "+resultado.getString(21)+"\t ring "+resultado.getString(22));
			   
			}
			
		} catch (SQLException e) {
			System.out.println("Error MYSQL");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			System.out.println("ERRROR 404");
		}
		
	}
}



