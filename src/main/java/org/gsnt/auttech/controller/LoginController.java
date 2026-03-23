package org.gsnt.auttech.controller;

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
import org.gsnt.auttech.util.TesteConexao;
import org.gsnt.auttech.config.DaoFactory;
import org.gsnt.auttech.model.dao.FuncionarioDao;
import org.gsnt.auttech.inicio.IniDAO;
import org.gsnt.auttech.config.seg.SessionUserDao;
import org.gsnt.auttech.funcionario.Funcionario;
import org.gsnt.auttech.config.seg.SessionUser;
import org.gsnt.auttech.util.ExceptionGenerics;


import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private final FuncionarioDao func = DaoFactory.createFuncionarioDao();
    private final SessionUserDao log = DaoFactory.createSessionUserDao();
    private final IniDAO ini = DaoFactory.createIniDao();

    private final TesteConexao t = new TesteConexao();
    private int tntv = 0;//Tentativas de acesso

    @FXML
    private Label lblEmpresa;

    @FXML
    private PasswordField pfSenha;

    @FXML
    private ComboBox<Funcionario> cbUsuario;

    @FXML
    private TextField txtCNPJ;

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
        LbTipo.setText("CNPJ - ");
    }

    @FXML
    private RadioButton RbCpf;

    @FXML
    private void RbCpfOnAcion(){
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

            tela();
            executarTestes();
           // carregaCombo();

        }catch (Exception e){
            throw new ExceptionGenerics(e+" Erro na tela de login");
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
