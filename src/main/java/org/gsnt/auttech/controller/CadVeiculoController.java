package org.gsnt.auttech.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import org.gsnt.auttech.TelaPrincipal;
import org.gsnt.auttech.model.dao.*;
import org.gsnt.auttech.model.dao.service.ClienteService;
import org.gsnt.auttech.model.entities.Cliente;
import org.gsnt.auttech.model.entities.MarcaVeiculo;
import org.gsnt.auttech.model.entities.ModeloVeiculo;
import org.gsnt.auttech.model.entities.Veiculo;
import org.gsnt.auttech.util.DadosCombos;
import org.gsnt.auttech.util.MaskValid;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class CadVeiculoController implements Initializable {

    private Cliente cliente = new Cliente();

    private MaskValid mascara = new MaskValid();

    private int cad = 0;

    private String nome = "";

    private ModeloVeiculoDao modeloService = DaoFactory.createModeloVeiculoDao();

    private MarcaVeiculoDao marcaService = DaoFactory.createMarcaVeiculoDao();

    private VeiculoDao veiculoService = DaoFactory.createVeiculoDao();

    private VeiculoDao veiculoServiceGeral = DaoFactory.createVeiculoDaoGeral();

    private ClienteDao clienteService = DaoFactory.createClienteDao();

    private int codVeiculo = 0;

    public CadVeiculoController(){}

    public CadVeiculoController(int cad, String nome){

        this.cad = cad;
        this.nome = nome;

    }

    private DadosCombos dadosCombos = new DadosCombos();

    private ObservableList<MarcaVeiculo> obsListTipoMArca;

    private ObservableList<ModeloVeiculo> obsListModeloVeiculo;

    @FXML
    protected Button btClose;

    @FXML
    protected void btCloseButtonClick(){
        Stage stage = (Stage)btClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected Button btImportar;

    @FXML
    protected Button btProcurar;

    @FXML
    private void onBtProcurar(){

        telaLista();
        txtNomeCli.requestFocus();
        if (txtCodCli.getText()!=null){
            btGravar.setDisable(false);
        }
    }


    @FXML
    protected TextField txtPlaca;


    @FXML
    protected ComboBox<MarcaVeiculo> cbMarca;

    @FXML
    private void hiddencbMarca(){

        MarcaVeiculo marca = cbMarca.getSelectionModel().getSelectedItem();
        carregarComboModelo(marca.getCod());
        cbModelo.show();

    }


    //Carrega ComboBox Marca
    private void carregarComboMarca( ){

        obsListTipoMArca = FXCollections.observableList(dadosCombos.marcaVeiculo());
        cbMarca.setItems(obsListTipoMArca);
        Callback<ListView<MarcaVeiculo>, ListCell<MarcaVeiculo>> factory = lv -> new ListCell<MarcaVeiculo>() {
            @Override
            protected void updateItem(MarcaVeiculo marca, boolean empty) {
                super.updateItem(marca, empty);
                setText(empty ? "" : marca.getMarcaVeiculo());
            }
        };
        cbMarca.setCellFactory(factory);
        cbMarca.setButtonCell(factory.call(null));

    }

    @FXML
    protected ComboBox<ModeloVeiculo> cbModelo;

    @FXML
    private void hiddencbModelo(){
        txtChassi.requestFocus();
    }

    //Carrega ComboBox Modelos
    private void carregarComboModelo(int id){

        obsListModeloVeiculo = FXCollections.observableList(dadosCombos.modeloVeiculo(id));
        cbModelo.setItems(obsListModeloVeiculo);
        Callback<ListView<ModeloVeiculo>, ListCell<ModeloVeiculo>> factory = lv -> new ListCell<ModeloVeiculo>() {
           @Override
           protected void updateItem(ModeloVeiculo modelo, boolean empty){
               super.updateItem(modelo, empty);
               setText(empty ? "" : modelo.getModelo());
           }
        };
        cbModelo.setCellFactory(factory);
        cbModelo.setButtonCell(factory.call(null));

    }

    @FXML
    protected TextField txtChassi;

    @FXML
    protected TextField txtMotor;

    @FXML
    protected CheckBox ckTurbo;

    @FXML
    protected CheckBox ckLinha;

    @FXML
    protected CheckBox ckV;

    @FXML
    protected TextField txtAno;

    @FXML
    protected TextField txtAnoMod;

    @FXML
    protected TextField txtRenavan;

    @FXML
    protected TextField txtCv;

    @FXML
    protected TextField txtCodCli;

    @FXML
    protected TextField txtNomeCli;

    @FXML
    protected CheckBox ckArC;

    @FXML
    protected CheckBox ckArQ;

    @FXML
    protected CheckBox ckDirE;

    @FXML
    protected CheckBox ckDirH;

    @FXML
    protected CheckBox ckVidro;

    @FXML
    protected CheckBox ckTrava;

    @FXML
    protected CheckBox ckAlarme;

    @FXML
    protected CheckBox ckTeto;

    @FXML
    protected CheckBox ckABS;

    @FXML
    protected CheckBox ckAirBag;

    @FXML
    protected CheckBox ckTracao;

    @FXML
    protected Button btGravar;

    @FXML
    protected Button btAlterar;

    @FXML
    protected Button btDesativar;

    @FXML
    protected Button btHistorico;

    @FXML
    protected Button btCancelar;


    private void habilitarBotoes(){
        btGravar.setDisable(false);
        btAlterar.setDisable(false);
        btDesativar.setDisable(false);
        btHistorico.setDisable(false);
    }

    private void desabilitarBotoes(){
        btGravar.setDisable(true);
        btAlterar.setDisable(true);
        btDesativar.setDisable(true);
        btHistorico.setDisable(true);
    }

    private void controlTab(){

        mascara.maskPlaca(txtPlaca);
        txtPlaca.setPromptText("___-____");

        if(this.cad != 0){
            txtCodCli.setText(""+this.cad);
            txtNomeCli.setText(this.nome);
        }

        btImportar.setDisable(true);

        txtPlaca.setOnKeyPressed((KeyEvent)->{

            if(txtPlaca.getLength()==8) {
                if (KeyEvent.getCode() == KeyCode.ENTER) {
                    int teste = veiculoService.verificaPlaca(txtPlaca.getText());
                    Veiculo veic = veiculoService.findById(txtPlaca.getText());

                    if (teste != 0) {
                        Cliente cli = clienteService.findById(clienteService.findIdClienteByIdVeiculo(veic.getCod()));
                        carregaVeiculo(veic, cli);
                        btProcurar.requestFocus();
                    }else {
                        cbMarca.show();
                    }

                }
            }
        });

        cbMarca.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtPlaca.requestFocus();
            }
        });

        cbModelo.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ESCAPE){
                cbMarca.show();
            }else{
                habilitarBotoes();
            }
        });

        txtChassi.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtMotor.requestFocus();
                habilitarBotoes();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                cbModelo.show();
            }
        });

        txtMotor.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtCv.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtChassi.requestFocus();
            }
        });

        txtCv.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                ckLinha.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtCv.requestFocus();
            }
        });

        ckTurbo.setOnKeyPressed((KeyEvent)->{
            txtAno.requestFocus();
        });

        ckLinha.setOnKeyPressed((KeyEvent)->{
            txtAno.requestFocus();
        });

        ckV.setOnKeyPressed((KeyEvent)->{
            txtAno.requestFocus();
        });

        txtAno.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtAnoMod.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                ckLinha.requestFocus();
            }
        });

        txtAnoMod.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtRenavan.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtAno.requestFocus();
            }
        });

        txtRenavan.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                btProcurar.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtAnoMod.requestFocus();
            }
        });

    }

    @FXML
    protected void onBtGravar(){
       if (txtPlaca.getText() != null && txtCodCli != null){
           cadastraVeiculo();
       }
    }

    protected void cadastraVeiculo(){

        Veiculo cad = new Veiculo();

        cad.setPlaca(txtPlaca.getText());
        cad.setMarca(cbMarca.getValue().getCod());
        cad.setModelo(cbModelo.getValue().getCod());
        cad.setChassi(txtChassi.getText());
        cad.setMotor(txtMotor.getText());
        cad.setCv(txtCv.getText());
        cad.setTurbo(ckTurbo.isSelected());
        cad.setEmLinha(ckLinha.isSelected());
        cad.setEmV(ckV.isSelected());
        cad.setAnof(txtAno.getText());
        cad.setAnof(txtAnoMod.getText());
        cad.setRenavan(txtRenavan.getText());
        cad.setArQuente(ckArQ.isSelected());
        cad.setAirBag(ckAirBag.isSelected());
        cad.setFreioABS(ckABS.isSelected());
        cad.setAlarme(ckAlarme.isSelected());
        cad.setArCond(ckArC.isSelected());
        cad.setDirHid(ckDirH.isSelected());
        cad.setDirElet(ckDirE.isSelected());
        cad.setVidroElet(ckVidro.isSelected());
        cad.setTravaElet(ckTrava.isSelected());
        cad.setTracao(ckTracao.isSelected());
        cad.setTeto(ckTeto.isSelected());

        int codCliente;
        codVeiculo = veiculoServiceGeral.saveVeiculo(cad);
        codVeiculo = 0;
        codVeiculo = veiculoService.saveVeiculo(cad);
        codCliente = Integer.valueOf(txtCodCli.getText());

        clienteService.associacaoVeicCliente(codVeiculo,codCliente);

        btCloseButtonClick();

    }

    private void carregaVeiculo(Veiculo veic, Cliente cli){

        txtPlaca.setText(veic.getPlaca());
        for (MarcaVeiculo marca : cbMarca.getItems()){
            if(marca.getCod() == veic.getMarca() ){
                cbMarca.getSelectionModel().select(marca);
                break;
            }
        }
        carregarComboModelo(veic.getMarca());
        for (ModeloVeiculo modelo : cbModelo.getItems()){
            if(modelo.getCod() == veic.getModelo() ){
                cbModelo.getSelectionModel().select(modelo);
                break;
            }
        }
        txtChassi.setText(veic.getChassi());
        txtMotor.setText(veic.getMotor());
        txtCv.setText(veic.getCv());
        ckTurbo.setSelected(veic.isTurbo());
        ckLinha.setSelected(veic.isEmLinha());
        ckV.setSelected(veic.isEmV());
        txtAno.setText(veic.getAnof());
        txtAnoMod.setText(veic.getAnom());
        txtRenavan.setText(veic.getRenavan());
        ckArQ.setSelected(veic.isArQuente());
        ckAirBag.setSelected(veic.isAirBag());
        ckABS.setSelected(veic.isFreioABS());
        ckAlarme.setSelected(veic.isAlarme());
        ckArC.setSelected(veic.isArCond());
        ckDirH.setSelected(veic.isDirHid());
        ckDirE.setSelected(veic.isDirElet());
        ckVidro.setSelected(veic.isVidroElet());
        ckTrava.setSelected(veic.isTravaElet());
        ckTracao.setSelected(veic.isTracao());
        ckTeto.setSelected(veic.isTeto());
        txtCodCli.setText(""+cli.getCod());
        txtNomeCli.setText(cli.getNome());

    }

    private void telaLista(){
        try {
            loadView("/org/gsnt/auttech/ListaCliente.fxml", (ListaClienteController cliController) -> {
                cliController.setClienteService(new ClienteService());
                cliController.updateTableView();
            });
        }catch (Exception d){
            System.out.println(d+" cadVeiculoController - telaLista");
        }

    }



    private synchronized<T> void loadView(String absoluteName, Consumer<T> inicializingAction) {
        try {

            FXMLLoader loader = new FXMLLoader(TelaPrincipal.class.getResource(absoluteName));
            Scene secundaryScene = new Scene(loader.load());

            ListaClienteController listaCliente = loader.getController();

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

            cliente = listaCliente.getClienteSelecionado();

            if(cliente != null) {
                txtNomeCli.setText(cliente.getNome());
                txtCodCli.setText("" + cliente.getCod());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage()+" cadVeiculoController - loadView");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        desabilitarBotoes();
        carregarComboMarca();
        controlTab();

    }


    public int getDadosOs(){

        return codVeiculo;

    }
}
