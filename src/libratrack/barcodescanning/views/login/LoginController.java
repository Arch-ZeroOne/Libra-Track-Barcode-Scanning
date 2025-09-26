/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libratrack.barcodescanning.views.login;

/**
 *
 * @author Windyl
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
public class LoginController {
    
    @FXML
    private Hyperlink register; 
    
    private Stage primaryStage;
    private Scene scene;
    private Parent root;
    
    @FXML
    public void handleTransfer(ActionEvent e)throws Exception{
        root = FXMLLoader.load(getClass().getResource("SampleScene.fxml"));
        primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene (root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    
   
    
    
    
}
