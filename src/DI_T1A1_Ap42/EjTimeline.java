package DI_T1A1_Ap42;

import com.sun.javafx.perf.PerformanceTracker;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 *
 * @author RaulOG
 */
public class EjTimeline extends Application {
    //Tamaño de la escena
    int x = 300;
    int y = 250;
    //Velocidad del circulo
    double ballSpeed = 10.0;
    //Objeto random
    Random r = new Random();
    
    @Override
    public void start(Stage stage) {
    //Montando la escena
        Group pane = new Group();
        Scene scene = new Scene(pane, x, y);
        stage.setScene(scene);
        stage.show();
        
    //Bola que se usará para la animación
        Circle ball = new Circle(10);
        ball.setTranslateX(x * 0.5);
        ball.setTranslateY(y * 0.5);
        pane.getChildren().addAll(ball);
        
    //Etiqueta que mostrará el valor de frames por segundo (FPS)
        Label label = new Label();
        label.setTranslateX(10);
        label.setTranslateY(10);
        pane.getChildren().addAll(label);
        
    //Escuchador a incluir en el bucle de Timeline
        EventHandler<ActionEvent> eH = e -> {
        //Mostrar la frecuencia de refresco FPS
            PerformanceTracker perfTracker
                    = PerformanceTracker.getSceneTracker(scene);
            label.setText("FPS (Timeline) = " + perfTracker.getInstantFPS());
            
        //Cambiar la dirección de la bola si llega a los extremos
            if (ball.getTranslateX() < 0 || ball.getTranslateX() > x) {
                ballSpeed *= -1;
                int rx = r.nextInt(x);
                int ry = r.nextInt(y);
                ball.setTranslateY(ry);
                ball.setTranslateX(rx);
            }
            if (ball.getTranslateY() < 0 || ball.getTranslateY() > y) {
                ballSpeed *= -1;
                int rx = r.nextInt(x);
                int ry = r.nextInt(y);
                ball.setTranslateY(ry);
                ball.setTranslateX(rx);
                
            }
            ball.setTranslateX(ball.getTranslateX() + ballSpeed);
            ball.setTranslateY(ball.getTranslateY() + ballSpeed);
        };
        
    //Definimos el bucle con la duración, cada 150 ms (unos 2fps)
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(150), eH));
        animation.setCycleCount(Timeline.INDEFINITE);
        
    //Iniciamos animation
        animation.play();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
