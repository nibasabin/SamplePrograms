/**********************************************************************************************************************
 * Class : SaveData
 * Date : December 5, 2013
 * Description : - This class contain method that writes the created meteorites on text file.
 * 				 - It contains method that writes the sellers information on text file
 * 				 - It contains method that writes the buyer information on text file
 * 				 - It contains method that reads the created meteorites from text file
 * 				 - It contains method that reads the created seller from text file
 * 				 - It contains method that reads the created buyer from text file
 * */

package datastore;

import java.io.File;
//import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import buyer.BuyerInfo;
import seller.SellerInfo;

	public class SaveData {
WorldMap myMap= new WorldMap();
	/******************************************************************************************
	 * Method: saveMap
	 * Description:	This function writes the created meteorite on Meteorite.txt file.
	 * Input : N/A
	 * Output : N/A
	 */	

	public void saveMap(WorldMap Map)
	{
	
		boolean flag= true;
		while (flag!=false)
		{
			JFrame parent= new JFrame();
			JFileChooser chooser = new JFileChooser("C:\\Users\\nibasabin\\Desktop");
			int returnVal = chooser.showSaveDialog(parent);
			try 
			{
				if(returnVal == JFileChooser.APPROVE_OPTION)
				{
	
					File path= chooser.getSelectedFile();
					String filePath = path.getPath();
					if(!filePath.toLowerCase().endsWith(".txt"))
					{
						path = new File(filePath + ".txt");
					}
					
					File myFile=new File(path.getAbsolutePath());	
					int conformation=JOptionPane.showConfirmDialog(null,
							"Do You Want To Save Meteorite", "Save Meteorite", JOptionPane.YES_NO_OPTION);
					if (conformation==JOptionPane.YES_OPTION )
					{
						try
						{
							Formatter myFormat= new Formatter(myFile);
							String mytext;
							int i=0;
							while(i!=Map.Array.size())
							{
								mytext=Integer.toString(Map.Array.get(i).getId());
								
								myFormat.format(mytext);
								myFormat.format(",");
								mytext=Map.Array.get(i).getType();
								myFormat.format(mytext);
								myFormat.format(",");
								mytext=Float.toString(Map.Array.get(i).getLongitude());
								myFormat.format(mytext);
								myFormat.format(",");
								mytext=Float.toString(Map.Array.get(i).getLatitude());
								myFormat.format(mytext);
								myFormat.format(",");
								mytext=Float.toString(Map.Array.get(i).getPrice());
								myFormat.format(mytext);
								myFormat.format(",");
								mytext=Boolean.toString(Map.Array.get(i).getStatus());
								myFormat.format(mytext);
								myFormat.format("%n");
						
								i++;
							}

							myFormat.close();								
	
						}
						
						catch(Exception e)
						{
							e.printStackTrace();
			
						}
					}
					
					else
					{
						System.out.println();
					}
			}
		flag=false;
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null," Wrong File ","Error",JOptionPane.ERROR_MESSAGE);
			continue;
		}
			
		}
		}
			
	
	/******************************************************************************************
	 * Method: saveSeller
	 * Parameter : SellerInfo object
	 * Description: This method writes the created seller on Seller.txt file
	 * input : N/A
	 * output : N/A
	 */		
public void saveSeller(SellerInfo mySeller)
	{
	boolean flag= true;
	
	while (flag!=false)
	{
	
	JFrame parent= new JFrame();
	JFileChooser chooser = new JFileChooser("C:\\Users\\nibasabin\\Desktop");
	int returnVal = chooser.showSaveDialog(parent);
	try {
	if(returnVal == JFileChooser.APPROVE_OPTION)
	{

	File path= chooser.getSelectedFile();
	int conformation=JOptionPane.showConfirmDialog(null,
			"Do You Want To Save Seller", "Save Seller", JOptionPane.YES_NO_OPTION);
	if (conformation==JOptionPane.YES_OPTION )
	{
	
	
	
	String filePath = path.getPath();
	if(!filePath.toLowerCase().endsWith(".txt"))
	{
	    path = new File(filePath + ".txt");
	}
	
	
	File myFile=new File(path.getAbsolutePath());	
		//File myfile=new File("C:\\Users\\nibasabin\\Desktop\\Seller.txt");	
		try
		{
			Formatter myFormat= new Formatter(myFile);
			String mytext;
			int i=0;
			//System.out.println("afdfafadfafafafd");
			//System.out.println("array size"+mySeller.SellerArray.size());
			while(i!=mySeller.SellerArray.size())
			{
				mytext=mySeller.SellerArray.get(i).getNames();
				System.out.println("this is it "+mytext);
				myFormat.format(mytext);
				myFormat.format(",");
				mytext=Float.toString(mySeller.SellerArray.get(i).getLongitude());
				myFormat.format(mytext);
				myFormat.format(",");
				mytext=Float.toString(mySeller.SellerArray.get(i).getLatitude());
				myFormat.format(mytext);
				myFormat.format("%n");
		
				i++;
			}
	
			myFormat.close();								
		
		}
		catch(Exception e)
		{
			
			
		}
		JOptionPane.showMessageDialog(null," Seller Saved Successfully ", " Message ", JOptionPane.PLAIN_MESSAGE);
	}
	else 
	{
		JOptionPane.showMessageDialog(null," You Cancelled To Save Seller", " Message ", JOptionPane.PLAIN_MESSAGE);
		System.out.println();
	}
		//System.out.println("************************************");
		}
				flag=false;
				}
					catch (Exception e)
					{
						e.printStackTrace();
						JOptionPane.showMessageDialog(null," Wrong File ","Error",JOptionPane.ERROR_MESSAGE);
						
						continue;
						
					}
					}
				
	
	}
