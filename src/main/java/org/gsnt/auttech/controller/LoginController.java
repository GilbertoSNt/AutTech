package org.gsnt.auttech.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.gsnt.auttech.db.TesteConexao;
import org.gsnt.auttech.model.dao.DaoFactory;
import org.gsnt.auttech.model.dao.FuncionarioDao;
import org.gsnt.auttech.model.dao.IniDAO;
import org.gsnt.auttech.model.dao.LoginDAO;
import org.gsnt.auttech.model.entities.Funcionario;
import org.gsnt.auttech.model.entities.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private FuncionarioDao func = DaoFactory.createFuncionarioDao();
    private LoginDAO log = DaoFactory.createloginDao();
    private TesteConexao t = new TesteConexao();

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



    IniDAO ini = DaoFactory.createIniDao();

    @FXML
    private void onBtAcesso(){

        if(txtCNPJ.getLength() < 14){

            if(pfSenha.getText().equals("admin")) {
                Usuario.setUser("Admin");
                close(btAcesso);
            }
        }else {
            verificaEmpresa();
        }
    }

    @FXML
    private void onBtCancel(){
        System.exit(0);
    }

    private String verificaEmpresa(){

        String resultado = ini.verifica(txtCNPJ.getText());

        // implementar funções de verificação de cnpj

        return resultado;

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

    private void verificaSenha(){

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

        txtCNPJ.requestFocus();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //  carregaCombo();
        tela();
        if (t.testeInternet()) {
            LblWeb.setText("OK");
        } else {
            LblWeb.setTextFill(Color.RED);
            LblWeb.setText("Falhou");
        }

        if (t.testeDbLocal()) {
            LblBdLocal.setText("OK");
        } else {
            LblBdLocal.setTextFill(Color.RED);
            LblBdLocal.setText("Falhou");
        }

        if (t.testeDbOn()) {
            LblBdRemoto.setText("OK");
        } else {
            LblBdRemoto.setTextFill(Color.RED);
            LblBdRemoto.setText("Falhou");
        }

        if (t.testeDbSttOn()) {
            LblStRemoto.setText("OK");
        } else {
            LblStRemoto.setTextFill(Color.RED);
            LblStRemoto.setText("Falhou");
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
