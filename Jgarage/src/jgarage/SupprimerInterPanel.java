/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Utilisateur
 */
public class SupprimerInterPanel extends JPanel  implements ActionListener {
    
    private Fenetre frame_mere;
    
    private JLabel JLB_nomclient = new JLabel("Nom du client :");
    private JComboBox JCB_nomclient = new JComboBox();
    private JLabel JLB_immatriculation = new JLabel("Immatriculation :");
    private JComboBox JCB_immatriculation = new JComboBox();
    
    private Textbox JTF_nature = new Textbox();
    private JLabel JLB_nature = new JLabel("Nature de l'intervention :");
    private Textbox JTF_prix = new Textbox();
    private JLabel JLB_prix = new JLabel("Prix de l'intervention :");
    private Textbox JTF_dateDebut = new Textbox();
    private JLabel JLB_dateDebut = new JLabel("Date début :");
    private Textbox JTF_dateFin = new Textbox();
    private JLabel JLB_dateFin = new JLabel("Date fin :");
    
    private JButton bt_cancel = new JButton("Annuler");
    private JButton bt_suppr_inter = new JButton("Supprimer");
    
    public SupprimerInterPanel(Fenetre f)
    {
        frame_mere = f; 
        
        this.add(JLB_nomclient);
        this.add(JCB_nomclient);
        this.add(JLB_immatriculation);
        this.add(JCB_immatriculation);
        JCB_immatriculation.setPreferredSize(new Dimension(100,20));
        JCB_nomclient.setPreferredSize(new Dimension(100,20));
        
        this.add(JLB_nature);
        this.add(JTF_nature);
        this.add(JLB_prix);
        this.add(JTF_prix);
        this.add(JLB_dateDebut);
        this.add(JTF_dateDebut);
        this.add(JLB_dateFin);
        this.add(JTF_dateFin);
        
        this.add(bt_cancel);
        this.add(bt_suppr_inter);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        
        if ( button==bt_cancel )
        {
            this.setVisible(false);
            frame_mere.affiche_page_gestionVeh();
        }
        else
        {
            
        }
    }
}
