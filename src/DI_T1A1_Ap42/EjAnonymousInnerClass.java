package DI_T1A1_Ap42;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author RaulOG
 */
public class EjAnonymousInnerClass extends Application implements EventHandler<ActionEvent> {
    //Definiendo variables
    Button btn;
    Button btn2;
    Button btn3;
    Button btn4;
@Override
    public void start (Stage primaryStage){
        System.out.println("Inicio");
        
        // Creando los botones
        btn = new Button();
        btn.setText("New");
        btn.setOnAction(this);
        
        btn2 = new Button();
        btn2.setText("Open");
        btn2.setOnAction(this);
        
        btn3 = new Button();
        btn3.setText("Save");
        btn3.setOnAction(this);
        
        btn4 = new Button();
        btn4.setText("Print");
        btn4.setOnAction(this);
        
        // Creando la caja para los botones
        HBox hbox = new HBox(btn,btn2,btn3,btn4);
        hbox.setAlignment(Pos.CENTER);
        HBox.setMargin(btn, new Insets(5, 5, 5,5));
        HBox.setMargin(btn2, new Insets(5, 5, 5,5));
        HBox.setMargin(btn3, new Insets(5, 5, 5,5));
        HBox.setMargin(btn4, new Insets(5, 5, 5,5));
        
        StackPane  root = new StackPane (hbox);
        
        Scene scene = new Scene(root, 400, 250);
        
        primaryStage.setTitle("AnonymousHandlerDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
        
         
    }

    
    public static void main(String[] args) {
        launch(args);
    }
   @Override
   public void handle(ActionEvent event){
       // Imprimimos por pantalla en base a la fuente del evento
       if (event.getSource() == btn){
           System.out.println("Nuevo proceso");
       }else
       if (event.getSource() == btn2){
           System.out.println("Abrir proceso");
       }else
       if (event.getSource() == btn3){
           System.out.println("Guardar proceso");
       } else
       if (event.getSource() == btn4){
           System.out.println("Imprimir proceso");
       }
       
        /* Esto deberia funiconar si switch soportara objetos...
       Object fuente;
       fuente = event.getSource().toString();
       System.out.println(fuente.toString());
      
        switch(fuente){
           case (btn):
               System.out.println("Nuevo proceso");
               break;
           case (btn2):
               System.out.println("Abrir proceso");
               break;
           case (btn3):
               System.out.println("Guardar proceso");
               break;
           case (btn4):
               System.out.println("Imprimir proceso");
               break;
       }
       */
       
   }
}
