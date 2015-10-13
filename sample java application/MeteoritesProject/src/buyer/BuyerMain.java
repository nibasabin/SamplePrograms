/*******************************************************************************
 * Author : Sabin Raj Bajrachary
 * Class : BuyerMain
 * Date : December 5, 2013
 * Description : This class display Buyer Menu and executes given operation.
 * */

package buyer;

	import seller.CreateMeteorite;
import seller.SellerInfo;
import datastore.Continent;
import datastore.GUI;
import datastore.Meteorite;
import datastore.Position;
import datastore.WorldMap;
import datastore.Distance;
import datastore.SaveData;
import datastore.Scramble;


//import seller.SellerInfo;




import java.util.*;
	
	public class BuyerMain 
	{
		WorldMap Map=new WorldMap();
		Meteorite myMeteorite=new Meteorite();
		CreateMeteorite newMeteorite= new CreateMeteorite();
		Continent myContinents=new Continent();
		Position myPosition= new Position();
		SellerInfo mySeller= new SellerInfo();
		Buy myBuy= new Buy();
		BuyerInfo myBuyer= new BuyerInfo();
		Distance myDistance= new Distance();
		SaveData mydata= new SaveData();
		Scramble myScramble = new Scramble();
		

/*******************************************************************************************
 * Method : menuList
 * Description: Displays buyer Menu
 * Input : N/A
 * Output : Buyer Menu
 */
		private void menuList()			
			{
				System.out.println("****************");
				System.out.println("*     Menu     *");
				System.out.println("****************");
				System.out.println();
				System.out.println("1. Load The World Map  :");
				System.out.println("2. Show The World Map With Meteorites:");
				System.out.println("3. Buy A Meteroites:");
				System.out.println("4. Save Files    :");
				System.out.println("5. Load Files    :");
				System.out.println("6. Buyer Option  :");
				System.out.println("7. Scramble      :");
				System.out.println("8. Exit			 :");
				System.out.println("");
				System.out.println("");
				System.out.println("Please Enter Your Choice :");
			}
			
			
			public void Choice() 		// method to allow user to choose the select the desired options form the menu

			{ 	
				int end=0;
				Scanner input;
				boolean flag= true;
				while(flag!=false)
				{
					try
					{
						while(end!=8)										// Runs a loop to display the menu after each task is done
						{
							input=new Scanner(System.in);
							System.out.println("");
							menuList();
							end= input.nextInt();			
				
							switch(end)									// Switch statement allows to choose the task that is desired
							{
								
								case 1:
									{								
										Map.worldMap();
										Map.printMap();
										continue;
									}
								case 2:
								{ 	Map.worldMap();
									Map.meteoriteMap(myMeteorite,mySeller,myBuyer);
									
									continue;
								}
								case 3: 
								{	
								//	myBuy.BuyMeteorite(Map);
									continue;
								}
								case 4: 
								{
									mydata.saveMap(Map);
									mydata.saveBuyer(myBuyer);
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
										System.out.println("* Buyer Menu *");
										System.out.println("**************");
										System.out.println();
										System.out.println(" 1. Create Buyer ");
										System.out.println(" 2. Buyer List ");
										System.out.println(" 3. Update Buyer ");
										System.out.println(" 4. Delete Buyer");
										System.out.println(" 5. Exit ");
										System.out.println("Please Enter your Choice : ");
										sub=input.nextInt();
										if (sub==1)
										{ 	
											//myBuyer.buyerInformation();
											
											continue;
											
										
										}
										if (sub==2)
										{
											//myBuyer.buyerList();
											continue;
										}
										
										if (sub==3)
										{	
										//	myBuyer.buyerList();
										//	myBuyer.buyerUpdate();
											continue;
										}
										if (sub==4)
										{
										//	myBuyer.buyerList();
										//	myBuyer.buyerRemove();
										}
										if (sub==5)
										{
											break;
										}
										
									}
									continue;
								}
									
								case 7:
								{	Map.worldMap();
									mydata.loadSeller(mySeller);
									mydata.loadBuyer(myBuyer);
									myScramble.random(Map,myBuyer,mySeller);
									continue;
								}
								
								case 8:
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
						System.err.println( "Invalid Input ");
					}
				}
			}
			
/*****************************************************************************************************
 * Method : Main method
 * Description : Calls the Choice method to run the buyer tool. 
 *  Input : N/A
 * Output : N/A
* */
			public static void main(String args[])				
			{
				Buy BuyerGUI = new Buy();
				BuyerGUI.makeGUI();
				//BuyerMain object=new BuyerMain();
				//object.Choice();
			}
		}
							
			
			

			




	
