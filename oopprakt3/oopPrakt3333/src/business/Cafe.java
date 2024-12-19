package business;

import java.util.ArrayList;

public class Cafe {

	
	private String name;
	private String ort;
	private String beschreibung;
	private String isBaeckerei;
	//private String[] kaffeeProdukt;
	private ArrayList<String> kaffeeProdukten;
	
	public Cafe(String name, String ort, String beschreibung, String isBaeckerei, String[] kaffeProdukt) {
		super();
		this.name = name;
		this.ort = ort;
		this.beschreibung = beschreibung;
		this.isBaeckerei = isBaeckerei;
		this.kaffeeProdukten = getKaffeproduktAusArray(kaffeProdukt);
	}
	private ArrayList<String> getKaffeproduktAusArray(String[] cafeArray) {
        this.kaffeeProdukten = new ArrayList<>();
        for (String menge : cafeArray) {
            this.kaffeeProdukten.add(menge.trim()); 
        }
        return kaffeeProdukten;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getIsBaeckerei() {
		return isBaeckerei;
	}

	public void setBaeckerei(String isBaeckerei) {
		this.isBaeckerei = isBaeckerei;
	}

	public ArrayList<String> getKaffeProdukt() {
		return kaffeeProdukten;
	}

	public void setKaffeProdukt(ArrayList<String> kaffeProdukt) {
		this.kaffeeProdukten = kaffeeProdukten;
	}
	
	public String getKaffeeProduktAlsString(char trenner) {
		
		/*
		String ergebnis = "";
		int i = 0;
		
		for(i = 0; i < this.getKaffeProdukt().length -1; i++) {
			
			ergebnis = ergebnis + this.getKaffeProdukt()[i] + trenner;
		}
		
		return ergebnis + this.getKaffeProdukt()[i];
		*/
		
		 StringBuilder ergebnis = new StringBuilder();
        for (int i = 0; i < this.getKaffeProdukt().size() - 1; i++) {
            ergebnis.append(this.kaffeeProdukten.get(i)).append(trenner);
        }
        return ergebnis.append(this.kaffeeProdukten.get(this.kaffeeProdukten.size() - 1)).toString();
		 
	}
	
	public String gibCafeZuruck(char trenner) {
		
		return this.getName() + trenner +
				this.getOrt() + trenner +
				this.getBeschreibung() + trenner +
				this.getIsBaeckerei() + trenner + 
				this.getKaffeeProduktAlsString(trenner) + "\n";
	}
	
}
