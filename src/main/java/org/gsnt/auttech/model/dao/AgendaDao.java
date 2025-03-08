package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.Agenda;

import java.util.List;

public interface AgendaDao {

    List<Agenda> findTelaPrincipal();

    List<Agenda> findLista();

    Boolean insertAgenda(Agenda item);

    Boolean excluiAgenda(Agenda item);

    Boolean saveAlterAgenda(Agenda item);

    Agenda findByPlacaData(String placa);

    void saveEnvioRecolhimento(Agenda item);

    void saveEnvioGuincho(Agenda item);

}
