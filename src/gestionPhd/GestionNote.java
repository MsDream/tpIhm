package gestionPhd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.stream.events.Namespace;

import javafx.scene.layout.Pane;

import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;

public class GestionNote extends JFrame {

	private JPanel contentPane;
	private static Connection connection;
	
	/**
	 * Code 
	 */
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {


					GestionNote frame = new GestionNote();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public static void fillComboBox() {
		
		try {
			String query="SELECT spcnom FROM specialite";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				comboSpec.addItem(rs.getString("spcnom"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
public  void fillComboBoxModele(String nomSpec) {
	
	try {
		String query="SELECT examennom From examen where examen.spcnom = ?";
		PreparedStatement pst=connection.prepareStatement(query);
		pst.setString(1, nomSpec);
		ResultSet rs=pst.executeQuery();
		
		comboModele.removeAllItems();
		while(rs.next()) {
			comboModele.addItem(rs.getString("examennom"));
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

	
	

	/**
	 * Create the frame.
	 */
	
	public GestionNote() {
		connection = (Connection) Connectionclass.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		 PaneChois = new JPanel();
		contentPane.add(PaneChois, "name_2380330659743");
		PaneChois.setLayout(null);
		
		comboSpec = new JComboBox();
		
		comboSpec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboSpec.getSelectedItem() != null) {
					String nameSpec =comboSpec.getSelectedItem().toString();
					fillComboBoxModele(nameSpec);
				}
			}
		});
		comboSpec.setBounds(146, 122, 174, 31);
		PaneChois.add(comboSpec);
		
		comboModele = new JComboBox();
		comboModele.setBounds(146, 222, 174, 31);
		PaneChois.add(comboModele);
		
		JLabel lblSpec = new JLabel("Spec");
		lblSpec.setBounds(146, 97, 46, 14);
		PaneChois.add(lblSpec);
		
		JLabel lblModele = new JLabel("Modele");
		lblModele.setBounds(146, 188, 46, 14);
		PaneChois.add(lblModele);
		
		JButton btnSaisieLesNote = new JButton("saisie les note ");
		btnSaisieLesNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String namSpec = comboSpec.getSelectedItem().toString();
				String nameModele = comboModele.getSelectedItem().toString();
				if(!namSpec.isEmpty()&& ! nameModele.isEmpty()) {
					PaneChois.setVisible(false);
					
					PanelSaisie.setVisible(true);
					fillSaisiePane(namSpec,nameModele);
				}
			}

			private void fillSaisiePane(String nameSpace,String nameModel) {
				// TODO Auto-generated method stub
				ArrayList<Integer> arr = new ArrayList();
				try {
					String query="SELECT code From candidat WHERE candidat.spécialite = ?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, nameSpace);
					ResultSet rs=pst.executeQuery();
					
					arr.clear();
					while(rs.next()) {
						arr.add(rs.getInt("code"));
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				try {
					JPanel l = new JPanel();
					GridLayout grid = new GridLayout();
					grid.setColumns(5);
					grid.setRows(arr.size());
					l.setLayout(grid);
					l.setPreferredSize(new Dimension(400, arr.size()*15));
					for (Integer ide : arr) {
						JLabel labname = new JLabel(ide.toString());
						labname.setSize(15, 15);
						System.out.print(",kd");
						l.add(labname);
					}
					l.setVisible(true);
					MainPane.add(l);
					MainPane.setVisible(true);
					
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		});
		btnSaisieLesNote.setForeground(Color.GREEN);
		btnSaisieLesNote.setBounds(396, 318, 134, 31);
		PaneChois.add(btnSaisieLesNote);
		
		 PanelSaisie = new JPanel();
		contentPane.add(PanelSaisie, "name_2389622295141");
		PanelSaisie.setLayout(null);
		
		MainPane = new JScrollPane();
		MainPane.setBounds(0, 454, 549, -410);
		PanelSaisie.add(MainPane);
		fillComboBox();
	
	}
	
	private static JComboBox comboSpec;
	private  JComboBox comboModele;
	private JPanel PanelSaisie;
	private JPanel PaneChois;
	private JScrollPane MainPane;
}
