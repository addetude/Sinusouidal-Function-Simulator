import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class homepanel extends JPanel{
	
	//Properties
	BufferedImage imghome;
	
	//Methods
	//Set up panel graphics
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(imghome, 0, 0, null);
	}
	
	//Constructor
	public homepanel (){
		//import home screen and account for IO exception
		try{
			imghome = ImageIO.read(new File("HELP.png"));
		}catch(IOException e){
			System.out.println("Cannot open HELP.png");
		}
	}
}

