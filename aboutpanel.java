import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class aboutpanel extends JPanel{
	
	//Properties
	BufferedImage imgabout;
	
	//Methods
	//Set up panel graphics
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(imgabout, 0, 0, null);
	}
	
	
	//Constructor
	public aboutpanel (){
		//import about screen and account for IO exception
		try{
			imgabout = ImageIO.read(new File("ABOUT.png"));
		}catch(IOException e){
			System.out.println("Cannot open ABOUT.png");
		}
	}
}
