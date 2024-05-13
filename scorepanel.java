import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class scorepanel extends JPanel{
	
	//Properties
	

	//Methods
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(new Color(238,238,238));
		g.fillRect(0,0,960,540);	
	}

	//Constructor
	public scorepanel(){
	}

}
