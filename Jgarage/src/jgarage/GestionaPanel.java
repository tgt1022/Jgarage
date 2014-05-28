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
public class GestionaPanel extends JPanel implements ActionListener{
    
    private Image img;  
    private BoutonMenu bt_precedent = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_precedent.png")));
    private BoutonMenu bt_gestvehi = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_gestvehi.png")));
    private BoutonMenu bt_gestinter = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_gestinter.png")));
    private Fenetre frame_mere;
    
    public GestionaPanel(String img,Fenetre f){
        this(new ImageIcon(img).getImage(),f);
    }
    
    public GestionaPanel(Image img,Fenetre f){
        frame_mere = f;
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);

        /* On positionne les boutons aux coordonnées mentionnées */
        bt_precedent.setBounds(7, 7, 65, 35);
        bt_gestvehi.setBounds(115, 219, 170, 96);
        //bt_gestinter.setBounds(306, 223, 170, 96);
       
        bt_precedent.addActionListener(this);
        bt_gestvehi.addActionListener(this);
        bt_gestinter.addActionListener(this);
        
        /* On ajoute les bouton au Panel */
        this.add(bt_precedent);
        this.add(bt_gestvehi);
        this.add(bt_gestinter);
    }
    
    public void paintComponent(Graphics g){
        g.drawImage(img,0,0,null);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton button = (JButton)e.getSource();
        
        if ( button==bt_gestinter )
        {
            this.setVisible(false);
            frame_mere.affiche_page_gestionInter();
        }
        else if ( button==bt_precedent )
        {
            this.setVisible(false);
            frame_mere.affiche_accueil();
        }
        else
        {
            this.setVisible(false);
            frame_mere.affiche_page_gestionVeh();
        }
        
    }
}
