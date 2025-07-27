package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.db.DB;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.MarcaVeiculoDao;
import org.gsnt.auttech.model.entities.entitiesgenerics.MarcaVeiculo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarcaVeiculoService implements MarcaVeiculoDao {

    private Connection conn;



    public MarcaVeiculoService(Connection conn){
        this.conn = conn;
    }


    public List<MarcaVeiculo> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<MarcaVeiculo> list = new ArrayList<>();
        try{
            st = conn.prepareStatement("select cod, nomemarca from marcacarro where status = true order by nomemarca");
            rs = st.executeQuery();

                while(rs.next()){
                list.add(new MarcaVeiculo(rs.getInt("COD"), rs.getString("nomemarca")));
                }

        }
        catch (SQLException a){
            throw new DbException(a.getMessage());
        }
        finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return list;
    }

    @Override
    public Integer findIdByMarca(String nomemarca) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("select cod from marcacarro where nomemarca = ? ");
            st.setString(1, nomemarca);
            rs = st.executeQuery();
            rs.next();
            return rs.getInt("cod");

        }
        catch (SQLException a){
            throw new DbException(a.getMessage());
        }
        finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }


    }

    @Override
    public String findMarcaById(Integer cod) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("select nomemarca  from marcacarro where cod = ? ");
            st.setInt(1, cod);
            rs = st.executeQuery();
            rs.next();
            return rs.getString("nomemarca");

        }
        catch (SQLException a){
            throw new DbException(a.getMessage());
        }
        finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }


}
