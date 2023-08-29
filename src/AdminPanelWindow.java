import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminPanelWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanelWindow frame = new AdminPanelWindow();
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
	public AdminPanelWindow() {
		setTitle("Admin Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 448);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 51));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 102), 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 102, 255));
		panel.setBorder(new LineBorder(new Color(51, 51, 0), 2, true));
		panel.setBounds(10, 11, 534, 387);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 51));
		panel_1.setBorder(new LineBorder(new Color(0, 51, 51), 2, true));
		panel_1.setBounds(10, 11, 514, 72);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAdminPanel = new JLabel("ADMIN PANEL");
		lblAdminPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminPanel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblAdminPanel.setBounds(132, 11, 239, 50);
		panel_1.add(lblAdminPanel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 153));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 51), 2, true));
		panel_2.setBounds(10, 94, 514, 282);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAddNewBook = new JButton("ADD NEW BOOK");
		btnAddNewBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAddNewBook.setBackground(Color.CYAN);
				btnAddNewBook.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAddNewBook.setBackground(UIManager.getColor("Button.background"));
				btnAddNewBook.setForeground(new Color(204, 0, 153));
			}
		});
		btnAddNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminAddNewBook adminNewBook = new AdminAddNewBook();
				adminNewBook.setVisible(true);
			}
		});
		btnAddNewBook.setBackground(UIManager.getColor("Button.background"));
		btnAddNewBook.setForeground(new Color(204, 0, 153));
		btnAddNewBook.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddNewBook.setBounds(131, 31, 241, 34);
		panel_2.add(btnAddNewBook);
		
		JButton btnManageMyStore = new JButton("MANAGE MY STORE");
		btnManageMyStore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnManageMyStore.setBackground(Color.CYAN);
				btnManageMyStore.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnManageMyStore.setBackground(UIManager.getColor("Button.background"));
				btnManageMyStore.setForeground(new Color(204, 0, 153));
			}
		});
		btnManageMyStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminStoreManagement adminStore = new AdminStoreManagement();
				adminStore.setVisible(true);
			}
		});
		btnManageMyStore.setForeground(new Color(204, 0, 153));
		btnManageMyStore.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnManageMyStore.setBackground(UIManager.getColor("Button.background"));
		btnManageMyStore.setBounds(131, 93, 241, 34);
		panel_2.add(btnManageMyStore);
		
		JButton btnBooksInformation = new JButton("BOOKS INFORMATION");
		btnBooksInformation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBooksInformation.setBackground(Color.CYAN);
				btnBooksInformation.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBooksInformation.setBackground(UIManager.getColor("Button.background"));
				btnBooksInformation.setForeground(new Color(204, 0, 153));
			}
		});
		btnBooksInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminBookInformation bookInfo = new AdminBookInformation();
				bookInfo.setVisible(true);
			}
		});
		btnBooksInformation.setForeground(new Color(204, 0, 153));
		btnBooksInformation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBooksInformation.setBackground(UIManager.getColor("Button.background"));
		btnBooksInformation.setBounds(131, 153, 241, 34);
		panel_2.add(btnBooksInformation);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogOut.setBackground(Color.RED);
				btnLogOut.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogOut.setBackground(UIManager.getColor("Button.background"));
				btnLogOut.setForeground(new Color(204, 0, 153));
			}
		});
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				WelcomeWindow welcome = new WelcomeWindow();
				welcome.setVisible(true);
			}
		});
		btnLogOut.setForeground(new Color(204, 0, 153));
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogOut.setBackground(UIManager.getColor("Button.background"));
		btnLogOut.setBounds(131, 208, 241, 34);
		panel_2.add(btnLogOut);
	}
}
