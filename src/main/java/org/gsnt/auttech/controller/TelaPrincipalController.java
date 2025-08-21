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
import org.gsnt.auttech.model.entities.Agenda;
import org.gsnt.auttech.model.entities.OrdemServico;
import org.gsnt.auttech.model.entities.StatusAtendimento;
import org.gsnt.auttech.model.entities.Usuario;
import org.gsnt.auttech.util.Alerts;
import org.gsnt.auttech.util.Circulos;
import org.gsnt.auttech.util.LogTxt;

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
    private LogTxt log = new LogTxt();

    private ObservableList<Agenda> obsListAgenda;

    @FXML
    private Accordion accServicos;

    @FXML
    private TitledPane tpAgenda;

    @FXML
    private TableView tvAgenda;

    @FXML
    private Label lblUser;

    @FXML
    private TableColumn<Agenda, String> tcDia;

    @FXML
    private TableColumn<Agenda, String> tcHora;

    @FXML
    private TableColumn<Agenda, String> tcPlaca;

    @FXML
    private TableColumn<Agenda, String> tcNome;

    @FXML
    private TableColumn<Agenda, String> tcVeiculo;

    @FXML
    private TableColumn<Agenda, String> tcDeslocamento;

    @FXML
    private TableColumn<Agenda, Circulos> tcSocMec;

    @FXML
    private TableColumn<Agenda, Circulos> tcSocElet;

    @FXML
    private TableColumn<Agenda, Circulos> tcGuincho;

    @FXML
    private TableColumn<Agenda, Circulos> tcBuscar;

    @FXML
    private TableColumn<Agenda, Circulos> tcSocorro;

    @FXML
    private TableColumn<Agenda, Circulos> tcLevar;

    @FXML
    private TableColumn<Agenda, Circulos> tcStatus;

    @FXML
    private TableColumn<Agenda, Circulos> tcServElet;

    @FXML
    private TableColumn<Agenda, Circulos> tcServMec;

    @FXML
    private TableColumn<Agenda, Circulos> tcServRev;

    @FXML
    private TableColumn<Agenda, Circulos> tcServInj;

    @FXML
    private TableColumn<Agenda, Circulos> tcServPneu;

    @FXML
    private TableColumn<Agenda, Circulos> tcServOleo;

    @FXML
    private Button btAgenda;

    @FXML
    private void onBtAgenda() {
        loadView("/org/gsnt/auttech/Agenda.fxml",x->{});
        updateTableView();
    }

    @FXML
    private Button btAlteraAgenda;

    @FXML
    private void onBtAlteraAgenda(){

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
    private Button btCancAgenda;

    @FXML
    private void onBtCancelarAgenda(){

        if(tvAgenda.getSelectionModel().getSelectedItem() != null) {
            Agenda tt = (Agenda) tvAgenda.getSelectionModel().getSelectedItem();
            Optional<ButtonType> result = Alerts.showConfirmation("Confirmação de exclusão", "Realmente deseja excluir o agendamento da placa "+tt.getPlaca());
                if(result.get() == ButtonType.OK) {
                    agendaService.excluiAgenda(tt);
                    updateTableView();
                    log.escreveLog(Usuario.getUser(),"Cancelou agendamento para placa "+tt.getPlaca());
                }
        }else{
            Alerts.showAlert("Cancelar agendamento", "Você deve selecionar uma linha na tabela agenda", null, Alert.AlertType.INFORMATION);
        }

    }

    @FXML
    private Button btReceberVeic;

    @FXML
    private void onBtReceberVeic(){

        if(tvAgenda.getSelectionModel().getSelectedItem() != null) {
            Agenda tt = (Agenda) tvAgenda.getSelectionModel().getSelectedItem();
            Agenda dado = agendaService.findByPlacaData(tt.getPlaca());
            Optional<ButtonType> result = Alerts.showConfirmation("Confirmação de abertura de O.S.", "Realmente deseja abrir ordem de serviço para a placa "+tt.getPlaca());
            if(result.get() == ButtonType.OK) {
                try {loadView("/org/gsnt/auttech/CriaOs.fxml", (CriaOsController criaOsController) -> {
                     criaOsController.preencheDadosAgenda(dado);
  // ativar aqui novamente                      agendaService.excluiAgenda(tt);
                      //  updateTableView();
                    log.escreveLog(Usuario.getUser(),"Criou OS para o veículo - "+tt.getPlaca());
                    });}
                    catch(Exception d){
                        throw new DbException(d.getMessage());
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
                log.escreveLog(Usuario.getUser(),"Alterou o status do envio do socorro para placa "+tt.getPlaca());
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
                log.escreveLog(Usuario.getUser(),"Alterou o status do deslocamento para placa "+tt.getPlaca());
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
                log.escreveLog(Usuario.getUser()," Cancelou a OS para placa "+st.getPlaca());

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
        }catch (Exception e){
            throw new DbException(e.getMessage()+" TelaPrincipalController -  na função onbtDirecionaOS");
        }
    }

















    // implementação tableview em orçamento

    private ObservableList<StatusAtendimento> obsListOrcamento;

    @FXML
    private TitledPane tpEmOrcamento;

    @FXML
    private TableView tvEmOrcamento;

    @FXML
    private TableColumn<StatusAtendimento,String> tcPlaca3;

    @FXML
    private TableColumn<StatusAtendimento,String> tcVeiculo3;

    @FXML
    private TableColumn tcStatus2;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcCambio3;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcElet3;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcMotor3;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcInjecao3;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcMecanica3;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcPneus3;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcAguardAvaliacao;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcStatusCliente;

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
                log.escreveLog(Usuario.getUser(),"cancelou o orçamento para placa "+st.getPlaca());

                //falta enviar informação para a tela de entrega do orçamento

            }
        }else{
            Alerts.showAlert("Erro ", "Você deve selecionar uma linha na tabela ordem de serviço", null, Alert.AlertType.INFORMATION);
        }

        updateTableView();
    }



    // implementação tableview em serviço

    private ObservableList<OrdemServico> obsListEmServico;

    @FXML
    private TitledPane tpServicos;

    @FXML
    private TableView tvServicos;

    @FXML
    private TableColumn<StatusAtendimento, String> tcPlaca4;

    @FXML
    private TableColumn<StatusAtendimento, String> tcVeiculo4;

    @FXML
    private TableColumn tcStatus4;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcCambio4;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcElet4;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcInjecao4;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcMecanica4;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcMotor4;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcPneus4;

    @FXML
    private TableColumn<StatusAtendimento, Circulos> tcLavacao4;

    @FXML
    private Button btAlteraOS;

    @FXML
    private Button btCncOS;


    @FXML
    private Button btFnlzServ;


    // Implementaçao serviços prontos

    @FXML
    private TitledPane tpProntos;

    @FXML
    private TableView tvProntos;

    @FXML
    private TableColumn tcPlaca5;

    @FXML
    private TableColumn tcVeiculo5;

    @FXML
    private TableColumn tcCliente5;

    @FXML
    private TableColumn tcTelefone5;

    @FXML
    private TableColumn tcStatus5;

    @FXML
    private Button btFnlzOS;


