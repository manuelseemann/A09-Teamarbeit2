package Seemann;
import javax.swing.*;

import Seemann.Controller;
import Seemann.Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
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
	
	public void start(){
		//Alle Buttons bekommen Farbe schwarz
		for (int i = 0; i < 25; i++) {
			this.buttons.get(i).setBackground(Color.black);
		}
		
		int OG = 24; //Obergrenze
		int UG = 1; //Untergrenze
		//Zufallsanzahl der Elemente, die gelb werden
		int za = (int)(Math.random()*(OG-UG)+UG);
		
		LinkedList gelbe = new LinkedList(); //Enth‰lt die gelben
		for(int i=0; i < za; i++){
			int zz = (int)(Math.random()*(OG-UG)); //Zufallszahl welches Element gelb wird
			if(!gelbe.contains(zz)){
				gelbe.add(zz);
				this.buttons.get(zz).setBackground(Color.yellow);
			}
		}
		
		this.anzahlGelb = gelbe.size();
		this.anzahlSchwarz = this.buttons.size()-this.anzahlGelb;
	}
	
	public int getAnzahlSchwarz(){
		return this.anzahlSchwarz;
	}
	
	public boolean istDasButton(Object b){
		if(this.buttons.contains(b)) return true;
		return false;
	}
	
	public boolean istDasRestart(Object b){
		if(this.restart==b) return true;
		return false;
	}
	
	public boolean istDasExit(Object b){
		if(this.exit==b) return true;
		return false;
	}
	
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