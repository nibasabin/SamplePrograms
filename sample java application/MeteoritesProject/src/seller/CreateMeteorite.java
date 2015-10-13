/*******************************************************************************
 * Class : CreateMeteorite
 * Date : December 5, 2013
 * Description : - Child class of Pricing Class
 * 				 - This class contains the methods to creates meteorites 
 * 				 - It contains the method that updates the meteorites.
 * 				 - It contains abstract function that gives the price to meteorite base 
 * 				   on its type and where it landed
 * 				 - It contains method that prints the list of meteorite
 * 				 - It contains method that prints the list of meteorite that was created
 * */

	package seller;
	import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import datastore.WorldMap;
import datastore.Meteorite;
import datastore.Chondrite;
import datastore.Achondrite;
import datastore.Lunar;
import datastore.Martian;
import datastore.Asteroidal;
import datastore.Iron;
import datastore.Stony;
import datastore.StonyIron;
import datastore.Pallasite;
import datastore.SpaceJunk;
import datastore.Position;
import datastore.Pricing;
import datastore.Continent;

	public class CreateMeteorite extends Pricing implements ActionListener
	{
		Continent mycontinent= new Continent();
		Position myPosition=new Position();
		Meteorite newMeteorite=new Meteorite();
		WorldMap myMap=new WorldMap();
		int index,Id;
		JComboBox JType;
		JTextField JCost, JLongitude, JLatitude,JId;
		String Type;
		String MeteoriteType[]={ "Chondrite","Achondrite","Lunar-Achondrite", "Martian-Achondrite","Asteroidal-Achondrite", "Iron", "Stony","Stony-Iron","Pallasite","SpaceJunk"};

	
	/*******************************************************************************************
	 * Method : meteorite
	 * Parameter : Object of class WorldMap
	 * Description: - Takes input in a single line string.
	 * 			    - Tokenizes the string and gets longitude, latitude, type and price of meteorite
	 * 				- Based on the type of meteorites, it creates meteorite object and stores in array list
	 * String Longitude : Longitude of meteorite
	 * String Latitude : Latitude of meteorite
	 * String Type : Type of meteorite
	 * String Cost : Cost of meteorite
	 */
	
	public void meteorite(WorldMap Map) 
	{
	
				
				boolean flag=true;
				boolean done1=false;
				boolean done2=false;
			
					String Longitude=null;
					String Latitude=null;
					String Cost=null;
				
					JId= new JTextField();
					JLongitude = new JTextField();
					JLatitude = new JTextField();
					
					JType= new JComboBox(MeteoriteType);
					
					JType.setSelectedIndex(9);
					JType.addItemListener(new ItemListener(){
						public void itemStateChanged(ItemEvent e){
							index = JType.getSelectedIndex();
					boolean a=true;
						    Type= MeteoriteType[index];
						  
						    try{
						    JCost.setText(String.valueOf(pricing(Type, myMap.longitude((Float.parseFloat((JLongitude.getText())))), myMap.latitude(Float.parseFloat(JLatitude.getText()))-7)));
						 
						    }
						    catch(Exception s)
						    {
						    	//JOptionPane.showMessageDialog(null," Invalid Longitude / Latitude " ," Message ", JOptionPane.PLAIN_MESSAGE);
								//continue;
						    }
						
						}
					});;
					//if (JLongitude.getText().equals("")|| JLatitude.getText().equlals)
					JCost= new JTextField();
					
					final JComponent[] inputs = new JComponent[] {new JLabel(" Meteorite Id "),JId,new JLabel(" Meteorite Longitude"),JLongitude,new JLabel(" Meteorite Latitude "),JLatitude,new JLabel(" Meteorite Type "),JType,new JLabel(" Meteorite Cost "),JCost };
					JOptionPane.showMessageDialog(null, inputs, " Create Meteorite ", JOptionPane.PLAIN_MESSAGE);
					
					try
					{
						Id=Integer.parseInt(JId.getText());
						Longitude=JLongitude.getText();
						Latitude= JLatitude.getText();
						Type= MeteoriteType[index];
						Cost= JCost.getText();
						
					
						
						boolean condition= false;
						for (int i=0;i<Map.Array.size();i++)
						{
							if (Id==Map.Array.get(i).getId())
							{
								
								condition=true;
							}
							
						}
						if (condition== true)
						{
							JOptionPane.showMessageDialog(null," This ID No Already Exists ","Message", JOptionPane.PLAIN_MESSAGE);
						}
						else 
						{
						
							
						if(Type.equals("Chondrite"))
						{	
							
							Chondrite myChondrite= new Chondrite( Id, 50,true,"Chondrite");	
							
							done1=myChondrite.setLongitude(Map.longitude(Float.parseFloat(Longitude)));
							done2=myChondrite.setLatitude(Map.latitude(Float.parseFloat(Latitude)));
							
							if (done1 & done2 ==true)
							{	
								myChondrite.setId(Id);
								myChondrite.setLongitude((Float.parseFloat(Longitude)));
								myChondrite.setLatitude((Float.parseFloat(Latitude)));
								System.out.println(" longitude "+(Map.longitude(Float.parseFloat(Longitude))));
								System.out.println(" Latitude "+(Map.latitude(Float.parseFloat(Latitude))));
								myChondrite.setType(Type);
								myChondrite.setPrice(Float.parseFloat(Cost));
							
								Map.Array.add(myChondrite);
							
									
								flag=false;
							
							}
						}
						else if(Type.equals("Lunar-Achondrite"))
						{
							Lunar myLunar= new Lunar(Id,1000,true,"Achondrite");	
							
							done1=myLunar.setLongitude(Map.longitude(Float.parseFloat(Longitude)));
							done2=myLunar.setLatitude(Map.latitude(Float.parseFloat(Latitude)));
						
							if (done1 && done2 ==true)
							{	myLunar.setId(Id);
								myLunar.setLongitude((Float.parseFloat(Longitude)));
								myLunar.setLatitude((Float.parseFloat(Latitude)));
								myLunar.setType(Type);
								if(Cost.equals(""))
								{
									System.out.println();
								}
								else
								{
									myLunar.setPrice(Float.parseFloat(Cost));
								}
								Map.Array.add(myLunar);
							}
								flag=false;
							
							}
						else if(Type.equals("Martian-Achondrite"))
						{
							Lunar myMartian= new Lunar(Id,1000,true,"Martian");	
							
							done1=myMartian.setLongitude(Map.longitude(Float.parseFloat(Longitude)));
							done2=myMartian.setLatitude(Map.latitude(Float.parseFloat(Latitude)));
						
							if (done1 && done2 ==true)
							{	myMartian.setId(Id);
								myMartian.setLongitude((Float.parseFloat(Longitude)));
								myMartian.setLatitude((Float.parseFloat(Latitude)));
								myMartian.setType(Type);
								if(Cost.equals(""))
								{
									System.out.println();
								}
								else
								{
									myMartian.setPrice(Float.parseFloat(Cost));
								}
								Map.Array.add(myMartian);
							}
								flag=false;
							
							}
							
							
						
						else if(Type.equals("Asteroidal-Achondrite"))
						{	
							Asteroidal myAsteroidal= new Asteroidal(Id,250,true,"Asteroidal-Achondrite");	
							
							done1=myAsteroidal.setLongitude(Map.longitude(Float.parseFloat(Longitude)));
							done2=myAsteroidal.setLatitude(Map.latitude(Float.parseFloat(Latitude)));
						
							if (done1 & done2==true)
							{
								myAsteroidal.setId(Id);
								myAsteroidal.setLongitude((Float.parseFloat(Longitude)));
								myAsteroidal.setLatitude((Float.parseFloat(Latitude)));
								myAsteroidal.setType(Type);
								if(Cost.equals(""))
								{
									System.out.println();
								}
								else
								{
									myAsteroidal.setPrice(Float.parseFloat(Cost));
								}
								
								Map.Array.add(myAsteroidal);
							}
								flag=false;
						}
						
						else if(Type.equals("Iron"))
						{
							Iron myIron= new Iron(Id,500,true,"Iron");	
							
							done1=myIron.setLongitude(Map.longitude(Float.parseFloat(Longitude)));
							done2=myIron.setLatitude(Map.latitude(Float.parseFloat(Latitude)));
						
							if (done1 && done2==true)
							{
								myIron.setId(Id);
								myIron.setLongitude((Float.parseFloat(Longitude)));
								myIron.setLatitude((Float.parseFloat(Latitude)));
								myIron.setType(Type);
								if(Cost.equals(""))
								{
									System.out.println();
								}
								else
								{
									myIron.setPrice(Float.parseFloat(Cost));
								}
							
								Map.Array.add(myIron);
							}
								flag=false;
						}
						
						else if(Type.equals("Stony"))
						{
							Stony myStony	= new Stony(Id,500,true,"Stony");	
							
							done1=myStony.setLongitude(Map.longitude(Float.parseFloat(Longitude)));
							done2=myStony.setLatitude(Map.latitude(Float.parseFloat(Latitude)));
						
							if (done1 && done2==true)
							{	
								
								myStony.setId(Id);
								myStony.setType(Type);
								myStony.setLongitude((Float.parseFloat(Longitude)));
								myStony.setLatitude((Float.parseFloat(Latitude)));
								if (Cost.equals(""))
								{		
									System.out.println();
								}
								else
								{
									myStony.setPrice(Float.parseFloat(Cost));
								}
								Map.Array.add(myStony);
								}
							flag=false;
						}
						
						else if(Type.equals("Stony-Iron"))
						{		
							StonyIron myStonyIron	= new StonyIron(Id,500,true,"Stony-Iron");	
							
							done1=myStonyIron.setLongitude(Map.longitude(Float.parseFloat(Longitude)));
							done2=myStonyIron.setLatitude(Map.latitude(Float.parseFloat(Latitude)));
						
							if (done1 && done2==true)
							{	myStonyIron.setId(Id);
								myStonyIron.setLongitude((Float.parseFloat(Longitude)));	
								myStonyIron.setLatitude((Float.parseFloat(Latitude)));
								myStonyIron.setType(Type);
								if(Cost.equals(""))
								{
									System.out.println();
								
								}
								else 
								{
									myStonyIron.setPrice(Float.parseFloat(Cost));
								}
								Map.Array.add(myStonyIron);
							}
								flag=false;
						}
							
						
						else if(Type.equals("Pallasite"))
						{	
							Pallasite myPallasite	= new Pallasite(Id,1000,true,"Pallasite");	
							
							done1=myPallasite.setLongitude(Map.longitude(Float.parseFloat(Longitude)));
							done2=myPallasite.setLatitude(Map.latitude(Float.parseFloat(Latitude)));
						
							if (done1 && done2==true)
							{
								myPallasite.setId(Id);
								myPallasite.setType(Type);
								myPallasite.setLongitude((Float.parseFloat(Longitude)));
								myPallasite.setLatitude((Float.parseFloat(Latitude)));
								if(Cost.equals(""))
								{
									System.out.println("");
									
								}
								else
								{
									myPallasite.setPrice(Float.parseFloat(Cost));
								}
								
								Map.Array.add(myPallasite);
							}
								flag=false;
						}
						
						else if(Type.equals("SpaceJunk"))
						{
							SpaceJunk mySpaceJunk	= new SpaceJunk(Id,10,true,"SpaceJunk");	
							
							done1=mySpaceJunk.setLongitude(Map.longitude(Float.parseFloat(Longitude)));
							done2=mySpaceJunk.setLatitude(Map.latitude(Float.parseFloat(Latitude)));
							if (done1 && done2==true)
							{
								mySpaceJunk.setId(Id);
								mySpaceJunk.setType(Type);
								mySpaceJunk.setLongitude((Float.parseFloat(Longitude)));
								mySpaceJunk.setLatitude((Float.parseFloat(Latitude)));
								if(Cost.equals(""))
								{
									System.out.println();
								}
								else
								{
									mySpaceJunk.setPrice(Float.parseFloat(Cost));
								}
								
								Map.Array.add(mySpaceJunk);
							}
								flag=false;
						}
						}
						JOptionPane.showMessageDialog(null," Meteorite Created Successfully ", " Message ", JOptionPane.PLAIN_MESSAGE);
						
					}
				
					
					catch (Exception e)
					{
						JOptionPane.showMessageDialog(null, " Meteorite Not Created ", " Message ", JOptionPane.PLAIN_MESSAGE);
						//e.printStackTrace();
						System.out.println();
						flag=false;
					}
					
				}
			
		
	
							
							
						
				

	
			
			
						
							
						
			
	
	/*******************************************************************************************
	 * Function  : pricing
	 * Parameter : Objects of Class WorldMap and Continent
	 * Description: - Abstract function of Abstract class Pricing 
	 * 				- Checks in which continent does the meteorite fall and suggest the price 
	 * 				  depending on the type of meteorite and location of meteorite
	 * Input : N/A
	 * Output : N/A
	 */
		

	public float pricing(String type, float longitude, float latitude)
	
	{	
	
			if (type.equalsIgnoreCase("Chondrite"))
			{
				return (50 + mycontinent.isContinent((int)longitude,(int)latitude ));
			}
			else if (type.equalsIgnoreCase("Achondrite"))
			{
				return (150 + mycontinent.isContinent((int)longitude,(int)latitude ));
			}
			
			else if (type.equalsIgnoreCase("Lunar-Achondrite"))
			{
				return (1000 + mycontinent.isContinent((int)longitude,(int)latitude ));
			}
			else if (type.equalsIgnoreCase("Martian-Achondrite"))
			{ 
				System.out.println("this is martian price"+ mycontinent.isContinent((int)longitude,(int)latitude ));
				return (1000 + mycontinent.isContinent((int)longitude,(int)latitude ));
			}
			else if (type.equalsIgnoreCase("Asteroidal-Achondrite"))
			{
				return (250 + mycontinent.isContinent((int)longitude,(int)latitude ));
			}
			else if (type.equalsIgnoreCase("Iron"))
			{
				return (500 + mycontinent.isContinent((int)longitude,(int)latitude ));
			}
			else if (type.equalsIgnoreCase("Stony"))
			{
				return (500 + mycontinent.isContinent((int)longitude,(int)latitude ));
			}
			else if (type.equalsIgnoreCase("Stony-Iron"))
			{
				return (50 + mycontinent.isContinent((int)longitude,(int)latitude ));
			}
			else if (type.equalsIgnoreCase("Pallasite"))
			{
				return (1000 + mycontinent.isContinent((int)longitude,(int)latitude ));
			}
			else
			{
				return (10 + mycontinent.isContinent((int)longitude,(int)latitude ));
			}
				
			
	}
	/*	
	public static void main(String args[])
	{
		CreateMeteorite n= new CreateMeteorite();
		n.pricing("Chondrite", (float)395.96, (float)86.57);
	}
	*/

			
		
	/*******************************************************************************************
	 * Method : printArrayList
	 * Parameter : Objects of Class WorldMap
	 * Description: - Prints the List of Meteorites 
	 * 				- prints the status of Meteorite (Available or Not Available)
	 * 				- 
	 * Input : N/A
	 * Output : Prints the Meteorite List
	 */
		
		
	public void printArrayList(WorldMap Map)
		{
			System.out.println(" U.T.A METEORITE SHOP INVENTORY ");
			System.out.println("--------------------------------");
			System.out.println(" array size id "+Map.Array.size());
			for(int i=0;i<Map.Array.size();i++)
			{  
				System.out.println("\n");
				System.out.println(" ID :"+Map.Array.get(i).getId());
				System.out.println(" Type :"+Map.Array.get(i).getType());
				System.out.println(" Price :"+Map.Array.get(i).getPrice());
				System.out.println(" Latitude :"+Map.Array.get(i).getLatitude());
				System.out.println(" Longitude :"+Map.Array.get(i).getLongitude());
				if (Map.Array.get(i).getStatus()==true)
				{
					System.out.println(" Status : Available");
				}
				else 
				{
					System.out.println(" Status : Not Available");
				}
				
				
			}
		}
	
	
		
	/*******************************************************************************************
	 * Function  : update
	 * Parameter : Objects of Class WorldMap
	 * Description: - This function displays list of update menu and perform the task 
	 * 				  of updating Price, Longitude, Latitude and Type of meteorite.
	 * float price : new price for meteorite
	 * float Longitude : new longitude for meteorite
	 * float latitude : new latitude for meteorite 
	 * float Type : new type for meteorite
	 */
		
	public void update(WorldMap Map)
	{
			
		int size= Map.Array.size();
		String MArray[]= new String[size+1];
		
		for(int i=0; i<Map.Array.size();i++)
			{
				String Id= Integer.toString(Map.Array.get(i).getId());
				MArray[0]=" None ";
				MArray[i+1] ="Id #"+ Id + " Meteorite Type : " +Map.Array.get(i).getType();
			}
			
		JComboBox JType= new JComboBox(MArray);
		JType.setSelectedIndex(Map.Array.size()-1);
		final JComponent[] inputs = new JComponent[] {new JLabel(" Please Select Meteorite To Update "),JType };
		JOptionPane.showMessageDialog(null, inputs, " Meteorite List ", JOptionPane.PLAIN_MESSAGE);
		JType.addActionListener(this);
		int index=JType.getSelectedIndex();
			
		String Type= MArray[index];
		
		int temp = 0;
		for(int i=0;i<Map.Array.size();i++)
		{
			if (Type.equals("Id #"+ Map.Array.get(i).getId() + " Meteorite Type : " +Map.Array.get(i).getType()))
			{
				temp=i;
				System.out.println("Array no "+temp);
			}
			
		}
		
		boolean flag=true;
		while (flag!=false)
		{
		try
		{
			String Longitude=null;
			String Latitude=null;
			String MType=null;
			String Cost=null;
			int Id;
			String MeteoriteType[]={ "Chondrite","Achondrite","Lunar-Achondrite", "Martian-Achondrite","Asteroidal-Achondrite", "Iron", "Stony","Stony-Iron","Pallasite","SpaceJunk"};
			JTextField ULongitude = new JTextField();
			JTextField ULatitude = new JTextField();
			JTextField UCost= new JTextField();
			JComboBox UType= new JComboBox(MeteoriteType);
			
			final JComponent[] update = new JComponent[] {new JLabel(" Meteorite Longitude"),ULongitude,new JLabel(" Meteorite Latitude "),ULatitude,new JLabel(" Meteorite Type "),UType,new JLabel(" Meteorite Cost "),UCost };
			JOptionPane.showMessageDialog(null, update, " Update Meteorite ", JOptionPane.PLAIN_MESSAGE);
			JType.setSelectedIndex(Map.Array.size()-1);
			JType.addActionListener(this);
			
			Longitude=ULongitude.getText();
			Latitude=ULatitude.getText();
			Cost=UCost.getText();
			int Uindex=UType.getSelectedIndex();
			MType=MeteoriteType[Uindex];
			if (Longitude.equals("")||Latitude.equals("")||Cost.equals(""))
			{
				JOptionPane.showMessageDialog(null," Complete Information Not Provided ", " Message ", JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(null," Meteorite Not Updated ", " Message ", JOptionPane.PLAIN_MESSAGE);
				
				flag=false;
			}
			else
			{
				boolean done1=false;
				boolean done2= false;
				done1=Map.Array.get(temp).setLongitude(Float.parseFloat(Longitude));
				done2= Map.Array.get(temp).setLatitude(Float.parseFloat(Latitude));
				if (done1 && done2 == true)
				{
					Map.Array.get(temp).setLongitude(Float.parseFloat(Longitude));
					Map.Array.get(temp).setLatitude(Float.parseFloat(Latitude));
					Map.Array.get(temp).setPrice(Float.parseFloat(Cost));
					Map.Array.get(temp).setType(MType);
					flag=false;
				}
				else 
				{
					JOptionPane.showMessageDialog(null," Complete Information Not Provided ", " Message ", JOptionPane.PLAIN_MESSAGE);
					JOptionPane.showMessageDialog(null," Meteorite Not Updated ", " Message ", JOptionPane.PLAIN_MESSAGE);
					continue;
				}
			}
		}
			
			catch(Exception e)
			{
				e.printStackTrace();
				continue;
			}
		}
	}
		
			
			
			
			
			
		
		
	/*******************************************************************************************
	 * Function  : remove
	 * Parameter : Objects of Class WorldMap 
	 * Description: - Ask for the Id of Meteorite and deletes all information of that meteorite
	 * Input : N/A
	 * Output : N/A
	 */
		public void remove(WorldMap Map)
		{
			int size= Map.Array.size();
			String MArray[]= new String[size+1];
			
			for(int i=0; i<Map.Array.size();i++)
				{
					String Id= Integer.toString(Map.Array.get(i).getId());
					MArray[0]=" None ";
					MArray[i+1] ="Id #"+ Id + " Meteorite Type : " +Map.Array.get(i).getType();
				}
				
			JComboBox JType= new JComboBox(MArray);
			JType.setSelectedIndex(Map.Array.size()-1);
			final JComponent[] inputs = new JComponent[] {new JLabel(" Please Select Meteorite To Update "),JType };
			JOptionPane.showMessageDialog(null, inputs, " Meteorite List ", JOptionPane.PLAIN_MESSAGE);
			JType.addActionListener(this);
			int index=JType.getSelectedIndex();
				//System.out.println("Selected index"+index);
			String Type= MArray[index];
				//System.out.println(Type);
			int temp = 0;
			for(int i=0;i<Map.Array.size();i++)
			{
				if (Type.equals("Id #"+ Map.Array.get(i).getId() + " Meteorite Type : " +Map.Array.get(i).getType()))
				{
					temp=i;
					System.out.println("Array no "+temp);
				}
				
			}
			int conformation=JOptionPane.showConfirmDialog(null,
					"Do You Want To Remove Meteorite", "Remove Meteorite", JOptionPane.YES_NO_OPTION);
			if (conformation==JOptionPane.YES_OPTION )
			{
			Map.Array.remove(temp);
			JOptionPane.showMessageDialog(null," Meteorite Successfully Removed ", " Message", JOptionPane.PLAIN_MESSAGE);
			}
			else 
			{
				JOptionPane.showMessageDialog(null," You Cancelled To Remove Meteorites", " Message ", JOptionPane.PLAIN_MESSAGE);
				System.out.println(" You Cancelled To Load Meteorites ");
			}
		}
			
			
			
			
			
			
			
			
			
			
			
			
		


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 // JComboBox cb = (JComboBox)e.getSource();
	       // String petName = (String)cb.getSelectedItem();
	}
	
}
    
  


