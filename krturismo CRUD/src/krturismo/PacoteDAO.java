package krturismo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PacoteDAO {
	
	private Connection connection;
	
	public PacoteDAO () {
		this.connection = new ConnectionFactory().getConnection();
	}

	//Create
	public void save (Pacote pacote){
		String sql = "INSERT INTO pacote (Cod_Pacote, Origem, Destino) VALUES(?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, pacote.getCod_Pacote());
			stmt.setString(2, pacote.getOrigem());
			stmt.setString(3, pacote.getDestino());	
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	//Read
	public ResultSet getPacote() throws SQLException {
		String sql = "SELECT * FROM pacote";
		Statement stmt = null;
		ResultSet resultado = null;
		try{
			stmt = connection.createStatement();
			resultado = stmt.executeQuery(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resultado;			
	}

	//Update
	public void update(Pacote pacote) {
		String sql = "UPDATE pacote SET Origem = ?, Destino = ? WHERE Cod_Pacote = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, pacote.getCod_Pacote());
			stmt.setString(2, pacote.getOrigem());
			stmt.setString(3, pacote.getDestino());	
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	
	//Delete
	public void removeByCod_Pacote(int Cod_Pacote) {
		String sql = "DELETE FROM pacote WHERE Cod_Pacote=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, Cod_Pacote);
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
