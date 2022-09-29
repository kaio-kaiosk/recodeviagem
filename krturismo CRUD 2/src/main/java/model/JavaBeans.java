package model;

public class JavaBeans {
	private String nomeCliente;
	private String CPF;
	private String telefone;
	private String email;
	private String senha;

	
	
	public JavaBeans() {
		super();
	}
	
	public JavaBeans(String nomeCliente, String CPF, String telefone, String email, String senha) {
		super();
		this.nomeCliente = nomeCliente;
		this.CPF = CPF;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}

