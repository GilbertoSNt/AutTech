package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.Direcionados;

public interface DirecionadosDao {

    Integer saveDirecionados(Direcionados dir);
    Boolean excluiDirecionados(Integer cod);
    Boolean editDirecionados(Integer cod);

}
