package org.gsnt.auttech.model.dao;


import org.gsnt.auttech.db.DB;
import org.gsnt.auttech.db.DB2;
import org.gsnt.auttech.model.dao.service.*;


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

    public static AgendaDao agendaDao(){
        try {
            return new AgendaService(DB2.getConnection());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static OrdemServicoDao ordemServicoDao(){
        try {
            return new OrdemServicoService(DB2.getConnection());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static OrcamentoDao orcamentoDao(){
        try {
            return new OrcamentoService(DB2.getConnection());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
