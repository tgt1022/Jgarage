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
public class InterventionDAO extends DAO<Intervention>{

    public InterventionDAO(Connection conn){
        super(conn);
    }
    
    @Override
    public boolean create(Intervention i)
    {                        
        try 
        {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO intervention"
                    + " (idVehicule,nature,prix,date_debut,date_fin)"
                    + " VALUES (? , ? , ? , ? , ?);"); 
            prepare.setInt(1,i.getidVehicule());
            prepare.setString(2,i.getNature());            
            prepare.setFloat(3,i.getPrix());
            prepare.setString(4,i.getDate_debut());
            prepare.setString(5,i.getDate_fin());
            
            
            prepare.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    

    @Override
    public boolean delete(Intervention i)
    {
        try 
            {
                int result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("Delete from intervention Where idIntervention = "+i.getidIntervention());

            } catch (SQLException e){
                e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Intervention i) {
        
        try 
            {
                this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeUpdate(
                        "Update intervnetion SET nature = '" +i.getNature()+ "' and "
                        + " prix = '" +i.getPrix()+ "' and date_debut = '" +i.getDate_debut()+ "' "
                        + " and date_fin = '" +i.getDate_fin());

            } catch (SQLException e){
                e.printStackTrace();
        }
        return true;
        
    }

    @Override
    public Intervention find(int id) {
        
        Intervention intervention = new Intervention();
        
        try 
        {
            ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select * From intervention Where idIntervention = "+id);

            if (result.first())
            {
                intervention= new Intervention(id,
                    result.getInt("idVehicule"),
                    result.getString("nature"),                        
                    result.getInt("prix"),
                    result.getString("date_debut"),
                    result.getString("date_fin"));
            } 
        } catch (SQLException e){
            e.printStackTrace();
        }
        return intervention;
    }

    @Override
    public ResultSet order(String critere) {
        
        ResultSet result = null;
        
        try 
        {
            result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select * From intervention ORDER BY = "+critere);

               
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
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select * From intervention;");

               
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
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select Max(`idIntervention`) From `intervention`;");
            
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
}
