
import java.util.ArrayList;


public class RetailItem {
    
   private String ItemCode;
   private String description;
   private int unit;
   private double price; 
   private int checkedCount ;  
   private double totalByItem;        

    public double getTotalByItem() {
        return totalByItem;
    }

    public void setTotalByItem(double TotalByItem) {
        this.totalByItem = TotalByItem;
    }
   
    public int getCheckedCount() {
        return checkedCount;
    }

    public void setCheckedCount(int checkedCount) {
        this.checkedCount = checkedCount;
    }
   
   //the default constructor
   RetailItem(){}
   
   RetailItem(String ItemCode,String description,int unit,double price)
   {
       this.ItemCode= ItemCode;
       this.description = description;       
       this.unit = unit;
       this.price = price;
 
   } 

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
   
   
   
   
   
}
