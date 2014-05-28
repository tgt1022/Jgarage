/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author Utilisateur
 */
public class RechercheVehPanel extends JPanel implements ActionListener{

    private Fenetre frame_mere;
    
    private JLabel JLB_critere = new JLabel("Critère de recherche :");
    private Textbox JTF_critere = new Textbox();
    private JComboBox JCB_critere = new JComboBox();   
    private JButton bt_ok = new JButton("Valider");
    private ResultSet retourTMP;
    private JPanel s = new JPanel();
    private JPanel nord = new JPanel();
    private Object[][] data;
    private  String[] entetes = {"Immatriculation", "Marque", "Modèle", "Type", "Couleur", "Nombre km","Nombre de places","Année"};
    
    public RechercheVehPanel(Fenetre f)
    {
        frame_mere = f;         
        JCB_critere.setPreferredSize(new Dimension(130,20));        
        JTF_critere.setPreferredSize(new Dimension(100,20));
        
        

        nord.add(JLB_critere);        
        nord.add(JTF_critere);
        nord.add(JCB_critere);
        //nord.add(JCB_recherche);
        //nord.add(bt_cancel);
        nord.add(bt_ok);

        DAO<Vehicule> VehiculeDao = new VehiculeDAO(SdzConnection.getInstance());
        retourTMP = VehiculeDao.requete("COLUMN_NAME","INFORMATION_SCHEMA.COLUMNS","TABLE_NAME","vehicule"); 
        
        int compteur = 0;
        JCB_critere.addItem("Nom du client");
        
        try {                       
            while(retourTMP.next()){ 
                compteur++;
                
                // Pour éviter de recupérer l'idClient et l'idVehicule
                if ( compteur > 2)
                    JCB_critere.addItem(retourTMP.getString(1));                
            }
            
        }catch(Exception e){
             e.printStackTrace();
             System.out.print("erreur");
        }        
        
        
        
        bt_ok.addActionListener(this);
        
        this.setLayout(new BorderLayout());
        s.setLayout(new BorderLayout());
       
        this.add(nord,BorderLayout.NORTH);
       
       frame_mere.pack();

    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton button = (JButton)e.getSource();
        
        if ( button==bt_ok )
        {
            int i=0;
            int taille=1;
            DAO<Vehicule> VehiculeDao = new VehiculeDAO(SdzConnection.getInstance());
        
             if (JCB_critere.getSelectedItem().toString()=="Nom du client")
            {  
                //System.out.println(JTF_critere.getText());
                retourTMP = VehiculeDao.requete("count(*)","Vehicule Natural join Client","nom",JTF_critere.getText());
            }
            else
            {
                retourTMP = VehiculeDao.requete("count(*)","vehicule Natural join client",JCB_critere.getSelectedItem().toString(),JTF_critere.getText()); 
            }
            
            
            try {                       
                while(retourTMP.next()){               
                    System.out.println();
                    
                    taille = retourTMP.getInt(1);
                }

            }catch(Exception f){
                 f.printStackTrace();
                 System.out.println("erreur requete taille");
            } 
            //System.out.println(taille);
            data = new Object[taille][8];
           
            if (JCB_critere.getSelectedItem().toString()=="Nom du client")
            {  
                //System.out.println(JTF_critere.getText());
                retourTMP = VehiculeDao.requete("*","Vehicule Natural join Client","nom",JTF_critere.getText());
            }
            else if (JCB_critere.getSelectedItem().toString()!="Nom du client")
            {
                //System.out.println(JTF_critere.getText());
                retourTMP = VehiculeDao.requete("*","Vehicule Natural join Client",JCB_critere.getSelectedItem().toString(),JTF_critere.getText());
            }
            
            //retourTMP = VehiculeDao.requete("*","vehicule Natural join client","1","1 LIMIT 30");
            //retourTMP = VehiculeDao.requete("*","vehicule Natural join client",JCB_critere.getSelectedItem().toString(),JTF_critere.getText());
            
             try {                       
                while(retourTMP.next()){ 
                    //System.out.println("2");  

                    data[i][0] = retourTMP.getString(3);
                    data[i][1] = retourTMP.getString(4);
                    data[i][2] = retourTMP.getString(5);
                    data[i][3] = retourTMP.getString(6);
                    data[i][4] = retourTMP.getString(7);
                    data[i][5] = retourTMP.getString(8);
                    data[i][6] = retourTMP.getString(9);
                    data[i][7] = retourTMP.getString(10);
                    i++;
                }

            }catch(Exception f){
                 f.printStackTrace();
                 System.out.print("erreur Tableau");
            } 
             
            TableauClientsModel tableauClients = new TableauClientsModel(data,entetes); 
            TableRowSorter sorter = new TableRowSorter(tableauClients);
            
            JTable montab = new JTable(tableauClients);
            montab.setRowSorter(sorter);          
            
            s.removeAll();
            s.add(montab.getTableHeader(),BorderLayout.NORTH);
            s.add(montab,BorderLayout.CENTER);
                    
            this.add(s,BorderLayout.CENTER);
            frame_mere.setSize(705+i,500);
        }
   }
    
    
    
}
