package org.gsnt.auttech.util;

import kotlin.contracts.Returns;
import org.gsnt.auttech.model.entities.Agenda;
import org.gsnt.auttech.model.entities.Cliente;
import org.gsnt.auttech.model.entities.Orcamento;
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
        list.add(new Agenda("15/02","11:19","Teste5","veiculo5","EEE-0E00", false, false, true, false, false, false, false, false, false, false, false, true, false, false, false, 3));
        return list;

    }

    public List<OrdemServico> dadosTelaSerIniciados(){

        List<OrdemServico> list = new ArrayList<>();

        list.add(new OrdemServico(1,"AAA0A00","Veículo1",false, false, false,false,false,false, false,true,false,false,false,false));
        list.add(new OrdemServico(2,"BBB0B00","Veículo2",true, true, false,false,false,true, false,false,false,false,true,true));
        list.add(new OrdemServico(3,"CCC0C00","Veículo3",false, false, false,false,true,false, false,false,true,false,false,true));
        list.add(new OrdemServico(4,"DDD0D00","Veículo4",false, true, false,false,false,false, false,true,false,false,false,false));
        list.add(new OrdemServico(5,"EEE0E00","Veículo5",true, false, true,false,false,false, false,true,false,false,false,false));

        return list;
    }

    public List<Orcamento> dadosTelaOrcamento(){
        /*
        * Integer cod, String placa, String modelo, String statusCliente, Integer statusOrc,
        * Integer orcPneu, Integer orcMecanico, Integer orcInjecao, Integer orcFreio,
        * Integer orcEletrico, Integer orcCambio*/

        List<Orcamento> list = new ArrayList<>();

        list.add(new Orcamento(1,"AAA0A00","Veículo1",1,1,0,1,1,1,1,1));
        list.add(new Orcamento(2,"BBB0B00","Veículo2",3,6,3,0,1,0,2,1));
        list.add(new Orcamento(3,"CCC0C00","Veículo3",2,4,0,1,2,0,1,2));
        list.add(new Orcamento(4,"DDD0D00","Veículo4",2,4,1,1,1,0,0,1));
        list.add(new Orcamento(5,"EEE0E00","Veículo5",2,4,2,0,2,0,0,0));
        list.add(new Orcamento(6,"FFF0F00","Veículo6",1,6,1,1,1,1,2,2));

        return list;
    }


    public List<OrdemServico> dadosTelaOsProducao(){
        /*
        Integer numero, String placa, String modelo, Integer sEletrico3, Integer sInjecao3,
        Integer sCamAut3, Integer sCamMec3, Integer sFreioDt3, Integer sFreioTr3, Integer sMotor3,
        Integer sSuspDt3, Integer sSuspTr3, Integer sPneus3, Integer sTrOleo3, Integer lavacao
        */

        List<OrdemServico> list = new ArrayList<>();
        list.add(new OrdemServico(1,"AAA0A00","Veículo1",1,1,1,1,1,1,1,1,1,1,1,1));
        list.add(new OrdemServico(2,"BBB0B00","Veículo2",2,2,2,2,2,2,2,2,2,2,2,2));
        list.add(new OrdemServico(3,"CCC0C00","Veículo3",3,3,3,3,3,3,3,3,3,3,3,3));
        list.add(new OrdemServico(3,"CCC0C00","Veículo4",0,0,0,1,1,0,0,0,0,0,0,0));
        list.add(new OrdemServico(3,"CCC0C00","Veículo5",1,1,1,0,0,1,1,0,0,1,0,1));
        list.add(new OrdemServico(3,"CCC0C00","Veículo6",2,2,0,0,0,0,2,3,0,2,0,2));
        list.add(new OrdemServico(3,"CCC0C00","Veículo7",3,3,0,2,0,0,3,1,3,3,0,3));
        list.add(new OrdemServico(3,"CCC0C00","Veículo8",0,0,0,0,0,0,0,0,0,0,3,1));
        list.add(new OrdemServico(3,"CCC0C00","Veículo9",0,0,0,0,1,0,0,0,0,1,3,0));
        return list;

    }




}
