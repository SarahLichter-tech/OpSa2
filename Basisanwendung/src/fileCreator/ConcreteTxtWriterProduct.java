//Praktikum 2 - Realisierung der Fabrik-Methode
package fileCreator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteTxtWriterProduct extends WriterProduct {
BufferedWriter aus;	
	
	public ConcreteTxtWriterProduct(){

		try {
			aus = new BufferedWriter(new FileWriter("Freizeitbad.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
	    aus = new BufferedWriter(new FileWriter("Freizeitbad.txt"));
	    aus.write(((Freizeitbad) object).gibFreizeitbadZurueck(';'));
	    aus.close();
	}

	@Override
	public void schliesseDatei() throws IOException {	
	}
}