package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
	private String url = "jdbc:mysql://localhost:3306/cadastrowb";
	private String username = "root";
	private String password = "will";
	private static Connection connection = null;
	private static Conexao instance = null; 
	
	
	private Conexao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver carregado");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver não carregado: " + e.getMessage());
		}
	}  
	
	
	public static Conexao getInstance() {
		if (instance == null) {
			instance = new Conexao();
			System.out.println("Criando instance");
		}
		System.out.println("Retornando instance");
		return instance;
	} 
	
	public Connection getConnection() {
		try {		
			if ((connection == null) || (connection.isClosed())) {
				connection = DriverManager.getConnection(this.url, this.username, this.password);
				System.out.println("Conexao estabelecida");
				return connection;
			}
		} catch (SQLException e) {
			System.out.println("Conexao nao estabelecida: " + e.getMessage());
		}
	
		return connection;
	} 
	
	public void finalize() {
		System.out.println("Destroy");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}