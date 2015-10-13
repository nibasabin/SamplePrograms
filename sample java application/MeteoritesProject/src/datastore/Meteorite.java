/*******************************************************************************
 * Class : Meteorite
 * Date : December 5, 2013
 * Description :- This class creates an object of this class. 
 * Position myPosition : creates new Position object the position of meteorites
 * float Price : Price of the meteorite
 * int Id : Id of the meteorite
 * String Type : Type of meteorite
 * boolean Status : Status of the meteorite if available or not
 * */

package datastore;

public class Meteorite {
	protected Position myPosition= new Position();
	protected float Price;
	protected int Id;
	protected String Type;
	
	protected boolean Status;
	
	/*******************************************************************************
	 *Constructor : Meteorite 
	 * */
	public Meteorite()
	{
		Id=0;
		Price=0;
		myPosition.setLongitude(0);
		myPosition.setLatitude(0);
		Type="Unknown";
		Status=true;
	}
	/*******************************************************************************
	 *Constructor : Meteorite 
	 *Parameters : int MId, float MPrice,boolean MStatus, String MType
	 * */
	public Meteorite( int MId,float MPrice,boolean MStatus,String MType)
	{
	
		this.Id=MId;
		this.Price=MPrice;
		this.Type=MType;
		this.Status=MStatus;
	}
	/*******************************************************************************
	 * Method : getPrice
	 * Description: Gets price of Meteorite
	 * Input : N/A
	 * Output: N/A
	 * */
	public float getPrice()
	{
		return Price;
	}
	/*******************************************************************************
	 * Method : setPrice
	 * Description: Sets price of Meteorite
	 * Parameter : float Price 
	 * float Price : Price of meteorite
	 * Input : N/A
	 * Output: N/A
	 * */
	public boolean setPrice(float Price)
	{
		this.Price= Price;
		return true;
	}
	
	/*******************************************************************************
	 * Method : getId
	 * Description: Gets Id of Meteorite
	 * Input : N/A
	 * Output: N/A
	 * */
	public int getId()
	{
		return Id;
	}
	
	/*******************************************************************************
	 * Method : setId
	 * Description: Sets Id of Meteorite
	 * Parameter : int Id 
	 * float Price : Id of meteorite
	 * Input : N/A
	 * Output: N/A
	 * */
	public boolean setId(int MyId)
	{
		this.Id=MyId;
		return true;
	}
	/*******************************************************************************
	 * Method : getLongitude
	 * Description: Gets Longitude of Meteorite
	 * Input : N/A
	 * Output: N/A
	 * */
	public float getLongitude()
	{
		return myPosition.getLongitude();
	}
	/*******************************************************************************
	 * Method : getLatitude
	 * Description: Gets Latitude of Meteorite
	 * Input : N/A
	 * Output: N/A
	 * */
	public float getLatitude()
	{
		return myPosition.getLatitude();
	}
	/*******************************************************************************
	 * Method : setLongitude
	 * Description: Sets Longitude of Meteorite
	 * Parameter : float Longitude
	 * float Longitude : Longitude of meteorite
	 * Input : N/A
	 * Output: N/A
	 * @return 
	 * */
	public boolean setLongitude(float Longitude)
	{
		return this.myPosition.setLongitude(Longitude);
	}
	/*******************************************************************************
	 * Method : setLatitude
	 * Description: Sets Latitude of Meteorite
	 * Parameter : float Latitude
	 * float Latitude : Latitude of meteorite
	 * Input : N/A
	 * Output: N/A
	 * @return 
	 * */
	public boolean setLatitude(float Latitude)
	{
		return this.myPosition.setLatitude(Latitude);
		
	}
	public String getType()
	{
	return Type;
	}
	/*******************************************************************************
	 * Method : setType
	 * Description: Sets Type of Meteorite
	 * Parameter : String Type
	 * String type : Type of meteorite
	 * Input : N/A
	 * Output: N/A
	 * */
	public String setType(String Type)
	{
	
		if (Type.equals("Chondrite"))
		{
			this.Type="Chondrite";
			
		}
		else if (Type.equals("Achondrite"))
		{
			this.Type="Achondrite";
		}
		else if (Type.equals("Lunar-Achondrite"))
		{
			this.Type="Lunar-Achondrite";
		}
		else if (Type.equals("Martian-Achondrite"))
		{
			this.Type="Martian-Achondrite";
		}
		else if (Type.equals("Asteroidal-Achondrite"))
		{
			this.Type="Asteroidal-Achondrite";
		}
		else if (Type.equals("Iron"))
		{
			this.Type="Iron";
		}
		
		else if (Type.equals("Stony"))
		{
			this.Type="Stony";
		}
		else if (Type.equals("Stony-Iron"))
		{
			this.Type="Stony-Iron";
		}
		else if (Type.equals("Pallasite"))
		{
			this.Type="Pallasite";
		}
		else if (Type.equals("SpaceJunk"))
		{
			this.Type="SpaceJunk";
		}
		else
		{
			System.err.println(" Meteorite Type Not Found :");
		}
		return Type;
	
	}
	
	/*******************************************************************************
	 * Method : getStatus
	 * Description: Gets Status of Meteorite
	 * Input : N/A
	 * Output: N/A
	 * */
	public boolean getStatus()
	{
		return Status;
	}
	/*******************************************************************************
	 * Method : setStatus
	 * Description: Sets Status of Meteorite
	 * Parameter : boolean Type
	 * boolean type : status of meteorite
	 * Input : N/A
	 * Output: N/A
	 * */
	public boolean setStatus(boolean Status)
	{
		this.Status=Status;
		return true;
	}



}

