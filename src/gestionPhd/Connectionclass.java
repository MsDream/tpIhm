package gestionPhd;
import java.sql.*;

import javax.swing.*;
public class Connectionclass {
	private static Connection c=null;
	
	public static Connection dbConnector(){
		
			try {
		         Class.forName("org.postgresql.Driver");
		         c = DriverManager
		            .getConnection("jdbc:postgresql://localhost:5432/drsGestion",
		            "postgres", "soumia");
		         JOptionPane.showMessageDialog(null,"Connection done successfully");
		         
			
			} catch ( Exception e ) {
	            JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR DE CONNEXION ! ", JOptionPane.ERROR_MESSAGE);
	         }
		
		return c;
		}
		}
