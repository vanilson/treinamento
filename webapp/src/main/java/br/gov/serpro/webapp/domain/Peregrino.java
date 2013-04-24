package br.gov.serpro.webapp.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Peregrino implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long id;

	@Column
	@NotBlank
	@Size(min = 1, max = 20)
	private String nome;

	@Column
	@NotBlank
	private String telefone;

	@Column
	@NotBlank
	@Email
	private String email;

	@Column
	private String dataInscricao;

	public Peregrino() {
	}

	public Peregrino(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataInscricao = Calendar.getInstance().getTime().toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(String dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

}
