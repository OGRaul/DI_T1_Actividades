/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DI_T1A1_Ap42;

import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;

/**
 *
 *
 */
public class Ej4 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        final Text actiontarget = new Text();
        
        //Creando botón
        Button btn = new Button();
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        btn.setText("   Sign in    ");
        btn.setOnAction((e) ->{ 
            
           
                System.out.println("Boton pulsado");
                    
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");
            
        });
        
        // Crenado el panel de coordenadas con su padding externo y espacio entre lineas(v) y columnas(h)
        GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));
            
        // Creando el escenario y escena
        Scene scene = new Scene(grid, 400, 300);
        
        primaryStage.setTitle("Formulario");
        primaryStage.setScene(scene);
        primaryStage.show(); 
        
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        // Creando el menú
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        
        Label lbtn = new Label ("Enviar: ");
        grid.add(lbtn, 0, 3);
        grid.add(hbBtn, 1, 3);
        
        grid.add(actiontarget, 1, 6);  
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
