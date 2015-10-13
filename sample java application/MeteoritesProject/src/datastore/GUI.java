
/*******************************************************************************
 * Class : GUI
 * Date : December 5, 2013
 * Description :- This Class creates all the main components of GUI.
 * 				- This class creates the JMenu, JMenuItem and performs the action 
 * 				- given to the action listener.
 * */


package datastore;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import datastore.WorldMap;
import datastore.SaveData;
import seller.SellerInfo;
import seller.CreateMeteorite;
import datastore.Continent;
import seller.SingleTextMeteorite;
import  seller.RealMap;


public class GUI extends JFrame implements ActionListener
{
	WorldMap Map= new WorldMap();
	SaveData mySave= new SaveData();
	SellerInfo mySeller= new SellerInfo();
	CreateMeteorite myMeteorite= new CreateMeteorite();
	Continent myContinents= new Continent();
	SingleTextMeteorite OneMeteorite= new SingleTextMeteorite();
	RealMap myMap= new RealMap();
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuItem loadMap,Information,loadSeller,loadMeteorites,saveMap,saveSeller,saveMeteorites,exit,newSeller,update, remove, HMeteorite, newMeteorite, Mupdate,Mremove,OneLineMeteorite;
	
	
	/**
	 * Method : makeGUI
	 * Parameters : 
	 * Description: creates the JFrame, JMenu, JMenuItems.
	 * Input : N/A
	 * Output: N/A
	 */
	public void makeGUI()
	{
		
	this.setTitle(" Main Menu ");
	JMenuBar Menu= new JMenuBar();
	this.setJMenuBar(Menu);
	JMenu file= new JMenu(" File ");
	Menu.add(file);
	JMenu load= new JMenu(" Load ");
	file.add(load);
	loadMap= new JMenuItem(" Load Map ");
	load.add(loadMap);
	loadMap.addActionListener(this);
	loadSeller= new JMenuItem (" Load Seller "); 
	load.add(loadSeller);
	loadSeller.addActionListener(this);
	loadMeteorites= new JMenuItem (" Load Meteorites ");
	load.add(loadMeteorites);
	loadMeteorites.addActionListener(this);
	

	
	JMenu save= new JMenu(" Save ");
	file.add(save);
	saveMap= new JMenuItem(" Save Map ");
	save.add(saveMap);
	saveMap.addActionListener(this);
	saveSeller= new JMenuItem(" Save Seller ");
	save.add(saveSeller);
	saveSeller.addActionListener(this);
	saveMeteorites= new JMenuItem(" Save Meteorites ");
	save.add(saveMeteorites);
	saveMeteorites.addActionListener(this);
	
	
	exit= new JMenuItem(" Exit ");
	file.add(exit);
	exit.addActionListener(this);
	
	JMenu seller=new JMenu( " The Seller ");
	Menu.add(seller);
	newSeller= new JMenuItem (" Create Seller ");
	seller.add(newSeller);
	newSeller.addActionListener(this);
	update= new JMenuItem(" Update ");
	seller.add(update);
	update.addActionListener(this);
	remove = new JMenuItem( " Remove a Seller " );
	seller.add (remove);
	remove.addActionListener(this);
	JMenu HMeteorites = new JMenu(" Handel Meteorites ");
	Menu.add(HMeteorites);
	newMeteorite = new JMenuItem(" Create Meteorite " );
	HMeteorites.add(newMeteorite);
	newMeteorite.addActionListener(this);
	Mupdate = new JMenuItem (" Update Meteorite "); 
	HMeteorites.add(Mupdate);
	Mupdate.addActionListener(this);
	Mremove = new JMenuItem ( " Remove Meteorite ");
	HMeteorites.add(Mremove);
	Mremove.addActionListener(this);
	
	OneLineMeteorite= new JMenuItem(" Create Meteorite on One line ");
	HMeteorites.add(OneLineMeteorite);
	OneLineMeteorite.addActionListener(this);
	
	JMenu about= new JMenu(" About ");
	Menu.add(about);
	Information= new JMenuItem(" Information ");
	about.add(Information);
	Information.addActionListener(this);   

	
	
	
	JFrame TFrame=new JFrame();


    JLabel background=new JLabel(new ImageIcon("/Users/nibasabin/Documents/workspace/project phase 3/MeteoritesProject/src/space.jpg"));
    TFrame.setResizable(false);
   add(background);


	this.pack();
	//this.setSize(new Dimension(640,480));
	this.setVisible(true);
	
}


@Override
public void actionPerformed(ActionEvent e) {
if(e.getSource()==loadMap)
{
	myMap.method(Map);

	
}
else if (e.getSource()==loadSeller)
{
	mySave.loadSeller(mySeller);
	
}
else if (e.getSource()==loadMeteorites)
{
	mySave.loadMap(Map);
}
else if (e.getSource()== saveMap)
{
	mySave.saveMap(Map);
}
else if (e.getSource()==saveSeller)
{
	mySave.saveSeller(mySeller);
}
else if (e.getSource()==saveMeteorites)
{
	mySave.saveMap(Map);
	
}
else if( e.getSource()== exit)
{
	
	System.exit(0);
}
else if( e.getSource()==newSeller)
	{
	mySeller.sellerInformation();
	}
else if (e.getSource()==update)
{
	mySeller.sellerUpdate();
}

else if (e.getSource()==remove)
{
	mySeller.sellerRemove();
}

else if (e.getSource()==newMeteorite)
{
	myMeteorite.meteorite(Map);

}
else if (e.getSource()==Mupdate)
{
	myMeteorite.printArrayList(Map);
	myMeteorite.update(Map);
}
else if (e.getSource()==Mremove)
{	myMeteorite.printArrayList(Map);
	myMeteorite.remove(Map);
}
else if(e.getSource()==OneLineMeteorite)
{
	OneMeteorite.CreateMeteoriteOneLine(Map);

}
else if (e.getSource()==Information)
{ 
	mySeller.about();
	
}

}



}