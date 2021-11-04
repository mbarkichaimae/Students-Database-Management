import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Add_student extends JFrame {

	Statement st=null;
	PreparedStatement ps = null;
	Connection conn = null;
	ResultSet rs = null;
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtPreAdress;
	private JTextField txtPerAdress;
	private JTextField textFatherName;
	private JTextField textDateOfBirth;
	private JTextField textPhone;
	private JTextField textYear;
	private JTextField textCourse;
	private JTextField textDegree;
	private JTextField textFatherOccupation;
	private  JRadioButton Female;
	private  JRadioButton Male;
	private ButtonGroup group;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_student frame = new Add_student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Add_student() {
		initComponents();
		conn= DBConnection.ConnectDB();
	}
		public void initComponents() {
			for(javax.swing.UIManager.LookAndFeelInfo info:javax.swing.UIManager.getInstalledLookAndFeels())
			if("Nimbus".equals(info.getName())){
				try {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Name = new JLabel("Name");
		Name.setBackground(new Color(240, 240, 240));
		Name.setForeground(new Color(0, 51, 51));
		Name.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Name.setBounds(91, 14, 58, 31);
		contentPane.add(Name);
		
		JLabel Per_Adress = new JLabel("Per_Address  ");
		Per_Adress.setForeground(new Color(0, 51, 51));
		Per_Adress.setFont(new Font("Segoe UI", Font.BOLD, 13));
		Per_Adress.setBounds(59, 91, 83, 31);
		contentPane.add(Per_Adress);
		
		JLabel Phone = new JLabel("Phone");
		Phone.setForeground(new Color(0, 51, 51));
		Phone.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Phone.setBounds(289, 11, 50, 31);
		contentPane.add(Phone);
		
		txtName = new JTextField();
		txtName.setBounds(142, 16, 114, 27);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtPreAdress = new JTextField();
		txtPreAdress.setBounds(142, 58, 114, 27);
		contentPane.add(txtPreAdress);
		txtPreAdress.setColumns(10);
		
		txtPerAdress = new JTextField();
		txtPerAdress.setBounds(142, 93, 114, 27);
		contentPane.add(txtPerAdress);
		txtPerAdress.setColumns(10);
		
		JButton btnsubmit = new JButton("submit");
		btnsubmit.setBackground(new Color(0, 51, 51));
		btnsubmit.setForeground(new Color(204, 204, 204));
		btnsubmit.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender="";
				if(Male.isSelected())
			    {
					gender="Male";
					
			    }
				else if(Female.isSelected())
			    {
					gender="Female";
					
			    }
			String sql =" insert into students(Name,PRE_ADDRESS,PER_ADDRESS,FatherName,"
					+ "DateOfBirth,FatherOccupation,Phone,Gender,Year,Course,Degree) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?)";
				try{
					ps=conn.prepareStatement(sql);
					ps.setString(1,txtName.getText());
					ps.setString(2, txtPreAdress.getText());
					ps.setString(3,	txtPerAdress.getText());
					ps.setString(4, textFatherName.getText());
					ps.setString(5, textDateOfBirth.getText());
					ps.setString(6, textFatherOccupation.getText());
					ps.setString(7, textPhone.getText());
					ps.setString(8, gender);
					ps.setString(9, textYear.getText());
					ps.setString(10, textCourse.getText());
					ps.setString(11, textDegree.getText());
					
					rs=ps.executeQuery();
					if(rs.next()){
						JOptionPane.showMessageDialog(null,"add Successfully");
						
						Student_Management m= new Student_Management();
						m.setVisible(true);
						dispose();
						
					}
					else{
						JOptionPane.showMessageDialog(null, "Connection Problem");
					}
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnsubmit.setBounds(157, 259, 99, 31);
		contentPane.add(btnsubmit);
		
		textFatherName = new JTextField();
		textFatherName.setBounds(142, 131, 114, 27);
		contentPane.add(textFatherName);
		textFatherName.setColumns(10);
		
		textDateOfBirth = new JTextField();
		textDateOfBirth.setBounds(142, 169, 114, 27);
		contentPane.add(textDateOfBirth);
		textDateOfBirth.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setBounds(345, 16, 114, 27);
		contentPane.add(textPhone);
		textPhone.setColumns(10);
		
		textYear = new JTextField();
		textYear.setBounds(345, 97, 114, 27);
		contentPane.add(textYear);
		textYear.setColumns(10);
		
		textCourse = new JTextField();
		textCourse.setBounds(345, 151, 114, 27);
		contentPane.add(textCourse);
		textCourse.setColumns(10);
		
		textDegree = new JTextField();
		textDegree.setBounds(345, 203, 114, 27);
		contentPane.add(textDegree);
		textDegree.setColumns(10);
		
		textFatherOccupation = new JTextField();
		textFatherOccupation.setBounds(142, 207, 114, 27);
		contentPane.add(textFatherOccupation);
		textFatherOccupation.setColumns(10);
		
		JLabel Pre_Adress = new JLabel("Pre_Adress");
		Pre_Adress.setForeground(new Color(0, 51, 51));
		Pre_Adress.setFont(new Font("Segoe UI", Font.BOLD, 13));
		Pre_Adress.setBounds(59, 63, 73, 17);
		contentPane.add(Pre_Adress);
		
		JLabel FatherName = new JLabel("FatherName");
		FatherName.setForeground(new Color(0, 51, 51));
		FatherName.setFont(new Font("Segoe UI", Font.BOLD, 13));
		FatherName.setBounds(59, 137, 83, 13);
		contentPane.add(FatherName);
		
		JLabel DateOfBirth = new JLabel("DateOfBirth");
		DateOfBirth.setForeground(new Color(0, 51, 51));
		DateOfBirth.setFont(new Font("Segoe UI", Font.BOLD, 13));
		DateOfBirth.setBounds(59, 168, 83, 28);
		contentPane.add(DateOfBirth);
		
		JLabel FatherOccupation = new JLabel("FatherOccupation");
		FatherOccupation.setForeground(new Color(0, 51, 51));
		FatherOccupation.setFont(new Font("Segoe UI", Font.BOLD, 13));
		FatherOccupation.setBounds(30, 210, 111, 20);
		contentPane.add(FatherOccupation);
		
		JLabel Gender = new JLabel("Gender");
		Gender.setForeground(new Color(0, 51, 51));
		Gender.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Gender.setBounds(289, 64, 50, 14);
		contentPane.add(Gender);
		
		JLabel Year = new JLabel("Year");
		Year.setForeground(new Color(0, 51, 51));
		Year.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Year.setBounds(293, 108, 46, 14);
		contentPane.add(Year);
		
		JLabel Course = new JLabel("Course");
		Course.setForeground(new Color(0, 51, 51));
		Course.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Course.setBounds(293, 157, 46, 14);
		contentPane.add(Course);
		
		JLabel Degree = new JLabel("Degree");
		Degree.setForeground(new Color(0, 51, 51));
		Degree.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Degree.setBounds(293, 209, 58, 21);
		contentPane.add(Degree);
		
		
		
		//contentPane.add(group);
		
		 Female = new JRadioButton("F");
		 Female.setForeground(new Color(0, 51, 51));
		 Female.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		Female.setBounds(356, 60, 40, 22);
		contentPane.add(Female);
		
		Male = new JRadioButton("M");		
		Male.setForeground(new Color(0, 51, 51));
		Male.setFont(new Font("Segoe UI", Font.BOLD, 13));
		Male.setBounds(409, 52, 50, 38);
		contentPane.add(Male);
		 group = new ButtonGroup();
		group.add(Female); 
		group.add(Male);
		
		JButton exit_add = new JButton("cancel");
		exit_add.setForeground(new Color(204, 204, 204));
		exit_add.setBackground(new Color(0, 51, 51));
		exit_add.setFont(new Font("Segoe UI", Font.BOLD, 13));
		exit_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_Management a= new Student_Management();
				a.setVisible(true);
				dispose();
			}
		});
		exit_add.setBounds(278, 259, 99, 31);
		contentPane.add(exit_add);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel.setIcon(new ImageIcon(Add_student.class.getResource("/pictures/7.jpg")));
		lblNewLabel.setBounds(-80, -11, 579, 380);
		contentPane.add(lblNewLabel);
	}
			private void closeTheCurrentFrameAndOpenNew(java.awt.event.ActionEvent evt){
			 dispose();//To close the current window
			 Student_Management closeCurrentWindow = new Student_Management();
			 closeCurrentWindow.setVisible(true);//Open the new window
			}
}
