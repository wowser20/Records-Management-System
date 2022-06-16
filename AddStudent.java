import java.awt.Color;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;
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
 **/
@SuppressWarnings("serial")
public class AddStudent extends JFrame implements ActionListener,KeyListener, MouseListener{
	
	Connection connection = null;//database connection
	private JLabel lblfirstname,lblmiddlename,lbllastname,lblsex,lblage,lblcontactnumber,lblyearlvl,lbladdress,lblid,lblcourse,lblsearch,lblemail,lbltitle;
	private JTextField txtfirstname,txtmiddlename,txtlastname,txtsex,txtage,txtcontactnumber,txtyearlvl,txtaddress,txtid,txtcourse,txtsearch,txtemail;
	private JButton btnupdate,btnadd,btnclose,btndelete,btnclear;
	private JPanel panelinfo,panelbutton, panelsearch,panelbackground,panelbackground2;
	private JTable tblinfo;
	DefaultTableModel modelForm;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbyear,cmbage,cmbsex;
	
	
	@SuppressWarnings("unchecked")
	public void InsertToComboBoxYear() {//method for filling up the combobox year.
		try {
			String query="select * from Year_level order by Year";
			PreparedStatement pst =connection.prepareStatement(query);
			ResultSet rs =pst.executeQuery();
			while (rs.next())
			{
				String year = rs.getString("Year");
				cmbyear.addItem(year);

			}
			pst.close();
			rs.close();

		} catch (Exception r) {
			JOptionPane.showMessageDialog(null, r);
		}
	}
	@SuppressWarnings("unchecked")
	public void InsertToComboBoxAge() {//method for filling up the combobox age.
		try {
			String query="select * from age order by Age";
			PreparedStatement pst =connection.prepareStatement(query);
			ResultSet rs =pst.executeQuery();
			while (rs.next())
			{
				String age = rs.getString("Age");
				cmbage.addItem(age);

			}
			pst.close();
			rs.close();

		} catch (Exception r) {
			JOptionPane.showMessageDialog(null, r);
		}
	}
		@SuppressWarnings("unchecked")
		public void InsertToComboBoxSex() {//method for filling up the combobox sex.
			try {
				String query="select * from sex order by Sex";
				PreparedStatement pst =connection.prepareStatement(query);
				ResultSet rs =pst.executeQuery();
				while (rs.next())
				{
					String sex = rs.getString("Sex");
					cmbsex.addItem(sex);

				}
				pst.close();
				rs.close();

			} catch (Exception r) {
				JOptionPane.showMessageDialog(null, r);
			}
		}
	public void ClearJText() {//method for clearing up the text boxes.
		txtfirstname.setText("");
		txtmiddlename.setText("");
		txtlastname.setText("");
		txtsex.setText("");
		txtage.setText("");
		txtcontactnumber.setText("");
		txtyearlvl.setText("");
		txtid.setText("");
		txtaddress.setText("");
		txtcourse.setText("");
		txtemail.setText("");
		
	}
	public void Refreshtable(){//Method for showing data to the table.
		try {
			String query="select * from student_list order by Lastname ASC";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			tblinfo.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	@SuppressWarnings("rawtypes")
	public AddStudent() {
	//This is where I've instantiated the needed components for the frame.
		
		connection=sqLiteConnection.dbConnector();
		Container pane = getContentPane();
		pane.setLayout(new FlowLayout());
		setLayout(null);
		
		tblinfo=new JTable();
		JScrollPane scroll = new JScrollPane(tblinfo);
		
		JViewport view = scroll.getViewport();
		view.setBackground(Color.WHITE);
		
		JTableHeader header = tblinfo.getTableHeader();
		header.setBackground(new Color(0,102,204));
		header.setFont(new Font("Dialog", Font.BOLD, 12));
		header.setForeground(Color.WHITE);
		
		panelinfo=new JPanel();
		panelinfo.setBorder(new TitledBorder(new LineBorder(new Color(0,102,204)),"Student's Registration Form"));
		panelinfo.setFont(new Font("Dialog", Font.BOLD, 20));
		
		lbltitle=new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource("/student-128.png")).getImage();
		lbltitle.setIcon(new ImageIcon(logo));
		
		lblfirstname = new JLabel("First name:");;
		lblfirstname.setFont(new Font("Dialog", Font.BOLD, 13));
		
		lblmiddlename = new JLabel("Middle name:");
		lblmiddlename.setFont(new Font("Dialog", Font.BOLD, 13));
	
		lbllastname = new JLabel("Last name:");
		lbllastname.setFont(new Font("Dialog", Font.BOLD, 13));
		
		lblsex = new JLabel("Sex:");
		lblsex.setFont(new Font("Dialog", Font.BOLD, 13));
		
		lblage = new JLabel("Age:");
		lblage.setFont(new Font("Dialog", Font.BOLD, 13));
	
		lblcontactnumber = new JLabel("Contact number:");
		lblcontactnumber.setFont(new Font("Dialog", Font.BOLD, 13));
		
		lblyearlvl = new JLabel("Year Level:");
		lblyearlvl.setFont(new Font("Dialog", Font.BOLD, 13));
		
		lblid = new JLabel("ID number:");
		lblid.setFont(new Font("Dialog", Font.BOLD, 13));
	
		lblcourse= new JLabel("Course");
		lblcourse.setFont(new Font("Dialog", Font.BOLD, 13));
		
		lbladdress = new JLabel("Address:");
		lbladdress.setFont(new Font("Dialog", Font.BOLD, 13));
		
		lblemail= new JLabel("Email:");
		lblemail.setFont(new Font("Dialog", Font.BOLD, 13));	
		
		
		txtfirstname=new JTextField();
		txtfirstname.setBackground(new Color(248, 249, 249));
		
		txtmiddlename=new JTextField();
		txtmiddlename.setBackground(new Color(248, 249, 249));
		
		txtlastname = new JTextField();
		txtlastname.setBackground(new Color(248, 249, 249));
		
		txtsex=new JTextField();
		txtsex.setBackground(new Color(248, 249, 249));
		
		txtage = new JTextField();
		txtage.setBackground(new Color(248, 249, 249));;
		
		txtcontactnumber=new JTextField();
		txtcontactnumber.setBackground(new Color(248, 249, 249));
		
		txtyearlvl = new JTextField();
		txtyearlvl.setBackground(new Color(248, 249, 249));
		
		txtid=new JTextField();
		txtid.setBackground(new Color(248, 249, 249));
		
		txtaddress=new JTextField();
		txtaddress.setBackground(new Color(248, 249, 249));
		
		txtcourse=new JTextField();
		txtcourse.setBackground(new Color(248, 249, 249));
		
		txtemail=new JTextField();
		txtemail.setBackground(new Color(248, 249, 249));
		
		txtsearch=new JTextField();
		txtsearch.setBackground(new Color(248, 249, 249));
		
		
		cmbyear = new JComboBox();
		cmbyear.setBackground(Color.WHITE);
		
		cmbage = new JComboBox();
		cmbage.setBackground(Color.WHITE);
		
		
		cmbsex = new JComboBox();
		cmbsex.setBackground(Color.WHITE);
		
		
		btnadd=new JButton("ADD");
		btnadd.setBackground(new Color(0,102,204));
		btnadd.setForeground(Color.WHITE);
		
		btnupdate=new JButton("SAVE");
		btnupdate.setBackground(new Color(0,102,204));
		btnupdate.setForeground(Color.WHITE);
		
		btndelete=new JButton("DELETE");
		btndelete.setBackground(new Color(0,102,204));
		btndelete.setForeground(Color.WHITE);
		
		btnclear=new JButton("CLEAR");
		btnclear.setBackground(new Color(0,102,204));
		btnclear.setForeground(Color.WHITE);
		
		btnclose=new JButton("BACK");
		btnclose.setBackground(new Color(0,102,204));
		btnclose.setForeground(Color.WHITE);
		
		lblsearch=new JLabel("Search");
		txtsearch=new JTextField(10);
		panelsearch=new JPanel(new FlowLayout());
		panelsearch.add(lblsearch);
		panelsearch.add(txtsearch);
		panelsearch.setBackground(Color.white);
		
		panelbackground=new JPanel();
		panelbackground.setLayout(new GridBagLayout());
		
		panelbackground2 = new JPanel();
		panelbackground2.setLayout(null);
		
		panelbackground.setBackground(new Color(0,102,204));
		panelbackground2.setBackground(new Color(0,102,204));
		
		
		
		panelbutton=new JPanel(new GridLayout(1,6,2,3));
		panelbutton.add(btnclose);
		panelbutton.add(btnadd);
		panelbutton.add(btnupdate);
		panelbutton.add(new JLabel());
		panelbutton.add(new JLabel());
		panelbutton.add(btnclear);
		panelbutton.add(btndelete);
		panelbutton.setBackground(Color.WHITE);
		
		panelinfo.setLayout(new GridLayout(11,2));
		
	//This is where I've added the swing components to the container pane for them to be visible.
		panelinfo.setBackground(new Color(174, 214, 241));
		panelinfo.add(lblfirstname);panelinfo.add(txtfirstname);
		panelinfo.add(lblmiddlename); panelinfo.add(txtmiddlename);
		panelinfo.add(lbllastname); panelinfo.add(txtlastname);
		panelinfo.add(lblsex); panelinfo.add(cmbsex);
		panelinfo.add(lblage); panelinfo.add(cmbage);
		panelinfo.add(lblcontactnumber); panelinfo.add(txtcontactnumber);
		panelinfo.add(lblyearlvl); panelinfo.add(cmbyear);
		panelinfo.add(lblid); panelinfo.add(txtid);
		panelinfo.add(lblcourse); panelinfo.add(txtcourse);
		panelinfo.add(lbladdress); panelinfo.add(txtaddress);
		panelinfo.add(lblemail);panelinfo.add(txtemail);
		
		panelbackground.add(lbltitle).setBounds(50,0,128,128);
		
		add(panelbackground).setBounds(0,0,1150,130);
		add(panelbackground2).setBounds(0,650,1150,20);
		pane.setBackground(Color.WHITE);
		add(panelinfo).setBounds(10, 160, 330, 380);
		add(scroll).setBounds(350, 200, 770, 340);
		add(panelsearch).setBounds(350, 160, 200, 30);
		add(panelbutton).setBounds(10, 580, 1100, 40);
		setTitle("STUDENT REGISTRATION FORM");
		setSize(1150, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		txtsearch.addKeyListener(this);
		btnadd.addActionListener(this);
		btnupdate.addActionListener(this);
		btndelete.addActionListener(this);
		btnclear.addActionListener(this);
		btnclose.addActionListener(this);
		tblinfo.addMouseListener(this);
		
		Refreshtable();
		InsertToComboBoxYear();
		InsertToComboBoxAge();
		InsertToComboBoxSex();
	}
	public static void main (String[]args) {//Main method
		new AddStudent();
		
	}

 //This is where I've placed the button, keyboard, & mouse functions.
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnclose)) {//Button back function.
			dispose();
			Mainmenu menu =new Mainmenu();
			menu.setLocationRelativeTo(null);
			menu.setVisible(true);	
			
		}
		else if(e.getSource().equals(btnadd)) {//Button add function
			if((txtfirstname.getText().isEmpty()||txtmiddlename.getText().isEmpty()||txtlastname.getText().isEmpty()||txtcontactnumber.getText().isEmpty()||txtid.getText().isEmpty()||txtcourse.getText().isEmpty()||txtaddress.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Kindly fill up the spaces");
			}
			else {
				int choice =JOptionPane.showConfirmDialog(null, "Are you sure you want to add this data?"," ",JOptionPane.YES_NO_OPTION);
				if(choice==0) {
				
				try {
				String query="insert into student_list (Lastname,Firstname,Middlename,Sex,Age,Contactinfo,Gradelevel,Address,ID,Course,Email) values (?,?,?,?,?,?,?,?,?,?,?)";
				String year = cmbyear.getSelectedItem().toString();
				String age = cmbage.getSelectedItem().toString();
				String sex = cmbsex.getSelectedItem().toString();
				PreparedStatement pst =connection.prepareStatement(query);
				pst.setString(1,txtlastname.getText());
				pst.setString(2,txtfirstname.getText());
				pst.setString(3,txtmiddlename.getText());
				pst.setString(4,sex);
				pst.setString(5,age);
				pst.setString(6,txtcontactnumber.getText());	
				pst.setString(7,year);
				pst.setString(8,txtaddress.getText());
				pst.setString(9,txtid.getText());
				pst.setString(10,txtcourse.getText());
				pst.setString(11,txtemail.getText());
			
				
				
				pst.execute();
				
				JOptionPane.showMessageDialog(null, "Student Added Successfully");
				
				pst.close();
				
			} catch (Exception e1) {
				e1.printStackTrace();
		}
			ClearJText();
			Refreshtable();
		}
		}
		}
		
		
	else if(e.getSource().equals(btnclear)) {//Button clear function.
		if((txtfirstname.getText().isEmpty()||txtmiddlename.getText().isEmpty()||txtlastname.getText().isEmpty()||txtcontactnumber.getText().isEmpty()||txtid.getText().isEmpty()||txtcourse.getText().isEmpty()||txtaddress.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Form is already empty");
		}else
		ClearJText();
		}
		
	else if(e.getSource().equals(btnupdate)) {//Button update function.
		if((txtfirstname.getText().isEmpty()||txtmiddlename.getText().isEmpty()||txtlastname.getText().isEmpty()||txtcontactnumber.getText().isEmpty()||txtid.getText().isEmpty()||txtcourse.getText().isEmpty()||txtaddress.getText().isEmpty())||txtemail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Kindly fill up the spaces");
			}
		else {
			int choice =JOptionPane.showConfirmDialog(null, "Are you sure you want to save this data?"," ",JOptionPane.YES_NO_OPTION);
			if(choice==0) {
		try{
			String year = cmbyear.getSelectedItem().toString();
			String age = cmbage.getSelectedItem().toString();
			String sex = cmbsex.getSelectedItem().toString();
			String query= "Update student_list set Lastname='"+txtlastname.getText()+"', Firstname='"+txtfirstname.getText()+"', Middlename='"+txtmiddlename.getText()+"', Sex='"+sex+"', Age='"+age+"', Contactinfo='"+txtcontactnumber.getText()+"',Gradelevel='"+year+"', Address='"+txtaddress.getText()+"',ID='"+txtid.getText()+"', Course='"+txtcourse.getText()+"',Email='"+txtemail.getText()+"'where Email='"+txtemail.getText()+"'";
			PreparedStatement pst =connection.prepareStatement(query);
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Data Updated Successfully");
			
			
			pst.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		ClearJText();
		Refreshtable();
		
	}
	}
	}
	else if(e.getSource().equals(btndelete)) {//Button delete function.
		if((txtfirstname.getText().isEmpty()||txtmiddlename.getText().isEmpty()||txtlastname.getText().isEmpty()||txtcontactnumber.getText().isEmpty()||txtid.getText().isEmpty()||txtcourse.getText().isEmpty()||txtaddress.getText().isEmpty()||txtemail.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Form is empty");
			}
		else {
			int choice =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this data?"," ",JOptionPane.YES_NO_OPTION);
			if(choice==0) {
				try {
					int row = tblinfo.getSelectedRow();
					String delete = tblinfo.getModel().getValueAt(row, 8).toString();
					
					String query="DELETE FROM student_list WHERE ID='"+delete+"'";
					PreparedStatement pst =connection.prepareStatement(query);
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Deleted ");
					
					pst.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				Refreshtable();
				ClearJText();
			
		}}
		}
			else{
				
				}
	
		}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void keyReleased(KeyEvent e) {//For search bar function
		// TODO Auto-generated method stub
		try {
			DefaultTableModel table  =  (DefaultTableModel)tblinfo.getModel();
			String search=txtsearch.getText();
			TableRowSorter sort=new TableRowSorter(table);
			tblinfo.setRowSorter(sort);
			sort.setRowFilter(RowFilter.regexFilter("(?i)" + search,0,1,2,3,4,5,6,7,8,9,10));
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
		
	
	@Override
	public void mouseClicked(MouseEvent e) {//For populating data to the JtextField by clicking the table.
		// TODO Auto-generated method stub
		int row = tblinfo.getSelectedRow();
		
		txtlastname.setText(tblinfo.getValueAt(row,0).toString());
		txtfirstname.setText(tblinfo.getValueAt(row,1).toString());
		txtmiddlename.setText(tblinfo.getValueAt(row,2).toString());
		cmbsex.setSelectedItem(tblinfo.getValueAt(row, 3));
		cmbage.setSelectedItem(tblinfo.getValueAt(row, 4));
		txtcontactnumber.setText(tblinfo.getValueAt(row,5).toString());
		cmbyear.setSelectedItem(tblinfo.getValueAt(row, 6));
		txtaddress.setText(tblinfo.getValueAt(row,7).toString());
		txtid.setText(tblinfo.getValueAt(row,8).toString());
		txtcourse.setText(tblinfo.getValueAt(row,9).toString());
		txtemail.setText(tblinfo.getValueAt(row,10).toString());
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
		}

	
		
	
