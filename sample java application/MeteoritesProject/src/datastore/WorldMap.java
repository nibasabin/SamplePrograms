/**********************************************************************************************************************
 * Class : WorldMap
 * Date : December 5, 2013
 * Description : - This class contain method that reads a text file (MMarket.txt) and creates world map
 * 				 - It contains method that prints world map
 * 				 - It contains method that prints world map with meteorite.
 * 				 - It contains method that converts longitude and latitude.
 * Integer ArrayList MapList : Stores the values that determines land and water from the MMarket.txt file
 * Meteorite ArrayList Array : Stores meteorite object
 * integer Array1[][]: Creates 20 by 60 grid line for the world map with land and water value
 * */
package datastore;
//import MeteorImageMap;



import java.util.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import seller.SellerInfo;
import buyer.BuyerInfo;
public class WorldMap extends Component{
	
	ArrayList <Integer> MapList= new ArrayList<Integer>();
	public ArrayList<Meteorite> Array= new ArrayList<Meteorite>();
	int Array1[][]= new int[20][60];
	BufferedImage img;
/******************************************************************************************
 * Method: worldMap
 * Description:	This function reads the MMarket.txt file.
 * 				Creates 20 by 60 array and stores the value that determines the land and water
 * integer  Array[20][60] : To create 20,60 grid for the map
 * input : N/A
 * output : N/A
 */	
	public void sampleMap()
	{
		 
		
		 	WorldMap mim =new WorldMap();
		 	 
		 	
		     JFrame f = new JFrame("World Map");
		     
		     f.addWindowListener(new WindowAdapter(){
		             public void windowClosing(WindowEvent e) {
		                 System.exit(0);
		             }
		         });

		     f.add(mim);
		     f.pack();
		     f.setVisible(true);
	}

			    public void paint(Graphics g) {
			        g.drawImage(img, 0, 0, 800,400,null);
			    }
			 
			    public  WorldMap() {
			       try {
			           img = ImageIO.read(new File("C:\\Users\\nibasabin\\Desktop\\Phase3\\WorldMap.png"));
			       } catch (IOException e) {
			       }
			 
			    }
			 
			    public Dimension getPreferredSize() {
			        if (img == null) {
			             return new Dimension(100,100);
			        } else {
			           return new Dimension(800, 400);
			       }
			    
			 
	}
	
	public void worldMap()
	{
		boolean flag= true;
	
		while (flag!=false)
		{
		
		
		JFrame parent= new JFrame();
		JFileChooser chooser = new JFileChooser("C:\\Users\\nibasabin\\Desktop");
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
			    " Text File Only", "txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(parent);
		try {
		if(returnVal == JFileChooser.APPROVE_OPTION)
		{
	
		File path= chooser.getSelectedFile();
		File myFile=new File(path.getAbsolutePath());
		int conformation=JOptionPane.showConfirmDialog(null,
				"Do You Want To Load Meteorite", "Load Meteorite", JOptionPane.YES_NO_OPTION);
		if (conformation==JOptionPane.YES_OPTION )
		{
		
		try{
			Scanner myScanner= new Scanner(myFile);
			String text=new String();
			while (myScanner.hasNextLine())
			{ 
				text=myScanner.next();
				String token= new String();
				StringTokenizer mytoken=new StringTokenizer(text,",");
				token=mytoken.nextToken();
				token=mytoken.nextToken();
				token=mytoken.nextToken();
				MapList.add(Integer.parseInt(token));
			}
		}
		catch(Exception e)
		{
		}
		
		int index=0;
		for(int i=0;i<20;i++)
		{
			for (int j=0;j<60;j++)
			{
				Array1[i][j]=MapList.get(index);
				index++;
			}
		}
		JOptionPane.showMessageDialog(null," World Map Successfully Loaded", " Message ", JOptionPane.PLAIN_MESSAGE);
	}
		else
		{
			JOptionPane.showMessageDialog(null," You Cancelled To Load World Map", " Message ", JOptionPane.PLAIN_MESSAGE);
			System.out.println();
		}
		
		}
		
		
		flag=false;
	}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null," Wrong File Type","Error",JOptionPane.ERROR_MESSAGE);
			
			continue;
			
		}
		}
	}
	
