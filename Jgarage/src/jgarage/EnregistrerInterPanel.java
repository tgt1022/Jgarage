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

/**
 *
 * @author Utilisateur
 */
public class EnregistrerInterPanel extends JPanel implements ActionListener {

    private Fenetre frame_mere;
    
    private JLabel JLB_nomclient = new JLabel("Nom du client :");
    private JComboBox JCB_nomclient = new JComboBox();
    private JLabel JLB_immatriculation = new JLabel("Immatriculation :");
    private JComboBox JCB_immatriculation = new JComboBox();
    
    private Textbox JTF_nature = new Textbox();
    private JLabel JLB_nature = new JLabel("Nature de l'intervention :");
    private Textbox JTF_prix = new Textbox();
    private JLabel JLB_prix = new JLabel("Prix de l'intervention :");
    private Textbox JTF_dateDebut = new Textbox();
    private JLabel JLB_dateDebut = new JLabel("Date début :");
    
    private JLabel JLB_pieceused = new JLabel("Pièce utilisé :");
    private JComboBox JCB_pieceused = new JComboBox();
    private Textbox JTF_pieceused = new Textbox();
    private JLabel JLB_qttepieceused = new JLabel("Quantité à utiliser :");
    
    private JPanel etatstock = new JPanel();
    private JLabel JLB_etatstock = new JLabel(" ATTENTION STOCK VIDE ");
    
    private Textbox JTF_dateFin = new Textbox();
    private JLabel JLB_dateFin = new JLabel("Date fin :");
    
    private JButton bt_cancel = new JButton("Annuler");
    private JButton bt_valider = new JButton("Enregistrer");
    
    private JPanel nnord = new JPanel();
    private JPanel nord = new JPanel();
    private JPanel sud = new JPanel();
    private JPanel ssud = new JPanel();
    
    private ResultSet lesclients;
    private ResultSet retourTMP;
    
    public EnregistrerInterPanel(Fenetre f)
    {
        frame_mere = f;
        
        JLB_etatstock.setBackground(Color.red);
        JTF_pieceused.setPreferredSize(new Dimension(130,20));
        JCB_pieceused.setPreferredSize(new Dimension(130,20));
        JCB_nomclient.setPreferredSize(new Dimension(130,20));
        JCB_immatriculation.setPreferredSize(new Dimension(130,20));
        JTF_nature.setPreferredSize(new Dimension(130,20));
        JTF_prix.setPreferredSize(new Dimension(130,20));
        JTF_dateDebut.setPreferredSize(new Dimension(130,20));
        JTF_dateFin.setPreferredSize(new Dimension(130,20));
             
        JCB_pieceused.addItem(" ");
        JCB_pieceused.addItem("moteur");
        JCB_pieceused.addItem("huile");
        JCB_pieceused.addItem("vitre");
        JCB_pieceused.addItem("carburant");
        JCB_pieceused.addItem("pneu");
        
        DAO<Client> ClientDao = new ClientDAO(SdzConnection.getInstance());
        lesclients = ClientDao.display(); 
        JCB_nomclient.addItem(" ");
        try {
                       
            while(lesclients.next()){ 
                JCB_nomclient.addItem(lesclients.getString(2));                
            }
            
        }catch(Exception e){
             e.printStackTrace();
             System.out.print("erreur");
        }
        
        JCB_nomclient.addActionListener(new ItemAction3(JCB_nomclient,JCB_immatriculation));
        
        nnord.add(JLB_nomclient);
        nnord.add(JCB_nomclient);
        nnord.add(JLB_immatriculation);
        nnord.add(JCB_immatriculation);
        
        nord.add(JLB_pieceused);
        nord.add(JCB_pieceused);
        nord.add(JLB_qttepieceused);
        nord.add(JTF_pieceused);
        
        sud.add(JLB_nature);
        sud.add(JTF_nature);
        
        sud.add(JLB_prix);
        sud.add(JTF_prix);
        
        ssud.add(JLB_dateDebut);
        ssud.add(JTF_dateDebut);
        ssud.add(JLB_dateFin);
        ssud.add(JTF_dateFin);        
        
        bt_cancel.addActionListener(this);
        bt_valider.addActionListener(this);
        
        ssud.add(bt_cancel);
        ssud.add(bt_valider);
        etatstock.setBackground(Color.red);
        etatstock.add(JLB_etatstock);
        
        JCB_pieceused.addActionListener(new ItemAction4(JCB_pieceused,etatstock,this,frame_mere));
        
        //this.setLayout(new BorderLayout());
        
        this.add(nnord);
        this.add(nord);
        this.add(sud);
        this.add(ssud);
        
        //this.add(etatstock);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton button = (JButton)e.getSource();
        int idVehicule=0;
        int prix=Integer.parseInt(JTF_prix.getText());
        int idIntervention=0;
        int quantite=1;
        
        if ( button==bt_valider)
        {
            DAO<Vehicule> VehiculeDao = new VehiculeDAO(SdzConnection.getInstance());
            retourTMP = VehiculeDao.requete("idVehicule","vehicule","immatriculation",JCB_immatriculation.getSelectedItem().toString());
            
            try {
                       
                while(retourTMP.next()){     

                    idVehicule = retourTMP.getInt(1);
                }

                 }catch(Exception f){
                        f.printStackTrace();
                        System.out.print("Erreur lors de la suppression");
                }
            
            
            
            DAO<Intervention> InterventionDao = new InterventionDAO(SdzConnection.getInstance());
            idIntervention =InterventionDao.getLastId();
            
            Intervention monIntervention = new Intervention(idIntervention,idVehicule,JTF_nature.getText(),prix,JTF_dateDebut.getText(),JTF_dateFin.getText());
            ControlerSaveIntervention saveIntervention = new ControlerSaveIntervention(monIntervention);
            saveIntervention.saveIntervention();
        }
    }
    
}
