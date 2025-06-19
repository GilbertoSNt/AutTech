package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.StatusAtendimento;

import java.util.List;

public interface StatusAtendimentoDao {

    public List<StatusAtendimento> findTelaPrincipal();
    public void alteraStatus(StatusAtendimento st);
    public void statusOsInicial(StatusAtendimento st,StatusAtendimento st1);
    public void statusOsInicial(StatusAtendimento st);
}
