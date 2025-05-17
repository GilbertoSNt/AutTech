package org.gsnt.auttech.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.gsnt.auttech.TelaPrincipal;
import org.gsnt.auttech.model.dao.*;
import org.gsnt.auttech.model.entities.Agenda;
import org.gsnt.auttech.model.entities.Cliente;
import org.gsnt.auttech.model.entities.Veiculo;
import org.gsnt.auttech.util.Alerts;
import org.gsnt.auttech.util.MaskValid;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mascara.maskPlaca(txtPlaca);
        txtPlaca.setPromptText("___-____");

    }
}
