package domain;

import java.util.ArrayList;

public class Cart{
	private ArrayList<OrderItem> items;

	public Cart() {
		items = new ArrayList<OrderItem>();
	}

	public ArrayList<OrderItem> getItems() {
		return items;
	}

	public int getCount() {
		return items.size();
	}

	public void addItem(OrderItem item) {
		String name = item.getProduct().getName();
		int quantity = item.getQuantity();
		for (int i = 0; i < items.size(); i++) {
			OrderItem orderItem = items.get(i);
			if (orderItem.getProduct().getName().equals(name)) {
				orderItem.setQuantity(quantity);
				return;
			}
		}
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		String name = item.getProduct().getName();
		for (int i = 0; i < items.size(); i++) {
			OrderItem orderItem = items.get(i);
			if (orderItem.getProduct().getName().equals(name)) {
				items.remove(i);
				return;
			}
		}
	}
}