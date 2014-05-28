/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

/**
 *
 * @author Utilisateur
 */
public class ControlerSaveClient {
    
    /* Variable d'instances */	
    private Integer idClient;		
    private String nom;	
    private String prenom;	
    private String adresse;	
    private String email;
    
    public ControlerSaveClient(Integer idClient, String nom, String prenom, String adresse, String email)
    {
            this.idClient = idClient;
            this.nom = nom;
            this.prenom = prenom;
            this.adresse = adresse;
            this.email = email;	
    }  
    
    public boolean addClient()
    {
                
        Client monClient = new Client(idClient, nom, prenom,adresse,email);
        DAO<Client> ClientDao = new ClientDAO(SdzConnection.getInstance());
        Boolean client = ClientDao.create(monClient);        
        
        return client;
        
    }
}
