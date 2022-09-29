package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = {"/main","/inserir","/select","/update","/delete"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();
	JavaBeans cliente = new JavaBeans();
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String action = request.getServletPath();
	    System.out.println(action);
	    
	    if (action.equals("/main")) {
	    	clientes(request,response);
	    } else if (action.equals("/inserir")) {
	    	novoCliente(request,response);
	    } else if (action.equals("/select")) {
	    	listarCliente(request,response);
	    } else if (action.equals("/update")) {
	    	editarCliente(request,response);
	    }else if (action.equals("/delete")) {
	    	removerCliente(request,response);	
	    }else {
	    	response.sendRedirect("clientes.jsp");
	    }
	}
	
	protected void clientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Criar uma objeto do tipo lista para receber os clientes do metodo listarClientes
		ArrayList<JavaBeans> lista = dao.listarClientes();
		
		//Enviar os dados para a página clientes.jsp
		request.setAttribute("clientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("clientes.jsp");
		rd.forward(request,response);
		
	}

	protected void novoCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cliente.setCPF(request.getParameter("CPF"));
		cliente.setNomeCliente(request.getParameter("NomeCliente"));
		cliente.setTelefone(request.getParameter("Telefone"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setSenha(request.getParameter("senha"));

		
		//Chamar o método inserirCliente do DAO 
		dao.inserirCliente(cliente);
		//Redirecionar a tela
		response.sendRedirect("main");
	}
	
	
	protected void listarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Pegar ID do cliente selecionado
		String CPF = request.getParameter("CPF");
		cliente.setCPF(CPF);
		//Executar o método selecionarCliente do DAO
		dao.selecionarCliente(cliente);
		//Colocar os dados no objeto Cliente
		request.setAttribute("CPF", cliente.getCPF());	
		request.setAttribute("nomeCliente", cliente.getNomeCliente());
		request.setAttribute("Telefone", cliente.getTelefone());
		request.setAttribute("email", cliente.getEmail());
		request.setAttribute("senha", cliente.getSenha());

		// Enviar documento para a página editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);	}

	protected void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Popular os dados no objeto cliente
		cliente.setCPF(request.getParameter("CPF"));
		cliente.setNomeCliente(request.getParameter("nomeCliente"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setSenha(request.getParameter("senha"));

		//Alterar o cliente usando o DAO
		dao.alterarCliente(cliente);
		//Redirecionar para o documentp clientes.jsp (com os dados atualizado)
		response.sendRedirect("main");		
	}

	protected void removerCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recebe o id do clienet a ser excluido do validador.js 
		String CPF = request.getParameter("CPF");
		// Definir idcli a ser excluido
		cliente.setCPF(CPF);
		// executar o metodo de excluir no DAO
		dao.deletarCliente(cliente);
		// Redirecionar para o documento clientes.jsp (como os dados atualizados)
		response.sendRedirect("main");
	}

}


