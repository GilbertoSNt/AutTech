package org.gsnt.auttech.model.dao.impl;

import org.gsnt.auttech.model.entities.ModeloVeiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ModeloVeiculoDaoJDBC implements org.gsnt.auttech.model.dao.ModeloVeiculoDao {

    private Connection conn;


    public ModeloVeiculoDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public ModeloVeiculo findById(Integer id) {
        return null;
    }

    @Override
    public List<ModeloVeiculo> findAll() {
        return List.of();
    }

    @Override
    public List<ModeloVeiculo> findByIdMarca(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        /*
        try{
            st = conn.prepareStatement("select * from modelo where marca =  <<<<");
            st.setInt(1,id);
            rs = st.executeQuery();
            while (rs.next()){

            }

            if (){

            }
            return null;

        }
        catch (SQLException e){

        }*/

        return List.of();
    }
}
