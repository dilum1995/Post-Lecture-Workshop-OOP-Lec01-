
import java.util.ArrayList;
import java.util.Scanner;


public class CashRegister {
    
    //The arrayList which contains item data
    private static ArrayList<RetailItem> lstItems = new ArrayList<RetailItem>();
    
    //The arrayList which contains purchased data
    private static ArrayList<RetailItem> purchaseList = new ArrayList<RetailItem>();
    private static Scanner sc = new Scanner(System.in);
    private static String selecteditemcode;
    private static String userSelection;
    
    public static void main(String[] args)
    {           
       displayItems();
       check_out();
       
//       clear();
        
    }
   
   //method which fills the details of a retial items
   public static void FillRetial_Items()
    {
        //add item data to the arryList
        lstItems.add(new RetailItem("#R1001","ITEM1", 10, 100.50));
        lstItems.add(new RetailItem("#R1002","ITEM2", 15, 500.50));
        lstItems.add(new RetailItem("#R1003","ITEM3", 20, 300.50));
        
        lstItems.add(new RetailItem("#R2001","ITEM4", 10, 400.50));
        lstItems.add(new RetailItem("#R2002","ITEM5", 15, 200.50));
        lstItems.add(new RetailItem("#R2003","ITEM6", 20, 600.50));
        
        
    }
    
   //menu which display the stock availability
    private static void displayItems() {
        FillRetial_Items();
        
        System.out.println("\n-------------------------------------- Retail Shop V1.0 --------------------------------------------\n");
        
        System.out.println(String.format("%-65s%-60s%n", "\t\t Row-01", "Row -02"));
        System.out.print(String.format("%-15s%-15s%-15s", "Item-Code", "Item-Name", "Price\t\t|"));
	System.out.println(String.format("%-15s%-15s%-15s%n", "\tItem-Code", "Item-Name", "Price"));        

        for (int i = 0; i < lstItems.size()-3; i++) {
        
            System.out.print(String.format("%-15s%-15s%-15s", lstItems.get(i).getItemCode(), lstItems.get(i).getDescription(), lstItems.get(i).getPrice()+"\t\t|"));
            System.out.println(String.format("%-15s%-15s%-15s%n", "\t"+lstItems.get(i+3).getItemCode(), lstItems.get(i+3).getDescription(), lstItems.get(i+3).getPrice()));
            System.out.println("");
            
            RetailItem objRetailItem = new RetailItem();;
            objRetailItem = lstItems.get(i);
        }
        
        do {
            System.out.print("Type the Item Code :");
            selecteditemcode = sc.nextLine().toString();          
            
        for (int i = 0; i < lstItems.size(); i++) {
            if(lstItems.get(i).getItemCode().equals(selecteditemcode))
            {
                purchase_item(lstItems.get(i));
            }
        }        
        System.out.print("Do you want to buy more Y/N:");
        userSelection = sc.nextLine().toString();      

        } while (userSelection.equalsIgnoreCase("Y"));            
        
    }   
    private static void purchase_item(RetailItem obj)
    {
        if(purchaseList.size() > 0)
        {
            for (int i = 0; i < purchaseList.size(); i++) {
            if(purchaseList.get(i).equals(obj))
            {
                purchaseList.get(i).setCheckedCount(purchaseList.get(i).getCheckedCount() + 1);
            }
            else
            {
                purchaseList.add(obj);
            }
            } 
        }        
        else
        {
            obj.setCheckedCount(1);            
            purchaseList.add(obj);
        }
        
    }
    
    private static void check_out()
    {    
        System.out.println("Your purhase history\n");
        System.out.println("Item count\t"+"Item-Code\t"+"Item-Name\t"+"Price\t\n");
            for (int i = 0; i < purchaseList.size(); i++) {
                
               
                System.out.print(purchaseList.get(i).getCheckedCount()+"\t\t" + purchaseList.get(i).getItemCode()+"\t\t" +purchaseList.get(i).getDescription()+"\t\t" +purchaseList.get(i).getPrice()+"\t\n");
                //System.out.println("");
                //System.out.println(purchaseList.get(i).getDescription() + purchaseList.get(i).getPrice() + "  " + "Count :" + purchaseList.get(i).getCheckedCount());
                
            }
    }
    
    private static void get_total()
    {
        
    }
    
    //method which will clear the user's purchase history
    private static void clear()
    {
        purchaseList.clear();
    }
}
