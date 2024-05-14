//Program Name: Sinusoudial Function Simulator 
//Created by: Adeline Lue Sang & Chloe Tai
//Version number: 0.1

//CHECK TEXT FIELD INPUT EXCEPTION

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class sinusouidal extends JFrame implements ActionListener, ChangeListener{
	
	//PROPERTIES
	boolean blnchecker = true;
	
	//Frame & Panels
	JFrame theframe = new JFrame("Sinusouidal Function Simulator");
	aboutpanel abpanel = new aboutpanel();
	homepanel hmpanel = new homepanel();
	helppanel hppanel = new helppanel();
	simpanel smpanel = new simpanel();
	quizpanel qzpanel = new quizpanel();
	scorespanel scpanel = new scorespanel();
	
	
	//Menu
	JMenuBar themenubar = new JMenuBar();
	
	JMenu menumenu = new JMenu("Menu");
	JMenu mainmenu = new JMenu("Main");
	
	JMenuItem aboutmenuitem = new JMenuItem("About");
	JMenuItem helpmenuitem = new JMenuItem("Help");
	JMenuItem quizmenuitem = new JMenuItem("Quiz");
	JMenuItem simulatormenuitem = new JMenuItem("Simulator");
	JMenuItem homemenuitem = new JMenuItem("Home");
	JMenuItem scoremenuitem = new JMenuItem("Scores");
	
	//Initialize Sliders & Text Fields & Labels & Combo Boxes & Buttons
	JSlider aslider = new JSlider(-10, 10, 0);
	JSlider kslider = new JSlider(-10, 10, 0);
	JSlider cslider = new JSlider(-10, 10, 0);
	JSlider dslider = new JSlider(-10, 10, 0);
	
	JTextField afield = new JTextField("1");
	JTextField kfield = new JTextField("1");
	JTextField cfield = new JTextField("0");
	JTextField dfield = new JTextField("0");
	
	JTextField nametf = new JTextField("");
	
	JLabel avalue = new JLabel("a-value");
	JLabel kvalue = new JLabel("k-value");
	JLabel cvalue = new JLabel("c-value");
	JLabel dvalue = new JLabel("d-value");
	
	JLabel eqlabel = new JLabel("equation");
	JLabel ftlabel = new JLabel("function type");
	JLabel yvalue = new JLabel("y-value");
	
	JLabel eqa = new JLabel("");
	JLabel eqk = new JLabel("");
	JLabel eqc = new JLabel("");
	JLabel eqd = new JLabel("");
	JLabel eqfunc = new JLabel("sin");
	
	JLabel name = new JLabel("Name: ");
	JLabel q1 = new JLabel("Cos(x) with a phase shift of __ to the ___ gives the sin(x) function");
	JLabel q2 = new JLabel("What does the 'c' parameter of a sinusoidal function indicate?");
	JLabel q3 = new JLabel("If cotx = 0, what is x?");
	
	String[] arr = {"sin", "cos", "tan"};
	String[] arr1 = {" ", "π/2, left", "π/2, right", "π, left", "π, right"};
	String[] arr2 = {" ", "amplitude", "horizontal stretch", "phase shift", "vertical translation"};
	String[] arr3 = {" ", "π/4", "π/2", "π", "2π"};
	
	JComboBox cb = new JComboBox(arr);
	JComboBox quiz1 = new JComboBox(arr1);	
	JComboBox quiz2 = new JComboBox(arr2);	
	JComboBox quiz3 = new JComboBox(arr3);	
	
	JButton submit = new JButton("Submit");
	JButton retake = new JButton("Retake");
	
	//Files
	PrintWriter txtScores;
	
	//METHODS
	//Set Content Pane to a panel based on menu item selected and repaint
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == homemenuitem){
			theframe.setContentPane(hmpanel);
			theframe.pack();
			theframe.repaint();
		}else if(evt.getSource() == simulatormenuitem){
			theframe.setContentPane(smpanel);
			theframe.pack();
			theframe.repaint();
		}else if(evt.getSource() == helpmenuitem){
			theframe.setContentPane(hppanel);
			theframe.pack();
			theframe.repaint();
		}else if(evt.getSource() == aboutmenuitem){
			theframe.setContentPane(abpanel);
			theframe.pack();
			theframe.repaint();
		}else if(evt.getSource() == quizmenuitem){
			theframe.setContentPane(qzpanel);
			theframe.pack();
			theframe.repaint();
		}else if(evt.getSource() == scoremenuitem){
			theframe.setContentPane(scpanel);
			theframe.pack();
			theframe.repaint();
		}else if(evt.getSource() == afield){
			//Get parameter values from textfields
			smpanel.inta = Integer.parseInt(afield.getText());
			aslider.setValue(smpanel.inta);
			smpanel.repaint();
		}else if(evt.getSource() == kfield){
			smpanel.intk = Integer.parseInt(kfield.getText());
			kslider.setValue(smpanel.intk);
			smpanel.repaint();
		}else if(evt.getSource() == cfield){
			smpanel.intc = Integer.parseInt(cfield.getText());
			cslider.setValue(smpanel.intc);
			smpanel.repaint();
		}else if(evt.getSource() == dfield){
			smpanel.intd = Integer.parseInt(dfield.getText());
			dslider.setValue(smpanel.intd);
			smpanel.repaint();
		}else if(evt.getSource() == cb){
			//Get preferred function type from combo box
			smpanel.strcb = (String)cb.getSelectedItem();
			eqfunc = eqmethfunc(smpanel.strcb);
			smpanel.add(eqfunc);
			smpanel.repaint();
		}else if(evt.getSource() == submit){
			//when submit is pressed, calculate number of correct answers
			if(quiz1.getSelectedItem() == "π/2, right"){
				qzpanel.intPoints += 1;
			}if(quiz2.getSelectedItem() == "phase shift"){
				qzpanel.intPoints += 1;
			}if(quiz3.getSelectedItem() == "π/2"){
				qzpanel.intPoints += 1;
			}
			String strName = nametf.getText();
			
			//print user's name and score to score file
			try{
				txtScores = new PrintWriter(new FileWriter("scores.txt", true));
			}catch(IOException e){
				System.out.println("could not load scores.txt");
			}
			
			//after subit is pressed, user cannot change answer
			if(blnchecker == true){
				txtScores.println(strName);
				txtScores.println(qzpanel.intPoints);
				txtScores.close();
				
				qzpanel.check = true;
				quiz1.setEnabled(false);
				quiz2.setEnabled(false);
				quiz3.setEnabled(false);
				qzpanel.repaint();
				
				blnchecker = false;
			}
		}else if(evt.getSource() == retake){
			//retake button resets quiz panel
			blnchecker = true;
			quiz1.setEnabled(true);
			quiz2.setEnabled(true);
			quiz3.setEnabled(true);
			quiz1.setSelectedItem(" ");
			quiz2.setSelectedItem(" ");
			quiz3.setSelectedItem(" ");
			qzpanel.intPoints = 0;
			qzpanel.check = false;
			qzpanel.repaint();
		}
	}
	
	//Get perameters from sliders and use values to update equation/graph
	public void stateChanged(ChangeEvent evt){
		if(evt.getSource() == aslider){
			smpanel.inta = aslider.getValue();
			afield.setText(smpanel.inta+"");
			eqa = eqmetha(smpanel.inta);
			smpanel.add(eqa);
			smpanel.repaint();
		}else if(evt.getSource() == kslider){
			smpanel.intk = kslider.getValue();
			kfield.setText(smpanel.intk+"");
			eqk = eqmethk(smpanel.intk);
			smpanel.add(eqk);
			smpanel.repaint();
		}else if(evt.getSource() == cslider){
			smpanel.intc = cslider.getValue();
			cfield.setText(smpanel.intc+"");
			eqc = eqmethc(smpanel.intc);
			smpanel.add(eqc);
			smpanel.repaint();
		}else if(evt.getSource() == dslider){
			smpanel.intd = dslider.getValue();
			dfield.setText(smpanel.intd+"");
			eqd = eqmethd(smpanel.intd);
			smpanel.add(eqd);
			smpanel.repaint();
		}
	}
	
	//Methods to reproduce graph equation each time peramters are adjusted
	public JLabel eqmetha(int inta){
		eqa.setText("");
		
		JLabel equation = new JLabel();
		
		equation.setSize(100, 50);
		equation.setForeground(Color.RED);
		equation.setText(inta+"");
		equation.setLocation(784, 168);
		
		return equation;
	}
	public JLabel eqmethk(int intk){
		eqk.setText("");
		
		JLabel equation = new JLabel();
		
		equation.setSize(100, 50);
		equation.setForeground(new Color(250, 100, 210));
		equation.setText(intk+"");
		equation.setLocation(839, 168);
		
		return equation;	
	}
	public JLabel eqmethc(int intc){
		eqc.setText("");
		
		JLabel equation = new JLabel();
		
		equation.setSize(100, 50);
		equation.setForeground(Color.BLUE);
		equation.setText(intc+"");
		equation.setLocation(883, 168);
		
		return equation;
	}
	public JLabel eqmethd(int intd){
		eqd.setText("");
		
		JLabel equation = new JLabel();
		
		equation.setSize(100, 50);
		equation.setForeground(new Color(240, 120, 50));
		equation.setText(intd+"");
		equation.setLocation(928, 168);
		
		return equation;
	}
	public JLabel eqmethfunc(String strfunc){
		eqfunc.setText("");
		
		JLabel equation = new JLabel();
		
		equation.setSize(100, 50);
		equation.setForeground(Color.BLACK);
		equation.setText(strfunc+"");
		equation.setLocation(812, 168);
		
		return equation;
	}
	
	//CONSTRUCTOR
	public sinusouidal(){
		smpanel.setLayout(null);
		qzpanel.setLayout(null);
		
		//Setup Menu Bar
		themenubar.add(menumenu);	
		themenubar.add(mainmenu);	
		
		mainmenu.add(simulatormenuitem);
		mainmenu.add(quizmenuitem);
		mainmenu.add(scoremenuitem);
		menumenu.add(homemenuitem);
		menumenu.add(helpmenuitem);
		menumenu.add(aboutmenuitem);
		
		theframe.setJMenuBar(themenubar);
		
		//Add Action Listener to menu items, buttons, and combo boxes
		aboutmenuitem.addActionListener(this);
		helpmenuitem.addActionListener(this);
		quizmenuitem.addActionListener(this);
		simulatormenuitem.addActionListener(this);
		homemenuitem.addActionListener(this);
		scoremenuitem.addActionListener(this);
		
		cb.addActionListener(this);
		submit.addActionListener(this);
		retake.addActionListener(this);
		
		//Frame & Panel Design
		theframe.setPreferredSize(new Dimension(960,540));
		theframe.setResizable(false);
		theframe.setContentPane(hmpanel);
		theframe.pack();
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setVisible(true);
		
		//Sliders & Labels & Buttons & Text Fields, format and add Change Listeners/Action Listeners
		aslider.setSize(250, 20);
		aslider.setLocation(50, 100);
		aslider.setValue(smpanel.inta);
		aslider.addChangeListener(this);
		smpanel.add(aslider);
		
		kslider.setSize(250, 20);
		kslider.setLocation(50, 200);
		kslider.setValue(smpanel.intk);
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
		
		avalue.setSize(100, 50);
		avalue.setLocation(155, 55);
		smpanel.add(avalue);
		
		kvalue.setSize(100, 50);
		kvalue.setLocation(155, 155);
		smpanel.add(kvalue);
		
		cvalue.setSize(100, 50);
		cvalue.setLocation(155, 255);
		smpanel.add(cvalue);
		
		dvalue.setSize(100, 50);
		dvalue.setLocation(155, 355);
		smpanel.add(dvalue);
		
		eqlabel.setSize(100, 50);
		eqlabel.setLocation(838, 130);
		smpanel.add(eqlabel);
		
		ftlabel.setSize(100, 50);
		ftlabel.setLocation(830, 260);
		smpanel.add(ftlabel);
		
		cb.setSize(60, 25);
		cb.setLocation(837, 300);
		smpanel.add(cb);
		
		//Set up quiz panel label & combo box formatting
		name.setSize(200, 25);
		name.setLocation(20, 20);
		qzpanel.add(name);
		
		nametf.setSize(100, 20);
		nametf.setLocation(75, 24);
		qzpanel.add(nametf);
		
		q1.setSize(500, 50);
		q1.setLocation(20, 50);
		qzpanel.add(q1);
		
		q2.setSize(500, 50);
		q2.setLocation(20, 150);
		qzpanel.add(q2);
		
		q3.setSize(500, 50);
		q3.setLocation(20, 260);
		qzpanel.add(q3);
		
		quiz1.setSize(100, 25);
		quiz1.setLocation(20, 100);
		qzpanel.add(quiz1);
		
		quiz2.setSize(150, 25);
		quiz2.setLocation(20, 200);
		qzpanel.add(quiz2);
		
		quiz3.setSize(50, 25);
		quiz3.setLocation(20, 310);
		qzpanel.add(quiz3);
		
		submit.setSize(150, 50);
		submit.setHorizontalAlignment(JButton.CENTER);
		submit.setLocation(40, 380);
		qzpanel.add(submit);
		
		retake.setSize(150, 50);
		retake.setHorizontalAlignment(JButton.CENTER);
		retake.setLocation(220, 380);
		qzpanel.add(retake);
		
		//set up intial equation for the graph
		eqa = eqmetha(smpanel.inta);
		smpanel.add(eqa);
		
		eqk = eqmethk(smpanel.intk);
		smpanel.add(eqk);
		
		eqc = eqmethc(smpanel.intc);
		smpanel.add(eqc);
		
		eqd = eqmethd(smpanel.intd);
		smpanel.add(eqd);
		
		eqfunc = eqmethfunc(smpanel.strcb);
		smpanel.add(eqfunc);
		

	}
	
	//MAIN METHOD
	public static void main(String args[]){
		new sinusouidal();
	}
	
	

}
	
