/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgarage;

/**
 *
 * @author Utilisateur
 */
public class ControlerModifStock {
    
    private int idStock;
    private int prix;
    private int quantite;
    private String type_stock;
    private Boolean retour;
    
    
    public ControlerModifStock(int idStock,int prix,int quantite,String type_stock)
    {
        this.idStock = idStock;
        this.prix = prix;
        this.quantite=quantite;
        this.type_stock=type_stock;
    }
    
    public boolean modification()
    {
        Stock monStock = new Stock(idStock, prix, quantite,type_stock);
        DAO<Stock> StockDao = new StockDAO(SdzConnection.getInstance());
        retour = StockDao.update(monStock);  
        
        return retour;
    }
}
