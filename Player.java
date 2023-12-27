package application;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.Random;

class Player {

    // Labels
    Label player1Label = new Label("Player 1 Name:");
    Label player2Label = new Label("Player 2 Name:");
    Label winnerLabel = new Label("");

    // String Variables
    String p1Name;
    String p2Name;
    String p1Char;
    String p2Char;

    // Boolean variables
    boolean isPlayerXO;
    boolean p1Turn;
    boolean p2Turn;
    boolean xWins;
    boolean oWins;
    boolean isDraw = false;


    // Integer variables
    int p1Wins;
    int p2Wins;
    int count;

    // Buttons
    Button menuButton = new Button("Back to the Menu");
    Button quitButton = new Button("Quit");
    Button restartButton = new Button("Restart");

    HBox labelHbox;

    VBox board;
    VBox gameVbox;


    // Which player is X and which player is O
    Random random = new Random();
    public void isPlayerXO() {
        isPlayerXO = random.nextBoolean();
        if (isPlayerXO) {
            p1Char = "X";
            p2Char = "O";
        } else {
            p1Char = "O";
            p2Char = "X";
        }
        // Which player starts based off this
        firstTurn();
    }
    // Determine which player has the first turn
    public void firstTurn(){
        if (p1Char == "X") {
            p1Turn = true;
            p2Turn = false;
        } else {
            p1Turn = false;
            p2Turn = true;
        }
    }
    // Swap the labels each turn
    public void isTurn() {
        if (p1Turn) {
            player1Label.setStyle("-fx-text-fill: green; -fx-font-weight: bold");
            player2Label.setStyle("-fx-text-fill: red;");

        } else {
            player2Label.setStyle("-fx-text-fill: green; -fx-font-weight: bold");
            player1Label.setStyle("-fx-text-fill: red; ");
        }
    }

    // Initialize the buttons
    Button[] buttons;
    public void setBoard(){
        // Create all 9 buttons and provide setOnAction for each
        buttons = new Button[9];
        for(int i = 0; i < 9; i++) {
            buttons[i] = new Button();
            buttons[i].setPrefSize(100, 100);
            buttons[i].setStyle("-fx-background-color: #C19A6B; -fx-border-style: solid;" );
            buttons[i].setOnAction(e -> {
                Button button = (Button) e.getSource();
                // If p1 selects a button
                if (p1Turn) {
                    button.setText(p1Char);
                    button.setStyle("-fx-background-color: grey; -fx-border-style: solid;");
                    p1Turn = false;
                    p2Turn = true;
                    button.setDisable(true);
                    count ++ ;
                    isTurn();
                    checkGameOver();
                }
                // If p2 selects a button
                else {
                    button.setText(p2Char);
                    button.setStyle("-fx-background-color: grey;  -fx-border-style: solid;");
                    p2Turn = false;
                    p1Turn = true;
                    button.setDisable(true);
                    count ++ ;
                    isTurn();
                    checkGameOver();
                }
            });
        }

        // Each row of the board
        HBox topRow = new HBox(2, buttons[0], buttons[1], buttons[2]);
        HBox midRow = new HBox(2, buttons[3], buttons[4], buttons[5]);
        HBox botRow = new HBox(2, buttons[6], buttons[7], buttons[8]);

        // Create a vbox for the tic tac toe board
        board = new VBox(topRow, midRow, botRow);

    }

