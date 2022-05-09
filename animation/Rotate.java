package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.*;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;


public class Rotate implements Initializable{
	private static final Point3D Z_AXIS = null;
	@FXML
	private ImageView myImage;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		RotateTransition rotate = new RotateTransition();
		rotate.setNode(myImage);
		rotate.setDuration(Duration.millis(500));
		rotate.setCycleCount(TranslateTransition.INDEFINITE);
		rotate.setByAngle(360);
		rotate.setInterpolator(Interpolator.LINEAR);
		rotate.setAxis(Rotate.Z_AXIS);
		rotate.play();
		
	}
}

