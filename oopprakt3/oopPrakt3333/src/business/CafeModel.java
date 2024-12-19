package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import factory.Creator;
import factory.Product;
import ownUtil.Observable;
import ownUtil.Observer;
import factory.ConcreteCsvCreator;
import factory.ConcreteTxtCreator;


public class CafeModel implements Observable{

	private Cafe cafe;
	
	//Singleton:
	private static CafeModel cafeModel;
	
	private ArrayList<Cafe> cafes = new ArrayList<>();
	
	
	
	
	private Vector<Observer> observers = new Vector<Observer>();
	public static CafeModel getInstance() {
		
		if(cafeModel == null) {
			cafeModel = new CafeModel();
		}
		return cafeModel;
	}
	
	public void schreibeCafeInCsvDatei(ArrayList<Cafe> cafes) throws IOException{
		
		
		if (this.cafe == null) {
	        throw new IllegalStateException("Cafe nicht verfügbar");
	    }
			BufferedWriter aus = new BufferedWriter(new FileWriter("Cafe.csv", true));
			aus.write(this.cafes.size() + "");
			aus.newLine();
			
			for(Cafe caf : cafes) {
				aus.write(caf.getName());
				aus.newLine();
				aus.write(caf.getOrt());
				aus.newLine();
				aus.write(caf.getBeschreibung());
				aus.newLine();
				aus.write(caf.getIsBaeckerei());
				aus.newLine();
				aus.write(caf.getKaffeeProduktAlsString(';'));
				aus.newLine();
			}
			aus.close();
		
	}
	public void leseCafeAusCsvDatei() throws IOException {
		
		Creator readerCreator = new ConcreteCsvCreator();
	    Product reader = readerCreator.factoryMethod();
	    
	    ArrayList<Cafe> cafes = reader.leseAusDatei();
	    
	    this.cafes.addAll(cafes);
        reader.schliesseDatei();
        //Observer:


        notifyObservers();
	}
	
	public ArrayList<Cafe> getCafes() {
	    return cafes;
	}
	
	
	public void leseCafeAusTxtDatei() throws IOException {
			
		Creator readerCreator = new ConcreteCsvCreator();
	    Product reader = readerCreator.factoryMethod();
	    
	    ArrayList<Cafe> cafes = reader.leseAusDatei();
	    
	    this.cafes.addAll(cafes);
        reader.schliesseDatei();
	        
	        //Observer:
	        notifyObservers();
		}

	public Cafe getCafe() {
		return cafe;
	}
	

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
		notifyObservers();
	}
	private CafeModel() {
		
	}

	//Observable:

	@Override
	public void addObserver(Observer obs) {
		
		observers.addElement(obs);
		
	}

	@Override
	public void removeObserver(Observer obs) {

		observers.removeElement(obs);
		
	}

	@Override
	public void notifyObservers() {

		for(int i = 0; i < this.observers.size(); i++){ 
			   this.observers.elementAt(i).update(); 
			  }
		
	}

	

	
	
}