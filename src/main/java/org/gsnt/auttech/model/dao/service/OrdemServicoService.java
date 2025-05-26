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
        /*
        * 1 - Serviço sem direcionamento - Vermelho - cd5c5c
        * 2 - Direcionamento sem confirmação - Vermelho - Amarelo - cd5c5c/f9d428
        * 3 - OS com orçamento pendente - Amarelo - f9d428
        * 4 - Orçamento aguardando liberação - verde - 70c3a7
        * 5 - Orçamento lib. aguardando peças - verde - verde escuro - 70c3a7/3f676d
        * 6 - Orçamento lib. aguardando início - verde escuro - 3f676d
        */
        Moka mok = new Moka();
        List<OrdemServico> a = mok.dadosTelaSerIniciados();
        List<OrdemServico> correta = new ArrayList<>();

        for(Integer b = 0; b<a.size(); b++){

            Circulos sEletrico = null;
            switch (a.get(b).getsEletrico()) {
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
            switch (a.get(b).getsInjecao()) {
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
            switch (a.get(b).getsCambio()) {
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
            switch (a.get(b).getsFreioDt()) {
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
            switch (a.get(b).getsFreioTr()) {
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
            switch (a.get(b).getsMotor()) {
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
            switch (a.get(b).getsSuspDt()) {
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
            switch (a.get(b).getsSuspTr()) {
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
            switch (a.get(b).getsPneus()) {
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
            switch (a.get(b).getsTrOleo()) {
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
            switch (a.get(b).getsRevisao()) {
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

            correta.add(new OrdemServico(a.get(b).getNumero(), a.get(b).getPlaca(), a.get(b).getModelo(),
                    sEletrico, sInjecao, sCambio, sFreioDt, sFreioTr, sMotor, sRevisao,sSuspDt,
                    sSuspTr, sPneus,sTrOleo));
        }

        return correta;
    }


    ///////////////// refatorar tudo aqui


    @Override
    public List<OrdemServico> findTelaPrincipalEmServiço() {
        //Tela Inicial de Ordem de Serviço em produção

        Moka mok = new Moka();
        List<OrdemServico> a = mok.dadosTelaOsProducao();
        List<OrdemServico> correta = new ArrayList<>();

        for (Integer b = 0; b < a.size(); b++) {

            Circulos sEletrico = null;
            switch (a.get(b).getsEletrico()) {
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
            switch (a.get(b).getsInjecao()) {
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

            Circulos sCambio = null;
            if (a.get(b).getsCambio() != 0) {
                switch (a.get(b).getsCambio()) {
                    case 0:
                        break;
                    case 1:
                        sCambio = new Circulos("#cd5c5c");
                        break;
                    case 2:
                        sCambio = new Circulos("#f9d428");
                        break;
                    case 3:
                        sCambio = new Circulos("#70c3a7");
                        break;
                }
            }

            Integer freio = 0;
            Integer suspensao = 0;
            Integer trocaoleo = 0;
            Integer result = 0;

            if (a.get(b).getsFreioDt() != 0 || a.get(b).getsFreioTr() != 0){

                if(a.get(b).getsFreioDt() == 0){
                    freio = a.get(b).getsFreioTr();
                }else if(a.get(b).getsFreioTr() == 0){
                    freio = a.get(b).getsFreioDt();
                }else if ((a.get(b).getsFreioDt() >= a.get(b).getsFreioTr()) && a.get(b).getsFreioTr()!=0){
                    freio = a.get(b).getsFreioTr();
                }else if ((a.get(b).getsFreioDt() <= a.get(b).getsFreioTr()) && a.get(b).getsFreioDt()!=0){
                    freio = a.get(b).getsFreioDt();
                }

            }

            if (a.get(b).getsSuspDt() != 0 || a.get(b).getsSuspTr() != 0){

                if(a.get(b).getsSuspDt() == 0){
                    suspensao = a.get(b).getsSuspTr();
                }else if(a.get(b).getsSuspTr() == 0){
                    suspensao = a.get(b).getsSuspDt();
                }else if((a.get(b).getsSuspDt() >= a.get(b).getsSuspTr()) && a.get(b).getsSuspTr() != 0){
                    suspensao = a.get(b).getsSuspTr();
                }else if((a.get(b).getsSuspDt() <= a.get(b).getsSuspTr()) && a.get(b).getsSuspDt() != 0){
                    suspensao = a.get(b).getsSuspDt();
                }

            }

            if (a.get(b).getsTrOleo() != 0) {
                trocaoleo = a.get(b).getsTrOleo();
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
            switch (a.get(b).getsMotor()) {
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
            switch (a.get(b).getsPneus()) {
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
                    sEletrico, sInjecao, sMotor, sMecanico, sCambio, sPneus, sLavacao));
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