/******************************************************************************************
 * Method: saveBuyer
 * Parameter: BuyerInfo object
 * Description:	This method writes created buyer in a buyer.txt file
 * input : N/A
 * output : N/A
 */	
	public void saveBuyer(BuyerInfo myBuyer)
	{
		File myfile=new File("C:\\Users\\nibasabin\\Desktop\\Buyer.txt");	
		try
		{
			Formatter myFormat= new Formatter(myfile);
			String mytext;
			int i=0;
			while(i!=myBuyer.BuyerArray.size())
			{
				mytext=myBuyer.BuyerArray.get(i).getName();
				myFormat.format(mytext);
				myFormat.format(",");
				mytext=Float.toString(myBuyer.BuyerArray.get(i).getLongitude());
				myFormat.format(mytext);
				myFormat.format(",");
				mytext=Float.toString(myBuyer.BuyerArray.get(i).getLatitude());
				myFormat.format(mytext);
				myFormat.format("%n");
		
				i++;
			}
	
			myFormat.close();								
		
		}
		catch(Exception e)
		{
			
			
		}
		System.out.println("*****************************************");
		System.out.println("* Buyer Information Successfully Saved *");
		System.out.println("*****************************************");
	}

	/******************************************************************************************
	 * Method: LoadMap
	 * Parameter : WorldMap object
	 * Description:	This method reads the MMarket.txt file and stores all the meteorite object in an array.
	 * Input : N/A
	 * Output : N/A
	 */	
	public void loadMap(WorldMap Map)
	{		//SellerInfo mySeller=new SellerInfo();
			String Token3;
			String Token4;
			String Token5;
			String Token6;
			String Token7;
			String Token8;
			String Token9;
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
			Scanner myScanner=new Scanner(myFile);			
			String text=new String();												
			while (myScanner.hasNextLine())

			{
				
				//SellerInfo newSeller=new SellerInfo();
				text=myScanner.next();
				StringTokenizer mytoken=new StringTokenizer (text,",");		
				Token3=mytoken.nextToken();
				Token4=mytoken.nextToken();
				//System.out.println(" Token 4 "+Token4);
				//System.out.println(" token 3 "+ Token3);
				//System.out.println(" token 4 " +Token4);
				//Token5=mytoken.nextToken();
				Token6=mytoken.nextToken();
				Token7=mytoken.nextToken();
				Token8=mytoken.nextToken();
				Token9=mytoken.nextToken();
				
				if(Token4.equals("Chondrite"))
				{	
					//System.out.println(" this is the true shit");
						Chondrite myChondrite= new Chondrite();	
						myChondrite.setType(Token4);
						myChondrite.setId(Integer.parseInt(Token3));
						myChondrite.setLongitude(Float.parseFloat(Token6));
						myChondrite.setLatitude(Float.parseFloat(Token7));
						myChondrite.setPrice(Float.parseFloat(Token8));
						myChondrite.setStatus(Boolean.parseBoolean(Token9));
						Map.Array.add(myChondrite);
						continue;
					}
				else if (Token4.equals("Achondrite"))
					{	
						Achondrite myAchondrite= new Achondrite();
						myAchondrite.setType(Token4);
						myAchondrite.setId(Integer.parseInt(Token3));
						myAchondrite.setLongitude(Float.parseFloat(Token6));
						myAchondrite.setLatitude(Float.parseFloat(Token7));
						myAchondrite.setPrice(Float.parseFloat(Token8));
						myAchondrite.setStatus(Boolean.parseBoolean(Token9));
						Map.Array.add(myAchondrite);
						continue;
					
						
					}
				else if(Token4.equals("Lunar-Achondrite"))
					{
						Lunar myLunar=new Lunar();
						
						myLunar.setId(Integer.parseInt(Token3));
						myLunar.setType(Token4);
						myLunar.setLongitude(Float.parseFloat(Token6));
						myLunar.setLatitude(Float.parseFloat(Token7));
						myLunar.setPrice(Float.parseFloat(Token8));
						myLunar.setStatus(Boolean.parseBoolean(Token9));
						Map.Array.add(myLunar);
						continue;
					
					
					
					}
				else if(Token4.equals("Martian-Achondrite"))
					{	
						Martian myMartian=new Martian();
				
						myMartian.setId(Integer.parseInt(Token3));
						myMartian.setType(Token4);
						myMartian.setLongitude(Float.parseFloat(Token6));
						myMartian.setLatitude(Float.parseFloat(Token7));
						myMartian.setPrice(Float.parseFloat(Token8));
						myMartian.setStatus(Boolean.parseBoolean(Token9));
						Map.Array.add(myMartian);
						continue;
					
					
				}
				else if(Token4.equals("Asteroidal-Achondrite"))
					{	
						
						Asteroidal myAsteroidal= new Asteroidal();
					
						myAsteroidal.setId(Integer.parseInt(Token3));
						myAsteroidal.setType(Token4);
						myAsteroidal.setLongitude(Float.parseFloat(Token6));
						myAsteroidal.setLatitude(Float.parseFloat(Token7));
						myAsteroidal.setPrice(Float.parseFloat(Token8));
						myAsteroidal.setStatus(Boolean.parseBoolean(Token9));
						Map.Array.add(myAsteroidal);
						continue;
					
					
					}
				else if(Token4.equals("Iron"))
					{
						Iron myIron= new Iron();
					
						myIron.setId(Integer.parseInt(Token3));
						myIron.setType(Token4);
						myIron.setLongitude(Float.parseFloat(Token6));
						myIron.setLatitude(Float.parseFloat(Token7));
						myIron.setPrice(Float.parseFloat(Token8));
						myIron.setStatus(Boolean.parseBoolean(Token9));
						Map.Array.add(myIron);
						continue;
				
					
					
					}
				else if(Token4.equals("Stony"))
					{
						Stony myStony= new Stony();
					
						myStony.setId(Integer.parseInt(Token3));
						myStony.setType(Token4);
						myStony.setLongitude(Float.parseFloat(Token6));
						myStony.setLatitude(Float.parseFloat(Token7));
						myStony.setPrice(Float.parseFloat(Token8));
						myStony.setStatus(Boolean.parseBoolean(Token9));
						Map.Array.add(myStony);
						continue;
					
					}
				else if(Token4.equals("Stony-Iron"))
				{		
					StonyIron myStonyIron= new StonyIron();
					myStonyIron.setId(Integer.parseInt(Token3));
					myStonyIron.setType(Token4);
					myStonyIron.setLongitude(Float.parseFloat(Token6));
					myStonyIron.setLatitude(Float.parseFloat(Token7));
					myStonyIron.setPrice(Float.parseFloat(Token8));
					myStonyIron.setStatus(Boolean.parseBoolean(Token9));
					Map.Array.add(myStonyIron);
					continue;
						
				}
				else if(Token4.equals("Pallasite"))
					{	
						Pallasite myPallasite=new Pallasite();
						myPallasite.setId(Integer.parseInt(Token3));
						myPallasite.setType(Token4);
						myPallasite.setLongitude(Float.parseFloat(Token6));
						myPallasite.setLatitude(Float.parseFloat(Token7));
						myPallasite.setPrice(Float.parseFloat(Token8));
						myPallasite.setStatus(Boolean.parseBoolean(Token9));
						Map.Array.add(myPallasite);
						continue;
					
						
					}
				else if(Token4.equals("SpaceJunk"))
					{
						SpaceJunk mySpaceJunk=new SpaceJunk();	
						mySpaceJunk.setType(Token4);
						mySpaceJunk.setId(Integer.parseInt(Token3));
						mySpaceJunk.setLongitude(Float.parseFloat(Token6));
						mySpaceJunk.setLatitude(Float.parseFloat(Token7));
						mySpaceJunk.setPrice(Float.parseFloat(Token8));
						mySpaceJunk.setStatus(Boolean.parseBoolean(Token9));
						Map.Array.add(mySpaceJunk);
						continue;
					
						
					}
				
				
				
				//mySeller.SellerArray.add(newSeller);
				//System.out.println(" Array size "+myMap.Array.size());
			}
		}
		catch (Exception e)
		{											// Catch the Exception if there are any
			
		}
		JOptionPane.showMessageDialog(null," Meteorite Successfully Loaded", " Message", JOptionPane.PLAIN_MESSAGE);
			}
			else 
			{
				
					JOptionPane.showMessageDialog(null," You Cancelled To Load Meteorites", " Message ", JOptionPane.PLAIN_MESSAGE);
				
				System.out.println(" You Cancelled To Load Meteorites ");
			}
			
		
			}
			flag=false;
			}
			
				catch (Exception e)
				{
					e.printStackTrace();
					JOptionPane.showMessageDialog(null," Wrong File Type","Error",JOptionPane.ERROR_MESSAGE);
					
					continue;
					
				}
				}
			
			}
	
	//System.out.println("************************************");
	//System.out.println("* Your File is Successfully Loaded *");
	//System.out.println("************************************");
