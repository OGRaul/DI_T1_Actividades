package DI_T1A1_Ap42;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import static javafx.scene.input.KeyCode.DOWN;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author RaulOG
 */
public class EjKeyEvent extends Application  {
        //Variables
        int x = 20;
        int y = 20;
        String s = "A";
        Text txt;
        String se ="";
        
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        txt= new Text(x,y,s);
         root.getChildren().add(txt);
      
        //Evento
        scene.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent e) {
                
                switch (e.getCode())
                {
                    case DOWN:
                        y= y+10;
                        txt.setY(y);
                        break;
                        
                    case UP:
                        y= y-10;
                        txt.setY(y);
                        break;
                        
                    case RIGHT:
                        x= x+10;
                        txt.setX(x);
                        break;
                        
                    case LEFT:
                        x= x-10;
                        txt.setX(x);
                        break;
                        
                    default:
                            se = e.getCode().toString();
                            s= s+se;
                            txt.setText(s);
                }
            }
            
        });
        

        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
