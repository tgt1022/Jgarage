/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Utilisateur
 */
public class BoutonMenu extends JButton implements MouseListener  {
  
    private ImageIcon icon; 
    
    public BoutonMenu(ImageIcon icon)
    {
        super(icon);
        this.icon = icon;
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setFocusPainted(true);
        this.setBorderPainted(true);
        this.setContentAreaFilled(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
    }
  
    
}
