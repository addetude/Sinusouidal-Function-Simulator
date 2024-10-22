import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class helppanel extends JPanel{
	
	//Properties
	BufferedImage imghelp;

	//Methods
	//Set up panel graphics
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(imghelp, 0, 0, null);
	}

	//Constructor
	public helppanel(){
		//import help screen and account for IO exception
		try{
			imghelp = ImageIO.read(new File("HELP.png"));
		}catch(IOException e){
			System.out.println("Cannot load HELP.png");
		}
	}

}
