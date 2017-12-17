package gestionPhd;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class Condidatlistgui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JComboBox comboBoxSpcNom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Condidatlistgui frame = new Condidatlistgui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldDateNaissance;
	private JTextField textFieldUniv;
	private JButton btnAjouterCondidats;
	private JButton btnActualiser;
	private JLabel lblCode;
	private JTextField textFieldCode;
	public void fillComboBox() {
		
		try {
			String query="SELECT spcnom FROM specialite";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				
				comboBoxSpcNom.addItem(rs.getString("spcnom"));
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Create the frame.
	 */
	public Condidatlistgui() {
		connection=Connectionclass.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnListeDeCondidat = new JButton("Afficher La Liste De Candidats");
		btnListeDeCondidat.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnListeDeCondidat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query ="SELECT * FROM Candidat where spécialite=?  ";
					PreparedStatement pst= connection.prepareStatement(query);
					 pst.setString(1, (String)comboBoxSpcNom.getSelectedItem());
					ResultSet rs=pst.executeQuery();	
					table.setModel(DbUtils.resultSetToTableModel(rs));
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnListeDeCondidat.setBounds(280, 20, 221, 32);
		contentPane.add(btnListeDeCondidat);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(260, 63, 404, 332);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
	try {
					int row = table.getSelectedRow();
					String EID =(table.getModel().getValueAt(row,0)).toString();
					String query="SELECT * FROM Candidat where code='"+EID+"' ";
					PreparedStatement pst= connection.prepareStatement(query);
			       
					ResultSet rs=pst.executeQuery();
					
					while(rs.next()) {
						//comboBoxSpcNom.addItem(rs.getString("spcnom"));
						textFieldNom.setText(rs.getString("nom"));
						textFieldPrenom.setText(rs.getString("prenom"));
						textFieldDateNaissance.setText(rs.getString("date_naissance"));
						textFieldUniv.setText(rs.getString("universite"));
					
					
					}
					
					
					pst.close();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		lblNom.setBounds(23, 115, 50, 23);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		lblPrenom.setBounds(23, 149, 73, 23);
		contentPane.add(lblPrenom);
		
		JLabel lblDateNaissance = new JLabel("Date-Naissance");
		lblDateNaissance.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblDateNaissance.setBounds(23, 183, 109, 32);
		contentPane.add(lblDateNaissance);
		
		JLabel lblUniversite = new JLabel("Universit\u00E9");
		lblUniversite.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblUniversite.setBounds(23, 220, 95, 21);
		contentPane.add(lblUniversite);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(145, 118, 86, 20);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(145, 152, 86, 20);
		contentPane.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		textFieldDateNaissance = new JTextField();
		textFieldDateNaissance.setText("JJ-MM-AAAA");
		textFieldDateNaissance.setBounds(145, 190, 86, 20);
		contentPane.add(textFieldDateNaissance);
		textFieldDateNaissance.setColumns(10);
		
		textFieldUniv = new JTextField();
		textFieldUniv.setBounds(145, 222, 86, 20);
		contentPane.add(textFieldUniv);
		textFieldUniv.setColumns(10);
		
		btnAjouterCondidats = new JButton("Ajouter ");
		btnAjouterCondidats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nom = textFieldNom.getText(),prenom =  textFieldPrenom.getText() 
						,univ = textFieldUniv.getText() ,date =  textFieldDateNaissance.getText();
				if(! nom.isEmpty() && !prenom.isEmpty() && !univ.isEmpty() && !date.isEmpty()) {
				try {
					String query ="INSERT INTO Candidat (nom,prenom,date_naissance,universite,spécialite)" + "VALUES (?,?,?,?,?)";
					PreparedStatement pst= connection.prepareStatement(query);
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
					java.util.Date d = sdf.parse(date);
					long ms = d.getTime() ;
					java.sql.Date dn= new java.sql.Date(ms);
					pst.setString(1,nom );
					pst.setString(2,prenom);
					pst.setDate(3,dn);
					pst.setString(4,univ );
					pst.setString(5, (String)comboBoxSpcNom.getSelectedItem());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Ajouté!");
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				}else  JOptionPane.showMessageDialog(null,"Vérifier le remplissage des champs SVP", "Error ! ", JOptionPane.ERROR_MESSAGE);
				
				
			}
		});
		btnAjouterCondidats.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		btnAjouterCondidats.setBounds(63, 267, 89, 23);
		contentPane.add(btnAjouterCondidats);
		
		comboBoxSpcNom = new JComboBox();
		comboBoxSpcNom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String query="SELECT nom,prenom,date_naissance,universite FROM Candidat where spécialite=? ";
					PreparedStatement pst= connection.prepareStatement(query);
			        pst.setString(1, (String)comboBoxSpcNom.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					//regrouper les candidats par specialite
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					/*////la date
					 * String s = textFieldDateNaissance.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
					java.util.Date d = sdf.parse(s);
					long ms = d.getTime() ;
					java.sql.Date dn= new java.sql.Date(ms);
					pst.setDate(3,dn);
					while(rs.next()) {
						//comboBoxSpcNom.addItem(rs.getString("spcnom"));
						textFieldNom.setText(rs.getString("nom"));
						textFieldPrenom.setText(rs.getString("prenom"));
						textFieldDateNaissance.setText(rs.getString("date_naissance"));
						textFieldUniv.setText(rs.getString("universite"));
					}*/
					pst.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}
				
				
			}
		});
		comboBoxSpcNom.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		comboBoxSpcNom.setBounds(47, 25, 184, 22);
		contentPane.add(comboBoxSpcNom);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				String query="SELECT * FROM Candidat where spécialite=? ";
				PreparedStatement pst= connection.prepareStatement(query);
		        pst.setString(1, (String)comboBoxSpcNom.getSelectedItem());
				ResultSet rs=pst.executeQuery();
					//String query="delete from candidat where nom='"+textFieldNom.getText()+"' ";
				//	PreparedStatement pst= connection.prepareStatement(query);
					pst.execute();
					pst.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}
				
				
			}
		});
		btnSupprimer.setBounds(63, 302, 89, 23);
		contentPane.add(btnSupprimer);
		
		btnActualiser = new JButton("Actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
					String query="update candidat set nom='"+textFieldNom.getText()+"',prenom='"+textFieldPrenom.getText()+"',date_naissance='"+textFieldDateNaissance.getText()+"', universite='"+textFieldUniv.getText()+"'";
					PreparedStatement pst= connection.prepareStatement(query);
					pst.execute();
					pst.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			}
		});
		btnActualiser.setBounds(63, 336, 89, 23);
		contentPane.add(btnActualiser);
		
		lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		lblCode.setBounds(23, 81, 73, 23);
		contentPane.add(lblCode);
		
		textFieldCode = new JTextField();
		textFieldCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
try {
					
					String query="SELECT code FROM Candidat where spécialite=? ";
					PreparedStatement pst= connection.prepareStatement(query);
			        pst.setString(1, (String)comboBoxSpcNom.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					textFieldCode.setText();
					pst.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		});
		textFieldCode.setBounds(145, 81, 86, 20);
		
		contentPane.add(textFieldCode);
		textFieldCode.setColumns(10);
	
		fillComboBox();
	}
}
