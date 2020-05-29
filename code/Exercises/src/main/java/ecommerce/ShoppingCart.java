package ecommerce;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	private List<CartItem> items;
	
	public ShoppingCart() {
		items = new ArrayList<CartItem>();
	}

	public CartItem getItem(int i) {
		return items.get(i);
	}
	
	public void add(CartItem item) {
		items.add(item);
	}
	
	public int count() {
		return items.size();
	}
}