    // Method to set Label and Vbox
    public void setLabel() {
        player1Label.setText("Player " + p1Char + ": " + p1Name + ", Wins: " + p1Wins);
        player2Label.setText("Player " + p2Char + ": " + p2Name + ", Wins: " + p2Wins);
        labelHbox = new HBox(10, player1Label, player2Label);
        restartButton.setVisible(false);
        gameVbox = new VBox(10,labelHbox,  board, winnerLabel, restartButton, menuButton ,quitButton);
        gameVbox.setPadding(new Insets(10));
        gameVbox.setAlignment(Pos.CENTER);

    }
    // Check for each possibility of the game to be ended
    public void checkGameOver() {
        // Check all possibilities for X to win
        if (buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")) {
            xWins = true;
            count = 0;
            board.setDisable(true);
            winningPattern(0,1,2);
            isWinner();
        }if (buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")){
            xWins = true;
            count = 0;
            board.setDisable(true);
            winningPattern(3,4,5);
            isWinner();
        } if (buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")){
            xWins = true;
            count = 0;
            board.setDisable(true);
            winningPattern(6,7,8);
            isWinner();
        }if (buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")){
            xWins = true;
            count = 0;
            board.setDisable(true);
            winningPattern(0,3,6);
            isWinner();
        } if (buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")){
            xWins = true;
            count = 0;
            board.setDisable(true);
            winningPattern(1,4,7);
            isWinner();
        } if (buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")){
            xWins = true;
            count = 0;
            board.setDisable(true);
            winningPattern(2,5,8);
            isWinner();
        } if (buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")){
            xWins = true;
            count = 0;
            board.setDisable(true);
            winningPattern(0,4,8);
            isWinner();
        } if (buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X")) {
            xWins = true;
            count = 0;
            board.setDisable(true);
            winningPattern(2,4,6);
            isWinner();
        }
        // Check all possibilities for O to win
        if (buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")) {
            oWins = true;
            count = 0;
            board.setDisable(true);
            winningPattern(0,1,2);
            isWinner();
        }if (buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")){
            oWins = true;
            count = 0;
            board.setDisable(true);
            winningPattern(3,4,5);
            isWinner();
        } if (buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")){
            oWins = true;
            count = 0;
            board.setDisable(true);
            winningPattern(6,7,8);
            isWinner();
        }if (buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")){
            oWins = true;
            count = 0;
            board.setDisable(true);
            winningPattern(0,3,6);
            isWinner();
        }if (buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")){
            oWins = true;
            count = 0;
            board.setDisable(true);
            winningPattern(1,4,7);
            isWinner();
        }if (buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")){
            oWins = true;
            count = 0;
            board.setDisable(true);
            winningPattern(2,5,8);
            isWinner();
        }if (buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")){
            oWins = true;
            count = 0;
            board.setDisable(true);
            winningPattern(0,4,8);
            isWinner();
        }if (buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O")) {
            oWins = true;
            count = 0;
            board.setDisable(true);
            winningPattern(2,4,6);
            isWinner();
        }
        // Check for a draw
        else if (count == 9) {
            isDraw = true;
            isWinner();
        }
    }

    // isWinner check
    public void isWinner() {
        if (xWins || oWins){
            // Show the restart button
            restartButton.setText("Restart Game?");
            restartButton.setVisible(true);
            //X winner
            if (xWins) {
                if (p1Char.equals("X")) {
                    p1Wins++;
                    player1Label.setText("Player " + p1Char + ": " + p1Name + ", Wins: " + p1Wins);
                    winnerLabel.setText(p1Name + " won!");
                } else if (p2Char.equals("X")) {
                    p2Wins++;
                    player2Label.setText("Player " + p2Char + ": " + p2Name + ", Wins: " + p2Wins);
                    winnerLabel.setText(p2Name + " won!");
                }
            }
            //O winner
            if (oWins) {
                if (p1Char.equals("O")) {
                    p1Wins++;
                    player1Label.setText("Player " + p1Char + ": " + p1Name + ", Wins: " + p1Wins);
                    winnerLabel.setText(p1Name + " won!");
                } else if (p2Char.equals("O")) {
                    p2Wins++;
                    player2Label.setText("Player " + p2Char + ": " + p2Name + ", Wins: " + p2Wins);
                    winnerLabel.setText(p2Name + " won!");
                }
            }
            // If game is a draw
        } else if (isDraw){
            isDraw = false;
            winnerLabel.setText("Draw!");
            restartButton.setText("Restart Game?");
            restartButton.setVisible(true);
        }
    }

        // Reset the tic tac toe board
        public void resetBoard() {
            for (int i = 0; i < 9; i++) {
                buttons[i].setPrefSize(100, 100);
                buttons[i].setText("");
                buttons[i].setDisable(false);
                buttons[i].setStyle("-fx-background-color: #C19A6B; -fx-border-style: solid;");
            }
        }
    // Highlight the winning patten in green
    public void winningPattern(int a,int b,int c) {
        buttons[a].setStyle("-fx-background-color: Green; ");
        buttons[b].setStyle("-fx-background-color: Green; ");
        buttons[c].setStyle("-fx-background-color: Green; ");

    }
}

