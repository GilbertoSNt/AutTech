package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.TelaPrincipal;
import org.gsnt.auttech.db.DBLocal;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.DaoFactory;
import org.gsnt.auttech.model.dao.ModeloVeiculoDao;
import org.gsnt.auttech.model.dao.StatusAtendimentoDao;
import org.gsnt.auttech.model.entities.Cliente;
import org.gsnt.auttech.model.entities.OrdemServico;
import org.gsnt.auttech.model.entities.StatusAtendimento;
import org.gsnt.auttech.util.Circulos;
import org.gsnt.auttech.util.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatusAtendimentoService implements StatusAtendimentoDao {

    private final Connection conn;
    private final Connection connExt;
    private Circulos cir = new Circulos();
    private final ModeloVeiculoDao modelo = DaoFactory.createModeloVeiculoDao();
    private Utils ut = new Utils();

    private final String inicialOnLineStatus = "INSERT INTO public.tbtstgrlpblc(" +
            "cpfcnpjfornecedor, cpfcnpjcliente, os, placa, datainicio, hrinicio, datafinal, horafinal, " +
            "datainiorc, horainiorc, datafimorc, horafimorc, dataprevisao, horaprevisao, servico, dtservicoini, " +
            "hrservicoini, dtservicofim, hrservicofim, aviso, staviso, dtaviso, hraviso, dtultimo, hrultimo, ativo)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private final String ins_stgrlos = "CALL public.ins_tbstgrlos(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public StatusAtendimentoService(Connection conn, Connection connExt){

        this.conn = conn;
        this.connExt = connExt;
    }


    @Override
    public void alteraStatus(StatusAtendimento st) {

    }

    /**
     * statusOsInicial lança o status inicial com orçamento
     * @param os
     * @param cria
     */
    @Override
    public void statusOsInicial(OrdemServico os, Boolean cria) {

        StatusAtendimento st2 = organizaInicStatusBancoGeral(os,cria);

      //  erro aqui

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
            DBLocal.closeStatement(st);
        }

    }

    /**
     * statusOsInicial lança o status inicial sem orçamento
     * @param os
     */
    @Override
    public void statusOsInicial(OrdemServico os) {
        //Sem necessidade de orçamento
        StatusAtendimento st2 = organizaInicStatusBancoGeral(os,false);


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
            DBLocal.closeStatement(st);
        }

    }

    /**
     * statusOrçamento retorna lista para accordion Orçamento
     * @return List Status Acordion orçamento
     */
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
        DBLocal.closeResultSet(rs);
        DBLocal.closeStatement(st);
        }

    }

    /**
     * statusOrdemServicoTelaSI retorna lista para accordion Serviços iniciados
     * @return List Status Acordion Serviços iniciados
     */
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
            DBLocal.closeResultSet(rs);
            DBLocal.closeStatement(st);
        }

    }


    /**
     * statusOrdemServicoTelaS retorna lista para accordion Serviços
     * @return List Status Acordion Serviços
     */
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
            DBLocal.closeResultSet(rs);
            DBLocal.closeStatement(st);
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
                    return cir.circ1();
                    //status = new Circulos("f50505");//vermelho total

                case 2:
                    return cir.circ2();
                    //status = new Circulos("f9d428", "f50505");// inteno amarelo - externo verde

                case 3:
                    return cir.circ3();
                    //status = new Circulos("f9d428", "f9d428");

                case 4:
                    return cir.circ4();
                    //status = new Circulos("7c2d91");

                case 5:
                    return cir.circ5();
                    //status = new Circulos("7c2d91","70c3a7" );

                case 6:
                    return cir.circ6();
                    //status = new Circulos("3f676d");

                case 7://circ1
                    return cir.circ1();
                    //status = new Circulos("f50505");

                case 8:
                    return cir.circ8();
                    //status = new Circulos("54d6f0");

                case 9:
                    return cir.circ9();
                    //status = new Circulos("70c3a7");

                case 10:
                    return cir.circ10();
                    //status = new Circulos("3f676d");

                case 11://circ3
                    return cir.circ3();
                    //status = new Circulos("f9d428");

                case 12:
                    return cir.circ12();
                    //status = new Circulos("f9d428", "70c3a7");

                case 13:
                    return cir.circ13();
                    //status = new Circulos("70c3a7");

                case 14:
                    return cir.circ14();
                    //status = new Circulos("7c2d91");

                case 15:
                    return cir.circ4();
                    //status = new Circulos("e3c9a2");

                case 16:
                    return cir.circ16();
                    //status = new Circulos("000000");

                case 17:
                    return cir.circ17();
                    //status = new Circulos("f59097");

                case 18:
                    return cir.circ18();
                    //status = new Circulos("86fdff");
            }
        return status;
    }

    /**
     * deleta o status do veículo no banco local
     * @param item
     * @return
     */
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
            DBLocal.closeStatement(st);
        }

    }

    /**
     * cancela atendimento
     * @param item
     */
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
            DBLocal.closeStatement(st);
        }

    }

    /**
     * Retorna o status de uma ordem de serviço para o direcionamento do serviço
     * @param item
     * @return status
     */
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
            rs.next();

                sta.setCodOs(item);
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
        catch (SQLException e){
            throw new DbException(e.getMessage()+" StatusAtendiemntoService - stgeralunico");
        }
        finally {
            DBLocal.closeResultSet(rs);
            DBLocal.closeStatement(st);
        }

        return sta;
    }


    /**
     * Organiza status inicial no banco externo
     * @param os1 Ordem de serviço
     * @param orca verifica a necessidade de orçamento
     * @return Status atendimento
     */
    private StatusAtendimento organizaInicStatusBancoGeral(OrdemServico os1, Boolean orca){

        StatusAtendimento sa = new StatusAtendimento();

        if (orca) {
            sa.setOrMontagem((byte) 11);
            sa.setOrStCliente((byte) 17);
        }else {
            sa.setOrMontagem((byte) 0);
            sa.setOrStCliente((byte) 0);
        }

        if (os1.getRevisao()) {
            sa.setRevisao((byte) 1);
            sa.setMecanico((byte) 1);
            sa.setEletrico((byte) 1);
            sa.setInjecao((byte) 1);
            sa.setFreioDt((byte) 1);
            sa.setFreioTr((byte) 1);
            sa.setSuspensaoDt((byte) 1);
            sa.setSuspensaoTr((byte) 1);
            sa.setCaixa((byte) 1);
            sa.setMotor((byte) 1);
            sa.setTrocaOleo((byte) 1);
            sa.setPneus((byte) 1);
            if (orca) {
                sa.setOrCambio((byte) 11);
                sa.setOrEletrico((byte) 11);
                sa.setOrMotor((byte) 11);
                sa.setOrInjecao((byte) 11);
                sa.setOrMecanica((byte) 11);
                sa.setOrPneu((byte) 11);
            }
        }

        if (os1.getEletrica()) {
            sa.setEletrico((byte) 1);
            if (orca) {
                sa.setOrEletrico((byte) 11);
            }
        }
        if (os1.getInjecao()) {
            sa.setInjecao((byte) 1);
            if (orca) {
                sa.setOrInjecao((byte) 11);
            }
        }
        if (os1.getMecanico()) {
            sa.setMecanico((byte) 1);
            if (orca) {
                sa.setOrMecanica((byte) 11);
            }
        }
        if (os1.getFreioDt()) {
            sa.setFreioDt((byte) 1);
            sa.setMecanico((byte) 1);
            if (orca) {
                sa.setOrMecanica((byte) 11);
            }
        }
        if (os1.getFreioTr()) {
            sa.setFreioTr((byte) 1);
            sa.setMecanico((byte) 1);
            if (orca) {
                sa.setOrMecanica((byte) 11);
            }
        }
        if (os1.getSuspDt()) {
            sa.setSuspensaoDt((byte) 1);
            sa.setMecanico((byte) 1);
            if (orca) {
                sa.setOrMecanica((byte) 11);
            }
        }
        if (os1.getSuspTr()) {
            sa.setSuspensaoTr((byte) 1);
            sa.setMecanico((byte) 1);
            if (orca) {
                sa.setOrMecanica((byte) 11);
            }
        }
        if (os1.getCaixa()) {
            sa.setCaixa((byte) 1);
            if (orca) {
                sa.setOrCambio((byte) 11);
            }
        }
        if (os1.getMotor()) {
            sa.setMotor((byte) 1);
            if (orca) {
                sa.setOrMotor((byte) 11);
            }
        }

        if (os1.getTrocaoleo()) {
            sa.setTrocaOleo((byte) 1);
            sa.setMecanico((byte) 1);
            if (orca) {
                sa.setOrMecanica((byte) 11);
            }
        }

        if (os1.getPneu() || os1.getAlin()) {
            sa.setPneus((byte) 1);
            if (orca) {
                sa.setOrPneu((byte) 11);
            }
        }

        if (os1.getLavacao()) {
            sa.setLavacao((byte) 1);
        }
        sa.setCodOs(os1.getNumero());
        sa.setCodVeiculo(os1.getCodVeiculo());

        return sa;
    }







    // aqui comença a trabalhar com o status externo



    public void stUnico(String cnpj, Integer os, String prof, byte tipoServ, int stt, byte tipotempo ){

        String campoEspNome = "";
        String campohora = "";
        String campoData = "";
        String campoEspStatus = "";

        switch (tipoServ){
            case 1:
                campoEspNome = "alin";
                campoEspStatus = "stalin";
                campohora = "hralin";
                campoData = "dtalin";
                break;
            case 2:
                campoEspNome = "caixa";
                campoEspStatus = "stcaixa";
                campohora = "hrcaixa";
                campoData = "dtcaixa";
                break;
            case 3:
                campoEspNome = "eletrico";
                campoEspStatus = "steletrico";
                campohora = "hrelet";
                campoData = "dtelet";
                break;
            case 4:
                campoEspNome = "freio";
                campoEspStatus = "stfreio";
                campohora = "hrfreio";
                campoData = "dtfreio";
                break;
            case 5:
                campoEspNome = "injelet";
                campoEspStatus = "stinjelet";
                campohora = "hrinj";
                campoData = "dtinj";
                break;
            case 6:
                campoEspNome = "motor";
                campoEspStatus = "stmotor";
                campohora = "hrmot";
                campoData = "dtmot";
                break;
            case 7:
                campoEspNome = "pneu";
                campoEspStatus = "stpneu";
                campohora = "hrpneu";
                campoData = "dtpneu";
                break;
            case 8:
                campoEspNome = "suspensao";
                campoEspStatus = "stsuspensao";
                campohora = "hrsusp";
                campoData = "dtsusp";
                break;
            case 9:
                campoEspNome = "trcoleo";
                campoEspStatus = "sttrcoleo";
                campohora = "hrtrcoleo";
                campoData = "dttrcoleo";
                break;
        }

        String sql_int_envio = "UPDATE public.tbtstgrlpblc " +
                    "SET "+campoEspNome+"=?, "+campoEspStatus+"=?, "+campoData+"envio =?, "+campohora+"envio=?,  dtultimo=?, hrultimo=?, " +
                    "WHERE  os= ?, cpfcnpjfornecedor - ?";

        String sql_int_aceite = "UPDATE public.tbtstgrlpblc " +
                "SET "+campoEspNome+"=?, "+campoEspStatus+"=?, "+campoData+"+aceite=?, "+campohora+"aceite=?, dtultimo=?, hrultimo=?, " +
                "WHERE  os= ?, cpfcnpjfornecedor - ?";

        String sql_int_inicio = "UPDATE public.tbtstgrlpblc " +
                "SET "+campoEspNome+"=?, "+campoEspStatus+"=?, "+campoData+"+ini=?, "+campohora+"ini=?, dtultimo=?, hrultimo=?, " +
                "WHERE  os= ?, cpfcnpjfornecedor - ?";

        String sql_int_fim = "UPDATE public.tbtstgrlpblc " +
                "SET "+campoEspNome+"=?, "+campoEspStatus+"=?, "+campoData+"+fim=?, "+campohora+"fim=?, dtultimo=?, hrultimo=?, " +
                "WHERE  os= ?, cpfcnpjfornecedor - ?";

        String sql = "";
        switch (tipotempo){
            case 1:
               sql = sql_int_envio;
               break;
            case 2:
                sql = sql_int_aceite;
                break;
            case 3:
                sql = sql_int_inicio;
                break;
            case 4:
                sql = sql_int_fim;
                break;
        }


        PreparedStatement st = null;
        try{
            st = connExt.prepareStatement(sql);

            st.setString(1,prof);
            st.setInt(2, stt);
            st.setDate(3, ut.returnSystemDateBanco());
            st.setTime(4, ut.returnSystemTimeBanco());
            st.setDate(5, ut.returnSystemDateBanco());
            st.setTime(6, ut.returnSystemTimeBanco());

            st.setInt(7, os);
            st.setString(8, cnpj);

            st.executeUpdate();


        }catch (SQLException e){
            throw new DbException(e.getMessage()+" StatusAtendimentoService - stUnico");
        }
        finally {
            DBLocal.closeStatement(st);
        }

        //****************************************************************************************************
        //****************************************************************************************************
        // corrigir no utils data hora e fazer a segunda conexão

        //1-envio 2-aceite 3-inicio 4-fim
        // alin - caixa - eletrico - freio - inj - motor - pneu - suspensao - trcoleo - aviso
    }



    /**
     * inicia o registro quando é gravada a Ordem de serviço
     * @param st StatusAtendimento
     * @param os OrdemServiço
     * @return
     */
    @Override
    public Boolean statusOnLineInicial(StatusAtendimento st, OrdemServico os, String cliente) {

        Date data = ut.returnSystemDateBanco();
        Time hora = ut.returnSystemTimeBanco();
        //  erro aqui

        PreparedStatement stExt = null;
        try{
            stExt = connExt.prepareStatement(inicialOnLineStatus, Statement.RETURN_GENERATED_KEYS);

            stExt.setString(1, TelaPrincipal.getId());
            stExt.setString(2, cliente);
            stExt.setInt(3, os.getNumero());
            stExt.setString(4,os.getPlaca());
            stExt.setDate(5,data);
            stExt.setDate(6,data);
            stExt.setTime(7,hora);






/*  cod bigint NOT NULL DEFAULT nextval('sqtstgrlpblc'::regclass),
        cpfcnpjfornecedor character varying(18) not null COLLATE pg_catalog."default",
    	cpfcnpjcliente character varying(18) not null COLLATE pg_catalog."default",
        os bigint NOT NULL DEFAULT 0,
        placa character varying(8) COLLATE pg_catalog."default" NOT NULL,
        datainicio date,
        hrinicio time without time zone,
        datafinal date,
        horafinal time without time zone,
        datainiorc date,
        horainiorc time without time zone,
        datafimorc date,
        horafimorc time without time zone,
        dataprevisao date,
        horaprevisao time without time zone,
        servico integer DEFAULT 0,
        dtservicoini date,
        hrservicoini time without time zone,
        dtservicofim date,
        hrservicofim time without time zone,
        aviso character varying(15) COLLATE pg_catalog."default",
        staviso integer DEFAULT 0,
        dtaviso date,
        hraviso time without time zone,
        dtultimo date,
        hrultimo timestamp without time zone,
        ativo Boolean*/


        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" StatusAtendiemntoService - stgeralunico");
        }
        finally {

            DBLocal.closeStatement(stExt);
        }



        return null;
    }

    @Override
    public void editOrCaixa(Integer codOs, Integer prof) {

    }

    @Override
    public void editOrEletrico(Integer codOs, Integer prof) {

    }

    @Override
    public void editOrInjecao(Integer codOs, Integer prof) {

    }

    @Override
    public void editOrMecanico(Integer codOs, Integer prof) {

    }

    @Override
    public void editOrMontagem(Integer codOs, Integer prof) {

    }

    @Override
    public void editOrMotor(Integer codOs, Integer prof) {

    }

    @Override
    public void editOrPneus(Integer codOs, Integer prof) {

    }

    @Override
    public void editOrStCliente(Integer codOs, Integer prof) {

    }
}

