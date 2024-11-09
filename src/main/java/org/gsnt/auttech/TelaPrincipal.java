package org.gsnt.auttech;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;



public class TelaPrincipal extends Application {


    private static Scene mainScene;


    @Override
    public void start(Stage mainStage) throws IOException{

        FXMLLoader fxmlLoader = new FXMLLoader(TelaPrincipal.class.getResource("TelaPrincipal.fxml"));
        mainScene = new Scene(fxmlLoader.load(),1210,900);
        mainStage.setTitle("");
        mainStage.initStyle(StageStyle.UNDECORATED);
        mainStage.setResizable(false);
        mainStage.setIconified(false);
        mainStage.setScene(mainScene);
        mainStage.show();

    }

    public static Scene getMainScene(){
        return mainScene;
    }


    public static void main(String[] args){
        launch();
    }


}
