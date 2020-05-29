package ecommerce;

public class CartItem {

	private int productId;
	private int quantity;
	
	
	public CartItem(int productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public int getProductId() {
		return productId;
	}
	public int getQuantity() {
		return quantity;
	}

}
