# Exercises M8 JMockit

## 1. Examine and run test
- Examine the scene.PerformerTests class
- Make sure you can run the test using either the TestNG plugin or by running Maven test

## 2. Create tests for the ecommerce example
Create the following types in the ecommerce package:

```java
public interface InventoryManager {
    void reserve(int productId, int quantity);
}

public interface OrderRepository {
    void saveOrder(ShoppingCart cart);
}

public class OrderProcessor {
    private InventoryManager inventoryManager;
    private OrderRepository orderRepository;

    public void placeOrder(ShoppingCart cart) {
        for(CartItem item: cart.getItems()) {
            inventoryManager.reserve(
                item.getProductId(),
                item.getQuantity());
        }
        orderRepository.saveOrder(cart);
    }
}
```
Write tests for placeOrder that confirm that:
1. inventoryManager.reserve() is called with the correct arguments.
2. orderRepository.saveOrder() is called