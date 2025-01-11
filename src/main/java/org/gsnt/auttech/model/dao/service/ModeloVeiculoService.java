package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.db.DB;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.entities.ModeloVeiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModeloVeiculoService implements org.gsnt.auttech.model.dao.ModeloVeiculoDao {

    private Connection conn;


    public ModeloVeiculoService(Connection conn){
        this.conn = conn;
    }

    @Override
    public ModeloVeiculo findById(int id) {
        return null;
    }


    @Override
    public List<ModeloVeiculo> findByIdMarca(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<ModeloVeiculo> list = new ArrayList<>();

        try{
            st = conn.prepareStatement("select cod,modelo from modelo where marca = ? and status = false order by modelo");
            st.setInt(1,id);
            rs = st.executeQuery();
            while (rs.next()){
                list.add(new ModeloVeiculo(Integer.valueOf(rs.getInt("cod")), rs.getString("modelo")));
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
