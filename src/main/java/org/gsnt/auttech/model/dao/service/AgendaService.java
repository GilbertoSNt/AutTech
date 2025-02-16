package org.gsnt.auttech.model.dao.service;


import org.gsnt.auttech.model.dao.AgendaDao;
import org.gsnt.auttech.model.entities.Agenda;
import org.gsnt.auttech.util.Circulos;
import org.gsnt.auttech.util.Moka;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class AgendaService implements AgendaDao {

    private Connection conn;

    public AgendaService(){}

    public AgendaService(Connection conn){
        this.conn = conn;
    }

    @Override
    public List<Agenda> findTelaPrincipal() {

        /* construtor do banco de dados
        Integer cod, String data, String hora, String nome, String veiculo, String placa,
        String telefone, String obs, Boolean sRevisao, Boolean sSuspensao, Boolean sInjecao,
        Boolean sPneus, Boolean sTrocaOleo, Boolean sFreio, Boolean sEletrico, Boolean sMecanico,
        Boolean sMotor, Boolean sCaixa, Boolean assSocMecanico, Boolean assSocEletrico, Boolean assLevar,
        Boolean assGuincho, Boolean assBuscar, Boolean assClienteTraz
        */

        /* construtor da tela inicial
         String data, String hora, String nome, String veiculo, String placa,
         BooleanProperty socMecanico, BooleanProperty socEletrico, BooleanProperty levar,
         BooleanProperty guincho, BooleanProperty buscar, BooleanProperty mecanico, BooleanProperty eletrico,
         BooleanProperty injecao, BooleanProperty revisão, BooleanProperty pneus,
         BooleanProperty trocaOleo, IntegerProperty status
         */

        Moka mok = new Moka();
        List<Agenda> a = mok.dadosTelaAgenda();
        List<Agenda> correta = new ArrayList<>();

        for(Integer b=0; b<a.size();b++) {

            Circulos socMecanico = null;
            if (a.get(b).getAssSocMecanico()){
                socMecanico = new Circulos("#70c3a7");
            }

            Circulos socEletrico = null;
            if(a.get(b).getAssSocEletrico()){
                socEletrico = new Circulos("#70c3a7");
            }

            Circulos levar = null;
            if(a.get(b).getAssLevar()){
                levar = new Circulos("#70c3a7");
            }

            Circulos guincho = null;
            if(a.get(b).getAssGuincho()){
                 guincho= new Circulos("#70c3a7");
            }

            Circulos buscar = null;
            if(a.get(b).getAssBuscar()){
                 buscar = new Circulos("#70c3a7");
            }

            Circulos sMecanico = null;
            if (a.get(b).getsMecanico() || a.get(b).getsCaixa() || a.get(b).getsFreio() || a.get(b).getsSuspensao() || a.get(b).getsMotor()) {
                sMecanico = new Circulos("#70c3a7");
            }

            Circulos sEletrico = null;
            if(a.get(b).getsEletrico()){
                sEletrico= new Circulos("#70c3a7");
            }

            Circulos sInjecao = null;
            if(a.get(b).getsInjecao()){
                sInjecao = new Circulos("#70c3a7");
            }

            Circulos  sRevisao = null;
            if(a.get(b).getsRevisao()){
                 sRevisao = new Circulos("#70c3a7");
            }

            Circulos  pneus = null;
            if(a.get(b).getsPneus()){
                 pneus = new Circulos("#70c3a7");
            }

            Circulos  sTrocaOleo = null;
            if(a.get(b).getsTrocaOleo()){
                 sTrocaOleo = new Circulos("#70c3a7");
            }

            Circulos status = null;
            if(a.get(b).getVerStatus()==1){
                status = new Circulos("#70c3a7");
            }else if(a.get(b).getVerStatus()==2) {
                status = new Circulos("#f9d428");
            }else if(a.get(b).getVerStatus()==3) {
                status = new Circulos("#cd5c5c");
            }

            correta.add(new Agenda(a.get(b).getData(), a.get(b).getHora(), a.get(b).getNome(), a.get(b).getVeiculo(),
                    a.get(b).getPlaca(),socMecanico, socEletrico, levar, guincho, buscar, sMecanico, sEletrico, sInjecao,
                    sRevisao, pneus, sTrocaOleo,status));


        }

        return correta;

    }
//----------------------------------------------------------------------------------------------------------------------
    @Override
    public List<Agenda> findLista() {
        return List.of();
    }

    @Override
    public Boolean saveAgenda(Agenda item) {
        return null;
    }

    @Override
    public Boolean excluiAgenda(Agenda item) {
        return null;
    }

    @Override
    public Boolean saveAlterAgenda(Agenda Item) {
        return null;
    }
}
