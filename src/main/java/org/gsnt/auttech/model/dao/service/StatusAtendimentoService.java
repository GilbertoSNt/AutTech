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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                    " freiotr, motor, revisao, suspensaodt, suspensaotr, pneus, trocaoleo, " +
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

}
