//Praktikum 2 - Fabrik-Methode
package fileCreator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteCsvWriterProduct extends WriterProduct {
BufferedWriter aus;	
	
	public ConcreteCsvWriterProduct(){

		try {
			aus = new BufferedWriter(new FileWriter("Freizeitbad.csv"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
	    aus = new BufferedWriter(new FileWriter("Freizeitbad.csv"));
	    aus.write(((Freizeitbad) object).gibFreizeitbadZurueck(';'));
	    aus.close();
	}

	@Override
	public void schliesseDatei() throws IOException {
			
	}
}