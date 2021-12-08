package DI_T1A1_Ap42;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 *
 * @author RaulOG
 */
public class EjPathTransition extends Application{
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Pane group = new Pane();
        Scene scene = new Scene(group, 500, 500, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Circles");
        primaryStage.show();

        Circle ruta = new Circle(250,250,100);
        ruta.setFill(Color.WHITE);
        ruta.setStrokeWidth(3.0);
        ruta.setStroke(Color.BLACK);

        DoubleProperty angulo = new SimpleDoubleProperty();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(4), new KeyValue(angulo, 360)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        group.getChildren().add(ruta);
        
        //Creando rectangulo y posicion
        Rectangle rectangle = new Rectangle(50, 75);
        rectangle.setX(225.0);
        rectangle.setY(120.0);
        rectangle.setFill(Color.YELLOW);
        
        //Rotacion
        Rotate rotacion = new Rotate();
        rotacion.setPivotX(250.0);
        rotacion.setPivotY(250.0);
        rectangle.getTransforms().add(rotacion);
        rotacion.angleProperty().bind(angulo);
            
            
        group.getChildren().add(rectangle);
       
            
        //Evento click
       ruta.setOnMousePressed((e) ->{
            timeline.pause();
       });
       //Evento suelta
       ruta.setOnMouseReleased((e) ->{
            timeline.play( );
       });    
       
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
