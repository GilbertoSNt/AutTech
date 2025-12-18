package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.Direcionados;

import java.util.List;

public interface DirecionadosDao {

    Integer saveDirecionados(Direcionados dir);
    Boolean excluiDirecionados(Integer cod);
    Boolean editDirecionados(Integer cod);
    List<Direcionados> listaServico();
    List<Direcionados> listaServPorFuncionarios(Integer cod);
    List<String> envio(List<String> enviados);


}
