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
public class ClientDAO extends DAO<Client>{
    
    public ClientDAO(Connection conn){
        super(conn);
    }
    
    @Override
    public boolean create(Client c)
    {                        
        try 
        {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO client "
                    + "(nom,prenom,adresse,email) VALUES (?, ? , ? , ?);");
            prepare.setString(1,c.getNom());
            prepare.setString(2,c.getPrenom());
            prepare.setString(3,c.getAdresse());
            prepare.setString(4,c.getEmail());
                        
            prepare.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    

    @Override
    public boolean delete(Client c)
    {
        try 
            {
                int result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("Delete from client Where idClient = "+c.getId());

            } catch (SQLException e){
                e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Client c) {        
        try 
            {
                this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeUpdate(
                        "Update client SET nom = '" +c.getNom()+ "' and "
                        + " prenom = '" +c.getPrenom()+ "' and adresse = '" +c.getAdresse()+"' "
                        + " and email = '"+c.getEmail()+"'; ");

            } catch (SQLException e){
                e.printStackTrace();
        }
        return true;
        
    }

    @Override
    public Client find(int id) {
        
        Client client = new Client();
        
        try 
        {
            ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select * From client Where idClient = "+id);

            if (result.first())
            {
                client= new Client(id,
                    result.getString("nom"),
                    result.getString("prenom"),
                    result.getString("adresse"),
                    result.getString("email"));
            } 
        } catch (SQLException e){
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public ResultSet order(String critere) {
        
        ResultSet result = null;
        
        try 
        {
            result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select * From client ORDER BY = "+critere);

               
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
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select * From client;");

               
        } catch (SQLException e){
            e.printStackTrace();
        }
        
       return result;
    }
          
    /**
     *
     * @return
     */
    @Override
    public int getLastId(){        
        
        int idClient=0;         
        
        try 
        {
            ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select Max(`idClient`) From `client`;");
            
            if (result.first())
            {
                idClient = result.getInt(1);
                idClient = idClient + 1;
            }
                        
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return idClient;
        
    }    

  
    @Override
    public ResultSet requete(String parametre, String table, String clause, Object valeurClause) {
        
        ResultSet result = null;      
        
        try 
        {
            result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery(" Select "+parametre+" From "+table+" Where "+clause+" = '"+valeurClause+"'; ");
                
            
                        
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return result;
        
    }
    
    

  
    
}
