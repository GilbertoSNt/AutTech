package org.gsnt.auttech;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.gsnt.auttech.db.*;
import org.gsnt.auttech.util.Alerts;
import org.gsnt.auttech.util.ExceptionGenerics;
import org.gsnt.auttech.util.LogTxt;
import javafx.scene.image.Image;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;


public class TelaPrincipal extends Application {


    private static Scene mainScene;
    private final LogTxt log = new LogTxt();
    private TesteConexao teste = new TesteConexao();


    @Override
    public void start(Stage mainStage) throws IOException {

        Image icon = new Image(getClass().getResourceAsStream("icones/AuttechIcon64.png"));
        mainStage.getIcons().add(icon);

        /*
        if(DBSttOn.getConnection()==null){
            Alerts.showAlert("Atenção", "Erro no DBSttOn", null, Alert.AlertType.ERROR);
        }

        if (!teste.testeInternet()) {

            Optional<ButtonType> result = Alerts.showConfirmation("Atenção", "Verifique sua conexão de internet\n\n " +
                    "- Sem conexão de internet as funções do\n software estarão limitadas.\n\n " +
                    "- Se continuar será testado a conexão\n com o bando de dados local.\n\n"
            );

            if (result.get() == ButtonType.OK) {
                try {
                    if (!teste.testeDbLocal()) {
                        Alerts.showAlert("Atenção", "Sem conexão com o servidor\ndo banco de dados local", null, Alert.AlertType.ERROR);
                        log.escreveErro("Classe Main - Sem conexão com o banco de dados local");
                    } else {
                        chamaTela(mainStage);
                    }
                } catch (Exception e) {
                    throw new DbException(e.getMessage()+" erro no metodo teste DB - Método main");
                }
            } else if (result.get() == ButtonType.CANCEL) {
                System.exit(0);
            }
        } else {
            try {
                if (!teste.testeDbLocal()) {
                    Alerts.showAlert("Atenção", "Sem conexão com o servidor\ndo banco de dados local", null, Alert.AlertType.ERROR);
                    log.escreveErro("Classe Main - Sem conexão com o banco de dados local");

                } else if (!teste.testeDbOn()) {
                    Optional<ButtonType> result1 = Alerts.showConfirmation("Atenção", "Não conseguimos conexão\n" +
                            "com o banco de dados auxiliar\n\n " +
                            "- Se continuar o software terá algumas limitações.\n\n"
                    );
                    if (result1.get() == ButtonType.OK) {
                        chamaTela(mainStage);
                    } else if (result1.get() == ButtonType.CANCEL) {
                        System.exit(0);
                    }
                }else{
                    chamaTela(mainStage);
                }
            }
            catch (Exception e) {
                throw new DbException(e.getMessage()+" teste Db1/2 - Método main");
            }
        }
*/
        chamaTela(mainStage);
    }

    private void telaLogin(){
        try {
            Image iconn = new Image(getClass().getResourceAsStream("icones/AuttechIcon64.png"));
            FXMLLoader loader = new FXMLLoader(TelaPrincipal.class.getResource("Login.fxml"));
            Parent splashRoot = loader.load();
            Scene splashScene = new Scene(splashRoot);
            Stage splashStage = new Stage();
            splashStage.getIcons().add(iconn);
            splashStage.initStyle(StageStyle.UNDECORATED);
            splashStage.setScene(splashScene);
            splashStage.showAndWait();
        }
        catch (Exception e){
            throw new ExceptionGenerics(e.getMessage()+" Erro no carregamento da tela de login");
        }
    }

    private void telaPrinc(Stage mainStage){
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(TelaPrincipal.class.getResource("TelaPrincipal.fxml"));
            mainScene = new Scene(fxmlLoader.load(),1210,900);
            mainStage.setTitle("");
            mainStage.initStyle(StageStyle.UNDECORATED);
            mainStage.setResizable(false);
            mainStage.setIconified(false);
            mainStage.setScene(mainScene);
            mainStage.show();
        }
        catch (Exception e){
            throw new ExceptionGenerics(e.getMessage()+" Erro no carregamento da tela de principal");
        }

    }

    private void chamaTela(Stage mainStage){

            telaLogin();
            telaPrinc(mainStage);

    }

    public static Scene getMainScene(){
        return mainScene;
    }

    public static void main(String[] args){
        launch();
    }


}
