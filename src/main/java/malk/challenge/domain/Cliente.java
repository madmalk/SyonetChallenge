package malk.challenge.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	private String nome;

	@NotEmpty
	@Email
	@Column(unique = true)
	private String email;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate nascimento;

	public Cliente() {
	}

	public Cliente(Integer id, @NotEmpty String nome, @NotEmpty @Email String email, LocalDate nascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public int hashCode() {
		return Objects.hash(email, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id);
	}

	public boolean isBirthday() {
		if (Objects.isNull(this.nascimento))
			return false;
		LocalDate now = LocalDate.now();
		int dayOfMonth = now.getDayOfMonth();
		int monthOfYear = now.getMonthValue();
		int dayOfBirth = this.nascimento.getDayOfMonth();
		int monthOfBirth = this.nascimento.getMonthValue();
		return dayOfMonth == dayOfBirth && monthOfYear == monthOfBirth;
	}
}
