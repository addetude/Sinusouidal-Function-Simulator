import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class scorespanel extends JPanel{
	
	//Properties
	BufferedReader txtScores;
	String strLine = "a";
	String [][] array;
	int intnum = 0;
	int intCount;
	int intCounter;

	//Methods
	//Set up panel graphics
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(new Color(238,238,238));
		g.fillRect(0,0,960,540);
		g.setColor(Color.BLACK);
		
		//import scores from file and draw scores on panel
		try{
			txtScores = new BufferedReader(new FileReader("scores.txt"));
			
			intCounter = 0;
			while(strLine != null){
				strLine = txtScores.readLine();
				intCounter += 1;
			}
			
			intCounter = intCounter/2;
			array = new String [intCounter][2];
			txtScores.close();
		}catch(IOException e){
			System.out.println("could not load scores.txt");
		}
		
		try{
			txtScores = new BufferedReader(new FileReader("scores.txt"));
			for(intCount = 0; intCount < intCounter; intCount++){
				strLine = txtScores.readLine();
				array [intCount][0] = strLine;
				strLine = txtScores.readLine();
				array [intCount][1] = strLine;
				System.out.println(array [intCount][0]);
				System.out.println();
			}
			
			txtScores.close();
			array = BubbleSort(array);
		}catch(IOException e){
			System.out.println("IOException error");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayIndexOutOfBoundsException error");
		}
		
		for(intCount = 0; intCount <= intCounter; intCount++){
			g.drawString(array [intCount][0]+"", 25, (intCount+2)*25); 
			g.drawString(array [intCount][1]+"", 300, (intCount+2)*25); 
		}
	}	
	
	//bubble sorting method to organize scores from highest to lowest
	public String [][] BubbleSort(String [][] array){
		int intCount = 0;
		int intLength = array.length;
		System.out.println(intLength);
		String strTemp;
		
		for(intCount = 0; intCount < intLength; intCount++){
			for(intCounter = 0; intCounter < intLength-1; intCounter++){
				if(Integer.parseInt(array[intCounter][1]) < Integer.parseInt(array[intCounter+1][1])){
					strTemp = array[intCounter][1];
					array[intCounter][1] = array[intCounter+1][1];
					array[intCounter+1][1] = strTemp;
					
					strTemp = array[intCounter][0];
					array[intCounter][0] = array[intCounter+1][0];
					array[intCounter+1][0] = strTemp;
				}
			}
		}
		
		return array; 
	}

	//Constructor
	public scorespanel(){
	}
}
