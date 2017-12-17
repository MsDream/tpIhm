package gestionPhd;
import java.sql.*;

import javax.swing.*;


public class ConnectionToDB {
	public static void main( String args[] ) {
	      Connection c = null;
	      Statement stmt = null;
	      String sql;
	      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/drsGestion",
            "postgres", "soumia");
         JOptionPane.showMessageDialog(null,"Connection done successfully");
         
         
       c.setAutoCommit(false);
         /*stmt = c.createStatement();
 		String sql1 = "CREATE TABLE Faculte"+"(facNom name PRIMARY KEY NOT NULL," + "Chef name)";
 		  stmt.executeUpdate(sql1);*/
 	        
 		 
 		 /*stmt = c.createStatement();
 		String sql1 = "CREATE TABLE specialite"+"(spcnom name NOT NULL," + "deptname name," +
 		" CONSTRAINT specialite_pkey PRIMARY KEY (spcnom)," +
 		"CONSTRAINT deptname FOREIGN KEY (deptname)REFERENCES Faculte(facNom) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE)";
 		  stmt.executeUpdate(sql1);*/
 		  
 		  
 		    /*   stmt = c.createStatement();
 		         String sql1 = "CREATE TABLE Examen " +
 		            "(examennom name NOT NULL," +
 		            " coefficient integer NOT NULL, " +
 		            " spcnom name NOT NULL, " +
 		            " moyenG   REAL, " +
 		            "CONSTRAINT Examen_pkey PRIMARY KEY (examennom)," +
 		"CONSTRAINT Examen_spcnom_fkey FOREIGN KEY (spcnom) REFERENCES specialite (spcnom) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE)";
 		         stmt.executeUpdate(sql1);*/
         
      /*  stmt = c.createStatement();
	         String sql1 = "CREATE TABLE Condidat " +
	            "(code SERIAL PRIMARY KEY ," +
	            " Nom name NOT NULL, " +
	            " Prenom name NOT NULL, " +
	            "Date_Naissance date," +
	            "Universite text ," +
	            "spécialite name," +
	          
	            "CONSTRAINT Condidat_spécialite_fkey FOREIGN KEY (spécialite) REFERENCES specialite (spcnom) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE)";
	stmt.executeUpdate(sql1);*/
         
       /*  stmt = c.createStatement();
         String sql1 = "CREATE TABLE Note " +
            "(correction1 real  DEFAULT 00.0 ," +
            " correction2 real DEFAULT 00.0, " +
            " correction3 real  DEFAULT 00.0 ," +
            " moyen real ," +
            "examennom name NOT NULL," +
            "code SERIAL," +
            "CONSTRAINT Note_pkey PRIMARY KEY (code, examennom),"+
            "CONSTRAINT Note_examennom_fkey FOREIGN KEY (examennom) REFERENCES Examen  (examennom) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE,"+
            "CONSTRAINT Note_code_fkey FOREIGN KEY (code) REFERENCES Condidat (code) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE)";
         	stmt.executeUpdate(sql1);*/
 		  
