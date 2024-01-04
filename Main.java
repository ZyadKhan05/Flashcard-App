package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {
	public static void main(String args[]) {
		// launch the application
		launch(args);
	}

	// Scenes
	Scene addScene;
	Scene flashcardsScene;

	// Variables
	VBox vbox;
	Text confirmation;

	@Override
	public void start(Stage primaryStage) {
		// Create Flashcards object
		Flashcards flashcard = new Flashcards();

		// TextField for inputs
		TextField termInput = new TextField();
		TextField defInput = new TextField();

		// Add Button
		Button addButton = new Button("Add");
		addButton.disableProperty().bind(termInput.textProperty().isEmpty());
		addButton.disableProperty().bind(defInput.textProperty().isEmpty());

		// View terms and definition button
		Button viewButton = new Button("View");

		// Create HBox and VBox
		HBox termVBox = new HBox(10, flashcard.termLabel, termInput);
		HBox defVBox = new HBox(10, flashcard.defLabel, defInput);
		vbox = new VBox(15, termVBox, defVBox, addButton, viewButton);
		termVBox.setAlignment(Pos.CENTER);
		defVBox.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(10));

		// Scroll Bar
		ScrollPane scrollBar = new ScrollPane();
		scrollBar.setContent(vbox);
		scrollBar.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		scrollBar.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

		addScene = new Scene(scrollBar);

		scrollBar.setPrefHeight(addScene.getHeight());
		scrollBar.setMaxHeight(addScene.getHeight());

		primaryStage.setScene(addScene);
		primaryStage.setTitle("Flashcard Menu");
		// primaryStage.setFullScreen(true); // I think that Full Screen makes it worse...
		primaryStage.show();

		primaryStage.setMinHeight(250);
		primaryStage.setMinWidth(450);
		
		// CSS
		String css = this.getClass().getResource("application.css").toExternalForm();
		addScene.getStylesheets().add(css);

		// Event handling for the Add Button
		addButton.setOnAction((new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// Adds the term and def to the ArrayList
				flashcard.terms.add(termInput.getText());
				flashcard.defs.add(defInput.getText());
				flashcard.setFlashcard();
				confirmation = new Text("Flashcard Added!");
				confirmation.setVisible(true);
				vbox.getChildren().add(confirmation);
				primaryStage.setHeight(350);
				primaryStage.setWidth(450);
			}
		}));

		viewButton.setOnAction((new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				// Create and set scene
				flashcard.viewFlashCard();
				flashcardsScene = new Scene(flashcard.scrollBar);
				primaryStage.setScene(flashcardsScene);
				primaryStage.setTitle("Flashcards");
				primaryStage.show();
				confirmation.setVisible(false);
				
				// Add css to flashcards scene
				flashcardsScene.getStylesheets().add(css);


			}
		}));


		// For simplicity let's disable this feature for the time being
//        addScene.setOnKeyPressed(e -> {
//            if (e.getCode() == KeyCode.ENTER) {
//            	// Adds the term and def to the ArrayList 
//            	flashcard.terms.add(termInput.getText());
//            	flashcard.defs.add(defInput.getText());
//            	
//            	// Calling method setFlashCard()
//            	flashcard.setFlashcard();
//            	
//            	// The CSS is not applying correctly
//            	flashcard.t.setId("t");
//            	flashcard.d.setId("d");
//
//            	// Create and set scene
//            	flashcardsScene = new Scene(flashcard.flashcards);
//            	flashcardsScene.getStylesheets().add("application.css");
//            	primaryStage.setScene(flashcardsScene);
//            	primaryStage.setTitle("Flashcards");
//            	primaryStage.show();
//            }
//        });

		// Event handling for the Add another flashcard button
		flashcard.addFlashcard.setOnAction(event -> {
			primaryStage.setScene(addScene);
		});
		


//        flashcard.quitButton.setOnAction(event -> {
//            primaryStage.close();
//        });
//       flashcard.restartButton.setOnAction(event -> {
//            flashcard.board.setDisable(false);
//            flashcard.isflashcardXO();
//            flashcard.isTurn();
//           flashcard.resetBoard();
//            flashcard.restartButton.setVisible(false);
//            flashcard.winnerLabel.setText("");
//            flashcard.xWins = false;
//            flashcard.oWins = false;
//       });
	}
}