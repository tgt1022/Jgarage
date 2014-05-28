/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Utilisateur
 */
public class SupprimerVehPanel extends JPanel  implements ActionListener {
    
    private Fenetre frame_mere;
    
    private JLabel JLB_nomclient = new JLabel("Nom du client :");
    private JComboBox JCB_nomclient = new JComboBox();
    private JLabel JLB_immatriculation = new JLabel("Immatriculation :");
    private JComboBox JCB_immatriculation = new JComboBox();

    private Textbox JTF_marque = new Textbox();
    private JLabel JLB_marque = new JLabel("Marque :");
    private Textbox JTF_modele = new Textbox();
    private JLabel JLB_modele = new JLabel("Modèle :");
    private Textbox JTF_couleur = new Textbox();
    private JLabel JLB_couleur = new JLabel("Couleur :");
    private Textbox JTF_kilometrage = new Textbox();
    private JLabel JLB_kilometrage = new JLabel("Kilométrage :");
    private Textbox JTF_nbplace = new Textbox();
    private JLabel JLB_nbplace = new JLabel("Nombre de place :");
    private Textbox JTF_annee = new Textbox();
    private JLabel JLB_annee = new JLabel("Année :");
    
    private JButton bt_cancel = new JButton("Annuler");
    private JButton bt_supprveh = new JButton("Supprimer");
   
    private ResultSet lesvehicules;
    private ResultSet lesclients;
    private ResultSet retourTMP;
    
    public SupprimerVehPanel(Fenetre f)
    {        
        frame_mere = f; 
        
        JPanel client = new JPanel();
        //On définit le layout en lui indiquant qu'il travaillera en ligne
        client.setLayout(new BoxLayout(client, BoxLayout.LINE_AXIS));
        client.add(JLB_nomclient);
        client.add(JCB_nomclient);        
        
        client.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        JPanel immatriculation = new JPanel();
        BoxLayout box_immat = new BoxLayout(immatriculation, BoxLayout.LINE_AXIS);        
        //Idem pour cette ligne
        immatriculation.setLayout(box_immat);
        immatriculation.add(JLB_immatriculation);
        immatriculation.add(JCB_immatriculation);        
        immatriculation.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        JPanel marque = new JPanel();
        //Idem pour cette ligne
        marque.setLayout(new BoxLayout(marque, BoxLayout.LINE_AXIS));
        marque.add(JLB_marque);
        marque.add(JTF_marque);
        marque.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        JPanel modele = new JPanel();
        //Idem pour cette ligne
        modele.setLayout(new BoxLayout(modele, BoxLayout.LINE_AXIS));
        modele.add(JLB_modele);
        modele.add(JTF_modele);
        modele.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); 
               
        JPanel bouton = new JPanel();
        //Idem pour cette ligne
        bouton.setLayout(new BoxLayout(bouton, BoxLayout.LINE_AXIS));
        bouton.add(bt_cancel);
        bouton.add(bt_supprveh);
        bouton.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        JPanel panelsuppr = new JPanel();
        //On positionne maintenant ces trois lignes en colonne
        panelsuppr.setLayout(new BoxLayout(panelsuppr, BoxLayout.PAGE_AXIS));
        panelsuppr.add(client);
        panelsuppr.add(immatriculation);
        panelsuppr.add(marque);
        panelsuppr.add(modele);
       
        panelsuppr.add(bouton);        
        
        this.add(panelsuppr);
        
        bt_cancel.addActionListener(this);   
        bt_supprveh.addActionListener(this);
        
        DAO<Client> ClientDao = new ClientDAO(SdzConnection.getInstance());
        lesclients = ClientDao.display(); 
        
        try {
                       
            while(lesclients.next()){ 
                JCB_nomclient.addItem(lesclients.getString(2));                
            }
            
        }catch(Exception e){
             e.printStackTrace();
             System.out.print("erreur");
        }
        
        JCB_nomclient.addActionListener(new ItemAction(JCB_nomclient,JCB_immatriculation,JTF_marque,JTF_modele));
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        
        if ( button==bt_cancel )
        {
            this.setVisible(false);
            frame_mere.affiche_page_gestionVeh();
        }
        else if ( button==bt_supprveh)
        {                        
            
            DAO<Vehicule> VehiculeDao = new VehiculeDAO(SdzConnection.getInstance());
            retourTMP = VehiculeDao.requete("*","vehicule","immatriculation",JCB_immatriculation.getSelectedItem().toString());
                     
            try {
                       
            while(retourTMP.next()){     
    
                Vehicule vehiculeTMP = new Vehicule(retourTMP.getInt(1),retourTMP.getInt(2),retourTMP.getString(3),retourTMP.getString(4),retourTMP.getString(5),retourTMP.getString(6),retourTMP.getString(7),retourTMP.getInt(8),retourTMP.getInt(9),retourTMP.getInt(10),retourTMP.getString(11));
                ControlerSupprVeh supprimer_vehicule = new ControlerSupprVeh(vehiculeTMP);
                supprimer_vehicule.delete();
                
                this.setVisible(false);
                frame_mere.affiche_page_gestionVeh();
            }
            
                }catch(Exception f){
                    f.printStackTrace();
                    System.out.print("Erreur lors de la suppression");
            }
            
            
             
        }
    }
    
}
