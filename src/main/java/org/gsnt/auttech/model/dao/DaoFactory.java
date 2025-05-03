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

    public static AgendaDao createAgendaDao(){
        try {
            return new AgendaService(DB2.getConnection());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static OrdemServicoDao createOrdemServicoDao(){
        try {
            return new OrdemServicoService(DB2.getConnection());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static OrcamentoDao createOrcamentoDao(){
        try {
            return new OrcamentoService(DB2.getConnection());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static VeiculoDao createVeiculoDao(){
        try {
            return new VeiculoService(DB2.getConnection()) {};

        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static VeiculoDao createVeiculoDaoGeral(){
        try {
            return new VeiculoService(DB.getConnection()) {};

        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static EnderecoDao createEnderecoDao(){
        try {
            return new EnderecoService(DB2.getConnection()) {};

        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static FuncionarioDao createFuncionarioDao(){
        try {
            return new FuncionarioService(DB2.getConnection()) {};

        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static EmailDao createEmailDao(){
        try {
            return new EmailService(DB2.getConnection()) {};

        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }


}
