/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;



import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Utilisateur
 */
public class SaveVehiculePanel extends JPanel implements ActionListener {
    
    private Fenetre frame_mere;
    
    private JLabel JLB_client = new JLabel("Client :");
    private JComboBox JCB_client = new JComboBox();
    
    private Textbox JTF_immatriculation = new Textbox();
    private JLabel JLB_immatriculation = new JLabel("Immatriculation :");
    private Textbox JTF_marque = new Textbox();
    private JLabel JLB_marque = new JLabel("Marque :                ");
    private Textbox JTF_modele = new Textbox();
    private JLabel JLB_modele = new JLabel("Modèle :                 ");
    private Textbox JTF_couleur = new Textbox();
    private JLabel JLB_type = new JLabel("Type :                      ");
    private Textbox JTF_type = new Textbox();
    private JLabel JLB_couleur = new JLabel("Couleur :                ");
    private Textbox JTF_kilometrage = new Textbox();
    private JLabel JLB_kilometrage = new JLabel("Kilométrage :        ");
    private Textbox JTF_nbplace = new Textbox();
    private JLabel JLB_nbplace = new JLabel("Nombre de place :     ");
    
    private Textbox JTF_annee = new Textbox();
    private JLabel JLB_annee = new JLabel("Année :                         ");
    
    private JButton bt_client = new JButton("Ajouter client");
    private JButton bt_cancel = new JButton("Annuler");
    private JButton bt_save_veh = new JButton("Enregistrer");
    
    private JLabel JLB_photo = new JLabel();
    private String LienImage = "C:\\Users\\Utilisateur\\Dropbox\\TOA\\jGarage\\src\\jgarage\\image\\noimage.png";
    
    private ImageIcon icon = new ImageIcon(LienImage);
    private Image t = icon.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
    private ImageIcon icon2 = new ImageIcon(t);    
    
       
                    
    private JButton bt_open = new JButton("Selectionner une photo"); //nouveau bouton open
    private JLabel status = new JLabel(""); //nouveau champs de texte
    
    private ResultSet lesclients;
    private ResultSet retourTMP;
    
