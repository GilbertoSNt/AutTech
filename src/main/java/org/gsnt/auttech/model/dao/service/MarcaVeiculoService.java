package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.db.DB;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.MarcaVeiculoDao;
import org.gsnt.auttech.model.entities.MarcaVeiculo;


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

}
