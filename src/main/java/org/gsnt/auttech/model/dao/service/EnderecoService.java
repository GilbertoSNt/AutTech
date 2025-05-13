package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.model.dao.EnderecoDao;
import org.gsnt.auttech.model.entities.Endereco;
import org.gsnt.auttech.db.DB2;
import org.gsnt.auttech.db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EnderecoService implements EnderecoDao {

    private Connection conn;

    public EnderecoService(Connection conn){
        this.conn = conn;
    }


    //procura endereço pelo tipo de caso(Cliente, fornecedor, funcionário) e código registro
    @Override
    public Endereco findByCasoCod(int caso, int codRegistro) {
        return null;
    }

    //salva o endereço
    @Override
    public void saveEndereco(Endereco endereco) {

        Endereco e = endereco;

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO tabendereco(codexterno, tipoend, endereco," +
                            "numero, bairro, cidade, estado, complemento, cep, codcaso)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            st.setInt(1,e.getCodExterno());
            st.setInt(2,e.getTipoEnd());
            st.setString(3,e.getEndereco());
            st.setString(4,e.getNumero());
            st.setString(5,e.getBairro());
            st.setString(6,e.getCidade());
            st.setInt(7,e.getEstado());
            st.setString(8,e.getComplemento());
            st.setString(9,e.getCep());
            st.setInt(10, e.getTipoCaso());

            st.executeUpdate();
        }catch (SQLException e1){
            throw new DbException(e1.getMessage()+" Endereço Service - save ");
        }
            finally {
            DB2.closeStatement(st);
        }

    }

    //altera o endereço
    @Override
    public void alterEndereco(int codRegistro, Endereco endereco) {

        Endereco e = endereco;

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE tabendereco SET codexterno=?, tipoend=?, endereco=?, " +
                    "numero=?, bairro=?, cidade=?, estado=?, complemento=?, cep=?, codcaso=?" +
                    "WHERE cod = ?");
            st.setInt(1,e.getCodExterno());
            st.setInt(2,e.getTipoEnd());
            st.setString(3,e.getEndereco());
            st.setString(4,e.getNumero());
            st.setString(5,e.getBairro());
            st.setString(6,e.getCidade());
            st.setInt(7,e.getEstado());
            st.setString(8,e.getComplemento());
            st.setString(9,e.getCep());
            st.setInt(10, e.getTipoCaso());
            st.setInt(11, codRegistro);

        }catch (SQLException e1){
            throw new DbException(e1.getMessage()+" Endereço Service - alter ");
        }
        finally {
            DB2.closeStatement(st);
        }

    }
}
