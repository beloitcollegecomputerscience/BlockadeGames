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


public class Translate implements Initializable{
	@FXML
	private ImageView myImage;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(myImage);
		translate.setDuration(Duration.millis(1000));
		translate.setCycleCount(TranslateTransition.INDEFINITE);
		translate.setByX(200);
		translate.setByY(50);
		translate.setAutoReverse(true);
		translate.play();
		
	}
}

