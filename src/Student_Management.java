import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JMenu;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JCheckBoxMenuItem;
import java.awt.GridLayout;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Student_Management extends JFrame {
	/******page=0 ==> Modify_student, page=1 ==> delete_student*****/
	public static int page=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Management frame = new Student_Management();
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
	public Student_Management() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 23);
		getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("LogOut ");
		mnNewMenu.setFont(new Font("Script MT Bold", Font.BOLD, 14));
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App_Login a= new App_Login();
				a.setVisible(true);
				dispose();
			}
		});
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit window");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App_Login a= new App_Login();
				a.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JButton btnNewButton = new JButton("MODIFY_STUDENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search  m= new Search();;
				m.setVisible(true);
				Search.display();
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(204, 204, 204));
		btnNewButton.setBackground(new Color(0, 51, 51));
		btnNewButton.setBounds(155, 93, 137, 32);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ADD_STUDENT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Add_student a= new Add_student();
				a.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setForeground(new Color(204, 204, 204));
		btnNewButton_1.setBackground(new Color(0, 51, 51));
		btnNewButton_1.setBounds(155, 38, 137, 32);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE_STUDENT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_Management.page=1;
				Search  d= new Search();
				d.setVisible(true);
				Search.display();
				dispose();	
			}
		});
		btnNewButton_2.setForeground(new Color(204, 204, 204));
		btnNewButton_2.setBackground(new Color(0, 51, 51));
		btnNewButton_2.setBounds(155, 149, 137, 32);
		getContentPane().add(btnNewButton_2);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBackground(new Color(0, 51, 51));
		btnSearch.setForeground(new Color(204, 204, 204));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search  d= new Search();
				d.setVisible(true);
				Search.display();
				dispose();
			}
		});
		btnSearch.setBounds(155, 205, 137, 32);
		getContentPane().add(btnSearch);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(0, 51, 51));
		lblNewLabel.setIcon(new ImageIcon(Student_Management.class.getResource("/pictures/7.jpg")));
		lblNewLabel.setBounds(0, 25, 434, 236);
		getContentPane().add(lblNewLabel);
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	private void closeTheCurrentFrameAndOpenNew(java.awt.event.ActionEvent evt){

		 dispose();//To close the current window

		Student_Management closeCurrentWindow = new Student_Management();
		 closeCurrentWindow.setVisible(true);//Open the new window

		}
}
