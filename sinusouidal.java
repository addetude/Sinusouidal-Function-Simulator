import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class sinusouidal implements ActionListener, KeyListener, MouseListener, MouseMotionListener{
	
	//Properties
	JFrame theframe = new JFrame("Sinusouidal Function Simulator");
	animationpanel thepanel = new animationpanel();
	JMenuBar themenubar = new JMenuBar();
	JMenu aboutmenu = new JMenu("About");
	JMenu mainmenu = new JMenu("Main");
	JMenu helpmenu = new JMenu("Help");
	JMenuItem aboutmenuitem = new JMenuItem("About");
	JMenuItem mainmenuitem = new JMenuItem("Main");
	JMenuItem helpmenuitem = new JMenuItem("Help");
	JSlider theslider = new JSlider(0,500,0);
	
	
	
	//Methods
	public void mouseExited(MouseEvent evt){
		
	}
	public void mouseEntered(MouseEvent evt){
		
	}
	public void mouseReleased(MouseEvent evt){
		
	}
	public void mousePressed(MouseEvent evt){
		
	}
	public void mouseClicked(MouseEvent evt){
		
	}
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == aboutmenuitem){
			System.out.println("pressed");
			thepanel.intBlockX = 200;
			thepanel.intBlockY = 200;
			thepanel.repaint();
			
		}else if(evt.getSource() == helpmenu){
			
		}else if(evt.getSource() == mainmenu){
			
		}
	}
	public void keyReleased(KeyEvent evt){
	
	}
	public void keyPressed(KeyEvent evt){
		
	}
	public void keyTyped(KeyEvent evt){
		
	}
	public void mouseMoved(MouseEvent evt){
		
	}
	public void mouseDragged(MouseEvent evt){
		
	}
	
	//Constructor
	public sinusouidal(){
		thepanel.setPreferredSize(new Dimension(1400,800));
		theframe.setContentPane(thepanel);
		theframe.setResizable(false);
		
		theslider.setLocation(100,100);
		theslider.setSize(100,100);
		thepanel.add(theslider);
		
		mainmenu.add(mainmenuitem);
		aboutmenu.add(aboutmenuitem);
		helpmenu.add(helpmenuitem);
		
		themenubar.add(mainmenu);
		themenubar.add(aboutmenu);
		themenubar.add(helpmenu);
		
		aboutmenu.addActionListener(this);
		mainmenu.addActionListener(this);
		helpmenu.addActionListener(this);
		aboutmenuitem.addActionListener(this);
		mainmenuitem.addActionListener(this);
		helpmenuitem.addActionListener(this);
		theframe.setJMenuBar(themenubar);
	
		
		theframe.pack();
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setVisible(true);
		
		//mainmenu.addActionListener(this);	
	}
	
	//Main Method
	public static void main(String args[]){
		new sinusouidal();
	}
}
	
