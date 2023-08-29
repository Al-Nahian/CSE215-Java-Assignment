import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminBookInformation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminBookInformation frame = new AdminBookInformation();
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
	public AdminBookInformation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 448);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 102));
		panel.setBorder(new LineBorder(Color.RED, 2, true));
		panel.setBounds(10, 11, 528, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(185, 70, 333, 300);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		
		JButton btnShowBookInfo = new JButton("Show Book Info");
		btnShowBookInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnShowBookInfo.setBackground(Color.CYAN);
				btnShowBookInfo.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnShowBookInfo.setBackground(UIManager.getColor("Button.background"));
				btnShowBookInfo.setForeground(new Color(0, 0, 0));
			}
		});
		btnShowBookInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(AdminAddNewBook.bookCollection.toString());
			}
		});
		btnShowBookInfo.setFont(new Font("Serif", Font.BOLD, 14));
		btnShowBookInfo.setBounds(25, 105, 136, 48);
		panel.add(btnShowBookInfo);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGoBack.setBackground(Color.RED);
				btnGoBack.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGoBack.setBackground(UIManager.getColor("Button.background"));
				btnGoBack.setForeground(new Color(0, 0, 0));
			}
		});
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminPanelWindow adminPanel = new AdminPanelWindow();
				adminPanel.setVisible(true);
			}
		});
		btnGoBack.setFont(new Font("Serif", Font.BOLD, 14));
		btnGoBack.setBounds(25, 264, 136, 48);
		panel.add(btnGoBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
		panel_1.setBackground(new Color(255, 99, 71));
		panel_1.setBounds(10, 11, 508, 48);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblShowBookInformation = new JLabel("Book Information");
		lblShowBookInformation.setBounds(150, 0, 211, 48);
		panel_1.add(lblShowBookInformation);
		lblShowBookInformation.setFont(new Font("Times New Roman", Font.BOLD, 27));
		
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
				btnReset.setForeground(new Color(0, 0, 0));
			}
		});
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
			}
		});
		btnReset.setFont(new Font("Serif", Font.BOLD, 14));
		btnReset.setBounds(25, 183, 136, 48);
		panel.add(btnReset);
		
	}
}
