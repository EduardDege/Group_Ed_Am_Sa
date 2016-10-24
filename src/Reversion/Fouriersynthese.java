package Reversion;

import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Fouriersynthese extends Application {

	private Group root;
	
	int cursorX = 0;
	int cursorY = 200;
	
	
	double z0;
	double z1 = 8;  // Amplitude	
	double z6 = 0;
	int i = 0;
	
	
	public void wave1() {
		for(int z=0; z<600 ; z++){
			z6= 50.0 * Math.sin(4*Math.PI *z /600);
			z6+= 50.0/3.0 * Math.sin(3*4*Math.PI *z /600);
			z6+= 50.0/5.0 * Math.sin(5*4*Math.PI *z /600);
			z6+= 50.0/7.0 * Math.sin(7*4*Math.PI *z /600);
			drawLine1(z, (int)z6) ;
			
		}}
	
		public void wave() {
			for(int z=0; z<600 ; z++){
				z0= 50.0 * Math.sin(4*Math.PI *z /600);
				z0+= 50.0/9.0 * Math.sin(-3*4*Math.PI *z /600);
				z0+= 50.0/25.0 * Math.sin(5*4*Math.PI *z /600);
				z0+= 50.0/49.0 * Math.sin(-7*4*Math.PI *z /600);
				drawLine(z, (int)z0) ;	
			
			}
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
	
	void drawLine1(int x, int y) {
		int endX =  x;
		int endY =  200 - y;
		Line line = new Line(cursorX, cursorY, endX , endY);
		cursorX = endX;
		cursorY = endY;
		line.setStroke(Color.BLUE);
		root.getChildren().add(line);	
	}
		
	
		
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		root = new Group();
		Scene scene = new Scene(root, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Scribble");
		
		Rectangle panel = new Rectangle(600, 400, Color.WHITESMOKE);
		root.getChildren().add(panel);
		primaryStage.show();		
	
//		wave();
     	wave1();
		
	}
}

/* 4.1 zum beispiel mit einer for-Schleife
   for(i=1;i>100;i++) a=2i+1 (fängt mit 3 an da die for schleife mit 1 startet).
   für die berechnung gerader zahlen kann man die gleiche schleife benutzen aber 
   ohne die +1.
   
   4.2 if(i>0 || i<0) i=i*(-1)
   
   4.3 zu 3.3
   2n+1 
       zu 3.4
   (-1)^n+(n*2+1)^2  */