/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

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
public class SupprimerClientPanel extends JPanel  implements ActionListener {

    private Fenetre frame_mere;
    
    private JLabel JLB_nomclient = new JLabel("Nom du client :");
    private JComboBox JCB_nomclient = new JComboBox();
    
    private JButton bt_cancel = new JButton("Annuler");
    private JButton bt_suppr_client = new JButton("Supprimer");
    
    public SupprimerClientPanel(Fenetre f)
    {
     
        frame_mere = f; 
        
        this.add(JLB_nomclient);
        this.add(JCB_nomclient);
        
        this.add(bt_cancel);
        this.add(bt_suppr_client);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
