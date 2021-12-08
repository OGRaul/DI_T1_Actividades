package DI_T1A1_Ap42;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


/**
 *
 * @author RaulOG
 */
public class EjControlCircle extends Application implements EventHandler<javafx.event.ActionEvent> {
    
    //Creating Buttons
    Button btn = null;
    Button btn1 = null;
    //Drawing a Circle
    int tamaño = 50;
    Circle circle = new Circle(tamaño);
@Override 
   public void start(Stage stage){
     

    
    //Setting the colors of the cicle
    circle.setStrokeWidth(3.0);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.WHITE);
    
    // Setting up the Buttons
    btn = new Button();
    btn.setText("Agrandar");
    btn.setOnAction(this);
    
    btn1 = new Button();
    btn1.setText("Empequeñecer");
    btn1.setOnAction(this);
    
      
      //Creating a HBox object  and setting it up with buttons
      HBox hbox = new HBox(btn,btn1);
      hbox.setAlignment(Pos.BOTTOM_CENTER);
      HBox.setMargin(btn, new Insets(0, 10, 10,0));
      HBox.setMargin(btn1, new Insets(0, 10, 10,0));
      
      // Creating StackPane object and adding the circle
      StackPane root = new StackPane(hbox);
      
      root.getChildren().addAll(circle);
      
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 300,Color.BLUE);  
      //Setting title to the Stage 
      stage.setTitle("Circulo"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show();
      
     
   } 
   public static void main(String args[]){ 
      launch(args); 
   }
   
   //@Override
   public void handle(javafx.event.ActionEvent event){
       if (event.getSource()==btn){
           System.out.println("agrandar");
           tamaño = tamaño + 10;
           circle.setRadius(tamaño);
           
       }
       if (event.getSource()==btn1){
           System.out.println("empequeñecer");
           tamaño = tamaño - 10;
           circle.setRadius(tamaño);
       }
   }
}
