package org.gsnt.auttech.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.gsnt.auttech.model.dao.ClienteDao;
import org.gsnt.auttech.model.dao.DaoFactory;
import org.gsnt.auttech.model.dao.OrdemServicoDao;
import org.gsnt.auttech.model.dao.VeiculoDao;
import org.gsnt.auttech.model.entities.Agenda;

import java.net.URL;
import java.util.ResourceBundle;

public class CriaOsController implements Initializable {

    private ClienteDao clienteservice = DaoFactory.createClienteDao();
    private VeiculoDao veiculoService = DaoFactory.createVeiculoDao();
    private OrdemServicoDao ordemServicoService = DaoFactory.createOrdemServicoDao();


    public CriaOsController(){}


    @FXML
    private TextField txtPlaca;

    @FXML
    private Label lblNomeCliente;

    @FXML
    private Label lblVeiculo;

    @FXML
    private Button btCadVeiculo;

    @FXML
    private Button btCadCliente;

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
        cbTrcOleo.setSelected(agenda.getsPneus());
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

    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (txtPlaca.getText() != null){

        }

    }
}
