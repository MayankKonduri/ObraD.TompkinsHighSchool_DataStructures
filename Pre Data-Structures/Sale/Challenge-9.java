import java.util.*;

public class Challenge {
    public static void sale(ArrayList<Item> inventory) {
        for (int i=inventory.size()-1; i>=0;i--) {
            Item item = inventory.get(i);
            int st = item.getStatus();
            double cp = item.getPrice();

            if (st == Item.CLEARANCE) {
                inventory.remove(item); 
            }
            if (st == Item.DISCOUNTED) {
                item.setStatus(Item.CLEARANCE);
                item.setPrice(cp * 0.5); 
            } 
            if ( st == Item.NORMAL) {
                item.setStatus(Item.DISCOUNTED);
                item.setPrice(cp * 0.7); 
            } 
            
        }
    }

    public static void main(String[] args) {

    }
}
