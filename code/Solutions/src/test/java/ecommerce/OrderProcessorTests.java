package ecommerce;

import mockit.*;
import org.testng.annotations.Test;

public class OrderProcessorTests {

    @Injectable InventoryManager inventoryManager;
    @Injectable OrderRepository orderRepository;
    @Tested OrderProcessor orderProcessor;
    @Mocked ShoppingCart shoppingCart;
    
    @Test
    public void adjustsInventory() {
        new Expectations(){{
            shoppingCart.count(); result = 2;
            shoppingCart.getItem(0);
            result = new CartItem(4,40);
            shoppingCart.getItem(1);
            result = new CartItem(5, 50);
        }};

        orderProcessor.placeOrder(shoppingCart);

        new Verifications(){{
            inventoryManager.reserve(4,40);
            times = 1;
            inventoryManager.reserve(5,50);
            times = 1;
            orderRepository.saveOrder(shoppingCart);
            times =1;
        }};
    }
}
