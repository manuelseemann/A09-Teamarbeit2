package Seemann;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
* Der Controller
* 
* @author Hasenberger, Mazzolini, Reichmann, Seemann
* @version 2016-11-17
*/
public class Controller implements ActionListener{
	/**
	 * Attribute
	 */
	private Model m; //Das Model
	private View v; //Die View
	
	/**
	 * Konstruktor
	 */
	public Controller(){
		this.m = new Model();
		this.v = new View(this.m, this);
		this.v.start();
	}
	
	/**
	* Verwaltet die Ereignisse bei z.B. Klicks auf Interaktionselemente in der View/Fenster (Ereignissteuerung)
	* 
	* @param e Referenz auf das ActionEvent-Objekt
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		//Wenn restart Button gedrückt wurde
		if(this.v.istDasRestart(e.getSource()) == true){
			this.v.setVisible(false);
			this.v = new View(this.m, this);
			this.v.start();
		}
		
		//Wenn exit Button gedrückt wurde
		if(this.v.istDasExit(e.getSource()) == true){
			System.exit(0);
		}
		
		//Wenn einer der Buttons des Spiels gedrückt wurde
		if(this.v.istDasButton(e.getSource()) == true){
			JButton pressed = (JButton) e.getSource(); //Schaut welcher Button gedrückt wurde
			System.out.println("Button Nummer: "+ pressed.getText());//Nur für Testing
			this.v.farbenAnpassen(this.m.aendern(Integer.parseInt(pressed.getText())));
			if(this.m.spielende(this.v.getAnzahlSchwarz())){
				JOptionPane.showMessageDialog(null, "Spielende! Sie haben gewonnen! " + "Sie brauchten: " +this.m.getSpieldauer() + "Sekunden.");
				this.v.setVisible(false);
				this.v = new View(this.m, this);
				this.v.start();
			}
		}
	}
}