package org.gsnt.auttech.status;


import org.gsnt.auttech.os.OrdemServico;

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
    void editOrCaixa(Integer codOs,Integer situacao);
    void editOrEletrico(Integer codOs,Integer situacao);
    void editOrInjecao(Integer codOs, Integer situacao);
    void editOrMecanico(Integer codOs, Integer situacao);
    void editOrMontagem(Integer codOs, Integer situacao);
    void editOrMotor(Integer codOs, Integer situacao);
    void editOrPneus(Integer codOs, Integer situacao);
    void editOrStCliente(Integer codOs, Integer situacao);
    void editStAlinBalan(Integer codOs, Integer situacao);
    void editAssLevar(Integer codOs, Integer situacao);
    void edirCaixa(Integer codOs, Integer situacao);
    void editEletrico(Integer codOs, Integer situacao);
    void editFreioDt(Integer codOs, Integer situacao);

    void editFreioTr(Integer codOs, Integer situacao);

    void editInj(Integer codOs, Integer prof, Integer situacao);
    void editLavacao(Integer codOs, Integer prof, Integer situacao);
    void editMotor(Integer codOs, Integer prof, Integer situacao);
    void editPneus(Integer codOs, Integer prof, Integer situacao);
    void editrevisão(Integer codOs, Integer prof, Integer situacao);
    void editStAviso(Integer codOs, Integer prof, Integer situacao);
    void editSuspensaoDt(Integer codOs, Integer situacao);

    void editSuspensaoTr(Integer codOs, Integer situacao);

    void edittrocaOleo(Integer codOs, Integer prof, Integer situacao);

    // possível erro aqui
    void editStgeralAtend(Integer codOs, Integer prof, Integer situacao);

}
