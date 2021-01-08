package gui.guiFreizeitbaeder;

import java.io.IOException;
import business.FreizeitbaederModel;
//import gui.guiFreizeitbaeder.FreizeitbaederView;
import javafx.stage.Stage;
//import java.util.Observable;
//import java.util.Observer;
import observerPattern.Observer;


public class FreizeitbaederControl implements Observer {
	  
    private FreizeitbaederView freizeitbaederView;
    private FreizeitbaederModel freizeitbaederModel;
    
    public FreizeitbaederControl(Stage primaryStage){
    	this.freizeitbaederModel = FreizeitbaederModel.getInstance();
    	//Überarbeitet: Erzeugen der View im Controller (Praktikum 1)
    	this.freizeitbaederView = new FreizeitbaederView(this, primaryStage, freizeitbaederModel); 
    	//Praktikum 3
    	this.freizeitbaederModel.addObserver(this);
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
    
    /*
	@Override
	public void update(Observable arg0, Object arg1) {

		freizeitbaederView.zeigeFreizeitbaederAn();
	}
	*/
    
	@Override
	public void update() {
		freizeitbaederView.zeigeFreizeitbaederAn();
		
	}
	
}
