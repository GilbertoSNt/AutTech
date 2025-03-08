package org.gsnt.auttech.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.gsnt.auttech.model.dao.AgendaDao;
import org.gsnt.auttech.model.dao.DaoFactory;
import org.gsnt.auttech.model.entities.Agenda;
import org.gsnt.auttech.util.MaskValid;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class AgendaController implements Initializable {

    public AgendaController(){}



    private MaskValid maskValid = new MaskValid();

    private AgendaDao agendaService = DaoFactory.createAgendaDao();

    private LocalDate a = null;
    private LocalDate b = null;
    private LocalTime c = null;
    private LocalTime d = null;

    @FXML
    private DatePicker dpData;

    @FXML
    private void onRidingDpData(){

        a = dpData.getValue();
        b = LocalDate.now();
        if (a.compareTo(b) < 0){
            dpData.show();
            lblConfirma.setText("Data escolhida deve ser superior ou igual a data atual");
        }else {
            txtHora.requestFocus();
            lblConfirma.setText("");
        }

    }

    @FXML
    private Label lblNumAgenda;

    @FXML
    protected TextField txtVeiculo;

    @FXML
    protected TextField txtPlaca;

    @FXML
    protected TextField txtNome;

    @FXML
    protected TextField txtTelefone;

    @FXML
    protected TextField txtHora;

    @FXML
    protected TextArea txaDescricao;

    @FXML
    protected Button btClose;

    @FXML
    protected CheckBox cbRevisao;

    @FXML
    protected CheckBox cbTrcOleo;

    @FXML
    protected CheckBox cbMec;

    @FXML
    protected CheckBox cbSusp;

    @FXML
    protected CheckBox cbFreio;

    @FXML
    protected CheckBox cbMotor;

    @FXML
    protected CheckBox cbInjElet;

    @FXML
    protected CheckBox cbElet;

    @FXML
    protected CheckBox cbCaixa;

    @FXML
    protected CheckBox cbAlinBalan;

    @FXML
    protected CheckBox cbSocMec;

    @FXML
    protected CheckBox cbBusVei;

    @FXML
    protected CheckBox cbSocElet;

    @FXML
    protected CheckBox cbLevVei;

    @FXML
    protected CheckBox cbGuincho;

    @FXML
    protected CheckBox cbCliente;

    @FXML
    private Label lblConfirma;

    @FXML
    protected void btCloseButtonClick(){
        Stage stage = (Stage)btClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected Button btGravar;

    @FXML
    protected void btGravarButtonClick(){

        Boolean confirma = agendaService.insertAgenda(coletaDados());

        if (confirma){

            //implementar tela aviso/confirmação

        }


    }

    @FXML
    protected Button btCancel;

    @FXML
    protected Button btFechar;

    @FXML
    protected void btFecharButtonClick(){
        Stage stage = (Stage)btFechar.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblNumAgenda.setVisible(false);

        maskValid.maskTel9Dig(txtTelefone);
        maskValid.maskHora(txtHora);

        txtHora.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                if(txtHora.getLength() < 5){
                    lblConfirma.setText("Atenção - Dados válidos de horário são obrigatórios");
                    txtHora.requestFocus();
                }else{
                    a = dpData.getValue();
                    b = LocalDate.now();
                    c = LocalTime.parse(txtHora.getText());
                    d = LocalTime.now();
                        if(a.compareTo(b) <= 0 && c.compareTo(d) <=0 ){
                        lblConfirma.setText("Atenção - Dados válidos de horário são obrigatórios");
                        txtHora.requestFocus();
                         }else{
                        txtVeiculo.requestFocus();
                        lblConfirma.setText("");
                         }
                    }
                }
            });


        txtVeiculo.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                if(txtVeiculo.getText() == null || txtVeiculo.getLength() <= 2){
                    txtVeiculo.requestFocus();
                    lblConfirma.setText("Atenção - Dados válidos do veículo são obrigatórios");
                }else{
                    txtNome.requestFocus();
                    lblConfirma.setText("");
                }
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtHora.requestFocus();
            }
        });

        txtNome.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                if(txtNome.getText() == null || txtNome.getLength() <= 1){
                    txtNome.requestFocus();
                    lblConfirma.setText("Atenção - Dados válidos do nome são obrigatórios");
                }else{
                    txtPlaca.requestFocus();
                    lblConfirma.setText("");
                }
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtVeiculo.requestFocus();
            }
                });

        txtPlaca.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER) {
                txtTelefone.requestFocus();
            }
            });

        txtTelefone.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER) {
                txaDescricao.requestFocus();
            }
        });



    }


    private Agenda coletaDados(){
        Agenda a = new Agenda();

        a.setDataAgenda(dpData.getValue().toString());
        a.setHora(txtHora.getText());
        a.setNome(txtNome.getText());
        a.setVeiculo(txtVeiculo.getText());
        a.setPlaca(txtPlaca.getText());
        a.setTelefone(txtTelefone.getText());
        a.setObs(txaDescricao.getText());
        a.setsRevisao(cbRevisao.isSelected());
        a.setsSuspensao(cbSusp.isSelected());
        a.setsInjecao(cbInjElet.isSelected());
        a.setsPneus(cbAlinBalan.isSelected());
        a.setsTrocaOleo(cbTrcOleo.isSelected());
        a.setsFreio(cbFreio.isSelected());
        a.setsEletrico(cbElet.isSelected());
        a.setsMecanico(cbMec.isSelected());
        a.setsMotor(cbMotor.isSelected());
        a.setsCaixa(cbCaixa.isSelected());
        a.setAssSocMecanico(cbSocMec.isSelected());
        a.setAssSocEletrico(cbSocElet.isSelected());
        a.setAssLevar(cbLevVei.isSelected());
        a.setAssGuincho(cbGuincho.isSelected());
        a.setAssBuscar(cbBusVei.isSelected());
        a.setAssClienteTraz(cbCliente.isSelected());
        a.setAssEnvioGuincho(false);
        a.setAssEnvioDeslocamento(false);

        return a;

    }

    public void preencheDados(String placa){

        System.out.println("Aqui");

        Agenda dados = agendaService.findByPlacaData(placa);
        lblNumAgenda.setVisible(true);
        lblNumAgenda.setText("Nº - "+dados.getCod());
        dpData.setValue(LocalDate.parse(dados.getDataAgenda()));
        txtHora.setText(dados.getHora());
        txtVeiculo.setText(dados.getVeiculo());
        txtPlaca.setText(dados.getPlaca());
        txtTelefone.setText(dados.getTelefone());
        cbRevisao.setSelected(dados.getsRevisao());
        cbSusp.setSelected(dados.getsSuspensao());
        cbInjElet.setSelected(dados.getsInjecao());
        cbAlinBalan.setSelected(dados.getsPneus());
        cbTrcOleo.setSelected(dados.getsTrocaOleo());
        cbFreio.setSelected(dados.getsFreio());
        cbElet.setSelected(dados.getsEletrico());
        cbMec.setSelected(dados.getsMecanico());
        cbMotor.setSelected(dados.getsMotor());
        cbCaixa.setSelected(dados.getsCaixa());
        cbSocMec.setSelected(dados.getAssSocMecanico());
        cbSocElet.setSelected(dados.getAssSocEletrico());
        cbGuincho.setSelected(dados.getAssGuincho());
        cbBusVei.setSelected(dados.getAssBuscar());
        cbLevVei.setSelected(dados.getAssLevar());
        cbCliente.setSelected(dados.getAssClienteTraz());
        txaDescricao.setText(dados.getObs());


    }


}
