/**********************************************************************************************************************
 * Class : Position
 * Date : December 5, 2013
 * Description : This class creates an object of class Position which is used to assign position of meteorite.
 * 
 * */

package datastore;

import javax.swing.JOptionPane;

public class Position {
	

		private float Longitude;
		private float Latitude;
		
		/*******************************************************************************
		 *Constructor : Position
		 * */
		
		public Position()
		{
			Longitude=0;
			Latitude=0;
		}
		
		/*******************************************************************************
		 *Constructor : Position
		 *Parameters : float myLongitude,float myLatitude
		 * */
		
		public Position(float myLongitude,float myLatitude)
		{
			this.Longitude=myLongitude;
			this.Latitude=myLatitude;
		}
		
		/*******************************************************************************
		 * Method : getLongitude
		 * Description: Gets Longitude of Meteorite
		 * Input : N/A
		 * Output: N/A
		 * */
		
		public float getLongitude()
		{
			
			return Longitude;
		}
		
		/*******************************************************************************
		 * Method : setLongitude
		 * Description: Sets Longitude of Meteorite
		 * Parameter : float longitude
		 * float longitude : longitude of meteorite
		 * Input : N/A
		 * Output: N/A
		 * */
		public boolean setLongitude(float Longitude)
		{ 
			if ((Longitude>=-800) && (Longitude<=800))
			{
			this.Longitude=Longitude;
			return true;
			}
			else
			{
			JOptionPane.showMessageDialog(null," Longitude Out Of Range ","Error",JOptionPane.ERROR_MESSAGE);
			System.out.println(Longitude);
			System.err.println(" Longitude Out Of Range ");
			return false;
			}
			
			
		}
		
		/*******************************************************************************
		 * Method : getLatitude
		 * Description: Gets Latitude of Meteorite
		 * Input : N/A
		 * Output: N/A
		 * */
		
		public float getLatitude()
		{
			
			return Latitude;
		}
		/*******************************************************************************
		 * Method : setPrice
		 * Description: Sets price of Meteorite
		 * Parameter : float Price 
		 * float Price : Price of meteorite
		 * Input : N/A
		 * Output: N/A
		 * */
		public boolean setLatitude(float Latitude)
		{
			if ((Latitude>=-400)&& (Latitude<=400))
			{
				this.Latitude=Latitude;
				return true;
			}
			else 
			{	JOptionPane.showMessageDialog(null," Latitude Out Of Range ","Error",JOptionPane.ERROR_MESSAGE);
			System.out.println(Latitude);
				System.err.println(" Latitude Out Of Range");
				return false;
			}
		}

	}


