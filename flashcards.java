package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Random;

class Flashcards {
	private Label termsLabel;
	private Label defsLabel;
	VBox flashcards;
	int cnt;

	// Labels
	Label termLabel = new Label("Enter in your term:");
	Label defLabel = new Label("Enter in the definition for this term:");

	// ArrayList Variables
	ArrayList<String> terms = new ArrayList<String>();
	ArrayList<String> defs = new ArrayList<String>();
	ArrayList<Button> deleteBtns = new ArrayList<>();

	// BUG - The delete button is not visible
	Button deleteBtn;
	Button addFlashcard = new Button("Add Another Flashcard");

	Text t = new Text("Terms");
	Text d = new Text("Definitions");

	ScrollPane scrollBar;

	// Method to view flash card
	public void viewFlashCard() {
		// Primary VBox
		VBox flashcards = new VBox();

		// Not active anymore 
		// BUG - When the view is clicked on start with nothing entered, it freaks out
		if (terms.isEmpty() || defs.isEmpty()) {
	        Label noCards = new Label("No flashcards entered");
	        flashcards.getChildren().add(noCards);
	    } else {

		// For each item in the terms and defs list
		for (int i = 0; i < terms.size(); i++) {

			// Term and Def at i
			String term = terms.get(i);
			String def = defs.get(i);

			// Front
			VBox front = new VBox();
			front.setPrefSize(300, 200);
			front.setAlignment(Pos.CENTER);
			front.setStyle("-fx-background-color: lightblue;");

			// Term label
			Label termLabel = new Label("Term:");
			front.getChildren().add(termLabel);

			// Term
			Label termText = new Label(term);
			termText.setStyle("-fx-text-fill: darkblue; -fx-font-weight: bold;");
			front.getChildren().add(termText);

			// Back
			VBox back = new VBox();
			back.setPrefSize(300, 200);
			back.setAlignment(Pos.CENTER);
			back.setStyle("-fx-background-color: lightgreen;");

			// Def Label
			Label defLabel = new Label("Definition:");
			back.getChildren().add(defLabel);

			// Def
			Label defText = new Label(def);
			defText.setStyle("-fx-text-fill: darkgreen;");

			back.getChildren().add(defText);

			// HBox
			HBox card = new HBox();
			card.setAlignment(Pos.CENTER);
			card.setStyle("-fx-margin: 20px;");
			card.getChildren().addAll(front, back);

			// On default the front is visible
			front.setVisible(true);
			back.setVisible(false);

			// Click handlers
			front.setOnMouseClicked(e -> {
				front.setVisible(false);
				back.setVisible(true);
			});
			back.setOnMouseClicked(e -> {
				back.setVisible(false);
				front.setVisible(true);
			});

			// VBox for the add button
			VBox bottom = new VBox();
			bottom.setAlignment(Pos.BOTTOM_CENTER);
			bottom.getChildren().add(addFlashcard);

			// Combine it all to the VBox
			flashcards.getChildren().add(card);
			flashcards.getChildren().add(bottom);
			flashcards.setSpacing(2);

		}

		// Set primary vbox with scroll bar
		 scrollBar = new ScrollPane(flashcards); // Use the class-level ScrollPane
         scrollBar.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
         scrollBar.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		  }
	}

	public void setFlashcard() {

		String term = terms.get(cnt);
		String def = defs.get(cnt);

		if (cnt == 0) {
			// Create labels on first run
			termsLabel = new Label(term);
			defsLabel = new Label(def);

		} else {
			// Append new text to existing labels
			termsLabel.setText(termsLabel.getText() + "\n" + term);
			defsLabel.setText(defsLabel.getText() + "\n" + def);
		}

		// Delete Button
		deleteBtn = new Button("Delete");
		deleteBtns.add(deleteBtn);

		// HBoxs and VBox for Flashcard
		HBox termHBox = new HBox(10, t, d);
		termHBox.setAlignment(Pos.TOP_CENTER);
		HBox defHBox = new HBox(10, termsLabel, defsLabel, deleteBtn);
		defHBox.setAlignment(Pos.CENTER);
		flashcards = new VBox(10, termHBox, defHBox, addFlashcard);
		flashcards.setAlignment(Pos.TOP_CENTER);
		cnt++;

		scrollBar = new ScrollPane();
		scrollBar.setContent(flashcards);
		scrollBar.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		scrollBar.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

		deleteBtn.setOnAction(e -> {
			terms.remove(cnt);
			defs.remove(cnt);

			setFlashcard();
		});

	}

}
