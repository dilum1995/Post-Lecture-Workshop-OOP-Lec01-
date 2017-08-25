
import java.util.ArrayList;
import java.util.Scanner;


public class CashRegister {
    
    //The arrayList which contains item data
    private static ArrayList<RetailItem> lstItems = new ArrayList<RetailItem>();
    
    //The arrayList which contains purchased data
    private static ArrayList<RetailItem> purchaseList = new ArrayList<RetailItem>();
    private static Scanner sc = new Scanner(System.in);
    private static String selecteditemcode;
    private static String userSelection = null ;
    private static double finalTotal = 0.000;
    
    public static void main(String[] args)
    {   
        FillRetial_Items();        
        displayItems();
        check_out();    
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
        
//        if (lstItems.size() < 1) {
//            FillRetial_Items();
//        }  
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
                break;
            }
        }        
        System.out.println("");
        System.out.print("Do you want to buy more Y/N:");
        userSelection = sc.nextLine().toString();      

        } while (userSelection.equalsIgnoreCase("Y"));            
        
    }   
    private static void purchase_item(RetailItem obj)
    {
        boolean isExists = false;
        int existingIndex = -1;
        if(purchaseList.size() > 0)
        {
            for (int i = 0; i < purchaseList.size(); i++) {
                
                if(obj.getItemCode().equals(purchaseList.get(i).getItemCode()))
                {
                    isExists = true;
                    existingIndex = i;
                    break; 
                }                           
            }            
            if(isExists)
            {
                if(existingIndex != -1)
                {
                    purchaseList.get(existingIndex).setCheckedCount(purchaseList.get(existingIndex).getCheckedCount() + 1);
                }                
            }
            else
            {
                obj.setCheckedCount(1); 
                purchaseList.add(obj);
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
        System.out.println("Item-count\t"+"Item-Code\t"+"Item-Name\t"+"Unit-price\t"+"Total Price By Item\t\n");
            for (int i = 0; i < purchaseList.size(); i++) {
               
                purchaseList.get(i).setTotalByItem(purchaseList.get(i).getCheckedCount() *purchaseList.get(i).getPrice());
                System.out.print(purchaseList.get(i).getCheckedCount()+"\t\t" + purchaseList.get(i).getItemCode()+"\t\t" +purchaseList.get(i).getDescription()+"\t\t" +purchaseList.get(i).getPrice()+"\t\t"+ purchaseList.get(i).getTotalByItem()+"\t\n");
            }           
        
        System.out.println("\nSelect your option");
        System.out.println("A-Purchase more items"+"\t\t\t"+"B-Get total price");
        userSelection = sc.next().toUpperCase();
        
        switch(userSelection){
        
            case "A": 
                displayItems();
                break;
                
            case "B":
                get_total();
                break;
                
            default: 
                System.err.println("Please enter a valid option");
                break;
        }          
    } 
    
    //method which calculates the total
    private static void get_total()
    {   
        System.out.println("\n");
        for (int i = 0; i < purchaseList.size(); i++) {
            finalTotal += purchaseList.get(i).getTotalByItem();
        }
        System.out.println("Total Price :" + finalTotal);
        System.out.println("\n");
        System.out.println("\nSelect your option");
        System.out.println("A-Purchase more items"+"\n"+"B-Clear purchase history"+"\n"+"C-Terminate program");
        userSelection = sc.next().toUpperCase();
        
        switch(userSelection){
        
            case "A": 
                displayItems();
                break;
                
            case "B":
                clear();
                break;
                
            case "C":
                terminate();
                break;
                
            default: 
                System.err.println("Please enter a valid option");
                break;
        }  
    }
    
    //method which will clear the user's purchase history
    private static void clear()
    {
        System.out.println("Purchase history has been cleared.....");
        purchaseList.clear();
        displayItems();
    }
    
    //using this method user can terminate the program
    private static void terminate()
    {
        System.exit(0);
    }
}
