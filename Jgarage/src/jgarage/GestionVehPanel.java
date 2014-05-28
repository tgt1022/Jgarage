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
public class GestionVehPanel extends JPanel implements ActionListener {
    
    private Image img;  
    private BoutonMenu bt_precedent = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_precedent.png")));
    private BoutonMenu bt_saveveh = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_saveveh.png")));
    private BoutonMenu bt_rechercherveh = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_rechercheveh.png")));
    private BoutonMenu bt_modiferveh = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_modifveh.png")));
    private BoutonMenu bt_supprveh = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_supprveh.png")));
    private BoutonMenu bt_afficherveh = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_afficherveh.png")));
    private Fenetre frame_mere;
    
    public GestionVehPanel(String img,Fenetre f){
        this(new ImageIcon(img).getImage(),f);
    }
    
    public GestionVehPanel(Image img,Fenetre f){
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
        bt_saveveh.setBounds(64, 144, 185, 75);
        bt_rechercherveh.setBounds(82, 352, 205, 75);
        bt_modiferveh.setBounds(351, 147, 191, 76);
        bt_supprveh.setBounds(195, 238, 213, 75);
        bt_afficherveh.setBounds(323, 352, 209, 75);
        
        bt_precedent.addActionListener(this);
        bt_saveveh.addActionListener(this);
        bt_supprveh.addActionListener(this);
        bt_rechercherveh.addActionListener(this);
        bt_afficherveh.addActionListener(this);
        
        /* On ajoute les bouton au Panel */
        this.add(bt_saveveh);
        this.add(bt_rechercherveh);
        this.add(bt_modiferveh);
        this.add(bt_supprveh);
        this.add(bt_precedent);
        this.add(bt_afficherveh);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton button = (JButton)e.getSource();
        
        if ( button==bt_precedent )
        {
            this.setVisible(false);
            frame_mere.affiche_page_gestionA();
        }
        else if ( button==bt_saveveh )
        {
            this.setVisible(false);
            frame_mere.affiche_page_saveVeh();
        }
        else if ( button==bt_supprveh )
        {
            this.setVisible(false);
            frame_mere.affiche_page_SupprimerVehPanel();
        }
        else if ( button==bt_rechercherveh )
        {
            this.setVisible(false);
            frame_mere.affiche_page_RechercheVehPanel();
        }
        else if ( button==bt_afficherveh )
        {
            this.setVisible(false);
            frame_mere.affiche_page_AfficherVehPanel();
        }
    }
}
