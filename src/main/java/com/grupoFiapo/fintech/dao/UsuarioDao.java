package com.grupoFiapo.fintech.dao;

import com.grupoFiapo.fintech.factory.ConnectionFactory;
import com.grupoFiapo.fintech.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

	private Connection conexao;



	public UsuarioDao() throws SQLException {
		conexao = ConnectionFactory.getConnection();
	}

	public void fecharConexao() throws SQLException {
		conexao.close();
	}


	public void cadastrarUsuario(Usuario usuario) throws SQLException {

		PreparedStatement statement = conexao.prepareStatement("INSERT INTO tb_usuario (id_usuario, nr_cpf, nm_usuario, nm_email, ds_senha) VALUES (seq_id_usuario.nextval, ?, ?, ?, ?)");

		statement.setString(1, usuario.getCpf());
		statement.setString(2, usuario.getNome());
		statement.setString(3, usuario.getEmail());
		statement.setString(4, usuario.getSenha());
		statement.executeUpdate();
	}

	private Usuario parseUsuario(ResultSet result) throws SQLException {
		Long id = result.getLong("id_usuario");
		String cpf = result.getString("nr_cpf");
		String nome = result.getString("nm_usuario");
		String email = result.getString("nm_email");
		String senha = result.getString("ds_senha");

		return new Usuario(id, cpf, nome, email, senha);
	}

	public List<Usuario> getAll() throws SQLException {
		PreparedStatement statement = conexao.prepareStatement("SELECT * FROM tb_usuario");
		ResultSet result = statement.executeQuery();
		List<Usuario> usuarios = new ArrayList<>();
		while (result.next()) {
			usuarios.add(parseUsuario(result));
		}
		return usuarios;
	}


}
