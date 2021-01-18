package business.businessSporthallen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Observable;
import java.util.ArrayList;

import fileCreator.ConcreteCsvWriterCreator;
import fileCreator.ConcreteTxtWriterCreator;
import fileCreator.WriterCreator;
import fileCreator.WriterProduct;
import observerPattern.ConcreteObservable;
import ownUtil.PlausiException;
import business.businessFreizeitbaeder.FreizeitbaederModel;
import business.businessSporthallen.Sporthalle;
import business.businessSporthallen.SporthallenModel;
import business.businessFreizeitbaeder.Freizeitbad;
import business.businessFreizeitbaeder.FreizeitbaederModel;

public class SporthallenModel extends ConcreteObservable {
	
	private Sporthalle sporthalle;
	private ArrayList<Sporthalle> sporthallen;

	public Sporthalle getSporthalle() {
		return this.sporthalle;
	}

	public void setSporthalle(Sporthalle sporthalle) {
		this.sporthalle = sporthalle;
		//this.setChanged();
		this.notifyObservers();
	}

	//-----------Singleton--------	
	private static SporthallenModel sporthallenModel = null;
	
	private SporthallenModel(){
		
	}
	
	public static SporthallenModel getInstance(){
		
		if(sporthallenModel == null){
			
			sporthallenModel = new SporthallenModel();
		}
		return sporthallenModel;
	}	
	//-------------------------
	
	public Sporthalle leseSporthalleAusCsvDatei() throws IOException, PlausiException{
			BufferedReader ein = new BufferedReader(new FileReader("Sporthallen.csv"));
			ArrayList<Sporthalle> ergebnis = new ArrayList<>(); 
			String zeileStr = ein.readLine();
			while(zeileStr != null) {
				String[] zeile = zeileStr.split(";");
		           ergebnis.add(new Sporthalle(zeile[0], zeile[1], zeile[2]));
		           zeileStr = ein.readLine();
			}    
		 	ein.close();
		 	this.sporthallen = ergebnis;
			return sporthalle;
		}
	
}
