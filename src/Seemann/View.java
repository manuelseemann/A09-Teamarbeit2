package Seemann;
import javax.swing.*;

import Seemann.Controller;
import Seemann.Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
* Die View, Fenster mit Interaktionselementen
* 
* @author Hasenberger, Mazzolini, Reichmann, Seemann
* @version 2016-11-17
*/
public class View extends JFrame{
	/**
	 * Attribute
	 */
	private Controller c; //Der Controller
    private Model m; //Das Model
    
    private ArrayList<JButton> buttons; //ArrayList mit den Buttons
    private JButton restart; //Button zum restarten des Spiels
    private JButton exit; //Button zum schlieﬂen des Spiels
	
    private int anzahlSchwarz; //Anzahl der schwarzen/licht aus Felder
    private int anzahlGelb; //Anzahl der gelben/licht an Felder
    
	/**
	 * Konstruktor
	 * 
	 * @param m das Model
	 * @param c der Controller
	 */
	public View(Model m, Controller c){
		this.m = m;
		this.c = c;
		
		this.restart = new JButton("Restart");
		this.exit = new JButton("Exit");
		this.buttons = new ArrayList<JButton>();
		for (int i = 0; i < 25; i++) {
			this.buttons.add(new JButton(i+""));
			this.buttons.get(i).setFont(new Font("Arial", Font.PLAIN, 0));
		}
		
		JPanel b = new JPanel();
		b.setLayout(new GridLayout(0, 5));
		Iterator<JButton> iter = buttons.iterator();
		while(iter.hasNext()){
			b.add(iter.next());
		}
		
		JPanel s = new JPanel();
		s.add(this.restart);
		s.add(this.exit);
		
		this.setTitle("Light Out Game");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        this.add(new JLabel("Light Out Game"), BorderLayout.NORTH);
        this.add(b, BorderLayout.CENTER);
        this.add(s, BorderLayout.SOUTH);
        
        //Adden zum ActionListener
        Iterator<JButton> i = buttons.iterator();
		while(i.hasNext()){
			i.next().addActionListener(this.c);
		}
		restart.addActionListener(this.c);
		exit.addActionListener(this.c);
        
        this.setVisible(true);
	}
	
	/**
	 * start Methode, weiﬂt den Buttons Farben zu, Zuf‰llige Anzahl an gelben/leuchteten Buttons, die restlichen schwarz
	 * Wird zu Begin des Programmes aufgerufen
	 */
	public void start(){
		//Alle Buttons bekommen zun‰chst die Farbe schwarz
		for (int i = 0; i < 25; i++) {
			this.buttons.get(i).setBackground(Color.black);
		}
		
		//Zuf‰llige Buttons werden zurerst gedr¸ckt
		int za = this.m.getZufallszahl();
		for(int i=0; i < za; i++){
			int zz = this.m.getZufallszahl();
			this.farbenAnpassen(this.m.aendern(zz));
		}
	}
	
	/**
	 * Get-Methode f¸r anzahlSchwarz
	 * 
	 * @return int Wert mit der Anzahl der Schwarzen Buttons
	 */
	public int getAnzahlSchwarz(){
		return this.anzahlSchwarz;
	}
	
	/**
	* ‹berpr¸ft ob das Object buttons enth‰lt
	* 
	* @param b das zu ¸berpr¸fende Object
	* @return true wenn buttons beinhaltet b ansonsten false
	*/
	public boolean istDasButton(Object b){
		if(this.buttons.contains(b)) return true;
		return false;
	}
	
	/**
	* ‹berpr¸ft ob das Object restart ist
	* 
	* @param b das zu ¸berpr¸fende Object
	* @return true wenn b gleich restart ansonsten false
	*/
	public boolean istDasRestart(Object b){
		if(this.restart==b) return true;
		return false;
	}
	
	/**
	* ‹berpr¸ft ob das Object exit ist
	* 
	* @param b das zu ¸berpr¸fende Object
	* @return true wenn b gleich exit ansonsten false
	*/
	public boolean istDasExit(Object b){
		if(this.exit==b) return true;
		return false;
	}
	
	/**
	 * Methode zum Anpassen der Farben: Schwarze werden gelb, Gelbe werden schwarz
	 * 
	 * @param x ArrayList mit den Nummern der zu ‰nderten Feldern
	 */
	public void farbenAnpassen(ArrayList <Integer> x){
		for (int o : x){
			String farbe = this.buttons.get(o).getBackground().toString();
			
			if(farbe.equals("java.awt.Color[r=0,g=0,b=0]")){
				this.buttons.get(o).setBackground(Color.yellow);
			}else{
				this.buttons.get(o).setBackground(Color.black);
			}
		}
		this.repaint();
	}
}