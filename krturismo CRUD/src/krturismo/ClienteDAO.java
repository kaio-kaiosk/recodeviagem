package krturismo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO {
	
	private Connection connection;
	
	public ClienteDAO () {
		this.connection = new ConnectionFactory().getConnection();
	}

	//Create
	public void save (Cliente cliente){
		String sql = "INSERT INTO cliente (cpf, nomeCliente, telefone, email, senha) VALUES(?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, cliente.getCPF());
			stmt.setString(2, cliente.getNomeCliente());
			stmt.setInt(3, cliente.getTelefone());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getSenha());
			stmt.execute();
			stmt.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	//Update
	public void update(Cliente cliente) {
		String sql = "UPDATE cliente SET Nome_Cliente = ?, telefone = ?, email = ?, senha = ? WHERE CPF = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(2, cliente.getNomeCliente());
			stmt.setInt(3, cliente.getTelefone());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getSenha());
			stmt.execute();
			stmt.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	//Delete
	public void removeByCPF(int CPF) {
		String sql = "DELETE FROM cliente WHERE CPF=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, CPF);
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	//Read
		public ResultSet getCliente() throws SQLException{
			String sql = "SELECT * FROM cliente";
			Statement stmt = null;
			ResultSet resultado = null;
			try {
				stmt = connection.createStatement();
				resultado = stmt.executeQuery(sql);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return resultado;			
		}
}
