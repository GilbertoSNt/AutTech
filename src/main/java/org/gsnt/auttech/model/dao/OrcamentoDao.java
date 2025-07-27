package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.Orcamento;

import java.util.List;

public interface OrcamentoDao {

    List<Orcamento> findByTela();
    Integer criaOrcamento(Orcamento or);
    void relacaoOrOs(Integer os, Integer or);
    Integer findOrcamento(Integer os);
    void recusaOrcamento(Integer or);
}
