package Seemann;
import javax.swing.*;

import Seemann.Controller;
import Seemann.Model;

import java.awt.*;
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
    
    private LinkedList<JButton> buttons;
    private JButton restart;
    private JButton exit;
	
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
		this.buttons = new LinkedList<JButton>();
		for (int i = 0; i < 25; i++) {
			this.buttons.add(new JButton(""));
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