package org.gsnt.auttech.model.dao.impl;

import org.gsnt.auttech.model.dao.MarcaVeiculoDao;
import org.gsnt.auttech.model.entities.MarcaVeiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class MarcaVeiculoDaoJDBC implements MarcaVeiculoDao {

    private Connection conn;

    public MarcaVeiculoDaoJDBC(){};

    public MarcaVeiculoDaoJDBC(Connection conn){
        this.conn = conn;
    }


    public List<MarcaVeiculo> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        return List.of();
    }

}
