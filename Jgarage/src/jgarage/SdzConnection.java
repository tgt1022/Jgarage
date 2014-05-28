/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Utilisateur
 */
public class SdzConnection {
    
    private String port = "3306";
    private String url = "jdbc:mysql://localhost:" + port + "/jGarage";
    private String user = "root";
    private String pwd = "";
    private static Connection conn;
    
    private SdzConnection(){
        try{
            conn = DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    //Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
    public static Connection getInstance(){
        if ( conn==null){
            new SdzConnection();
            //System.out.println("INSTANCIATION DE LA CONNEXION SQL ");
        }
        else{
            //System.out.println("CONNEXION SQL EXISTANTE ");
        }
       return conn;
    }
    
}
