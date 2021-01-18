//Praktikum 2 - Realisierung der Fabrik-Methode
package fileCreator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.businessFreizeitbaeder.Freizeitbad;

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

	//Überarbeitet Praktikum 2: schliesseDatei() darf nicht leer sein/ close-Befehl
	@Override
	public void schliesseDatei() throws IOException {	
		aus.close();
	}
}