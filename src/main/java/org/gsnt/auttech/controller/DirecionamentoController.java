package org.gsnt.auttech.controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import org.gsnt.auttech.TelaPrincipal;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.*;
import org.gsnt.auttech.model.dao.service.DirecionadosService;
import org.gsnt.auttech.model.entities.Cliente;
import org.gsnt.auttech.model.entities.Direcionados;
import org.gsnt.auttech.model.entities.Funcionario;
import org.gsnt.auttech.model.entities.StatusAtendimento;
import org.gsnt.auttech.util.Alerts;
import org.gsnt.auttech.util.Botoes;
import org.gsnt.auttech.util.ExceptionGenerics;
import org.gsnt.auttech.util.MaskValid;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import java.util.ResourceBundle;
import java.util.function.Consumer;

public class DirecionamentoController implements Initializable {


    private FuncionarioDao funcionarioServ =  DaoFactory.createFuncionarioDao();
    private DirecionadosDao dirService = DaoFactory.createDirecionadosDao();

    private int codVeiculo = 0;

    private MaskValid mascara = new MaskValid();

    private List<String> caixa = new ArrayList<>();
    private List<String> freio = new ArrayList<>();
    private List<String> suspensao = new ArrayList<>();
    private List<String> motor = new ArrayList<>();
    private List<String> eletrico = new ArrayList<>();
    private List<String> injecao = new ArrayList<>();
    private List<String> pneus = new ArrayList<>();
    private List<String> alin = new ArrayList<>();
    private List<String> balan = new ArrayList<>();
    private List<String> trocaOleo = new ArrayList<>();


    @FXML
    private TitledPane tp1;

    @FXML
    private TitledPane tp2;

    @FXML
    private TitledPane tp3;


    @FXML
    private Label lblVeiculo;


    @FXML
    private Button btGravar;

    @FXML
    private Button btCancel;

    @FXML
    private Button btFechar;

    @FXML
    private Button btClose;

