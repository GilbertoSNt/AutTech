package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.OrdemServico;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface OrdemServicoDao {

    List<OrdemServico> findTelaPrincipal();

    List<OrdemServico> findTelaPrincipalEmServiço();

    List<OrdemServico> findLista();

    Integer saveOrdemServico(OrdemServico item);

    Boolean cancelaOrdemServico(Integer Item);

    Boolean saveAlterOrdemServico(OrdemServico Item);

    Integer criaOrdemServico(OrdemServico os);
    void encerraOs(Date data, Time hora);
    void financeiroOs(int parcelas);
    void baixaParcelasOs();
    void encaminharOs();
    Integer findOrforOs(Integer os);

}
