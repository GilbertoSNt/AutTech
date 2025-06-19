package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.db.DB2;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.DaoFactory;
import org.gsnt.auttech.model.dao.ModeloVeiculoDao;
import org.gsnt.auttech.model.dao.StatusAtendimentoDao;
import org.gsnt.auttech.model.dao.VeiculoDao;
import org.gsnt.auttech.model.entities.OrdemServico;
import org.gsnt.auttech.model.entities.StatusAtendimento;
import org.gsnt.auttech.model.entities.Veiculo;
import org.gsnt.auttech.util.Circulos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatusAtendimentoService implements StatusAtendimentoDao {

    private Connection conn;

   // public StatusAtendimentoService(){}

    public StatusAtendimentoService(Connection conn){
        this.conn = conn;
    }

    private ModeloVeiculoDao modelo = DaoFactory.createModeloVeiculoDao();
    private VeiculoDao veic = DaoFactory.createVeiculoDao();

    @Override
    public List<StatusAtendimento> findTelaPrincipal() {

        //Tela Inicial de Ordem de Serviço a serem iniciados
        /*
         * 1 - Serviço sem direcionamento - Vermelho - cd5c5c
         * 2 - Direcionamento sem confirmação - Vermelho - Amarelo - cd5c5c/f9d428
         * 3 - OS com orçamento pendente - Amarelo - f9d428
         * 4 - Orçamento aguardando liberação - verde - 70c3a7
         * 5 - Orçamento lib. aguardando peças - verde - verde escuro - 70c3a7/3f676d
         * 6 - Orçamento lib. aguardando início - verde escuro - 3f676d
         */
        List<StatusAtendimento> a = new ArrayList<>();
        List<StatusAtendimento> correta = new ArrayList<>();
        StatusAtendimento b;
        Veiculo veiculo;

        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement("SELECT codos, codveiculo, eletrico, injecao, caixa, freiodt," +
                    " freiotr, motor, revisao, suspensaodt, suspensaotr, pneus, trocaoleo" +
                    "FROM tabstatusatendimento where tipo = 2"
            );
            rs = st.executeQuery();

            while (rs.next()) {

                veiculo = veic.verPlacaModelo(rs.getInt("codveiculo"));

                a.add(new StatusAtendimento(rs.getInt("codos"), veiculo.getPlaca(),
                      modelo.findModeloById(veiculo.getModelo()), rs.getByte("eletrico"),
                      rs.getByte("injecao"), rs.getByte("caixa"),rs.getByte("freiodt"),
                      rs.getByte("freiotr"), rs.getByte("motor"), rs.getByte("revisao"),
                      rs.getByte("suspensaodt"), rs.getByte("suspensaotr"),
                      rs.getByte("pneus"),rs.getByte("trocaoleo")));
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" findTelaPrincipal - statusatendimentoservice");
        }
        finally {
            DB2.closeStatement(st);
            DB2.closeResultSet(rs);
        }

        for(Integer z = 0; z<a.size(); z++){

            Circulos sEletrico = null;
            switch (a.get(z).getEletrico()) {
                case 0:
                    break;
                case 1:
                    sEletrico = new Circulos("#cd5c5c");
                    break;
                case 2:
                    sEletrico = new Circulos("#cd5c5c","#f9d428");
                    break;
                case 3:
                    sEletrico = new Circulos("#f9d428");
                    break;
                case 4:
                    sEletrico = new Circulos("#70c3a7");
                    break;
                case 5:
                    sEletrico = new Circulos("#70c3a7","#3f676d");
                    break;
                case 6:
                    sEletrico = new Circulos("#3f676d");
                    break;
            }

            Circulos sInjecao = null;
            switch (a.get(z).getInjecao()) {
                case 0:
                    break;
                case 1:
                    sEletrico = new Circulos("#cd5c5c");
                    break;
                case 2:
                    sEletrico = new Circulos("#cd5c5c","#f9d428");
                    break;
                case 3:
                    sEletrico = new Circulos("#f9d428");
                    break;
                case 4:
                    sEletrico = new Circulos("#70c3a7");
                    break;
                case 5:
                    sEletrico = new Circulos("#70c3a7","#3f676d");
                    break;
                case 6:
                    sEletrico = new Circulos("#3f676d");
                    break;
            }

            Circulos sCambio = null;
            switch (a.get(z).getCaixa()) {
                case 0:
                    break;
                case 1:
                    sEletrico = new Circulos("#cd5c5c");
                    break;
                case 2:
                    sEletrico = new Circulos("#cd5c5c","#f9d428");
                    break;
                case 3:
                    sEletrico = new Circulos("#f9d428");
                    break;
                case 4:
                    sEletrico = new Circulos("#70c3a7");
                    break;
                case 5:
                    sEletrico = new Circulos("#70c3a7","#3f676d");
                    break;
                case 6:
                    sEletrico = new Circulos("#3f676d");
                    break;
            }

            Circulos sFreioDt = null;
            switch (a.get(z).getFreioDt()) {
                case 0:
                    break;
                case 1:
                    sEletrico = new Circulos("#cd5c5c");
                    break;
                case 2:
                    sEletrico = new Circulos("#cd5c5c","#f9d428");
                    break;
                case 3:
                    sEletrico = new Circulos("#f9d428");
                    break;
                case 4:
                    sEletrico = new Circulos("#70c3a7");
                    break;
                case 5:
                    sEletrico = new Circulos("#70c3a7","#3f676d");
                    break;
                case 6:
                    sEletrico = new Circulos("#3f676d");
                    break;
            }

            Circulos sFreioTr = null;
            switch (a.get(z).getFreioTr()) {
                case 0:
                    break;
                case 1:
                    sEletrico = new Circulos("#cd5c5c");
                    break;
                case 2:
                    sEletrico = new Circulos("#cd5c5c","#f9d428");
                    break;
                case 3:
                    sEletrico = new Circulos("#f9d428");
                    break;
                case 4:
                    sEletrico = new Circulos("#70c3a7");
                    break;
                case 5:
                    sEletrico = new Circulos("#70c3a7","#3f676d");
                    break;
                case 6:
                    sEletrico = new Circulos("#3f676d");
                    break;
            }

            Circulos sMotor = null;
            switch (a.get(z).getMotor()) {
                case 0:
                    break;
                case 1:
                    sEletrico = new Circulos("#cd5c5c");
                    break;
                case 2:
                    sEletrico = new Circulos("#cd5c5c","#f9d428");
                    break;
                case 3:
                    sEletrico = new Circulos("#f9d428");
                    break;
                case 4:
                    sEletrico = new Circulos("#70c3a7");
                    break;
                case 5:
                    sEletrico = new Circulos("#70c3a7","#3f676d");
                    break;
                case 6:
                    sEletrico = new Circulos("#3f676d");
                    break;
            }

            Circulos sSuspDt = null;
            switch (a.get(z).getSuspensaoDt()) {
                case 0:
                    break;
                case 1:
                    sEletrico = new Circulos("#cd5c5c");
                    break;
                case 2:
                    sEletrico = new Circulos("#cd5c5c","#f9d428");
                    break;
                case 3:
                    sEletrico = new Circulos("#f9d428");
                    break;
                case 4:
                    sEletrico = new Circulos("#70c3a7");
                    break;
                case 5:
                    sEletrico = new Circulos("#70c3a7","#3f676d");
                    break;
                case 6:
                    sEletrico = new Circulos("#3f676d");
                    break;
            }

            Circulos sSuspTr = null;
            switch (a.get(z).getSuspensaoTr()) {
                case 0:
                    break;
                case 1:
                    sEletrico = new Circulos("#cd5c5c");
                    break;
                case 2:
                    sEletrico = new Circulos("#cd5c5c","#f9d428");
                    break;
                case 3:
                    sEletrico = new Circulos("#f9d428");
                    break;
                case 4:
                    sEletrico = new Circulos("#70c3a7");
                    break;
                case 5:
                    sEletrico = new Circulos("#70c3a7","#3f676d");
                    break;
                case 6:
                    sEletrico = new Circulos("#3f676d");
                    break;
            }

            Circulos sPneus = null;
            switch (a.get(z).getPneus()) {
                case 0:
                    break;
                case 1:
                    sEletrico = new Circulos("#cd5c5c");
                    break;
                case 2:
                    sEletrico = new Circulos("#cd5c5c","#f9d428");
                    break;
                case 3:
                    sEletrico = new Circulos("#f9d428");
                    break;
                case 4:
                    sEletrico = new Circulos("#70c3a7");
                    break;
                case 5:
                    sEletrico = new Circulos("#70c3a7","#3f676d");
                    break;
                case 6:
                    sEletrico = new Circulos("#3f676d");
                    break;
            }

            Circulos sTrOleo = null;
            switch (a.get(z).getTrocaOleo()) {
                case 0:
                    break;
                case 1:
                    sEletrico = new Circulos("#cd5c5c");
                    break;
                case 2:
                    sEletrico = new Circulos("#cd5c5c","#f9d428");
                    break;
                case 3:
                    sEletrico = new Circulos("#f9d428");
                    break;
                case 4:
                    sEletrico = new Circulos("#70c3a7");
                    break;
                case 5:
                    sEletrico = new Circulos("#70c3a7","#3f676d");
                    break;
                case 6:
                    sEletrico = new Circulos("#3f676d");
                    break;
            }

            Circulos sRevisao = null;
            switch (a.get(z).getRevisao()) {
                case 0:
                    break;
                case 1:
                    sRevisao = new Circulos("#cd5c5c");
                    break;
                case 2:
                    sRevisao = new Circulos("#cd5c5c","#f9d428");
                    break;
                case 3:
                    sRevisao = new Circulos("#f9d428");
                    break;
                case 4:
                    sRevisao = new Circulos("#70c3a7");
                    break;
                case 5:
                    sRevisao = new Circulos("#70c3a7","#3f676d");
                    break;
                case 6:
                    sRevisao = new Circulos("#3f676d");
                    break;
            }

            correta.add(new StatusAtendimento(a.get(z).getCod(), a.get(z).getPlaca(), a.get(z).getVeiculo(),
                    sEletrico, sInjecao, sCambio, sFreioDt, sFreioTr, sMotor, sRevisao,sSuspDt,
                    sSuspTr, sPneus,sTrOleo));
        }

        return correta;
    }

    @Override
    public void alteraStatus(StatusAtendimento st) {


    }

    @Override
    public void statusOsInicial(StatusAtendimento st2, StatusAtendimento st3) {


        StatusAtendimento st1 = st2;
        StatusAtendimento st4 = st3;
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "INSERT INTO tabstatusatendimento(codos, codveiculo, eletrico, injecao, "+
                            "caixa, freiodt, freiotr, motor, revisao, suspensaodt, suspensaotr, pneus, "+
                            "trocaoleo, lavacao, asslevar, alinbalan, orcambio, oreletrico, ormotor, orinjecao, " +
                            "ormecanica, orpneu, orstcliente, ormontagem) "+
                            "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1,st1.getCodOs());
            st.setInt(2,st1.getCodVeiculo());
            st.setInt(3,st1.getEletrico());
            st.setInt(4,st1.getInjecao());
            st.setInt(5,st1.getCaixa());
            st.setInt(6,st1.getFreioDt());
            st.setInt(7,st1.getFreioTr());
            st.setInt(8,st1.getMotor());
            st.setInt(9,st1.getRevisao());
            st.setInt(10,st1.getSuspensaoDt());
            st.setInt(11,st1.getSuspensaoTr());
            st.setInt(12,st1.getPneus());
            st.setInt(13,st1.getTrocaOleo());
            st.setInt(14,st1.getLavacao());
            st.setInt(15,st1.getAssLevar());
            st.setInt(16,st1.getAlinBalan());
            st.setInt(17,st4.getOrCambio());
            st.setInt(18,st4.getOrEletrico());
            st.setInt(19,st4.getOrMotor());
            st.setInt(20,st4.getOrInjecao());
            st.setInt(21,st4.getOrMecanica());
            st.setInt(22,st4.getOrPneu());
            st.setInt(23,st4.getOrStCliente());
            st.setInt(24,st4.getOrMontagem());
            st.executeUpdate();

        }catch (SQLException e){
            throw new DbException(e.getMessage()+" insert status atendimento com 2 parametro");
        }
        finally {
            DB2.closeStatement(st);
        }



    }

    @Override
    public void statusOsInicial(StatusAtendimento st2) {

        StatusAtendimento st1 = st2;

        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "INSERT INTO tabstatusatendimento(codos,codveiculo,eletrico, injecao, "+
                    "caixa, freiodt, freiotr, motor, revisao, suspensaodt, suspensaotr, pneus, "+
                    "trocaoleo, lavacao, asslevar, alinbalan) "+
                    "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1,st1.getCodOs());
            st.setInt(2,st1.getCodVeiculo());
            st.setInt(3,st1.getEletrico());
            st.setInt(4,st1.getInjecao());
            st.setInt(5,st1.getCaixa());
            st.setInt(6,st1.getFreioDt());
            st.setInt(7,st1.getFreioTr());
            st.setInt(8,st1.getMotor());
            st.setInt(9,st1.getRevisao());
            st.setInt(10,st1.getSuspensaoDt());
            st.setInt(11,st1.getSuspensaoTr());
            st.setInt(12,st1.getPneus());
            st.setInt(13,st1.getTrocaOleo());
            st.setInt(14,st1.getLavacao());
            st.setInt(15,st1.getAssLevar());
            st.setInt(16,st1.getAlinBalan());

            st.executeUpdate();

        }catch (SQLException e){
            throw new DbException(e.getMessage()+" insert status atendimento com 1 parametro");
        }
        finally {
            DB2.closeStatement(st);
        }

    }


}
