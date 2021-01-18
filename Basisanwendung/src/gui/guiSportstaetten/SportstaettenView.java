package gui.guiSportstaetten;

//import java.util.ArrayList;

import business.businessFreizeitbaeder.Freizeitbad;
import business.businessFreizeitbaeder.FreizeitbaederModel;
import business.businessSporthallen.SporthallenModel;
import gui.guiSportstaetten.SportstaettenControl;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;


public class SportstaettenView {
	
	// Hier ergaenzen - Praktikum 3 Singelton,Observe
	private FreizeitbaederModel freizeitbaederModel;
	private SporthallenModel sporthallenModel;
	private SportstaettenControl sportstaettenControl;
	
	
    	//---Anfang Attribute der grafischen Oberflaeche---
    	//Anzeige Freizeitbaeder
		private Pane pane = new  Pane();
    	private Label lblAnzeigeFreizeitbaeder = new Label("Anzeige Freizeitbäder");
    	private TextArea txtAnzeigeFreizeitbaeder  = new TextArea();
    	private Button btnAnzeigeFreizeitbaeder = new Button("csv-Import und Anzeige");
    	// Anzeige Sporthallen
    	private Label lblAnzeigeSporthallen = new Label("Anzeige Sporthallen");
    	private TextArea txtAnzeigeSporthallen  = new TextArea();
    	private Button btnAnzeigeSporthallen = new Button("csv-Import und Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
		//private Object txtAnzeige;
    
    	public SportstaettenView(/* Hier ergaenzen … Praktikum 3 Singelton,Observe */ 
    			SportstaettenControl sportstaettenControl, Stage primaryStage, FreizeitbaederModel freizeitbaederModel, SporthallenModel sporthallenModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von Sportstätten");
    		primaryStage.show();
    		// Hier ergaenzen - Praktikum 3 Singelton,Observe
    		this.sportstaettenControl = sportstaettenControl;
        	this.freizeitbaederModel = freizeitbaederModel;
			//this.initKomponenten();
			//this.initListener();
        	this.sporthallenModel = sporthallenModel;
    		this.initKomponentenFreizeitbaeder();
    		this.initKomponentenSporthalle();
    		this.initListenerFreizeitbad();
    		this.initListenerSporthalle();
    	}
    	private void initKomponentenFreizeitbaeder(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeFreizeitbaeder.setLayoutX(310);
    		lblAnzeigeFreizeitbaeder.setLayoutY(40);
    		lblAnzeigeFreizeitbaeder.setFont(font);
    		lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeFreizeitbaeder);    
        	// Textbereich	
        	txtAnzeigeFreizeitbaeder.setEditable(false);
     		txtAnzeigeFreizeitbaeder.setLayoutX(310);
    		txtAnzeigeFreizeitbaeder.setLayoutY(90);
     		txtAnzeigeFreizeitbaeder.setPrefWidth(220);
    		txtAnzeigeFreizeitbaeder.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeFreizeitbaeder);        	
        	// Button
          	btnAnzeigeFreizeitbaeder.setLayoutX(310);
        	btnAnzeigeFreizeitbaeder.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeFreizeitbaeder); 
   }
    	private void initKomponentenSporthalle(){
    		// Label
    		lblAnzeigeSporthallen.setLayoutX(10);
    		lblAnzeigeSporthallen.setLayoutY(40);
    		Font font = new Font("Arial", 24);
    		lblAnzeigeSporthallen.setFont(font);
    		lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;"); 
    		pane.getChildren().add(lblAnzeigeSporthallen);    
    		// 	Textbereich	
    		txtAnzeigeSporthallen.setEditable(false);
    		txtAnzeigeSporthallen.setLayoutX(10);
    		txtAnzeigeSporthallen.setLayoutY(90);
    		txtAnzeigeSporthallen.setPrefWidth(220);
    		txtAnzeigeSporthallen.setPrefHeight(185);
    		pane.getChildren().add(txtAnzeigeSporthallen);        	
    		// 	Button
    		btnAnzeigeSporthallen.setLayoutX(10);
    		btnAnzeigeSporthallen.setLayoutY(290);
    		pane.getChildren().add(btnAnzeigeSporthallen); 
   }
    	
    	//Methoden anpassen SOLID
    	//Lambda
    	private void initListenerFreizeitbad() {
		    btnAnzeigeFreizeitbaeder.setOnAction(e-> {
		            	//zeigeFreizeitbaederAn();
		            	new EventHandler<ActionEvent>() {
		    	    		@Override
		    	        	public void handle(ActionEvent e) {
		    	            	zeigeFreizeitbaederAn();
		    	        	}
		            	};
		    });
    	}
    
    	private void initListenerSporthalle(){
    		   btnAnzeigeSporthallen.setOnAction(
    		 			new EventHandler<ActionEvent>() {
    			    		@Override
    			        	public void handle(ActionEvent e) {
    			    			sporthallenModel.setSporthalle(sportstaettenControl.leseSporthalleAusCsvDatei());
    			    			zeigeSporthalleAn();
    			        	} 
    	   	    });	   
    	   }
   
    public void zeigeFreizeitbaederAn(){
    		/*if(freizeitbaederModel.getFreizeitbad() != null){
    			txtAnzeigeFreizeitbaeder.setText(
    				freizeitbaederModel.getFreizeitbad()
 				.gibFreizeitbadZurueck(' '));
    		}*/
	    	if(freizeitbaederModel.getFreizeitbaeder().size() > 0){
	    		StringBuffer text = new StringBuffer();
	    		
	    		// Ergaenzen: for each – Schleife ueber ArrayList
	    		for(Freizeitbad fzb: freizeitbaederModel.getFreizeitbaeder()){
	    			text.append(fzb.gibFreizeitbadZurueck(' ') + "\n");
	    		}
	    		this.txtAnzeigeFreizeitbaeder.setText(text.toString());
	    	}
	    	else{
	    		zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
	    	}
    }
    
	public void zeigeSporthalleAn(){
			
	    	if(sporthallenModel.getSporthalle() != null){
				txtAnzeigeSporthallen.setText(sporthallenModel.getSporthalle().gibSporthalleZurueck(' '));
			}
			else{
				zeigeInformationsfensterAn("Bisher wurde keine Sporthalle aufgenommen!");
			}
	}	
	
	private void schreibeFreizeitbadInDatei(String typ){
    	sportstaettenControl.schreibeFreizeitbadInDatei(typ);
    }
	    
    void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    void zeigeFehlermeldungAn(String meldung){
    	this.zeigeFehlermeldungAn("Fehler", meldung);
    }
    
    private void zeigeFehlermeldungAn(String titel, String meldung){
    	new MeldungsfensterAnzeiger(null,titel, meldung).zeigeMeldungsfensterAn();
    }
}

