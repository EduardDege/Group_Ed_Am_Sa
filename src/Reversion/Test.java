package Reversion;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Test extends Application {

	private Group root;
	
	int cursorX = 0;
	int cursorY = 200;
	
	
	double z0;
	double z1 = 8;  // Amplitude
	double z2 = 0;
	int i = 0;
	double z3=1.99;
	
	public void sinus(double f) {
		if(i > 600)
			return;
		z0 = f * z1 - z2;
		z2 = z1;
		z1 = z0;
		System.out.println(i + " " + (int)z0 ); 
		drawLine(i, (int)z0) ;
		i++;
		//f -= 0.01;
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
		root.getChildren().add(line);	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		root = new Group();
		Button btn = new Button("-0.01");
		Button btn1 = new Button("+0.01");
		Label l = new Label ("Bitte nicht über 1.99 gehen also nutze die Taste -0.01");
		btn1.setLayoutX(200);
		btn1.setLayoutY(200);
		Rectangle panel = new Rectangle(600, 400, Color.WHITESMOKE);
		
	
		Scene scene = new Scene(root, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Scribble");
		btn1.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				
				// TODO Auto-generated method stub
				
				i=0;
				if(i > 600)
					return;
				z0 = z3 * z1 - z2;
				z2 = z1;
				z1 = z0;
				System.out.println(i + " " + (int)z0 ); 
				drawLine(i, (int)z0) ;
				i++;
				z3 += 0.01;
				int cursorX = 0;
				int cursorY = 200;
				root.getChildren().clear();
				root.getChildren().add(panel);
				root.getChildren().add(btn);
				sinus(z3);
				
				}
			
			
			
			

		
		
		});
		btn.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				
				// TODO Auto-generated method stub
				
				i=0;
				if(i > 600)
					return;
				z0 = z3 * z1 - z2;
				z2 = z1;
				z1 = z0;
				System.out.println(i + " " + (int)z0 ); 
				drawLine(i, (int)z0) ;
				i++;
				z3 -= 0.01;
				int cursorX = 0;
				int cursorY = 200;
				root.getChildren().clear();
				root.getChildren().add(panel);
				root.getChildren().add(btn);
				sinus(z3);
				
				}
			
			
			
			

		
		
		});
		
		root.getChildren().add(panel);
		root.getChildren().add(l);
		root.getChildren().add(btn1);
		root.getChildren().add(btn);
		primaryStage.show();		
	
		sinus(1.99);
	}
}
