package gestionPhd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class FrameMenu {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMenu window = new FrameMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 583, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel main = new JPanel();
		frame.getContentPane().add(main, "name_1981718819072");
		main.setLayout(null);
		
		JButton button = new JButton("Gestion Condidats");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(253, 136, 145, 23);
		main.add(button);
		
		JButton button_1 = new JButton("Notes");
		button_1.setBounds(253, 202, 145, 23);
		main.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(253, 258, 145, 23);
		main.add(button_2);
		
		JPanel candidat = new JPanel();
		frame.getContentPane().add(candidat, "name_2090595863734");
		
		JPanel gestionCandidat = new JPanel();
		gestionCandidat.setLayout(null);
		gestionCandidat.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(gestionCandidat, "name_32376836320770");
		
		JButton button_3 = new JButton("Afficher La Liste De Candidats");
		button_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		button_3.setBounds(280, 20, 221, 32);
		gestionCandidat.add(button_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(260, 63, 404, 332);
		gestionCandidat.add(scrollPane);
		
		JLabel label = new JLabel("Nom");
		label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		label.setBounds(23, 115, 50, 23);
		gestionCandidat.add(label);
		
		JLabel label_1 = new JLabel("Prenom");
		label_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		label_1.setBounds(23, 149, 73, 23);
		gestionCandidat.add(label_1);
		
		JLabel label_2 = new JLabel("Date-Naissance");
		label_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		label_2.setBounds(23, 183, 109, 32);
		gestionCandidat.add(label_2);
		
		JLabel label_3 = new JLabel("Universit\u00E9");
		label_3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		label_3.setBounds(23, 220, 95, 21);
		gestionCandidat.add(label_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(145, 118, 86, 20);
		gestionCandidat.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(145, 152, 86, 20);
		gestionCandidat.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("JJ-MM-AAAA");
		textField_2.setColumns(10);
		textField_2.setBounds(145, 190, 86, 20);
		gestionCandidat.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(145, 222, 86, 20);
		gestionCandidat.add(textField_3);
		
		JButton button_4 = new JButton("Ajouter ");
		button_4.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		button_4.setBounds(63, 260, 89, 23);
		gestionCandidat.add(button_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		comboBox.setBounds(47, 25, 184, 22);
		gestionCandidat.add(comboBox);
		
		JButton button_5 = new JButton("Supprimer");
		button_5.setBounds(63, 294, 89, 23);
		gestionCandidat.add(button_5);
		
		JButton button_6 = new JButton("Actualiser");
		button_6.setBounds(63, 328, 89, 23);
		gestionCandidat.add(button_6);
	}
}
