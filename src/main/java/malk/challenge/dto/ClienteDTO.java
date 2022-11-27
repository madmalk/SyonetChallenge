package malk.challenge.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import malk.challenge.domain.Cliente;
import malk.challenge.mapper.ToEntity;

public class ClienteDTO implements ToEntity<Cliente> {
	
	@NotEmpty
	private String nome;
	@NotEmpty
	@Email
	private String email;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate nascimento;
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(Cliente obj) {
		nome = obj.getNome();
		email = obj.getEmail();
		nascimento = obj.getNascimento();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
	@Override
	public Cliente to() {
		Cliente cliente = new Cliente(); 
		cliente.setNome(this.getNome());
		cliente.setEmail(this.getEmail());
		cliente.setNascimento(this.getNascimento());
		return cliente;
	}

}