    /*     stmt = c.createStatement();
         String sql = "CREATE TABLE COMPANY " +
            "(ID INT PRIMARY KEY     NOT NULL," +
            " NAME           TEXT    NOT NULL, " +
            " AGE            INT     NOT NULL, " +
            " ADDRESS        CHAR(50), " +
            " SALARY         REAL)";
         stmt.executeUpdate(sql);*/
         /*stmt = c.createStatement(); */
            /*sql="INSERT INTO Faculte(facNom,Chef )"
            		+ "VALUES ('sciences','Med');";
            stmt.executeUpdate(sql);
            sql="INSERT INTO Faculte(facNom,Chef )"
            		+ "VALUES ('droit','ali lois');";
            stmt.executeUpdate(sql);
            sql="INSERT INTO Faculte(facNom,Chef )"
            		+ "VALUES ('gestion','med bnq');";
            stmt.executeUpdate(sql);
            sql="INSERT INTO Faculte(facNom,Chef )"
            		+ "VALUES ('sociologie','omar philo');";
            stmt.executeUpdate(sql);   
            sql="INSERT INTO Faculte(facNom,Chef )"
            		+ "VALUES ('technologie','mohamed ali');";
            stmt.executeUpdate(sql);*/
           /* 
            sql="INSERT INTO specialite(spcnom ,deptname)"
            		+ "VALUES ('SID','sciences');";
            stmt.executeUpdate(sql);
            sql="INSERT INTO specialite(spcnom ,deptname)"
            		+ "VALUES ('RES','sciences');";
            stmt.executeUpdate(sql);
            sql="INSERT INTO specialite(spcnom ,deptname)"
            		+ "VALUES ('Math','sciences');";
            stmt.executeUpdate(sql);
            sql="INSERT INTO specialite(spcnom ,deptname)"
            		+ "VALUES ('Management','gestion');";
            stmt.executeUpdate(sql);
            sql="INSERT INTO specialite(spcnom ,deptname)"
            		+ "VALUES ('Relations internationales','droit');";
            stmt.executeUpdate(sql);
            sql="INSERT INTO specialite(spcnom ,deptname)"
            		+ "VALUES ('Philosophie','sociologie');";
            stmt.executeUpdate(sql);
            sql="INSERT INTO specialite(spcnom ,deptname)"
            		+ "VALUES ('Electronique','sociologie');";
            stmt.executeUpdate(sql);
            */
           /* stmt = c.createStatement();
         	String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                 + "VALUES (44, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
              stmt.executeUpdate(sql);*/
            
            
           /* sql = "INSERT INTO Examen (examennom,coefficient ,spcnom, moyenG) "
                    + "VALUES ('AlgoSI',2,'SID',0.0);";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Examen (examennom,coefficient ,spcnom, moyenG) "
                    + "VALUES ('AlgoRes',2,'RES',0.0);";
            stmt.executeUpdate(sql);*/
           /* sql = "INSERT INTO Examen (examennom,coefficient ,spcnom, moyenG) "
                    + "VALUES ('SI',4,'SID',0.0);";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Examen (examennom,coefficient ,spcnom, moyenG) "
                    + "VALUES ('Res',4,'RES',0.0);";
            stmt.executeUpdate(sql);*/
           /* sql = "INSERT INTO Examen (examennom,coefficient ,spcnom, moyenG) "
                    + "VALUES ('Math1',2,'Math',0.0);";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Examen (examennom,coefficient ,spcnom, moyenG) "
                    + "VALUES ('Math2',4,'Math',0.0);";
            stmt.executeUpdate(sql);*/
           
            /* ResultSet rs = stmt.executeQuery( "SELECT * FROM Faculte;" );
            while ( rs.next() ) {
               String  facNom = rs.getString("facNom");
               String  Chef = rs.getString("Chef");
               System.out.println( "Faculte : = " + facNom );
               System.out.println( "Chef : = " + Chef );
               System.out.println();
            }*/
          /* sql = "INSERT INTO Condidat (Nom ,Prenom,Date_Naissance,Universite,spécialite)"
                    + "VALUES ('Bendine','Samia','21/4/1996','uatl','SID');";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Condidat;" );
	         while ( rs.next() ) {
	            int id = rs.getInt("code");
	            String  nom = rs.getString("nom");
	            String  prenom = rs.getString("prenom");
	            Date  dn = rs.getDate("date_naissance");
	           
	            System.out.println( "Code= " + id );
	            System.out.println( "nom = " + nom );
	            System.out.println( "prenom = " + prenom );
	            System.out.println( "Date De Naissance = " + dn );
	            System.out.println();
	         }
            rs.close();*/
            stmt.close();
            c.close();
         } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
         }
         System.out.println("Operation done successfully");
      }
   }