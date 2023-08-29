
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminLoginWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginWindow frame = new AdminLoginWindow();
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
	public AdminLoginWindow() {
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 413);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 51));
		contentPane.setBorder(new LineBorder(new Color(51, 51, 51), 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 102));
		panel.setBorder(new LineBorder(new Color(0, 0, 255), 2, true));
		panel.setBounds(10, 11, 581, 352);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 153));
		panel_1.setBounds(10, 11, 561, 60);
		panel_1.setBorder(new LineBorder(new Color(51, 51, 102), 2, true));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("ADMIN LOGIN");
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblAdminLogin.setBounds(164, 11, 225, 38);
		panel_1.add(lblAdminLogin);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 255));
		panel_2.setBorder(new LineBorder(new Color(102, 0, 255), 2, true));
		panel_2.setBounds(10, 82, 561, 259);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblUserName = new JLabel("USER NAME");
		lblUserName.setBounds(10, 23, 103, 20);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(lblUserName);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(120, 20, 270, 26);
		textFieldUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(10, 66, 103, 20);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(121, 63, 271, 27);
		panel_2.add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(12, 112, 535, 3);
		panel_2.add(separator);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(Color.CYAN);
				btnLogin.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(UIManager.getColor("Button.background"));
				btnLogin.setForeground(new Color(102, 0, 153));
			}
		});
		btnLogin.setForeground(new Color(153, 0, 204));
		btnLogin.setBackground(UIManager.getColor("Button.background"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName = textFieldUserName.getText();
				String password = passwordField.getText();
				
				File file = null;
				FileReader fr = null;
				BufferedReader br = null;
				
				String line;
				String[] values = null;
				
				try {
					file = new File("Admin.txt");
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					
					while((line = br.readLine()) != null) {
						values = line.split(" ");
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				
				if((userName.equals(values[0])) && password.equals(values[1])) {
					dispose();
					AdminPanelWindow adminPanel = new AdminPanelWindow();
					adminPanel.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid username or password", "LOGIN ERROR", JOptionPane.ERROR_MESSAGE);
					textFieldUserName.setText(null);
					passwordField.setText(null);
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnLogin.setBounds(22, 126, 128, 35);
		panel_2.add(btnLogin);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnReset.setBackground(Color.ORANGE);
				btnReset.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnReset.setBackground(UIManager.getColor("Button.background"));
				btnReset.setForeground(new Color(102, 0, 153));
			}
		});
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldUserName.setText(null);
				passwordField.setText(null);
			}
		});
		btnReset.setForeground(new Color(153, 0, 204));
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnReset.setBackground(UIManager.getColor("Button.background"));
		btnReset.setBounds(230, 126, 128, 35);
		panel_2.add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.RED);
				btnExit.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(UIManager.getColor("Button.background"));
				btnExit.setForeground(new Color(102, 0, 153));
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Exit?", "CONFIRM", JOptionPane.YES_NO_OPTION);
				if(dialogButton == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setForeground(new Color(153, 0, 204));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnExit.setBackground(UIManager.getColor("Button.background"));
		btnExit.setBounds(419, 126, 128, 35);
		panel_2.add(btnExit);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(10, 179, 537, 3);
		panel_2.add(separator_1);
		
		JButton btnGoBack = new JButton("GO BACK TO WELCOME WINDOW");
		btnGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGoBack.setBackground(Color.GREEN);
				btnGoBack.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGoBack.setBackground(UIManager.getColor("Button.background"));
				btnGoBack.setForeground(new Color(102, 0, 153));
			}
		});
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				WelcomeWindow welcomeWindow = new WelcomeWindow();
				welcomeWindow.setVisible(true);
			}
		});
		btnGoBack.setForeground(new Color(153, 0, 204));
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnGoBack.setBackground(UIManager.getColor("Button.background"));
		btnGoBack.setBounds(93, 193, 395, 43);
		panel_2.add(btnGoBack);
	}
}
