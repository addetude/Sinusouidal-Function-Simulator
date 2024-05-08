//Program Name: Sinusoudial Function Simulator 
//Created by: Adeline Lue Sang & Chloe Tai
//Version number: 0.1

//CHECK TEXT FIELD INPUT EXCEPTION

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class sinusouidal extends JFrame implements ActionListener, ChangeListener{
	
	//PROPERTIES
	//Variables
	
	
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
	
	//Sliders & Text Fields & Labels & Combo Boxes
	JSlider aslider = new JSlider(-10, 10, 0);
	JSlider kslider = new JSlider(-10, 10, 0);
	JSlider cslider = new JSlider(-10, 10, 0);
	JSlider dslider = new JSlider(-10, 10, 0);
	
	JTextField afield = new JTextField("1");
	JTextField kfield = new JTextField("1");
	JTextField cfield = new JTextField("0");
	JTextField dfield = new JTextField("0");
	
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
	
	String[] arr = {"sin", "cos", "tan"} ;
	
	JComboBox cb = new JComboBox(arr);
	
	
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
			smpanel.strcb = (String)cb.getSelectedItem();
			eqfunc = eqmethfunc(smpanel.strcb);
			smpanel.add(eqfunc);
			smpanel.repaint();
		}
	}
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
		cb.addActionListener(this);
		
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
	
	//Main Method
	public static void main(String args[]){
		new sinusouidal();
	}
	
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

}
	
