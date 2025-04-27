package org.gsnt.auttech.model.dao.service;


import org.gsnt.auttech.model.dao.OrdemServicoDao;
import org.gsnt.auttech.model.entities.OrdemServico;
import org.gsnt.auttech.util.Circulos;
import org.gsnt.auttech.util.Moka;

import java.sql.Connection;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdemServicoService implements OrdemServicoDao {

    private Connection conn;

    public OrdemServicoService(){}

    public OrdemServicoService(Connection conn){
        this.conn = conn;
    }


    @Override
    public List<OrdemServico> findTelaPrincipal() {
        //Tela Inicial de Ordem de Serviço a serem iniciados
        Moka mok = new Moka();
        List<OrdemServico> a = mok.dadosTelaSerIniciados();
        List<OrdemServico> correta = new ArrayList<>();

        for(Integer b = 0; b<a.size(); b++){

            Circulos sEletrico = null;
            if(a.get(b).getsEletrico()){
                sEletrico = new Circulos("#f9d428");
            }

            Circulos sInjecao = null;
            if(a.get(b).getsInjecao()){
                sInjecao = new Circulos("#f9d428");
            }

            Circulos sCamAut = null;
            if(a.get(b).getsCamAut()){
                sCamAut = new Circulos("#f9d428");
            }

            Circulos sCamMec = null;
            if(a.get(b).getsCamAut()){
                sCamMec = new Circulos("#f9d428");
            }

            Circulos sFreioDt = null;
            if(a.get(b).getsFreioDt()){
                sFreioDt = new Circulos("#f9d428");
            }

            Circulos sFreioTr = null;
            if(a.get(b).getsFreioTr()){
                sFreioTr = new Circulos("#f9d428");
            }

            Circulos sMotor = null;
            if(a.get(b).getsMotor()){
                sMotor = new Circulos("#f9d428");
            }

            Circulos sSuspDt = null;
            if(a.get(b).getsSuspDt()){
                sSuspDt = new Circulos("#f9d428");
            }

            Circulos sSuspTr = null;
            if(a.get(b).getsSuspTr()){
                sSuspTr = new Circulos("#f9d428");
            }

            Circulos sPneus = null;
            if(a.get(b).getsPneus()){
                sPneus = new Circulos("#f9d428");
            }

            Circulos sTrOleo = null;
            if(a.get(b).getsTrOleo()){
                sTrOleo = new Circulos("#f9d428");
            }

            Circulos sRevisao = null;
            if(a.get(b).getsRevisao()){
                sRevisao = new Circulos("#f9d428","#70c3a7");
                sEletrico = new Circulos("#f9d428");
                sInjecao = new Circulos("#f9d428");
                sCamAut = new Circulos("#f9d428");
                sCamMec = new Circulos("#f9d428");
                sFreioDt = new Circulos("#f9d428");
                sFreioTr = new Circulos("#f9d428");
                sMotor = new Circulos("#f9d428");
                sSuspDt = new Circulos("#f9d428");
                sSuspTr = new Circulos("#f9d428");
                sPneus = new Circulos("#f9d428");
                sTrOleo = new Circulos("#f9d428");

            }

            correta.add(new OrdemServico(a.get(b).getNumero(), a.get(b).getPlaca(), a.get(b).getModelo(),
                    sEletrico, sInjecao, sCamAut, sCamMec, sFreioDt, sFreioTr, sMotor, sRevisao,sSuspDt,
                    sSuspTr, sPneus,sTrOleo));

        }

        return correta;
    }

    @Override
    public List<OrdemServico> findTelaPrincipalEmServiço() {
        //Tela Inicial de Ordem de Serviço em produção

        Moka mok = new Moka();
        List<OrdemServico> a = mok.dadosTelaOsProducao();
        List<OrdemServico> correta = new ArrayList<>();

        for (Integer b = 0; b < a.size(); b++) {

            Circulos sEletrico = null;
            switch (a.get(b).getsEletrico3()) {
                case 0:
                    break;
                case 1:
                    sEletrico = new Circulos("#cd5c5c");
                    break;
                case 2:
                    sEletrico = new Circulos("#f9d428");
                    break;
                case 3:
                    sEletrico = new Circulos("#70c3a7");
                    break;
            }

            Circulos sInjecao = null;
            switch (a.get(b).getsInjecao3()) {
                case 0:
                    break;
                case 1:
                    sInjecao = new Circulos("#cd5c5c");
                    break;
                case 2:
                    sInjecao = new Circulos("#f9d428");
                    break;
                case 3:
                    sInjecao = new Circulos("#70c3a7");
                    break;
            }

            Circulos sCamMec = null;
            if (a.get(b).getsCamAut3() != 0) {
                switch (a.get(b).getsCamAut3()) {
                    case 0:
                        break;
                    case 1:
                        sCamMec = new Circulos("#cd5c5c");
                        break;
                    case 2:
                        sCamMec = new Circulos("#f9d428");
                        break;
                    case 3:
                        sCamMec = new Circulos("#70c3a7");
                        break;
                }
            } else if (a.get(b).getsCamMec3() != 0) {
                switch (a.get(b).getsCamMec3()) {
                    case 0:
                        break;
                    case 1:
                        sCamMec = new Circulos("#cd5c5c");
                        break;
                    case 2:
                        sCamMec = new Circulos("#f9d428");
                        break;
                    case 3:
                        sCamMec = new Circulos("#70c3a7");
                        break;
                }
            }

            Integer freio = 0;
            Integer suspensao = 0;
            Integer trocaoleo = 0;
            Integer result = 0;

            if (a.get(b).getsFreioDt3() != 0 || a.get(b).getsFreioTr3() != 0){

                if(a.get(b).getsFreioDt3() == 0){
                    freio = a.get(b).getsFreioTr3();
                }else if(a.get(b).getsFreioTr3() == 0){
                    freio = a.get(b).getsFreioDt3();
                }else if ((a.get(b).getsFreioDt3() >= a.get(b).getsFreioTr3()) && a.get(b).getsFreioTr3()!=0){
                    freio = a.get(b).getsFreioTr3();
                }else if ((a.get(b).getsFreioDt3() <= a.get(b).getsFreioTr3()) && a.get(b).getsFreioDt3()!=0){
                    freio = a.get(b).getsFreioDt3();
                }

            }

            if (a.get(b).getsSuspDt3() != 0 || a.get(b).getsSuspTr3() != 0){

                if(a.get(b).getsSuspDt3() == 0){
                    suspensao = a.get(b).getsSuspTr3();
                }else if(a.get(b).getsSuspTr3() == 0){
                    suspensao = a.get(b).getsSuspDt3();
                }else if((a.get(b).getsSuspDt3() >= a.get(b).getsSuspTr3()) && a.get(b).getsSuspTr3() != 0){
                    suspensao = a.get(b).getsSuspTr3();
                }else if((a.get(b).getsSuspDt3() <= a.get(b).getsSuspTr3()) && a.get(b).getsSuspDt3() != 0){
                    suspensao = a.get(b).getsSuspDt3();
                }

            }

            if (a.get(b).getsTrOleo3() != 0) {
                trocaoleo = a.get(b).getsTrOleo3();
            }

            if(freio != 0){
                result = freio;
            }
            if ((suspensao != 0) && (suspensao > result && result == 0)){
                result = suspensao;
            }
            if ((trocaoleo != 0) && (trocaoleo > result && result == 0)){
                result = trocaoleo;
            }

            Circulos sMecanico = null;
            switch (result) {
                case 0:
                    break;
                case 1:
                    sMecanico = new Circulos("#cd5c5c");
                    break;
                case 2:
                    sMecanico = new Circulos("#f9d428");
                    break;
                case 3:
                    sMecanico = new Circulos("#70c3a7");
                    break;
            }

            Circulos sMotor = null;
            switch (a.get(b).getsMotor3()) {
                case 0:
                    break;
                case 1:
                    sMotor = new Circulos("#cd5c5c");
                    break;
                case 2:
                    sMotor = new Circulos("#f9d428");
                    break;
                case 3:
                    sMotor = new Circulos("#70c3a7");
                    break;
            }

            Circulos sPneus = null;
            switch (a.get(b).getsPneus3()) {
                case 0:
                    break;
                case 1:
                    sPneus = new Circulos("#cd5c5c");
                    break;
                case 2:
                    sPneus = new Circulos("#f9d428");
                    break;
                case 3:
                    sPneus = new Circulos("#70c3a7");
                    break;
            }

            Circulos sLavacao = null;
            switch (a.get(b).getLavacao()) {
                case 0:
                    break;
                case 1:
                    sLavacao = new Circulos("#cd5c5c");
                    break;
                case 2:
                    sLavacao = new Circulos("#f9d428");
                    break;
                case 3:
                    sLavacao = new Circulos("#70c3a7");
                    break;
            }

/*
        Integer numero, String placa, String modelo, Integer sEletrico3, Integer sInjecao3,
        Integer sCamAut3, Integer sCamMec3, Integer sFreioDt3, Integer sFreioTr3, Integer sMotor3,
        Integer sSuspDt3, Integer sSuspTr3, Integer sPneus3, Integer sTrOleo3, Integer lavacao

        * Integer numero, String placa, String modelo, Circulos sEletrico2, Circulos sInjecao2,
          Circulos sMotor2, Circulos sMecanico, Circulos sCamMec2, Circulos sPneus2, Circulos sLavacao
            0 = sem serviço
            1 = não iniciado #cd5c5c
            2 = em serviço   #f9d428
            3 = pronto       #70c3a7
        */

            correta.add(new OrdemServico(a.get(b).getNumero(), a.get(b).getPlaca(), a.get(b).getModelo(),
                    sEletrico, sInjecao, sMotor, sMecanico, sCamMec, sPneus, sLavacao));
        }

        return correta;
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
    public Boolean excluiOrdemServico(OrdemServico Item) {
        return null;
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

}