// restante da tela
    @FXML
    private Button btClose;

    @FXML
    private void btCloseButtonClick() {
        System.exit(0);
    }

    @FXML
    private Button btIconified;

    @FXML
    private void onbtIconified(){
        Stage stage = (Stage)btIconified.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private Button btCliente;

    @FXML
    private void btClienteButtonClick() {
        loadView("/org/gsnt/auttech/TipoPessoa.fxml",x->{});
    }

    @FXML
    private Button btVeiculo;

    @FXML
    private void btVeiculoButtonClick() {
        loadView("/org/gsnt/auttech/CadVeiculo.fxml",x->{});
    }

    @FXML
    private Button btAbrirOS2;

    @FXML
    private void onbtAbrirOS() {
        loadView("/org/gsnt/auttech/CriaOs.fxml",x->{});
        updateTableView();
    }

    @FXML
    private Button btListaClientes;

    @FXML
    private void btListaClientesButtonClick(){
        try {
                loadView("/org/gsnt/auttech/ListaCliente.fxml", (ListaClienteController cliController) -> {
                cliController.setClienteService(new ClienteService());
                cliController.updateTableView();
            });
        }catch (Exception e){
            throw new DbException(e.getMessage()+" TelaPrincipalController - btListaClientesButtonClick");
        }
    }

    @FXML
    private Button btCadProfissionais;

    @FXML
    private void onbtCadProfissionais(){
        loadView("/org/gsnt/auttech/CadFuncionarios.fxml",x->{});
    }



    /////////////////////////////////////////// gerenciamento de serviços ////////
    @FXML
    private Button btListaServico;

    @FXML
    private Button btAssumir;









    @FXML
    private Button btListarProfissionais;

    @FXML
    private void onbtListarProfissionais(){

    }

    private void updateTableView() {

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

    private void initializeNodes(){

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
        lblUser.setText(Usuario.getUser());

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
            throw new DbException("loadView - TelaPrincipalController " +e.getMessage());
        }
    }

}
