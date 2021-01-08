package business;
   
//import business.Freizeitbad;
import java.io.IOException;
import java.util.ArrayList;

import fileCreator.ConcreteCsvWriterCreator;
import fileCreator.ConcreteTxtWriterCreator;
import fileCreator.WriterCreator;
import fileCreator.WriterProduct;
import observerPattern.ConcreteObservable;

public class FreizeitbaederModel extends ConcreteObservable {
	     
    // speichert temporaer ein Objekt vom Typ Freizeitbad
    //private Freizeitbad freizeitbad;
    
	//Praktikum 4-------------------------------------------------
	ArrayList<Freizeitbad> freizeitbaeder = new ArrayList<>();
	
    public ArrayList<Freizeitbad> getFreizeitbaeder() {
		return this.freizeitbaeder;
    }
    
    /*public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbaeder = freizeitbad;
		this.notifyObservers();
    }*/
    
    //neue Methode zum Hinzufügen zu den bereits vorhandenen Freizeitbädern ein Weiteres 
    public void addFreizeitbad(Freizeitbad freizeitbad) {
    	freizeitbaeder.add(freizeitbad);
    }
    
  //Praktikum 3---------------------------Singleton------------------------------
	
  	private static FreizeitbaederModel freizeitbaederModel = null;
  	private FreizeitbaederModel(){
  		
  	}
  	
  	public static FreizeitbaederModel getInstance(){
  		if(freizeitbaederModel == null){
  			freizeitbaederModel = new FreizeitbaederModel();
  		}
  		
  		return freizeitbaederModel;
  	}	
  	//----------------------------------------------------------------
    
    /*
    //Praktikum 1 - MVC
    public void schreibeFreizeitbaederInCsvDatei()
	    //Werfen einer IOException
    	throws IOException{
    		BufferedWriter aus = new BufferedWriter(
			  new FileWriter("Freizeitbaeder.csv", true));
    		aus.write(this.getFreizeitbad().gibFreizeitbadZurueck(';'));
    		aus.close();
	}*/    
    
    //Praktikum 2 - Realisierung der Fabrik-Methode
    public void schreibeFreizeitbaederInCsvDatei()
    		throws IOException{
    			// Kreieren eines Creator-Objekts und Abspeicherung mit Hilfe einer Variablen vom Typ der entsprechenden abstrakten Creator-Klasse.
    			WriterCreator writerCreator = new ConcreteCsvWriterCreator();
    			// Kreieren eines Product-Objekts mit Hilfe der Factory-Methode des Creator-Objekts und Abspeicherung mit Hilfe einer Variablen vom Typ der entsprechenden abstrakten Product-Klasse.
    			WriterProduct writerProduct = writerCreator.factoryMethod();
	    		//Praktikum 4
    			this.getFreizeitbaeder().forEach((fzb) -> {
    				try {
    					writerProduct.fuegeInDateiHinzu(fzb);
    				} catch (IOException e) {
    					
    				}
    			});
    			writerProduct.schliesseDatei();
    		}
    
    //Praktikum 2 - Ausbau der Fabrik-Methode
    public void schreibeFreizeitbadInTxtDatei()
		    throws IOException{
			    WriterCreator writerCreator = new ConcreteTxtWriterCreator();
			    WriterProduct writerProduct = writerCreator.factoryMethod();
			    //Praktikum 4
    			this.getFreizeitbaeder().forEach((fzb) -> {
    				try {
    					writerProduct.fuegeInDateiHinzu(fzb);
    				} catch (IOException e) {
    					
    				}
    			});
    			writerProduct.schliesseDatei();		    
    }   
}