package org.gsnt.auttech.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import org.gsnt.auttech.TelaPrincipal;
import org.gsnt.auttech.model.dao.*;
import org.gsnt.auttech.model.dao.service.FuncionarioService;
import org.gsnt.auttech.model.entities.*;
import org.gsnt.auttech.util.Alerts;
import org.gsnt.auttech.util.MaskValid;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class CriaOsController implements Initializable {

    private ModeloVeiculoDao modeloService = DaoFactory.createModeloVeiculoDao();
    private MarcaVeiculoDao marcaService = DaoFactory.createMarcaVeiculoDao();
    private ClienteDao clienteService = DaoFactory.createClienteDao();
    private VeiculoDao veiculoService = DaoFactory.createVeiculoDao();
    private OrdemServicoDao ordemServicoService = DaoFactory.createOrdemServicoDao();
    private FuncionarioDao funcionarioServ =  DaoFactory.createFuncionarioDao();

    private ObservableList<Funcionario> obsComboCaixa;
    private ObservableList<Funcionario> obsComboFreio;
    private ObservableList<Funcionario> obsComboSuspensao;
    private ObservableList<Funcionario> obsComboMotor;
    private ObservableList<Funcionario> obsComboEletrico;
    private ObservableList<Funcionario> obsComboInjecao;
    private ObservableList<Funcionario> obsComboPneus;
    private ObservableList<Funcionario> obsComboAlin;
    private ObservableList<Funcionario> obsComboBalan;


    private int codVeiculo = 0;

    private MaskValid mascara = new MaskValid();

   // public CriaOsController(){}

    @FXML
    private TextField txtPlaca;

    @FXML
    private Label lblNomeCliente;

    @FXML
    private Label lblVeiculo;

    @FXML
    private Button btCadVeiculo;

    @FXML
    private void onbtCadastraVeiculo(){
        verificaCadastro(txtPlaca.getText());
    }

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
    private TextArea txaDescricao;

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
    private CheckBox cbSocMec;

    @FXML
    private CheckBox cbSocElet;

    @FXML
    private CheckBox cbBusVei;

    @FXML
    private CheckBox cbGuincho;

    @FXML
    private CheckBox cbLevVei;

    @FXML
    private CheckBox cbCliente;

    @FXML
    private CheckBox cbTrOleo;

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

    //
    //   ainda falta dados(Busca cadastro)
    //

    public void preencheDadosAgenda(Agenda agenda){

        txtPlaca.setText(agenda.getPlaca());
        cbRevisao.setSelected(agenda.getsRevisao());
        cbSusp.setSelected(agenda.getsSuspensao());
        cbInjElet.setSelected(agenda.getsInjecao());
        cbAlinBalan.setSelected(agenda.getsPneus());
        cbTrcOleo.setSelected(agenda.getsTrocaOleo());
        cbFreio.setSelected(agenda.getsFreio());
        cbElet.setSelected(agenda.getsEletrico());
        cbMec.setSelected(agenda.getsMecanico());
        cbMotor.setSelected(agenda.getsMotor());
        cbCaixa.setSelected(agenda.getsCaixa());
        cbSocMec.setSelected(agenda.getAssSocMecanico());
        cbSocElet.setSelected(agenda.getAssSocEletrico());
        cbGuincho.setSelected(agenda.getAssGuincho());
        cbBusVei.setSelected(agenda.getAssBuscar());
        cbLevVei.setSelected(agenda.getAssLevar());
        cbCliente.setSelected(agenda.getAssClienteTraz());
        txaDescricao.setText(agenda.getObs());
        verificaCadastro(agenda.getPlaca());

    }

    private void verificaCadastro(String placa){

        int teste = veiculoService.verificaPlaca(placa);
        if(teste != 0){
            Veiculo veiculo =  veiculoService.findById(placa);
            Cliente cli = clienteService.findById(clienteService.findIdClienteByIdVeiculo(veiculo.getCod()));
            preencheTelaComplemento(veiculo,cli);
        }else if(placa.length() == 8){
            Optional<ButtonType> result = Alerts.showConfirmation("Placa não cadastrada ou informação errada", "Placa não cadastrada ou informação errada. Confirma cadastro de novo veículo ?");
            if (result.get() == ButtonType.OK) {
                cadastraVeiculo(placa);
            }
        }else{
            Alerts.showAlert("Atenção","Placa fora do padrão, redigite a placa",null, Alert.AlertType.ERROR);
            cadastraVeiculo();
        }
    }

    private void cadastraVeiculo(){
        loadView("/org/gsnt/auttech/CadVeiculo.fxml",x->{});
    }

    private void cadastraVeiculo(String placa){

        loadView("/org/gsnt/auttech/CadVeiculo.fxml",(CadVeiculoController cadVeicControl) ->{
            cadVeicControl.txtPlaca.setText(placa);
        });
            //implementar placa na tela, verificar segunda entrada no banco, verificar segunda chamada do método
    }

    private synchronized<T> void loadView(String absoluteName, Consumer<T> inicializingAction) {
        try {

            FXMLLoader loader = new FXMLLoader(TelaPrincipal.class.getResource(absoluteName));
            Scene secundaryScene = new Scene(loader.load());

            CadVeiculoController cadVeiculoController = loader.getController();

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

            codVeiculo = cadVeiculoController.getDadosOs();
            if (codVeiculo != 0){
                Veiculo veiculo =  veiculoService.findByCod(codVeiculo);
                Cliente cli = clienteService.findById(clienteService.findIdClienteByIdVeiculo(codVeiculo));
                preencheTelaComplemento(veiculo,cli);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void preencheTelaComplemento(Veiculo veiculo, Cliente cliente){
        txtPlaca.setText(veiculo.getPlaca());
        lblVeiculo.setText(marcaService.findMarcaById(veiculo.getMarca())+" / "+modeloService.findModeloById(veiculo.getModelo())+" / Ano - "+veiculo.getAnof()
                +" / Ano modelo - "+veiculo.getAnom()+" / Motor - "+veiculo.getMotor());
        lblNomeCliente.setText(cliente.getNome());
    }

    private void preencheCombos(){

        List<Funcionario> funci = funcionarioServ.findByEspecializacao();

        //Funcionario indicador;
        List<String> caixa = new ArrayList<>();
        List<String> freio = new ArrayList<>();
        List<String> suspensao = new ArrayList<>();
        List<String> motor = new ArrayList<>();
        List<String> eletrico = new ArrayList<>();
        List<String> injecao = new ArrayList<>();
        List<String> pneus = new ArrayList<>();
        List<String> alin = new ArrayList<>();
        List<String> balan = new ArrayList<>();
        List<String> trocaOleo = new ArrayList<>();

        //
        // implementar troca de óleo
        //

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        preencheCombos();
        mascara.maskPlaca(txtPlaca);
        txtPlaca.setPromptText("___-____");

    }
}
