import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class sinusouidal implements ActionListener, KeyListener, MouseListener, MouseMotionListener{
	
	//Properties
	JFrame theframe = new JFrame("Sinusouidal Function Simulator");
	JPanel thepanel = new animationpanel();;
	
	
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
		thepanel.setPreferredSize(new Dimension(800,800));
		theframe.setContentPane(thepanel);
		theframe.pack();
		thepanel.setVisible(true);
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Main Method
	public static void main(String args[]){
		new sinusouidal();
	}
}
	
