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
public class RechercheInterPanel extends JPanel implements ActionListener {
    
    private Fenetre frame_mere;
    
    private JLabel JLB_critere = new JLabel("Critère de recherche :");
    private JComboBox JCB_critere = new JComboBox();    
    private Textbox JTF_critere = new Textbox();     
    private JButton bt_cancel = new JButton("Annuler");
    private JButton bt_rechercher = new JButton("Rechercher");

    public RechercheInterPanel(Fenetre f)
    {
        frame_mere = f; 
        
        JCB_critere.setPreferredSize(new Dimension(100,20));
        
        this.add(JLB_critere);
        this.add(JCB_critere);
        
        
        this.add(bt_cancel);
        this.add(bt_rechercher);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
