/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;


import javax.swing.ImageIcon;
import javax.swing.JFrame;


/**
 *
 * @author Utilisateur
 */
public class Fenetre extends JFrame  {
    
    AccueilPanel page_accueil = new AccueilPanel(new ImageIcon("C:/Users/Utilisateur/Pictures/jgarage/image/accueil.png").getImage(),this);
    GestionaPanel page_gesta = new GestionaPanel(new ImageIcon("C:/Users/Utilisateur/Pictures/jgarage/image/accueil.png").getImage(),this);
    GestionfacPanel page_gestfac = new GestionfacPanel(new ImageIcon("C:/Users/Utilisateur/Pictures/jgarage/image/accueil.png").getImage(),this);
    GestionInterPanel page_gestinter = new GestionInterPanel(new ImageIcon("C:/Users/Utilisateur/Pictures/jgarage/image/accueil.png").getImage(),this);
    GestionTechPanel page_gesttech = new GestionTechPanel(new ImageIcon("C:/Users/Utilisateur/Pictures/jgarage/image/accueil.png").getImage(),this);
    GestionStockPanel page_geststock = new GestionStockPanel(new ImageIcon("C:/Users/Utilisateur/Pictures/jgarage/image/accueil.png").getImage(),this);
    GestionVehPanel page_gestveh = new GestionVehPanel(new ImageIcon("C:/Users/Utilisateur/Pictures/jgarage/image/accueil.png").getImage(),this);
    SaveVehiculePanel page_saveveh = new SaveVehiculePanel(this);
    SupprimerVehPanel page_supprveh = new SupprimerVehPanel(this);
    ModifierVehPanel page_modifveh = new ModifierVehPanel(this);
    RechercheVehPanel page_rechercheveh = new RechercheVehPanel(this);
    AfficherVehPanel page_afficherveh = new AfficherVehPanel(this);
    EnregistrerClientPanel page_saveClient = new EnregistrerClientPanel(this);
    ModificationStockPanel page_modifStock = new ModificationStockPanel(this);
    EnregistrerInterPanel page_saveInter = new EnregistrerInterPanel(this);
    
    public Fenetre(){
        /* Paramètres de la fenêtre */
        this.setTitle("Page d'accueil");
        this.setSize(750,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        
        /* On rajoute le panel de la page d'accueil à la fenêtre */
       this.getContentPane().add(page_accueil);        
       //this.getContentPane().add(page_supprveh);
       //this.getContentPane().add(page_modifveh);
       //this.getContentPane().add(page_rechercheveh);
       //this.getContentPane().add(page_afficherveh);
       //this.getContentPane().add(page_saveveh); 
       //this.getContentPane().add(page_saveClient);
       //this.getContentPane().add(page_modifStock);
       
        /* On active la visibilité de la fenêtre */
        this.setVisible(true);
        /* Dimensionne la fenêtre à la taille exacte de l'image de fond*/
        this.pack();
        
        
    }
    
    /*Méthode permettant d'afficher la page d'accueil */
    public void affiche_accueil()
    {
        this.setTitle("Accueil");
        page_accueil.setVisible(true);
        
    }
    
    /*
     *  METHODE D'AFFICHAGE DES PAGES DE GESTIONS
     */    
    /* Méthode permettant d'afficher la page gestion administrative */
    public void affiche_page_gestionA()
    {
        this.setTitle("Gestion administrative");
        page_accueil.setVisible(false); 
        this.getContentPane().add(page_gesta);
        page_gesta.setVisible(true);
        
    }    
    /* Méthode permettant d'afficher la page gestion des factures */
    public void affiche_page_gestionFac()
    {
        this.setTitle("Gestion des Factures");
        page_accueil.setVisible(false); 
        this.getContentPane().add(page_gestfac);
        page_gestfac.setVisible(true);
        
    }    
    /* Méthode permettant d'afficher la page gestion des interventions */
    public void affiche_page_gestionInter()
    {
        this.setTitle("Gestion des interventions");
        page_gesta.setVisible(false); 
        this.getContentPane().add(page_gestinter);
        page_gestinter.setVisible(true);        
    }    
    /* Méthode permettant d'afficher la page gestion techniques */
    public void affiche_page_gestionTech()
    {
        this.setTitle("Gestion Technique");
        page_accueil.setVisible(false);
        this.getContentPane().add(page_gesttech);
        page_gesttech.setVisible(true);        
    }    
    /* Méthode permettant d'afficher la page gestion des stocks */
    public void affiche_page_gestionStock()
    {
        this.setTitle("Gestion des Stocks");
        page_accueil.setVisible(false); 
        this.getContentPane().add(page_geststock);
        page_geststock.setVisible(true);        
    }    
    /* Méthode permettant d'afficher la page gestion des vehicules */
    public void affiche_page_gestionVeh()
    {
        this.setTitle("Gestion des Vehicules");
        page_gesta.setVisible(false); 
        this.getContentPane().add(page_gestveh);
        page_gestveh.setVisible(true);        
    }
    
    /*
     *  METHODE D'AFFICHAGE DES PANELS DE GESTIONS DES VEHICULES 
     */
    /* Méthode permettant d'afficher la page d'enregistrement des véhicules */
    public void affiche_page_saveVeh()
    {
        this.setTitle("Enregistrer un vehicule");
        page_gestveh.setVisible(false); 
        this.getContentPane().add(page_saveveh);
        page_saveveh.setVisible(true);        
    }
    
    /* Méthode permettant d'afficher la page de modification des vehicules */
    public void affiche_page_ModifierVehPanel()
    {
        this.setTitle("Modifier un vehicule");
        page_gestveh.setVisible(false); 
        this.getContentPane().add(page_modifveh);
        page_modifveh.setVisible(true);        
    }
    
    /* Méthode permettant d'afficher la page de recherche des véhicules */
    public void affiche_page_RechercheVehPanel()
    {
        this.setTitle("Rechercher un vehicule");
        page_gestveh.setVisible(false); 
        this.getContentPane().add(page_rechercheveh);
        page_rechercheveh.setVisible(true);        
    }    
    /* Méthode permettant d'afficher la page d'affichage des véhicules */
    public void affiche_page_AfficherVehPanel()
    {
        this.setTitle("Affichage des vehicules");
        page_gestveh.setVisible(false); 
        this.getContentPane().add(page_afficherveh);
        page_afficherveh.setVisible(true);        
    }
    /* Méthode permettant d'afficher la page de suppression des vehicules */
    public void affiche_page_SupprimerVehPanel()
    {
        this.setTitle("Suppression des vehicules");
        page_gestveh.setVisible(false); 
        this.getContentPane().add(page_supprveh);
        page_supprveh.setVisible(true);        
    }
    /* Méthode permettant d'afficher la page de suppression des vehicules */
    public void affiche_page_saveClient()
    {
        this.setTitle("Ajout d'un client");
        page_saveveh.setVisible(false); 
        this.getContentPane().add(page_saveClient);
        page_saveClient.setVisible(true);        
    }
    
    public void affiche_page_modifstock()
    {
       this.setTitle("Modification des stocks");
        page_geststock.setVisible(false); 
        this.getContentPane().add(page_modifStock);
        page_modifStock.setVisible(true);    
    }
    
    public void affiche_page_saveinter()
    {
       this.setTitle("Programmer une intervention");
        page_gestinter.setVisible(false); 
        this.getContentPane().add(page_saveInter);
        page_saveInter.setVisible(true);    
    }
}
