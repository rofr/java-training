package ecommerce;

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