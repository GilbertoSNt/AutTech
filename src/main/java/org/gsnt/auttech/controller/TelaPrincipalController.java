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
import org.gsnt.auttech.model.dao.*;
import org.gsnt.auttech.model.dao.service.ClienteService;
import org.gsnt.auttech.model.dao.service.OrcamentoService;
import org.gsnt.auttech.model.dao.service.OrdemServicoService;
import org.gsnt.auttech.model.entities.Agenda;
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

    private final AgendaDao agendaService = DaoFactory.createAgendaDao();
    private final StatusAtendimentoDao stAtendimento = DaoFactory.createStatusAtendimentoDao();
    private final OrdemServicoDao osServ = DaoFactory.createOrdemServicoDao();
    private final OrcamentoDao orcService = DaoFactory.createOrcamentoDao();

    private ObservableList<Agenda> obsListAgenda;

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
    private Button btEnvioSocorro;

    @FXML
    private void onBtConfirmaEnvioSocorro() {

        if(tvAgenda.getSelectionModel().getSelectedItem() != null) {
            Agenda tt = (Agenda) tvAgenda.getSelectionModel().getSelectedItem();
            Agenda status = agendaService.verStatusAssistencias(tt.getPlaca());


            if (tt.getGuincho() != null || tt.getSocMecanico() != null || tt.getSocEletrico() != null) {
                if (!status.getAssEnvioGuincho()) {
                    Optional<ButtonType> result = Alerts.showConfirmation("Confirmação do envio de guincho / socorro do veículo", "Confirma o envio do guincho / socorro para o veículo " + tt.getPlaca());
                    if (result.get() == ButtonType.OK) {
                        agendaService.saveEnvioGuincho(tt);
                    }
                } else if (status.getAssEnvioGuincho()) {
                    Optional<ButtonType> result = Alerts.showConfirmation("Confirmação do envio de guincho / socorro do veículo", "Confirma o envio do guincho / socorro para o veículo " + tt.getPlaca());
                    if (result.get() == ButtonType.OK) {
                        agendaService.reverteEnvioGuincho(tt);
                    }
                }
            } else {
                Alerts.showAlert("Atenção", "Agendamento não tem registro da necessidade do guinho / socorro para o veículo", null, Alert.AlertType.ERROR);
            }
            updateTableView();
        }else{
            Alerts.showAlert("Confirmação de envio do socorro", "Você deve selecionar uma linha na tabela agenda", null, Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    private Button btEnvioBusca;

    @FXML
    private void onBtConfirmaEnvioBusca(){
        if(tvAgenda.getSelectionModel().getSelectedItem() != null) {
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
            }else{
                Alerts.showAlert("Confirmação de envio do deslocamento", "Você deve selecionar uma linha na tabela agenda", null, Alert.AlertType.INFORMATION);
           }
    }

    @FXML
    private void onClickTableAgenda(){

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


    private ObservableList<StatusAtendimento> obsListOrdemServico;

    @FXML
    private TitledPane tpFuturos;

    @FXML
    private TableView tvFuturos;

    @FXML
    private TableColumn<StatusAtendimento,Integer> tcOs;

    @FXML
    private TableColumn tcDdVeiculos;

    @FXML
    private TableColumn<StatusAtendimento, String> tcPlaca2;

    @FXML
    private TableColumn<StatusAtendimento, String> tcModelo2;

    @FXML
    private TableColumn tcTipoServico;

    @FXML
    private TableColumn tcMec2;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcElet2;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcInj2;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcCambio2;

    @FXML
    private TableColumn tcFreio2;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcFreioDt;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcFreioTr;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcMotor2;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcRevisao2;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcPneus2;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcOleo2;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcSuspDiant;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcSuspTras;

    @FXML
    private Button btAbrirOS;

    @FXML
    private Button btCancOS;

    @FXML
    private void onbtCancelarOs(){

        if(tvFuturos.getSelectionModel().getSelectedItem() != null) {

            StatusAtendimento st =  (StatusAtendimento) tvFuturos.getSelectionModel().getSelectedItem();

            Optional<ButtonType> result = Alerts.showConfirmation("Confirmação", "Realmente deseja cancelar a OS da placa " + st.getPlaca());

            if(result.get() == ButtonType.OK) {

                orcService.recusaOrcamento(st.getCod());
                stAtendimento.cancelaAtendimento(st.getCod());
                osServ.cancelaOrdemServico(st.getCod());

            }
        }else{
            Alerts.showAlert("Erro ", "Você deve selecionar uma linha na tabela ordem de serviço", null, Alert.AlertType.INFORMATION);
        }

        updateTableView();

    }


    @FXML
    private Button btAltOS;

    @FXML
    private void onbtAltOS(){

    }

    @FXML
    private Button btDirecionaOS;

    @FXML
    private void onbtDirecionaOS(){

        try {
            loadView("/org/gsnt/auttech/Direcionamento.fxml", (DirecionamentoController dirCont) -> {
                StatusAtendimento st =  (StatusAtendimento) tvFuturos.getSelectionModel().getSelectedItem();
                dirCont.preencheDadosDir(stAtendimento.stGeralUnico(st.getCod()));
            });
        }catch (Exception d){
            System.out.println(d+" na função onbtDirecionaOS");
        }
    }

















    // implementação tableview em orçamento

    protected ObservableList<StatusAtendimento> obsListOrcamento;

    @FXML
    protected TitledPane tpEmOrcamento;

    @FXML
    protected TableView tvEmOrcamento;

    @FXML
    protected TableColumn<StatusAtendimento,String> tcPlaca3;

    @FXML
    protected TableColumn<StatusAtendimento,String> tcVeiculo3;

    @FXML
    protected TableColumn tcStatus2;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcCambio3;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcElet3;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcMotor3;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcInjecao3;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcMecanica3;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcPneus3;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcAguardAvaliacao;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcStatusCliente;

    @FXML
    private Button btAltOrc;

    @FXML
    private Button btAutrzOrc;

    @FXML
    private Button btCnclOrc;

    @FXML
    private void onbtCnclOrc(){
        if(tvEmOrcamento.getSelectionModel().getSelectedItem() != null) {

            StatusAtendimento st =  (StatusAtendimento) tvFuturos.getSelectionModel().getSelectedItem();

            Optional<ButtonType> result = Alerts.showConfirmation("Confirmação", "Realmente deseja rejeitar orçamento e cancelar a OS da placa " + st.getPlaca());

            if(result.get() == ButtonType.OK) {

                orcService.recusaOrcamento(st.getCod());
                stAtendimento.cancelaAtendimento(st.getCod());
                osServ.cancelaOrdemServico(st.getCod());

                //falta enviar informação para a tela de entrega do orçamento

            }
        }else{
            Alerts.showAlert("Erro ", "Você deve selecionar uma linha na tabela ordem de serviço", null, Alert.AlertType.INFORMATION);
        }

        updateTableView();
    }



    // implementação tableview em serviço

    protected ObservableList<OrdemServico> obsListEmServico;

    @FXML
    protected TitledPane tpServicos;

    @FXML
    protected TableView tvServicos;

    @FXML
    protected TableColumn<StatusAtendimento, String> tcPlaca4;

    @FXML
    protected TableColumn<StatusAtendimento, String> tcVeiculo4;

    @FXML
    protected TableColumn tcStatus4;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcCambio4;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcElet4;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcInjecao4;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcMecanica4;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcMotor4;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcPneus4;

    @FXML
    protected TableColumn<StatusAtendimento, Circulos> tcLavacao4;

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
    private void onbtIconified(){
        Stage stage = (Stage)btIconified.getScene().getWindow();
        stage.setIconified(true);
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
        updateTableView();
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
            System.out.println(d+" na função btListaClientesButtonClick()");
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

        try{

            if(stAtendimento == null || osServ == null || agendaService == null){
                throw new IllegalStateException("Ordem de Serviço Service está nulo");
            }
            //tela agendamento
            obsListAgenda = FXCollections.observableArrayList(agendaService.findTelaPrincipal());
            tvAgenda.setItems(obsListAgenda);
            //tela os sem direcionamento
            obsListOrdemServico = FXCollections.observableArrayList(stAtendimento.statusOrdemServicoTelaSI());
            tvFuturos.setItems(obsListOrdemServico);
            //tela em serviço
            obsListEmServico = FXCollections.observableArrayList(osServ.findTelaPrincipalEmServiço());
            tvServicos.setItems(obsListEmServico);
            //tela principal orçamento
            obsListOrcamento = FXCollections.observableArrayList(stAtendimento.statusOrcamentoTela());
            tvEmOrcamento.setItems(obsListOrcamento);

        }catch (Exception a){
            throw new DbException("Tela principal - updateTableView "+a.getMessage());
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
            tcOs.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Integer>("cod"));
            tcPlaca2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, String>("placa"));
            tcModelo2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, String>("veiculo"));
            tcElet2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("cirEletrico"));
            tcInj2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("cirInjecao"));
            tcCambio2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("cirCambio"));
            tcFreioDt.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("cirFreioDt"));
            tcFreioTr.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("cirFreioTr"));
            tcMotor2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("cirMotor"));
            tcRevisao2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("cirRevisao"));
            tcSuspDiant.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("cirSuspDt"));
            tcSuspTras.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("cirSuspTr"));
            tcPneus2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("cirPneus"));
            tcOleo2.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("cirTrOleo"));

        }
        catch (Exception a){
            System.out.println(a.getMessage()+"  erro no initializeNodes TelaPrincipalController");
        }

    }

    private void accordionOrcamento(){

        tcPlaca3.setCellValueFactory(new PropertyValueFactory<StatusAtendimento,String>("placa"));
        tcVeiculo3.setCellValueFactory(new PropertyValueFactory<StatusAtendimento,String>("veiculo"));
        tcCambio3.setCellValueFactory(new PropertyValueFactory<StatusAtendimento,Circulos>("cirCambio"));
        tcElet3.setCellValueFactory(new PropertyValueFactory<StatusAtendimento,Circulos>("cirEletrico"));
        tcMotor3.setCellValueFactory(new PropertyValueFactory<StatusAtendimento,Circulos>("cirMotor"));
        tcInjecao3.setCellValueFactory(new PropertyValueFactory<StatusAtendimento,Circulos>("cirInjecao"));
        tcMecanica3.setCellValueFactory(new PropertyValueFactory<StatusAtendimento,Circulos>("mecanico1"));
        tcPneus3.setCellValueFactory(new PropertyValueFactory<StatusAtendimento,Circulos>("cirPneus"));
        tcAguardAvaliacao.setCellValueFactory(new PropertyValueFactory<StatusAtendimento,Circulos>("montOrc"));
        tcStatusCliente.setCellValueFactory(new PropertyValueFactory<StatusAtendimento,Circulos>("stCliente"));

    }

    private void accordionEmServico(){

        tcPlaca4.setCellValueFactory(new PropertyValueFactory<StatusAtendimento,String>("placa"));
        tcVeiculo4.setCellValueFactory(new PropertyValueFactory<StatusAtendimento,String>("modelo"));
        tcCambio4.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("cirCambio"));
        tcElet4.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("cirEletrico"));
        tcInjecao4.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("cirInjecao"));
        tcMecanica4.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("mecanico1"));
        tcMotor4.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("cirMotor"));
        tcPneus4.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("cirPneus"));
        tcLavacao4.setCellValueFactory(new PropertyValueFactory<StatusAtendimento, Circulos>("lavacao1"));
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
