package krturismo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VendasDAO {
	
	private Connection connection;
	
	public VendasDAO () {
		this.connection = new ConnectionFactory().getConnection();
	}

	//Create
	public void save (Vendas vendas){
		String sql = "INSERT INTO vendas (NFS) VALUES(?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, vendas.getNFS());
			stmt.execute();
			stmt.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	//Read
	public ResultSet getVendas() throws SQLException {
		String sql = "SELECT * FROM vendas";
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
	
	//Delete
	public void removeByNFS(int NFS) {
		String sql = "DELETE FROM cliente WHERE NFS=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, NFS);
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
