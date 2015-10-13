/*******************************************************************************
 * Class : MapComponent
 * Date : December 5 2013
 * Description :- This class display world map with meteorites as a pin 
 * 				- BufferedImage image- image of world map
 * ArrayList<Pin>thesePins- ArrayList of meteorites as a pin
 * 			  
 * */


package datastore;



import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComponent;



public class MapComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	BufferedImage image;
	
	ArrayList <Pin> thesePins;
	
	
	/*******************************************************************************
	 * Method : MapComponent constructor
	 * Parameters; BufferedImage img- Image of world map
	 * Description : Displays world map image
	 * Input : N/A 
	 * OutPut : N/A
	 * */
	

	
	public MapComponent(BufferedImage img)
	{
		image=img;
		thesePins=new ArrayList<Pin>();
	}
	
	/*******************************************************************************
	 * Class : paint
	 * Description :- Draws new image for the world Map. 
	 * Output: N/A 
	 * Input : N/A
	 * 			  
	 * */
	public void paint(Graphics g) {
 
        g.drawImage(image, 0, 0, 800, 400, null);
        
        int pinLoop=0;
        int pinMax=0;
        
        Pin thisPin;
        
        
     
        
        pinMax=thesePins.size();
        for (pinLoop=0;pinLoop<pinMax;pinLoop++)
        {
        	thisPin=thesePins.get(pinLoop);
        	
 
        	
        	System.out.println(" x "+thisPin.pos.x);
        	System.out.println(" y "+thisPin.pos.y);
        	
        	
        	g.drawImage(thisPin.getIcon(),thisPin.pos.x,thisPin.pos.y,null);	
        }
        
        
        
        
    }

	  public Dimension getPreferredSize() {
	        if (image == null) {
	             return new Dimension(800,600);
	        } else {
	           return new Dimension(image.getWidth(null), image.getHeight(null));
	       }
	    }
	  
	  /*******************************************************************************
	   * Method : addPin
	   * Parameters : Pin myPin- Class pin that contains pin image
	   * Description : Add pin to arrayList<Pin> thesePins
	   * Inputs : N/A 
	   * Outputs : N/A
	   * ***********************************


*/
	public void addPin(Pin myPin) {
		// TODO Auto-generated method stub
		//Go away, you are bothering me. thisPin=myPin;
		thesePins.add(myPin);
	}    
}
	
	
	
	
