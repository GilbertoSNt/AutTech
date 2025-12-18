package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.db.DBLocal;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.DirecionadosDao;
import org.gsnt.auttech.model.entities.Direcionados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirecionadosService implements DirecionadosDao {

    private Connection conn;

    public DirecionadosService(Connection conn){
        this.conn = conn;
    }

    @Override
    public Integer saveDirecionados(Direcionados dir) {
        return 0;
    }

    @Override
    public Boolean excluiDirecionados(Integer cod) {
        return null;
    }

    @Override
    public Boolean editDirecionados(Integer cod) {
        return null;
    }

    /***
     * listaServico Lista de serviço por técnico
     *
     * @return List = Lista de serviços em que todos os  profissionais estão envolvidos.
     * @author Gilberto da S. Neto
     * @version 1.0
     */

    @Override
    public List<Direcionados> listaServico() {

        List<Direcionados> drc = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("SELECT * FROM nmsrvcprfssnl");
            rs = st.executeQuery();
            while(rs.next()){
                drc.add(new Direcionados(rs.getString("apelido"), rs.getInt("total")));
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" DirecionadosService - listaServiço");
        }
        finally {
            DBLocal.closeResultSet(rs);
            DBLocal.closeStatement(st);
        }
        return drc;
    }

    /***
     * listaServPorFuncionarios Lista detalhada dos serviços enviados para o técnico
     *
     * @param cod = número do técnico
     * @return List = Lista de serviços em que o profissional está envolvido.
     * @author Gilberto da S. Neto
     * @version 1.0
     */

    @Override
    public List<Direcionados> listaServPorFuncionarios(Integer cod) {

        //lista 0s serviços de um unico profissional

        List<Direcionados> drc = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement(" SELECT placa," +
                    " tmpprvst as tempo," +
                    " rdmtndmnt as ordem" +
                    " from tbocupcprfssnl" +
                    " where" +
                    " codprof = ?" +
                    " order by rdmtndmnt");
            st.setInt(1,cod);
            rs = st.executeQuery();

            while(rs.next()){

                drc.add(new Direcionados(rs.getString("placa"), rs.getString("tempo"), rs.getInt("ordem")));
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" DirecionadosService - listaServPorFuncionarios");
        }
        finally {
            DBLocal.closeResultSet(rs);
            DBLocal.closeStatement(st);
        }

        return drc;

    }

    @Override
    public List<String> envio(List<String> enviados) {

        return List.of();
    }


}
