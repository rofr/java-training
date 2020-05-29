package ecommerce;

public class OrderProcessor {
    private InventoryManager inventoryManager;
    private OrderRepository orderRepository;

    public void placeOrder(ShoppingCart cart) {
    	int count = cart.count();
        for(int i = 0; i < count; i++) {
        	CartItem item = cart.getItem(i);
            inventoryManager.reserve(
                    item.getProductId(),
                    item.getQuantity());
        }
        orderRepository.saveOrder(cart);
    }
}