package com.grupoFiapo.fintech.dao;

import com.grupoFiapo.fintech.factory.ConnectionFactory;
import com.grupoFiapo.fintech.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDao {

	private Connection conexao;



	public UsuarioDao() throws SQLException {
		conexao = ConnectionFactory.getConnection();

	}

	public void fecharConexao() throws SQLException {
		conexao.close();
	}

	public void cadastrarUsuario(Usuario usuario) throws SQLException {

	PreparedStatement statement = conexao.prepareStatement("INSERT INTO tb_usuario ()");
	}



}
