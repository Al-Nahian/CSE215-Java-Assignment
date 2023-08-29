
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminAddNewBook extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAuthorName;
	private JTextField textFieldAuthorEmail;
	private JTextField textFieldAuthorGender;
	private JTextField textFieldAuthorAge;
	private JTextField textFieldBookName;
	private JTextField textFieldBookPrice;
	private JTextField textFieldBookDiscount;
	private JTextField textFieldBookGenre;
	private JTextField textFieldBookSubGenre;
	private JTextField textFieldBookIsbn;
	private JTextField textFieldBookPublishYear;
	
	private Author author = null;
	private Book book = null;
	public static BookCollection bookCollection = new BookCollection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAddNewBook frame = new AdminAddNewBook();
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
	public AdminAddNewBook() {
		setTitle("Book Add Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 51));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 51), 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 153));
		panel.setBorder(new LineBorder(new Color(0, 0, 255), 2, true));
		panel.setBounds(10, 11, 768, 434);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 204));
		panel_1.setBorder(new LineBorder(new Color(102, 0, 255), 2, true));
		panel_1.setBounds(10, 11, 375, 256);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAuthorInformation = new JLabel("AUTHOR INFORMATION");
		lblAuthorInformation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAuthorInformation.setBounds(71, 11, 227, 23);
		panel_1.add(lblAuthorInformation);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(57, 45, 241, 2);
		panel_1.add(separator);
		
		JLabel lblAuthorName = new JLabel("NAME");
		lblAuthorName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAuthorName.setBounds(10, 58, 52, 23);
		panel_1.add(lblAuthorName);
		
		textFieldAuthorName = new JTextField();
		textFieldAuthorName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textFieldAuthorName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldAuthorName.setBounds(71, 58, 283, 23);
		panel_1.add(textFieldAuthorName);
		textFieldAuthorName.setColumns(10);
		
		JLabel lblAuthorEmail = new JLabel("EMAIL");
		lblAuthorEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAuthorEmail.setBounds(10, 113, 52, 23);
		panel_1.add(lblAuthorEmail);
		
		textFieldAuthorEmail = new JTextField();
		textFieldAuthorEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textFieldAuthorEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldAuthorEmail.setColumns(10);
		textFieldAuthorEmail.setBounds(71, 110, 283, 23);
		panel_1.add(textFieldAuthorEmail);
		
		JLabel lblAuthorGender = new JLabel("GENDER");
		lblAuthorGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAuthorGender.setBounds(10, 167, 73, 23);
		panel_1.add(lblAuthorGender);
		
		textFieldAuthorGender = new JTextField();
		textFieldAuthorGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textFieldAuthorGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldAuthorGender.setColumns(10);
		textFieldAuthorGender.setBounds(93, 166, 111, 23);
		panel_1.add(textFieldAuthorGender);
		
		JComboBox comboBoxAuthorGender = new JComboBox();
		comboBoxAuthorGender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comboBoxAuthorGender.setBackground(Color.CYAN);
				comboBoxAuthorGender.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				comboBoxAuthorGender.setBackground(UIManager.getColor("Button.background"));
				comboBoxAuthorGender.setForeground(Color.BLACK);
			}
		});
		comboBoxAuthorGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldAuthorGender.setText(comboBoxAuthorGender.getSelectedItem().toString());
			}
		});
		comboBoxAuthorGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBoxAuthorGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxAuthorGender.setBounds(266, 163, 88, 27);
		panel_1.add(comboBoxAuthorGender);
		
		JLabel lblAuthorAge = new JLabel("AGE");
		lblAuthorAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAuthorAge.setBounds(10, 216, 37, 23);
		panel_1.add(lblAuthorAge);
		
		textFieldAuthorAge = new JTextField();
		textFieldAuthorAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldAuthorAge.setColumns(10);
		textFieldAuthorAge.setBounds(70, 213, 58, 23);
		panel_1.add(textFieldAuthorAge);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 204));
		panel_2.setBorder(new LineBorder(new Color(102, 0, 153), 2, true));
		panel_2.setBounds(395, 11, 363, 408);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblBookInformation = new JLabel("BOOK INFORMATION");
		lblBookInformation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBookInformation.setBounds(80, 11, 203, 23);
		panel_2.add(lblBookInformation);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(62, 45, 241, 2);
		panel_2.add(separator_1);
		
		JLabel lblBookName = new JLabel("NAME");
		lblBookName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBookName.setBounds(10, 59, 50, 23);
		panel_2.add(lblBookName);
		
		textFieldBookName = new JTextField();
		textFieldBookName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldBookName.setColumns(10);
		textFieldBookName.setBounds(72, 58, 273, 23);
		panel_2.add(textFieldBookName);
		
		JLabel lblBookPrice = new JLabel("PRICE");
		lblBookPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBookPrice.setBounds(10, 108, 50, 23);
		panel_2.add(lblBookPrice);
		
		textFieldBookPrice = new JTextField();
		textFieldBookPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldBookPrice.setColumns(10);
		textFieldBookPrice.setBounds(72, 107, 106, 23);
		panel_2.add(textFieldBookPrice);
		
		JLabel lblBookDiscount = new JLabel("DISCOUNT");
		lblBookDiscount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBookDiscount.setBounds(10, 155, 86, 23);
		panel_2.add(lblBookDiscount);
		
		textFieldBookDiscount = new JTextField();
		textFieldBookDiscount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldBookDiscount.setColumns(10);
		textFieldBookDiscount.setBounds(101, 154, 106, 23);
		panel_2.add(textFieldBookDiscount);
		
		JLabel lblBookGenre = new JLabel("GENRE");
		lblBookGenre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBookGenre.setBounds(10, 206, 74, 23);
		panel_2.add(lblBookGenre);
		
		textFieldBookGenre = new JTextField();
		textFieldBookGenre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldBookGenre.setColumns(10);
		textFieldBookGenre.setBounds(101, 205, 106, 23);
		panel_2.add(textFieldBookGenre);
		
		JComboBox comboBoxBookGenre = new JComboBox();
		comboBoxBookGenre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comboBoxBookGenre.setBackground(Color.CYAN);
				comboBoxBookGenre.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				comboBoxBookGenre.setBackground(UIManager.getColor("Button.background"));
				comboBoxBookGenre.setForeground(Color.BLACK);
			}
		});
		comboBoxBookGenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldBookGenre.setText(comboBoxBookGenre.getSelectedItem().toString());
			}
		});
		comboBoxBookGenre.setModel(new DefaultComboBoxModel(new String[] {"Fiction", "Non-Fiction"}));
		comboBoxBookGenre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxBookGenre.setBounds(251, 205, 94, 24);
		panel_2.add(comboBoxBookGenre);
		
		JLabel lblBookSubGenre = new JLabel("SUB GENRE");
		lblBookSubGenre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBookSubGenre.setBounds(10, 257, 86, 23);
		panel_2.add(lblBookSubGenre);
		
		textFieldBookSubGenre = new JTextField();
		textFieldBookSubGenre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldBookSubGenre.setColumns(10);
		textFieldBookSubGenre.setBounds(101, 257, 106, 23);
		panel_2.add(textFieldBookSubGenre);
		
		JLabel lblBookIsbn = new JLabel("ISBN");
		lblBookIsbn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBookIsbn.setBounds(10, 308, 50, 23);
		panel_2.add(lblBookIsbn);
		
		textFieldBookIsbn = new JTextField();
		textFieldBookIsbn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldBookIsbn.setColumns(10);
		textFieldBookIsbn.setBounds(72, 307, 273, 23);
		panel_2.add(textFieldBookIsbn);
		
		JLabel lblYearOfPublish = new JLabel("YEAR OF PUBLISH");
		lblYearOfPublish.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblYearOfPublish.setBounds(10, 358, 142, 23);
		panel_2.add(lblYearOfPublish);
		
		textFieldBookPublishYear = new JTextField();
		textFieldBookPublishYear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldBookPublishYear.setColumns(10);
		textFieldBookPublishYear.setBounds(162, 357, 106, 23);
		panel_2.add(textFieldBookPublishYear);
		
		JButton btnAddBookToCollection = new JButton("ADD BOOK TO COLLECTION");
		btnAddBookToCollection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAddBookToCollection.setBackground(Color.GREEN);
				btnAddBookToCollection.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAddBookToCollection.setBackground(UIManager.getColor("Button.background"));
				btnAddBookToCollection.setForeground(new Color(51, 0, 102));
			}
		});
		btnAddBookToCollection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("Books.txt");
				PrintWriter pw = null;
				String authorName = textFieldAuthorName.getText();
				String authorEmail = textFieldAuthorEmail.getText();
				String authorGender = textFieldAuthorGender.getText();
				int authorAge = Integer.parseInt(textFieldAuthorAge.getText());
				author = new Author(authorName, authorEmail, authorAge, authorGender);
				
				String bookName = textFieldBookName.getText();
				double price = Double.parseDouble(textFieldBookPrice.getText());
				double discount = Double.parseDouble(textFieldBookDiscount.getText());
				Genre genre;
				String subGenre = textFieldBookSubGenre.getText();
				if(textFieldBookGenre.equals("Fiction")) {
					genre = new Fiction(subGenre);
				}
				else {
					genre = new NonFiction(subGenre);
				}
				
				String isbn = textFieldBookIsbn.getText();
				int publishYear = Integer.parseInt(textFieldBookPublishYear.getText());
				book = new Book(bookName, price, author, discount, genre, isbn, publishYear);
				JOptionPane.showMessageDialog(null, "Succesfully Added!");
				try {
					pw = new PrintWriter(file);
					pw.println(textFieldBookName.getText());
					pw.println(textFieldBookPrice.getText());
					pw.println(authorName);
					pw.println(authorEmail);
					pw.println(authorGender);
					pw.println(authorAge);
					pw.println(textFieldBookDiscount.getText());
					pw.println(textFieldBookGenre.getText());
					pw.println(subGenre);
					pw.println(isbn);
					pw.println(publishYear);
					pw.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				bookCollection.addBook(book);

				textFieldAuthorName.setText(null);
				textFieldAuthorEmail.setText(null);
				comboBoxAuthorGender.setSelectedIndex(0);
				textFieldAuthorGender.setText(null);
				textFieldAuthorAge.setText(null);
				textFieldBookName.setText(null);
				textFieldBookPrice.setText(null);
				textFieldBookDiscount.setText(null);
				comboBoxBookGenre.setSelectedIndex(0);
				textFieldBookGenre.setText(null);
				textFieldBookSubGenre.setText(null);
				textFieldBookIsbn.setText(null);
				textFieldBookPublishYear.setText(null);
			}
		});
		btnAddBookToCollection.setBackground(UIManager.getColor("Button.background"));
		btnAddBookToCollection.setForeground(new Color(51, 0, 102));
		btnAddBookToCollection.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddBookToCollection.setBounds(47, 291, 297, 33);
		panel.add(btnAddBookToCollection);
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGoBack.setBackground(Color.RED);
				btnGoBack.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGoBack.setForeground(new Color(51, 0, 102));
				btnGoBack.setBackground(UIManager.getColor("Button.background"));
			}
		});
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminPanelWindow adminPanel = new AdminPanelWindow();
				adminPanel.setVisible(true);
			}
		});
		btnGoBack.setForeground(new Color(51, 0, 102));
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGoBack.setBackground(UIManager.getColor("Button.background"));
		btnGoBack.setBounds(47, 345, 297, 33);
		panel.add(btnGoBack);
	}
}
