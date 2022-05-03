package application;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.io.IOException;

import javafx.fxml.FXML;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToInGameScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Piecemove.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToMainScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToColorScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ColorScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void exit(ActionEvent event) {
		Platform.exit();
	}
	
	@FXML 
	private Button piece1;
	@FXML
	private Button piece2;
	@FXML
	private Button piece3;
	@FXML
	private Button piece4; 
	
	@FXML 
	private Button leftup;
	@FXML
	private Button leftbottom; 
	@FXML
	private Button rightup;
	@FXML
	private Button rightbottom;
	@FXML
	private Button middle;
	
	private String piece;
	private double x;
	private double y;
	boolean action=false;

	
 public void leftup(ActionEvent e) {
	 if(action) {
			action=false;
		 TranslateTransition translate = new TranslateTransition();
		 if(piece == piece1.getId()) {
			 translate.setNode(piece1);
		 	translate.setToX(leftup.getLayoutX()-x);
		 	translate.setToY(leftup.getLayoutY()-y);
		 	translate.play();
		 }else if(piece == piece2.getId()) {
			 translate.setNode(piece2);
			 translate.setToX(leftup.getLayoutX()-x);
			 translate.setToY(leftup.getLayoutY()-y);
			 translate.play();
		 }else if(piece == piece3.getId()) {
			 translate.setNode(piece3);
			 translate.setToX(leftup.getLayoutX()-x);
			 translate.setToY(leftup.getLayoutY()-y);
			 translate.play();
		 }else if(piece == piece4.getId()) {
			 translate.setNode(piece4);
			 translate.setToX(leftup.getLayoutX()-x);
			 translate.setToY(leftup.getLayoutY()-y);
			 translate.play();
		 }
		 System.out.print(piece1.getLayoutX());
	 }
 }
 public void leftbottom(ActionEvent e) {
	 if(action) {
			action=false;
		 TranslateTransition translate = new TranslateTransition();
		 if(piece == piece1.getId()) {
			 translate.setNode(piece1);
		 	translate.setToX(leftbottom.getLayoutX()-x);
		 	translate.setToY(leftbottom.getLayoutY()-y);
		 	translate.play();
		 }else if(piece == piece2.getId()) {
			 translate.setNode(piece2);
			 translate.setToX(leftbottom.getLayoutX()-x);
			 translate.setToY(leftbottom.getLayoutY()-y);
			 translate.play();
		 }else if(piece == piece3.getId()) {
			 translate.setNode(piece3);
			 translate.setToX(leftbottom.getLayoutX()-x);
			 translate.setToY(leftbottom.getLayoutY()-y);
			 translate.play();
		 }else if(piece == piece4.getId()) {
			 translate.setNode(piece4);
			 translate.setToX(leftbottom.getLayoutX()-x);
			 translate.setToY(leftbottom.getLayoutY()-y);
			 translate.play();
		 }
		 System.out.print(piece1.getLayoutX());
	 }
 }
 public void middle(ActionEvent e) {
	 if(action) {
			action=false;
		 TranslateTransition translate = new TranslateTransition();
		 if(piece == piece1.getId()) {
			 translate.setNode(piece1);
		 	translate.setToX(middle.getLayoutX()-x);
		 	translate.setToY(middle.getLayoutY()-y);
		 	translate.play();
		 }else if(piece == piece2.getId()) {
			 translate.setNode(piece2);
			 translate.setToX(middle.getLayoutX()-x);
			 translate.setToY(middle.getLayoutY()-y);
			 translate.play();
		 }else if(piece == piece3.getId()) {
			 translate.setNode(piece3);
			 translate.setToX(middle.getLayoutX()-x);
			 translate.setToY(middle.getLayoutY()-y);
			 translate.play();
		 }else if(piece == piece4.getId()) {
			 translate.setNode(piece4);
			 translate.setToX(middle.getLayoutX()-x);
			 translate.setToY(middle.getLayoutY()-y);
			 translate.play();
		 }
		 System.out.print(piece1.getLayoutX());
	 }
 }
 public void rightup(ActionEvent e) {
	 if(action) {
			action=false;
		 TranslateTransition translate = new TranslateTransition();
		 if(piece == piece1.getId()) {
			 translate.setNode(piece1);
		 	translate.setToX(rightup.getLayoutX()-x);
		 	translate.setToY(rightup.getLayoutY()-y);
		 	translate.play();
		 }else if(piece == piece2.getId()) {
			 translate.setNode(piece2);
			 translate.setToX(rightup.getLayoutX()-x);
			 translate.setToY(rightup.getLayoutY()-y);
			 translate.play();
		 }else if(piece == piece3.getId()) {
			 translate.setNode(piece3);
			 translate.setToX(rightup.getLayoutX()-x);
			 translate.setToY(rightup.getLayoutY()-y);
			 translate.play();
		 }else if(piece == piece4.getId()) {
			 translate.setNode(piece4);
			 translate.setToX(rightup.getLayoutX()-x);
			 translate.setToY(rightup.getLayoutY()-y);
			 translate.play();
		 }
		 System.out.print(piece1.getLayoutX());
	 }
 }
 public void rightbottom(ActionEvent e) {
	 if(action) {
			action=false;
		 TranslateTransition translate = new TranslateTransition();
		 if(piece == piece1.getId()) {
			 translate.setNode(piece1);
		 	translate.setToX(rightbottom.getLayoutX()-x);
		 	translate.setToY(rightbottom.getLayoutY()-y);
		 	translate.play();
		 }else if(piece == piece2.getId()) {
			 translate.setNode(piece2);
			 translate.setToX(rightbottom.getLayoutX()-x);
			 translate.setToY(rightbottom.getLayoutY()-y);
			 translate.play();
		 }else if(piece == piece3.getId()) {
			 translate.setNode(piece3);
			 translate.setToX(rightbottom.getLayoutX()-x);
			 translate.setToY(rightbottom.getLayoutY()-y);
			 translate.play();
		 }else if(piece == piece4.getId()) {
			 translate.setNode(piece4);
			 translate.setToX(rightbottom.getLayoutX()-x);
			 translate.setToY(rightbottom.getLayoutY()-y);
			 translate.play();
		 }
		 System.out.print(piece1.getLayoutX());
	 }
 }
 public void piece1(ActionEvent e) {
	 piece = piece1.getId();
	 x =piece1.getLayoutX();
	 y =piece1.getLayoutY();
	 action=true; 
 }
 public void piece2(ActionEvent e) {
	 piece = piece2.getId();
	 x =piece2.getLayoutX();
	 y =piece2.getLayoutY();
	 action=true;
 }
 public void piece3(ActionEvent e) {
	 piece = piece3.getId();
	 x =piece3.getLayoutX();
	 y =piece3.getLayoutY();
	 action=true;
 }
 public void piece4(ActionEvent e) {
	 piece = piece4.getId();
	 x =piece4.getLayoutX();
	 y =piece4.getLayoutY();
	 action=true;
 }
}