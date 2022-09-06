package krturismo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteVendasDao {

	public static void main(String[] args) {
		// Testando a execução do Pacote DAO
		//Create
		Vendas vendas = new Vendas();				
		vendas.setNFS(7777);
				
		VendasDAO dao = new VendasDAO();						
		dao.save(vendas);
						
		System.out.println("Venda salva");
		
		//Read
		try {
			ResultSet resultado = dao.getVendas();
			while (resultado.next()) {
				System.out.println(resultado.getInt(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//Update
		
		//Delete
		VendasDAO dao1 = new VendasDAO();						
		dao1.removeByNFS(0);
		
		System.out.println("Venda removida");
	}
}
