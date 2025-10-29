package org.gsnt.auttech.model.dao;


import org.gsnt.auttech.model.entities.OrdemServico;
import org.gsnt.auttech.model.entities.StatusAtendimento;

import java.util.List;

public interface StatusAtendimentoDao {


    public void alteraStatus(StatusAtendimento st);
    public void statusOsInicial(OrdemServico os, Boolean cria);
    public void statusOsInicial(OrdemServico os);
    public List<StatusAtendimento> statusOrcamentoTela();
    public List<StatusAtendimento> statusOrdemServicoTelaSI();
    public List<StatusAtendimento> statusOrdemServicoTelaS();
    public List<StatusAtendimento> statusOrdemServicoTelaP();
    public Boolean deletaStatus(Integer item);
    public void cancelaAtendimento(Integer item);
    public StatusAtendimento stGeralUnico(Integer item);

    ///// Status OnLine

    ///// Status Orçamento
}
