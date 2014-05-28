/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Utilisateur
 */
public class TableauClientsModel extends AbstractTableModel {
    
    Object donnees[][];
    String entetes[]; 

   
   public TableauClientsModel(Object[][] donnees, String[] entetes)  { 
      this.donnees = donnees; 
      this.entetes = entetes; 
 
   }     
    
 //  @Override
//   public Class<?> getColumnClass(int columnIndex)
//   {// pour trier les nombre par ordre numerique sans le "bug des 0"
//       return getValueAt(0, column).getClass();
//   }
   
   @Override 
    public String getColumnName(int columnIndex)
   {
       return entetes[columnIndex];
   }

    @Override
    public int getRowCount() {
        
        return donnees.length; 
        
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
       
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
     
        return donnees[rowIndex][columnIndex];
        
        
    }
    
}
