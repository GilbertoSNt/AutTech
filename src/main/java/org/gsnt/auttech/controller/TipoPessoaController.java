package org.gsnt.auttech.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.gsnt.auttech.TelaPrincipal;
import org.gsnt.auttech.db.DbException;

import java.io.IOException;

public class TipoPessoaController {



    @FXML
    private Button btPessoaFisica;

    @FXML
    private void onbtPessoaFisica(){
        loadView("/org/gsnt/auttech/CadClienteF.fxml");
        Stage stage = (Stage)btPessoaFisica.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btPessoaJuridica;

    @FXML
    private void onbtPessoaJuridica(){
        loadView("/org/gsnt/auttech/CadClienteJ.fxml");
        Stage stage = (Stage)btPessoaJuridica.getScene().getWindow();
        stage.close();
    }



    private void loadView(String absoluteName) {
        try {
            FXMLLoader loader = new FXMLLoader(TelaPrincipal.class.getResource(absoluteName));
            Scene secundaryScene = new Scene(loader.load());
            Stage stage1 = new Stage();
            stage1.setIconified(false);
            stage1.setResizable(false);
            stage1.setTitle("");
            stage1.initStyle(StageStyle.UNDECORATED);
            stage1.initModality(Modality.APPLICATION_MODAL);
            stage1.initOwner(TelaPrincipal.getMainScene().getWindow());
            stage1.setScene(secundaryScene);
            stage1.showAndWait();
        } catch (IOException e) {
            throw new DbException(e.getMessage()+" loadView - TipoPessoaController");
        }
    }

}
