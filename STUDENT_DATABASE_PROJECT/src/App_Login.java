	import java.awt.BorderLayout;
	import java.awt.EventQueue;
	import java.awt.Toolkit;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JTextField;
	import javax.swing.JPasswordField;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.UnsupportedLookAndFeelException;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import java.awt.event.WindowEvent;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
	import java.awt.Color;
	import java.awt.Font;
	import java.awt.event.FocusAdapter;
	import java.awt.event.FocusEvent;
	public class App_Login extends JFrame {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Statement st=null;
		private JPanel contentPane;
		private JTextField txtUserName;
		private JPasswordField txtPassword;
		private JLabel lblNewLabel;
		/**
		* Launch the application.
		*/
		public App_Login(){
			initComponents();
			conn= DBConnection.ConnectDB();
		}
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
					App_Login frame = new App_Login();
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
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(500, 100, 244, 375);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 153, 255));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			JLabel lblUserName = new JLabel("User Name");
			lblUserName.setForeground(new Color(0, 51, 51));
			lblUserName.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lblUserName.setBounds(78, 34, 96, 23);
			contentPane.add(lblUserName);
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setForeground(new Color(0, 51, 51));
			lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lblPassword.setBounds(85, 116, 89, 23);
			contentPane.add(lblPassword);
			txtUserName = new JTextField();
			txtUserName.setToolTipText("");
			txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtUserName.setBackground(new Color(245, 245, 245));
			txtUserName.setBounds(59, 68, 115, 32);
			contentPane.add(txtUserName);
			txtUserName.setColumns(10);
			txtPassword = new JPasswordField();
			txtPassword.setBackground(new Color(245, 245, 245));
			txtPassword.setBounds(59, 150, 115, 33);
			contentPane.add(txtPassword);
			JButton btnLogin = new JButton("Login");
			btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 13));
			btnLogin.setForeground(new Color(204, 204, 204));
			btnLogin.setBackground(new Color(0, 51, 51));
			btnLogin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
			});
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sql ="select * from users where name=? and pass=?";
					try{
						ps=conn.prepareStatement(sql);
						ps.setString(1, txtUserName.getText());
						ps.setString(2, txtPassword.getText());
						rs=ps.executeQuery();
						if(rs.next()){
							//JOptionPane.showMessageDialog(null,"connected Successfully");
							Student_Management s = new Student_Management();
							s.setVisible(true);
							close();
						}
						else{
							JOptionPane.showMessageDialog(null, "Connection Problem");
						}
					}catch (Exception ex){
						JOptionPane.showMessageDialog(null, ex);
					}
				}
			});
			btnLogin.setBounds(67, 223, 96, 32);
			contentPane.add(btnLogin);
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(App_Login.class.getResource("/pictures/2ee59b56deca065158436d87a7781415.jpg")));
			lblNewLabel.setBounds(0, -72, 257, 476);
			contentPane.add(lblNewLabel);
		}
		public   void close(){
			WindowEvent wincloseEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wincloseEvent);
		}
		 
	}