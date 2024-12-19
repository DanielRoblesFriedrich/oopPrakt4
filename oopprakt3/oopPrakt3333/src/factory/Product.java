package factory;

import java.io.IOException;
import java.util.ArrayList;

import business.Cafe;

public abstract class Product {

	public abstract ArrayList<Cafe> leseAusDatei() throws IOException;
	
	public abstract void schliesseDatei() throws IOException;
}