    @FXML
    protected void onbtCloseButtonClick(){
        Stage stage = (Stage)btClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private CheckBox cbRevisao;

    @FXML
    private CheckBox cbTrcOleo;

    @FXML
    private CheckBox cbMec;

    @FXML
    private CheckBox cbSusp;

    @FXML
    private CheckBox cbFreio;

    @FXML
    private CheckBox cbMotor;

    @FXML
    private CheckBox cbInjElet;

    @FXML
    private CheckBox cbElet;

    @FXML
    private CheckBox cbCaixa;

    @FXML
    private CheckBox cbAlinBalan;

    @FXML
    private ComboBox<String> cbxCaixa;

    @FXML
    private ComboBox<String> cbxFreio;

    @FXML
    private ComboBox<String> cbxMotor;

    @FXML
    private ComboBox<String> cbxSuspensao;

    @FXML
    private ComboBox<String> cbxEletrico;

    @FXML
    private ComboBox<String> cbxInjElet;

    @FXML
    private ComboBox<String> cbxPneu;

    @FXML
    private ComboBox<String> cbxAlin;

    @FXML
    private ComboBox<String> cbxBalan;

    @FXML
    private ComboBox<String> cbxTrocaOleo;

    @FXML
    private TableView tvMecanico;

    @FXML
    private TableColumn<Direcionados, String> tcMecNome;

    @FXML
    private TableColumn<Direcionados, Integer> tcMecQuant;

    @FXML
    private TableColumn<Direcionados, Direcionados> tcLista;

    private ObservableList<Direcionados> obsDirecionado;

    public void preencheDadosDir(StatusAtendimento st){

        lblVeiculo.setText("Código O.S. - "+st.getCodOs()+" Placa - "+st.getPlaca()+" Modelo - "+st.getVeiculo());

        if(st.getRevisao()>0){
            cbRevisao.setSelected(true);
        }
        if(st.getTrocaOleo()>0){
            cbTrcOleo.setSelected(true);
        }
        if(st.getSuspensaoDt()>0 || st.getSuspensaoTr()>0){
            cbSusp.setSelected(true);
            cbMec.setSelected(true);
        }
        if(st.getFreioDt()>0 || st.getFreioTr()>0){
            cbFreio.setSelected(true);
            cbMec.setSelected(true);
        }
        if(st.getMotor()>0){
            cbMotor.setSelected(true);
            cbMec.setSelected(true);
        }
        if(st.getInjecao()>0){
            cbInjElet.setSelected(true);
        }
        if(st.getPneus()>0 || st.getAlinBalan()>0){
            cbAlinBalan.setSelected(true);
        }
        if(st.getEletrico()>0){
            cbElet.setSelected(true);
        }
        if(st.getCaixa()>0){
            cbCaixa.setSelected(true);
        }
        check();

    }

    private void preencheCombos(){

        List<Funcionario> funci = funcionarioServ.findByEspecializacao();


        for(int z = 0; z<funci.size();z++) {

            if (funci.get(z).getCaixaMec()) {
                caixa.add(funci.get(z).getNome() + " (Mec)");
            }
            if (funci.get(z).getCaixaAut()) {
                caixa.add(funci.get(z).getNome() + " (Aut)");
            }
            if (funci.get(z).getFreio()) {
                freio.add(funci.get(z).getNome());
            }
            if (funci.get(z).getSuspensao()) {
                suspensao.add(funci.get(z).getNome());
            }
            if (funci.get(z).getMotorDiesel()) {
                motor.add(funci.get(z).getNome() + " (Diesel)");
            }
            if (funci.get(z).getMotorFlex()) {
                motor.add(funci.get(z).getNome() + " (Flex)");
            }
            if (funci.get(z).getEletrica()) {
                eletrico.add(funci.get(z).getNome());
            }
            if (funci.get(z).getInjDiesel()) {
                injecao.add(funci.get(z).getNome() + " (Diesel)");
            }
            if (funci.get(z).getInjFlex()) {
                injecao.add(funci.get(z).getNome() + " (Flex)");
            }
            if (funci.get(z).getPneus()) {
                pneus.add(funci.get(z).getNome());
                alin.add(funci.get(z).getNome());
                balan.add(funci.get(z).getNome());
            }
            if (funci.get(z).getTrocaOleo()) {
                trocaOleo.add(funci.get(z).getNome());
            }
        }

        comboCaixa(caixa);
        comboFreio(freio);
        comboSuspensao(suspensao);
        comboMotor(motor);
        comboEletrico(eletrico);
        comboInjecao(injecao);
        comboPneus(pneus);
        comboAlin(alin);
        comboBalan(balan);
        combotrocaOleo(trocaOleo);


    }

    private void comboBalan(List balan){

        ObservableList obsComboBalan = FXCollections.observableList(balan);
        cbxBalan.setItems(obsComboBalan);
        Callback<ListView<String>, ListCell<String>> factoryBalan = lv -> new ListCell<String>(){
            @Override
            protected void updateItem(String funcionario8, boolean empty){
                super.updateItem(funcionario8, empty);
                setText(empty ?"":funcionario8);
            }
        };
        cbxBalan.setCellFactory(factoryBalan);
        cbxBalan.setButtonCell(factoryBalan.call(null));

    }

    private void comboAlin(List alin){

        ObservableList obsComboAlin = FXCollections.observableList(alin);
        cbxAlin.setItems(obsComboAlin);
        Callback<ListView<String>, ListCell<String>> factoryAlin = lv -> new ListCell<String>(){
            @Override
            protected void updateItem(String funcionario7, boolean empty){
                super.updateItem(funcionario7, empty);
                setText(empty ?"":funcionario7);
            }
        };
        cbxAlin.setCellFactory(factoryAlin);
        cbxAlin.setButtonCell(factoryAlin.call(null));

    }

    private void comboPneus(List pneus){

        ObservableList obsComboPneus = FXCollections.observableList(pneus);
        cbxPneu.setItems(obsComboPneus);
        Callback<ListView<String>, ListCell<String>> factoryPneus = lv -> new ListCell<String>(){
            @Override
            protected void updateItem(String funcionario6, boolean empty){
                super.updateItem(funcionario6, empty);
                setText(empty ?"":funcionario6);
            }
        };
        cbxPneu.setCellFactory(factoryPneus);
        cbxPneu.setButtonCell(factoryPneus.call(null));

    }

    private void comboInjecao(List injecao){

        ObservableList obsComboInjecao = FXCollections.observableList(injecao);
        cbxInjElet.setItems(obsComboInjecao);
        Callback<ListView<String>, ListCell<String>> factoryInjecao = lv -> new ListCell<String>(){
            @Override
            protected void updateItem(String funcionario5, boolean empty){
                super.updateItem(funcionario5, empty);
                setText(empty ?"":funcionario5);
            }
        };
        cbxInjElet.setCellFactory(factoryInjecao);
        cbxInjElet.setButtonCell(factoryInjecao.call(null));

    }

    private void comboEletrico(List eletrico){

        ObservableList obsComboEletrico = FXCollections.observableList(eletrico);
        cbxEletrico.setItems(obsComboEletrico);
        Callback<ListView<String>, ListCell<String>> factoryEletrico = lv -> new ListCell<String>(){
            @Override
            protected void updateItem(String funcionario4, boolean empty){
                super.updateItem(funcionario4, empty);
                setText(empty ?"":funcionario4);
            }
        };
        cbxEletrico.setCellFactory(factoryEletrico);
        cbxEletrico.setButtonCell(factoryEletrico.call(null));

    }

    private void comboMotor(List motor){

        ObservableList obsComboMotor = FXCollections.observableList(motor);
        cbxMotor.setItems(obsComboMotor);
        Callback<ListView<String>, ListCell<String>> factoryMotor = lv -> new ListCell<String>(){
            @Override
            protected void updateItem(String funcionario3, boolean empty){
                super.updateItem(funcionario3, empty);
                setText(empty ?"":funcionario3);
            }
        };
        cbxMotor.setCellFactory(factoryMotor);
        cbxMotor.setButtonCell(factoryMotor.call(null));

    }

    private void comboSuspensao(List suspensao){

        ObservableList obsComboSuspensao = FXCollections.observableList(suspensao);
        cbxSuspensao.setItems(obsComboSuspensao);
        Callback<ListView<String>, ListCell<String>> factorySuspensao = lv -> new ListCell<String>(){
            @Override
            protected void updateItem(String funcionario2, boolean empty){
                super.updateItem(funcionario2, empty);
                setText(empty ?"":funcionario2);
            }
        };
        cbxSuspensao.setCellFactory(factorySuspensao);
        cbxSuspensao.setButtonCell(factorySuspensao.call(null));

    }

    private void comboFreio(List freio){

        ObservableList obsComboFreio = FXCollections.observableList(freio);
        cbxFreio.setItems(obsComboFreio);
        Callback<ListView<String>, ListCell<String>> factoryFreio = lv -> new ListCell<String>(){
            @Override
            protected void updateItem(String funcionario1, boolean empty){
                super.updateItem(funcionario1, empty);
                setText(empty ?"":funcionario1);
            }
        };
        cbxFreio.setCellFactory(factoryFreio);
        cbxFreio.setButtonCell(factoryFreio.call(null));

    }

    private void comboCaixa(List caixa){

        ObservableList obsComboCaixa = FXCollections.observableList(caixa);
        cbxCaixa.setItems(obsComboCaixa);
        Callback<ListView<String>, ListCell<String>> factoryCaixa = lv -> new ListCell<String>(){
            @Override
            protected void updateItem(String funcionario, boolean empty){
                super.updateItem(funcionario, empty);
                setText(empty ?"":funcionario);
            }
        };
        cbxCaixa.setCellFactory(factoryCaixa);
        cbxCaixa.setButtonCell(factoryCaixa.call(null));

    }

    private void combotrocaOleo(List trocaOleo){

        ObservableList obsComboTrocaOleo = FXCollections.observableList(trocaOleo);
        cbxTrocaOleo.setItems(obsComboTrocaOleo);
        Callback<ListView<String>, ListCell<String>> factoryTrocaOleo = lv -> new ListCell<String>(){
            @Override
            protected void updateItem(String funcionario9, boolean empty){
                super.updateItem(funcionario9, empty);
                setText(empty ?"":funcionario9);
            }
        };
        cbxTrocaOleo.setCellFactory(factoryTrocaOleo);
        cbxTrocaOleo.setButtonCell(factoryTrocaOleo.call(null));

    }

    private void initializeNodes(){
        try {
            tcMecNome.setCellValueFactory(new PropertyValueFactory<Direcionados, String>("apelido"));
            tcMecQuant.setCellValueFactory(new PropertyValueFactory<Direcionados, Integer>("qtdtndmnt"));
            buttonColumnLista();

        }catch (Exception e){
            throw new ExceptionGenerics(e.getMessage()+" DirecionamentoController - initializaNodes");
        }

    }

    private void updadeTableView(){
        try {
            if (dirService == null) {
                throw new IllegalStateException("Direcionamento esta nulo");
            }
            obsDirecionado = FXCollections.observableArrayList(dirService.listaServico());
            tvMecanico.setItems(obsDirecionado);

        }catch (Exception a){
            throw new ExceptionGenerics(a.getMessage()+" DirecionamentoController - updateTableView");
        }
    }

    private void buttonColumnLista(){
        tcLista.setCellValueFactory(param-> new ReadOnlyObjectWrapper<>(param.getValue()));
        tcLista.setCellFactory(param -> new TableCell<Direcionados, Direcionados>() {

            private final Botoes listaAtend = new Botoes("#70c3a7");

            @Override
            protected void updateItem(Direcionados dir, boolean empty) {

                super.updateItem(dir, empty);
                if (dir == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(listaAtend);

                listaAtend.setOnAction(event -> {

                    Direcionados dir1 = getTableView().getItems().get(getIndex());
                    try {
                        loadView("/org/gsnt/auttech/ListaAtendFunc.fxml", (ListaAtendFuncController lista) -> {
                            lista.chamada(dir1.getApelido());
                        });
                    }catch (Exception d){
                        System.out.println(d+" DirecionamentoController - buttonColumnLista");
                    }

                });
            }
        });
    }

    @FXML
    private void onCheck(){
        check();
    }

    private void check(){

        if(cbMec.isSelected() || cbRevisao.isSelected()){
            cbxMotor.setDisable(false);
            cbxSuspensao.setDisable(false);
            cbxFreio.setDisable(false);
        }else {
            cbxMotor.setDisable(true);
            cbxSuspensao.setDisable(true);
            cbxFreio.setDisable(true);
        }
        if(cbTrcOleo.isSelected() || cbRevisao.isSelected()){
            cbxTrocaOleo.setDisable(false);
        }else{
            cbxTrocaOleo.setDisable(true);
        }
        if(cbCaixa.isSelected() || cbRevisao.isSelected()){
            cbxCaixa.setDisable(false);
        }else{
            cbxCaixa.setDisable(true);
        }
        if(cbFreio.isSelected() || cbRevisao.isSelected()){
            cbxFreio.setDisable(false);
        }else{
            cbxFreio.setDisable(true);
        }
        if(cbSusp.isSelected() || cbRevisao.isSelected()){
            cbxSuspensao.setDisable(false);
        }else{
            cbxSuspensao.setDisable(true);
        }
        if(cbMotor.isSelected() || cbRevisao.isSelected()){
            cbxMotor.setDisable(false);
        }else{
            cbxMotor.setDisable(true);
        }
        if(cbElet.isSelected() || cbRevisao.isSelected()){
            cbxEletrico.setDisable(false);
        }else{
            cbxEletrico.setDisable(true);
        }
        if(cbInjElet.isSelected() || cbRevisao.isSelected()){
            cbxInjElet.setDisable(false);
        }else{
            cbxInjElet.setDisable(true);
        }
        if(cbAlinBalan.isSelected() || cbRevisao.isSelected()){
            cbxBalan.setDisable(false);
            cbxAlin.setDisable(false);
            cbxPneu.setDisable(false);
        }else{
            cbxBalan.setDisable(true);
            cbxAlin.setDisable(true);
            cbxPneu.setDisable(true);
        }
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeNodes();
        preencheCombos();
        updadeTableView();

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
            throw new ExceptionGenerics(e.getMessage()+" DirecionamentoController - loadView");
        }
    }

}
