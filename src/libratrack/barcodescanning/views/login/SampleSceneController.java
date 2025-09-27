/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package libratrack.barcodescanning.views.login;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;



/**
 *
 * @author Windyl
 */
public class SampleSceneController  {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void switchToScene1(ActionEvent event){
        try{
        root = FXMLLoader.load(getClass().getResource("./Scene1.fxml"));
        }
        
    }
    public void switchToScene2(ActionEvent event){
        
        
    }
    
   
    
}
