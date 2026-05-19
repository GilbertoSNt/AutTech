package org.gsnt.auttech.primacesso;

import org.gsnt.auttech.config.db.DBPrimario;
import org.gsnt.auttech.entitiesgenerics.Empresa;
import org.gsnt.auttech.util.ExceptionGenerics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PrimAcessoService implements PrimAcessoDao {

    private Connection conn;

    public PrimAcessoService(Connection conn){
        this.conn = conn;
    }


    /**
     * @param cnpj
     * @return resultset com nome e status
     */
    @Override
    public ResultSet verificaCadEmpresa(String cnpj) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            stmt = conn.prepareStatement("select * from public.fn_cliente_por_cnpj(?)");
            stmt.setString(1,cnpj);
            rs = stmt.executeQuery();
            return rs;

        }catch (SQLException e){
            throw new ExceptionGenerics(e.getMessage()+"PrimAcessoService = Verifica cnpj cad empresa");
        }finally {
            DBPrimario.closeResultSet(rs);
            DBPrimario.closeStatement(stmt);
        }

    }

    /**
     * @param cpf
     * @return resultset com nome e status
     */
    @Override
    public ResultSet verificaCadFisico(String cpf) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            stmt = conn.prepareStatement("select * from public.fn_cliente_por_cpf(?)");
            stmt.setString(1,cpf);
            rs = stmt.executeQuery();
            return rs;

        }catch (SQLException e){
            throw new ExceptionGenerics(e.getMessage()+"PrimAcessoService = Verifica cpf cad empresa ");
        }finally {
            DBPrimario.closeResultSet(rs);
            DBPrimario.closeStatement(stmt);
        }
    }


    /**
     *
     * @param cnpj
     * @return List de empresas filiais
     */
    @Override
    public List<Empresa> retornaUnidades(String cnpj) {
        return List.of();
    }

    /**
     *
     * Cadastra um usuário novo
     *
     * @param ps
     */
    @Override
    public void cadastra(PreparedStatement ps) {

    }



}
