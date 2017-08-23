
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dilumdesilva
 */
public class CashRegister {    
    
    ArrayList<RetailItem> lstRetailItem = new ArrayList<RetailItem>();   
    
    public static void main(String[] args)
    {
        
        
       
    }
    
   
    
   
    
    public void pur (RetailItem objRetailItem)
    {        
        lstRetailItem.add(objRetailItem);
    }
        
    public void ppp ()
    {
        RetailItem objRetailItem;
        //CashRegister OBJ =  new CashRegister();
        objRetailItem = new RetailItem("ddgg", "u", 23.9);       
        
        this.pur(objRetailItem);
    }
}
