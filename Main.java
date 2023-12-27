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
        Player player = new Player();

        // Create TextField for user to enter the flashcard info
        TextField termInput = new TextField();
        TextField defInput = new TextField();


        // Add Button
        Button playButton = new Button("Add");


        //Create VBox
        HBox termVBox = new HBox(10, player.player1Label, termInput);
        termVBox.setAlignment(Pos.CENTER);
        HBox defVBox = new HBox(10, player.player2Label, defInput); 
        defVBox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(10, termVBox, defVBox, playButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
       

        addScene = new Scene(vbox);

        primaryStage.setScene(addScene);
        primaryStage.setTitle("Flashcard Menu");
        primaryStage.setFullScreen(true);
        primaryStage.show();

        // Game - This needs to become our primary app as this is just from Tic-Tac-Toe
//        playButton.setOnAction((new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                player.p1Name = termInput.getText();
//                player.p2Name = defInput.getText();
//
//                player.setBoard();
//                player.isPlayerXO();
//                player.isTurn();
//                player.setLabel();
//
//
//                flashcardsScene = new Scene(player.gameVbox);
//                primaryStage.setScene(flashcardsScene);
//                primaryStage.setTitle("Tic-Tac-Toe Game");
//                primaryStage.show();
//            }
//        }));
//
//        player.quitButton.setOnAction(event -> {
//            primaryStage.close();
//        });
//        player.restartButton.setOnAction(event -> {
//            player.board.setDisable(false);
//            player.isPlayerXO();
//            player.isTurn();
//            player.resetBoard();
//            player.restartButton.setVisible(false);
//            player.winnerLabel.setText("");
//            player.xWins = false;
//            player.oWins = false;
//        });}
    }
}
