package org.gsnt.auttech;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.gsnt.auttech.db.DB;
import org.gsnt.auttech.db.DB2;
import org.gsnt.auttech.db.DbException;
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


    @Override
    public void start(Stage mainStage) throws IOException {


        Image icon = new Image(getClass().getResourceAsStream("icones/AuttechIcon64.png"));
        mainStage.getIcons().add(icon);

        if (!hasInternetConnection()) {

            Optional<ButtonType> result = Alerts.showConfirmation("Atenção", "Verifique sua conexão de internet\n\n " +
                    "- Sem conexão de internet as funções do\n software estarão limitadas.\n\n " +
                    "- Se continuar será testado a conexão\n com o bando de dados local.\n\n"
            );

            if (result.get() == ButtonType.OK) {
                try {
                    if (!DB.testBd()) {
                        Alerts.showAlert("Atenção", "Sem conexão com o servidor\ndo banco de dados local", null, Alert.AlertType.ERROR);
                        log.escreveErro("Classe Main - Sem conexão com o banco de dados local");
                    } else {
                        chamaTela(mainStage);
                    }
                } catch (SQLException e) {
                    // sem tratamento
                }
            } else if (result.get() == ButtonType.CANCEL) {
                System.exit(0);
            }
        } else {
            try {
                if (!DB.testBd()) {
                    Alerts.showAlert("Atenção", "Sem conexão com o servidor\ndo banco de dados local", null, Alert.AlertType.ERROR);
                    log.escreveErro("Classe Main - Sem conexão com o banco de dados local");

                } else if (!DB2.testBdRemoto()) {
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
            } catch (Exception e) {
                throw new DbException(e.getMessage());
            }
        }

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
            throw new ExceptionGenerics("Erro no carregamento da tela de login");
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
            throw new ExceptionGenerics("Erro no carregamento da tela de login");
        }

    }

    private boolean hasInternetConnection() {
        try {
            URL url = new URL("http://www.google.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(60);
            conn.connect();
            return conn.getResponseCode() == 200;
        } catch (Exception e) {
            return false;
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
