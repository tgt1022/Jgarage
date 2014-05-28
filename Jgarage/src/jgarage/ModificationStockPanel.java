/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Utilisateur
 */
public class ModificationStockPanel extends JPanel implements ActionListener{
    
    private Fenetre frame_mere;
    
    private JComboBox JCB_choixstock = new JComboBox();    
    private Textbox JTF_choixstock = new Textbox();
    private Textbox JTF_newstock = new Textbox();
    private Textbox JTF_prixstock = new Textbox();
    private JLabel JLB_choixstock = new JLabel("Choix du stock");
    private JLabel JLB_etatstock = new JLabel("État du stock");
//    private JButton bt_augmenter = new JButton("Ajouter +");
//    private JButton bt_diminuer = new JButton("Diminuer -");
    private JButton bt_valider = new JButton("Valider");
    
    private JPanel nord = new JPanel();
    private JPanel sud = new JPanel();
    
   
    
    private ResultSet requeteTMP;
    
    public ModificationStockPanel(Fenetre f)
    {
        frame_mere = f;  
        JCB_choixstock.setPreferredSize(new Dimension(130,20));        
        JTF_choixstock.setPreferredSize(new Dimension(130,20));
        JTF_newstock.setPreferredSize(new Dimension(130,20));
        JTF_prixstock.setPreferredSize(new Dimension(130,20));
        
        JTF_newstock.setText("Nouvelle quantitée");
        JTF_prixstock.setText("Prix");
        //JCB_choixstock.setBackground(Color.green);
        
        JCB_choixstock.addItem(" ");
        JCB_choixstock.addItem("Stock Vitre");
        JCB_choixstock.addItem("Stock Pneu");
        JCB_choixstock.addItem("Stock Carburant");
        JCB_choixstock.addItem("Stock Moteur");
        JCB_choixstock.addItem("Stock Huile");       
        
        nord.setBackground(Color.red);
  
        bt_valider.addActionListener(this);
//        bt_diminuer.addActionListener(this);
        JCB_choixstock.addActionListener(new ItemAction2(JCB_choixstock,JTF_choixstock));
        
        nord.add(JLB_choixstock);        
        nord.add(JCB_choixstock); 
        nord.add(JLB_etatstock);
        nord.add(JTF_choixstock);
        sud.add(JTF_newstock);
        sud.add(JTF_prixstock);
        sud.add(bt_valider);
//        nord.add(bt_augmenter);
//        nord.add(bt_diminuer);
        
        this.add(nord);
        this.add(sud);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton button = (JButton)e.getSource();
        
        System.out.println(JCB_choixstock.getSelectedItem());
        String nomstock="";
        int prix=0;
        int quantite=0;
        Boolean retour;
    
        quantite = Integer.parseInt(JTF_newstock.getText());
        prix = Integer.parseInt(JTF_prixstock.getText());
        
        if ( button==bt_valider)
        {
           
            
            if ( JCB_choixstock.getSelectedItem()=="Stock Vitre")
            {
               nomstock="vitre";
               ControlerModifStock modif_stock = new ControlerModifStock(1,prix,quantite,"vitre");
               retour=modif_stock.modification();
               System.out.println(retour);
               this.setVisible(false);
               frame_mere.affiche_page_gestionStock();
            }
            else if (JCB_choixstock.getSelectedItem()=="Stock Pneu")
            {
               nomstock="pneu";
               ControlerModifStock modif_stock = new ControlerModifStock(5,prix,quantite,"pneu");
               retour=modif_stock.modification();
               this.setVisible(false);
                frame_mere.affiche_page_gestionStock();
//               System.out.println(retour);
            }
            else if (JCB_choixstock.getSelectedItem()=="Stock Huile")
            {
               nomstock="huile";
               ControlerModifStock modif_stock = new ControlerModifStock(3,prix,quantite,"huile");
               retour=modif_stock.modification();
               System.out.println(retour);
               this.setVisible(false);
                frame_mere.affiche_page_gestionStock();
            }
            else if ( JCB_choixstock.getSelectedItem()=="Stock Moteur" )
            {
                nomstock="moteur";
                ControlerModifStock modif_stock = new ControlerModifStock(2,prix,quantite,"moteur");
                retour=modif_stock.modification();
                System.out.println(retour);
                
                this.setVisible(false);
                frame_mere.affiche_page_gestionStock();
            }
            else if ( JCB_choixstock.getSelectedItem()=="Stock Carburant")
            {
               nomstock="carburant";
               ControlerModifStock modif_stock = new ControlerModifStock(4,prix,quantite,"carburant");
               retour=modif_stock.modification();
               System.out.println(retour);
               
               this.setVisible(false);
            frame_mere.affiche_page_gestionStock();
            }
        }
        
        
                
    }
    
}
