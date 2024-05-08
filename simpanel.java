import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.lang.Math.*;

public class simpanel extends JPanel{
	
	//Properties
	BufferedImage imgsin;
	BufferedImage imggraph;
	BufferedImage imgsin2;
	
	int intCount;
	
	int inta = 1;
	int intk = 1;
	int intc = 0;
	int intd = 0;
	
	String strcb = "sin";
	
	//Methods
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(new Color(238,238,238));
		g.fillRect(0,0,960,540);
		g.drawImage(imgsin, 35, 20, null);
		g.drawImage(imggraph, 325, 15, null);
		g.setColor(Color.BLACK);
		g.drawRect(325, 15, 450, 450);
		g.setColor(Color.BLACK);
		g.drawImage(imgsin2, 795, 180, null);
		g.setColor(new Color(40, 150, 20));
		for(intCount = -188; intCount < 260; intCount++){
			if(strcb == "sin"){
				int inty = (int)(((inta*-10)*Math.sin((intk*0.01)*(intCount*1.0000000001)+intc*25)-intd*50/10)+250);
				if(inty >= 15 && inty <= 465){
					g.drawString("-", intCount+513, inty+3);
				}
			}else if(strcb == "cos"){
				int inty = (int)(((inta*-10)*Math.cos((intk*0.01)*(intCount*1.0000000001)+intc*25)-intd*50/10)+250);
				if(inty >= 15 && inty <= 465){
					g.drawString("-", intCount+513, inty+3);
				}
			}else if(strcb == "tan"){
				int inty = (int)(((inta*-10)*Math.tan((intk*0.01)*(intCount*1.0000000001)+intc*25)-intd*50/10)+250);
				if(inty >= 15 && inty <= 465){
					g.drawString("-", intCount+513, inty+3);
				}
			}
		}
	}
	
	//Constructor
	public simpanel (){
		super();
		try{
			imgsin = ImageIO.read(new File("SIN.png"));
			imggraph = ImageIO.read(new File("2.png"));
			imgsin2 = ImageIO.read(new File("new.png"));
		}catch(IOException e){
			System.out.println("cannot load SIN.png");
		}
	}
}
