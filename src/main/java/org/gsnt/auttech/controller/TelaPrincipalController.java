package org.gsnt.auttech.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.gsnt.auttech.TelaPrincipal;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.service.AgendaService;
import org.gsnt.auttech.model.dao.service.ClienteService;
import org.gsnt.auttech.model.dao.service.OrcamentoService;
import org.gsnt.auttech.model.dao.service.OrdemServicoService;
import org.gsnt.auttech.model.entities.Agenda;
import org.gsnt.auttech.model.entities.Orcamento;
import org.gsnt.auttech.model.entities.OrdemServico;
import org.gsnt.auttech.util.Circulos;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class TelaPrincipalController implements Initializable {

    private AgendaService agendaService;

    protected void setAgendaService(AgendaService agenda){
        this.agendaService = agenda;
    }

    protected ObservableList<Agenda> obsListAgenda;

    @FXML
    private Accordion accServicos;

    @FXML
    protected TitledPane tpAgenda;

    @FXML
    protected TableView tvAgenda;

    @FXML
    protected TableColumn<Agenda, String> tcDia;

    @FXML
    protected TableColumn<Agenda, String> tcHora;

    @FXML
    protected TableColumn<Agenda, String> tcPlaca;

    @FXML
    protected TableColumn<Agenda, String> tcNome;

    @FXML
    protected TableColumn<Agenda, String> tcVeiculo;

    @FXML
    protected TableColumn<Agenda, String> tcDeslocamento;

    @FXML
    protected TableColumn<Agenda, Circulos> tcSocMec;

    @FXML
    protected TableColumn<Agenda, Circulos> tcSocElet;

    @FXML
    protected TableColumn<Agenda, Circulos> tcGuincho;

    @FXML
    protected TableColumn<Agenda, Circulos> tcBuscar;

    @FXML
    protected TableColumn<Agenda, Circulos> tcSocorro;

    @FXML
    protected TableColumn<Agenda, Circulos> tcLevar;

    @FXML
    protected TableColumn<Agenda, Circulos> tcStatus;

    @FXML
    protected TableColumn<Agenda, Circulos> tcServElet;

    @FXML
    protected TableColumn<Agenda, Circulos> tcServMec;

    @FXML
    protected TableColumn<Agenda, Circulos> tcServRev;

    @FXML
    protected TableColumn<Agenda, Circulos> tcServInj;

    @FXML
    protected TableColumn<Agenda, Circulos> tcServPneu;

    @FXML
    protected TableColumn<Agenda, Circulos> tcServOleo;

    @FXML
    protected Button btAgenda;

    @FXML
    protected void btAgendaOnButtonClick() {
        loadView("/org/gsnt/auttech/Agenda.fxml",x->{});
    }

    @FXML
    protected Button btCancAgenda;

    @FXML
    protected Button btReceberVeic;

    @FXML
    protected Button btEnvioSocorro;

    // Inicio da table view(Veículo a serem iniciados)

    private OrdemServicoService ordemServicoService;

    protected void setOrdemServicoService(OrdemServicoService ordem){
        this.ordemServicoService = ordem;
    }

    protected ObservableList<OrdemServico> obsListOrdemServico;

    @FXML
    protected TitledPane tpFuturos;

    @FXML
    protected TableView tvFuturos;

    @FXML
    protected TableColumn<OrdemServico,Integer> tcOs;

    @FXML
    protected TableColumn tcDdVeiculos;

    @FXML
    protected TableColumn<OrdemServico, String> tcPlaca2;

    @FXML
    protected TableColumn<OrdemServico, String> tcModelo2;

    @FXML
    protected TableColumn tcTipoServico;

    @FXML
    protected TableColumn tcMec2;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcElet2;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcInj2;

    @FXML
    protected TableColumn tcCambio2;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcCbAut;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcCbMec;

    @FXML
    protected TableColumn tcFreio2;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcFreioDt;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcFreioTr;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcMotor2;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcRevisao2;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcPneus2;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcOleo2;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcSuspDiant;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcSuspTras;

    @FXML
    protected Button btAbrirOS;

    @FXML
    protected Button btCancOS;

    @FXML
    protected Button btDirTecnico;

    // implementação tableview em orçamento

    private OrcamentoService orcamentoService;

    protected void setOrcamentoService(OrcamentoService orcamento){
        this.orcamentoService = orcamento;
    }

    protected ObservableList<Orcamento> obsListOrcamento;

    @FXML
    protected TitledPane tpEmOrcamento;

    @FXML
    protected TableView tvEmOrcamento;

    @FXML
    protected TableColumn<Orcamento,String> tcPlaca3;

    @FXML
    protected TableColumn<Orcamento,String> tcVeiculo3;

    @FXML
    protected TableColumn tcStatus2;

    @FXML
    protected TableColumn<Orcamento, Circulos> tcCambio3;

    @FXML
    protected TableColumn<Orcamento, Circulos> tcElet3;

    @FXML
    protected TableColumn<Orcamento, Circulos> tcFreio3;

    @FXML
    protected TableColumn<Orcamento, Circulos> tcInjecao3;

    @FXML
    protected TableColumn<Orcamento, Circulos> tcMecanica3;

    @FXML
    protected TableColumn<Orcamento, Circulos> tcPneus3;

    @FXML
    protected TableColumn<Orcamento, Circulos> tcAguardAvaliacao;

    @FXML
    protected TableColumn<Orcamento, String> tcStatusCliente;

    @FXML
    protected Button btAltOrc;

    @FXML
    protected Button btAutrzOrc;

    @FXML
    protected Button btCnclOrc;


    // implementação tableview em serviço

    @FXML
    protected TitledPane tpServicos;

    @FXML
    protected TableView tvServicos;

    @FXML
    protected TableColumn tcPlaca4;

    @FXML
    protected TableColumn tcVeiculo4;

    @FXML
    protected TableColumn tcStatus4;

    @FXML
    protected TableColumn tcCambio4;

    @FXML
    protected TableColumn tcElet4;

    @FXML
    protected TableColumn tcFreio4;

    @FXML
    protected TableColumn tcInjecao4;

    @FXML
    protected TableColumn tcMecanica4;

    @FXML
    protected TableColumn tcPneus4;

    @FXML
    protected TableColumn tcRevisao4;

    @FXML
    protected TableColumn tcLavacao4;

    @FXML
    protected Button btAlteraOS;

    @FXML
    protected Button btCncOS;

    @FXML
    protected Button btFnlzServ;






    // Implementaçao serviços prontos
    @FXML
    protected TitledPane tpProntos;

    @FXML
    protected TableView tvProntos;

    @FXML
    protected TableColumn tcPlaca5;

    @FXML
    protected TableColumn tcVeiculo5;

    @FXML
    protected TableColumn tcCliente5;

    @FXML
    protected TableColumn tcTelefone5;

    @FXML
    protected TableColumn tcStatus5;

    @FXML
    protected Button btFnlzOS;









// restante da tela
    @FXML
    protected Button btClose;

    @FXML
    protected void btCloseButtonClick() {
        System.exit(0);
    }

    @FXML
    protected Button btIconified;

    @FXML
    protected void btIconifiedButtonClick() {
    }


    @FXML
    protected Button btCliente;

    @FXML
    protected void btClienteButtonClick() {
        loadView("/org/gsnt/auttech/TipoPessoa.fxml",x->{});
    }

    @FXML
    protected Button btVeiculo;

    @FXML
    protected void btVeiculoButtonClick() {
        loadView("/org/gsnt/auttech/CadVeiculo.fxml",x->{});
    }

    @FXML
    protected Button btListaClientes;

    @FXML
    protected void btListaClientesButtonClick(){
        try {
            loadView("/org/gsnt/auttech/ListaCliente.fxml", (ListaClienteController cliController) -> {
                cliController.setClienteService(new ClienteService());
                cliController.updateTableView();
            });
        }catch (Exception d){
            System.out.println(d);
        }
    }

    public void updateTableView() {

            setAgendaService(new AgendaService());
        try {
            if (agendaService == null) {
                throw new IllegalStateException("Agenda estava nulo");
            }
            obsListAgenda = FXCollections.observableArrayList(agendaService.findTelaPrincipal());
            tvAgenda.setItems(obsListAgenda);
        }catch (Exception a){
            throw new DbException(a.getMessage());
        }



            setOrdemServicoService(new OrdemServicoService());
        try{
            if(ordemServicoService == null){
                throw new IllegalStateException("Ordem de Serviço Service está nulo");
            }
            obsListOrdemServico = FXCollections.observableArrayList(ordemServicoService.findTelaPrincipal());
            tvFuturos.setItems(obsListOrdemServico);
        }catch (Exception a){
            throw new DbException(a.getMessage());
        }

        setOrcamentoService(new OrcamentoService());
        try{
            if(orcamentoService == null){
                throw new IllegalStateException("Ordem de Serviço Service está nulo");
            }
            obsListOrcamento = FXCollections.observableArrayList(orcamentoService.findByTela());
            tvEmOrcamento.setItems(obsListOrcamento);
        }catch (Exception a){
            throw new DbException(a.getMessage());
        }

    }

    protected void initializeNodes(){

        accordionAgenda();
        accordionSerIniciados();
        accordionOrcamento();

    }




    @Override
    public void initialize(URL url, ResourceBundle rB) {

        updateTableView();
        initializeNodes();
        accServicos.setExpandedPane(tpAgenda);

    }

    private void accordionAgenda(){

        try {

            tcDia.setCellValueFactory(new PropertyValueFactory<Agenda, String>("data"));
            tcHora.setCellValueFactory(new PropertyValueFactory<Agenda, String>("hora"));
            tcNome.setCellValueFactory(new PropertyValueFactory<Agenda, String>("nome"));
            tcPlaca.setCellValueFactory(new PropertyValueFactory<Agenda, String>("placa"));
            tcVeiculo.setCellValueFactory(new PropertyValueFactory<Agenda, String>("veiculo"));
            tcServElet.setCellValueFactory(new PropertyValueFactory<Agenda, Circulos>("eletrico"));
            tcServInj.setCellValueFactory(new PropertyValueFactory<Agenda, Circulos>("injecao"));
            tcServMec.setCellValueFactory(new PropertyValueFactory<Agenda, Circulos>("mecanico"));
            tcServOleo.setCellValueFactory(new PropertyValueFactory<Agenda, Circulos>("trocaOleo"));
            tcServPneu.setCellValueFactory(new PropertyValueFactory<Agenda, Circulos>("pneus"));
            tcServRev.setCellValueFactory(new PropertyValueFactory<Agenda, Circulos>("revisao"));
            tcSocElet.setCellValueFactory(new PropertyValueFactory<Agenda, Circulos>("socEletrico"));
            tcGuincho.setCellValueFactory(new PropertyValueFactory<Agenda, Circulos>("guincho"));
            tcSocMec.setCellValueFactory(new PropertyValueFactory<Agenda, Circulos>("socMecanico"));
            tcBuscar.setCellValueFactory(new PropertyValueFactory<Agenda, Circulos>("buscar"));
            tcLevar.setCellValueFactory(new PropertyValueFactory<Agenda, Circulos>("levar"));
            tcStatus.setCellValueFactory(new PropertyValueFactory<Agenda, Circulos>("status"));

        }

        catch (Exception a){
            System.out.println(a.getMessage()+"  erro no initializeNodes TelaPrincipalController");
        }

    }

    private void accordionSerIniciados(){

        try {
            tcOs.setCellValueFactory(new PropertyValueFactory<OrdemServico, Integer>("numero"));
            tcPlaca2.setCellValueFactory(new PropertyValueFactory<OrdemServico, String>("placa"));
            tcModelo2.setCellValueFactory(new PropertyValueFactory<OrdemServico, String>("modelo"));
            tcElet2.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("sEletrico2"));
            tcInj2.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("sInjecao2"));
            tcCbAut.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("sCamAut2"));
            tcCbMec.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("sCamMec2"));
            tcFreioDt.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("sFreioDt2"));
            tcFreioTr.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("sFreioTr2"));
            tcMotor2.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("sMotor2"));
            tcRevisao2.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("sRevisao2"));
            tcSuspDiant.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("sSuspDt2"));
            tcSuspTras.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("sSuspTr2"));
            tcPneus2.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("sPneus2"));
            tcOleo2.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("sTrOleo2"));

        }

        catch (Exception a){
            System.out.println(a.getMessage()+"  erro no initializeNodes TelaPrincipalController");
        }

    }

    private void accordionOrcamento(){
        /* Integer cod, String placa, String modelo, String statusCliente, Circulos orcCambio2,
         * Circulos orcEletrico2, Circulos orcFreio2, Circulos orcInjecao2, Circulos orcMecanico2,
         * Circulos orcPneu2, Circulos statusOrc2
        */

        tcPlaca3.setCellValueFactory(new PropertyValueFactory<Orcamento,String>("placa"));
        tcVeiculo3.setCellValueFactory(new PropertyValueFactory<Orcamento,String>("modelo"));
        tcCambio3.setCellValueFactory(new PropertyValueFactory<Orcamento,Circulos>("orcCambio2"));
        tcElet3.setCellValueFactory(new PropertyValueFactory<Orcamento,Circulos>("orcEletrico2"));
        tcFreio3.setCellValueFactory(new PropertyValueFactory<Orcamento,Circulos>("orcFreio2"));
        tcInjecao3.setCellValueFactory(new PropertyValueFactory<Orcamento,Circulos>("orcInjecao2"));
        tcMecanica3.setCellValueFactory(new PropertyValueFactory<Orcamento,Circulos>("orcMecanico2"));
        tcPneus3.setCellValueFactory(new PropertyValueFactory<Orcamento,Circulos>("orcPneu2"));
        tcAguardAvaliacao.setCellValueFactory(new PropertyValueFactory<Orcamento,Circulos>("statusOrc2"));
        tcStatusCliente.setCellValueFactory(new PropertyValueFactory<Orcamento,String>("statusCliente2"));

    }



    private synchronized<T> void loadView(String absoluteName, Consumer<T> inicializingAction) {
        try {

            FXMLLoader loader = new FXMLLoader(TelaPrincipal.class.getResource(absoluteName));
            Scene secundaryScene = new Scene(loader.load());

            Stage stage1 = new Stage();
            stage1.setIconified(false);
            stage1.setResizable(false);
            stage1.setTitle("");
            stage1.initStyle(StageStyle.UNDECORATED);
            stage1.initModality(Modality.APPLICATION_MODAL);
            stage1.initOwner(TelaPrincipal.getMainScene().getWindow());
            stage1.setScene(secundaryScene);

            T controller = loader.getController();
            inicializingAction.accept(controller);

            stage1.showAndWait();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }




}
