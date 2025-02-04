package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.Agenda;

import java.util.List;

public interface AgendaDao {

    List<Agenda> findTelaPrincipal();

    List<Agenda> findLista();

    Boolean saveAgenda(Agenda item);

    Boolean excluiAgenda(Agenda Item);

    Boolean saveAlterAgenda(Agenda Item);

}
