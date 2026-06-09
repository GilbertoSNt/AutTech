package org.gsnt.auttech.funcionario;

import java.util.List;

public interface FuncionarioDao {

    int saveFuncionario(Funcionario funcionario);
    List<Funcionario> findByEspecializacao();
    Funcionario findByCod(Integer cod);
    void alterFuncionario(Funcionario funcionario, int cod);
    Integer findFuncByApelido(String apelido);
    List<Funcionario> findFuncCombo(int tipo,int tipo2);



}
