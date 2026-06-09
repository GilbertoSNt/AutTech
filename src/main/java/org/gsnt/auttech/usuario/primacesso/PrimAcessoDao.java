package org.gsnt.auttech.usuario.primacesso;

import org.gsnt.auttech.entitiesgenerics.Empresa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface PrimAcessoDao {

    ResultSet verificaCadEmpresa(String cnpj);
    ResultSet verificaCadFisico(String cpf);
    List<Empresa> retornaUnidades(String cnpj);
    void cadastra(PreparedStatement ps);


}
