/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libratrack.barcodescanning;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Windyl
 */
public class LibraTrackBarcodeScanning  extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Application.launch(args);
    }
    
    public void start(Stage stage) {
         Label lbl = new Label("JavaFx Project");
        StackPane pane = new StackPane();
        pane.getChildren().add(lbl);
        Scene sc = new Scene(pane,600,400);
        stage.setTitle("Java Fx Project");
        stage.setScene(sc);
        
        
        stage.show();
        
    }
    
}
