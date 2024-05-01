import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class animationpanel extends JPanel{
	//Properties
	
	
	//Methods
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.GREEN);
		g.fillRect(0,0,800,800);
	}
	
	//Constructor
	public animationpanel(){
		super();
	}
}
