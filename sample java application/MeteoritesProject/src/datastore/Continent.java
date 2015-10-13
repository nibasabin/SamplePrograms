/*******************************************************************************
 * Class : Continent			
 * Date : December 5, 2013
 * Description :- This class checks in which continent does the meteorite falls.
 * 				- This class creates boolean array for seven continents to create a map of continents. 
 * 
 * */

package datastore;
//import WorldMapComponent;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;



public class Continent {

	WorldMap Map= new WorldMap();
	String CArrayName[]= new String[7];
	String Name[]=new String [7];
	BufferedImage Images[]= new BufferedImage[7];
	public boolean result[]=new boolean[7];
	/*******************************************************************************
	 * Constructor :Continent			 
	 * */
	
	public Continent()
	{/*
		CArrayName[0]="C:\\Users\\nibasabin\\Desktop\\Phase3\\a\\Africa.png";
		CArrayName[1]="C:\\Users\\nibasabin\\Desktop\\Phase3\\a\\Antarctica.png";
		CArrayName[2]="C:\\Users\\nibasabin\\Desktop\\Phase3\\a\\Asia.png";
		CArrayName[3]="C:\\Users\\nibasabin\\Desktop\\Phase3\\a\\Austrailia.png";
		CArrayName[4]="C:\\Users\\nibasabin\\Desktop\\Phase3\\a\\Europe.png";
		CArrayName[5]="C:\\Users\\nibasabin\\Desktop\\Phase3\\a\\NorthAmerica.png";
		CArrayName[6]="C:\\Users\\nibasabin\\Desktop\\Phase3\\a\\SouthAmerica.png";
		*/
		CArrayName[0]="C:\\Users\\nibasabin\\Desktop\\Phase3\\Africa.png";
		CArrayName[1]="C:\\Users\\nibasabin\\Desktop\\Phase3\\Antarctica.png";
		CArrayName[2]="C:\\Users\\nibasabin\\Desktop\\Phase3\\Asia.png";
		CArrayName[3]="C:\\Users\\nibasabin\\Desktop\\Phase3\\Austrailia.png";
		CArrayName[4]="C:\\Users\\nibasabin\\Desktop\\Phase3\\Europe.png";
		CArrayName[5]="C:\\Users\\nibasabin\\Desktop\\Phase3\\NorthAmerica.png";
		CArrayName[6]="C:\\Users\\nibasabin\\Desktop\\Phase3\\SouthAmerica.png";
	
		Name[0]="Africa";
		Name[1]="Antarctica";
		Name[2]="Asia";
		Name[3]="Australia";
		Name[4]="Europe";
		Name[5]="NorthAmerica";
		Name[6]="SouthAmerica";
	}
		
	

	/*****************************************
	 * Function: Continents
	 * Parameters: filename
	 * Description: converts the .png file into buffered image
	 * Inputs: N/A
	 * Outputs: true/false
	 *******************************************/	
	
	
	
	public BufferedImage Continents(String filename)
	{
		BufferedImage fileImage = null;
		
			File file = new File(filename);
			try
			{
				
				fileImage=ImageIO.read(file);
				
				
			
				
			}
			catch(Exception e)
			{
				System.out.println(filename);
				e.printStackTrace();
			}
			
			return fileImage;
	}
	

		

	/*****************************************
	 * Function: isAfrica
	 * Parameters: position
	 * Description: check whether a position is 
	 * located in africa
	 * Inputs: N/A
	 * Outputs: true/false
	 *******************************************/
	
	public float isContinent(int x, int y)
	{
		/*
		BufferedImage asia = Continents("C:\\Users\\nibasabin\\Desktop\\Phase3\\a\\Asia.png");
		BufferedImage africa = Continents("C:\\Users\\nibasabin\\Desktop\\Phase3\\a\\Africa.png");
		BufferedImage europe = Continents("C:\\Users\\nibasabin\\Desktop\\Phase3\\a\\Europe.png");
		BufferedImage nAmerica = Continents("C:\\Users\\nibasabin\\Desktop\\Phase3\\a\\NorthAmerica.png");
		BufferedImage sAmerica = Continents("C:\\Users\\nibasabin\\Desktop\\Phase3\\a\\SouthAmerica.png");
		BufferedImage australia = Continents("C:\\Users\\nibasabin\\Desktop\\Phase3\\a\\Austrailia.png");
		BufferedImage antarctica = Continents("C:\\Users\\nibasabin\\Desktop\\Phase3\\a\\Antarctica.png");
	*/
		BufferedImage asia = Continents("C:\\Users\\nibasabin\\Desktop\\Phase3\\Asia.png");
		BufferedImage africa = Continents("C:\\Users\\nibasabin\\Desktop\\Phase3\\Africa.png");
		BufferedImage europe = Continents("C:\\Users\\nibasabin\\Desktop\\Phase3\\Europe.png");
		BufferedImage nAmerica = Continents("C:\\Users\\nibasabin\\Desktop\\Phase3\\NorthAmerica.png");
		BufferedImage sAmerica = Continents("C:\\Users\\nibasabin\\Desktop\\Phase3\\SouthAmerica.png");
		BufferedImage australia = Continents("C:\\Users\\nibasabin\\Desktop\\Phase3\\Austrailia.png");
		BufferedImage antarctica = Continents("C:\\Users\\nibasabin\\Desktop\\Phase3\\Antarctica.png");
		
		Raster rAsia=asia.getData();	
		Raster rAfrica= africa.getData();
		Raster rEurope= europe.getData();
		Raster rNamerica= nAmerica.getData();
		Raster rSamerica= sAmerica.getData();
		Raster raustralia= australia.getData();
		Raster rantarctica= antarctica.getData();
	
	    int sampleAsia= rAsia.getSample(x,y,1);
	    int sampleAfrica= rAfrica.getSample(x,y,1);
	    int sampleEurope= rEurope.getSample(x,y,1);
	    int sampleNamerica= rNamerica.getSample(x,y,1);
	    int sampleSamerica= rSamerica.getSample(x,y,1);
	    int sampleAustralia= raustralia.getSample(x,y,1);
	    int sampleAntarctica= rantarctica.getSample(x,y,1);
	    
	    System.out.println(" Asia "+sampleAsia);
	    System.out.println(" Africa "+ sampleAfrica);
	    System.out.println( " Europ "+ sampleEurope);
	    System.out.println( " Namerica "+ sampleNamerica);
	    System.out.println(" Samerica "+ sampleSamerica);
	    System.out.println(" Australia "+ sampleAustralia);
	    System.out.println(" Antarctica " +sampleAntarctica);
	    
	   

		if (sampleAfrica== 255)
			return 150;
		else if(sampleAntarctica== 255)
			return 1000;
		else if(sampleAsia== 255)
			return 200;
		else if(sampleAustralia== 255)
			return 500;
		else if(sampleEurope== 255)
			return 100;
		else if(sampleNamerica== 255)
			return 150;
		else if(sampleSamerica== 255)
			return 200;
		else 
			return 0;
		
	
		
	}

	
	
	public static void main(String args[])	{
		Continent object= new Continent();
	object.isContinent((int)396,(int)80);
	}
	
}

	



