//Praktikum 3 Singelton,Observer
package gui.guiSportstaetten;

//import java.io.IOException;
//import java.util.Observable;
//import java.util.Observer;
import observerPattern.Observer;
import business.FreizeitbaederModel;
//import gui.guiSportstaetten.SportstaettenView;
import javafx.stage.Stage;

public class SportstaettenControl implements Observer {
	private SportstaettenView sportstaettenView;
	private FreizeitbaederModel freizeitbaederModel;
	
	public SportstaettenControl(Stage primaryStage){
		this.freizeitbaederModel = FreizeitbaederModel.getInstance();
		this.sportstaettenView = new SportstaettenView(this, primaryStage,freizeitbaederModel);
		this.freizeitbaederModel.addObserver(this);
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
