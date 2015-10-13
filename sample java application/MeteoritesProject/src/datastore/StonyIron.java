/*******************************************************************************
 * Class : StonyIron
 * Date : December 5, 2013
 * Description :- Child class of Asteroidal class
 * 				- This class creates StonyIron meteorite object
 * 				- Overrides the price of parents class  
 * */

package datastore;
public class StonyIron extends Asteroidal {

/*******************************************************************************
 *constructor : StonyIron
 * */
	
	public StonyIron()
	{
		
	}
	
/*******************************************************************************
 * constructor : StonyIron
 * Parameter : int MId,float MPrice, boolean MStatus, String MType
 * Description : Calls the parent constructor 
 * Input : N/A
 * Output : N/A
 * */
	
	public StonyIron( int MId,float MPrice,boolean MStatus,String MType)
	{
		super(MId,MPrice=500,MStatus,MType);
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
		if (Price>499)
		{
			return true;
		}
		else 
		{
			System.err.println(" StonyIron Price Should Be $ 500 Or More :");
			return false;
		}

}

}
