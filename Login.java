import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
/**
 * ----------------------------------------------------------------------------------------------------------------------------------
 * Records Management System
 * - System for storing and securing records from registration forms.
 * 		
 *      ------------------------------------------------------------------------------------
 * 		|Supported Functions: 4			                                                   |
 * 		|	                                                                               |								                                               |
 * 		|-Login						                                                       |		          
 * 		|-Store,update, & delete Records on SQL database	                               |
 * 	    |-Search Data                                            						   |
 * 		|-Populate records to text boxes just by clicking the designated row on the table. |
 *		------------------------------------------------------------------------------------
 * 
 * 		
 * 		----------------------
 * 	    |Classes: 5	         |
 * 	    | -SqlConnection     |
 * 	    | -Login             |
 *      | -Mainmenu          |
 *      | -AddStudent        |
 *      | -AddTeacher        |
 *      ----------------------
 * 
 *
 * @author Andrea Ella R. Remoreras
 * 		   CS26L - FINAL OUTPUT
 *-------------------------------------------------------------------------------------------------------------------------------------
 * 
 **/
@SuppressWarnings("serial")
class Login extends JFrame implements ActionListener{
	
	Connection connection=null;//Database connection
	private JPanel panelbackground,panelbackground2;
	private JLabel lbluser,lblpassword,lbltitle,lbllogo,lbllogo2;
	private JTextField txtuser;
	private JPasswordField txtpass;
	private JButton btnlogin;
	
	public Login() {
		
	 //This is where I've instantiated the needed components for the frame.
		connection=sqLiteConnection.dbConnector();//Database connection
		Container pane = getContentPane();
		pane.setLayout(null);
		
		
		panelbackground= new JPanel();
		panelbackground.setLayout(new GridBagLayout());
		panelbackground.setBackground(new Color(214, 137, 16));
		
		panelbackground2= new JPanel();
		panelbackground2.setLayout(new GridBagLayout());
		panelbackground2.setBackground(new Color(214, 137, 16));
		
		
		lbllogo=new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource("/text-file-4-32.png")).getImage();
		lbllogo.setIcon(new ImageIcon(logo));
		
		lbllogo2=new JLabel("");
		Image logo2 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lbllogo2.setIcon(new ImageIcon(logo2));
		
		
		lbltitle=new JLabel("Records Management Login");
		lbltitle.setFont(new Font("Dialog", Font.BOLD, 20));
		lbltitle.setForeground(Color.BLACK);
		
		
		lbluser=new JLabel("Username:");
		lbluser.setFont(new Font("Dialog", Font.BOLD, 14));
		lbluser.setForeground(Color.BLACK);
		
		lblpassword=new JLabel("Password:");
		lblpassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblpassword.setForeground(Color.BLACK);
		
		txtuser=new JTextField();
		txtuser.setBackground(new Color(234, 236, 238));
		
		txtpass=new JPasswordField();
		txtpass.setBackground(new Color(234, 236, 238));
		
		btnlogin=new JButton("LOGIN");
		btnlogin.setFont(new Font("Dialog", Font.BOLD, 14));	
		btnlogin.setForeground(Color.WHITE);
		btnlogin.setBackground(new Color(214, 137, 16));
		
		
	//This is where I've added the swing components to the container pane for them to be visible.
		pane.setBackground(Color.WHITE);
		panelbackground.add(lbllogo);
		pane.add(panelbackground).setBounds(0,0,400,70);
		pane.add(panelbackground2).setBounds(0,300,400,20);
		pane.add(lbltitle).setBounds(20,80,300,30);
		pane.add(lbllogo2).setBounds(20,140,64,64);
		pane.add(lbluser).setBounds(100,140,100,20);pane.add(txtuser).setBounds(180,140,150,20);
		pane.add(lblpassword).setBounds(100,180,100,20);pane.add(txtpass).setBounds(180,180,150,20);
		pane.add(btnlogin).setBounds(100,220,230,30);
		
		setTitle("");
		setSize(400,350);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		btnlogin.addActionListener(this);
		
		
	}
	public static void main (String[]args) {//Main method
		
		new Login();
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {//Login button function.
		// TODO Auto-generated method stub
				
		try {
			String query="select * from userdata where username=? and password=?";
			PreparedStatement pst= connection.prepareStatement(query);
			pst.setString(1,txtuser.getText());
			pst.setString(2,txtpass.getText());
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()){
			
				JOptionPane.showMessageDialog(null,"You have successfully logged in");
				dispose();
				new Mainmenu();
			}
			
			else{
				JOptionPane.showMessageDialog(null,"The username or password you’ve entered doesn’t match any of our records.");
			}
		rs.close();
		pst.close();
		
		}catch(Exception e2)
		{
			JOptionPane.showMessageDialog(null, e);
		}	
		}
		}
