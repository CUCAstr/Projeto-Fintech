package com.grupoFiapo.fintech;

import com.grupoFiapo.fintech.dao.UsuarioDao;
import com.grupoFiapo.fintech.models.Usuario;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Cap11Test {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try{
			UsuarioDao dao = new UsuarioDao();

			Usuario u1 = new Usuario("11111111111", "Ana Almeida",   "ana@mail.com",   "senhaA1");
			Usuario u2 = new Usuario("22222222222", "Bruno Barbosa", "bruno@mail.com", "senhaB2");
			Usuario u3 = new Usuario("33333333333", "Carla Castro",  "carla@mail.com", "senhaC3");
			Usuario u4 = new Usuario("44444444444", "Diego Dias",    "diego@mail.com", "senhaD4");
			Usuario u5 = new Usuario("55555555555", "Eva Esteves",   "eva@mail.com",   "senhaE5");

			dao.cadastrarUsuario(u1);
			dao.cadastrarUsuario(u2);
			dao.cadastrarUsuario(u3);
			dao.cadastrarUsuario(u4);
			dao.cadastrarUsuario(u5);
			System.out.println("5 usuários inseridos com sucesso!");

			List<Usuario> usuarios = dao.getAll();
			System.out.println("\nLista completa de usuários:");
			for (Usuario u : usuarios) {
				System.out.println(u);
			}

			dao.fecharConexao();

		} catch (SQLException e) {
			System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
		}


	}
}
