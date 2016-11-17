package Seemann;

import java.util.ArrayList;

/**
* Das Model, enthält die Geschäftslogik der GUI
* 
* @author Hasenberger, Mazzolini, Reichmann, Seemann
* @version 2016-11-17
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
	
	public ArrayList <Integer> aendern (int nummer){

		ArrayList <Integer> rueckgabe = new ArrayList <Integer>(); 
		//Hauptfeld mitte
		if(nummer >=6 && nummer <=8 || nummer >=11 && nummer <=13 || nummer >=16 && nummer <=18){
			rueckgabe.add(nummer -5);
			rueckgabe.add(nummer +5);
			rueckgabe.add(nummer -1);
			rueckgabe.add(nummer +1);
			rueckgabe.add(nummer);
		}
		//Linker Rand
		if(nummer == 5|| nummer == 10 || nummer == 15){
			rueckgabe.add(nummer -5);
			rueckgabe.add(nummer +5);
			rueckgabe.add(nummer +1);
			rueckgabe.add(nummer);
		}
		//Oberer Rand
		if(nummer >= 1 && nummer <= 3){
			rueckgabe.add(nummer +5);
			rueckgabe.add(nummer -1);
			rueckgabe.add(nummer +1);
			rueckgabe.add(nummer);
		}
		//Rechter Rand
		if(nummer == 9|| nummer == 14 || nummer == 19){
			rueckgabe.add(nummer -5);
			rueckgabe.add(nummer +5);
			rueckgabe.add(nummer -1);
			rueckgabe.add(nummer);
		}
		//Unterer Rand
		if(nummer >= 21 && nummer <= 23){
			rueckgabe.add(nummer -5);
			rueckgabe.add(nummer -1);
			rueckgabe.add(nummer +1);
			rueckgabe.add(nummer);
		}
		//Ecke links oben
		if(nummer == 0){
			rueckgabe.add(nummer +5);
			rueckgabe.add(nummer +1);
			rueckgabe.add(nummer);
		}
		//Ecke rechts oben 
		if(nummer == 4){
			rueckgabe.add(nummer +5);
			rueckgabe.add(nummer -1);
			rueckgabe.add(nummer);
		}
		//Ecke rechts unten 
		if(nummer == 24){
			rueckgabe.add(nummer -5);
			rueckgabe.add(nummer -1);
			rueckgabe.add(nummer);
		}
		//Ecke links unten
		if(nummer == 20){
			rueckgabe.add(nummer -5);
			rueckgabe.add(nummer +1);
			rueckgabe.add(nummer);
		}
		return rueckgabe;
	}
}