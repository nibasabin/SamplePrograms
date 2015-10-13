
/*******************************************************************************
 * Class : WMMTMain
 * Date : December 5, 2013
 * Description :- this class creates the buffer image of world map an then creates a frame to display the 
 * 				- the world map.
 * */

package datastore;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WMMTMain extends JFrame {


	private static final long serialVersionUID = 1L;
	JPanel mapPanel;
	MapComponent mapComponent;
	
	public WMMTMain()
	{
	mapPanel=new JPanel();
	mapPanel.setLayout(new BorderLayout());
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.add(mapPanel);
	this.pack();
	this.setSize(new Dimension (800,400));
	this.setVisible(true);

	
	}
	

/*******************************************************************************
 * Method: go
 * parameter : worldMap object
 * Date : December 5, 2013
 * Description :- this class creates the buffer image of world map.
 * Input : N/A
 * Output : N/A
 * 			
 * */

	

	
	public void go(WorldMap myMap)
	{
		File mapFile=null;
		BufferedImage mapImage=null;
		try
		{
			mapFile=new File("C:\\Users\\nibasabin\\Desktop\\Phase3\\WorldMap.png");
			mapImage=ImageIO.read(mapFile);
		}
		catch(Exception e)
		{
			
		}
		
		mapComponent=new MapComponent(mapImage);
		mapPanel.add(mapComponent);
		
		Pin myPin=null;
		
		int pinLoop=0;
		float x=0;
		float y=0;
		boolean sold=false;
		
		System.out.println(" latitude"+x);
		System.out.println("longitude"+y);
		System.out.println(" Arraysize"+myMap.Array.size());
		for (pinLoop=0;pinLoop<myMap.Array.size();pinLoop++)
		{	
			x=myMap.Array.get(pinLoop).getLongitude();
			y=myMap.Array.get(pinLoop).getLatitude();
			
			
			System.out.println(" latitude"+x);
			System.out.println("longitude"+y);
			sold=myMap.Array.get(pinLoop).getStatus();
			myPin=new Pin((int)(x-13),(int)(y-20),sold);
		
			mapComponent.addPin(myPin);
		}
		
		validate();
		repaint();
		
	}

}