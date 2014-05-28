/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 *
 * @author Utilisateur
 */
public class GestionInterPanel extends JPanel implements ActionListener {
    
    private Image img;  
    private BoutonMenu bt_precedent = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_precedent.png")));
    private BoutonMenu bt_saveinter = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_saveinter.png")));
    private BoutonMenu bt_rechercherinter = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_rechercheinter.png")));
    private BoutonMenu bt_modiferinter = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_modifierinter.png")));
    private BoutonMenu bt_supprinter = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_supprinter.png")));
    private BoutonMenu bt_afficherinter = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_afficherinter.png")));
    private Fenetre frame_mere;
    
    public GestionInterPanel(String img,Fenetre f){
        this(new ImageIcon(img).getImage(),f);
    }
    
    public GestionInterPanel(Image img,Fenetre f){
        frame_mere = f;
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);

        /* On positionne les boutons aux coordonnées mentionnées */
        bt_precedent.setBounds(7, 7, 66, 37);
        bt_saveinter.setBounds(60, 151, 179, 76);
        bt_rechercherinter.setBounds(341, 352, 205, 76);
        bt_modiferinter.setBounds(354, 151, 182, 76);
        bt_supprinter.setBounds(198, 241, 196, 75);
        bt_afficherinter.setBounds(54, 347, 209, 82);
        
        bt_precedent.addActionListener(this);
        bt_saveinter.addActionListener(this);
        bt_rechercherinter.addActionListener(this);
        bt_modiferinter.addActionListener(this);
        bt_supprinter.addActionListener(this);
        bt_afficherinter.addActionListener(this);                
                
        /* On ajoute les bouton au Panel */
        this.add(bt_saveinter);
        this.add(bt_rechercherinter);
        this.add(bt_modiferinter);
        this.add(bt_supprinter);
        this.add(bt_precedent);
        this.add(bt_afficherinter);
    }
    
    public void paintComponent(Graphics g){
        g.drawImage(img,0,0,null);
       
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton button = (JButton)e.getSource();
        
        if ( button==bt_precedent )
        {
            this.setVisible(false);
            frame_mere.affiche_page_gestionA();
        }
        else if ( button==bt_saveinter)
        {
            this.setVisible(false);
            frame_mere.affiche_page_saveinter();
        }
        
    }
}
