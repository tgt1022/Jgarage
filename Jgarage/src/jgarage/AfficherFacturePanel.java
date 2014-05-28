/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Utilisateur
 */
public class AfficherFacturePanel extends JPanel implements ActionListener {

    private Fenetre frame_mere;
    
    private Textbox JTF_dateFacture = new Textbox();
    private JLabel JLB_dateFacture = new JLabel("Date d'emission de la facture :");
    private Textbox JTF_montantFacture = new Textbox();
    private JLabel JLB_montantFacture = new JLabel("Montant de la facture :");
    
    private JButton bt_precedentInter = new JButton(" <- Précédent");
    private JButton bt_suivantInter = new JButton("Suivant ->");
    
    /* Intervention rattaché à la facture */
    
    public AfficherFacturePanel(Fenetre f)
    {
        frame_mere = f;
        
        this.add(JTF_dateFacture);
        this.add(JLB_dateFacture);                
        this.add(JTF_montantFacture);
        this.add(JLB_montantFacture); 
        
        this.add(bt_precedentInter);
        this.add(bt_suivantInter);        
         
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
