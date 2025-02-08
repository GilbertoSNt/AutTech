package org.gsnt.auttech.model.dao.service;


import org.gsnt.auttech.model.dao.OrdemServicoDao;
import org.gsnt.auttech.model.entities.OrdemServico;
import org.gsnt.auttech.util.Circulos;
import org.gsnt.auttech.util.Moka;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoService implements OrdemServicoDao {

    private Connection conn;

    public OrdemServicoService(){}

    public OrdemServicoService(Connection conn){
        this.conn = conn;
    }


    @Override
    public List<OrdemServico> findTelaPrincipal() {

        Moka mok = new Moka();
        List<OrdemServico> a = mok.dadosTelaSerIniciados();
        List<OrdemServico> correta = new ArrayList<>();

        for(Integer b = 0; b>a.size(); b++){

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
            if(a.get(b).getsTrOleo()){
                sRevisao = new Circulos("#f9d428","#cd5c5c");
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
           /* Circulos sRevisao2,
                    Circulos sPneus2, Circulos sTrOleo2*/
            correta.add(new OrdemServico(a.get(b).getNumero(), a.get(b).getPlaca(), a.get(b).getModelo(),
                    sEletrico, sInjecao, sCamAut, sCamMec, sFreioDt, sFreioTr, sMotor, sRevisao,sSuspDt,
                    sSuspTr, sPneus,sTrOleo));
        }

        return correta;
    }

    @Override
    public List<OrdemServico> findLista() {
        return List.of();
    }

    @Override
    public Boolean saveOrdemServico(OrdemServico item) {
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
}
