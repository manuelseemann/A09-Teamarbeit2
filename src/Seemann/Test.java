package Seemann;
import Seemann.Controller;

/**
* Klasse mit main Methode zum Testen des Programms
* 
* @author Hasenberger, Mazzolini, Reichmann, Seemann
* @version 2016-11-17
**/
public class Test{
	/**
	* Main-Methode zum Starten der Applikation
	* 
	* @param args
	*/
	public static void main(String[] args){
		Controller c = new Controller();
		Model m = new Model();
		//Testing der einzelnen Methoden:
		try{
		System.out.println("Ist das Spiel zu ende?: "+ m.spielende(14));
		m.aendern(89);
		}
		catch(NumberFormatException e){
			System.out.println("Die Nummer ist auﬂerhalb des Wetebereichs.");
		}
		System.out.println(m.getZufallszahl());
		
		
		
	}
}