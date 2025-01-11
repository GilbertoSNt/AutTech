package org.gsnt.auttech.model.dao;


import org.gsnt.auttech.db.DB;
import org.gsnt.auttech.db.DB2;
import org.gsnt.auttech.model.dao.service.ClienteService;
import org.gsnt.auttech.model.dao.service.MarcaVeiculoService;
import org.gsnt.auttech.model.dao.service.ModeloVeiculoService;

public class DaoFactory {

    public static MarcaVeiculoDao createMarcaVeiculoDao(){
        try {
            return new MarcaVeiculoService(DB.getConnection());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public static ModeloVeiculoDao createModeloVeiculoDao(){

        try {
            return new ModeloVeiculoService(DB.getConnection());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public static ClienteDao createClienteDao(){

        try {
            return new ClienteService(DB2.getConnection());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

}
