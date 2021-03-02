package alekseytyan.ejb;

import java.util.Map;

public interface ShoppingCart {
    void addItem(String id, int quantity);
    void removeItem(String id, int quantity);
    Map<String, Integer> getItems();
    void checkout(int paymentId);
    void cancel();
}
