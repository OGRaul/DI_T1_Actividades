package DI_T1A1_Ap42;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class EjMouseCoordinateCursor extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
        
        //Texto
        Text txt = new Text();
        
        //Evento
        EventHandler<MouseEvent> eh = new EventHandler<MouseEvent>() 
        {
            public void handle(MouseEvent event)
            {
                txt.setText("Programming is fun");
                Double x;
                Double y;
                x = event.getX();
                y = event.getY();
                
                txt.setX(x);
                txt.setY(y);
               
            }
            
        };
        
       root.setOnMouseDragged(eh);    
       root.getChildren().add(txt);
    }

    public static void main(String[] args) {
        launch(args);
    }
}