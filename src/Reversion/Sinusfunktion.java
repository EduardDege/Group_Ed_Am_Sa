package Reversion;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Sinusfunktion extends Application {
    
	private BorderPane b;
	
	static String s;
	int cursorX = 0;
	int cursorY = 200;
	
	
	double z0;
	
	double z1 = 8;  // Amplitude
	double z2 = 0;
	double z3 = 1.99;
	int i = 0;
	
	
	public void sinus(double f) {
		if(i > 600)
			return;
		z0 = z3 * z1 - z2;
		z2 = z1;
		z1 = z0;
		drawLine(i, (int)z0) ;
		i++;
		System.out.println("z3()"+z3);
		System.out.println("z1^^"+z1);
		sinus(f);
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}

	void drawLine(int x, int y) {
		int endX =  x;
		int endY =  200 - y;
		Line line = new Line(cursorX, cursorY, endX , endY);
		cursorX = endX;
		cursorY = endY;
		line.setStroke(Color.RED);
		b.getChildren().add(line);	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	    TextField a = new TextField ("Amplitude");
	    HBox box = new HBox();
	    box.setPadding(new Insets(15, 10, 15, 10));
	    box.setSpacing(20);
	    box.setStyle("-fx-background-color: #448899;");
	    Button btn = new Button("-0.01");
	    Button btn2= new Button("+0.01");
	    Rectangle c = new Rectangle(600, 400, Color.BLACK);
		btn.setOnAction(new EventHandler<ActionEvent>(){         //Button Event für -0.01
			public void handle(ActionEvent event){
				z3-=0.01;
				if(z3<=-2){                                    //Abgrenzung damit z3(f) nicht unter -2 geht und somit unerkennbar wird 
					z3+=0.01;
					b.getChildren().clear();
					Label l = new Label ("Bitte nicht unter -1.99 gehen also nutze die Taste -0.01");
					l.setTextFill(Color.WHITE);
					
					
					b.setTop(box);
					b.getChildren().add(c);
				    b.setCenter(l);
				}else{    //normalfall falls z3 runtergeht
			
				
				
					b.getChildren().clear();
					
					i=0;
					cursorX = 0;
					cursorY = 200;
			
         			b.setTop(box);		
				    b.setCenter(c);
					sinus(1.99);
			}
				}
			});
		
		btn2.setOnAction(new EventHandler<ActionEvent>(){  //Button Event für +0.01
			public void handle(ActionEvent event){
				z3+=0.01;
				if(z3 >= 2){                     // z3 soll auch nicht auf oder über +2 gehen
					z3 -=0.01;
					b.getChildren().clear();
					Label l = new Label ("Bitte nicht über 1.99 gehen also nutze die Taste -0.01");
					l.setTextFill(Color.WHITE);
					b.setTop(box);
					b.getChildren().add(c);
				    b.setCenter(l);

					
				}else{ //normalfall wird fortgesetzt
					
				
					b.getChildren().clear();
			       
					i=0;
					cursorX = 0;
					cursorY = 200;
			
					b.setCenter(c);
					b.setTop(box);		
					
				 
					sinus(1.99);
			
				}
			}
			});
		a.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				
				s = a.getText();
				z1= Double.parseDouble(s);
				a.setText("");
				b.getChildren().clear();
				z2=0;
				i=0;
				cursorX = 0;
				cursorY = 200;
				
						
			    b.setCenter(c);
			    b.setTop(box);
			    sinus(1.99);
				
				
				
			}
		});
		
	    
		
		b = new BorderPane();
		Scene scene = new Scene( b, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Scribble");
		b.setTop(box);
		box.getChildren().addAll(a, btn, btn2);
		b.setCenter(c);
		//eingliedrung der GUI elemente
		
		

		primaryStage.show();		
	    
		sinus(1.99);
		
	}

	
	
}