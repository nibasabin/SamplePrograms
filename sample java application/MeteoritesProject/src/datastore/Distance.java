/*******************************************************************************
 * Class : Distance			
 * Date : December 5, 2013
 * Description :- This class calculates the distance between the selected buyer and seller
 * Position myPosition : creates new Position object the position of meteorites
 * */


package datastore;
import java.util.Scanner;


import seller.SellerInfo;
import buyer.BuyerInfo;

public class Distance {
	
	/*******************************************************************************
	 * Method : totalDistance
	 * Parameters : objects of SellerInfo and BuyerInfo class
	 * Description: calculates the distance between the selected buyer and seller
	 * Input : buyer and seller position
	 * Output: total distance
	 * */
	
	public void totalDistance(SellerInfo mySeller,BuyerInfo myBuyer)
	{	String Seller=new String();
		String Buyer=new String();
	
		boolean flag= true;
		while (flag!=false)
		{
			System.out.println(" Do you want to measure the Distance ( Y / N ) :");
			Scanner myscanner;
			String question ;
			try {
				myscanner= new Scanner(System.in);
				question=myscanner.next();
				if (question.equals("Y") || (question.equals("y")))
				{
					boolean flag1= true;
					while(flag1!=false)
					{
						mySeller.sellerList();
						System.out.println();
						System.out.println(" Please Select A Seller ");
						
						try
						{
							Scanner scanner1= new Scanner(System.in);
						 Seller= scanner1.next();
							flag1=false;
						}
						catch(Exception e)
						{
							continue;
						}
					}
						
						boolean flag2= true;
						while(flag2!=false)
						{
							myBuyer.buyerList();
							System.out.println();
							System.out.println(" Please Select A Buyer ");
							try
							{
								Scanner scanner2= new Scanner(System.in);
								Buyer= scanner2.next();
								flag2=false;
							}
							catch(Exception e)
							{
								continue;
							}
							
						}
						
						int index1=0;
						int index2=0;
						for (int i= 0;i<mySeller.SellerArray.size();i++)
						{
							if(Seller.equals(mySeller.SellerArray.get(i).getName()))
							{
								index1=i;
							}
							
						}
						for (int j= 0;j<myBuyer.BuyerArray.size();j++)
						{
							if(Seller.equals(mySeller.SellerArray.get(j).getName()))
							{
								index2=j;
							}
							
						}
					
					
					float latitude1 = mySeller.SellerArray.get(index1).getLatitude();
					float longitude1 =mySeller.SellerArray.get(index1).getLongitude();
					float latitude2 = myBuyer.BuyerArray.get(index2).getLatitude();
					float longitude2 = myBuyer.BuyerArray.get(index2).getLongitude();
					float radius = (float) (3958.75);
					float lat = (float)(Math.toRadians(latitude2-latitude1));
					float lon = (float)(Math.toRadians(longitude2-longitude1));
					float a = (float)(Math.pow(Math.sin(lat/2), 2) + Math.pow(Math.sin(lon/2), 2)*Math.cos(Math.toRadians(latitude1))*Math.cos(Math.toRadians(latitude2)));
					float b = (float)(2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)));
					float distance = radius * b;
					System.out.println(" The distance between "+mySeller.SellerArray.get(index1).getName()+
							" and "+myBuyer.BuyerArray.get(index2).getName() +" is : " + distance +" Miles");
					
					flag=false;
					continue;
				}
				else if (question.equals("N")||(question.equals("n")))
				{
					flag=false;
					continue;
				}
				else 
				{
					System.err.println(" Invalid Input ");
					continue;
				}
				
				}
				catch(Exception e)
				{
					
				}
			}
	}
		
		
}
