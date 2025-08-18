package org.gsnt.auttech.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.gsnt.auttech.TelaPrincipal;
import org.gsnt.auttech.model.dao.*;
import org.gsnt.auttech.model.entities.*;
import org.gsnt.auttech.util.Alerts;
import org.gsnt.auttech.util.ExceptionGenerics;
import org.gsnt.auttech.util.MaskValid;
import org.gsnt.auttech.util.Utils;

import java.util.Optional;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class CriaOsController implements Initializable {

    private ModeloVeiculoDao modeloService = DaoFactory.createModeloVeiculoDao();
    private MarcaVeiculoDao marcaService = DaoFactory.createMarcaVeiculoDao();
    private ClienteDao clienteService = DaoFactory.createClienteDao();
    private VeiculoDao veiculoService = DaoFactory.createVeiculoDao();
    private OrdemServicoDao ordemServicoService = DaoFactory.createOrdemServicoDao();
    private StatusAtendimentoDao statusService = DaoFactory.createStatusAtendimentoDao();
    private OrcamentoDao orcamentoService = DaoFactory.createOrcamentoDao();
    private Utils ut = new Utils();

    private int codVeiculo = 0;

    private MaskValid mascara = new MaskValid();

    @FXML
    private TextField txtPlaca;

    @FXML
    private Label lblNomeCliente;

    @FXML
    private Label lblVeiculo;

    @FXML
    private Button btCadVeiculo;

    @FXML
    private void onbtCadastraVeiculo(){
        verificaCadastro(txtPlaca.getText());
    }

    @FXML
    private Button btGravar;

    @FXML
    private void onbtGravar(){

        coletaSalvaDados(cbOrc.isSelected());
        onbtCloseButtonClick();

    }

    @FXML
    private Button btCancel;

    @FXML
    private Button btFechar;

    @FXML
    private Button btClose;

    @FXML
    protected void onbtCloseButtonClick(){
        Stage stage = (Stage)btClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private TextArea txaDescricao;

    @FXML
    private CheckBox cbRevisao;

    @FXML
    private CheckBox cbTrcOleo;

    @FXML
    private CheckBox cbMec;

    @FXML
    private CheckBox cbSuspDt;

    @FXML
    private CheckBox cbSuspTr;

    @FXML
    private CheckBox cbFreioDt;

    @FXML
    private CheckBox cbFreioTr;

    @FXML
    private CheckBox cbMotor;

    @FXML
    private CheckBox cbInjElet;

    @FXML
    private CheckBox cbElet;

    @FXML
    private CheckBox cbCaixa;

    @FXML
    private CheckBox cbAlinBalan;

    @FXML
    private CheckBox cbPneu;

    @FXML
    private CheckBox cbLevVei;

    @FXML
    private CheckBox cbOrc;

    @FXML
    private CheckBox cbLava;

    //   ainda falta dados(Busca cadastro)
    //  troca de óleo implementação

    public void preencheDadosAgenda(Agenda agenda){

        txtPlaca.setText(agenda.getPlaca());
        cbRevisao.setSelected(agenda.getsRevisao());
        cbSuspDt.setSelected(agenda.getsSuspensao());
        cbSuspTr.setSelected(agenda.getsSuspensao());
        cbInjElet.setSelected(agenda.getsInjecao());
        cbAlinBalan.setSelected(agenda.getsPneus());
        cbTrcOleo.setSelected(agenda.getsTrocaOleo());
        cbFreioDt.setSelected(agenda.getsFreio());
        cbFreioTr.setSelected(agenda.getsFreio());
        cbElet.setSelected(agenda.getsEletrico());
        cbMec.setSelected(agenda.getsMecanico());
        cbMotor.setSelected(agenda.getsMotor());
        cbCaixa.setSelected(agenda.getsCaixa());
        cbLevVei.setSelected(agenda.getAssLevar());
        txaDescricao.setText(agenda.getObs());
        verificaCadastro(agenda.getPlaca());

    }

    private void verificaCadastro(String placa){

        int teste = veiculoService.verificaPlaca(placa);
        if(teste != 0){
            Veiculo veiculo =  veiculoService.findById(placa);
            Cliente cli = clienteService.findById(clienteService.findIdClienteByIdVeiculo(veiculo.getCod()));
            preencheTelaComplemento(veiculo,cli);
        }else if(placa.length() == 8){
            Optional<ButtonType> result = Alerts.showConfirmation("Placa não cadastrada ou informação errada", "Placa não cadastrada ou informação errada. Confirma cadastro de novo veículo ?");
            if (result.get() == ButtonType.OK) {
                cadastraVeiculo(placa);
            }
        }else{
            Alerts.showAlert("Atenção","Placa fora do padrão, redigite a placa",null, Alert.AlertType.ERROR);
            cadastraVeiculo();
        }

    }

    private void coletaSalvaDados(Boolean cria){
        try {

            StatusAtendimento sa = new StatusAtendimento();
            OrdemServico os = new OrdemServico();

            os.setCodVeiculo(veiculoService.findCodById(txtPlaca.getText()));
            os.setCodCliente(clienteService.findIdClienteByIdVeiculo(os.getCodVeiculo()));
            os.setDataAbertura(ut.returnDateSystemBanco());
            os.setHoraAbertura(ut.returnTimeSystem());
            sa.setCodVeiculo(os.getCodVeiculo());

            if (cbOrc.isSelected()) {
                sa.setOrMontagem((byte) 11);
                sa.setOrStCliente((byte) 0);
            }

            if (cbRevisao.isSelected()) {
                sa.setRevisao((byte) 1);
                sa.setMecanico((byte) 1);
                sa.setEletrico((byte) 1);
                sa.setInjecao((byte) 1);
                sa.setFreioDt((byte) 1);
                sa.setFreioTr((byte) 1);
                sa.setSuspensaoDt((byte) 1);
                sa.setSuspensaoTr((byte) 1);
                sa.setCaixa((byte) 1);
                sa.setMotor((byte) 1);
                sa.setTrocaOleo((byte) 1);
                sa.setPneus((byte) 1);
                if (cbOrc.isSelected()) {
                    sa.setOrCambio((byte) 11);
                    sa.setOrEletrico((byte) 11);
                    sa.setOrMotor((byte) 11);
                    sa.setOrInjecao((byte) 11);
                    sa.setOrMecanica((byte) 11);
                    sa.setOrPneu((byte) 11);
                }
            }
            if (cbElet.isSelected()) {
                sa.setEletrico((byte) 1);
                if (cbOrc.isSelected()) {
                    sa.setOrEletrico((byte) 11);
                }
            }
            if (cbInjElet.isSelected()) {
                sa.setInjecao((byte) 1);
                if (cbOrc.isSelected()) {
                    sa.setOrInjecao((byte) 11);
                }
            }
            if (cbMec.isSelected()) {
                sa.setMecanico((byte) 1);
                if (cbOrc.isSelected()) {
                    sa.setOrMecanica((byte) 11);
                }
            }
            if (cbFreioDt.isSelected()) {
                sa.setFreioDt((byte) 1);
                sa.setMecanico((byte) 1);
                if (cbOrc.isSelected()) {
                    sa.setOrMecanica((byte) 11);
                }
            }
            if (cbFreioTr.isSelected()) {
                sa.setFreioTr((byte) 1);
                sa.setMecanico((byte) 1);
                if (cbOrc.isSelected()) {
                    sa.setOrMecanica((byte) 11);
                }
            }
            if (cbSuspDt.isSelected()) {
                sa.setSuspensaoDt((byte) 1);
                sa.setMecanico((byte) 1);
                if (cbOrc.isSelected()) {
                    sa.setOrMecanica((byte) 11);
                }
            }
            if (cbSuspTr.isSelected()) {
                sa.setSuspensaoTr((byte) 1);
                sa.setMecanico((byte) 1);
                if (cbOrc.isSelected()) {
                    sa.setOrMecanica((byte) 11);
                }
            }
            if (cbCaixa.isSelected()) {
                sa.setCaixa((byte) 1);
                if (cbOrc.isSelected()) {
                    sa.setOrCambio((byte) 11);
                }
            }
            if (cbMotor.isSelected()) {
                sa.setMotor((byte) 1);
                if (cbOrc.isSelected()) {
                    sa.setOrMotor((byte) 11);
                }
            }

            if (cbTrcOleo.isSelected()) {
                sa.setTrocaOleo((byte) 1);
                sa.setMecanico((byte) 1);
                if (cbOrc.isSelected()) {
                    sa.setOrMecanica((byte) 11);
                }
            }

            if (cbPneu.isSelected() || cbAlinBalan.isSelected()) {
                sa.setPneus((byte) 1);
                if (cbOrc.isSelected()) {
                    sa.setOrPneu((byte) 11);
                }
            }

            if (cbLava.isSelected()) {
                sa.setLavacao((byte) 1);
            }

            os.setNecOrcamento(cbOrc.isSelected());
            os.setAssLevarVeiculo(cbLevVei.isSelected());
            sa.setStGeralAtend((byte) 1);
            if (cria) {
                Orcamento or1 = new Orcamento(ut.returnDateSystemBanco(), os.getCodVeiculo(), os.getCodCliente());
                sa.setCodOrcamento(orcamentoService.criaOrcamento(or1));
                os.setStatusOs((byte) 1);
                sa.setCodOs(ordemServicoService.criaOrdemServico(os));

                ordemServicoService.relacaoOsOr(sa.getCodOs(), sa.getCodOrcamento());
                if (cbOrc.isSelected()) {
                    sa.setOrStCliente((byte) 0);
                    sa.setOrMontagem((byte) 11);
                    sa.setOrStCliente((byte) 17);
                    statusService.statusOsInicial(sa, cbOrc.isSelected());
                } else {
                    statusService.statusOsInicial(sa);
                }
            } else if (!cbOrc.isSelected()) {
                sa.setCodOs(ordemServicoService.criaOrdemServico(os));
                statusService.statusOsInicial(sa);
            }
            //
        }
        catch (RuntimeException e){
            System.out.println("CriaOs - coletaDados - "+e.getMessage());
        }


    }

    private void cadastraVeiculo(){
        loadView("/org/gsnt/auttech/CadVeiculo.fxml",x->{});
    }

    private void cadastraVeiculo(String placa){

        loadView("/org/gsnt/auttech/CadVeiculo.fxml",(CadVeiculoController cadVeicControl) ->{
            cadVeicControl.txtPlaca.setText(placa);
        });
            //implementar placa na tela, verificar segunda entrada no banco, verificar segunda chamada do método
    }


    private synchronized<T> void loadView(String absoluteName, Consumer<T> inicializingAction) {
        try {

            FXMLLoader loader = new FXMLLoader(TelaPrincipal.class.getResource(absoluteName));
            Scene secundaryScene = new Scene(loader.load());

            CadVeiculoController cadVeiculoController = loader.getController();

            Stage stage1 = new Stage();
            stage1.setIconified(false);
            stage1.setResizable(false);
            stage1.setTitle("");
            stage1.initStyle(StageStyle.UNDECORATED);
            stage1.initModality(Modality.APPLICATION_MODAL);
            stage1.initOwner(TelaPrincipal.getMainScene().getWindow());
            stage1.setScene(secundaryScene);

            T controller = loader.getController();
            inicializingAction.accept(controller);

            stage1.showAndWait();

            codVeiculo = cadVeiculoController.getDadosOs();
            if (codVeiculo != 0){
                Veiculo veiculo =  veiculoService.findByCod(codVeiculo);
                Cliente cli = clienteService.findById(clienteService.findIdClienteByIdVeiculo(codVeiculo));
                preencheTelaComplemento(veiculo,cli);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void preencheTelaComplemento(Veiculo veiculo, Cliente cliente){
        txtPlaca.setText(veiculo.getPlaca());
        lblVeiculo.setText(marcaService.findMarcaById(veiculo.getMarca())+" / "+modeloService.findModeloById(veiculo.getModelo())+" / Ano - "+veiculo.getAnof()
                +" / Ano modelo - "+veiculo.getAnom()+" / Motor - "+veiculo.getMotor());
        lblNomeCliente.setText(cliente.getNome());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mascara.maskPlaca(txtPlaca);
        txtPlaca.setPromptText("___-____");

        txtPlaca.setOnKeyPressed((KeyEvent)->{
            if(txtPlaca.getLength() == 8) {
                if (KeyEvent.getCode() == KeyCode.ENTER) {
                    verificaCadastro(txtPlaca.getText());
                }
            }
        });

    }





}
