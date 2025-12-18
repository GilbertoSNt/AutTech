package org.gsnt.auttech;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.gsnt.auttech.db.*;
import org.gsnt.auttech.util.ExceptionGenerics;
import org.gsnt.auttech.util.LogTxt;
import javafx.scene.image.Image;
import java.io.IOException;



public class TelaPrincipal extends Application {


    private static Scene mainScene;
    private final LogTxt log = new LogTxt();
    private TesteConexao teste = new TesteConexao();
    private static String id= "";


    @Override
    public void start(Stage mainStage) throws IOException {

        Image icon = new Image(getClass().getResourceAsStream("icones/AuttechIcon64.png"));
        mainStage.getIcons().add(icon);

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
            //mainStage.setTitle("teste");
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

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        TelaPrincipal.id = id;
    }
}
