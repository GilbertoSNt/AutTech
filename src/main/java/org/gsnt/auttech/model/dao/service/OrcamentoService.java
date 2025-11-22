package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.db.DBLocal;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.OrcamentoDao;
import org.gsnt.auttech.model.entities.Orcamento;

import java.sql.*;
import java.util.List;

public class OrcamentoService implements OrcamentoDao {

    //toda vez que criar orçamento replica recusa orçamento anterior


    private Connection conn;

    public OrcamentoService(Connection conn){
        this.conn = conn;
    }

    @Override
    public List<Orcamento> findByTela() {

        return List.of();
    }

    @Override
    public void criaOrcamento(Orcamento or) {

        Integer resultado = -1;
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("INSERT INTO tabor(" +
                                           "codcliente, codveiculo,dataabertura,codos,digitoor)" +
                                           "VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1,or.getCodCliente());
            st.setInt(2,or.getCodVeiculo());
            st.setString(3,or.getDataAbertura());
            st.setInt(4,or.getOrdemServico());
            st.setInt(5,1);
            st.executeUpdate();
            int rowsaffected = st.executeUpdate();

            if(rowsaffected > 0){
                rs = st.getGeneratedKeys();
                if(rs.next()){
                    resultado = rs.getInt(1);
                }
            }


        }catch(SQLException e){
            throw new DbException(e.getMessage()+" Cria orçamento - OrçamentoService");
        } finally {
            DBLocal.closeStatement(st);
        }

     //   mudar lógica para acertar digito do orçamento

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
                    st = conn.prepareStatement("UPDATE tabor SET stgeralorcamento=16 WHERE cod = ?");
                    st.setInt(1, rs.getInt(rs.getInt("codorc")));
                    st.executeUpdate();
                }
            }else if(qt == 1){
                rs.next();
                st = conn.prepareStatement("UPDATE tabor SET stgeralorcamento=16 WHERE cod = ?");
                st.setInt(1, rs.getInt(rs.getInt("codorc")));
                st.executeUpdate();
            }

        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" OrçamentoService - Recusa orçamento ");
        }
        finally {
            DBLocal.closeStatement(st);
            DBLocal.closeResultSet(rs);
        }
    }

}
