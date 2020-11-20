//Praktikum 2 - Fabrik-Methode
package fileCreator;

public class ConcreteTxtWriterCreator extends WriterCreator{
	@Override
	public WriterProduct factoryMethod(){
		
		WriterProduct wp = new ConcreteTxtWriterProduct();
		
		return wp;
	}
}