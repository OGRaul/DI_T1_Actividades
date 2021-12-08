package DI_T1A1_Ap42;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author RaulOG
 */
public class EjActionEvent extends Application{
    //Declarando variables
    Button btn;
    final Text actiontarget = new Text();
    TextField airfld;
    TextField nyfld;
    TextField lafld;
    Label mpfld;
    Label mirfld;
    Label tpfld;
    //Annual interest rate
    Double i = 1.0;
    //Number of years
    Double n  = 1.0;
    //Loan amount
    Double h  = 1.0;
    
    //Monthly payment
    Double m;
    //Monthly interest rate
    Double r;
    //Total payment
    Double t;

    
    
    @Override
    public void start(Stage primaryStage) {
        //Crenado el grid
        GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));
            
        // Creando el escenario y escena
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Calculadora de prestamo");
        primaryStage.setScene(scene);
        primaryStage.show(); 
        
        //Creando labels y cajas de texto y añadiendolas al grid        
        Label air = new Label("Annual Interest Rate:");
        grid.add(air, 0, 1);
        airfld = new TextField();
        grid.add(airfld, 1, 1);

        Label ny = new Label("Number of Years:");
        grid.add(ny, 0, 2);
        nyfld = new TextField();
        grid.add(nyfld, 1, 2);
        
        Label la = new Label("Loan Amount:");
        grid.add(la, 0, 3);
        lafld = new TextField();
        grid.add(lafld, 1, 3);
        
        
        //Resultados
        Label mp = new Label("Monthly Payment:");
        grid.add(mp, 0, 4);
        mpfld = new Label();
        grid.add(mpfld, 1, 4);
        
        Label tp = new Label("Total Payment");
        grid.add(tp, 0, 5);
        tpfld = new Label();
        grid.add(tpfld, 1, 5);
           
        Label b = new Label ("Calcular: ");
        grid.add(b, 0, 6);
       
        btn = new Button();
        btn.setText("Calcular");
        
        grid.add(btn, 1, 6);
        
        
        grid.add(actiontarget, 1, 7);
        
        int a=2;
        
        

    btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            //Vaciando label                
                tpfld.setText("");
                mpfld.setText("");
                
                // Gestionando el evento
                System.out.println("Boton pulsado");

                actiontarget.setFill(Color.BLACK);
                actiontarget.setText("Calculando...");
                
                //Inputs
                //Anual interest rate
                i = Double.parseDouble(airfld.getText());

                //Number of years
                n = Double.parseDouble(nyfld.getText());

                //Loan amount
                h = Double.parseDouble(lafld.getText());

                //Por definir:
                r=i/(100*12); //Monthly interest rate
                t = h * r * n*12.0 ; // Total pagado (cantidad * interes anual * numero de años)
                m = h *(i /12.0) ; //Monthly payment
                
                //Setting results
                tpfld.setText(t.toString());
                mpfld.setText(m.toString());
        }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
