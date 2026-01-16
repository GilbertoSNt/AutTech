package org.gsnt.auttech.model.dao;

import org.gsnt.auttech.model.entities.Direcionados;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public interface ProfServDao {

    Boolean saveDirecionadosInterno(List<Direcionados> dir, Integer codOS, char tipo, Integer movimento);
    Boolean excluiDirecionados(Integer cod);
    Boolean editDirecionados(Integer cod);
    List<Direcionados> listaServico();
    List<Direcionados> listaServPorFuncionarios(Integer cod);
    List<String> envio(List<String> enviados);


}
