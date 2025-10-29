package org.gsnt.auttech.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.gsnt.auttech.model.dao.AgendaDao;
import org.gsnt.auttech.model.dao.DaoFactory;
import org.gsnt.auttech.model.entities.Agenda;
import org.gsnt.auttech.model.entities.Usuario;
import org.gsnt.auttech.util.Alerts;
import org.gsnt.auttech.util.LogTxt;
import org.gsnt.auttech.util.MaskValid;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

/**
* Classe de controle da tela de agenda
*
* @author Gilberto da S. Neto
* @version 1.0
*/

public class AgendaController implements Initializable {

    /**
     * @param maskvalid para validação de datas;
     */
    private final MaskValid maskValid = new MaskValid();

    /**
     * @param agendaService acesso ao banco de dados;
     */
    private final AgendaDao agendaService = DaoFactory.createAgendaDao();

    /**
     * @param log gera log de comandos e erros;
     */
    private final LogTxt log = new LogTxt();

    /**
     * @param a,b,c,d Todas as variáveis são usadas para validação de horas e datas;
     */
    private LocalDate a = null;
    private LocalDate b = null;
    private LocalTime c = null;
    private LocalTime d = null;

    /**
     * @param tipoTela para verificar se é alteração ou agenda nova;
     */
    private int tipoTela = 0;

    /**
     * @param placaTela cerraga a placa na chamada da tela;
     */
    private String placaTela = null;

    @FXML
    private DatePicker dpData;

    /**
     * confere se a data e a hora escolhida está correta
     */
    @FXML
    private void onRidingDpData(){

        a = dpData.getValue();
        b = LocalDate.now();
        if (a.isBefore(b)){
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
    private TextField txtVeiculo;

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

    /**
     * Fechamento da tela
     */
    @FXML
    private void btCloseButtonClick(){
        close(btClose);
    }

    @FXML
    protected Button btGravar;

    /**
     * Grava dados da tela
     */
    @FXML
    protected void btGravarButtonClick(){

        Boolean confirma = false;
        if (tipoTela == 0){
            confirma = agendaService.insertAgenda(coletaDados());
            log.escreveLog(Usuario.getUser(),"Gravou novo agendamento para placa "+this.placaTela);
        }else if(tipoTela == 1) {
            confirma = agendaService.saveAlterAgenda(coletaDados(), this.placaTela);
            log.escreveLog(Usuario.getUser(),"Alterou agendamento para placa "+this.placaTela);
        }

        if (confirma){
            tipoTela = 0;
            this.placaTela = null;
            Alerts.showAlert("Atenção","Correção gravada no agendamento",null, Alert.AlertType.CONFIRMATION);
        }

        close(btGravar);

    }

    @FXML
    protected Button btCancel;

    @FXML
    protected Button btFechar;

    /**
     * Fechamento da tela
     */
    @FXML
    protected void btFecharButtonClick(){
        close(btFechar);
    }

    /**
     * Fechamento da tela
     */
    private void close(Button bt){
        Stage stage = (Stage)bt.getScene().getWindow();
        stage.close();
    }


    /**
     * Organiza a tela inicial confere datas e horas quando em alteração do agendamento
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblNumAgenda.setVisible(false);
        maskValid.maskPlaca(txtPlaca);
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

    /**
     * Coleta os dados da tela
     *
     * @return a Objeto Agenda
     */
    private Agenda coletaDados(){

        var a = new Agenda();

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

    /**
     * Preenche a tela quando carrega um item do agendamento
     *
     * @param placa do veículo
     */
    public void preencheDados(String placa){

        this.placaTela = placa;
        Agenda dados = agendaService.findByPlacaData(placa);
        lblNumAgenda.setVisible(true);
        lblNumAgenda.setText("Nº - "+dados.getCod());
        dpData.setValue(LocalDate.parse(dados.getDataAgenda()));
        txtHora.setText(dados.getHora());
        txtVeiculo.setText(dados.getVeiculo());
        txtPlaca.setText(dados.getPlaca());
        txtTelefone.setText(dados.getTelefone());
        txtNome.setText(dados.getNome());
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