//	}
	
	/******************************************************************************************
	 * Method: loadSeller
	 * Parameter : SellerInfo object
	 * Description:	This method reads the Seller.txt file and stores all the seller object in an array.
	 * Input : N/A
	 * Output : N/A
	 */	
	public void loadSeller(SellerInfo mySeller)
	{
	
		String Token1;
		String Token2;
		String Token3;
		
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
				"Do You Want To Load Seller", "Load Seller", JOptionPane.YES_NO_OPTION);
		if (conformation==JOptionPane.YES_OPTION )
		{
		
		
		try{
			Scanner myScanner=new Scanner(myFile);			
			String text=new String();											
			while (myScanner.hasNextLine())

			{
				SellerInfo newSeller=new SellerInfo();
				text=myScanner.next();
				StringTokenizer mytoken=new StringTokenizer (text,",");		
				Token1=mytoken.nextToken();
				Token2=mytoken.nextToken();
				Token3=mytoken.nextToken();
				newSeller.setNames(Token1);
				newSeller.setLongitude(Float.parseFloat(Token2));
				newSeller.setLatitude(Float.parseFloat(Token3));
				mySeller.SellerArray.add(newSeller);
			
				
			}
		}
		catch (Exception e)
		{											
			
		}
		
		JOptionPane.showMessageDialog(null," Seller Successfully Loaded", " Message ", JOptionPane.PLAIN_MESSAGE);
	
		}
		else
		{	JOptionPane.showMessageDialog(null," You Cancelled To Load Seller", " Message ", JOptionPane.PLAIN_MESSAGE);
			System.out.println(" You Cancelled To Load Seller");
		}
		}
		
		flag=false;
	
		}
		
			catch (Exception e)
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(null," Wrong File Type","Error",JOptionPane.ERROR_MESSAGE);
				
				continue;
				
			}
			}
	}
	
		
		
		
		
	
	/******************************************************************************************
	 * Method: loadBuyer
	 * Parameter :BuyerInfo object
	 * Description:	This method reads the Buyer.txt file and stores all the buyer object in an array.
	 * Input : N/A
	 * Output : N/A
	 */	
	public void loadBuyer(BuyerInfo myBuyer)
	{
		String Token1;
		String Token2;
		String Token3;
		File myfile=new File("C:\\Users\\nibasabin\\Desktop\\Buyer.txt");	// Opens the Meteorite file which containts the information of meteorite created. 
		try{
			Scanner myScanner=new Scanner(myfile);			
			String text=new String();												
			while (myScanner.hasNextLine())

			{
				BuyerInfo newBuyer=new BuyerInfo();
				myScanner.hasNextLine();
				text=myScanner.next();
				StringTokenizer mytoken=new StringTokenizer (text,",");		
				Token1=mytoken.nextToken();
				Token2=mytoken.nextToken();
				Token3=mytoken.nextToken();
				newBuyer.setName(Token1);
				newBuyer.setLatitude(Float.parseFloat(Token3));
				newBuyer.setLongitude(Float.parseFloat(Token2));
				
				if(myBuyer.BuyerArray.size()==0)
				{
					myBuyer.BuyerArray.add(newBuyer);	
				}
				else
				{
					boolean check= false;
					for(int i=0;i<myBuyer.BuyerArray.size();i++)
					{
						if(Token1.equals(myBuyer.BuyerArray.get(i).getName()))
						{
							check=true;
						}
						if (check==false)
						{
							myBuyer.BuyerArray.add(newBuyer);
						}
						else
						{
							System.out.println();
						}
					
					}
				}
			}
		}
		catch (Exception e)
		{											// Catch the Exception if there are any
			
		}
		
		}
	
	
	
	}
