package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animate extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();			
			
		   Path path = new Path();
		   createPath(path);
		   
		   PathTransition transition = new PathTransition();
		   createTransition( transition, path, root);
	       
		   primaryStage.setTitle("PathTransition Demo");
		   primaryStage.setScene(scene);
		   primaryStage.show();
		   
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	 private static void createPath(Path path) {
		 path.getElements().add(new MoveTo(100, 100));
		 
		   LineTo line1 = new LineTo(100,100);        
		   LineTo line2 = new LineTo(250,250); 
		   LineTo line3 = new LineTo(250,100); 
		   LineTo line4 = new LineTo(100,250);
		   LineTo line5 = new LineTo(100,100); 
		   LineTo line6 = new LineTo(250,100); 
		   
		   //Adding all the elements to the path  
		   path.getElements().addAll( line1, line2,line3,line4, line5, line6);  
	 }
	
	 private static void createTransition(PathTransition transition, Path path, BorderPane root) {
			
		 Circle circle = new Circle(20, 120, 10);
		 circle.setFill(Color.CADETBLUE);
		 
		 transition.setDuration(Duration.seconds(8));
	     transition.setDelay(Duration.seconds(1));
	     transition.setPath(path);
	     transition.setNode(circle);
	     transition.setCycleCount(1);
	     transition.setAutoReverse(true);
	     transition.play();
	       
	     root.getChildren().addAll(path, circle);
	 }
	
	 public static void main(String[] args) {
		launch(args);
	}
}
