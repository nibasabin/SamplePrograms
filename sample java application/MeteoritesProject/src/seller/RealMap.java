/*******************************************************************************
 * Class : RealMap
 * Date : December 5, 2013
 * Description :- This class excess the world map of nassa and points the meteorites that is created or loaded.
 * 				
 * */



package seller;

import javax.swing.JFrame;

import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.PointPlacemark;
import datastore.WorldMap;

public class RealMap {
	
	/*******************************************************************************
	 * Method : method
	 * Paramether : WorldMap object
	 * Date : December 5, 2013
	 * Description :- This class creates a frame for the world map an pins the meteorite on world map.
	 * 				
	 * */

	
	public void method( WorldMap map)
	{
		WorldWindowGLCanvas myWorld= new WorldWindowGLCanvas();
		myWorld.setModel(new BasicModel());
		JFrame Frame = new JFrame();
		Frame.add(myWorld);
		Frame.setVisible(true);
		Frame.setSize(800,800);
		for(int i=0; i<map.Array.size();i++)
		{
		float longitude= map.Array.get(i).getLongitude();
		float latitude= map.Array.get(i).getLatitude();
		Position myPosition= Position.fromDegrees(latitude,longitude);
		PointPlacemark myMark= new PointPlacemark(myPosition);
		RenderableLayer myLayer= new RenderableLayer();
		myLayer.addRenderable(myMark);
		myWorld.getModel().getLayers().add(myLayer);
	}
	}

}
