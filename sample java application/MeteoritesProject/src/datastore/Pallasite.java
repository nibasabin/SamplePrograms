/*******************************************************************************
 * Class : Pallasite
 * Date : December 5, 2013
 * Description :- Child class of StonyIron class
 * 				- This class creates Pallasite meteorite object
 * 				- Overrides the price of parents class  
 * */
package datastore;
public class Pallasite extends StonyIron
{
	
	/*******************************************************************************
	 *constructor : Pallasite
	 * */
	public Pallasite()
	{

	}
	
	/*******************************************************************************
	 * constructor : Pallasite
	 * Parameter : int MId,float MPrice, boolean MStatus, String MType
	 * Description : Calls the parent constructor 
	 * Input : N/A
	 * Output : N/A
	 * */
	
	public Pallasite( int MId,float MPrice,boolean MStatus,String MType)
	{
		super(MId,MPrice=1000,MStatus,MType);
	}
	
	/*******************************************************************************
	 * Method: setPrice
	 * Parameter :float myPrice
	 * Description : Overrides the parent class price for object of this class
	 * float myPrice : Price for the object of this class
	 * Input : N/A
	 * Output : N/A
	 * */
	
	public boolean setPrice(float myPrice)
	{
		this.Price=myPrice;
		if (Price>999)
		{
			return true;
		}
		else 
		{
			System.err.println(" Pallasite Price Should Be $ 1000 Or More :");
			return false;
		}

}

}
