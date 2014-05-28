/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Utilisateur
 */
class ItemAction4 implements ActionListener {

    
    private JComboBox JCB_pieceused;
    private String type;
    private ResultSet retour;
    private int quantite;
    private JPanel etatstock;
    private JPanel monPanel;
    Fenetre frame_mere;
    
    public ItemAction4(JComboBox JCB_pieceused,JPanel etatstock,JPanel monPanel,Fenetre f) {
        
        frame_mere=f;
        this.JCB_pieceused = JCB_pieceused;
        this.etatstock = etatstock;
        this.monPanel = monPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        type = JCB_pieceused.getSelectedItem().toString();
        
        
        DAO<Stock> StockDao = new StockDAO(SdzConnection.getInstance());
        retour = StockDao.requete("quantite","stock","type",type);
        
        try {
                       
                while(retour.next()){     

                    quantite = retour.getInt(1);
                    
                }

                 }catch(Exception f){
                        f.printStackTrace();
                        System.out.print("Erreur lors de la suppression");
                }
        
        if ( quantite == 0)
        {
            //System.out.println(JLB_etatstock);
            monPanel.add(etatstock);
            frame_mere.setSize(705,510);
        }
        else
        {
            monPanel.remove(etatstock);
            frame_mere.setSize(706,510);
        }
    }
    
}
