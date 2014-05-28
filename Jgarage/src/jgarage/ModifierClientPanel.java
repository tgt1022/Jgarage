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
public class ModifierClientPanel extends JPanel implements ActionListener{
    
    private Fenetre frame_mere;
    
    private Textbox JTF_nomclient = new Textbox();
    private JLabel JLB_nomclient = new JLabel("Nom du client :");
    private Textbox JTF_prenomclient = new Textbox();
    private JLabel JLB_prenomclient = new JLabel("Prénom du client :");
    private Textbox JTF_adresse = new Textbox();
    private JLabel JLB_adresse = new JLabel("Adresse :");
    private Textbox JTF_email = new Textbox();
    private JLabel JLB_email = new JLabel("E-mail :");

    private JButton bt_cancel = new JButton("Annuler");
    private JButton bt_modif_client = new JButton("Enregistrer modification");
    
    public ModifierClientPanel(Fenetre f)
    {
        frame_mere = f; 
        
        this.add(JLB_nomclient);
        this.add(JTF_nomclient);                
        this.add(JLB_prenomclient);
        this.add(JTF_prenomclient);        
        this.add(JLB_adresse);
        this.add(JTF_adresse);        
        this.add(JLB_email);
        this.add(JTF_email); 
        
        this.add(bt_cancel);
        this.add(bt_modif_client);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
