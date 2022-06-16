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
 * ------------------------------------------------------------------------------------------------------------------------------------
 **/
@SuppressWarnings("serial")
public class AddTeacher extends JFrame implements ActionListener, KeyListener, MouseListener{
	
	Connection connection = null;
	DefaultTableModel modelForm;
	private JLabel lblfirstname,lblmiddlename,lbllastname,lblcontact,lblsex,lbldepartment,lblage,lbladdress,lblemail,lblsearch,lbllogo;
	private JTextField txtfirstname,txtmiddlename,txtlastname,txtcontact,txtaddress,txtemail,txtsearch;
	private JButton btnadd,btnsave,btnclose,btnclear,btndelete;
	private JPanel panelbackground,panelform,panelsearch,panelbuttons,panelbackground2;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbsex, cmbage,cmbdepartment;
	private JTable tblinfo;

	
	
	@SuppressWarnings("unchecked")
	public void InsertComboBoxSex() {//Method for filling up the combobox Sex.
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
	@SuppressWarnings("unchecked")
	public void InsertComboBoxAge() {//Method for filling up the combobox Age.
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
	public void InsertComboBoxDepartment() {//Method for filling up the combobox Department.
		try {
			String query="select * from cmb_department order by Department";
			PreparedStatement pst =connection.prepareStatement(query);
			ResultSet rs =pst.executeQuery();
			while (rs.next())
			{
				String age = rs.getString("Department");
				cmbdepartment.addItem(age);

			}
			pst.close();
			rs.close();

		} catch (Exception r) {
			JOptionPane.showMessageDialog(null, r);
		}
	}
		
	
	public void TableInsert() {//Method for showing data to the table.
		try {
			String query="select * from teacher_list order by Lastname ASC";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			tblinfo.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public void ClearJText() {//method for clearing up the text boxes.
		txtfirstname.setText("");
		txtmiddlename.setText("");
		txtlastname.setText("");
		txtcontact.setText("");
		txtaddress.setText("");
		txtemail.setText("");
		txtsearch.setText("");
	
	}
	@SuppressWarnings("rawtypes")
	public AddTeacher() {
		
	//This is where I've instantiated the needed components for the frame.
		connection= sqLiteConnection.dbConnector();
		
		
		Container pane = getContentPane();
		pane.setLayout(null);
		
		lblfirstname = new JLabel("First name:");
		lblfirstname.setFont(new Font("Dialog", Font.BOLD, 13));
		
		lblmiddlename = new JLabel("Middle name:");
		lblmiddlename.setFont(new Font("Dialog", Font.BOLD, 13));
		
		lbllastname = new JLabel("Last name:");
		lbllastname.setFont(new Font("Dialog", Font.BOLD, 13));
		
		lblsex = new JLabel("Sex:");
		lblsex.setFont(new Font("Dialog", Font.BOLD, 13));
		
		lbldepartment = new JLabel("College Department: ");
		lbldepartment.setFont(new Font("Dialog", Font.BOLD, 13));
		
		lblage = new JLabel("Age:");
		lbldepartment.setFont(new Font("Dialog", Font.BOLD, 13));
		
		lbladdress = new JLabel("Home address:");
		lbladdress.setFont(new Font("Dialog", Font.BOLD, 13));
		
		lblemail = new JLabel("Email:");
		lblemail.setFont(new Font("Dialog", Font.BOLD, 13));
		
		lblsearch = new JLabel("Search:");
		lblsearch.setFont(new Font("Dialog", Font.BOLD, 13));
		
		lblcontact = new JLabel ("Contact #:");
		lblcontact.setFont(new Font("Dialog", Font.BOLD, 13));
		
		lbllogo = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource("/edit-6-128.png")).getImage();
		lbllogo.setIcon(new ImageIcon(logo));
		
		txtfirstname = new JTextField();
		txtfirstname.setBackground(new Color(248, 249, 249));
		
		txtmiddlename = new JTextField();
		txtmiddlename.setBackground(new Color(248, 249, 249));
		
		txtlastname = new JTextField();
		txtlastname.setBackground(new Color(248, 249, 249));
		
		txtcontact = new JTextField();
		txtcontact.setBackground(new Color(248, 249, 249));
		
		txtaddress = new JTextField();
		txtaddress.setBackground(new Color(248, 249, 249));
		
		txtemail = new JTextField();
		txtemail.setBackground(new Color(248, 249, 249));
		
		txtsearch = new JTextField();
		txtsearch.setBackground(new Color(248, 249, 249));
		
		btnadd = new JButton("ADD");
		btnadd.setBackground(new Color(123, 36, 28));
		btnadd.setForeground(Color.WHITE);
		
		btnsave = new JButton("SAVE");
		btnsave.setBackground(new Color(123, 36, 28));
		btnsave.setForeground(Color.WHITE);
		
		btnclear = new JButton("CLEAR");
		btnclear.setBackground(new Color(123, 36, 28));
		btnclear.setForeground(Color.WHITE);
		
		btnclose = new JButton("BACK");
		btnclose.setBackground(new Color(123, 36, 28));
		btnclose.setForeground(Color.WHITE);
		
		btndelete = new JButton("DELETE");
		btndelete.setBackground(new Color(123, 36, 28));
		btndelete.setForeground(Color.WHITE);
		
		
		panelbackground = new JPanel();
		panelbackground.setLayout(new GridBagLayout());
		panelbackground.setBackground(new Color(123, 36, 28));
		
		panelbackground2 = new JPanel();
		panelbackground2.setLayout(new GridBagLayout());
		panelbackground2.setBackground(new Color(123, 36, 28));
		
		
		panelform = new JPanel();
		panelform.setBorder(BorderFactory.createTitledBorder("Teacher Registration Form"));
		panelform.setLayout(new GridLayout(11,2));
		
		
		txtsearch =new JTextField(10);
		panelsearch = new JPanel();
		panelsearch=new JPanel(new FlowLayout());
		panelsearch.add(lblsearch);
		panelsearch.add(txtsearch);
		panelsearch.setBackground(Color.white);
		
		
		panelbuttons = new JPanel();
		panelbuttons=new JPanel(new GridLayout(1,6,2,3));
		panelbuttons.add(btnclose);
		panelbuttons.add(btnadd);
		panelbuttons.add(btnsave);
		panelbuttons.add(new JLabel());
		panelbuttons.add(new JLabel());
		panelbuttons.add(btnclear);
		panelbuttons.add(btndelete);
		panelbuttons.setBackground(Color.WHITE);
		
		cmbage = new JComboBox();
		cmbage.setBackground(Color.WHITE);
		
		cmbsex = new JComboBox();
		cmbsex.setBackground(Color.WHITE);
		
		cmbdepartment = new JComboBox();
		cmbdepartment.setBackground(Color.WHITE);
		
		tblinfo = new JTable();
		JScrollPane scroll = new JScrollPane(tblinfo);
		scroll.setBackground(Color.WHITE);
		
		JViewport view = scroll.getViewport();
		view.setBackground(Color.WHITE);
		
		JTableHeader header = tblinfo.getTableHeader();
		header.setBackground(new Color(123, 36, 28));
		header.setFont(new Font("Dialog", Font.BOLD, 12));
		header.setForeground(Color.WHITE);
		
	//This is where I've added the swing components to the container pane for them to be visible.
		panelform.setBackground(new Color(242, 215, 213));
		panelform.add(lblfirstname);panelform.add(txtfirstname);
		panelform.add(lblmiddlename); panelform.add(txtmiddlename);
		panelform.add(lbllastname); panelform.add(txtlastname);
		panelform.add(lblsex); panelform.add(cmbsex);
		panelform.add(lblage); panelform.add(cmbage);
		panelform.add(lbldepartment);panelform.add(cmbdepartment);
		panelform.add(lblcontact); panelform.add(txtcontact);
		panelform.add(lbladdress); panelform.add(txtaddress);
		panelform.add(lblemail);panelform.add(txtemail);
		
		panelbackground.add(lbllogo).setBounds(50,0,128,128);
		
		add(panelbackground).setBounds(0,0,1150,130);
		add(panelbackground2).setBounds(0,650,1150,100);
		pane.add(panelform).setBounds(10, 160, 330, 380);
		pane.add(panelbuttons).setBounds(10, 580, 1100, 30);
		pane.add(panelsearch).setBounds(350, 160, 200, 30);
		pane.setBackground(Color.WHITE);
		pane.add(scroll).setBounds(350, 200, 770, 340);
		
		
		
		setTitle("TEACHER REGISTRATION FORM");
		setSize(1150,700);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tblinfo.addMouseListener(this);
		txtsearch.addKeyListener(this);
		btnadd.addActionListener(this);
		btnsave.addActionListener(this);
		btnclose.addActionListener(this);
		btnclear.addActionListener(this);
		btndelete.addActionListener(this);
		
		TableInsert();
		InsertComboBoxSex();
		InsertComboBoxAge();
		InsertComboBoxDepartment();
	}
	public static void main (String[]args) {
		new AddTeacher();
		
	}

//This is where I've placed the button, keyboard, & mouse functions.
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnclose)) {//Button back function.
			dispose();
			new Mainmenu();
			
		}
		else if(e.getSource().equals(btnadd)) {//Button add function.
			
			if((txtfirstname.getText().isEmpty()||txtmiddlename.getText().isEmpty()||txtlastname.getText().isEmpty()||txtaddress.getText().isEmpty()||txtcontact.getText().isEmpty()||txtemail.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Kindly fill up the spaces");
				}
				else {
					int choice =JOptionPane.showConfirmDialog(null, "Are you sure you want to add this data?"," ",JOptionPane.YES_NO_OPTION);
					if(choice==0) {
					try {
					String query="insert into teacher_list (Lastname,Firstname,Middlename,Sex,Age,Department,Contact,Address,Email) values (?,?,?,?,?,?,?,?,?)";
					String sex = cmbsex.getSelectedItem().toString();
					String age = cmbage.getSelectedItem().toString();
					String department = cmbdepartment.getSelectedItem().toString();
					PreparedStatement pst =connection.prepareStatement(query);
					pst.setString(1,txtlastname.getText());
					pst.setString(2,txtfirstname.getText());
					pst.setString(3,txtmiddlename.getText());
					pst.setString(4,sex);
					pst.setString(5,age);
					pst.setString(6,department);	
					pst.setString(7,txtcontact.getText());
					pst.setString(8,txtaddress.getText());
					pst.setString(9,txtemail.getText());
				
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Student Added Successfully");
					
					pst.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
			}
					ClearJText();
					TableInsert();
			}
			}
			}
			else if (e.getSource().equals(btnsave)) {//Button save function.
				if((txtfirstname.getText().isEmpty()||txtmiddlename.getText().isEmpty()||txtlastname.getText().isEmpty()||txtaddress.getText().isEmpty()||txtcontact.getText().isEmpty()||txtemail.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Kindly fill up the spaces");
					}
					else {
						int choice =JOptionPane.showConfirmDialog(null, "Are you sure you want to save this data?"," ",JOptionPane.YES_NO_OPTION);
						if(choice==0) {
						
						try{
							String sex = cmbsex.getSelectedItem().toString();
							String age = cmbage.getSelectedItem().toString();
							String department = cmbdepartment.getSelectedItem().toString();
							String query= "Update teacher_list set Lastname='"+txtlastname.getText()+"', Firstname='"+txtfirstname.getText()+"', Middlename='"+txtmiddlename.getText()+"', Sex='"+sex+"', Age='"+age+"',Department='"+department+"', Contact='"+txtcontact.getText()+"', Address='"+txtaddress.getText()+"',Email='"+txtemail.getText()+"'where Email='"+txtemail.getText()+"'";
							PreparedStatement pst =connection.prepareStatement(query);
							pst.executeUpdate();
							
							JOptionPane.showMessageDialog(null, "Data Updated Successfully");
							
							
							pst.close();
				
						}catch(Exception e2) {
							JOptionPane.showMessageDialog(null, e2);
						}
						TableInsert();
						ClearJText();
						
					}
			}
			}
		
			else if(e.getSource().equals(btnclear)) {//Button clear function.
				if((txtfirstname.getText().isEmpty()||txtmiddlename.getText().isEmpty()||txtlastname.getText().isEmpty()||txtaddress.getText().isEmpty()||txtcontact.getText().isEmpty()||txtemail.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Form is already empty");
					}
					else {
				ClearJText();
			}
			}
			else if(e.getSource().equals(btndelete)) {//Button delete function.
				if((txtfirstname.getText().isEmpty()||txtmiddlename.getText().isEmpty()||txtlastname.getText().isEmpty()||txtaddress.getText().isEmpty()||txtcontact.getText().isEmpty()||txtemail.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Form is empty");
					}
					else {
						int choice =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this data?"," ",JOptionPane.YES_NO_OPTION);
						if(choice==0) {
							try {
								int row = tblinfo.getSelectedRow();
								String delete = tblinfo.getModel().getValueAt(row, 8).toString();
								
								String query="DELETE FROM teacher_list WHERE Email='"+delete+"'";
								PreparedStatement pst =connection.prepareStatement(query);
								pst.executeUpdate();
								
								JOptionPane.showMessageDialog(null, "Deleted ");
								
								pst.close();
								
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							TableInsert();
							ClearJText();
						
					}}
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
	public void keyReleased(KeyEvent e) {//For the search bar function.
		// TODO Auto-generated method stub
		try {
			DefaultTableModel table  =  (DefaultTableModel)tblinfo.getModel();
			String search=txtsearch.getText();
			TableRowSorter sort=new TableRowSorter(table);
			tblinfo.setRowSorter(sort);
			sort.setRowFilter(RowFilter.regexFilter("(?i)" + search,0,1,2,3,4,5,6,7,8,9));
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
		cmbdepartment.setSelectedItem(tblinfo.getValueAt(row, 5));
		txtcontact.setText(tblinfo.getValueAt(row,6).toString());
		txtaddress.setText(tblinfo.getValueAt(row,7).toString());
		txtemail.setText(tblinfo.getValueAt(row,8).toString());

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
					