    public SaveVehiculePanel(Fenetre f)
    { 
        
        frame_mere = f;       
        
        /*JPanel client = new JPanel();
        //On définit le layout en lui indiquant qu'il travaillera en ligne
        client.setLayout(new BoxLayout(client, BoxLayout.LINE_AXIS));
        client.add(JLB_nomclient);
        client.add(JCB_nomclient); */       
        
        //client.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        //On définit le layout à utiliser sur le content pane
        this.setLayout(new BorderLayout());
        
        JPanel client = new JPanel();
        BoxLayout box_client = new BoxLayout(client, BoxLayout.LINE_AXIS);        
        //Idem pour cette ligne
        client.setLayout(box_client);
        client.add(JLB_client);
        client.add(JCB_client);
        client.add(bt_client);   
        client.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
                
        DAO<Client> ClientDao = new ClientDAO(SdzConnection.getInstance());
        lesclients = ClientDao.display();   
        
        try {
           
            while(lesclients.next()){ 
                JCB_client.addItem(lesclients.getString(2));
                
            }
            
        }catch(Exception e){
             e.printStackTrace();
             System.out.print("erreur");
        }
        
        
        
        JPanel immatriculation = new JPanel();
        BoxLayout box_immat = new BoxLayout(immatriculation, BoxLayout.LINE_AXIS);        
        //Idem pour cette ligne
        immatriculation.setLayout(box_immat);
        immatriculation.add(JLB_immatriculation);
        immatriculation.add(JTF_immatriculation);        
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
        
        JPanel type = new JPanel();
        //Idem pour cette ligne
        type.setLayout(new BoxLayout(type, BoxLayout.LINE_AXIS));
        type.add(JLB_type);
        type.add(JTF_type);
        type.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        JPanel couleur = new JPanel();
        //Idem pour cette ligne
        couleur.setLayout(new BoxLayout(couleur, BoxLayout.LINE_AXIS));
        couleur.add(JLB_couleur);
        couleur.add(JTF_couleur);
        couleur.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        JPanel kilometrage = new JPanel();
        //Idem pour cette ligne
        kilometrage.setLayout(new BoxLayout(kilometrage, BoxLayout.LINE_AXIS));
        kilometrage.add(JLB_kilometrage);
        kilometrage.add(JTF_kilometrage);
        kilometrage.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        JPanel nbplace = new JPanel();
        //Idem pour cette ligne
        nbplace.setLayout(new BoxLayout(nbplace, BoxLayout.LINE_AXIS));
        nbplace.add(JLB_nbplace);
        nbplace.add(JTF_nbplace);
        nbplace.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        JPanel annee = new JPanel();
        //Idem pour cette ligne
        annee.setLayout(new BoxLayout(annee, BoxLayout.LINE_AXIS));
        annee.add(JLB_annee);
        annee.add(JTF_annee);
        annee.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        JPanel bouton = new JPanel();
        //Idem pour cette ligne
        bouton.setLayout(new BoxLayout(bouton, BoxLayout.LINE_AXIS));
        bouton.add(bt_cancel);
        bouton.add(bt_save_veh);
        bouton.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        JPanel panelsuppr = new JPanel();
        //On positionne maintenant ces trois lignes en colonne
        panelsuppr.setLayout(new BoxLayout(panelsuppr, BoxLayout.PAGE_AXIS));
        //panelsuppr.add(client);
        panelsuppr.add(client);
        panelsuppr.add(immatriculation);
        panelsuppr.add(marque);
        panelsuppr.add(modele);
        panelsuppr.add(type);
        panelsuppr.add(couleur);
        panelsuppr.add(kilometrage);
        panelsuppr.add(nbplace);
        panelsuppr.add(annee);
        panelsuppr.add(bouton);                
        
        
        JPanel image_panel = new JPanel();
        
        image_panel.setLayout(new BorderLayout());
        image_panel.setLayout(new BoxLayout(image_panel, BoxLayout.PAGE_AXIS));
        
        image_panel.add(JLB_photo);
        image_panel.add(bt_open);
        image_panel.add(status); 
          
//        BoxLayout box_image = new BoxLayout(image_panel, BoxLayout.LINE_AXIS);        
//        //Idem pour cette ligne
//        client.setLayout(box_image);
//        //client.add(JLB_photo);
//        client.add(bt_open);           
//        client.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        JLB_photo.setIcon(icon2);
        
        this.add(panelsuppr, BorderLayout.WEST);
        this.add(image_panel, BorderLayout.EAST);
        //this.add(panelsuppr);
        
        bt_cancel.addActionListener(this);
        bt_save_veh.addActionListener(this);
        bt_open.addActionListener(this);
        bt_client.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton button = (JButton)e.getSource();
        
        if ( button==bt_cancel )
        {
            this.setVisible(false);
            frame_mere.affiche_page_gestionVeh();
        }
        else if ( button == bt_save_veh )
        {
            /* On prépare les informations pour le controler*/
           int idVehicule;
           int idClient = 0;
           
           DAO<Vehicule> VehiculeDao = new VehiculeDAO(SdzConnection.getInstance());
           idVehicule = VehiculeDao.getLastId();          
           
           DAO<Client> ClientDao = new ClientDAO(SdzConnection.getInstance());
           retourTMP = ClientDao.requete("idClient", "client", "nom", JCB_client.getSelectedItem().toString());
           
           try {
                       
            while(retourTMP.next()){ 
                
                idClient = retourTMP.getInt(1);
                
                }

            }catch(Exception f){
                 f.printStackTrace();
                 System.out.print("erreur");
            }
           
           //idClient = ClientDao.get_id_fromName(JCB_client.getSelectedItem().toString());
           
           
            int kilometre =  Integer.parseInt(JTF_kilometrage.getText());
            int nombre_place = Integer.parseInt(JTF_nbplace.getText());
            int anneeVeh = Integer.parseInt(JTF_annee.getText());
           
            /* On appel le controler qui va se charger de faire le lien entre le modèle et la vue en enregistrant le vehicule*/
           ControlerSaveVehicule enregistrer_vehicule = new ControlerSaveVehicule(idVehicule,idClient,JTF_immatriculation.getText(),JTF_marque.getText(),JTF_modele.getText(),JTF_type.getText(),JTF_couleur.getText(),kilometre,nombre_place,anneeVeh,LienImage);
           enregistrer_vehicule.addVechicule();              
         
            this.setVisible(false);
            frame_mere.affiche_page_gestionVeh();
        }
        else if ( button == bt_open )
        {
             FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "bmp", "gif", "jpg", "jpeg", "png");
             JFileChooser chooser = new JFileChooser();//création dun nouveau filechosser
             chooser.setAcceptAllFileFilterUsed(false);
             chooser.addChoosableFileFilter(filter);
                        
             chooser.setApproveButtonText("Choix de l'image..."); //intitulé du bouton
                       
             if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
              {	
                    //status.setText(chooser.getSelectedFile().getAbsolutePath()); //si un fichier est selectionné, récupérer le fichier puis sont path et l'afficher dans le champs de texte
                    LienImage = chooser.getSelectedFile().getAbsolutePath();
                    ImageIcon icon = new ImageIcon(LienImage);
                    Image t = icon.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
                    ImageIcon icon2 = new ImageIcon(t);
             
                   
                    JLB_photo.setIcon(icon2);
              }            
        }
        else if ( button==bt_client)
        {
            frame_mere.affiche_page_saveClient();
            
            
            
        }
    }
}
