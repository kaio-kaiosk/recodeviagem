package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	// Estabelecer a conexão com o BD
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/krturismo";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "kaiosk";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	private Connection conectar() throws ClassNotFoundException {
		Connection con = null;	
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public void inserirCliente(JavaBeans cliente) {
		//Criar um objeto para receber o camando em SQL
		String sql = "INSERT INTO cliente (cpf, nomeCliente, telefone, email, senha) VALUES(?,?,?,?,?);";		
		try {
			//Abrir a conexão com o BD
			Connection con = conectar();
			//Criar um stattement
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, cliente.getCPF());
			stm.setString(2, cliente.getNomeCliente());
			stm.setString(3, cliente.getTelefone());
			stm.setString(4, cliente.getEmail());
			stm.setString(5, cliente.getSenha());
			//Executar a Query
			stm.execute();
			//Fechar a conexão com o BD
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}		
	}
	
    public ArrayList<JavaBeans>	listarClientes() {
    	//Criar a lista de clientes com os dados dos clientes
    	ArrayList<JavaBeans> clientes = new ArrayList<>();
    	
    	//Criar um objeto para receber o camando em SQL
    	String sql = "select * from cliente order by nomeCliente";
    	try {
    		//Abrir a conexão com o BD
    		Connection con = conectar();
    		//Criar o statement
    		PreparedStatement stm = con.prepareStatement(sql);
    		ResultSet result = stm.executeQuery();
    		//Preencher os dados da lista clientes
    		while (result.next()) {
    			String CPF = result.getString(1);
    			String nomeCliente = result.getString(2);
    			String telefone = result.getString(3);
    			String email = result.getString(4);
    			String senha = result.getString(5);

    			clientes.add(new JavaBeans(CPF,nomeCliente,telefone,email,senha));
    		}
    		//Fechar a conexão com o BD
    		con.close();
    		return clientes;
    	} catch (Exception e) {
    		System.out.println(e);
    		return null;
    	}
    	
    }
    
    public void selecionarCliente(JavaBeans cliente) {
    	//Criar um objeto para receber o camando em SQL
    	String sql = "select * from cliente where CPF = ?";
    	
    	try {
    		//Abrir a conexão com o BD
    		Connection con = conectar();
    		//Criar statement
    		PreparedStatement stm = con.prepareStatement(sql);
    		stm.setString(1, cliente.getCPF());
    		//Executar o statement
    		ResultSet result = stm.executeQuery();
    		//Preencher os dados do cliente
    		while (result.next()) {
    			cliente.setCPF(result.getString(1));
    			cliente.setNomeCliente(result.getString(2));
    			cliente.setTelefone(result.getString(3));
    			cliente.setEmail(result.getString(4));
    			cliente.setSenha(result.getString(5));

    		}
    		con.close();
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
    public void alterarCliente(JavaBeans cliente) {
    	//Criar um objeto para receber o camando em SQL
    	String sql = "update cliente set nomeCliente=?, telefone=?, email=?, senha=? where CPF = ?";
    	
    	try {
    		//Abrir a conexão com o BD
    		Connection con = conectar();
    		//Criar statement
    		PreparedStatement stm = con.prepareStatement(sql);
    		stm.setString(1, cliente.getCPF());
    		stm.setString(2, cliente.getNomeCliente());
    		stm.setString(3, cliente.getTelefone());
    		stm.setString(4, cliente.getEmail());
    		stm.setString(5, cliente.getSenha()); 	  		
    		

    		//Executar o statement
    		stm.executeUpdate();
    		//Fechar conexão    	
    		con.close();
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
	public void deletarCliente(JavaBeans cliente) {
		// Criar o objeto que vai receber o comando em SQL
		String sql = "DELETE FROM cliente WHERE CPF=?";		
		try {
			// Abrir uma conexão com o BD
			Connection con = conectar();
			//Criar o statement 
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, cliente.getCPF());
			//Executar o statement
			stm.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

