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
public class GestionfacPanel extends JPanel implements ActionListener {

    private Image img;  
    private BoutonMenu bt_precedent = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_precedent.png")));
    private BoutonMenu bt_savefac = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_savefac.png")));
    private BoutonMenu bt_rechercherfac = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_recherchefac.png")));
    private BoutonMenu bt_modiferfac = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_modifierfac.png")));
    private BoutonMenu bt_supprfac = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_supprfac.png")));
    private BoutonMenu bt_afficherfac = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_afficherfac.png")));
    private Fenetre frame_mere;
    
    public GestionfacPanel(String img,Fenetre f){
        this(new ImageIcon(img).getImage(),f);
    }
    
    public GestionfacPanel(Image img,Fenetre f){
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
        bt_savefac.setBounds(62, 144, 186, 85);
        bt_rechercherfac.setBounds(313, 149, 205, 76);
        bt_modiferfac.setBounds(176, 249, 210, 75);
        bt_supprfac.setBounds(44, 365, 214, 75);
        bt_afficherfac.setBounds(317, 359, 209, 75);
        
        bt_precedent.addActionListener(this);
        
        /* On ajoute les bouton au Panel */
        this.add(bt_savefac);
        this.add(bt_rechercherfac);
        this.add(bt_modiferfac);
        this.add(bt_supprfac);
        this.add(bt_precedent);
        this.add(bt_afficherfac);
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
            frame_mere.affiche_accueil();
        }
    }
    
}
