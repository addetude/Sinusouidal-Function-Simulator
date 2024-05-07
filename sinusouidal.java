//Program Name: Sinusoudial Function Simulator 
//Created by: Adeline Lue Song & Chloe Tai
//Version number: 0.1

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class sinusouidal extends JFrame implements ActionListener, ChangeListener{
	
	//PROPERTIES
	//Variables
	int inta = 1;
	int intk = 1;
	int intc = 0;
	int intd = 0;
	
	//Frame & Panels
	JFrame theframe = new JFrame("Sinusouidal Function Simulator");
	aboutpanel abpanel = new aboutpanel();
	homepanel hmpanel = new homepanel();
	helppanel hppanel = new helppanel();
	simpanel smpanel = new simpanel();
	
	
	//Menu
	JMenuBar themenubar = new JMenuBar();
	
	JMenu menumenu = new JMenu("Menu");
	JMenu mainmenu = new JMenu("Main");
	
	JMenuItem aboutmenuitem = new JMenuItem("About");
	JMenuItem helpmenuitem = new JMenuItem("Help");
	JMenuItem quizmenuitem = new JMenuItem("Quiz");
	JMenuItem simulatormenuitem = new JMenuItem("Simulator");
	JMenuItem homemenuitem = new JMenuItem("Home");
	
	//Sliders & Text Fields & Labels
	JSlider aslider = new JSlider(-10, 10, 0);
	JSlider kslider = new JSlider(-10, 10, 0);
	JSlider cslider = new JSlider();
	JSlider dslider = new JSlider();
	
	JTextField afield = new JTextField("1");
	JTextField kfield = new JTextField("1");
	JTextField cfield = new JTextField("0");
	JTextField dfield = new JTextField("0");
	
	//METHODS
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == homemenuitem){
			theframe.setContentPane(hmpanel);
			theframe.pack();
			theframe.repaint();
		}else if(evt.getSource() == simulatormenuitem){
			theframe.setContentPane(smpanel);
			theframe.pack();
			theframe.repaint();
		}else if(evt.getSource() == mainmenu){
			
		}else if(evt.getSource() == helpmenuitem){
			theframe.setContentPane(hppanel);
			theframe.pack();
			theframe.repaint();
		}else if(evt.getSource() == aboutmenuitem){
			theframe.setContentPane(abpanel);
			theframe.pack();
			theframe.repaint();
		}else if(evt.getSource() == quizmenuitem){
			
		}else if(evt.getSource() == afield){
			inta = Integer.parseInt(afield.getText());
			aslider.setValue(inta);
		}else if(evt.getSource() == kfield){
			intk = Integer.parseInt(kfield.getText());
			kslider.setValue(intk);
		}else if(evt.getSource() == cfield){
			intc = Integer.parseInt(cfield.getText());
			cslider.setValue(intc);
		}else if(evt.getSource() == dfield){
			intd = Integer.parseInt(dfield.getText());
			dslider.setValue(intd);
		}
	}
	public void stateChanged(ChangeEvent evt){
		if(evt.getSource() == aslider){
			inta = aslider.getValue();
			afield.setText(inta+"");
		}else if(evt.getSource() == kslider){
			inta = kslider.getValue();
			kfield.setText(intk+"");
		}else if(evt.getSource() == cslider){
			inta = cslider.getValue();
			cfield.setText(intc+"");
		}else if(evt.getSource() == dslider){
			inta = dslider.getValue();
			dfield.setText(intd+"");
		}
	}
	public void mouseClicked(MouseEvent evt){
		
	}
	public void keyTyped(KeyEvent evt){
		
	}
	
	//Constructor
	
	public sinusouidal(){
		smpanel.setLayout(null);
		
		//Add Menu Bar
		themenubar.add(menumenu);	
		themenubar.add(mainmenu);	
		
		mainmenu.add(simulatormenuitem);
		mainmenu.add(quizmenuitem);
		menumenu.add(homemenuitem);
		menumenu.add(helpmenuitem);
		menumenu.add(aboutmenuitem);	
		
		aboutmenuitem.addActionListener(this);
		helpmenuitem.addActionListener(this);
		quizmenuitem.addActionListener(this);
		simulatormenuitem.addActionListener(this);
		homemenuitem.addActionListener(this);
		
		theframe.setJMenuBar(themenubar);
		
		//Frame & Panel Design
		theframe.setPreferredSize(new Dimension(960,540));
		theframe.setResizable(false);
		theframe.setContentPane(hmpanel);
		theframe.pack();
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setVisible(true);
		
		//Sliders & Labels & Buttons
		aslider.setSize(250, 20);
		aslider.setLocation(50, 100);
		aslider.setValue(inta);
		aslider.addChangeListener(this);
		smpanel.add(aslider);
		
		kslider.setSize(250, 20);
		kslider.setLocation(50, 200);
		kslider.setValue(intk);
		kslider.addChangeListener(this);
		smpanel.add(kslider);
		
		cslider.setSize(250, 20);
		cslider.setLocation(50, 300);
		cslider.addChangeListener(this);
		smpanel.add(cslider);
		
		dslider.setSize(250, 20);
		dslider.setLocation(50, 400);
		dslider.addChangeListener(this);
		smpanel.add(dslider);
		
		afield.setSize(50, 20);
		afield.setLocation(153, 130);
		afield.setHorizontalAlignment(JTextField.CENTER);
		afield.addActionListener(this);
		smpanel.add(afield);
		
		kfield.setSize(50, 20);
		kfield.setLocation(153, 230);
		kfield.setHorizontalAlignment(JTextField.CENTER);
		kfield.addActionListener(this);
		smpanel.add(kfield);
		
		cfield.setSize(50, 20);
		cfield.setLocation(153, 330);
		cfield.setHorizontalAlignment(JTextField.CENTER);
		cfield.addActionListener(this);
		smpanel.add(cfield);
		
		dfield.setSize(50, 20);
		dfield.setLocation(153, 430);
		dfield.setHorizontalAlignment(JTextField.CENTER);
		dfield.addActionListener(this);
		smpanel.add(dfield);
		
		
	}
	
	//Main Method
	public static void main(String args[]){
		new sinusouidal();
	}
}
	
