

import java.awt.BorderLayout;

import net.miginfocom.swing.MigLayout;
import net.proteanit.sql.DbUtils;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.Font;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField textsearch;
	Statement st=null;
	
	static PreparedStatement ps = null;
	static Connection conn = null;
	static ResultSet rs = null;
	static private JTable table;
	private JScrollPane students_table;
	/***** the name of selected student ****/
	public static String name_search;
	private JButton Exit_Search;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
					Search.display();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/****** methode to diplay all data ********/

	public static  void display() {
		
		try{
			String sql="select * from students ";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			ResultSetMetaData metadata = rs.getMetaData();				
			table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, ex);
			}
	}
	
	
	/**
	 * Create the frame.
	 */
	public Search() {
		
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
		setBounds(100, 100, 580, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel SearchStudent = new JLabel("Search Student ");
		SearchStudent.setFont(new Font("Segoe UI", Font.BOLD, 14));
		SearchStudent.setForeground(new Color(0, 51, 51));
		SearchStudent.setBackground(new Color(255, 255, 255));
		SearchStudent.setBounds(138, 14, 111, 36);
		contentPane.add(SearchStudent);
		

		
		textsearch = new JTextField();
		textsearch.setBounds(244, 20, 135, 26);
		//JTableHeader header ;
		textsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String search =textsearch.getText();
				try{
					String sql="select * from students where Name like '"+search+"%'";
					ps=conn.prepareStatement(sql);
					rs=ps.executeQuery();
					ResultSetMetaData metadata = rs.getMetaData();				
					table.setModel(DbUtils.resultSetToTableModel(rs));
					}catch (Exception ex){
						JOptionPane.showMessageDialog(null, ex);
					}
			
			}
		});
		contentPane.add(textsearch);
		textsearch.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(0, 51, 51));
		btnNewButton.setForeground(new Color(204, 204, 204));
		btnNewButton.setBounds(389, 20, 83, 26);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String search =textsearch.getText();
					if(textsearch.getText().isEmpty()) {
						search =" ";
					}
					
					String sql="select * from students where Name like '"+search+"%'";
					ps=conn.prepareStatement(sql);
					rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		contentPane.add(btnNewButton);
		
		students_table = new JScrollPane();
		
		students_table.setBounds(0, 64, 565, 224);
		contentPane.add(students_table);
		
	table =new JTable();
	table.setBackground(new Color(255, 255, 255));
	//table.setBorder(new LineBorder(new Color(0, 51, 51)));
	//table.setFillsViewportHeight(true);
	table.setCellSelectionEnabled(true);
	table.setColumnSelectionAllowed(true);
	table.setSurrendersFocusOnKeystroke(true);
	table.setForeground(new Color(0, 0, 0));

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        if (table.getSelectedRow() > -1) {
		        	
		               Search.name_search=table.getValueAt(table.getSelectedRow(),0).toString();
			            if(Student_Management.page==0) {
			            modify_student m= new modify_student();
			        	m.setVisible(true);
			        	modify_student.fill();
			        	dispose();
		             }
		             if(Student_Management.page==1) {
			             delete_student d= new delete_student();
			        	d.setVisible(true);
			        	dispose();
			             }
		             
		        }
		    }
		});
		students_table.setViewportView(table);
		
		Exit_Search = new JButton("Cancel");
		Exit_Search.setFont(new Font("Segoe UI", Font.BOLD, 13));
		Exit_Search.setForeground(new Color(204, 204, 204));
		Exit_Search.setBackground(new Color(0, 51, 51));
		Exit_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_Management a= new Student_Management();
				a.setVisible(true);
				dispose();
			}
		});
		Exit_Search.setBounds(482, 20, 77, 26);
		contentPane.add(Exit_Search);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Search.class.getResource("/pictures/7.jpg")));
		lblNewLabel_1.setBounds(0, -9, 575, 314);
		contentPane.add(lblNewLabel_1);
		
		
		//setLayout(new MigLayout());
		//contentPane.setLayout(new MigLayout());
	}
			
			private void closeTheCurrentFrameAndOpenNew(java.awt.event.ActionEvent evt){

				 dispose();//To close the current window

				Student_Management closeCurrentWindow = new Student_Management();
				 closeCurrentWindow.setVisible(true);//Open the new window

				}
}
