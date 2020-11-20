//Praktikum 2 -  Realisierung der Fabrik-Methode
package fileCreator;

import java.io.IOException;

public abstract class WriterProduct {
	
	public abstract void fuegeInDateiHinzu(Object object) throws IOException;
	public abstract void schliesseDatei() throws IOException;
}
