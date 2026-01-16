package org.gsnt.auttech.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.gsnt.auttech.model.dao.DaoFactory;
import org.gsnt.auttech.model.dao.ProfServDao;
import org.gsnt.auttech.model.dao.FuncionarioDao;
import org.gsnt.auttech.model.entities.Direcionados;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaAtendFuncController implements Initializable {

    private FuncionarioDao funcionarioServ =  DaoFactory.createFuncionarioDao();
    private ProfServDao dirService = DaoFactory.createDirecionadosDao();
    private ObservableList<Direcionados> lista;

    @FXML
    private Button btClose;

    @FXML
    private TableView tvAtendimento;

    @FXML
    private TableColumn<Direcionados, String> tcPlaca;

    @FXML
    private TableColumn<Direcionados, String> tcTempo;

    @FXML
    private TableColumn<Direcionados, Integer> tcPriori;

    @FXML
    private TableColumn<Direcionados, Boolean> TcAceite;



    @FXML
    private void onBtClose(){
        Stage stage = (Stage)btClose.getScene().getWindow();
        stage.close();
    }

    private void initializeNodes(){
        tcPlaca.setCellValueFactory(new PropertyValueFactory<Direcionados, String>("placa"));
        tcTempo.setCellValueFactory(new PropertyValueFactory<Direcionados, String>("tmpPrvst"));
        tcPriori.setCellValueFactory(new PropertyValueFactory<Direcionados, Integer>("rdmTndmnt"));
        TcAceite.setCellValueFactory(new PropertyValueFactory<Direcionados, Boolean>("aceito"));
        TcAceite.setCellFactory(CheckBoxTableCell.forTableColumn(TcAceite));
    }

    public void chamada(String apelido){
        updateTableView(apelido);
    }

    private void updateTableView(String cod){

        lista = FXCollections.observableArrayList(dirService.listaServPorFuncionarios(funcionarioServ.findFuncByApelido(cod)));
        tvAtendimento.setItems(lista);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initializeNodes();

    }
}
