package business;
   
import java.io.BufferedWriter;
import business.Freizeitbad;
import java.io.FileWriter;
import java.io.IOException;

public class FreizeitbaederModel {
	     
    // speichert temporaer ein Objekt vom Typ Freizeitbad
    private Freizeitbad freizeitbad;
    
    public Freizeitbad getFreizeitbad() {
		return this.freizeitbad;
    }
    
    public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
    }
    
    //Ąnderung
    public void schreibeFreizeitbaederInCsvDatei()
	    //Werfen einer IOException
    	throws IOException{
    		BufferedWriter aus = new BufferedWriter(
			  new FileWriter("Freizeitbaeder.csv", true));
    		aus.write(this.getFreizeitbad().gibFreizeitbadZurueck(';'));
    		aus.close();
	}    
}