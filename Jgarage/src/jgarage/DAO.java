/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Utilisateur
 */
public abstract class DAO<E> {
    
    protected Connection connect = null;
    
    public DAO(Connection conn){
        this.connect = conn;
    }
    
    public abstract boolean create(E e);
    
    public abstract boolean delete(E e);
    
    public abstract boolean update(E e);
    
    public abstract E find(int id);
    
    public abstract ResultSet order(String critere);
    
    public abstract ResultSet display();
    
    /**
     *
     * @return
     */
    public abstract int getLastId();    
    
    public abstract ResultSet requete(String parametre,String table,String clause, Object valeurClause);
}
