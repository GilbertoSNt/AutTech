package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.db.DB2;
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

    @Override
    public List<Direcionados> listaServico() {

        List<Direcionados> drc = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("SELECT * FROM public.nmsrvcprfssnl");
            rs = st.executeQuery();

            while(rs.next()){

                drc.add(new Direcionados(rs.getString("apelido"), rs.getInt("total")));

            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage()+" DirecionadosService - listaServiço");
        }
        finally {
            DB2.closeResultSet(rs);
            DB2.closeStatement(st);
        }

        return drc;

    }

    @Override
    public List<Direcionados> listaServPorFuncionarios(Integer cod) {

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
            DB2.closeResultSet(rs);
            DB2.closeStatement(st);
        }

        return drc;

    }
}
