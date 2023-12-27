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
    Scene menuScene;
    Scene gameScene;

    @Override

    public void start(Stage primaryStage) {
        Player player = new Player();

        //Create TextField for player to enter their name
        TextField player1Input = new TextField();
        TextField player2Input = new TextField();


        //Play Button
        Button playButton = new Button("Play");


        //Create VBox
        VBox vbox1 = new VBox(10, player.player1Label, player1Input);
        VBox vbox2 = new VBox(10, player.player2Label, player2Input);
        HBox hbox = new HBox(10, vbox1, vbox2, playButton);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(10));

        menuScene = new Scene(hbox);

        primaryStage.setScene(menuScene);
        primaryStage.setTitle("Tic-Tac-Toe Menu");
        primaryStage.show();

        // Game


        playButton.setOnAction((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                player.p1Name = player1Input.getText();
                player.p2Name = player2Input.getText();

                player.setBoard();
                player.isPlayerXO();
                player.isTurn();
                player.setLabel();


                gameScene = new Scene(player.gameVbox);
                primaryStage.setScene(gameScene);
                primaryStage.setTitle("Tic-Tac-Toe Game");
                primaryStage.show();
            }
        }));

        player.quitButton.setOnAction(event -> {
            primaryStage.close();
        });
        player.restartButton.setOnAction(event -> {
            player.board.setDisable(false);
            player.isPlayerXO();
            player.isTurn();
            player.resetBoard();
            player.restartButton.setVisible(false);
            player.winnerLabel.setText("");
            player.xWins = false;
            player.oWins = false;
        });}
}
