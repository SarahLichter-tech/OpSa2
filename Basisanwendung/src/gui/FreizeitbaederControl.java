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
    }
    
    //Änderung
    void schreibeFreizeitbaederInDatei(String typ){
    	try{
	    	if("csv".equals(typ)){
	    		// Aufruf des Models zum Schreiben des Freizeitbads in die Datei des vorgegebenen Typs und Ausgabe der Meldung
	    		freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
	    	}
	    	else{
		    	freizeitbaederView.zeigeInformationsfensterAn("Noch nicht implementiert!");
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
