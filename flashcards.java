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

	Button addFlashcard = new Button("Add Another Flashcard");
	
	// Will want to implement a delete flashcard button - LATER


	Text t = new Text("Terms");
	Text d = new Text("Definitions");
	
	ScrollPane scrollBar;

	//Method to view flash card
	// BUG - View is not Centered
	// NEXT Step: Can we make this more visually appealing?
	public void viewFlashCard() {
	    VBox flashcards;

	    if (terms.isEmpty() || defs.isEmpty()) {
	        termsLabel = new Label("No Flashcards Entered");
	        defsLabel = new Label("");
	    } else {
	        termsLabel = new Label(String.join("\n", terms));
	        defsLabel = new Label(String.join("\n", defs));
	    }

	    // HBoxs and VBox for Flashcard
	    HBox termHBox = new HBox(10, t, d);
	    termHBox.setAlignment(Pos.CENTER);
	    HBox defHBox = new HBox(10, termsLabel, defsLabel);
	    defHBox.setAlignment(Pos.CENTER);
	    flashcards = new VBox(10, termHBox, defHBox, addFlashcard);
	    flashcards.setAlignment(Pos.CENTER); 

	    scrollBar = new ScrollPane();
	    scrollBar.setContent(flashcards);
	    scrollBar.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	    scrollBar.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
	}




	public void setFlashcard() {

		  String term = terms.get(cnt);
		  String def = defs.get(cnt);

		  if(cnt == 0) {
		    // Create labels on first run
		    termsLabel = new Label(term);  
		    defsLabel = new Label(def);

		  } else {
		    // Append new text to existing labels
		    termsLabel.setText(termsLabel.getText() + "\n" + term);
		    defsLabel.setText(defsLabel.getText() + "\n" + def);
		  }


		// HBoxs and VBox for Flashcard
		HBox termHBox = new HBox(10, t , d);
		termHBox.setAlignment(Pos.TOP_CENTER);
		HBox defHBox = new HBox(10, termsLabel, defsLabel);
		defHBox.setAlignment(Pos.CENTER);
		flashcards = new VBox(10, termHBox, defHBox, addFlashcard);
		flashcards.setAlignment(Pos.TOP_CENTER);
		cnt++;
		
        scrollBar = new ScrollPane();
        scrollBar.setContent(flashcards);
        scrollBar.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); 
        scrollBar.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        


	}
	


}
