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
public class GestionTechPanel extends JPanel implements ActionListener{
    
    private Image img;  
    private BoutonMenu bt_precedent = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_precedent.png")));
    private BoutonMenu bt_prgmope = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_prgmope.png")));
    private Fenetre frame_mere;
    
    public GestionTechPanel(String img,Fenetre f){
        this(new ImageIcon(img).getImage(),f);
    }
    
    public GestionTechPanel(Image img,Fenetre f){
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
        bt_prgmope.setBounds(195, 191, 186, 86);
        
        bt_precedent.addActionListener(this);
        bt_prgmope.addActionListener(this);
        
        this.add(bt_prgmope);
        this.add(bt_precedent);
    
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
        else 
        {
            this.setVisible(false);
            frame_mere.affiche_page_saveinter();
        }
    }
}
