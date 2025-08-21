package org.gsnt.auttech.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.gsnt.auttech.model.dao.DaoFactory;
import org.gsnt.auttech.model.dao.IniDAO;
import org.gsnt.auttech.model.entities.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Label lblEmpresa;

    @FXML
    private PasswordField pfSenha;

    @FXML
    private ComboBox cbUsuario;

    @FXML
    private TextField txtCNPJ;

    @FXML
    private Button btAcesso;

    @FXML
    private Button btCancel;

    IniDAO ini = DaoFactory.createIniDao();

    @FXML
    private void onBtAcesso(){


        if(txtCNPJ.getLength() < 14){

            if(pfSenha.getText().equals("admin")) {
                Usuario.setUser("Admin1");
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
        return resultado;

    }

    private void carregaCombo(){
        ObservableList obsUsr = FXCollections.observableList(null);// arrumar aqui
        cbUsuario.setItems(obsUsr);
        Callback<ListView<String>, ListCell<String>> factoryBalan = lv -> new ListCell<String>(){
            @Override
            protected void updateItem(String funcionario, boolean empty){
                super.updateItem(funcionario, empty);
                setText(empty ?"":funcionario);
            }
        };
        cbUsuario.setCellFactory(factoryBalan);
        cbUsuario.setButtonCell(factoryBalan.call(null));
    }

    private void verificaSenha(){

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      //  carregaCombo();
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
