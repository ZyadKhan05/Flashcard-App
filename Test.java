package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Test extends Application {

    private int cnt = 0;
    private ArrayList<String> terms = new ArrayList<>();
    private ArrayList<String> defs = new ArrayList<>();
    private TextArea flashcardsArea = new TextArea();

    public void start(Stage primaryStage) {
        // Dummy data for demonstration
        terms.add("Term 1");
        defs.add("Definition 1");

        Button addFlashcard = new Button("Add Another Flashcard");
        addFlashcard.setOnAction(e -> setFlashcard());

        VBox root = new VBox(10, flashcardsArea, addFlashcard);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Flashcards App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setFlashcard() {
        if (cnt < terms.size()) {
            String term = terms.get(cnt);
            String def = defs.get(cnt);

            // Append the new flashcard text to the existing text
            flashcardsArea.appendText("Term: " + term + "\nDefinition: " + def + "\n\n");
            cnt++;
        } else {
            flashcardsArea.appendText("No more flashcards available.\n");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
