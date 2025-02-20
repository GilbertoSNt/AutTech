package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.OrdemServico;

import java.util.List;

public interface OrdemServicoDao {

    List<OrdemServico> findTelaPrincipal();

    List<OrdemServico> findTelaPrincipalEmServiço();

    List<OrdemServico> findLista();

    Boolean saveOrdemServico(OrdemServico item);

    Boolean excluiOrdemServico(OrdemServico Item);

    Boolean saveAlterOrdemServico(OrdemServico Item);

}
