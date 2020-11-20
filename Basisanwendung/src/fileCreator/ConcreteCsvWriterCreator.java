//Praktikum 2 - Fabrik-Methode
package fileCreator;

public class ConcreteCsvWriterCreator extends WriterCreator{
	@Override
	public WriterProduct factoryMethod(){
		
		WriterProduct wp = new ConcreteCsvWriterProduct();
		
		return wp;
	}
}