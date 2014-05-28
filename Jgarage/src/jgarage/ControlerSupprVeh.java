/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

import java.sql.ResultSet;

/**
 *
 * @author Utilisateur
 */
public class ControlerSupprVeh  {
    
    private Vehicule v;        
    private Boolean retour;
    
    public ControlerSupprVeh(Vehicule v)
    {
        this.v = v;
    }
    
    public Boolean delete()
    {
        DAO<Vehicule> VehiculeDao = new VehiculeDAO(SdzConnection.getInstance());
        retour = VehiculeDao.delete(v);
        
        return retour;
    }
}
