


/******************************************************************************
 * Class : SingleTextMeteorite
 * Date : December 5, 2013
 * Description : - Child class of Pricing Class
 * 				 - This class contains the methods to creates meteorites in single line text
 * 				
 * */
package seller;

import java.util.StringTokenizer;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import datastore.Martian;
import datastore.Achondrite;
import datastore.Asteroidal;
import datastore.Chondrite;
import datastore.Iron;
import datastore.Lunar;
import datastore.Pallasite;
import datastore.SpaceJunk;
import datastore.Stony;
import datastore.StonyIron;
import datastore.WorldMap;
import seller.CreateMeteorite;

public class SingleTextMeteorite extends JFrame{
	
	/******************************************************************************
	 * Method : SingleTextMeteorite
	 * Date : October 31, 2013
	 * Description : - This class contains the methods to creates meteorites in single line text
	 * 				
	 * */
	
	
	public void CreateMeteoriteOneLine(WorldMap Map) 
	{
		CreateMeteorite myMeteorite= new CreateMeteorite();
		
	
				boolean flag= false;
				boolean done=false;
				
					JTextArea text= new JTextArea("Chondrite \n"
							+ "Achondrite \n"
							+ "Lunar-Achondrite \n"
							+ "Martian-Achondrite \n"
							+ "Asteroidal-Achondrite \n"
							+ "Iron \n"
							+ "Stony \n"
							+ "Stony-Iron \n"
							+ "Pallasite \n"
							+ "SpaceJunk \n");
				
					text.setEditable(false);
					text.setBackground(null);
				
					String Text;
					JTextField JMeteorite= new JTextField();
					final JComponent[] create= new JComponent[] { new JLabel(" Enter (ID/Type/Longitude/Latitude/Price) "),JMeteorite,new JLabel("Meteorite List"),text};
					JOptionPane.showMessageDialog(null, create, " Create Meteorite ", JOptionPane.PLAIN_MESSAGE);
					Text= JMeteorite.getText();

					add(JMeteorite);
					
					try
					{
						int Id;
						String Type;
						String Longitude;
						String Latitude;
						String Cost;
						
						StringTokenizer myToken= new StringTokenizer(Text,"/");
						Id=Integer.parseInt(myToken.nextToken());
						Type=myToken.nextToken();
						Longitude=myToken.nextToken();
						Latitude=myToken.nextToken();
						Cost=myToken.nextToken();
						
			


					
					
					boolean condition= false;
					boolean done1=false;
					boolean done2=false;
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
								System.out.println(" yeyeyeyey"+done1);
								if (done1 && done2 ==true)
								{	
									myChondrite.setId(Id);
									myChondrite.setLongitude((Float.parseFloat(Longitude)));
									myChondrite.setLatitude((Float.parseFloat(Latitude)));
									myChondrite.setType(Type);
									float price= myMeteorite.pricing(Type, Map.longitude(Float.parseFloat(Longitude)),Map.latitude(Float.parseFloat(Latitude)));
									int conformation=JOptionPane.showConfirmDialog(null,
											"Suggeste Price :" + price, Cost, JOptionPane.YES_NO_OPTION);
									if (conformation==JOptionPane.YES_OPTION )
				
									{
										myChondrite.setPrice(price);
									}
									else
									{
										myChondrite.setPrice(Float.parseFloat(Cost));
									}
									
									
									
									Map.Array.add(myChondrite);
				
										
									flag=false;
								
							
						}
							}
							
						else if (Type.equals("Achondrite"))
								{	
									Achondrite myAchondrite= new Achondrite(Id,150,true,"Achondrite");
								
									
									done1=myAchondrite.setLongitude(Map.latitude(Float.parseFloat(Longitude)));
									done2=myAchondrite.setLatitude(Map.latitude(Float.parseFloat(Latitude)));
								
									if (done1 && done2==true)
									{	myAchondrite.setId(Id);
										myAchondrite.setLongitude((Float.parseFloat(Longitude)));;
										myAchondrite.setLatitude((Float.parseFloat(Latitude)));
										myAchondrite.setType(Type);
										float price= myMeteorite.pricing(Type, Map.longitude(Float.parseFloat(Longitude)),Map.latitude(Float.parseFloat(Latitude)));
										int conformation=JOptionPane.showConfirmDialog(null,
												"Suggeste Price :" + price, Cost, JOptionPane.YES_NO_OPTION);
										if (conformation==JOptionPane.YES_OPTION )
					
										{
											myAchondrite.setPrice(price);
										}
										else
										{
											myAchondrite.setPrice(Float.parseFloat(Cost));
										}
										Map.Array.add(myAchondrite);
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
										float price= myMeteorite.pricing(Type, Map.longitude(Float.parseFloat(Longitude)),Map.latitude(Float.parseFloat(Latitude)));
										int conformation=JOptionPane.showConfirmDialog(null,
												"Suggeste Price :" + price, Cost, JOptionPane.YES_NO_OPTION);
										if (conformation==JOptionPane.YES_OPTION )
					
										{
											myLunar.setPrice(price);
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
								Martian myMartian= new Martian(Id,1000,true,"Martian");	
								
								done1=myMartian.setLongitude(Map.longitude(Float.parseFloat(Longitude)));
								done2=myMartian.setLatitude(Map.latitude(Float.parseFloat(Latitude)));
							
								if (done1 && done2 ==true)
								{	myMartian.setId(Id);
									myMartian.setLongitude((Float.parseFloat(Longitude)));
									myMartian.setLatitude((Float.parseFloat(Latitude)));
									myMartian.setType(Type);
									float price= myMeteorite.pricing(Type, Map.longitude(Float.parseFloat(Longitude)),Map.latitude(Float.parseFloat(Latitude)));
									int conformation=JOptionPane.showConfirmDialog(null,
											"Suggeste Price :" + price, Cost, JOptionPane.YES_NO_OPTION);
									if (conformation==JOptionPane.YES_OPTION )
				
									{
										myMartian.setPrice(price);
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
									
									done1=myAsteroidal.setLongitude((Float.parseFloat(Longitude)));
									done2=myAsteroidal.setLatitude((Float.parseFloat(Latitude)));
								
									if (done1 && done2==true)
									{
										myAsteroidal.setId(Id);
										myAsteroidal.setLongitude((Float.parseFloat(Longitude)));
										myAsteroidal.setLatitude((Float.parseFloat(Latitude)));
										myAsteroidal.setType(Type);
										float price= myMeteorite.pricing(Type, Map.longitude(Float.parseFloat(Longitude)),Map.latitude(Float.parseFloat(Latitude)));
										int conformation=JOptionPane.showConfirmDialog(null,
												"Suggeste Price :" + price, Cost, JOptionPane.YES_NO_OPTION);
										if (conformation==JOptionPane.YES_OPTION )
					
										{
											myAsteroidal.setPrice(price);
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
										float price= myMeteorite.pricing(Type, Map.longitude(Float.parseFloat(Longitude)),Map.latitude(Float.parseFloat(Latitude)));
										int conformation=JOptionPane.showConfirmDialog(null,
												"Suggeste Price :" + price, Cost, JOptionPane.YES_NO_OPTION);
										if (conformation==JOptionPane.YES_OPTION )
					
										{
											myIron.setPrice(price);
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
										float price= myMeteorite.pricing(Type, Map.longitude(Float.parseFloat(Longitude)),Map.latitude(Float.parseFloat(Latitude)));
										int conformation=JOptionPane.showConfirmDialog(null,
												"Suggeste Price :" + price, Cost, JOptionPane.YES_NO_OPTION);
										if (conformation==JOptionPane.YES_OPTION )
					
										{
											myStony.setPrice(price);
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
										float price= myMeteorite.pricing(Type, Map.longitude(Float.parseFloat(Longitude)),Map.latitude(Float.parseFloat(Latitude)));
										int conformation=JOptionPane.showConfirmDialog(null,
												"Suggeste Price :" + price, Cost, JOptionPane.YES_NO_OPTION);
										if (conformation==JOptionPane.YES_OPTION )
					
										{
											myStonyIron.setPrice(price);
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
										float price= myMeteorite.pricing(Type, Map.longitude(Float.parseFloat(Longitude)),Map.latitude(Float.parseFloat(Latitude)));
										int conformation=JOptionPane.showConfirmDialog(null,
												"Suggeste Price :" + price, Cost, JOptionPane.YES_NO_OPTION);
										if (conformation==JOptionPane.YES_OPTION )
					
										{
											myPallasite.setPrice(price);
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
										float price= myMeteorite.pricing(Type, Map.longitude(Float.parseFloat(Longitude)),Map.latitude(Float.parseFloat(Latitude)));
										int conformation=JOptionPane.showConfirmDialog(null,
												"Suggeste Price :" + price, Cost, JOptionPane.YES_NO_OPTION);
										if (conformation==JOptionPane.YES_OPTION )
					
										{
											mySpaceJunk.setPrice(price);
										}
										else
										{
											mySpaceJunk.setPrice(Float.parseFloat(Cost));
										}

										Map.Array.add(mySpaceJunk);
										JOptionPane.showMessageDialog(null," Meteorite Created Successfully ", " Message ", JOptionPane.PLAIN_MESSAGE);
									}
										flag=false;
								}
							}
						}
							
							catch (Exception e)
							{
								JOptionPane.showMessageDialog(null, " Invalid Parameter ", " Message ", JOptionPane.PLAIN_MESSAGE);
								JOptionPane.showMessageDialog(null, " Meteorite Not Created ", " Message ", JOptionPane.PLAIN_MESSAGE);
								System.out.println();
								flag=false;
							}
					
						}
	}

						

