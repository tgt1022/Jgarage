/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Utilisateur
 */
public class ModifierVehPanel extends JPanel implements ActionListener {

    private Fenetre frame_mere;
    
    private JLabel JLB_nomclient = new JLabel("Nom du client :");
    private JComboBox JCB_nomclient = new JComboBox();
    private JLabel JLB_immatriculation = new JLabel("Immatriculation :");
    private JComboBox JCB_immatriculation = new JComboBox();
    
    private Textbox JTF_immatriculation = new Textbox();    
    private Textbox JTF_marque = new Textbox();
    private JLabel JLB_marque = new JLabel("Marque :");
    private Textbox JTF_modele = new Textbox();
    private JLabel JLB_modele = new JLabel("Modèle :");
    private Textbox JTF_couleur = new Textbox();
    private JLabel JLB_couleur = new JLabel("Couleur :");
    private Textbox JTF_kilometrage = new Textbox();
    private JLabel JLB_kilometrage = new JLabel("Kilométrage :");
    private Textbox JTF_nbplace = new Textbox();
    private JLabel JLB_nbplace = new JLabel("Nombre de place :");
    private JFormattedTextField JTF_annee = new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JLabel JLB_annee = new JLabel("Année :");    
    
    private JButton bt_cancel = new JButton("Annuler");
    private JButton bt_save_veh = new JButton("Enregistrer modification");
    
    public ModifierVehPanel(Fenetre f)
    {
        frame_mere = f;     
        
        this.setLayout(new GridLayout(9,8));
        
        JCB_immatriculation.setPreferredSize(new Dimension(100,20));
        JCB_nomclient.setPreferredSize(new Dimension(100,20));
        
        this.add(JLB_nomclient);
        this.add(JCB_nomclient);
         
        this.add(JLB_immatriculation);
        this.add(JCB_immatriculation);
        
//        this.add(JLB_immatriculation);
//        this.add(JTF_immatriculation);
        
        this.add(JLB_marque);
        this.add(JTF_marque);
      
        
        this.add(JLB_modele);
        this.add(JTF_modele);
       
        
        this.add(JLB_couleur);
        this.add(JTF_couleur);          
        
        this.add(JLB_kilometrage);
        this.add(JTF_kilometrage);         
        
        this.add(JLB_nbplace);
        this.add(JTF_nbplace); 
      
        
        this.add(JLB_annee);
        
        JTF_annee.setPreferredSize(new Dimension(150,10));      
        this.add(JTF_annee);
        
        
        bt_cancel.addActionListener(this);
        bt_save_veh.addActionListener(this);
        
        this.add(bt_cancel);
        this.add(bt_save_veh);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
