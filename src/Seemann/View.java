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
* @author Paul Mazzolini
* @version 2016-10-26
*/
public class View extends JFrame{
	/**
	 * Attribute
	 */
	private Controller c; //Der Controller
    private Model m; //Das Model
    
    private ArrayList<JButton> buttons;
    private JButton restart;
    private JButton exit;
	
    private int anzahlSchwarz;
    private int anzahlGelb;
    
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
			this.buttons.add(new JButton(""));
		}
		
		//Alle Buttons bekommen Farbe schwarz
		for (int i = 0; i < 25; i++) {
			this.buttons.get(i).setBackground(Color.black);;
		}
		
		int OG = 24; //Obergrenze
		int UG = 1; //Untergrenze
		//Zufallsanzahl der Elemente, die gelb werden
		int za = (int)(Math.random()*(OG-UG)+UG);
		
		LinkedList gelbe = new LinkedList(); //Enthält die gelben
		for(int i=0; i < za; i++){
			int zz = (int)(Math.random()*(OG-UG)); //Zufallszahl welches Element gelb wird
			if(!gelbe.contains(zz)){
				gelbe.add(zz);
				this.buttons.get(zz).setBackground(Color.yellow);
			}
		}
		
		this.anzahlGelb = gelbe.size();
		this.anzahlSchwarz = this.buttons.size()-this.anzahlGelb;
		
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
        
        Iterator<JButton> i = buttons.iterator();
		while(i.hasNext()){
			i.next().addActionListener(this.c);
		}
		restart.addActionListener(this.c);
		exit.addActionListener(this.c);
        
        this.setVisible(true);
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
}