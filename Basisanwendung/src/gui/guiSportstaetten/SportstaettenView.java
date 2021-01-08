package gui.guiSportstaetten;

//import java.util.ArrayList;

import business.Freizeitbad;
import business.FreizeitbaederModel;
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
	//private SportstaettenControl sportstaettenControl;
	
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane     				       
 		= new  Pane();
    	private Label lblAnzeigeFreizeitbaeder     
 		= new Label("Anzeige Freizeitbäder");
    	private TextArea txtAnzeigeFreizeitbaeder  = new TextArea();
    	private Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
		//private Object txtAnzeige;

		private SportstaettenControl sportstaettenControl;
    
    	public SportstaettenView(/* Hier ergaenzen … Praktikum 3 Singelton,Observe */ 
    			SportstaettenControl sportstaettenControl, Stage primaryStage, FreizeitbaederModel freizeitbaederModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von Sportstätten");
    		primaryStage.show();
    		// Hier ergaenzen - Praktikum 3 Singelton,Observe
    		this.sportstaettenControl = sportstaettenControl;
        	this.freizeitbaederModel = freizeitbaederModel;
		this.initKomponenten();
		this.initListener();
    	}
    	private void initKomponenten(){
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
   
    	//Lambda
    	private void initListener() {
		    btnAnzeigeFreizeitbaeder.setOnAction(e-> {
		            	zeigeFreizeitbaederAn();
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
	    
    void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,"Information", meldung).zeigeMeldungsfensterAn();
    }	
}

