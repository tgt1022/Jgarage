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
public class StockDAO extends DAO<Stock> {
    
    public StockDAO(Connection conn){
        super(conn);
    }
    
    @Override
    public boolean create(Stock s)
    {                        
        try 
        {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO stock "
                    + "(prix,quantite,type) VALUES (?, ?, ?);");
            prepare.setDouble(1,s.getPrix());
            prepare.setFloat(2,s.getQuantite());
            prepare.setString(3,s.getType());
            
            prepare.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    

    @Override
    public boolean delete(Stock s)
    {
        try 
            {
                int result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("Delete from stock Where idStock = "+s.getIdStock());

            } catch (SQLException e){
                e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Stock s) {        
        try 
            {
                this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeUpdate(
                        "Update stock SET prix = '"+s.getPrix()+"',"
                        + " quantite = '"+s.getQuantite()+"' Where idStock="+s.getIdStock()+";");
                
                
            } catch (SQLException e){
                e.printStackTrace();
        }
        return true;
        
    }

    @Override
    public Stock find(int id) {
        
        Stock stock = new Stock();
        
        try 
        {
            ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select * From stock Where idStock = "+id);

            if (result.first())
            {
                stock= new Stock(id,
                    result.getInt("prix"),
                    result.getInt("quantite"),
                    result.getString("type"));
            } 
        } catch (SQLException e){
            e.printStackTrace();
        }
        return stock;
    }

    @Override
    public ResultSet order(String critere) {
        
        ResultSet result = null;
        
        try 
        {
            result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select * From stock ORDER BY = "+critere);

               
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
    
    public int getLastId(){        
        
        int idVehicule=0;         
        
        try 
        {
            ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("Select Max(`idStock`) From `stock`;");
            
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

    
}
