import java.awt.Color;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
class Mainmenu extends JFrame implements ActionListener {
	
	
	private JPanel panelbackground,panelbackground2;
	private JLabel lblhome,lbldashboard,lbladd,lblteacher,lbllogout;
	private JButton btnlogout,btnaddstudent,btnaddteacher;
	
	public Mainmenu() {
		
	//This is where I've instantiated the needed components for the frame.
		Container pane = getContentPane();
		pane.setLayout(null);
	
	   
		panelbackground=new JPanel();
		panelbackground.setBackground(new Color(214, 137, 16));
		panelbackground.setLayout(new GridBagLayout());
		
		panelbackground2=new JPanel();
		panelbackground2.setBackground(new Color(214, 137, 16));
		panelbackground2.setLayout(new GridBagLayout());
		
		
		lbldashboard= new JLabel("RECORDS MANAGEMENT MENU");
		lbldashboard.setFont(new Font("Dialog", Font.BOLD, 20));
		lbldashboard.setForeground(Color.BLACK);
		
		lblhome= new JLabel("");
		Image home = new ImageIcon(this.getClass().getResource("/book-2-64.png")).getImage();
		lblhome.setIcon(new ImageIcon(home));
		
		
		lblhome.setFont(new Font("Agency FB", Font.BOLD,30));
		lblhome.setForeground(Color.WHITE);
		
		lbladd=new JLabel("STUDENTS FORM");
		lbladd.setFont(new Font("Dialog", Font.BOLD, 18));
		lbladd.setForeground(Color.BLACK);
		
		lblteacher=new JLabel("TEACHERS FORM");
		lblteacher.setFont(new Font("Dialog", Font.BOLD, 18));
		lblteacher.setForeground(Color.BLACK);
		
		lbllogout=new JLabel("LOGOUT");
		lbllogout.setFont(new Font("Dialog", Font.BOLD, 18));
		lbllogout.setForeground(Color.BLACK);
		
		
		btnaddstudent= new JButton("");
		Image add = new ImageIcon(this.getClass().getResource("/add-user-3-64.png")).getImage();
		btnaddstudent.setIcon(new ImageIcon(add));
		btnaddstudent.setBackground(new Color(0,102,204));
		
		btnaddteacher= new JButton("");
		Image teacher = new ImageIcon(this.getClass().getResource("/teacher-64.png")).getImage();
		btnaddteacher.setIcon(new ImageIcon(teacher));
		btnaddteacher.setBackground(new Color(123, 36, 28));
		
		btnlogout= new JButton("");
		Image logout = new ImageIcon(this.getClass().getResource("/account-logout-64.png")).getImage();
		btnlogout.setIcon(new ImageIcon(logout));
		btnlogout.setBackground(new Color(214, 137, 16));
		
		
	//This is where I've added the swing components to the container pane for them to be visible.
		pane.setBackground(Color.WHITE);
		panelbackground.add(lblhome);
		
		pane.add(lbldashboard).setBounds(100,70,400,100); 
		pane.add(panelbackground).setBounds(0,0,500,100);
		pane.add(panelbackground2).setBounds(0,520,550,20);
		pane.add(btnaddstudent).setBounds(50,160,130,130);pane.add(lbladd).setBounds(33,300,300,20);
		pane.add(btnaddteacher).setBounds(320,160,130,130);pane.add(lblteacher).setBounds(298,300,300,20);
		pane.add(btnlogout).setBounds(180,350,130,130);pane.add(lbllogout).setBounds(205,490,300,20);
		
		
		setSize(520,580);
		setTitle("HOME");
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
		btnaddstudent.addActionListener(this);
		btnaddteacher.addActionListener(this);
		btnlogout.addActionListener(this);
	}
	
	public static void main(String[]args) {
		
		new Mainmenu();
	}
	
 //This is where I've placed the functions of buttons.
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnaddstudent)) {//This will call the AddStudent Class.
			dispose();
			new AddStudent();
			
		}
		else if(e.getSource().equals(btnaddteacher)) {//This will call the AddTeacher Class.
			dispose();
			new AddTeacher();
			
		}
		else {//This will call the Login Class.
			int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?"," ",JOptionPane.YES_NO_OPTION);
			if(choice==0) {
			dispose();
			new Login();
			}
			else {
				
			}	
			}
			}
			}
