/*******************************************************************************
 * Class : SpaceJunk
 * Date : December 5, 2013
 * Description :- Child class of Meteorite class
 * 				- This class creates SpaceJunk meteorite object
 * 				- Overrides the price of parents class  
 * */
package datastore;

public class SpaceJunk extends Meteorite{

	/*******************************************************************************
	 *constructor : SpaceJunk
	 * */
	
	public SpaceJunk()
	{
	}

	/*******************************************************************************
	 * constructor : SpaceJunk
	 * Parameter : int MId,float MPrice, boolean MStatus, String MType
	 * Description : Calls the parent constructor 
	 * Input : N/A
	 * Output : N/A
	 * */
	
	public SpaceJunk( int MId,float MPrice,boolean MStatus,String MType)
	{
	super(MId,MPrice=10,MStatus,MType);
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
		if (Price>9)
		{
			return true;
		}
		else 
		{
			System.err.println(" Space Junk Price Should Be $ 10 Or More :");
			return false;
		}

}

}
