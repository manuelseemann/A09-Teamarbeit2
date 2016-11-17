package Seemann;

/**
* Das Model, enth�lt die Gesch�ftslogik der GUI
* 
* @author Paul Mazzolini
* @version 2016-10-26
*/
public class Model{
	/**
	 * Attribute
	 */
	
	
	/**
	 * Konstruktor
	 */
	public Model(){
		
	}
	
	/**
	 * Methoden
	 */
	/**
	 * Diese Methode pr�ft, ob alle Lichter aus sind und das Spielende erreicht ist.
	 * @param anzdunkel ist die Anzahl an dunklen Lichtern
	 * @return <code>true</code> wenn das Spielende erreicht wurde
	 * 		   <code>false</code> andernfalls
	 */
	public boolean spielende(int anzahldunkel){
		 if(anzahldunkel == 25){
			 return true;
		 } else {
			 return false;
		 }
	 }
	
	public int [] aendern (int nummer){
		int [] rueckgabe = new int [4];
		rueckgabe [1] = nummer -5;
		rueckgabe [2] = nummer +5;
		rueckgabe [3] = nummer -1;
		rueckgabe [4] = nummer +1;
		rueckgabe [5] = nummer;
		return rueckgabe;
	}
}