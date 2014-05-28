/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

/**
 *
 * @author Utilisateur
 */
public class ControlerSaveVehicule {
    
    private int idVehicule;
    private int idClient;
    private String immatriculation;
    private String marque;
    private String modele;
    private String type;
    private String couleur;            
    private int kilometre;
    private int nombre_place;
    private int anneeVeh;
    private String LienImage;   
    
    
    public ControlerSaveVehicule(int idVehicule,int idClient,String immatriculation,String marque,String modele,String type,String couleur,int kilometre,int nombre_place,int anneeVeh,String lien_image){        
        
        this.idVehicule = idVehicule;
        this.idClient = idClient;
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.type = type;
        this.couleur = couleur;            
        this.kilometre = kilometre;
        this.nombre_place = nombre_place;
        this.anneeVeh = anneeVeh;
        this.LienImage = lien_image;             
        
    }
    
    public boolean addVechicule()
    {
                
        Vehicule monVehicule = new Vehicule(idVehicule,idClient,immatriculation,marque,modele,type,couleur,kilometre,nombre_place,anneeVeh,LienImage);
        DAO<Vehicule> VehiculeDao = new VehiculeDAO(SdzConnection.getInstance());
        Boolean vehicule = VehiculeDao.create(monVehicule);        
        
        return vehicule;
        
    }
}
