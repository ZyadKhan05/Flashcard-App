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
    
    

    

    @Override
    public void start(Stage primaryStage) {
        Flashcards flashcard = new Flashcards();
        int cnt;
     

        // Create TextField for user to enter the flashcard info
        TextField termInput = new TextField();
        TextField defInput = new TextField();


        // Add Button
        Button addButton = new Button("Add");

        //Create HBox and VBox scenes
        HBox termVBox = new HBox(10, flashcard.termLabel, termInput);
        termVBox.setAlignment(Pos.CENTER);
        HBox defVBox = new HBox(10, flashcard.defLabel, defInput); 
        defVBox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(10, termVBox, defVBox, addButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
       

        addScene = new Scene(vbox);

        primaryStage.setScene(addScene);
        primaryStage.setTitle("Flashcard Menu");
        // primaryStage.setFullScreen(true); // I think that Full Screen makes it worse...
        primaryStage.show();

        
        // Event handling for the Add Button
        addButton.setOnAction((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	
            	// Adds the term and def to the ArrayList 
            	flashcard.terms.add(termInput.getText());
            	flashcard.defs.add(defInput.getText());
            	
            	// Calling method setFlashCard()
            	flashcard.setFlashcard();

            	// Create and set scene
            	flashcardsScene = new Scene(flashcard.flashcards);
            	primaryStage.setScene(flashcardsScene);
            	primaryStage.setTitle("Flashcards");
            	primaryStage.show();
            }
        }));
        
        addScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
            	// Adds the term and def to the ArrayList 
            	flashcard.terms.add(termInput.getText());
            	flashcard.defs.add(defInput.getText());
            	
            	// Calling method setFlashCard()
            	flashcard.setFlashcard();
            	
            	// The CSS is not applying correctly
            	flashcard.t.setId("t");
            	flashcard.d.setId("d");

            	// Create and set scene
            	flashcardsScene = new Scene(flashcard.flashcards);
            	flashcardsScene.getStylesheets().add("application.css");
            	primaryStage.setScene(flashcardsScene);
            	primaryStage.setTitle("Flashcards");
            	primaryStage.show();
            }
        });


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
