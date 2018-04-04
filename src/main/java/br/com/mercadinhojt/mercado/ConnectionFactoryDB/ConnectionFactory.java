package br.com.mercadinhojt.mercado.ConnectionFactoryDB;

import java.sql.*;

public class ConnectionFactory {
	
	private static final String URL = "jdbc:sqlserver://localhost:1433;"+"databaseName=MEJT0000;";
	private static final String USUARIO = "DBO04021993";
	private static final String PASSWORD = "l@y$om!";
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	public static Connection getConnection() throws SQLException{
		try{
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL,USUARIO,PASSWORD);
			return con;			
		}catch(ClassNotFoundException e){
			throw new SQLException(e.getMessage());
		}		
	}	
}
