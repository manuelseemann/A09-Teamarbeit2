package Seemann;

/**
* Das Model, enthält die Geschäftslogik der GUI
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
	 * Diese Methode prüft, ob alle Lichter aus sind und das Spielende erreicht ist.
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
}