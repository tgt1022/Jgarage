/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

/**
 *
 * @author Utilisateur
 */
public class ControlerSaveIntervention {
    
    private Intervention i;
    
    public ControlerSaveIntervention(Intervention i)
    {
        this.i = i;
    }
    
    public boolean saveIntervention()
    {
        
        DAO<Intervention> InterventionDao = new InterventionDAO(SdzConnection.getInstance());
        Boolean retour = InterventionDao.create(i); 
        
        return retour;
    }
}
