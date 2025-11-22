package org.gsnt.auttech.model.dao;


import org.gsnt.auttech.db.DBOn;
import org.gsnt.auttech.db.DBLocal;
import org.gsnt.auttech.model.dao.service.*;


public class DaoFactory {

    public static MarcaVeiculoDao createMarcaVeiculoDao() {
        try {
            return new MarcaVeiculoService(DBOn.getConnection());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public static ModeloVeiculoDao createModeloVeiculoDao() {

        try {
            return new ModeloVeiculoService(DBOn.getConnection());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public static ClienteDao createClienteDao() {

        try {
            return new ClienteService(DBLocal.getConnection());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public static AgendaDao createAgendaDao() {
        try {
            return new AgendaService(DBLocal.getConnection());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static OrdemServicoDao createOrdemServicoDao() {
        try {
            return new OrdemServicoService(DBLocal.getConnection());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static OrcamentoDao createOrcamentoDao() {
        try {
            return new OrcamentoService(DBLocal.getConnection());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static VeiculoDao createVeiculoDao() {
        try {
            return new VeiculoService(DBLocal.getConnection()) {
            };

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static VeiculoDao createVeiculoDaoGeral() {
        try {
            return new VeiculoService(DBOn.getConnection()) {
            };

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static IniDAO createIniDao() {
        try {
            return new IniService(DBOn.getConnection()) {
            };

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static EnderecoDao createEnderecoDao() {
        try {
            return new EnderecoService(DBLocal.getConnection()) {
            };

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static FuncionarioDao createFuncionarioDao() {
        try {
            return new FuncionarioService(DBLocal.getConnection()) {
            };

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static EmailDao createEmailDao() {
        try {
            return new EmailService(DBLocal.getConnection()) {
            };
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static StatusAtendimentoDao createStatusAtendimentoDao() {
        try {
            return new StatusAtendimentoService(DBLocal.getConnection()) {
            };
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static DirecionadosDao createDirecionadosDao(){
        try {
            return new DirecionadosService(DBLocal.getConnection()) {};
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static LoginDAO createloginDao() {
        try {
            return new LoginService(DBLocal.getConnection());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



}
