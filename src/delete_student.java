import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class delete_student extends JFrame {
     Statement st=null;	
	PreparedStatement ps = null;
	Connection conn = null;
	ResultSet rs = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete_student frame = new delete_student();
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
	public delete_student() {
		
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Are you sure you want to delete this row ?");
		lblNewLabel.setForeground(new Color(0, 51, 51));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(86, 51, 288, 61);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.setForeground(new Color(204, 204, 204));
		btnNewButton.setBackground(new Color(0, 51, 51));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String search=Search.name_search;
				try{
					String sql="delete from students where Registration_no="+search+"";
					ps=conn.prepareStatement(sql);
					rs=ps.executeQuery();
					if(rs.next()){
						JOptionPane.showMessageDialog(null,"delete Successfully");
						Search s = new Search();
						s.setVisible(true);
						Search.display();
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(null, "Connection Problem");
					}
					//ResultSetMetaData metadata = rs.getMetaData();
				
					}catch (Exception ex){
						JOptionPane.showMessageDialog(null, ex);
					}
				
			}
		});
		btnNewButton.setBounds(118, 113, 89, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setForeground(new Color(204, 204, 204));
		btnNewButton_1.setBackground(new Color(0, 51, 51));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search a= new Search();
				a.setVisible(true);
				Search.display();
				dispose();
			}
		});
		btnNewButton_1.setBounds(233, 113, 100, 33);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(delete_student.class.getResource("/pictures/7.jpg")));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_1);
	}
		private void closeTheCurrentFrameAndOpenNew(java.awt.event.ActionEvent evt){

			 dispose();//To close the current window

			Student_Management closeCurrentWindow = new Student_Management();
			 closeCurrentWindow.setVisible(true);//Open the new window

			}
}
