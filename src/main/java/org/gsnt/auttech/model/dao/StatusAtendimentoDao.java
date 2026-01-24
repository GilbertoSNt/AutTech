package org.gsnt.auttech.model.dao;


import org.gsnt.auttech.model.entities.Cliente;
import org.gsnt.auttech.model.entities.OrdemServico;
import org.gsnt.auttech.model.entities.StatusAtendimento;

import java.util.List;

public interface StatusAtendimentoDao {


    void alteraStatus(StatusAtendimento st);
    void statusOsInicial(OrdemServico os, Boolean cria);
    void statusOsInicial(OrdemServico os);

    List<StatusAtendimento> statusOrdemServicoTelaSI();
    List<StatusAtendimento> statusOrdemServicoTelaS();
    List<StatusAtendimento> statusOrdemServicoTelaP();
    Boolean deletaStatus(Integer item);
    void cancelaAtendimento(Integer item);
    StatusAtendimento stGeralUnico(Integer item);


    void stUnico(String cnpj, Integer os, String prof, byte tipoServ, int stt, byte tipotempo );

    ///// Status OnLine

    Boolean statusOnLineInicial(StatusAtendimento st, OrdemServico os, String cliente);


    ///// Status Orçamento

    List<StatusAtendimento> statusOrcamentoTela();

            // edição
    void editOrCaixa(Integer codOs, Integer prof);
    void editOrEletrico(Integer codOs, Integer prof);
    void editOrInjecao(Integer codOs, Integer prof);
    void editOrMecanico(Integer codOs, Integer prof);
    void editOrMontagem(Integer codOs, Integer prof);
    void editOrMotor(Integer codOs, Integer prof);
    void editOrPneus(Integer codOs, Integer prof);
    void editOrStCliente(Integer codOs, Integer prof);

}
