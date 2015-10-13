/*******************************************************************************
 * Class : Asteroidal
 * Date : December 5, 2013
 * Description :- Child class of Achondrite class
 * 				- This class creates Asteroidal meteorite object
 * 				- Overrides the price of parents class  
 * */

package datastore;

public class Asteroidal extends Achondrite
{
	/*******************************************************************************
	 *constructor : StonyIron
	 * */
	
	public Asteroidal()
	{
		
	}
	
	/*******************************************************************************
	 * constructor : Asteroidal
	 * Parameter : int MId,float MPrice, boolean MStatus, String MType
	 * Description : Calls the parent constructor 
	 * Input : N/A
	 * Output : N/A
	 * */
	
	public Asteroidal( int MId,float MPrice,boolean MStatus,String MType)
	{
		super( MId,MPrice=250,MStatus,MType);
	}
	
	/*******************************************************************************
	 * Method: setPrice
	 * Parameter :float myPrice
	 * Description : Overrides the parent class price for object of this class
	 * float myPrice : Price for the object of this class
	 * Input : N/A
	 * Output : N/A
	 * */
@Override

	public boolean setPrice(float myPrice)
	{
		this.Price=myPrice;
		if (Price>249)
		{
			return true;
		}
		else 
		{
			System.err.println(" Asteroidal Price Should Be $ 250 Or More :");
			return false;
		}

}

}
