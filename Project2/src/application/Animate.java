package application;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animate extends Application {

    PathTransition transition;


    public void start(Stage primaryStage) throws Exception {
    	try {
    		BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();			
			
			 Path path = new Path();
			

        // creates a circle to move 
        Circle circle = new Circle(10,10, 10);
        circle.setStroke(Color.BLUE);
        circle.setFill(Color.BLUE.deriveColor(1, 1, 1, 0.3));
        circle.relocate(100, 80);
        root.getChildren().add(circle);
       
 
    
        transition = new PathTransition();
        transition.setNode(circle);
        transition.setDuration(Duration.seconds(1));
        
        
       

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {

            @Override
            public void handle(Event event) {

                transition.stop();

                setPositionFixed( circle);

                double toX = ((MouseEvent) event).getX();
                double toY = ((MouseEvent) event).getY();

                Path path = new Path();
                path.getElements().add(new MoveToAbs(circle));
                path.getElements().add(new LineToAbs(circle, toX, toY));

                transition.setPath(path);
                transition.play();

            }

            // change layout to current position, reset translate
            private void setPositionFixed( Node node) {
                double x = circle.getLayoutX() + circle.getTranslateX();
                double y = circle.getLayoutY() + circle.getTranslateY();
                circle.relocate(x, y);
                circle.setTranslateX(0);
                circle.setTranslateY(0);
            }

        });
        
       

        primaryStage.setScene(scene);
        primaryStage.show();
    	
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }

    public static class MoveToAbs extends MoveTo {

        public MoveToAbs(Node node) {
            super(node.getLayoutBounds().getWidth() / 2, node.getLayoutBounds().getHeight() / 2);
        }

        public MoveToAbs(Node node, double x, double y) {
            super(x - node.getLayoutX() + node.getLayoutBounds().getWidth() / 2, y - node.getLayoutY() + node.getLayoutBounds().getHeight() / 2);
        }

    }

    public static class LineToAbs extends LineTo {

        public LineToAbs(Node node, double x, double y) {
            super(x - node.getLayoutX() + node.getLayoutBounds().getWidth() / 2, y - node.getLayoutY() + node.getLayoutBounds().getHeight() / 2);
        }

    }

   
    
    
    public static void main(String[] args) {
        launch(args);
    }

	
}