package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.Agenda;

import java.util.List;

public interface AgendaDao {

    List<Agenda> findTelaPrincipal();

    Boolean insertAgenda(Agenda item);

    Boolean excluiAgenda(Agenda item);

    Boolean saveAlterAgenda(Agenda item, String placa);

    Agenda findByPlacaData(String placa);

    void saveEnvioRecolhimento(Agenda item);

    void saveEnvioGuincho(Agenda item);

    void reverteEnvioGuincho(Agenda item);

    void reverterEnvioRecolhimento(Agenda item);

    Agenda verStatusAssistencias(String placa);
}
