import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class simpanel extends JPanel{
	
	//Properties
	BufferedImage imgsin;
	
	//Methods
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(new Color(238,238,238));
		g.fillRect(0,0,960,540);
		g.drawImage(imgsin, 35, 30, null);
	}
	
	//Constructor
	public simpanel (){
		super();
		try{
			imgsin = ImageIO.read(new File("SIN.png"));
		}catch(IOException e){
			System.out.println("cannot load SIN.png");
		}
	}
}
