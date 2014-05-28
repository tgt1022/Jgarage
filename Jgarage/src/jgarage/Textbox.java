/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author Utilisateur
 */
public class Textbox extends JTextField{    
    
    Font police = new Font("Arial",Font.BOLD,14);
    
    public Textbox(){        
        this.setFont(police);
        this.setPreferredSize(new Dimension(150,10));
        this.setForeground(Color.BLACK);
    }
}
