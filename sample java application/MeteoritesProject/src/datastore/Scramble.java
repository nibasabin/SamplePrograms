/*******************************************************************************
 * Class : Scramble
 * Date : December 5, 2013
 * Description :- This class scrambles the location of meteorite, buyer, and seller and 
 * 				- assigns new position for meteorite, buyer and seller.
 * */

package datastore;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import buyer.BuyerInfo;
import seller.SellerInfo;
/*******************************************************************************
 * Method : Scramble
 * Parameters : Object of WorldMap Class, BuyerInfo Class and SellerInfo Class
 * Description :- This class scrambles the location of meteorite, buyer, and seller and 
 * 				- assigns new position for meteorite, buyer and seller.
 * Input : N/A
 * Output : N/A
 * */


public class Scramble {
  	int sampleAsia;
    int sampleAfrica;
    int sampleEurope;
    int sampleNamerica;
    int sampleSamerica;
    int sampleAustralia;
    int sampleAntarctica;
    Continent myContinent=new Continent();
    
	public BufferedImage Continents(String filename)
	{
		BufferedImage fileImage = null;
		
			File file = new File(filename);
			//System.out.println("adfafas");
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
	
	
	
public void random(WorldMap myMap,BuyerInfo myBuyer,SellerInfo mySeller)
{ /*
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
//	System.out.println(" longitude in is continent "+x);
	//System.out.println(" latitude in is contitnent "+y);
  
    
   
	boolean question=true;
	while (question==true)
	{
		int conformation=JOptionPane.showConfirmDialog(null,
				"Do You Want To Scramble", "Message", JOptionPane.YES_NO_OPTION);
		if (conformation==JOptionPane.YES_OPTION )
		{
				Random r = new Random();
				
						
						
			for(int i=0;i<myMap.Array.size();i++)
			{	
				boolean condition=false;
				int check;
				while (condition!=true)
				{
					
					float minLat = -90;
					float  maxLat = 90;      
					int latitude = myMap.latitude((int)(minLat + (float)(Math.random() * ((maxLat - minLat) + 1))));
					float minLon = -180;
					float maxLon = 180;     
					int longitude = myMap.longitude((int)(minLon + (float)(Math.random() * ((maxLon - minLon) + 1))));
					
					
					 sampleAsia= rAsia.getSample(longitude,latitude,1);
				     sampleAfrica= rAfrica.getSample(longitude,latitude,1);
				     sampleEurope= rEurope.getSample(longitude,latitude,1);
				     sampleNamerica= rNamerica.getSample(longitude,latitude,1);
				     sampleSamerica= rSamerica.getSample(longitude,latitude,1);
				     sampleAustralia= raustralia.getSample(longitude,latitude,1);
				     sampleAntarctica= rantarctica.getSample(longitude,latitude,1);
				    
				    System.out.println(" Asia "+sampleAsia);
				    System.out.println(" Africa "+ sampleAfrica);
				    System.out.println( " Europ "+ sampleEurope);
				    System.out.println( " Namerica "+ sampleNamerica);
				    System.out.println(" Samerica "+ sampleSamerica);
				    System.out.println(" Australia "+ sampleAustralia);
				    System.out.println(" Antarctica " +sampleAntarctica);
				
				//	myMap.Array.get(i).setLatitude(myMap.latitude(latitude));
				//	myMap.Array.get(i).setLongitude(myMap.longitude(longitude));
					
					//check= (int)myContinent.isContinent(myMap.longitude(longitude), myMap.latitude(latitude));
					//System.out.println(" Check is checking "+check);
					
					
					
					if((sampleAsia==255) || (sampleEurope==255 ))
						
					{
						myMap.Array.get(i).setLatitude(latitude);
						myMap.Array.get(i).setLongitude(longitude);
						System.out.println(" longi"+ myMap.Array.get(i).getLongitude());
						System.out.println(" lati"+ myMap.Array.get(i).getLatitude());
						condition=true;
					}
					else if ((sampleAfrica==255) || (sampleNamerica==255) )
					{
						myMap.Array.get(i).setLatitude(latitude);
						myMap.Array.get(i).setLongitude(longitude);
						System.out.println(" longi"+ myMap.Array.get(i).getLongitude());
						System.out.println(" lati"+ myMap.Array.get(i).getLatitude());
						condition=true;
					}
					else if ((sampleSamerica==255) || (sampleAustralia==255) )
					{
						myMap.Array.get(i).setLatitude(latitude);
						myMap.Array.get(i).setLongitude(longitude);
						System.out.println(" longi"+ myMap.Array.get(i).getLongitude());
						System.out.println(" lati"+ myMap.Array.get(i).getLatitude());
						condition=true;
					}
					else if ( (sampleAntarctica==255))
					{
						myMap.Array.get(i).setLatitude(latitude);
						myMap.Array.get(i).setLongitude(longitude);
						System.out.println(" longi"+ myMap.Array.get(i).getLongitude());
						System.out.println(" lati"+ myMap.Array.get(i).getLatitude());
						condition=true;
					}
					else 
					{
						continue;
					}
				}
			
			}
			question=false;
			}
		}
		//	catch(Exception e)
		//	{
		
		//	}
			
			//}
	System.out.println("************************");
	System.out.println("* Scramble Successfull *");
	System.out.println("************************");

}
}


