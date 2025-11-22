package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.Orcamento;

import java.util.List;

public interface OrcamentoDao {

    List<Orcamento> findByTela();
    void criaOrcamento(Orcamento or);
    Integer findOrcamento(Integer os);
    void recusaOrcamento(Integer or);
}
