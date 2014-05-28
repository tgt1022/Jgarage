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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Utilisateur
 */
public class AccueilPanel extends JPanel implements ActionListener {
    
    private Image img;
    /* On déclare tous les boutons*/
    private BoutonMenu bt_gestionA = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_gestgdmini.png")));       
    private BoutonMenu bt_gestionS = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_geststock.png")));
    private BoutonMenu bt_gestionT = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_gesttech.png")));
    private BoutonMenu bt_gestionF = new BoutonMenu(new ImageIcon(this.getClass().getResource("image/bt_gestfact.png")));

    
    /* Attribut pour récupérer la fenêtre */
    private Fenetre frame_mere;
    
    public AccueilPanel(String img,Fenetre f){
        
        this(new ImageIcon(img).getImage(),f);
       
    }
    
    public AccueilPanel(Image img,Fenetre f)
    {
        frame_mere = f;
        this.img = img;
        
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        
        /* On positionne les boutons aux coordonnées mentionnées */
        bt_gestionA.setBounds(105, 151, 180, 70);
        bt_gestionS.setBounds(312, 151, 180, 70);
        bt_gestionT.setBounds(110, 278, 180, 70);
        bt_gestionF.setBounds(319, 282, 180, 70);       
        
        /* */
        bt_gestionA.addActionListener(this);
        bt_gestionF.addActionListener(this);
        bt_gestionT.addActionListener(this);
        bt_gestionS.addActionListener(this);      
        
        /* On ajoute les bouton au Panel */
        this.add(bt_gestionA);
        this.add(bt_gestionS);
        this.add(bt_gestionT);
        this.add(bt_gestionF);
      
        
    }
    
    public void paintComponent(Graphics g){
        g.drawImage(img,0,0,null);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton button = (JButton)e.getSource();
        
        if ( button==bt_gestionA )
        {
            frame_mere.affiche_page_gestionA();
        }
        else if ( button==bt_gestionF )
        {
            frame_mere.affiche_page_gestionFac();
        }
        else if ( button==bt_gestionT )
        {
            frame_mere.affiche_page_gestionTech();
        }
        else
        {
            frame_mere.affiche_page_gestionStock();
        }
            
    }
    
}
