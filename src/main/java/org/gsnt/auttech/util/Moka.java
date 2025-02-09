package org.gsnt.auttech.util;

import org.gsnt.auttech.model.entities.Agenda;
import org.gsnt.auttech.model.entities.Cliente;
import org.gsnt.auttech.model.entities.OrdemServico;

import java.util.ArrayList;
import java.util.List;

public class Moka {


    public List<Cliente> dadosListaClientes(){

        List<Cliente> list = new ArrayList<>();

        list.add(new Cliente(1, "teste1", "teste11"));
        list.add(new Cliente(2, "teste2", "teste22"));
        list.add(new Cliente(3, "teste3", "teste33"));
        list.add(new Cliente(4, "teste4", "teste44"));
        list.add(new Cliente(5, "teste5", "teste55"));

        return list;
    }



    public List<Agenda> dadosTelaAgenda(){
        List<Agenda> list = new ArrayList<>();

        /* construtor do banco de dados
                  String data, String hora, String nome, String veiculo, String placa, Boolean sRevisao,
                  Boolean sSuspensao, Boolean sInjecao, Boolean sPneus, Boolean sTrocaOleo, Boolean sFreio,
                  Boolean sEletrico, Boolean sMecanico, Boolean sMotor, Boolean sCaixa, Boolean assSocMecanico,
                  Boolean assSocEletrico, Boolean assLevar, Boolean assGuincho, Boolean assBuscar,
                  Integer verStatus
        */
    ;

        list.add(new Agenda("12/02","11:16","Teste1","veiculo1","AAA-0A00", true, false,false, false, false, true, false, false, false, false, false, false, false, true, false, 1));
        list.add(new Agenda("12/02","11:16","Teste2","veiculo2","BBB-0B00", false, true,false, false, true, false, true, false, false, false, false, false, false, true, false, 2));
        list.add(new Agenda("13/02","11:17","Teste3","veiculo3","CCC-0C00", false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, 1));
        list.add(new Agenda("14/02","11:18","Teste4","veiculo4","DDD-0D00", false, false, false, true, false, false, false, false, false, false, true, false, true, false, true, 2));
        list.add(new Agenda("15/02","11:19","Teste5","veiculo5","EEE-0E00", false, false, true, false, false, false, false, false, false, false, false, true, false, false, false, 2));
        return list;

    }

    public List<OrdemServico> dadosTelaSerIniciados(){

        List<OrdemServico> list = new ArrayList<>();

        list.add(new OrdemServico(1,"AAA0A00","Veículo1",false, false, false,false,false,false, false,true,false,false,false,false));
        list.add(new OrdemServico(2,"BBB0B00","Veículo2",true, true, false,false,false,true, false,true,false,false,false,true));
        list.add(new OrdemServico(3,"CCC0C00","Veículo3",false, false, false,false,true,false, false,true,true,false,false,true));
        list.add(new OrdemServico(4,"DDD0D00","Veículo4",false, true, false,false,false,false, false,true,false,false,false,false));
        list.add(new OrdemServico(5,"EEE0E00","Veículo5",false, false, true,false,false,false, false,true,false,false,false,false));

        return list;
    }



}
