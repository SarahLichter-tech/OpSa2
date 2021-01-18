//Praktikum 3 Singelton,Observer
package gui.guiSportstaetten;

//import java.util.Observable;
//import java.util.Observer;
import observerPattern.Observer;

import java.io.IOException;

import business.businessFreizeitbaeder.FreizeitbaederModel;
import business.businessSporthallen.Sporthalle;
import business.businessSporthallen.SporthallenModel;
import gui.guiSportstaetten.SportstaettenView;
import javafx.stage.Stage;

public class SportstaettenControl implements Observer {
	private SportstaettenView sportstaettenView;
	private FreizeitbaederModel freizeitbaederModel;
	private SporthallenModel sporthallenModel;
	
	public SportstaettenControl(Stage primaryStage){
		this.freizeitbaederModel = FreizeitbaederModel.getInstance();
		this.sportstaettenView = new SportstaettenView(this, primaryStage, freizeitbaederModel, sporthallenModel);
		this.freizeitbaederModel.addObserver(this);
		this.sporthallenModel = SporthallenModel.getInstance();
	}
	
	public Sporthalle leseSporthalleAusCsvDatei(){
		Sporthalle ergebnis = null;
		try{
			ergebnis = sporthallenModel.leseSporthalleAusCsvDatei();
		}
		catch(IOException exc){
			sportstaettenView.zeigeFehlermeldungAn("IOException beim Lesen!");
		}
		catch(Exception exc){
			sportstaettenView.zeigeFehlermeldungAn("Unbekannter Fehler beim Lesen!");
		}		
		return ergebnis;
	}	
	
	
	
	void schreibeFreizeitbadInDatei(String typ){
	   	try{
	   		if("csv".equals(typ)){
	   			freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
	   			sportstaettenView.zeigeInformationsfensterAn("Das Freizeitbad wurde gespeichert!");
	   		}
	   		else{
	   			freizeitbaederModel.schreibeFreizeitbaederInTxtDatei();
	   			sportstaettenView.zeigeInformationsfensterAn("Das Freizeitbad wurde gespeichert!");
	   		}
	    } 
		catch(IOException exc){
			sportstaettenView.zeigeFehlermeldungAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			sportstaettenView.zeigeFehlermeldungAn(
				"Unbekannter Fehler beim Speichern!");
		}
    }
	
	/*
	@Override
	public void update(Observable o, Object arg) {
		sportstaettenView.zeigeFreizeitbaederAn();	
	}*/

	@Override
	public void update() {
		sportstaettenView.zeigeFreizeitbaederAn();
	}
}
