package application;

import java.net.URL;

import java.util.ResourceBundle;
import javafx.scene.*;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class Controller implements Initializable{
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
		
	
		
		/*fade
		FadeTransition fade = new FadeTransition();
		fade.setNode(myImage);
		fade.setDuration(Duration.millis(1000));
		fade.setCycleCount(TranslateTransition.INDEFINITE);
		fade.setInterpolator(Interpolator.LINEAR);
	    fade.setFromValue(1);
	    fade.setToValue(0);
	    fade.play();
	    */
	    
		//scale
		/*
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(myImage);
		scale.setDuration(Duration.millis(1000));
		scale.setCycleCount(TranslateTransition.INDEFINITE);
		scale.setInterpolator(Interpolator.LINEAR);
		scale.setByX(2.0);
		scale.setByY(2.0);
		scale.setAutoReverse(true);
		
	    scale.play();
	    */
	}
	
	
	
	}

