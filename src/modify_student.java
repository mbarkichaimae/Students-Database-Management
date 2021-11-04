import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class modify_student extends JFrame {
	
	static Statement st=null;
	static PreparedStatement ps = null;
	 static Connection conn = null;
	static ResultSet rs = null;

	private JPanel contentPane;
	static private JTextField textPreAdress;
	static private JTextField textPerAdress;
	private JButton btnModify;
	private JButton Exit_modify;
	static	private JTextField textFatherOccupation;
	private JLabel FatherOccupation;
	static private JTextField textYear;
	static private JTextField textCourse;
	static private JTextField textDegree;
	private JLabel Year;
	private JLabel Course;
	private JLabel Degree;
	private JLabel lblNewLabel;
	static private JTextField textPhone;
	private JLabel lblNewLabel_1;

	

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modify_student frame = new modify_student();
					frame.setVisible(true);
					fill();
					//System.out.print("voilaa "+Search.name_search);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
/****** a method to display the data of the selected student in the Jtxtfield *********/	
	
public static  void fill() {
	String a=Search.name_search;
		try{
			String sql="select FATHEROCCUPATION,PRE_ADDRESS,PER_ADDRESS,PHONE,YEAR,"
					+ "COURSE,DEGREE from students  where Registration_no="+a+"";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();	
			while (rs.next()) {

			textFatherOccupation.setText(rs.getString(1));
			textPreAdress.setText(rs.getString(2));
			textPerAdress.setText(rs.getString(3));
			textPhone.setText(rs.getString(4));
			textYear.setText(rs.getString(5));
			textCourse.setText(rs.getString(6));
			textDegree.setText(rs.getString(7));
			}
			
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, ex);
			}
	}
	

	/**
	 * Create the frame.
	 * 
	 */
public modify_student() {
		
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
		setBounds(100, 100, 483, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel PreAdress = new JLabel("Pre_Adress");
		PreAdress.setForeground(new Color(0, 51, 51));
		PreAdress.setFont(new Font("Segoe UI", Font.BOLD, 13));
		PreAdress.setBounds(39, 44, 74, 20);
		contentPane.add(PreAdress);
		
		JLabel PerAdress = new JLabel("Per_Adress");
		PerAdress.setForeground(new Color(0, 51, 51));
		PerAdress.setFont(new Font("Segoe UI", Font.BOLD, 13));
		PerAdress.setBounds(39, 91, 74, 17);
		contentPane.add(PerAdress);
		
		textPreAdress = new JTextField();
		textPreAdress.setBounds(119, 44, 114, 29);
		contentPane.add(textPreAdress);
		textPreAdress.setColumns(10);
		
		textPerAdress = new JTextField();
		textPerAdress.setBounds(119, 85, 114, 29);
		contentPane.add(textPerAdress);
		textPerAdress.setColumns(10);
		
		btnModify = new JButton("Submit");
		btnModify.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnModify.setForeground(new Color(204, 204, 204));
		btnModify.setBackground(new Color(0, 51, 51));
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=Search.name_search;
				
			String sql ="update students set PRE_ADDRESS=?,PER_ADDRESS=?,FatherOccupation=?,Phone=?," + 
						"Year=?,Course=?,Degree=?  where Registration_no="+a+"";				
				try{	 
					ps=conn.prepareStatement(sql);
					ps.setString(1,textPreAdress.getText());
					ps.setString(2, textPerAdress.getText());
					ps.setString(3,textFatherOccupation.getText());
					ps.setString(4,textPhone.getText());
					ps.setString(5,textYear.getText());
					ps.setString(6,textCourse.getText());
					ps.setString(7,textDegree.getText());
					
					rs=ps.executeQuery();
					if(rs.next()){
						JOptionPane.showMessageDialog(null,"modify Successfully");
						Student_Management s = new Student_Management();
						s.setVisible(true);
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

		btnModify.setBounds(149, 224, 101, 29);
		contentPane.add(btnModify);
		
		Exit_modify = new JButton("Cancel");
		Exit_modify.setFont(new Font("Segoe UI", Font.BOLD, 13));
		Exit_modify.setForeground(new Color(204, 204, 204));
		Exit_modify.setBackground(new Color(0, 51, 51));
		Exit_modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search a= new Search();
				a.setVisible(true);
				Search.display();
				dispose();
			}
		});
		Exit_modify.setBounds(260, 224, 101, 29);
		contentPane.add(Exit_modify);
		
		textFatherOccupation = new JTextField();
		textFatherOccupation.setBounds(119, 130, 114, 29);
		contentPane.add(textFatherOccupation);
		textFatherOccupation.setColumns(10);
		
		FatherOccupation = new JLabel("FatherOccupation");
		FatherOccupation.setForeground(new Color(0, 51, 51));
		FatherOccupation.setFont(new Font("Segoe UI", Font.BOLD, 13));
		FatherOccupation.setBounds(10, 135, 114, 18);
		contentPane.add(FatherOccupation);
		
		textYear = new JTextField();
		textYear.setBounds(327, 48, 114, 29);
		contentPane.add(textYear);
		textYear.setColumns(10);
		
		textCourse = new JTextField();
		textCourse.setBounds(327, 98, 114, 29);
		contentPane.add(textCourse);
		textCourse.setColumns(10);
		
		textDegree = new JTextField();
		textDegree.setBounds(327, 145, 114, 29);
		contentPane.add(textDegree);
		textDegree.setColumns(10);
		
		Year = new JLabel("Year");
		Year.setForeground(new Color(0, 51, 51));
		Year.setFont(new Font("Segoe UI", Font.BOLD, 13));
		Year.setBounds(272, 57, 55, 16);
		contentPane.add(Year);
		
		Course = new JLabel("Course");
		Course.setForeground(new Color(0, 51, 51));
		Course.setFont(new Font("Segoe UI", Font.BOLD, 13));
		Course.setBounds(272, 104, 55, 16);
		contentPane.add(Course);
		
		Degree = new JLabel("Degree");
		Degree.setForeground(new Color(0, 51, 51));
		Degree.setFont(new Font("Segoe UI", Font.BOLD, 13));
		Degree.setBounds(272, 151, 55, 16);
		contentPane.add(Degree);
		
		lblNewLabel = new JLabel("Phone");
		lblNewLabel.setForeground(new Color(0, 51, 51));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel.setBounds(39, 178, 55, 16);
		contentPane.add(lblNewLabel);
		
		textPhone = new JTextField();
		textPhone.setBounds(119, 172, 114, 29);
		contentPane.add(textPhone);
		textPhone.setColumns(10);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(modify_student.class.getResource("/pictures/7.jpg")));
		lblNewLabel_1.setBounds(-100, 0, 567, 342);
		contentPane.add(lblNewLabel_1);
	}
		public   void close(){
			WindowEvent wincloseEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wincloseEvent);
		}
		private void closeTheCurrentFrameAndOpenNew(java.awt.event.ActionEvent evt){

			 dispose();//To close the current window
		     Student_Management closeCurrentWindow = new Student_Management();
			 closeCurrentWindow.setVisible(true);//Open the new window
			}
}
