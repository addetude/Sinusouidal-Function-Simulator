import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class quizpanel extends JPanel{
	//Properties
	BufferedImage imgart;
	Font font = new Font("SansSerif", Font.PLAIN, 30);
	int intPoints = 0;
	boolean check = false;

	//Methods
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(new Color(238,238,238));
		g.fillRect(0,0,960,540);
		g.drawImage(imgart, 500, 40, null);
		if(check == true){
			g.setColor(new Color(40, 150, 20));
			g.setFont(font);
			g.drawString(intPoints+"/3", 400, 415);
		}
	}
	
	//Constructor
	public quizpanel(){
		try{
			imgart = ImageIO.read(new File("sineart.png"));
		}catch(IOException e){
			System.out.println("Cannot load sineart.png");
		}
		
	}
}

