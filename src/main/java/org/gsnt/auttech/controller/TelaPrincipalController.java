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
import org.gsnt.auttech.model.dao.AgendaDao;
import org.gsnt.auttech.model.dao.DaoFactory;
import org.gsnt.auttech.model.dao.service.ClienteService;
import org.gsnt.auttech.model.dao.service.OrcamentoService;
import org.gsnt.auttech.model.dao.service.OrdemServicoService;
import org.gsnt.auttech.model.entities.Agenda;
import org.gsnt.auttech.model.entities.Orcamento;
import org.gsnt.auttech.model.entities.OrdemServico;
import org.gsnt.auttech.model.entities.StatusAtendimento;
import org.gsnt.auttech.util.Alerts;
import org.gsnt.auttech.util.Circulos;


import java.io.IOException;
import java.net.URL;

import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class TelaPrincipalController implements Initializable {

    AgendaDao agendaService = DaoFactory.createAgendaDao();

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
    protected void onBtAgenda() {
        loadView("/org/gsnt/auttech/Agenda.fxml",x->{});
        updateTableView();
    }

    @FXML
    protected Button btAlteraAgenda;

    @FXML
    protected void onBtAlteraAgenda(){

        if(tvAgenda.getSelectionModel().getSelectedItem() != null) {
            Agenda tt = (Agenda) tvAgenda.getSelectionModel().getSelectedItem();
            Optional<ButtonType> result = Alerts.showConfirmation("Confirmação de alteração", "Realmente deseja alterar o agendamento da placa " + tt.getPlaca());
            if(result.get() == ButtonType.OK) {
                loadView("/org/gsnt/auttech/Agenda.fxml", (AgendaController agendaController) -> {
                    agendaController.preencheDados(tt.getPlaca(), 1);
                });
            }
        }else{
            Alerts.showAlert("Altera o agendamento", "Você deve selecionar uma linha na tabela agenda", null, Alert.AlertType.INFORMATION);
        }
        updateTableView();
    }

    @FXML
    protected Button btCancAgenda;

    @FXML
    protected void onBtCancelarAgenda(){

        if(tvAgenda.getSelectionModel().getSelectedItem() != null) {
            Agenda tt = (Agenda) tvAgenda.getSelectionModel().getSelectedItem();
            Optional<ButtonType> result = Alerts.showConfirmation("Confirmação de exclusão", "Realmente deseja excluir o agendamento da placa "+tt.getPlaca());
                if(result.get() == ButtonType.OK) {
                    agendaService.excluiAgenda(tt);
                    updateTableView();
                }
        }else{
            Alerts.showAlert("Cancelar agendamento", "Você deve selecionar uma linha na tabela agenda", null, Alert.AlertType.INFORMATION);
        }

    }

    @FXML
    protected Button btReceberVeic;

    @FXML
    protected void onBtReceberVeic(){

        if(tvAgenda.getSelectionModel().getSelectedItem() != null) {
            Agenda tt = (Agenda) tvAgenda.getSelectionModel().getSelectedItem();
            Agenda dado = agendaService.findByPlacaData(tt.getPlaca());
            Optional<ButtonType> result = Alerts.showConfirmation("Confirmação de abertura de O.S.", "Realmente deseja abrir ordem de serviço para a placa "+tt.getPlaca());
            if(result.get() == ButtonType.OK) {
                try {loadView("/org/gsnt/auttech/CriaOs.fxml", (CriaOsController criaOsController) -> {
                     criaOsController.preencheDadosAgenda(dado);
  // ativar aqui novamente                      agendaService.excluiAgenda(tt);
                      //  updateTableView();
                    });}
                    catch(Exception d){
                        System.out.println(d);
                    }
             }else{
                 Alerts.showAlert("Confirmação de abertura de O.S.", "Você deve selecionar uma linha na tabela agenda", null, Alert.AlertType.INFORMATION);
             }
        }else{
            Alerts.showAlert("Confirmação de abertura de O.S.", "Você deve selecionar uma linha na tabela agenda", null, Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    protected Button btEnvioSocorro;

    @FXML
    protected void onBtConfirmaEnvioSocorro(){

        Agenda tt = (Agenda) tvAgenda.getSelectionModel().getSelectedItem();
        Agenda status = agendaService.verStatusAssistencias(tt.getPlaca());

        if(tt.getGuincho() != null || tt.getSocMecanico() != null || tt.getSocEletrico() != null){
            if(!status.getAssEnvioGuincho()) {
                Optional<ButtonType> result = Alerts.showConfirmation("Confirmação do envio de guincho / socorro do veículo", "Confirma o envio do guincho / socorro para o veículo " + tt.getPlaca());
                if (result.get() == ButtonType.OK) {
                    agendaService.saveEnvioGuincho(tt);
                }
            }else if(status.getAssEnvioGuincho()){
                Optional<ButtonType> result = Alerts.showConfirmation("Confirmação do envio de guincho / socorro do veículo", "Confirma o envio do guincho / socorro para o veículo " + tt.getPlaca());
                if (result.get() == ButtonType.OK) {
                    agendaService.reverteEnvioGuincho(tt);
                }
            }
        }
        else{
            Alerts.showAlert("Atenção","Agendamento não tem registro da necessidade do guinho / socorro para o veículo",null, Alert.AlertType.ERROR);
        }
        updateTableView();
    }

    @FXML
    protected Button btEnvioBusca;

    @FXML
    protected void onBtConfirmaEnvioBusca(){

        Agenda tt = (Agenda) tvAgenda.getSelectionModel().getSelectedItem();
        Agenda status = agendaService.verStatusAssistencias(tt.getPlaca());
        if(tt.getBuscar() != null) {
            if (!status.getAssEnvioDeslocamento()) {
                Optional<ButtonType> result = Alerts.showConfirmation("Confirmação da Mudança do status do recolhimento do veículo", "Confirma o novo status da equipe de recolhimento para o veículo " + tt.getPlaca());
                if (result.get() == ButtonType.OK) {
                    agendaService.saveEnvioRecolhimento(tt);
                }
            } else if(status.getAssEnvioDeslocamento()) {
                Optional<ButtonType> result = Alerts.showConfirmation("Confirmação da Mudança do status do recolhimento do veículo", "Confirma o novo status da equipe de recolhimento para o veículo "+tt.getPlaca());
                if(result.get() == ButtonType.OK) {
                    agendaService.reverterEnvioRecolhimento(tt);
                }
            }
        }
        else{
            Alerts.showAlert("Atenção","Agendamento não tem registro da necessidade de buscar o veículo",null, Alert.AlertType.ERROR);
        }
        updateTableView();

    }

    @FXML
    protected void onClickTableAgenda(){

        if (tvAgenda.getSelectionModel().getSelectedItem() != null) {
            Agenda tt = (Agenda) tvAgenda.getSelectionModel().getSelectedItem();

            Agenda status = agendaService.verStatusAssistencias(tt.getPlaca());

            if (tt.getGuincho() != null || tt.getSocMecanico() != null || tt.getSocEletrico() != null) {
                btEnvioSocorro.setDisable(false);
            } else if (tt.getGuincho() == null || tt.getSocMecanico() == null || tt.getSocEletrico() == null) {
                btEnvioSocorro.setDisable(true);
            }

            if (tt.getLevar() != null || tt.getBuscar() != null) {
                btEnvioBusca.setDisable(false);
            } else if (tt.getLevar() == null || tt.getBuscar() == null) {
                btEnvioBusca.setDisable(true);
            }

            if (status.getAssEnvioGuincho()) {
                btEnvioSocorro.setText("Reverter envio socorro");
            } else if (!status.getAssEnvioGuincho()) {
                btEnvioSocorro.setText("Confirma envio do socorro");
            }

            if (status.getAssEnvioDeslocamento()) {
                btEnvioBusca.setText("Reverter busca veículo");
            } else if (!status.getAssEnvioDeslocamento()) {
                btEnvioBusca.setText("Confirma a busca veículo");
            }
        }
    }

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
    protected TableColumn<StatusAtendimento,Integer> tcOs;

    @FXML
    protected TableColumn tcDdVeiculos;

    @FXML
    protected TableColumn<StatusAtendimento, String> tcPlaca2;

    @FXML
    protected TableColumn<StatusAtendimento, String> tcModelo2;

    @FXML
    protected TableColumn tcTipoServico;

    @FXML
    protected TableColumn tcMec2;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcElet2;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcInj2;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcCambio2;

    @FXML
    protected TableColumn tcFreio2;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcFreioDt;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcFreioTr;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcMotor2;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcRevisao2;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcPneus2;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcOleo2;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcSuspDiant;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcSuspTras;

    @FXML
    protected Button btAbrirOS;

    @FXML
    protected Button btCancOS;

    @FXML
    protected Button btDirTecnico;

    @FXML
    protected Button btOsSemOrc;


















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

    protected ObservableList<OrdemServico> obsListEmServico;

    @FXML
    protected TitledPane tpServicos;

    @FXML
    protected TableView tvServicos;

    @FXML
    protected TableColumn<OrdemServico, String> tcPlaca4;

    @FXML
    protected TableColumn<OrdemServico, String> tcVeiculo4;

    @FXML
    protected TableColumn tcStatus4;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcCambio4;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcElet4;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcInjecao4;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcMecanica4;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcMotor4;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcPneus4;

    @FXML
    protected TableColumn<OrdemServico, Circulos> tcLavacao4;

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
    protected Button btAbrirOS2;

    @FXML
    protected void onbtAbrirOS() {
        loadView("/org/gsnt/auttech/CriaOs.fxml",x->{});
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

    @FXML
    protected Button btCadProfissionais;

    @FXML
    protected void onbtCadProfissionais(){
        loadView("/org/gsnt/auttech/CadFuncionarios.fxml",x->{});
    }

    @FXML
    protected Button btListarProfissionais;

    @FXML
    protected void onbtListarProfissionais(){

    }

    public void updateTableView() {

        try {
            if (agendaService == null) {
                throw new IllegalStateException("Agenda estava nulo");
            }
            obsListAgenda = FXCollections.observableArrayList(agendaService.findTelaPrincipal());
            tvAgenda.setItems(obsListAgenda);
        }catch (Exception a){
            throw new DbException(a.getMessage()+" updateTableView - Tela Agenda");
        }


            setOrdemServicoService(new OrdemServicoService());
        try{
            if(ordemServicoService == null){
                throw new IllegalStateException("Ordem de Serviço Service está nulo");
            }
            obsListOrdemServico = FXCollections.observableArrayList(ordemServicoService.findTelaPrincipal());
            tvFuturos.setItems(obsListOrdemServico);
            obsListEmServico = FXCollections.observableArrayList(ordemServicoService.findTelaPrincipalEmServiço());
            tvServicos.setItems(obsListEmServico);


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
        accordionEmServico();

    }

    @Override
    public void initialize(URL url, ResourceBundle rB) {

        updateTableView();
        initializeNodes();
        accServicos.setExpandedPane(tpAgenda);

    }

    private void accordionAgenda(){

        try {

            tcDia.setCellValueFactory(new PropertyValueFactory<Agenda, String>("dataAgenda"));
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
            tcOs.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Integer>("codOs"));
            tcPlaca2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, String>("placa"));
            tcModelo2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, String>("veiculo"));
            tcElet2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("sEletrico1"));
            tcInj2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("sInjecao1"));
            tcCambio2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("sCambio1"));
            tcFreioDt.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("sFreioDt1"));
            tcFreioTr.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("sFreioTr1"));
            tcMotor2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("sMotor1"));
            tcRevisao2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("sRevisao1"));
            tcSuspDiant.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("sSuspDt1"));
            tcSuspTras.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("sSuspTr1"));
            tcPneus2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("sPneus1"));
            tcOleo2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("sTrOleo1"));

        }
        catch (Exception a){
            System.out.println(a.getMessage()+"  erro no initializeNodes TelaPrincipalController");
        }

    }

    private void accordionOrcamento(){

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

    private void accordionEmServico(){

        tcPlaca4.setCellValueFactory(new PropertyValueFactory<OrdemServico,String>("placa"));
        tcVeiculo4.setCellValueFactory(new PropertyValueFactory<OrdemServico,String>("modelo"));
        tcCambio4.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("sCamMec2"));
        tcElet4.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("sEletrico2"));
        tcInjecao4.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("sInjecao2"));
        tcMecanica4.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("mecanico1"));
        tcMotor4.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("sMotor2"));
        tcPneus4.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("sPneus2"));
        tcLavacao4.setCellValueFactory(new PropertyValueFactory<OrdemServico, Circulos>("lavacao1"));
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
