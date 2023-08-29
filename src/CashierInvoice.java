import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class CashierInvoice extends JFrame {
	
	public int isbnNumber = 0;
	public final String [] isbn = new String[isbnNumber+10];
	public static Invoice inv = new Invoice();
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierInvoice frame = new CashierInvoice();
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
	public CashierInvoice() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 615);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 255, 0), 3, true));
		panel.setBackground(new Color(255, 222, 173));
		panel.setBounds(10, 11, 535, 548);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		try {
			comboBox.setSelectedItem(null);
			for(int i =0; i < AdminAddNewBook.bookCollection.getNumberOfBooks(); i++)
				comboBox.addItem(AdminAddNewBook.bookCollection.showBook(i));
		} catch (Exception e) {
			comboBox.setSelectedItem("No Items Added" + e);
		}
			
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox.setBounds(10, 82, 388, 35);
		panel.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(10, 128, 340, 409);
		panel.add(textArea);
		JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 128, 340, 409);
		panel.add(scrollPane);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea_1.setBounds(370, 245, 150, 154);
		panel.add(textArea_1);
		JScrollPane scrollPane_1 = new JScrollPane(textArea_1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setBounds(370, 245, 150, 154);
		panel.add(scrollPane_1);
		
		JButton btnSelectBook = new JButton("Select Book");
		btnSelectBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSelectBook.setBackground(Color.CYAN);
				btnSelectBook.setForeground(Color.black);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSelectBook.setBackground(UIManager.getColor("Button.background"));
				btnSelectBook.setForeground(new Color(0, 0, 0));
			}
		});
		btnSelectBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = (String)comboBox.getSelectedItem(),string=null;
				File file = new File("SelectedBooks.txt");
				BufferedReader br = null;
				PrintWriter pw = null;
				String[] values = null;
				
				try {
					
					pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
					pw.println(str);
					JOptionPane.showMessageDialog(null, "Added to Cart!");
					
					pw.close();
					br = new BufferedReader(new FileReader(file));
					while ((string = br.readLine())!=null) {
						values = string.split(" ");
					}
					br.close();
					isbn[isbnNumber++] = values[1];
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnSelectBook.setBounds(408, 84, 112, 30);
		panel.add(btnSelectBook);
		
		JButton btnNewButton = new JButton("Print Invoice");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(Color.CYAN);
				btnNewButton.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(UIManager.getColor("Button.background"));
				btnNewButton.setForeground(new Color(0, 0, 0));
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Book b = new Book();
				for (int i = 0; i < isbn.length; i++) {
					try {
					while((isbn[i]!=null)) {
					b=AdminAddNewBook.bookCollection.getBook(AdminAddNewBook.bookCollection.searchBookObj(isbn[i]));
					inv.addBook(b);
					}
					}catch (Exception ex) {
						// TODO: handle exception
					}
				}
				
					textField.setText(inv.getParchaseDate());
					textArea.setText(inv.toString());
					String stri = inv.totalPrice();
					textArea_1.setText(stri);
				
			}
		});
		
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnNewButton.setBounds(370, 410, 150, 35);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 255, 0), 3, true));
		panel_1.setBackground(new Color(255, 165, 0));
		panel_1.setBounds(10, 11, 514, 59);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblInvoice = new JLabel("INVOICE");
		lblInvoice.setFont(new Font("Serif", Font.BOLD, 35));
		lblInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoice.setBounds(159, 11, 185, 37);
		panel_1.add(lblInvoice);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.RED);
				btnExit.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(UIManager.getColor("Button.background"));
				btnExit.setForeground(new Color(0, 0, 0));
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				WelcomeWindow welcome = new WelcomeWindow();
				welcome.setVisible(true);
			}
		});
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnExit.setBounds(370, 502, 150, 35);
		panel.add(btnExit);
		
		JButton btnResetInvoice = new JButton("Reset Invoice");
		btnResetInvoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnResetInvoice.setBackground(Color.ORANGE);
				btnResetInvoice.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnResetInvoice.setBackground(UIManager.getColor("Button.background"));
				btnResetInvoice.setForeground(new Color(0, 0, 0));
			}
		});
		btnResetInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				textField.setText(null);
				textArea_1.setText(null);
			}
		});
		btnResetInvoice.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnResetInvoice.setBounds(370, 456, 150, 35);
		panel.add(btnResetInvoice);
		
		JLabel lblParchasePriceAnd = new JLabel("<html>Parchase Price And Date :<html>");
		lblParchasePriceAnd.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		lblParchasePriceAnd.setBounds(370, 128, 150, 35);
		panel.add(lblParchasePriceAnd);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField.setBounds(369, 174, 151, 43);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(370, 223, 150, 23);
		panel.add(lblPrice);
		
		
	}
}
