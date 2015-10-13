
/*******************************************************************************
 * Class : Chondrite
 * Date : December 5, 2013
 * Description :- Child class of Meteorite class
 * 				- This class creates Chondrite meteorite object
 * 				- Overrides the price of parents class  
 * */
package datastore;



public class Chondrite extends Meteorite
 {
	float price;
	
	/*******************************************************************************
	 *constructor : Chondrite
	 * */
	public Chondrite()
	{
		this.price=50;
	}
	
	/*******************************************************************************
	 * constructor : Chondrite
	 * Parameter : int MId,float MPrice, boolean MStatus, String MType
	 * Description : Calls the parent constructor 
	 * Input : N/A
	 * Output : N/A
	 * */
	public Chondrite ( int MId,float MPrice,boolean MStatus,String MType)
	{
		
		super( MId, MPrice=50, MStatus,MType);
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
		if (Price>49)
		{
			return true;
		}
		else 
		{
			System.err.println(" Chondrite Price Should Be $ 50 Or More :");
			// super(MId,MPrice=50,MStatus,MType);
			return false;
		}
	}
 }
	

