
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
 class RetailItem {
   String description;
   String unit;
   double price;   
   
   RetailItem(){}
   
   RetailItem(String description,String unit,double price)
   {
       this.description = description;       
       this.unit = unit;
       this.price = price;
 
   } 
   public ArrayList<RetailItem> ShowRetial_Items()
    {
        ArrayList<RetailItem> lstSavedItems = new ArrayList<RetailItem>();
        lstSavedItems.add(new RetailItem("Book", "P", 45));
        lstSavedItems.add(new RetailItem("Book", "P", 45));
        lstSavedItems.add(new RetailItem("Book", "P", 45));
        lstSavedItems.add(new RetailItem("Book", "P", 45));
        lstSavedItems.add(new RetailItem("Book", "P", 45));
        lstSavedItems.add(new RetailItem("Book", "P", 45));
        lstSavedItems.add(new RetailItem("Book", "P", 45));
        return  lstSavedItems;
    }
}
