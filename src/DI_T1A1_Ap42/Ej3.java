package DI_T1A1_Ap42;

import javafx.application.*;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Ej3 extends Application {
    
    @Override
    public void start (Stage primaryStage){
        System.out.println("Inicio");
        
        Button btn = new Button();
        btn.setText("Decir: 'Hola Mundo!'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hola Mundo!");
            }
        });
        
        StackPane  root = new StackPane ();
        root.getChildren().addAll(btn);
        
        Scene scene = new Scene(root, 400, 250);
        
        primaryStage.setTitle("Hola Mundo!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
         
    }
        
    
    public static void main(String[] args) {
        launch(args);
    }
}