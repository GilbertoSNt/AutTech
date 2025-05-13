package org.gsnt.auttech.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.gsnt.auttech.model.dao.DaoFactory;
import org.gsnt.auttech.model.dao.EmailDao;
import org.gsnt.auttech.model.dao.EnderecoDao;
import org.gsnt.auttech.model.dao.FuncionarioDao;
import org.gsnt.auttech.model.entities.*;
import org.gsnt.auttech.util.DadosCombos;
import org.gsnt.auttech.util.MaskValid;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class CadFuncionariosController implements Initializable {


    private FuncionarioDao funcService = DaoFactory.createFuncionarioDao();

    private EnderecoDao endService = DaoFactory.createEnderecoDao();

    private EmailDao emailService = DaoFactory.createEmailDao();



    @FXML
    private Button btClose;

    @FXML
    private void onBtClose(){
        Stage stage = (Stage)btClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btGravar;

    @FXML
    private void onBtGravar(){
        try {
            cadastraFuncionario(coletaDadosFuncionario(false, 0), coletaDadosEndereco(false,0), coletaDadosEmail(false,0));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private Button btEditar;


    @FXML
    private Button btDesativar;

    @FXML
    private Button btCancelar;

    @FXML
    private void btCancelarOnButtonClick(){
        onBtClose();
    }

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtRg;

    @FXML
    private DatePicker dpDataNasc;

    @FXML
    private void hiddendpDataNasc(){
        rbMasculino.requestFocus();
    }

    @FXML
    private ComboBox<TipoEndereco> cbTipoEndereco;

    @FXML
    private void hiddencbTipoEndereco(){
        txtEnd.requestFocus();
    }

    @FXML
    private TextField txtEnd;

    @FXML
    private TextField txtNum;

    @FXML
    private TextField txtComplemento;

    @FXML
    private TextField txtBairro;

    @FXML
    private TextField txtCidade;

    @FXML
    private ComboBox<Estados> cbEstado;

    @FXML
    private void hiddencbEstado(){
        txtCep.requestFocus();
    }

    @FXML
    private TextField txtCep;

    @FXML
    private TextArea txaObs;

    @FXML
    private DatePicker dpAdmissao;

    @FXML
    private void hiddendpDataAdmissao(){
        rbProd.requestFocus();
    }

    @FXML
    private DatePicker dpDesligamento;

    @FXML
    private TextField txtNumCartProf;

    @FXML
    private TextField txtDataEmis;

    @FXML
    private TextField txtFuncao;

    @FXML
    private TextField txtCargo;

    @FXML
    private TextArea txaObsProf;

    @FXML
    private CheckBox cbCaixaMec;

    @FXML
    private CheckBox cbCaixaAut;

    @FXML
    private CheckBox cbEletrica;

    @FXML
    private CheckBox cbFreio;

    @FXML
    private CheckBox cbInjDiesel;

    @FXML
    private CheckBox cbInjFlex;

    @FXML
    private CheckBox cbMotorDiesel;

    @FXML
    private CheckBox cbMotorFlex;

    @FXML
    private CheckBox cbPneu;

    @FXML
    private CheckBox cbSuspensao;

    @FXML
    private CheckBox cbSocorro;

    @FXML
    private CheckBox cbVeicEletrico;

    @FXML
    private CheckBox cbMotoristaLeva;

    @FXML
    private CheckBox cbMotoristaGuincho;

    @FXML
    private RadioButton rbAdm;

    @FXML
    private RadioButton rbProd;

    @FXML
    private RadioButton rbAdmAux;

    @FXML
    private RadioButton rbProdAux;

    @FXML
    private RadioButton rbApre;

    @FXML
    private Label labelAlertaCPF;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtMae;

    @FXML
    private TextField txtPai;

    @FXML
    private TextField txtEsposa;

    @FXML
    private TextField txtQuantFilho;

    @FXML
    private TextField txtTelefoneConjuge;

    @FXML
    private RadioButton rbMasculino;

    @FXML
    private RadioButton rbFeminino;

    @FXML
    private CheckBox cbComissao;

    @FXML
    private TextField txtComissaoPecas;

    @FXML
    private TextField txtComissaoServico;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtSalario;

    @FXML
    private Tab tabDadosProf;

    @FXML
    private Tab tabDadosEsp;

    private DadosCombos dadosCombos = new DadosCombos();

    private ObservableList<TipoEndereco> obsListTipoEndereco;

    private ObservableList<Estados> obsListEstados;

    private MaskValid mascara = new MaskValid();

    private void carregaCombo(){

        obsListTipoEndereco = FXCollections.observableList(dadosCombos.tipoEndereco());
        cbTipoEndereco.setItems(obsListTipoEndereco);
        Callback<ListView<TipoEndereco>, ListCell<TipoEndereco>> factory = lv -> new ListCell<TipoEndereco>() {
            @Override
            protected void updateItem(TipoEndereco tipo, boolean empty){
                super.updateItem(tipo, empty);
                setText(empty ? "" : tipo.getTipo());
            }
        };
        cbTipoEndereco.setCellFactory(factory);
        cbTipoEndereco.setButtonCell(factory.call(null));

        obsListEstados = FXCollections.observableList(dadosCombos.dadoEstados());
        cbEstado.setItems(obsListEstados);
        Callback<ListView<Estados>, ListCell<Estados>> factory1 = lv -> new ListCell<Estados>() {
            @Override
            protected void updateItem(Estados estado, boolean empty){
                super.updateItem(estado, empty);
                setText(empty ? "" : estado.getSigla());
            }
        };
        cbEstado.setCellFactory(factory1);
        cbEstado.setButtonCell(factory1.call(null));

    }

    private void carregaMascara(){

        mascara.maskData(dpDataNasc);
        mascara.maskData(dpAdmissao);
        mascara.maskData(dpDesligamento);
        mascara.maskCPF(txtCpf);
        mascara.maskkCEP(txtCep);
        mascara.maskTel9Dig(txtTelefone);
        mascara.maskTel9Dig(txtTelefoneConjuge);
        mascara.maskValor(txtSalario);


    }

    protected void radio(){

        ToggleGroup radioGroup = new ToggleGroup();
        rbAdm.setToggleGroup(radioGroup);
        rbProd.setToggleGroup(radioGroup);
        rbProdAux.setToggleGroup(radioGroup);
        rbAdmAux.setToggleGroup(radioGroup);
        rbApre.setToggleGroup(radioGroup);
        rbProd.setSelected(true);

        ToggleGroup radioGroup2 = new ToggleGroup();
        rbFeminino.setToggleGroup(radioGroup2);
        rbMasculino.setToggleGroup(radioGroup2);
        rbMasculino.setSelected(true);

    }

    private Funcionario coletaDadosFuncionario(Boolean editar, int cod){

        Funcionario func = new Funcionario();

        func.setNome(txtNome.getText());
        func.setCpf(txtCpf.getText());
        func.setRg(txtRg.getText());
        if (dpDataNasc.getValue() == null){
            func.setDataNasc("");
        }else{
            func.setDataNasc(dpDataNasc.getValue().toString());
        }
        if(rbFeminino.isSelected()){
            func.setGenero(true);
        }else if(rbMasculino.isSelected()){
            func.setGenero(false);
        }
        if(dpDesligamento.getValue() == null) {
            func.setStatus(true);
        }else{
            func.setStatus(false);
        }
        func.setTelefone(txtTelefone.getText());
        func.setMae(txtMae.getText());
        func.setPai(txtPai.getText());
        func.setConjuge(txtEsposa.getText());
        func.setQtdFilhos(Integer.parseInt(txtQuantFilho.getText()));
        func.setTelConjuge(txtTelefoneConjuge.getText());
        func.setObs(txaObs.getText());
        if (dpAdmissao.getValue() == null){
            func.setDataAdm("");
        }else{
            func.setDataAdm(dpAdmissao.getValue().toString());
        }
        if (dpDesligamento.getValue() == null){
            func.setDataDesl("");
        }else{
            func.setDataDesl(dpDesligamento.getValue().toString());
        }
        int tipoFuncionario = 0;
        if(rbAdm.isSelected()){
            tipoFuncionario = 1;
        }else if(rbAdmAux.isSelected()){
            tipoFuncionario = 2;
        }else if(rbProd.isSelected()){
            tipoFuncionario = 3;
        }else if(rbProdAux.isSelected()){
            tipoFuncionario = 4;
        }else if(rbApre.isSelected()){
            tipoFuncionario = 5;
        }
        func.setTipoFunc(tipoFuncionario);
        func.setCartProfissional(txtNumCartProf.getText());
        func.setDataemissao(txtDataEmis.getText());
        func.setFuncao(txtFuncao.getText());
        func.setCargo(txtCargo.getText());
        func.setComissao(cbComissao.isSelected());
        func.setComissaoPecas(txtComissaoPecas.getText());
        func.setComissaoServicos(txtComissaoServico.getText());
        func.setSalario(txtSalario.getText());
        func.setObsProf(txaObsProf.getText());
        func.setCaixaMec(cbCaixaMec.isSelected());
        func.setCaixaAut(cbCaixaAut.isSelected());
        func.setEletrica(cbEletrica.isSelected());
        func.setFreio(cbFreio.isSelected());
        func.setInjFlex(cbInjFlex.isSelected());
        func.setInjDiesel(cbInjDiesel.isSelected());
        func.setMotorDiesel(cbMotorDiesel.isSelected());
        func.setMotorFlex(cbMotorFlex.isSelected());
        func.setPneus(cbPneu.isSelected());
        func.setSuspensao(cbSuspensao.isSelected());
        func.setSocorro(cbSocorro.isSelected());
        func.setVeicEletricos(cbVeicEletrico.isSelected());
        func.setMotLeva(cbMotoristaLeva.isSelected());
        func.setMotguincho(cbMotoristaGuincho.isSelected());


        return func;
    }

    private Endereco coletaDadosEndereco(Boolean editar, int cod){

        Endereco end = new Endereco();
        end.setTipoCaso(3);
        end.setTipoEnd(cbTipoEndereco.getValue().getId());
        end.setEndereco(txtEnd.getText());
        end.setNumero(txtNum.getText());
        end.setBairro(txtBairro.getText());
        end.setCep(txtCep.getText());
        end.setComplemento(txtComplemento.getText());
        end.setCidade(txtCidade.getText());
        end.setEstado(cbEstado.getValue().getId());

        return end;

    }

    private Email coletaDadosEmail(Boolean editar,int cod){

        Email email = new Email();
        email.setCodCaso(3);
        email.setTipo(0);
        email.setEmail(txtEmail.getText());

        return email;

    }

    public void cadastraFuncionario(Funcionario func, Endereco end, Email email1){

        // Caso tem de ser 3
        Funcionario funcionario = func;
        Endereco endereco = end;
        Email email = email1;
        int codigo = funcService.saveFuncionario(funcionario);
        endereco.setCodExterno(codigo);
        email.setCodExterno(codigo);
        endService.saveEndereco(endereco);
        emailService.saveEmail(email);


    }

    private void teclaEnter(){

        txtNome.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtCpf.requestFocus();
            }
        });

        txtCpf.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER && mascara.isCPF(txtCpf.getText())){
                if (mascara.isCPF(txtCpf.getText())){
                    txtRg.requestFocus();
                    labelAlertaCPF.setVisible(false);
                }else{
                    labelAlertaCPF.setVisible(true);
                }
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtNome.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ENTER && mascara.isCPF(txtCpf.getText())!=true) {
                labelAlertaCPF.setVisible(true);
            }
        });

        txtRg.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                dpDataNasc.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtCpf.requestFocus();
            }
        });

        rbMasculino.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtEmail.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                dpDataNasc.requestFocus();
            }
        });

        rbFeminino.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtEmail.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                dpDataNasc.requestFocus();
            }
        });

        txtEmail.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                cbTipoEndereco.show();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                rbMasculino.requestFocus();
            }
        });


        txtEnd.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtNum.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                cbTipoEndereco.show();
            }
        });

        txtNum.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtComplemento.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtEnd.requestFocus();
            }
        });

        txtComplemento.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtBairro.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtNum.requestFocus();
            }
        });

        txtBairro.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtCidade.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtComplemento.requestFocus();
            }
        });

        txtCidade.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                cbEstado.show();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtBairro.requestFocus();
            }
        });

        cbEstado.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtCep.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtCidade.requestFocus();
            }
        });

        txtCep.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtTelefone.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                cbEstado.show();
            }
        });

        txtTelefone.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtMae.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtCep.requestFocus();
            }
        });

        txtMae.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtPai.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtTelefone.requestFocus();
            }
        });

        txtPai.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtEsposa.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtMae.requestFocus();
            }
        });

        txtEsposa.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtQuantFilho.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtPai.requestFocus();
            }
        });

        txtQuantFilho.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtTelefoneConjuge.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtEsposa.requestFocus();
            }
        });

        txtTelefoneConjuge.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txaObs.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtQuantFilho.requestFocus();
            }
        });

        txaObs.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtCidade.requestFocus();
            }
        });

        rbAdm.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtNumCartProf.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                dpAdmissao.requestFocus();
                dpAdmissao.show();
            }
        });

        rbAdmAux.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtNumCartProf.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                dpAdmissao.requestFocus();
                dpAdmissao.show();
            }
        });

        rbProd.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtNumCartProf.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                dpAdmissao.requestFocus();
                dpAdmissao.show();
            }
        });

        rbProdAux.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtNumCartProf.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                dpAdmissao.requestFocus();
                dpAdmissao.show();
            }
        });

        rbApre.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtNumCartProf.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                dpAdmissao.requestFocus();
                dpAdmissao.show();
            }
        });

        txtNumCartProf.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtDataEmis.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                rbProd.requestFocus();
            }
        });

        txtDataEmis.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtFuncao.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtNumCartProf.requestFocus();
            }
        });

        txtFuncao.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtCargo.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtDataEmis.requestFocus();
            }
        });

        txtCargo.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                cbComissao.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtCargo.requestFocus();
            }
        });

        cbComissao.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtComissaoPecas.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtCargo.requestFocus();
            }
        });

        txtComissaoPecas.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtComissaoServico.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                cbComissao.requestFocus();
            }
        });

        txtComissaoServico.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtSalario.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtComissaoPecas.requestFocus();
            }
        });

        txtSalario.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txaObsProf.requestFocus();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtComissaoServico.requestFocus();
            }
        });

        txaObsProf.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtSalario.requestFocus();
            }
        });
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        txtNome.requestFocus();
        carregaMascara();
        carregaCombo();
        teclaEnter();
        labelAlertaCPF.setVisible(false);
        radio();

    }
}
