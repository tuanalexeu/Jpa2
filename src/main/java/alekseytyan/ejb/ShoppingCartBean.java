package alekseytyan.ejb;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.HashMap;
import java.util.Map;


@Stateful
public class ShoppingCartBean implements ShoppingCart {

    private final Map<String, Integer> items;

    public ShoppingCartBean(Map<String, Integer> items) {
        this.items = items;
    }

    public ShoppingCartBean() {
        this(new HashMap<>());
    }

    @Override
    public void addItem(String id, int quantity) {
        Integer orderQuantity = items.get(id);

        if(orderQuantity == null) {
            orderQuantity = 0;
        }
        orderQuantity += quantity;
        items.put(id, orderQuantity);
    }

    @Override
    public void removeItem(String id, int quantity) {

    }

    @Override
    public Map<String, Integer> getItems() {
        return null;
    }

    @Override
    @Remove
    public void checkout(int paymentId) {
        // Store items to DB
    }

    @Override
    @Remove
    public void cancel() {

    }
}
