package org.gsnt.auttech.model.dao;


import org.gsnt.auttech.db.DB;
import org.gsnt.auttech.db.DB2;
import org.gsnt.auttech.model.dao.impl.ClienteDaoJDBC;
import org.gsnt.auttech.model.dao.impl.MarcaVeiculoDaoJDBC;
import org.gsnt.auttech.model.dao.impl.ModeloVeiculoDaoJDBC;

import java.sql.SQLException;

public class DaoFactory {

    public static MarcaVeiculoDao createMarcaVeiculoDao(){
        try {
            return new MarcaVeiculoDaoJDBC(DB.getConnection());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public static ModeloVeiculoDao createModeloVeiculoDao(){

        try {
            return new ModeloVeiculoDaoJDBC(DB.getConnection());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public static ClienteDao createClienteDao(){

        try {
            return new ClienteDaoJDBC(DB2.getConnection());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

}
