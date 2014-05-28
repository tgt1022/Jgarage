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
public class GestionStockPanel extends JPanel implements ActionListener {
    
    private Image img;  
    private BoutonMenu bt_precedent = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_precedent.png")));
    private BoutonMenu bt_savestock = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_savestock.png")));
    private BoutonMenu bt_rechercherstock = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_recherchestock.png")));
    private BoutonMenu bt_modiferstock = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_modifierstock.png")));
    private BoutonMenu bt_supprstock = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_supprstock.png")));
    private BoutonMenu bt_afficherstock = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_afficherstock.png")));
    private Fenetre frame_mere;
    
    public GestionStockPanel(String img,Fenetre f){
        this(new ImageIcon(img).getImage(),f);
    }
    
    public GestionStockPanel(Image img,Fenetre f){
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
        bt_savestock.setBounds(62, 144, 186, 85);
        bt_rechercherstock.setBounds(322, 150, 205, 76);
        bt_modiferstock.setBounds(189, 249, 191, 76);
        bt_supprstock.setBounds(72, 333, 167, 76);
        bt_afficherstock.setBounds(341, 334, 176, 76);
        
        bt_precedent.addActionListener(this);
        bt_modiferstock.addActionListener(this);
        
        /* On ajoute les bouton au Panel */
        this.add(bt_savestock);
        this.add(bt_rechercherstock);
        this.add(bt_modiferstock);
        this.add(bt_supprstock);
        this.add(bt_precedent);
        this.add(bt_afficherstock);
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
        else if ( button==bt_modiferstock)
        {
           this.setVisible(false);
            frame_mere.affiche_page_modifstock(); 
        }
    }
    
}
