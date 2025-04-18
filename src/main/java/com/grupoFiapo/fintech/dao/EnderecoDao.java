package com.grupoFiapo.fintech.dao;
import com.grupoFiapo.fintech.factory.ConnectionFactory;
import com.grupoFiapo.fintech.models.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDao {

    private final Connection conexao;

    public EnderecoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void insert(Endereco endereco) throws SQLException {
        String sql = "INSERT INTO tb_endereco (id_endereco, id_usuario, cep, logradouro, estado, cidade, bairro, residencia, complemento) " +
                "VALUES (seq_tb_endereco.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stm = conexao.prepareStatement(sql);

        stm.setLong(1, endereco.getIdUsuario());
        stm.setInt(2, endereco.getCep());
        stm.setString(3, endereco.getLogradouro());
        stm.setString(4, endereco.getEstado());
        stm.setString(5, endereco.getCidade());
        stm.setString(6, endereco.getBairro());
        stm.setString(7, endereco.getResidencia());
        stm.setString(8, endereco.getComplemento());

        stm.executeUpdate();
        stm.close();
    }

    public List<Endereco> getAll() throws SQLException {
        List<Endereco> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_endereco";
        PreparedStatement stm = conexao.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            Endereco e = new Endereco(
                    rs.getLong("id_usuario"),
                    rs.getInt("cep"),
                    rs.getString("logradouro"),
                    rs.getString("estado"),
                    rs.getString("cidade"),
                    rs.getString("bairro"),
                    rs.getString("residencia"),
                    rs.getString("complemento"),
                    rs.getInt("id_endereco")
            );
            lista.add(e);
        }

        rs.close();
        stm.close();

        return lista;
    }
    public void deleteAll() throws SQLException {
        String sql = "DELETE FROM tb_endereco";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.executeUpdate();
        stm.close();
    }
    public void fechar() throws SQLException {
        conexao.close();
    }
}