package krturismo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteClienteDao {

	public static void main(String[] args) {
		// Testando a execução do Cliente DAO
		//Create
		Cliente cliente = new Cliente();
		
		cliente.setCPF(1111155);
		cliente.setNomeCliente("Nando");
		cliente.setTelefone(48885554);
		cliente.setEmail("nandoo@yahoo.com");
		cliente.setSenha("88875");

		ClienteDAO dao = new ClienteDAO();
		
		dao.save(cliente);
		
		System.out.println("Cliente salvo");
		
		
		//Update
		cliente.setNomeCliente("lucca");
		cliente.setTelefone(444778);
		cliente.setEmail("l@yahoo.com");
		cliente.setSenha("555hi");
		
		dao.update(cliente);
		
		System.out.println("Cliente alterado");
		
		//Delete
		ClienteDAO dao1 = new ClienteDAO();
		dao1.removeByCPF(749449);
		
		System.out.println("Cliente removido");
		
		//Read
		try {
			ResultSet resultado = dao.getCliente();
			while (resultado.next()) {
				System.out.println(resultado.getInt(1)+" "+resultado.getString(2)+" "+resultado.getInt(3)+""+resultado.getString(4)+" "+resultado.getString(5));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
				

	}
}
