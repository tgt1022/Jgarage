/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Utilisateur
 */
public class EnregistrerClientPanel extends JPanel implements ActionListener {

    private Fenetre frame_mere;

    private Textbox JTF_nomclient = new Textbox();
    private JLabel JLB_nomclient = new JLabel("Nom du client :");
    private Textbox JTF_prenomclient = new Textbox();
    private JLabel JLB_prenomclient = new JLabel("Prénom du client :");
    private Textbox JTF_adresse = new Textbox();
    private JLabel JLB_adresse = new JLabel("Adresse :");
    private Textbox JTF_email = new Textbox();
    private JLabel JLB_email = new JLabel("E-mail :");
    
    private JButton bt_cancel = new JButton("Annuler");
    private JButton bt_save_client = new JButton("Enregistrer");
    
    public EnregistrerClientPanel(Fenetre f)
    {
        frame_mere = f;
        
        JPanel nomclient = new JPanel();
        //Idem pour cette ligne
        nomclient.setLayout(new BoxLayout(nomclient, BoxLayout.LINE_AXIS));
        nomclient.add(JLB_nomclient);
        nomclient.add(JTF_nomclient);
        nomclient.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
               
        JPanel prenomclient = new JPanel();
        //Idem pour cette ligne
        prenomclient.setLayout(new BoxLayout(prenomclient, BoxLayout.LINE_AXIS));
        prenomclient.add(JLB_prenomclient);
        prenomclient.add(JTF_prenomclient);
        prenomclient.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        JPanel adresse = new JPanel();
        //Idem pour cette ligne
        adresse.setLayout(new BoxLayout(adresse, BoxLayout.LINE_AXIS));
        adresse.add(JLB_adresse);
        adresse.add(JTF_adresse);
        adresse.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        JPanel email = new JPanel();
        //Idem pour cette ligne
        email.setLayout(new BoxLayout(email, BoxLayout.LINE_AXIS));
        email.add(JLB_email);
        email.add(JTF_email);
        email.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
       
        JPanel bouton = new JPanel();
        //Idem pour cette ligne
        bouton.setLayout(new BoxLayout(bouton, BoxLayout.LINE_AXIS));
        bouton.add(bt_cancel);
        bouton.add(bt_save_client);
        bouton.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        JPanel paneladdClient = new JPanel();
        //On positionne maintenant ces trois lignes en colonne
        paneladdClient.setLayout(new BoxLayout(paneladdClient, BoxLayout.PAGE_AXIS));
        //panelsuppr.add(client);
        paneladdClient.add(nomclient);
        paneladdClient.add(prenomclient);
        paneladdClient.add(adresse);
        paneladdClient.add(email);
        paneladdClient.add(bouton);
        
        this.add(paneladdClient);     
        
        bt_cancel.addActionListener(this);
        bt_save_client.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton button = (JButton)e.getSource();
        
        if ( button==bt_cancel )
        {
            this.setVisible(false);
            frame_mere.affiche_page_saveVeh();
        }
        else if ( button == bt_save_client )
        {
            /* On prépare les informations pour le controler*/
           int idClient;           
           DAO<Client> ClientDao = new ClientDAO(SdzConnection.getInstance());
           idClient = ClientDao.getLastId();             
           
            /* On appel le controler qui va se charger de faire le lien entre le modèle et la vue en enregistrant le vehicule*/
           ControlerSaveClient enregistrer_client = new ControlerSaveClient(idClient,JTF_nomclient.getText(),JTF_prenomclient.getText(),JTF_adresse.getText(),JTF_email.getText());
           enregistrer_client.addClient();              
         
            this.setVisible(false);
            frame_mere.affiche_page_saveVeh();
            
            
        }
        
    }
    
}
