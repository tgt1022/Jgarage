/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JComboBox;

/**
 *
 * @author Utilisateur
 */
public class ItemAction2 implements ActionListener {

    private JComboBox JCB_choixstock;
    private Textbox JTF_choixstock;
    private String nomstock;
    private ResultSet retourTMP;
    
    
    public ItemAction2(JComboBox JCB_choixstock,Textbox JTF_choixstock)
    {
        this.JCB_choixstock = JCB_choixstock;
        this.JTF_choixstock = JTF_choixstock;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        nomstock = JCB_choixstock.getSelectedItem().toString();        
        
        
        if ( nomstock=="Stock Vitre")
        {
           nomstock="vitre";
        }
        else if (nomstock=="Stock Pneu")
        {
           nomstock="pneu"; 
        }
        else if (nomstock=="Stock Huile")
        {
           nomstock="huile"; 
        }
        else if ( nomstock=="Stock Moteur" )
        {
            nomstock="moteur";
        }
        else
        {
           nomstock="carburant"; 
        }
        
        DAO<Stock> StockDao = new StockDAO(SdzConnection.getInstance());        
        retourTMP = StockDao.requete("quantite","stock","type",nomstock);        
        
        try {
                       
            while(retourTMP.next()){                
                 
               if ( nomstock=="vitre")
                {
                   JTF_choixstock.setText(retourTMP.getString(1)+" vitres");
                }
                else if (nomstock=="pneu")
                {
                   JTF_choixstock.setText(retourTMP.getString(1)+" pneus");
                }
                else if (nomstock=="huile")
                {
                   JTF_choixstock.setText(retourTMP.getString(1)+" L d'huiles");
                }
                else if ( nomstock=="moteur" )
                {
                    JTF_choixstock.setText(retourTMP.getString(1)+" moteurs");
                }
                else
                {
                   JTF_choixstock.setText(retourTMP.getString(1)+" L de carburant");
                }
               
               
            }
            
        }catch(Exception f){
             f.printStackTrace();
             System.out.print("erreur");
        }        
    
        
    }
    
}
