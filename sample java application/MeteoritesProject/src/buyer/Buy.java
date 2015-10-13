/*******************************************************************************
 * Class : Buy
 * Date : December 5, 2013
 * Description : This class allows the buyer to buy the meteorite
 * */

package buyer;
import datastore.WorldMap;
import seller.CreateMeteorite;
import seller.RealMap;
//import java.util.Scanner;

//public class Buy {
//CreateMeteorite myMeteorite=new CreateMeteorite();

/*******************************************************************************
 * Method: BuyMeteorite
 * Parameter : Object of WorldMap class
 * Description : Allows the buyer to buy the meteorite. Once the meteorite is sold It change is status. 
 * Input : N/A
 * Output : N/A
 * */

	
	//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Window;



	import javax.swing.*;

	import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.File;



import datastore.WMMTMain;
//	import datastore.WorldMap;
import datastore.SaveData;
import seller.SellerInfo;
//import seller.CreateMeteorite;
import datastore.Continent;
import seller.SingleTextMeteorite;
import datastore.Scramble;

	public class Buy extends JFrame implements ActionListener
	{
		WorldMap Map= new WorldMap();
		SaveData mySave= new SaveData();
		SellerInfo mySeller= new SellerInfo();
		BuyerInfo myBuyer= new BuyerInfo();
		CreateMeteorite myMeteorite= new CreateMeteorite();
		Continent myContinents= new Continent();
		SingleTextMeteorite OneMeteorite= new SingleTextMeteorite();
		Scramble myScramble= new Scramble();
		RealMap myMap= new RealMap();
		
		
		private static final long serialVersionUID = 1L;
		private JMenuItem loadMap,MScramble,Information,loadBuyer,loadMeteorites,saveMap,saveBuyer,saveMeteorites,exit,newBuyer,update, remove, HMeteorite, buyMeteorite, Mupdate,Mremove,OneLineMeteorite;
		
		/******************************************************************************
		 * Method : makeGUI
		 * Description : - This method creates GUI for the buyer menu.
		 * input :- N/A
		 * output :- N/A
		 * 				
		 * */
		
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
		loadBuyer= new JMenuItem (" Load Buyer "); 
		load.add(loadBuyer);
		loadBuyer.addActionListener(this);
		loadMeteorites= new JMenuItem (" Load Meteorites ");
		load.add(loadMeteorites);
		loadMeteorites.addActionListener(this);
		

		
		JMenu save= new JMenu(" Save ");
		file.add(save);
		saveMap= new JMenuItem(" Save Map ");
		save.add(saveMap);
		saveMap.addActionListener(this);
		saveBuyer= new JMenuItem(" Save Buyer ");
		save.add(saveBuyer);
		saveBuyer.addActionListener(this);
		saveMeteorites= new JMenuItem(" Save Meteorites ");
		save.add(saveMeteorites);
		saveMeteorites.addActionListener(this);
		
		
		exit= new JMenuItem(" Exit ");
		file.add(exit);
		exit.addActionListener(this);
		
		JMenu buyer=new JMenu( " The Buyer ");
		Menu.add(buyer);
		newBuyer= new JMenuItem (" Create Buyer ");
		buyer.add(newBuyer);
		newBuyer.addActionListener(this);
		update= new JMenuItem(" Update ");
		buyer.add(update);
		update.addActionListener(this);
		remove = new JMenuItem( " Remove a Buyer " );
		buyer.add (remove);
		remove.addActionListener(this);
		JMenu HMeteorites = new JMenu(" Handel Meteorites ");
		Menu.add(HMeteorites);
		
		buyMeteorite = new JMenuItem(" Buy Meteorite " );
		HMeteorites.add(buyMeteorite);
		buyMeteorite.addActionListener(this);

		JMenu scramble= new JMenu(" Scramble Menu ");
		Menu.add(scramble);
		MScramble= new JMenuItem(" Scramble ");
		scramble.add(MScramble);
		MScramble.addActionListener(this);
		
		JMenu about= new JMenu(" About ");
		Menu.add(about);
		Information= new JMenuItem(" Information ");
		about.add(Information);
		Information.addActionListener(this);   

		
		
		
		JFrame TFrame=new JFrame();


	    JLabel background=new JLabel(new ImageIcon("C:\\Users\\nibasabin\\Desktop\\e.jpg"));
	    TFrame.setResizable(false);
	   add(background);


		this.pack();
	
		this.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==loadMap)
	{
	
		myMap.method(Map);
	}
	else if (e.getSource()==loadBuyer)
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
	else if (e.getSource()==saveBuyer)
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
	else if( e.getSource()==newBuyer)
		{
		myBuyer.buyerInformation();
		}
	else if (e.getSource()==update)
	{
		myBuyer.buyerUpdate();
	}

	else if (e.getSource()==remove)
	{
		myBuyer.buyerRemove();
	}

	else if (e.getSource()==buyMeteorite)
	{
		BuyMeteorite(Map);
		
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
	else if(e.getSource()==MScramble)
	{
		myScramble.random(Map, myBuyer, mySeller);
	}
	else if (e.getSource()==Information)
	{ 
		mySeller.about();
		
	}
	
	
	}



	

	/******************************************************************************
	 * Method : BuyMeteorite
	 * Parameter : WorldMap object
	 * Description : - This method allows the buyer to buy the meteorite
	 * 
	 * 				
	 * */


	public void BuyMeteorite(WorldMap newMap)		
		{
		boolean result=false;
		int size= Map.Array.size();
		String MArray[]= new String[size+1];
		
		for(int i=0; i<Map.Array.size();i++)
			{
				String Id= Integer.toString(Map.Array.get(i).getId());
				MArray[0]=" None ";
				MArray[i+1] ="Id #"+ Id + " Meteorite Type : " +Map.Array.get(i).getType();
			}
			
		JComboBox JType= new JComboBox(MArray);
		JType.setSelectedIndex(Map.Array.size()-1);
		final JComponent[] inputs = new JComponent[] {new JLabel(" Please Select Meteorite To Update "),JType };
		JOptionPane.showMessageDialog(null, inputs, " Meteorite List ", JOptionPane.PLAIN_MESSAGE);
		JType.addActionListener(this);
		int index=JType.getSelectedIndex();
		
		String Type= MArray[index];
		int temp = 0;
		for(int i=0;i<Map.Array.size();i++)
		{
			if (Type.equals("Id #"+ Map.Array.get(i).getId() + " Meteorite Type : " +Map.Array.get(i).getType()))
			{
				temp=i;
				result=true;
				System.out.println("Array no "+temp);
			}
			
		}
				if(result!=false)
					{
						newMap.Array.get(temp).setStatus(false);
						JOptionPane.showMessageDialog(null," Congratulations You Just Bought A Meteorite ", " Message ", JOptionPane.PLAIN_MESSAGE);
						
						System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
						System.out.println("++   Congratulations You Just Bought A Meteorite   ++");
						System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
						System.out.print("\n\n");
						
			
					
				}
				else
				{
					System.err.println("No Matching ID Found");
					
				}
			}
	}
	
		

		
		

	


	

	
