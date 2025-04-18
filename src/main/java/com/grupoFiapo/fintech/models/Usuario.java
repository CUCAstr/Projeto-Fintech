package com.grupoFiapo.fintech.models;

/**
 * Representa um usuário do sistema.
 * Design enxuto: apenas os campos realmente usados no momento.
 * É fácil adicionar telefone, endereço etc. depois.
 */
public class Usuario {

	/* ---------- Atributos ---------- */
	private Long id;     // PK gerada pelo banco (seq_id_usuario.NEXTVAL)
	private String cpf;    // nr_cpf
	private String nome;   // nm_usuario
	private String email;  // nm_email
	private String senha;  // ds_senha

	/* ---------- Construtores ---------- */

	/**
	 * Construtor vazio – útil para frameworks e (des)serialização
	 */
	public Usuario() {
	}

	/**
	 * Construtor usado na gravação (não precisa de id)
	 */
	public Usuario(String cpf, String nome, String email, String senha) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	/**
	 * Construtor usado na leitura (já vem com id do banco)
	 */
	public Usuario(Long id, String cpf, String nome, String email, String senha) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	/* ---------- Getters & Setters ---------- */

	public Long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"id=" + id +
				", cpf='" + cpf + '\'' +
				", nome='" + nome + '\'' +
				", email='" + email + '\'' +
				", senha='" + senha + '\'' +
				'}';
	}
}