/*******************************************************************************************************************
 * Method : printMap
 * Description: Prints the map of the world 
 * Input : N/A
 * Output : World Map
 */
	public void printMap()
	{	
		System.out.println("                  **************************");
		System.out.println("                  *  U.T.A METEROITE SHOP  *");
		System.out.println("                  **************************");
		System.out.print("\n\n");
		for(int i=0;i<20;i++)
		{
			System.out.println();
			for (int j=0;j<60;j++)
			{
				if(Array1[i][j]==1)
				{
					if (i==10)
						System.out.print("-");
					else if (j==30)
						System.out.print("|");
					else
						System.out.print("*");
				}
					
				else 
					if (i==10)
						System.out.print("-");
					else if (j==30)
						System.out.print("|");
					else
				
					System.out.print(".");
			}
		}
		System.out.println();
		System.out.println();

	}

	/*******************************************************************************************************************
	 * Method : meteoriteMap
	 * Parameter : Meteorite object
	 * Description: Checks if the meteorite is available or not and prints the meteorite on world map
	 * Input : N/A
	 * Output : World Map
	 */
public void meteoriteMap(Meteorite myMeteorite,SellerInfo mySeller,BuyerInfo myBuyer)
{ 
	if(Array.size()!=0)
	{
	System.out.println("                  **************************");
	System.out.println("                  *  U.T.A METEROITE SHOP  *");
	System.out.println("                  **************************");											
		for( int i=0;i<Array.size();i++)
		{
			if (Array.get(i).getStatus() == true)
			{
				Array1[latitude(Array.get(i).getLatitude())][longitude(Array.get(i).getLongitude())] = 2;
			
			}
			else
			{
				Array1[latitude(Array.get(i).getLatitude())][longitude(Array.get(i).getLongitude())] = 3;
			}		
			
		for (int j=0; j<mySeller.SellerArray.size();j++)
		{
			
			if (mySeller.SellerArray.get(j).getStatus()==true)
			{
				Array1[latitude(mySeller.SellerArray.get(j).getLatitude())][longitude(mySeller.SellerArray.get(j).getLongitude())]=4;
			}
		}
		
		for (int k=0; k<myBuyer.BuyerArray.size();k++)
		{
			
			if (myBuyer.BuyerArray.get(k).getStatus()==true)
			{
				Array1[latitude(myBuyer.BuyerArray.get(k).getLatitude())][longitude(myBuyer.BuyerArray.get(k).getLongitude())]=5;
			}
		}
		
		
			
			
			
		}
		for(int i=0;i<20;i++)
		{
			System.out.println();
			for (int j=0;j<60;j++)
			{
				if(Array1[i][j]==1)
				{
					if (i==10)
						System.out.print("-");
					else if (j==30)
						System.out.print("|");
					else
						System.out.print("*");
				}
					
				else if (Array1[i][j]==0)
				{
					if (i==10)
						System.out.print("-");
					else if (j==30)
						System.out.print("|");
					else
				
					System.out.print(".");
				}
				else if (Array1[i][j]==2)
				{
					
					System.out.print("X");
				}
				else if (Array1[i][j]==3)
				{
					System.out.print("$");
				}
				else if (Array1[i][j]==4)
				{
					System.out.print("S");
				}
				else 
				{
					System.out.print("B");
				}
			}
		}
		System.out.println();
		System.out.println();
	}
	else
	{
		System.err.println("                World Map Empty ");
		System.err.println("Please Load The File Or Create A Meteorite First ");
		System.err.println("--------------------------------------------------");
	}
}
/*******************************************************************************************************************
 * Function: longitude
 * Parameter : float x
 * Description: converts longitude into column
 * float x : longitude of an object
 * Input : longitude
 * Output : column
 * Return Type : integer
 */
		
		public int longitude(float x)				
		{
			float column;
		
			column=(float) ((x*(799/360.0))+(400));
			int lo=(Math.round(column));
			
			if (lo>799)
				return lo-1;
			else 
				return lo;
		}
		
/*******************************************************************************************************************
 * Function: latitude
 * Parameter : float y
 * Description: converts latitude into row
 * float x : latitude of an object
 * Input : latitude
 * Output : row
 * return type : integer
 */
		public int latitude(float y)			
		{
		float row;
		row=(float)((y*(-399/180.0)+(200)));
		int la=(Math.round(row));
		if(la>399)
			return la-1;
		else 
		return la;
		
		}



		
}


