package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.db.DB2;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.DaoFactory;
import org.gsnt.auttech.model.dao.ModeloVeiculoDao;
import org.gsnt.auttech.model.dao.StatusAtendimentoDao;
import org.gsnt.auttech.model.entities.StatusAtendimento;
import org.gsnt.auttech.util.Circulos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatusAtendimentoService implements StatusAtendimentoDao {

    private final Connection conn;


    public StatusAtendimentoService(Connection conn){
        this.conn = conn;
    }

    private final ModeloVeiculoDao modelo = DaoFactory.createModeloVeiculoDao();


    @Override
    public void alteraStatus(StatusAtendimento st) {


    }

    @Override
    public void statusOsInicial(StatusAtendimento st2, Boolean cria) {
        //Com necessidade de orçamento

        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "INSERT INTO tabstatusatendimento(codos, codveiculo,codorcamento, eletrico, injecao, "+
                            "caixa, freiodt, freiotr, motor, revisao, suspensaodt, suspensaotr, pneus, "+
                            "trocaoleo, lavacao, asslevar, alinbalan, orcambio, oreletrico, ormotor, orinjecao, " +
                            "ormecanica, orpneu, orstcliente, ormontagem) "+
                            "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1,st2.getCodOs());
            st.setInt(2,st2.getCodVeiculo());
            st.setInt(3,st2.getCodOrcamento());
            st.setInt(4,st2.getEletrico());
            st.setInt(5,st2.getInjecao());
            st.setInt(6,st2.getCaixa());
            st.setInt(7,st2.getFreioDt());
            st.setInt(8,st2.getFreioTr());
            st.setInt(9,st2.getMotor());
            st.setInt(10,st2.getRevisao());
            st.setInt(11,st2.getSuspensaoDt());
            st.setInt(12,st2.getSuspensaoTr());
            st.setInt(13,st2.getPneus());
            st.setInt(14,st2.getTrocaOleo());
            st.setInt(15,st2.getLavacao());
            st.setInt(16,st2.getAssLevar());
            st.setInt(17,st2.getAlinBalan());
            st.setInt(18,st2.getOrCambio());
            st.setInt(19,st2.getOrEletrico());
            st.setInt(20,st2.getOrMotor());
            st.setInt(21,st2.getOrInjecao());
            st.setInt(22,st2.getOrMecanica());
            st.setInt(23,st2.getOrPneu());
            st.setInt(24,st2.getOrStCliente());
            st.setInt(25,st2.getOrMontagem());
            st.executeUpdate();

        }catch (SQLException e){
            throw new DbException(e.getMessage()+" Cria os status inicial atendimento com 2 parametro");
        }
        finally {
            DB2.closeStatement(st);
        }

    }

    @Override
    public void statusOsInicial(StatusAtendimento st2) {
        //Sem necessidade de orçamento



        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "INSERT INTO tabstatusatendimento(codos,codveiculo,eletrico, injecao, "+
                    "caixa, freiodt, freiotr, motor, revisao, suspensaodt, suspensaotr, pneus, "+
                    "trocaoleo, lavacao, asslevar, alinbalan) "+
                    "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1,st2.getCodOs());
            st.setInt(2,st2.getCodVeiculo());
            st.setInt(3,st2.getEletrico());
            st.setInt(4,st2.getInjecao());
            st.setInt(5,st2.getCaixa());
            st.setInt(6,st2.getFreioDt());
            st.setInt(7,st2.getFreioTr());
            st.setInt(8,st2.getMotor());
            st.setInt(9,st2.getRevisao());
            st.setInt(10,st2.getSuspensaoDt());
            st.setInt(11,st2.getSuspensaoTr());
            st.setInt(12,st2.getPneus());
            st.setInt(13,st2.getTrocaOleo());
            st.setInt(14,st2.getLavacao());
            st.setInt(15,st2.getAssLevar());
            st.setInt(16,st2.getAlinBalan());

            st.executeUpdate();

        }catch (SQLException e){
            throw new DbException(e.getMessage()+" Cria os status inicial atendimento com 1 parametro");
        }
        finally {
            DB2.closeStatement(st);
        }

    }

    @Override// Accordion de orçamento
    public List<StatusAtendimento> statusOrcamentoTela() {
        List<StatusAtendimento> orList = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;

        try{

            st = conn.prepareStatement("select * from statusorcamento");
            rs = st.executeQuery();

            while(rs.next()){

                String placa = rs.getString("placa");
                String modelo1 = modelo.findModeloById(rs.getInt("modelo"));
                Circulos orC = null;
                if(rs.getInt("orcambio")!=0) {
                    orC = stGeralAtendimento(rs.getInt("orcambio"));
                }
                Circulos orE = null;
                if(rs.getInt("oreletrico")!=0) {
                    orE = stGeralAtendimento(rs.getInt("oreletrico"));
                }
                Circulos orI = null;
                if(rs.getInt("orinjecao")!=0) {
                    orI = stGeralAtendimento(rs.getInt("orinjecao"));
                }
                Circulos orM = null;
                if(rs.getInt("ormecanica")!=0) {
                    orM = stGeralAtendimento(rs.getInt("ormecanica"));
                }
                Circulos orMt = null;
                if(rs.getInt("ormotor")!=0) {
                    orMt = stGeralAtendimento(rs.getInt("ormotor"));
                }
                Circulos orP = null;
                if(rs.getInt("orpneu")!=0) {
                    orP = stGeralAtendimento(rs.getInt("orpneu"));
                }
                Circulos mtOr = null;
                if(rs.getInt("ormontagem")!=0) {
                    mtOr = stGeralAtendimento(rs.getInt("ormontagem"));
                }
                Circulos stC = null;
                if(rs.getInt("orstcliente")!=0) {
                    stC = stGeralAtendimento(rs.getInt("orstcliente"));
                }

                orList.add(new StatusAtendimento(placa,modelo1,orC, orE, orI, orM, orMt, orP, mtOr, stC));

            }
            return  orList;
        }
        catch (SQLException e){
        throw new DbException(e.getMessage()+" StatusAtendiemntoService - statusOrcamentoTela SQlException");
        }
        catch (NullPointerException n){
            throw new DbException(n.getMessage()+" StatusAtendiemntoService - statusOrcamentoTela NullPointerException");
        }
        finally {
        DB2.closeResultSet(rs);
        DB2.closeStatement(st);
        }

    }

    @Override // Acordion sem Inicio só análise
    public List<StatusAtendimento> statusOrdemServicoTelaSI() {

        List<StatusAtendimento> osList = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("select * from statussereminiciados");

            rs = st.executeQuery();

            while(rs.next()){
                Integer cod = rs.getInt("cod");
                String placa = rs.getString("placa");
                String modelo1 = modelo.findModeloById(rs.getInt("modelo"));

                Circulos osE = null;
                if(rs.getInt("eletrico")!=0) {
                    osE = stGeralAtendimento(rs.getInt("eletrico"));
                }
                Circulos osI = null;
                if(rs.getInt("injecao")!=0) {
                    osI = stGeralAtendimento(rs.getInt("injecao"));
                }
                Circulos osC = null;
                if(rs.getInt("caixa")!=0) {
                    osC = stGeralAtendimento(rs.getInt("caixa"));
                }
                Circulos osFDt = null;
                if(rs.getInt("freiodt")!=0) {
                    osFDt = stGeralAtendimento(rs.getInt("freiodt"));
                }
                Circulos osFTr = null;
                if(rs.getInt("freiotr")!=0) {
                    osFTr = stGeralAtendimento(rs.getInt("freiotr"));
                }
                Circulos osMt = null;
                if(rs.getInt("motor")!=0) {
                    osMt = stGeralAtendimento(rs.getInt("motor"));
                }
                Circulos osR = null;
                if(rs.getInt("revisao")!=0) {
                    osR = stGeralAtendimento(rs.getInt("revisao"));
                }
                Circulos osSDt = null;
                if(rs.getInt("suspensaodt")!=0) {
                    osSDt = stGeralAtendimento(rs.getInt("suspensaodt"));
                }
                Circulos osSTr = null;
                if(rs.getInt("suspensaotr")!=0) {
                    osSTr = stGeralAtendimento(rs.getInt("suspensaotr"));
                }
                Circulos osP = null;
                if(rs.getInt("pneus")!=0) {
                    osP = stGeralAtendimento(rs.getInt("pneus"));
                }
                Circulos osTrOl = null;
                if(rs.getInt("trocaoleo")!=0) {
                    osTrOl = stGeralAtendimento(rs.getInt("trocaoleo"));
                }
                osList.add(new StatusAtendimento(cod,placa,modelo1,osE, osI,osC, osFDt, osFTr, osMt,osR,
                        osSDt, osSTr, osP, osTrOl));

            }
            return  osList;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" StatusAtendiemntoService - statusServiçoSemInicio Tela");
        }
        finally {
            DB2.closeResultSet(rs);
            DB2.closeStatement(st);
        }

    }

    @Override
    public List<StatusAtendimento> statusOrdemServicoTelaS() {
        // >>>>> teste com lançamentos de parametros <<<<<
        List<StatusAtendimento> osList = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("seletc * from statusemservico");
            rs = st.executeQuery();

            while(rs.next()){

                String placa = rs.getString("placa");
                String modelo1 = modelo.findModeloById(rs.getInt("modelo"));
                Circulos osC = null;
                if(rs.getInt("caixa")!=0) {
                    osC = stGeralAtendimento(rs.getInt("caixa"));
                }
                Circulos osE = null;
                if(rs.getInt("eletrico")!=0) {
                    osE = stGeralAtendimento(rs.getInt("eletrico"));
                }
                Circulos osI = null;
                if(rs.getInt("injecao")!=0) {
                    osI = stGeralAtendimento(rs.getInt("injecao"));
                }
                int fdt = rs.getInt("freiodt");
                if (fdt == 0){
                    fdt = 30;
                }
                int ftr = rs.getInt("freiotr");
                if (ftr == 0){
                    fdt = 30;
                }
                int sdt = rs.getInt("suspensaodt");
                if (sdt == 0){
                    sdt = 30;
                }
                int str = rs.getInt("suspensaotr");
                if (str == 0){
                    str = 30;
                }
                int menorMecanico1 = Math.min(fdt,ftr);
                int menorMecanico2 = Math.min(sdt,str);
                int resultMecanico = Math.min(menorMecanico1,menorMecanico2);
                Circulos osM = null;
                if (resultMecanico<30 && resultMecanico!=0) {
                    osM = stGeralAtendimento(resultMecanico);
                }
                int mt1 = rs.getInt("motor");
                if (mt1 == 0){
                    mt1 = 30;
                }
                int trO1 = rs.getInt("trocaoleo");
                if (trO1 == 0){
                    trO1 = 30;
                }
                int resultMtTr = Math.min(mt1,trO1);
                Circulos osMt = null;
                if(resultMtTr<30 && resultMtTr!=0) {
                    osMt = stGeralAtendimento(resultMtTr);
                }
                Circulos osP = null;
                if(rs.getInt("pneus")!=0) {
                    osP = stGeralAtendimento(rs.getInt("pneus"));
                }
                Circulos osL = null;
                if(rs.getInt("lavacao")!=0) {
                    osL = stGeralAtendimento(rs.getInt("lavacao"));
                }
                osList.add(new StatusAtendimento(placa,modelo1,osC, osE, osI, osM, osMt, osP, osL));

            }
            return  osList;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" StatusAtendiemntoService - statusOrcamentoTela");
        }
        finally {
            DB2.closeResultSet(rs);
            DB2.closeStatement(st);
        }

    }

    @Override
    public List<StatusAtendimento> statusOrdemServicoTelaP() {
        return List.of();
    }

    private Circulos stGeralAtendimento(int a){

        Circulos status = null;

            switch (a) {

                case 1:
                    status = new Circulos("f50505");//amarelo total
                    break;
                case 2:
                    status = new Circulos("f9d428", "f50505");// inteno amarelo - externo verde
                    break;
                case 3:
                    status = new Circulos("f9d428", "f9d428");
                    break;
                case 4:
                    status = new Circulos("7c2d91");
                    break;
                case 5:
                    status = new Circulos("7c2d91","70c3a7" );
                    break;
                case 6:
                    status = new Circulos("3f676d");
                    break;
                case 7:
                    status = new Circulos("f50505");
                    break;
                case 8:
                    status = new Circulos("54d6f0");
                    break;
                case 9:
                    status = new Circulos("70c3a7");
                    break;
                case 10:
                    status = new Circulos("3f676d");
                    break;
                case 11:
                    status = new Circulos("f9d428");
                    break;
                case 12:
                    status = new Circulos("f9d428", "70c3a7");
                    break;
                case 13:
                    status = new Circulos("70c3a7");
                    break;
                case 14:
                    status = new Circulos("7c2d91");
                    break;
                case 15:
                    status = new Circulos("e3c9a2");
                    break;
                case 16:
                    status = new Circulos("000000");
                    break;
                case 17:
                    status = new Circulos("f59097");
                    break;
                case 18:
                    status = new Circulos("86fdff");
                    break;
            }

            return status;

    }

    @Override
    public Boolean deletaStatus(Integer item) {

        PreparedStatement st = null;

        try{
            st = conn.prepareStatement("DELETE FROM tabstatusatendimento WHERE codos = ?");
            st.setInt(1, item);

            int rowsEffected = st.executeUpdate();

            if (rowsEffected > 0) {

                return true;}
            else {
                return false;}

        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB2.closeStatement(st);
        }

    }

    @Override
    public void cancelaAtendimento(Integer item) {

        PreparedStatement st = null;

        try{
            st = conn.prepareStatement("update tabstatusatendimento set stgeralatend = 13 where codos = ?");
            st.setInt(1, item);
            st.executeUpdate();

        }
        catch (SQLException e){
            throw new DbException("StatusAtendimentoService - Cancela atendimento "+e.getMessage());
        }
        finally {
            DB2.closeStatement(st);
        }

    }

    @Override
    public StatusAtendimento stGeralUnico(Integer item) {

        StatusAtendimento sta = new StatusAtendimento();
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("SELECT t1.placa, t1.modelo, st.*  FROM tabstatusatendimento st" +
                                           " JOIN tabveiculo t1 ON t1.cod = st.codveiculo" +
                                           " WHERE st.codos = ?");
            st.setInt(1,item);
            rs = st.executeQuery();

            while(rs.next()){

                sta.setPlaca(rs.getString("placa"));
                sta.setVeiculo(modelo.findModeloById(rs.getInt("modelo")));
                sta.setRevisao(rs.getByte("revisao"));
                sta.setCaixa(rs.getByte("caixa"));
                sta.setEletrico(rs.getByte("eletrico"));
                sta.setInjecao(rs.getByte("injecao"));
                sta.setFreioDt(rs.getByte("freiodt"));
                sta.setFreioTr(rs.getByte("freiotr"));
                sta.setSuspensaoDt(rs.getByte("suspensaodt"));
                sta.setSuspensaoTr(rs.getByte("suspensaotr"));
                sta.setMotor(rs.getByte("motor"));
                sta.setPneus(rs.getByte("pneus"));
                sta.setAlinBalan(rs.getByte("alinbalan"));
                sta.setTrocaOleo(rs.getByte("trocaoleo"));

            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" StatusAtendiemntoService - stgeralunico");
        }
        finally {
            DB2.closeResultSet(rs);
            DB2.closeStatement(st);
        }

        return sta;
    }


}
