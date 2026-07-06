package org.gsnt.auttech.usuario.login;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.gsnt.auttech.config.seg.CrypDao;
import org.gsnt.auttech.config.seg.CrypService;
import org.gsnt.auttech.util.*;
import org.gsnt.auttech.config.db.DaoFactory;
import org.gsnt.auttech.funcionario.FuncionarioDao;
import org.gsnt.auttech.inicio.IniDAO;
import org.gsnt.auttech.usuario.user.SessionUserDao;
import org.gsnt.auttech.funcionario.Funcionario;
import org.gsnt.auttech.usuario.user.SessionUser;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private FuncionarioDao func;
    private SessionUserDao log;
    //private final IniDAO ini = DaoFactory.createIniDao();
    private final CrypDao cry = new CrypService();
    private MaskValid maskValid;

    private final TesteConexao t = new TesteConexao();

    private int tntv = 0;//Tentativas de acesso

    private  String arq = "C:\\pen\\OfProg\\AutTech\\ini\\login.txt";

    private LogTxt g = new LogTxt();

    //Responsável pela comparação do código carregado do arquivo
    private String codInic = "";

    @FXML
    private Label lblEmpresa;

    @FXML
    private PasswordField pfSenha;

    @FXML
    private ComboBox<Funcionario> cbUsuario;

    @FXML
    private TextField txtCNPJ;

    @FXML
    private TextField txtCPF;

    @FXML
    private Button btAcesso;

    @FXML
    private Button btCancel;

    @FXML
    private Label LblWeb;

    @FXML
    private Label LblBdLocal;

    @FXML
    private Label LblBdRemoto;

    @FXML
    private Label LblStRemoto;

    @FXML
    private Label LbTipo;

    @FXML
    private RadioButton RbCnpj;

    @FXML
    private void RbCnpjOnAcion(){
        txtCNPJ.setVisible(true);
        txtCPF.setVisible(false);
        LbTipo.setText("CNPJ - ");
    }

    @FXML
    private RadioButton RbCpf;

    @FXML
    private void RbCpfOnAcion(){
        txtCNPJ.setVisible(false);
        txtCPF.setVisible(true);
        LbTipo.setText("CPF - ");
    }



    @FXML
    private void onBtAcesso(){

        String snh = pfSenha.getText();
        pfSenha.clear();
        System.out.println(txtCNPJ.getText());

        if(log.verificaEmpresa(txtCNPJ.getText())){  //erro aqui retorno em concatenação de integer e espera boolean

            SessionUser.setId(txtCNPJ.getText()+" - "+"Admin");

            /*
            if(log.loginSistema(cbUsuario.getValue().getApelido(),snh)) {

                SessionUser.setId(txtCNPJ.getText()+" - "+cbUsuario.getValue().getApelido());
                close(btAcesso);

            }else {

                tntv = tntv + 1;

            }

             */
        }
    }

    @FXML
    private void onBtCancel(){
        System.exit(0);
    }



    private void carregaCombo(){
        ObservableList obsUsr = FXCollections.observableList(func.findFuncCombo(1,2));
        cbUsuario.setItems(obsUsr);
        Callback<ListView<Funcionario>, ListCell<Funcionario>> factoryBalan = lv -> new ListCell<Funcionario>(){
            @Override
            protected void updateItem(Funcionario funcionario, boolean empty){
                super.updateItem(funcionario, empty);
                setText(empty ?"":funcionario.getApelido());
            }
        };
        cbUsuario.setCellFactory(factoryBalan);
        cbUsuario.setButtonCell(factoryBalan.call(null));
    }


    private void tela(){

        txtCNPJ.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER || KeyEvent.getCode() == KeyCode.TAB){
                cbUsuario.show();
            }
        });

        cbUsuario.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtCNPJ.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ENTER){
                pfSenha.requestFocus();
            }
        });

        pfSenha.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER || KeyEvent.getCode() == KeyCode.TAB){
                btAcesso.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                cbUsuario.show();
            }
        });

        ToggleGroup Tg1 = new ToggleGroup();

        RbCnpj.setToggleGroup(Tg1);
        RbCpf.setToggleGroup(Tg1);
        RbCnpj.setSelected(true);
        RbCnpj.requestFocus();
        txtCPF.setVisible(false);

        maskValid.maskCPF(txtCPF);
        maskValid.maskCNPJ(txtCNPJ);

        txtCPF.focusedProperty().addListener((observable, oldValue, newValue)->{

                if(!newValue) {
                    verificaRegistro(txtCPF);
                    cry.hashSenha(txtCPF.getText());
                }
        });

        txtCNPJ.focusedProperty().addListener((observable, oldValue, newValue)->{

            if(!newValue) {
                verificaRegistro(txtCNPJ);

            }
        });


    }

    /**
     * Verifica se o item digitado é o mesmo do gravado
     * se não for ele grava
     */
    private void verificaRegistro(TextField text){

        try {
            if (!codInic.equals(text.getText())) {

                Optional<ButtonType> result = Alerts.showConfirmation("Atenção", "Houve a digitação de um novo identificador. Confirma a mudança ?");

                if(result.get() == ButtonType.OK) {
                    System.out.println( cry.hashSenha(text.getText()));
                    g.escreve(2, text.getText());
                }else{
                    if(txtCNPJ.isDisabled()){
                        txtCPF.requestFocus();
                    }else if(txtCPF.isDisabled()){
                        txtCNPJ.requestFocus();
                    }
                }

            }
        }catch (Exception e){
            throw new ExceptionGenerics(e.getStackTrace()+" Login Controller - Verifica Registro");
        }

    }


    //separa aqui

    private void executarTestes() {
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() throws Exception {

                Thread.sleep(500);
                // Teste 1 - Internet
                Platform.runLater(() -> LblWeb.setText("Testando..."));
                Thread.sleep(500);
                boolean internet = t.testeInternet();
                Platform.runLater(() -> atualizaLabel(LblWeb, internet));


                // Teste 2 - BD Local
                Platform.runLater(() -> LblBdLocal.setText("Testando..."));
                Thread.sleep(500);
                boolean dbLocal = t.testeDbLocal();
                Platform.runLater(() -> atualizaLabel(LblBdLocal, dbLocal));

                // Teste 3 - BD Remoto
                Platform.runLater(() -> LblBdRemoto.setText("Testando..."));
                Thread.sleep(500);
                boolean dbOn = t.testeDbOn();
                Platform.runLater(() -> atualizaLabel(LblBdRemoto, dbOn));

                // Teste 4 - Servidor Remoto
                Platform.runLater(() -> LblStRemoto.setText("Testando..."));
                Thread.sleep(500);
                boolean dbSttOn = t.testeDbSttOn();
                Platform.runLater(() -> atualizaLabel(LblStRemoto, dbSttOn));

                return null;
            }
        };

        task.setOnFailed(e -> Platform.runLater(() -> {
            atualizaLabel(LblWeb, false);
            atualizaLabel(LblBdLocal, false);
            atualizaLabel(LblBdRemoto, false);
            atualizaLabel(LblStRemoto, false);
        }));

        Thread threadTestes = new Thread(task);
        threadTestes.setDaemon(true);
        threadTestes.start();
    }

    // Label genérico reutilizável
    private void atualizaLabel(Label label, boolean sucesso) {
        if (sucesso) {
            label.setTextFill(Color.GREEN);
            label.setText("OK");
        } else {
            label.setTextFill(Color.RED);
            label.setText("Falhou");
        }
    }

    //separa aqui

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

            maskValid = new MaskValid();
            tela();
            leArquivoIni();
            executarTestes();




            //func = DaoFactory.createFuncionarioDao();
            //log = DaoFactory.createSessionUserDao();

            // carregaCombo();

        }catch (Exception e){
            throw new ExceptionGenerics(e.getStackTrace()+" Erro na tela de login");
        }

    }

    private void leArquivoIni(){

        try {

            codInic = g.le();

            System.out.println(codInic);
                if (codInic.length() == 14 ){
                    txtCNPJ.setVisible(false);
                    txtCPF.setVisible(true);
                    RbCpf.setSelected(true);
                    txtCPF.setText(codInic);
                }else if(codInic.length() == 18 ) {
                    txtCNPJ.setVisible(true);
                    txtCPF.setVisible(false);
                    RbCnpj.setSelected(true);
                    txtCNPJ.setText(codInic);
                }

        } catch (Exception e) {
            throw new ExceptionGenerics(e.getStackTrace()+" LoginController - lerArquiviini");
        }
    }


    private void gravaCNPJ(){

    }

    private void fechaTela(){

    }

    private void close(Button bt){
        Stage stage = (Stage)bt.getScene().getWindow();
        stage.close();
    }


}
