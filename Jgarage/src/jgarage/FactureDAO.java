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
public class FactureDAO extends DAO<Facture> {
    
    public FactureDAO(Connection conn){
        super(conn);
    }
    
    @Override
    public boolean create(Facture f)
    {                        
        try 
        {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO facture (date,montant)"
                    + " VALUES (? , ? );");
            prepare.setString(2,f.getDate());
            prepare.setFloat(3,f.getMontant());            
                        
            prepare.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    

    @Override
    public boolean delete(Facture f)
    {
        try 
            {
                int result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("Delete from facture Where idFacture = "+f.getId());

            } catch (SQLException e){
                e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Facture f) {        
        try 
            {
                this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeUpdate(
                        "Update facture SET date = '" +f.getDate()+ "' and "
                        + " montant = '" +f.getMontant()+ "' ;");

            } catch (SQLException e){
                e.printStackTrace();
        }
        return true;
        
    }

    @Override
    public Facture find(int id) {
        
        Facture facture = new Facture();
        
        try 
        {
            ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select * From facture Where idFacture = "+id);

            if (result.first())
            {
                facture= new Facture(id,
                    result.getString("date"),
                    result.getFloat("montant"));
            } 
        } catch (SQLException e){
            e.printStackTrace();
        }
        return facture;
    }

    @Override
    public ResultSet order(String critere) {
        
        ResultSet result = null;
        
        try 
        {
            result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select * From facture ORDER BY = "+critere);

               
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
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select * From facture;");

               
        } catch (SQLException e){
            e.printStackTrace();
        }
        
       return result;
    }

    @Override
    public int getLastId(){        
        
        int idVehicule=0;         
        
        try 
        {
            ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select Max(`idFacture`) From `facture`;");
            
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
