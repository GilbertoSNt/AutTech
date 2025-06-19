package org.gsnt.auttech.model.dao.service;

import org.gsnt.auttech.model.dao.DirecionadosDao;
import org.gsnt.auttech.model.entities.Direcionados;

import java.sql.Connection;

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

}
