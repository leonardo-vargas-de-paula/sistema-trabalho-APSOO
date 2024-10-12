package sistema.model;

import jakarta.persistence.*;
import sistema.controller.ClienteManager;
import sistema.controller.PedidoManager;
import sistema.repository.ClienteRepository;
import sistema.repository.PedidoRepository;



public class Funcionario extends Usuario implements ClienteManager, PedidoManager {

	private String nome;
	@Id
	private String cpf;
	private String telefone;
	private Double salario;

	@OneToOne
	@JoinColumn(name = "usuario_fk", referencedColumnName = "id")

	private Usuario usuario;

	private Cliente cliente;

	private ClienteRepository clienteRepository;

	private PedidoRepository pedidoRepository;

	private void registrarPedido() {

	}

	private void realizarLogin() {

	}

	private void alterarStatus() {

	}

	private void alterarInfoCliente() {

	}

	private void cadastrarCliente() {

	}

	private void alterarCliente() {

	}

	private void removerCliente() {

	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
