
/*******************************************************************************
 * Author : Sabin Raj Bajrachary 
 * Class : SellerMain
 * Date : December 5, 2013
 * Description : This class display Seller Menu and executes given operation.
 * */

package seller;
import seller.CreateMeteorite;
import datastore.Distance;
import datastore.Meteorite;
import datastore.WorldMap;
import datastore.SaveData;
import datastore.Continent;
import datastore.Position;
import buyer.BuyerInfo;
import datastore.Scramble;
import datastore.GUI;
import java.util.*;


public class SellerMain
{
	
	WorldMap Map=new WorldMap();
	Meteorite myMeteorite=new Meteorite();
	CreateMeteorite newMeteorite= new CreateMeteorite();
	Continent myContinents=new Continent();
	Position myPosition= new Position();
	SellerInfo mySeller= new SellerInfo();
	SaveData mydata= new SaveData();
	Distance myDistance= new Distance();
	BuyerInfo myBuyer= new BuyerInfo();
	Scramble myScramble= new Scramble();

/*******************************************************************************************
 * Method : menuList
 * Description: Displays seller Menu
 * Input : N/A
 * Output : Seller Menu
 */
		
private void menuList()			
{
	System.out.println("****************");
	System.out.println("*     Menu     *");
	System.out.println("****************");
	System.out.println();
	System.out.println("1.Load The World Map  :");
	System.out.println("2.Handle A Meteroites:");
	System.out.println("3.Show The World Map With Meteorites:");
	System.out.println("4.Save Files    :");
	System.out.println("5.Load Files    :");
	System.out.println("6.Seller Option	:");
	System.out.println("7.Scramble :");
	System.out.println("8.To Find The Distance of Customer and Seller  :");
	System.out.println("9.Exit          :");
	System.out.println("");
	System.out.println("");
	System.out.println("Please Enter Your Choice :");
}

/*******************************************************************************************
 * Method : subMenu
 * Description: Displays sub menu for Meteorite 
 * Input : N/A
 * Output : Meteorite Sub Menu
 */
private void subMenu()				
{
	System.out.println();
	System.out.println("1.Create a Meteorite");
	System.out.println("2.Update Meteorite");
	System.out.println("3.Remove Meteorite");
	System.out.println("4.Quite");
	System.out.println();
}	

/*******************************************************************************************
 * Method : Choice
 * Description: Displays sub menu for Meteorite 
 * Input :  Depends on the menu selection
 * Output : Depends on the menu selection
 */
			
public void Choice() 	
{
	int end=0;
	Scanner input;
	boolean flag=true;
	while (flag!=false)
	{
		try
		{
			while(end!=9)										
			{
				input= new Scanner(System.in);
				System.out.println("");
				menuList();
				end= input.nextInt();			
		
				switch(end)									
				{
						
					case 1:
					{								
						Map.worldMap();
						Map.printMap();
						continue;
					}
					
					case 2:
					{ 
						int sub=0;
						while(sub!=4)
						{
							subMenu();
							System.out.println("Please Enter your Choice : ");
							sub=input.nextInt();
							
							if (sub==1)
							{ 	
							
								newMeteorite.meteorite(Map);
						
								continue;
							}
							
							if (sub==2)
							{
								newMeteorite.printArrayList(Map);
								newMeteorite.update(Map);
								continue;
							}
							
							if (sub==3)
							{
								newMeteorite.printArrayList(Map);
								newMeteorite.remove(Map);
								continue;
							}
							
							if (sub==4)
							{
								break;
							}
						}
							continue;
					}
					
				case 3: 
				{	
					Map.worldMap();
					Map.meteoriteMap(myMeteorite,mySeller,myBuyer);
					continue;
				}
				
				case 4: 
				{
					mydata.saveMap(Map);
					mydata.saveSeller(mySeller);
					continue;
				}
							
				case 5:
				{
					mydata.loadMap(Map);
					mydata.loadSeller(mySeller);
					mydata.loadBuyer(myBuyer);
					
					continue;
				}
						
				case 6:
				{

					int sub=0;
					while(sub!=3)
					{
						System.out.println("");
						System.out.println("**************");
						System.out.println("* Seller Menu *");
						System.out.println("**************");
						System.out.println();
						System.out.println(" 1. Create Seller ");
						System.out.println(" 2. Seller List ");
						System.out.println(" 3. Update Seller ");
						System.out.println(" 4. Delete Seller ");
						System.out.println(" 5. Exit ");
						System.out.println("Please Enter your Choice : ");
						sub=input.nextInt();
						if (sub==1)
						{ 	
							mySeller.sellerInformation();
							
							continue;
						}
								
						if (sub==2)
						{
							mySeller.sellerList();
							continue;
						}
							
						if (sub==3)
						{	mySeller.sellerList();
							mySeller.sellerUpdate();
							continue;
						}
						if(sub==4)
						{
							mySeller.sellerList();
							mySeller.sellerRemove();
						}
						if (sub==5)
						{
							break;
						}
						else
						{
							System.err.println(" Invalid Input ");
							continue;
						}
								
					}
						continue;
				}
						
				case 7:
				{
					Map.worldMap();
					mydata.loadSeller(mySeller);
					mydata.loadBuyer(myBuyer);
					myScramble.random(Map,myBuyer,mySeller);
					continue;
				}
				
				case 8:
				{
					myDistance.totalDistance(mySeller, myBuyer);
					continue;
				}
				
				case 9:
				{
					System.exit(0);
				}
				
				default:
				{
					System.err.println(" Invalid Input ");
				}
			}
		}
			flag=false;	
	}
		
		catch(InputMismatchException e)
		{
			System.err.println(" Invalid Input");
		}
	
	}
}
/*******************************************************************************************
 * Method : Main
 * Description: Main Method 
 * Input : N/A
 * Output : N/A
 */
	public static void main(String args[])				
	{  
		GUI newGui = new GUI();
			newGui.makeGUI();
		
	
	}
}
						
		
		
	
