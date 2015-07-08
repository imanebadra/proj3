import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * 
 *
 * Purpose : Calculate volume of box and sphere and compare to target volume by user
 *  GUIDriver class
 *
 * @version 1.0
 *
 */

public class GUIDriver extends JFrame implements ActionListener
{	

	//Text fields 
	private JTextField txtRadius = new JTextField(10);
	private JTextField txtSphereVol = new JTextField(10);
	private JTextField txtLength = new JTextField(10);
	private JTextField txtWidth = new JTextField(10);
	private JTextField txtHeight = new JTextField(10);
	private JTextField txtBoxVol = new JTextField(10);
	private JTextField txtTarget = new JTextField(10);
	
	//buttons 
	private JButton btnClose = new JButton("Close");
	private JButton btnInit = new JButton("Set Intital Quantities");
	private JButton btnVol = new JButton("Calculate Volume");
	
	private Volume v = new Volume();
	/**
	 * GUIDriver constructor to build the Jpanel and layouts
	 *   A JFrame by default has a BoarderLayout which contains a north, east, west, south, and center area.
	 */
	public GUIDriver()
	{
		setTitle(" Sphere and Box Volumes");
		
		//Make the volume boxes uneditable
		txtBoxVol.setEditable(false);
		txtSphereVol.setEditable(false);
		
	
		
		/*
		 * The top uses the JLable default FlowLayout to add the txtTarget and a JLabel.
		 * This pannel is added in position NORTH of the GridLayout of the JFrame.
		 */
		JPanel top = new JPanel();
		top.add(new JLabel("Enter the required amount of volume "));
		top.add(txtTarget);
		
		add(top, BorderLayout.NORTH);
		
		/*
		 * West uses a GrdiLayout of 2 rows by 2 columns. 
		 */
		JPanel west = new JPanel(new GridLayout(2, 2));
		
		west.add(new JLabel("Enter radius of sphere "));
		west.add(txtRadius);
		west.add(new JLabel("Volume of the sphere "));
		west.add(txtSphereVol);
		
		
		add(west, BorderLayout.WEST);
		
		/* East panel uses a gridlayout as well
		 */
		JPanel east = new JPanel(new GridLayout(4, 2));
		east.add(new JLabel("Enter length of box "));
		east.add(txtLength);
		east.add(new JLabel("Enter width of box "));
		east.add(txtWidth);
		east.add(new JLabel("Enter height of box "));
		east.add(txtHeight);
		east.add(new JLabel("Volume of the box "));
		east.add(txtBoxVol);
		
		add(east, BorderLayout.EAST);
		
		/*
		 * FlowLayout to arrange the buttons at the bottom.
		 */
		JPanel bot = new JPanel();
		bot.add(btnInit);
		bot.add(btnVol);
		bot.add(btnClose);
		
		add(bot, BorderLayout.SOUTH);
		
		
		/*
		 * GUIDriver implements ActionListener to  set the actions listener to this variable
		 */
		btnInit.addActionListener(this);
		btnClose.addActionListener(this);
		btnVol.addActionListener(this);
		
		pack();
	}
	
/** Method for action Performed. 
 * e.getSource() returns the object which called the ActionListener.
    	 * Therefore in out case e.getSource() should be which button was pressed.
 * 
 */
    public void actionPerformed(ActionEvent e)
    {
    	
    	
	    if(e.getSource() == btnClose)
	    {
	    	//close the frame and exits the program
	    	setVisible(false);
	    }
	    else if(e.getSource() == btnInit)
	    {
	    	//Convert all the text fields to doubles
	    	double target = Double.parseDouble(txtTarget.getText());
	    	double length = Double.parseDouble(txtLength.getText());
	    	double width = Double.parseDouble(txtWidth.getText());
	    	double height = Double.parseDouble(txtHeight.getText());
	    	double radius = Double.parseDouble(txtRadius.getText());
	    	
	    	//Check if the user entered values <= 0
	    	if(radius <= 0 || length <= 0 || height <= 0 || width <= 0 || target <= 0)
	    	{
	    		JOptionPane.showMessageDialog(null, "Values must be > 0");
	    		return;
	    	}
	    	
	    	
	    	
	    	//Set the corresponding values in the Volume object
	    	v.setHeight(height);
	    	v.setWidth(width);
	    	v.setRadius(radius);
	    	v.setLength(length);
	    	v.setTarget(target);
	    }
	    else if(e.getSource() == btnVol)
	    {
	    	//Put the volume into the correct text boxes.
	    	//Uses the String.format function to ensure 1 decimal place.
	    	
	    	txtBoxVol.setText(String.format("%.1f", v.getBoxVolume()));
	    	txtSphereVol.setText(String.format("%.1f", v.getSphereVolume()));
	    	
	    	/**
	    	 * These are the differences between the entered volumes and the target
	    	 */
	    	double sdiff = v.getSphereDifference();
	    	double bdiff = v.getBoxDifference();
	    	
	    	//building message dialog box
	    	String message = "";
	    	
	    	if(sdiff > 0)
	    		message += "The sphere is under the target volume.\n";
	    	else if(sdiff < 0)
	    		message += "The sphere is greater than the target volume.\n";
	    	else
	    		message += "The sphere is at the target volume.\n";
	    	
	    	if(bdiff > 0)
	    		message += "The box is under the target volume.\n";
	    	else if(bdiff < 0)
	    		message += "The box is greater than the target volume.\n";
	    	else
	    		message += "The box is at the target volume.\n";
	    	
	    	//compare the two differences
	    	sdiff = Math.abs(sdiff);
	    	bdiff = Math.abs(bdiff);
	    	
	    	if(sdiff < bdiff)
	    		message += "The sphere is close to the target volume.";
	    	else
	    		message += "The box is closer to the targer volume.";
	    	
	    	//Show the message
	    	JOptionPane.showMessageDialog(null, message);
	    }
	    
    }
    /** Main method to excute code 
     * 
    */
	public static void main(String[] args)
	{
		GUIDriver d = new GUIDriver();
		//Makes the program exit when d is set to not visible
		d.setDefaultCloseOperation(EXIT_ON_CLOSE);
		d.setVisible(true);
	}
}
