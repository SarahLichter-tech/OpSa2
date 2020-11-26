package gui;

import java.io.IOException;
import business.FreizeitbaederModel;
import gui.FreizeitbaederView;
import javafx.stage.Stage;


public class FreizeitbaederControl {
	  
    private FreizeitbaederView freizeitbaederView;
    private FreizeitbaederModel freizeitbaederModel;
    
    public FreizeitbaederControl(Stage primaryStage){
    	this.freizeitbaederModel = new FreizeitbaederModel();
    	//Überarbeitet: Erzeugen der View im Controller (Praktikum 1)
    	this.freizeitbaederView = new FreizeitbaederView(this, primaryStage, freizeitbaederModel); 
    }
    
    //Praktikum 1 - MVC
    void schreibeFreizeitbaederInDatei(String typ){
    	try{
	    	if("csv".equals(typ)){
	    		// Aufruf des Models zum Schreiben des Freizeitbads in die Datei des vorgegebenen Typs und Ausgabe der Meldung
	    		this.freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
	    		freizeitbaederView.zeigeInformationsfensterAn("Das Freizeitbad wurde gespeichert!");
	    	}
	    	else{
	    		//Überarbeitet Praktikum 2: Aufruf schreibeFreizeitbadInTxtDatei();
	    		freizeitbaederModel.schreibeFreizeitbadInTxtDatei();
		    	freizeitbaederView.zeigeInformationsfensterAn("Das Freizeitbad wurde gespeichert!");
		    }
    	}
    	catch(IOException exc){
		    	freizeitbaederView.zeigeFehlermeldungAn("IOException beim Speichern!");
		}
		catch(Exception exc){
		    	freizeitbaederView.zeigeFehlermeldungAn("Unbekannter Fehler beim Speichern!");
		}
    } 
    
  
	
}
