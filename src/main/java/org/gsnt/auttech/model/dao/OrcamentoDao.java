package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.Orcamento;

import java.util.List;

public interface OrcamentoDao {

    List<Orcamento> findByTela();
    void criaOrcamento(Orcamento or);
    void relacaoOrOs(Integer os, Integer or);
}
