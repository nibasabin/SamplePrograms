/*******************************************************************************
 * Class : buyerInfo
 * Date : December 5, 2013
 * Description : This class creates a Buyer which represents name and location
 * String name : buyer name
 * float Longitude : Buyer's Longitude coordinate
 * float Latitude : Buyer's Latitude coordinate
 * */



package buyer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



	public class BuyerInfo extends JFrame implements ActionListener
	{
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		protected String Name;
		protected float Longitude; 
		protected float Latitude;
		protected boolean Status;
		public ArrayList <BuyerInfo> BuyerArray= new ArrayList<BuyerInfo>();
	
	
	/*********************************************************************************
	 * Constructor
	 * Description : Initialize Buyer's Name and Location
	 */
	public BuyerInfo()
	{
		Name="Unknown";
		Longitude= 0;
		Latitude=0;
		Status=true;
	}

	/*********************************************************************************
	 * Method : getName
	 * Description : Takes Buyer Name
	 * returns : Buyer Name
	 */
	public String getNames()
	{
		return Name;
	}
	
	/*********************************************************************************
	 * Method : setName
	 * Description : Set's Buyer Name
	 * returns : Boolean
	 * @return 
	 */
	
	public boolean setNames(String myName)
	{
		this.Name=myName;
		return true;
	}
	
	/*********************************************************************************
	 * Method : getLongitude
	 * Description : Gets Buyer Longitude
	 * returns : Buyer Longitude
	 */
	public float getLongitude()
	{
		return Longitude;
	}
	
	/*********************************************************************************
	 * Method : setLongitude
	 * Description : Set Buyer Longitude
	 * returns : Boolean
	 */
	
	public boolean setLongitude(float myLongitude)
	{	if ((myLongitude>=-180) && (myLongitude<=180))
		{
		this.Longitude=myLongitude;
		return true;
		}
		else
		{
		JOptionPane.showMessageDialog(null," Longitude Out Of Range ","Error",JOptionPane.ERROR_MESSAGE);
		System.err.println(" Longitude Out Of Range ");
		return false;
		}
	}
	
	/*********************************************************************************
	 * Method : getLatitude
	 * Description : Gets Buyer Latitude
	 * returns : Buyer Latitude
	 */
	
	public float getLatitude()
	{
		return Latitude;
	}
	
	/*********************************************************************************
	 * Method : setLatitude
	 * Description : Set Buyer Latitude
	 * returns : Boolean
	 */
	
	public boolean setLatitude(float myLatitude)
	{	
		if ((myLatitude>=-90)&& (myLatitude<=90))
		{
			this.Latitude=myLatitude;
			return true;
		}
		else 
		{	JOptionPane.showMessageDialog(null," Latitude Out Of Range ","Error",JOptionPane.ERROR_MESSAGE);
			System.err.println(" Latitude Out Of Range");
			return false;
		}
	}
	

	/*********************************************************************************
	 * Method : getStatus()
	 * Description :Gets the status of the Buyer
	 * Input :N/A
	 * Output : N/A
	 */
	
	public boolean getStatus()
	{
		return Status;
	}
	
	/*********************************************************************************
	 * Method : setStatus()
	 * Description :set's the status of the Buyer
	 * Input :N/A
	 * Output : N/A
	 */
	public boolean setStatus(boolean Status)
	{
		this.Status=Status;
		return true;
	}


	
	/*********************************************************************************
	 * Method : sellerInformation
	 * Description : Creates Buyer with a single line input of string.
	 * 				 String is then tokenized
	 * 				 Name stored as String 
	 * 				 Longitude and Latitude stored as float value.
	 * String Name : Name of Buyer
	 * String Longitude : Longitude coordinate of Buyer
	 * String Latitude : Latitude coordinate of Buyer
	 */
	
	public void buyerInformation()
	{	
		String Name = null;
		String Longitude = null;
		String Latitude=null;
		BuyerInfo myBuyer= new BuyerInfo();
	//	Scanner myScanner= new Scanner(System.in);
		System.out.print("\n\n");
		System.out.println ("************************************");
		System.out.println("* Welcome To U.T.A METEORITE STORE *");
		System.out.println("************************************");
		System.out.println("");
		boolean done=false;
		boolean done1=false;
		boolean done2=false;
		while(!done)
		{	
			
			
			JTextField JName = new JTextField();
			JTextField JLongitude = new JTextField();
			JTextField JLatitude = new JTextField();
			final JComponent[] input = new JComponent[] {new JLabel(" Buyer Name"),JName,new JLabel(" Longitude "),JLongitude,new JLabel(" Latitude "),JLatitude };
			JOptionPane.showMessageDialog(null, input, " Create Buyer ", JOptionPane.PLAIN_MESSAGE);
			
		try
			{
				Name=JName.getText();
				Longitude=JLongitude.getText();
				Latitude= JLatitude.getText();

			
				if (Longitude.equals("")|| Latitude.equals("")||Name.equals(""))
				{
					JOptionPane.showMessageDialog(null," Complete Information Not Provided ", " Message ", JOptionPane.PLAIN_MESSAGE);
					JOptionPane.showMessageDialog(null," Buyer Not Created  ", " Message ", JOptionPane.PLAIN_MESSAGE);
					System.out.println(" longitude empty");	
					done=true;
				
				}
				else
				{
					myBuyer.setNames(Name);
					done1=myBuyer.setLongitude(Float.parseFloat(Longitude));
					done2=myBuyer.setLatitude(Float.parseFloat(Latitude));
					if (done1 && done2==true)
					{
						myBuyer.setLongitude(Float.parseFloat(Longitude));
						myBuyer.setLatitude(Float.parseFloat(Latitude));
						myBuyer.setStatus(true);
						BuyerArray.add(myBuyer);
						JOptionPane.showMessageDialog(null, " New Buyer Successfully Created ", " Message ", JOptionPane.PLAIN_MESSAGE);
						done=true;
					}
					else
					{
						continue;
					}
					
			}
			}
		
			
		catch (Exception e)
			{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null," No Buyer Created : ","Message",JOptionPane.ERROR_MESSAGE);
			done=true;
			}
			
		}
	}
	
	/*********************************************************************************
	 * Method : sellerList
	 * Description : Prints the list of Buyer's 
	 * Input : N/A
	 * Output : List of Buyer's
	 */

	
		
	public void buyerList()
{
	if (BuyerArray.size()==0)
	{
		System.err.println(" No Buyer On The File ");
	}
	else
	{
		for(int i=0;i<BuyerArray.size();i++)
		{
			System.out.println( " Buyer Name : "+BuyerArray.get(i).getNames());
			System.out.println( " Longitude : "+BuyerArray.get(i).getLongitude());
			System.out.println( " Latitude : "+ BuyerArray.get(i).getLatitude());
			System.out.println();
		}
	}
}
	public void buyerUpdate()
	{
		System.out.println("Buyer Array size"+BuyerArray.size());
		boolean question=true;
		boolean result=false;
		String Name=null;
		int temp = 0;
			
			if(BuyerArray.size()!=0)
			{
				int size= BuyerArray.size();
				String MArray[]= new String[size+1];
				
				for(int i=0; i<BuyerArray.size();i++)
					{
						Name= (BuyerArray.get(i).getNames());
						MArray[0]=" None ";
						MArray[i+1] =Name;
					}
					
				JComboBox JType= new JComboBox(MArray);
				JType.setSelectedIndex(BuyerArray.size()-1);
				final JComponent[] inputs = new JComponent[] {new JLabel(" Please Select Buyer To Update "),JType };
				JOptionPane.showMessageDialog(null, inputs, " Buyer List ", JOptionPane.PLAIN_MESSAGE);
				JType.addActionListener(this);
				
				int index=JType.getSelectedIndex();
				String Type= MArray[index];
					
				
				for(int i=0;i<BuyerArray.size();i++)
				{
					System.out.println(Type);
					System.out.println(BuyerArray.get(i).getNames());
					if (Type.equals(BuyerArray.get(i).getNames()))
					{
						temp=i;
						System.out.println("Array no "+temp);
						result= true;
					}
					
				}
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(null," Buyer Record Empty","Message", JOptionPane.PLAIN_MESSAGE);
				System.err.println(" Buyer List Empty");
				question=false;
				
			}
	
			if (result==false)
			{
				JOptionPane.showMessageDialog(null," No Matching Buyer Found "," Message ",JOptionPane.PLAIN_MESSAGE);
				question=false;
			}
			else
			{
				
				String Longitude= null;
				String Latitude= null;
				boolean flag1=false;
				boolean flag2=false;
				while (question!=false)
				{
					if (result!=false)
					{
					
					JTextField JName = new JTextField();
					JTextField JLongitude = new JTextField();
					JTextField JLatitude = new JTextField();
					final JComponent[] inputs = new JComponent[] {new JLabel(" Buyer Name"),JName,new JLabel(" Longitude "),JLongitude,new JLabel(" Latitude "),JLatitude };
					JOptionPane.showMessageDialog(null, inputs, " Update Buyer ", JOptionPane.PLAIN_MESSAGE);
					Name=JName.getText();
					Longitude= JLongitude.getText();
					Latitude = JLatitude.getText();
					if (Longitude.equals("")|| Latitude.equals("") || Name.equals(""))
					{	
						JOptionPane.showMessageDialog(null,"Complete Information Not Provided"," Message ",JOptionPane.PLAIN_MESSAGE);
						JOptionPane.showMessageDialog(null," Buyer Not Updated "," Message ",JOptionPane.PLAIN_MESSAGE);
						question=false;//continue;
					}
					else
					{
						flag1=BuyerArray.get(temp).setLongitude(Float.parseFloat(Longitude));
						flag2=BuyerArray.get(temp).setLatitude(Float.parseFloat(Latitude));
						if (flag1 && flag2  == true)
						{
							BuyerArray.get(temp).setLongitude(Float.parseFloat(Longitude));
							BuyerArray.get(temp).setLatitude(Float.parseFloat(Latitude));
							BuyerArray.get(temp).setNames(Name);
							question=false;
						}
						else
						{
							continue;
						}
						
						
							
					JOptionPane.showMessageDialog(null," Buyer Successfully Updated", " Message ", JOptionPane.PLAIN_MESSAGE);
					
				
				}
					}
				}
			}
	}
			
					
	
	
	
	public void buyerRemove()
	{
		
		
		
		boolean question=true;
		String Name=null;
			
			if(BuyerArray.size()!=0)
			{
				JTextField SName= new JTextField();
				final JComponent[] search= new JComponent[] { new JLabel(" Search Seller "),SName};
				JOptionPane.showMessageDialog(null, search, " Update Seller ", JOptionPane.PLAIN_MESSAGE);
				//System.out.println(" dfalkjfalkjfdalkfja");
				Name= SName.getText();
				
			}
			else
			{
				JOptionPane.showMessageDialog(null," Seller Record Empty","Message", JOptionPane.PLAIN_MESSAGE);
				System.err.println(" Seller List Empty");
				question=false;
				
			}
			boolean result=false;
			int temp=0;
			for(int i=0;i<BuyerArray.size();i++)
			{	
				if(Name.equals(BuyerArray.get(i).getNames()))
				{
					temp=i;
					result=true;
				}
			}
	
			if (result==false)
			{
				JOptionPane.showMessageDialog(null," No Matching Seller Found "," Message ",JOptionPane.PLAIN_MESSAGE);
				question=false;
			}
			else
			{
			BuyerArray.remove(temp);
			JOptionPane.showMessageDialog(null," Seller Successfully Removed "," Message ",JOptionPane.PLAIN_MESSAGE);
			
			}
	}
	 public void about()
	 {
		
				JTextArea text= new JTextArea("           Author \n"
						+ "Sabin Raj Bajracharya \n"
						+ "1000862596 \n"
						+ "Pranil Maharjan \n"
						+ "1000862596 \n"
						+ "November 24, 2013");
				text.setEditable(false);
				JPanel P= new JPanel();
				
			//	add(image);
				//JImageComponent ic = new JImageComponent(myImageGoesHere);
			//	imagePanel.add(ic);
				//author.setIcon(new ImageIcon("C:\\Users\\nibasabin\\Desktop\\1"));
				//author.add(P);
				setLayout(new FlowLayout());
				setSize(200,200);
				text.setBackground(null);
				setVisible(true);
				add(text);
				
				//add(author);
				validate();
			}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 JComboBox cb = (JComboBox)e.getSource();
	        String petName = (String)cb.getSelectedItem();
	}
	 }

	
	
	

		
		
	
