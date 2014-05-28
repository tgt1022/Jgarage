/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Utilisateur
 */
public class VehiculeDAO extends DAO<Vehicule>{

    public VehiculeDAO(Connection conn){
        super(conn);
    }
    
    @Override
    public boolean create(Vehicule v)
    {                        
        try 
        {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO vehicule"
                    + " (immatriculation,idClient,marque,modele,type,couleur,nb_kilometre,nb_place,annee,photo)"
                    + " VALUES (? , ? , ? , ? , ? , ? , ? , ? , ?, ?);");
            prepare.setString(1,v.getImmat());
            prepare.setInt(2,v.getIdClient());
            prepare.setString(3,v.getMarque());
            prepare.setString(4,v.getModele());
            prepare.setString(5,v.getType());
            prepare.setString(6,v.getCouleur());
            prepare.setInt(7, v.getNb_kilometre());
            prepare.setInt(8, v.getNb_place());
            prepare.setInt(9, v.getAnnee());
            prepare.setString(10,v.getPhoto());
            
            prepare.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    

    @Override
    public boolean delete(Vehicule v)
    {
        try 
            {
                int result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("Delete from vehicule Where idVehicule = "+v.getId());

            } catch (SQLException e){
                e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Vehicule v) {
        
        try 
            {
                this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeUpdate(
                        "Update vehicule SET immatriculation = '" +v.getImmat()+ "' and "
                        + " modele = '" +v.getModele()+ "' and type = '" +v.getType()+ "' and couleur = '" +v.getCouleur()+ "' "
                        + " and nb_kilometre = '" +v.getNb_kilometre()+ "' and nb_place = '" +v.getNb_place()+ "'"
                        + " and annee = '" +v.getAnnee()+ "' and photo = '" +v.getPhoto()+";");

            } catch (SQLException e){
                e.printStackTrace();
        }
        return true;
        
    }

    @Override
    public Vehicule find(int id) {
        
        Vehicule vehicule = new Vehicule();
        
        try 
        {
            ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select * From vehicule Where idVehicule = "+id);

            if (result.first())
            {
                vehicule= new Vehicule(id,
                    result.getInt("idClient"),
                    result.getString("immatriculation"),
                    result.getString("marque"),
                    result.getString("modele"),
                    result.getString("type"),    
                    result.getString("couleur"),
                    result.getInt("nb_kilometre"),
                    result.getInt("nb_place"),
                    result.getInt("annee"),
                    result.getString("photo"));
            } 
        } catch (SQLException e){
            e.printStackTrace();
        }
        return vehicule;
    }

    @Override
    public ResultSet order(String critere) {
        
        ResultSet result = null;
        
        try 
        {
            result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select * From vehicule ORDER BY = "+critere);

               
        } catch (SQLException e){
            e.printStackTrace();
        }
        
       return result;
    }
    
    @Override
    public ResultSet display() {
        
        ResultSet result = null;
        
        try 
        {
            result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select * From vehicule;");

               
        } catch (SQLException e){
            e.printStackTrace();
        }
        
       return result;
    }
    
    public int getLastId(){        
        
        int idVehicule=0;         
        
        try 
        {
            ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select Max(`idVehicule`) From `vehicule`;");
            
            if (result.first())
            {
                idVehicule = result.getInt(1);
                idVehicule = idVehicule + 1;
            }
                        
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return idVehicule;
        
    }

          
    

    @Override
    public ResultSet requete(String parametre, String table, String clause, Object valeurClause) {
        
        ResultSet result = null;      
        
        try 
        {
            result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery(" Select "+parametre+" From "+table+" Where "+clause+" = '"+valeurClause+"'; ");
                
                //System.out.println("Select "+parametre+" From "+table+" Where "+clause+" = '"+valeurClause+"';");
                
                        
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return result;
        
    }
    
    /* SELECT * 
FROM  `vehicule` 
WHERE  `immatriculation` LIKE  '%AB%' */
    
}
