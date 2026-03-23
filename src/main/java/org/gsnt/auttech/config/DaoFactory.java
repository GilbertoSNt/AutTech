package org.gsnt.auttech.config;


import org.gsnt.auttech.agenda.AgendaDao;
import org.gsnt.auttech.agenda.AgendaService;
import org.gsnt.auttech.cliente.ClienteDao;
import org.gsnt.auttech.cliente.ClienteService;
import org.gsnt.auttech.config.db.DBOn;
import org.gsnt.auttech.config.db.DBLocal;
import org.gsnt.auttech.config.db.DBSttOn;
import org.gsnt.auttech.direcionamento.ProfServDao;
import org.gsnt.auttech.direcionamento.ProfServService;
import org.gsnt.auttech.email.EmailDao;
import org.gsnt.auttech.email.EmailService;
import org.gsnt.auttech.endereco.EnderecoDao;
import org.gsnt.auttech.endereco.EnderecoService;
import org.gsnt.auttech.funcionario.FuncionarioService;
import org.gsnt.auttech.inicio.IniDAO;
import org.gsnt.auttech.inicio.IniService;
import org.gsnt.auttech.marca.MarcaVeiculoDao;
import org.gsnt.auttech.marca.MarcaVeiculoService;
import org.gsnt.auttech.model.dao.FuncionarioDao;
import org.gsnt.auttech.config.seg.SessionUserDao;
import org.gsnt.auttech.config.seg.SessionUserService;
import org.gsnt.auttech.modelo.ModeloVeiculoDao;
import org.gsnt.auttech.modelo.ModeloVeiculoService;
import org.gsnt.auttech.orcamento.Orcamento;
import org.gsnt.auttech.os.OrdemServicoDao;
import org.gsnt.auttech.os.OrdemServicoService;
import org.gsnt.auttech.status.StatusAtendimentoDao;
import org.gsnt.auttech.status.StatusAtendimentoService;
import org.gsnt.auttech.veiculo.VeiculoDao;
import org.gsnt.auttech.veiculo.VeiculoService;


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

    public static Orcamento.OrcamentoDao createOrcamentoDao() {
        try {
            return new Orcamento.OrcamentoService(DBLocal.getConnection());
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
            return new StatusAtendimentoService(DBLocal.getConnection(), DBSttOn.getConnection()) {
            };
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ProfServDao createDirecionadosDao(){
        try {
            return new ProfServService(DBLocal.getConnection()) {};
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    public static SessionUserDao createSessionUserDao() {
        try {
            return new SessionUserService(DBLocal.getConnection());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


}
