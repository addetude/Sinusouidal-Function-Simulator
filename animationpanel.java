import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class animationpanel extends JPanel{
	//Properties
	int intBlockX = 5000;
	int intBlockY = 5000;
	
	//Methods
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(new Color(245,245,245));
		g.fillRect(0,0,1400,800);
		g.setColor(Color.RED);
		g.fillRect(intBlockX, intBlockY, 200, 200);
	}
	
	//Constructor
	public animationpanel(){
		super();
	}
}
