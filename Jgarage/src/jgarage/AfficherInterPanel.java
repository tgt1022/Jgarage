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
public class AfficherInterPanel extends JPanel implements ActionListener {
    
    private Fenetre frame_mere;
    
    private Textbox JTF_nature = new Textbox();
    private JLabel JLB_nature = new JLabel("Nature de l'intervention :");
    private Textbox JTF_prix = new Textbox();
    private JLabel JLB_prix = new JLabel("Prix de l'intervention :");
    private Textbox JTF_dateDebut = new Textbox();
    private JLabel JLB_dateDebut = new JLabel("Date début :");
    private Textbox JTF_dateFin = new Textbox();
    private JLabel JLB_dateFin = new JLabel("Date fin :");
    
    private JButton bt_precedentInter = new JButton(" <- Précédent");
    private JButton bt_suivantInter = new JButton("Suivant ->");
    
    /* Plus l'ensemble des interventions associés a tel ou tel vehicule */
    
    public AfficherInterPanel(Fenetre f)
    {
        frame_mere = f;
        
        frame_mere = f;
                
        this.add(JLB_nature);
        this.add(JTF_nature);
        this.add(JLB_prix);
        this.add(JTF_prix);
        this.add(JLB_dateDebut);
        this.add(JTF_dateDebut);
        this.add(JLB_dateFin);
        this.add(JTF_dateFin);
        
        this.add(bt_precedentInter);
        this.add(bt_suivantInter);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
