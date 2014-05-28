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
class ItemAction3 implements ActionListener {

    private String nomclient;
    private int idClient;
    private ResultSet lesvehicules;
    private JComboBox JCB_nomclient;
    private JComboBox JCB_immat;
    private ResultSet retourTMP;
    
    public ItemAction3(JComboBox JCB_nomclient,JComboBox JCB_immat) {
        
        this.JCB_nomclient = JCB_nomclient;
        this.JCB_immat = JCB_immat;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        nomclient = JCB_nomclient.getSelectedItem().toString(); 
        //System.out.println(nomclient);
               
        DAO<Client> ClientDao = new ClientDAO(SdzConnection.getInstance());        
        retourTMP = ClientDao.requete("idClient","client","nom",nomclient);
        try {
                       
            while(retourTMP.next()){                
                
               idClient = retourTMP.getInt(1);
              
            }
            
        }catch(Exception f){
             System.out.print("erreur");
        }
        
        DAO<Vehicule> VehiculeDao = new VehiculeDAO(SdzConnection.getInstance());        
        lesvehicules = VehiculeDao.requete("*", "vehicule", "idClient", idClient);
        
        JCB_immat.removeAllItems();
        
         try {
                       
            while(lesvehicules.next()){                
                 
                JCB_immat.addItem(lesvehicules.getString(3));                
                //System.out.println(lesvehicules.getString(1));
            }
            
        }catch(Exception f){
             f.printStackTrace();
             System.out.print("erreur");
        }
        
    }
    
}
