/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libratrack.barcodescanning.views.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Windyl
 */

public class SampleSceneLoader extends Application{
    public static void main(String args[]){
        Application.launch(args);   
        
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println(this.getClass().getResource("./Scene1.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("./Scene1.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
}
