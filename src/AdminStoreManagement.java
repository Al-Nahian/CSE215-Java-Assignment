import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JLabel;



public class AdminStoreManagement extends JFrame {

	private JPanel contentPane;
	//private BookCollection bookCollection = new BookCollection();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStoreManagement frame = new AdminStoreManagement();
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
	public AdminStoreManagement() {
		setTitle("Store Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 448);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 222, 173));
		panel.setBorder(new LineBorder(new Color(255, 165, 0), 3, true));
		panel.setBounds(10, 11, 528, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(34, 139, 34), 3, true));
		panel_1.setBackground(new Color(221, 160, 221));
		panel_1.setBounds(10, 53, 226, 320);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea textAreaBooks = new JTextArea();
		textAreaBooks.setFont(new Font("Palatino Linotype", Font.PLAIN, 16));
		textAreaBooks.setBackground(new Color(192, 192, 192));
		textAreaBooks.setBounds(246, 53, 272, 320);
		panel.add(textAreaBooks);
		
		JButton btnSortByIsbn = new JButton("Sort  By  ISBN");
		btnSortByIsbn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSortByIsbn.setBackground(Color.CYAN);
				btnSortByIsbn.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSortByIsbn.setBackground(UIManager.getColor("Button.background"));
				btnSortByIsbn.setForeground(new Color(102, 51, 153));
			}
		});
		btnSortByIsbn.setForeground(new Color(102, 51, 153));
		btnSortByIsbn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAddNewBook.bookCollection.sortByIsbnBooks();
					textAreaBooks.setWrapStyleWord(true);
					textAreaBooks.setLineWrap(true);
					textAreaBooks.setText(AdminAddNewBook.bookCollection.toString());
				
			}
		});
		btnSortByIsbn.setBackground(UIManager.getColor("Button.background"));
		btnSortByIsbn.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSortByIsbn.setBounds(35, 36, 156, 40);
		panel_1.add(btnSortByIsbn);
		
		JButton btnSortByPrice = new JButton("Sort  By  Price");
		btnSortByPrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSortByPrice.setBackground(Color.CYAN);
				btnSortByPrice.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSortByPrice.setBackground(UIManager.getColor("Button.background"));
				btnSortByPrice.setForeground(new Color(102, 51, 153));
			}
		});
		btnSortByPrice.setForeground(new Color(102, 51, 153));
		btnSortByPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaBooks.setText(null);
				AdminAddNewBook.bookCollection.sortByPrice();
				textAreaBooks.setLineWrap(true);
				textAreaBooks.setWrapStyleWord(true);
				textAreaBooks.setText(AdminAddNewBook.bookCollection.toString());
			}
		});
		btnSortByPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSortByPrice.setBackground(UIManager.getColor("Button.background"));
		btnSortByPrice.setBounds(35, 109, 156, 40);
		panel_1.add(btnSortByPrice);
		
		JButton btnsortByYear = new JButton("<html>Sort  By  Year  Of  Publish<html>");
		btnsortByYear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnsortByYear.setBackground(Color.CYAN);
				btnsortByYear.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnsortByYear.setBackground(UIManager.getColor("Button.background"));
				btnsortByYear.setForeground(new Color(102, 51, 153));
			}
		});
		btnsortByYear.setForeground(new Color(102, 51, 153));
		btnsortByYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaBooks.setText(null);
				AdminAddNewBook.bookCollection.sortByYearOfPublish();
				textAreaBooks.setLineWrap(true);
				textAreaBooks.setWrapStyleWord(true);
				textAreaBooks.setText(AdminAddNewBook.bookCollection.toString());
				
			}
		});
		btnsortByYear.setVerticalAlignment(SwingConstants.TOP);
		btnsortByYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsortByYear.setBackground(UIManager.getColor("Button.background"));
		btnsortByYear.setBounds(35, 181, 156, 40);
		panel_1.add(btnsortByYear);
		
		JButton btnBackToPrev = new JButton("<html>Back  To  Previous  Page<html>");
		btnBackToPrev.setVerticalAlignment(SwingConstants.TOP);
		btnBackToPrev.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBackToPrev.setBackground(Color.RED);
				btnBackToPrev.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBackToPrev.setBackground(UIManager.getColor("Button.background"));
				btnBackToPrev.setForeground(new Color(102, 51, 153));
			}
		});
		btnBackToPrev.setForeground(new Color(102, 51, 153));
		btnBackToPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminPanelWindow adminPanel = new AdminPanelWindow();
				adminPanel.setVisible(true);
			}
		});
		btnBackToPrev.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBackToPrev.setBackground(UIManager.getColor("Button.background"));
		btnBackToPrev.setBounds(35, 251, 156, 40);
		panel_1.add(btnBackToPrev);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(220, 20, 60), 2, true));
		panel_2.setBackground(new Color(255, 0, 0));
		panel_2.setBounds(243, 50, 278, 326);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(230, 230, 250), 2, true));
		panel_3.setBackground(new Color(255, 140, 0));
		panel_3.setBounds(10, 4, 508, 44);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblStoreManagement = new JLabel("Store  Management");
		lblStoreManagement.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblStoreManagement.setBounds(127, 0, 245, 44);
		panel_3.add(lblStoreManagement);
		
		
	}
}
