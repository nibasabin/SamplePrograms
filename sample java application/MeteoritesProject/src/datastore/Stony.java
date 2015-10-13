/*******************************************************************************
 * Class : Stony
 * Date : December 5, 2013
 * Description :- Child class of Asteroidal class
 * 				- This class creates Stony meteorite object
 * 				- Overrides the price of parents class  
 * */

package datastore;
public class Stony extends Asteroidal
{

	/*******************************************************************************
	 *constructor : Stony
	 * */
	public Stony()
	{
	
	}

	/*******************************************************************************
	 * constructor : Stony
	 * Parameter : int MId,float MPrice, boolean MStatus, String MType
	 * Description : Calls the parent constructor 
	 * Input : N/A
	 * Output : N/A
	 * */
	
	public Stony( int MId,float MPrice,boolean MStatus,String MType)
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
			System.err.println(" Stony Price Should Be $ 500 Or More :");
			return false;
		}

}

}
