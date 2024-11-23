package org.gsnt.auttech.model.dao;


import org.gsnt.auttech.model.dao.impl.MarcaVeiculoDaoJDBC;

public class DaoFactory {

    public static MarcaVeiculoDao createMarcaVeiculoDao(){
        return new MarcaVeiculoDaoJDBC();
    }
/*
    public static ModeloVeiculoDao createModeloVeiculoDao(){
        return new ModeloVeiculoDaoJDBC();
    }
*/
}
