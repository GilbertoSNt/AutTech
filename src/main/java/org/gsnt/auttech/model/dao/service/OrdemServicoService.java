package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.db.DB2;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.AgendaDao;
import org.gsnt.auttech.model.dao.DaoFactory;
import org.gsnt.auttech.model.dao.OrdemServicoDao;
import org.gsnt.auttech.model.dao.StatusAtendimentoDao;
import org.gsnt.auttech.model.entities.OrdemServico;
import org.gsnt.auttech.model.entities.StatusAtendimento;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class OrdemServicoService implements OrdemServicoDao {

    private Connection conn;

    public OrdemServicoService(){}

    public OrdemServicoService(Connection conn){
        this.conn = conn;
    }

    private final StatusAtendimentoDao stAt= DaoFactory.createStatusAtendimentoDao();


    ///////////////// refatorar tudo aqui

    //excluir este metodo
    @Override
    public List<OrdemServico> findTelaPrincipal() {
        return List.of();
    }

    @Override
    public List<OrdemServico> findTelaPrincipalEmServiço() {
        return List.of();
    }


    @Override
    public List<OrdemServico> findLista() {
        return List.of();
    }

    @Override
    public Integer saveOrdemServico(OrdemServico item) {
        return null;
    }

    @Override
    public Boolean cancelaOrdemServico(Integer item) {

        PreparedStatement st = null;

        try{

            st = conn.prepareStatement("UPDATE tabos SET statusos=6 WHERE cod = ?");
            st.setInt(1, item);
            st.executeUpdate();

            int rowsEffected = st.executeUpdate();
            if (rowsEffected > 0 && stAt.deletaStatus(item)) {
                return true;
            }else {
                return false;
            }

        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" cancelaOrdemServico - OrdemServiçoService");
        }
        finally {
            DB2.closeStatement(st);
        }

    }


    @Override
    public Boolean saveAlterOrdemServico(OrdemServico Item) {
        return null;
    }

    @Override
    public void encerraOs(Date data, Time hora) {

    }

    @Override
    public void financeiroOs(int parcelas) {

    }

    @Override
    public void baixaParcelasOs() {

    }

    @Override
    public void encaminharOs() {

    }


    @Override
    public Integer findOrforOs(Integer os) {

        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT codorc " +
                    "FROM taborcordemserv where codordemserv = ?");

            st.setInt(1,os);

            rs =  st.executeQuery();
            rs.next();
            System.out.println("findOrforOs - "+rs.getFetchSize());
            if(rs.getFetchSize()==0) {
              return 0;
            }
            return rs.getInt("codorc");

        }catch(SQLException e){
            throw new DbException(e.getMessage()+" OrdemServiçoService - findOrforOs");
        } finally {
            DB2.closeStatement(st);
        }

    }

    @Override
    public Integer criaOrdemServico(OrdemServico os1) {

        int resultado = 0;
        StatusAtendimento sa = new StatusAtendimento();
        OrdemServico os = os1;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("INSERT INTO tabos(codcliente, codveiculo," +
                            "obsos, statusos, orcamento, dataabertura, horaabertura," +
                            "asslevas) " +
                            "VALUES ( ?, ?, ?, ?, ?, ?, ?,?);",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1,os.getCodCliente());
            st.setInt(2,os.getCodVeiculo());
            st.setString(3,os.getObsOs());
            st.setInt(4, os.getStatusOs());
            st.setBoolean(5,os.getNecOrcamento());
            st.setString(6,os.getDataAbertura());
            st.setString(7,os.getHoraAbertura());
            st.setBoolean(8, os1.getAssLevarVeiculo());

            int rowsaffected = st.executeUpdate();
            if(rowsaffected > 0){
                rs = st.getGeneratedKeys();
                if(rs.next()){
                    resultado = rs.getInt(1);
                }
            }

            return resultado;

        }catch(SQLException e){
            throw new DbException(e.getMessage()+" criaOrdemServico - OrdemServicoService");
        } finally {
            DB2.closeResultSet(rs);
            DB2.closeStatement(st);
        }

    }


}
