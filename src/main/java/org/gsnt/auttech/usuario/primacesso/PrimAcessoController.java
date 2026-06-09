package org.gsnt.auttech.usuario.primacesso;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.gsnt.auttech.config.db.DaoFactory;
import org.gsnt.auttech.util.MaskValid;
import org.gsnt.auttech.entitiesgenerics.Empresa;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class PrimAcessoController implements Initializable {

    PrimAcessoDao pAServ = DaoFactory.createPrimAcessoDao();

    private MaskValid maskValid;

    @FXML
    private Label lbCNPJ;

    @FXML
    private Label lbNome;

    @FXML
    private RadioButton rbJuridico;

    @FXML
    private RadioButton rbFisico;

    @FXML
    private TextField txtCnpj;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtLogCPF;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtUser;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtConfirmarSenha;

    @FXML
    private ComboBox<Empresa> cbUnidade;

    @FXML
    private RadioButton rbDono;

    @FXML
    private RadioButton rbGerente;

    @FXML
    private Button btGravar;

    @FXML
    private Button btCancelar;

    private ToggleGroup rd1 = new ToggleGroup();

    private ToggleGroup rd2 = new ToggleGroup();

    @FXML
    private void onKeyPressedCNPJ(KeyEvent event){

        ResultSet rs = null;
        String cod = null;

        if (event.getCode() == KeyCode.ENTER){
            if (rbJuridico.isSelected()){
                cod = txtCnpj.getText();
                if(cod.length() == 14){

                    rs = pAServ.verificaCadEmpresa(cod);

                }
            }


            if (rbFisico.isSelected()){
                cod = txtCpf.getText();
                 if(cod.length() == 11){

                     rs = pAServ.verificaCadFisico(cod);

                }
            }

        }

    }

    private void salva(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tela();
        grupos();
    }

    private void tela(){
        txtCnpj.setVisible(false);
        txtLogCPF.setVisible(false);
        txtCnpj.setPromptText("__.___.___/____-__");
        maskValid.maskCNPJ(txtCnpj);
        txtLogCPF.setPromptText("000.000.000-00");
        maskValid.maskCPF(txtLogCPF);
        txtCpf.setPromptText("000.000.000-00");
        maskValid.maskCPF(txtCpf);
    }

    private void grupos(){

        rbDono.setToggleGroup(rd1);
        rbDono.setOnAction(event ->{
            lbCNPJ.setText("CNPJ -");
        });

        rbGerente.setToggleGroup(rd1);
        rbGerente.setOnAction(event ->{
            lbCNPJ.setText("CPF -");
        });

        rbFisico.setToggleGroup(rd2);
        rbJuridico.setToggleGroup(rd2);

        rbJuridico.setOnAction(Event->{
            if(rbJuridico.isSelected()){
                txtCnpj.setVisible(true);
                txtLogCPF.setVisible(false);
            }
        } );

        rbFisico.setOnAction(Event->{
            if(rbFisico.isSelected()){
                txtCnpj.setVisible(false);
                txtLogCPF.setVisible(true);
            }
        } );

    }

}
