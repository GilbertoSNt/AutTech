package org.gsnt.auttech.primacesso;

import org.gsnt.auttech.entitiesgenerics.Empresa;

import java.sql.PreparedStatement;
import java.util.List;

public interface PrimAcessoDao {

    String verificaCadEmpresa(String cnpj);
    List<Empresa> retornaUnidades(String cnpj);
    void cadastra(PreparedStatement ps);


}
