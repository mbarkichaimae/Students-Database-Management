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

public class Welcome extends JFrame {

	private JPanel contentPane;
	private JButton Login;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Login = new JButton("Login");
		Login.setForeground(new Color(204, 204, 204));
		Login.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App_Login a= new App_Login();
				a.setVisible(true);
				dispose();
			}
		});
		Login.setBorderPainted(false);
		Login.setFocusPainted(false);
		Login.setBackground(new Color(0, 51, 51));
		Login.setBounds(196, 147, 105, 33);
		contentPane.add(Login);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome ");
		lblNewLabel_1.setForeground(new Color(0, 51, 51));
		lblNewLabel_1.setFont(new Font("Script MT Bold", Font.BOLD, 36));
		lblNewLabel_1.setBounds(178, 26, 171, 68);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To Student Management System");
		lblNewLabel_2.setForeground(new Color(0, 51, 51));
		lblNewLabel_2.setFont(new Font("Script MT Bold", Font.BOLD, 26));
		lblNewLabel_2.setBounds(80, 78, 384, 68);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Welcome.class.getResource("/pictures/7.jpg")));
		lblNewLabel.setBounds(0, 0, 474, 261);
		contentPane.add(lblNewLabel);
	}
}
