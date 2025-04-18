package com.grupoFiapo.fintech.dao;

import  com.grupoFiapo.fintech.factory.ConnectionFactory;
import  com.grupoFiapo.fintech.models.Metas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetaDao {

    private Connection conexao;

    public MetaDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void insert(Metas meta) throws SQLException {
        String sql = "INSERT INTO tb_meta (id_meta, TB_USUARIO_nl_cpf, nm_meta, vl_meta, dt_meta, ds_meta) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setLong(1, meta.getId());
        stmt.setLong(2, meta.getCpfUsuario());
        stmt.setString(3, meta.getNome());
        stmt.setDouble(4, meta.getValor());
        stmt.setDate(5, new java.sql.Date(meta.getDataMeta().getTime()));
        stmt.setString(6, meta.getDescricao());
        stmt.executeUpdate();
    }

    public List<Metas> getAll() throws SQLException {
        List<Metas> metas = new ArrayList<>();
        String sql = "SELECT * FROM tb_meta";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Metas meta = new Metas(
                    rs.getLong("id_meta"),
                    rs.getLong("TB_USUARIO_nl_cpf"),
                    rs.getString("nm_meta"),
                    rs.getDouble("vl_meta"),
                    rs.getDate("dt_meta"),
                    rs.getString("ds_meta")
            );
            metas.add(meta);
        }

        return metas;
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}

