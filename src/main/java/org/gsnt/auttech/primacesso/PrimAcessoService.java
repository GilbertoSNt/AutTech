package org.gsnt.auttech.primacesso;

import org.gsnt.auttech.entitiesgenerics.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class PrimAcessoService implements PrimAcessoDao {

    private Connection conn;

    public PrimAcessoService(Connection conn){
        this.conn = conn;
    }


    @Override
    public String verificaCadEmpresa(String cnpj) {
        return "";
    }

    @Override
    public List<Empresa> retornaUnidades(String cnpj) {
        return List.of();
    }

    @Override
    public void cadastra(PreparedStatement ps) {

    }
}
