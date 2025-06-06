package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.model.dao.OrcamentoDao;
import org.gsnt.auttech.model.entities.Orcamento;
import org.gsnt.auttech.util.Circulos;
import org.gsnt.auttech.util.Moka;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class OrcamentoService implements OrcamentoDao {

    private Connection conn;

    public OrcamentoService(){}

    public OrcamentoService(Connection conn){
        this.conn = conn;
    }

    @Override
    public List<Orcamento> findByTela() {

        //Tela principal da tela ordem de serviço

        Moka mok = new Moka();
        List<Orcamento> a = new ArrayList<>();
        a = mok.dadosTelaOrcamento();
        List<Orcamento> correta = new ArrayList<>();
        String statusFrase = null;

        for(Integer b=0; b<a.size();b++) {
            statusFrase = "";

            switch (a.get(b).getStatusCliente()){
                case 1:
                    statusFrase = "Aguardando";
                    break;
                case 2:
                    statusFrase = "Liberado";
                    break;
                case 3:
                    statusFrase = "Recusado";
                    break;
            }

            Circulos orcCambio2 = null;

            switch (a.get(b).getOrcCambio()){
                case 0:
                    break;
                case 1:
                    orcCambio2 = new Circulos("f9d428");
                    break;
                case 2:
                    orcCambio2 = new Circulos("f9d428","70c3a7");
                    break;
                case 3:
                    orcCambio2 = new Circulos("70c3a7","f9d428");
                    break;
            }

            Circulos orcEletrico2 = null;

            switch (a.get(b).getOrcEletrico()){
                case 0:
                    break;
                case 1:
                    orcEletrico2 = new Circulos("f9d428");
                    break;
                case 2:
                    orcEletrico2 = new Circulos("f9d428","70c3a7");
                    break;
                case 3:
                    orcEletrico2 = new Circulos("70c3a7","f9d428");
                    break;
            }

            Circulos orcFreio2 = null;

            switch (a.get(b).getOrcFreio()){
                case 0:
                    break;
                case 1:
                    orcFreio2 = new Circulos("f9d428");
                    break;
                case 2:
                    orcFreio2 = new Circulos("f9d428","70c3a7");
                    break;
                case 3:
                    orcFreio2 = new Circulos("70c3a7","f9d428");
                    break;
            }

            Circulos orcInjecao2 = null;

            switch (a.get(b).getOrcInjecao()){
                case 0:
                    break;
                case 1:
                    orcInjecao2 = new Circulos("f9d428");
                    break;
                case 2:
                    orcInjecao2 = new Circulos("f9d428","70c3a7");
                    break;
                case 3:
                    orcInjecao2 = new Circulos("70c3a7","f9d428");
                    break;
            }

            Circulos orcMecanico2 = null;

            switch (a.get(b).getOrcMecanico()){
                case 0:
                    break;
                case 1:
                    orcMecanico2 = new Circulos("f9d428");
                    break;
                case 2:
                    orcMecanico2 = new Circulos("f9d428","70c3a7");
                    break;
                case 3:
                    orcMecanico2 = new Circulos("70c3a7","f9d428");
                    break;
            }

            Circulos orcPneu2 = null;

            switch (a.get(b).getOrcPneu()){
                case 0:
                    break;
                case 1:
                    orcPneu2 = new Circulos("f9d428");
                    break;
                case 2:
                    orcPneu2 = new Circulos("f9d428","70c3a7");
                    break;
                case 3:
                    orcPneu2 = new Circulos("70c3a7","f9d428");
                    break;
            }

            Circulos statusOrc2 = null;

            switch (a.get(b).getStatusOrc()){
                case 0:
                    break;
                case 1:
                    statusOrc2 = new Circulos("f9d428");
                    break;
                case 2:
                    statusOrc2 = new Circulos("f9d428","70c3a7");
                    break;
                case 3:
                    statusOrc2 = new Circulos("70c3a7","f9d428");
                    break;
                case 4:
                    statusOrc2 = new Circulos("70c3a7");
                    break;
                case 5:
                    statusOrc2 = new Circulos("70c3a7","cd5c5c");
                    break;
                case 6:
                    statusOrc2 = new Circulos("cd5c5c");
                    break;
            }

            correta.add(new Orcamento(a.get(b).getCod(), a.get(b).getPlaca(),a.get(b).getModelo(), statusFrase,
                    orcCambio2, orcEletrico2, orcFreio2, orcInjecao2, orcMecanico2, orcPneu2, statusOrc2));
        }
        /*
        * Integer cod, String placa, String modelo, String statusCliente, Integer statusOrc,
        * Integer orcPneu, Integer orcMecanico, Integer orcInjecao, Integer orcFreio,
        * Integer orcEletrico, Integer orcCambio
          *
        * Integer cod, String placa, String modelo, String statusCliente, Circulos orcCambio2,
        * Circulos orcEletrico2, Circulos orcFreio2, Circulos orcInjecao2, Circulos orcMecanico2,
        * Circulos orcPneu2, Circulos statusOrc2

         * 1 - Aguardando profissional
         * 2 - Em preparação
         * 3 - liberado para o cliente
         *
         * 4 - Orçamento liberado
         * 5 - Orçamento liberado parcial
         * 6 - Orçamento recusado
         *
         * Status cliente
         * 1 - aguardando
         * 2 - Liberado
         * 3 - Recusado
         */
        return correta;
    }
}
