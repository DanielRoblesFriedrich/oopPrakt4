package factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import business.Cafe;

	public class ConcreteTxtProduct extends Product {
		private BufferedReader ein;

		public ConcreteTxtProduct() throws FileNotFoundException {
			this.ein = new BufferedReader(new FileReader("Cafe.txt"));;
		}
	@Override
	public ArrayList<Cafe> leseAusDatei() throws IOException {
		ArrayList<Cafe> cafes = new ArrayList<>();
	    String[] zeile = null;
	    String zeileStr = ein.readLine();
	    while (zeileStr != null) {
	    	zeile = zeileStr.split(";");
	        cafes.add(new Cafe(
	        		zeile[0],
	        		zeile[1],
	        		zeile[2],
	        		zeile[3],
	        		zeile[4].split(", ")
	        		));
	        zeileStr = ein.readLine();
	    }
	    ein.close();
	    return cafes;
	
}

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		ein.close();
		
	}

}