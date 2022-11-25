package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	    private static final String DATABASE="banco_antedegemon";   //declaração de constante(em caixa ALTA)
	    private static final String HOST="localhost:3306";      //HOST == porta
	    private static final String DRIVER="com.mysql.jdbc.Driver";
	    private static final String URL="jdbc:mysql://" +HOST+"/"+DATABASE;
	    private static final String USR="root";
	    private static final String PWD="";
	    
	    public static Connection Conectar(){
	        try{
	            Class.forName(DRIVER);
	            System.out.println("Conectadoooooooo");
	            return DriverManager.getConnection(URL, USR, PWD); //retorna conexao aberta
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println("ERRO: "+ e.getMessage());
	    return null;   //retorna conexao null
	        }
	    
	    }
	    
	    
	    public static void Desconectar (Connection con){      
	        try{
	            if(con != null){
	                con.close();                                //Se conexao tiver aberta, ela é fechada
	                con = null;
	            }
	        }catch (SQLException e) {                           //printa erro
	         System.out.println("ERRO: " + e.getMessage());
	        }
	    }
	}
