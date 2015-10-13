
/*******************************************************************************
 * Class : Achondrite
 * Date : December 5, 2013
 * Description :- Child class of Meteorite class
 * 				- This class creates Achondrite meteorite object
 * 				- Overrides the price of parents class  
 * */
package datastore;

public class Achondrite extends Meteorite{

	/*******************************************************************************
	 *constructor : Achondrite
	 * */
	public Achondrite()
	{
		
	}
	
	/*******************************************************************************
	 * constructor : Achondrite
	 * Parameter : int MId,float MPrice, boolean MStatus, String MType
	 * Description : Calls the parent constructor 
	 * Input : N/A
	 * Output : N/A
	 * */
	
	public Achondrite( int MId,float MPrice,boolean MStatus,String MType)
	{
		super(MId,MPrice=150,MStatus,MType);
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
		if (Price>149)
		{
			return true;
		}
		else 
		{
			System.err.println(" Achondrite Price Should Be $ 150 Or More :");
			return false;
		}

}
}

