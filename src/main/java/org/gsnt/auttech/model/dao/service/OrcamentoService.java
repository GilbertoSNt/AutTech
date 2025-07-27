package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.db.DB2;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.OrcamentoDao;
import org.gsnt.auttech.model.entities.Orcamento;
import org.gsnt.auttech.model.entities.StatusAtendimento;

import java.sql.*;
import java.util.List;

public class OrcamentoService implements OrcamentoDao {

    //toda ves que criar orçamento replica recusa orçamento anterior


    private Connection conn;

    public OrcamentoService(Connection conn){
        this.conn = conn;
    }

    @Override
    public List<Orcamento> findByTela() {

        return List.of();
    }

    @Override
    public Integer criaOrcamento(Orcamento or) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("INSERT INTO taborcliente(" +
                                           "codcliente, codveiculo,dataabertura)" +
                                           "VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1,or.getCodCliente());
            st.setInt(2,or.getCodVeiculo());
            st.setString(3,or.getDataAbertura());
            st.executeUpdate();

            st = null;

            st = conn.prepareStatement("SELECT cod " +
                    "FROM taborcliente where codcliente = ? " +
                    "and codveiculo = ? and dataabertura = ?");
            st.setInt(1, or.getCodCliente());
            st.setInt(2, or.getCodVeiculo());
            st.setString(3,or.getDataAbertura());
            rs = st.executeQuery();
            rs.next();

            return rs.getInt("cod");

        }catch(SQLException e){
            throw new DbException(e.getMessage()+" Cria orçamento ");
        } finally {
            DB2.closeStatement(st);
        }

    }

    @Override
    public void relacaoOrOs(Integer os, Integer or) {

    }

    @Override
    public Integer findOrcamento(Integer os) {
        return 0;
    }

    @Override
    public void recusaOrcamento(Integer or) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try{

            st = conn.prepareStatement("select codorc from taborcordemserv where codordemserv = ?");
            st.setInt(1,or);
            rs = st.executeQuery();

            int qt = rs.getFetchSize();

            if(qt > 1){
                while (rs.next()){
                    st = conn.prepareStatement("UPDATE taborcliente SET stgeralorcamento=16 WHERE cod = ?");
                    st.setInt(1, rs.getInt(rs.getInt("codorc")));
                    st.executeUpdate();
                }
            }else if(qt == 1){
                rs.next();
                st = conn.prepareStatement("UPDATE taborcliente SET stgeralorcamento=16 WHERE cod = ?");
                st.setInt(1, rs.getInt(rs.getInt("codorc")));
                st.executeUpdate();
            }

        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" OrçamentoService - Recusa orçamento ");
        }
        finally {
            DB2.closeStatement(st);
            DB2.closeResultSet(rs);
        }
    }

}
