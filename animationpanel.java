import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class animationpanel extends JPanel{
	//Properties
	int intaboutx = 5000;
	int intabouty = 5000;
	int inthelpx = 5000;
	int inthelpy = 5000;
	BufferedImage imgabout;
	BufferedImage imghelp;
	
	//Methods
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//g.setColor(Color.WHITE);
		//g.fillRect(0,0,1400,800);
		g.drawImage(imgabout, intaboutx, intabouty, null);
		g.drawImage(imghelp, inthelpx, inthelpy, null);
	}
	
	//Constructor
	public animationpanel(){
		super();
		try{
			imgabout = ImageIO.read(new File("ABOUT.png"));
			imghelp = ImageIO.read(new File("HELP.png"));
		}catch(IOException e){
			System.out.println("Cannot load ABOUT.png");
		}
	}
}
