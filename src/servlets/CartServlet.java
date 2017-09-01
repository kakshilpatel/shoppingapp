package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.ProductDb;
import domain.Cart;
import domain.OrderItem;
import domain.Product;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String product_Name = request.getParameter("product_Name");
		String strQuantity = request.getParameter("quantity");
		if (product_Name != null) {
			synchronized (session) {
				Cart cart = (Cart) session.getAttribute("cart");
				if (cart == null) {
					cart = new Cart();
					session.setAttribute("cart", cart);
				}
				int quantity = 1;
				try {
					quantity = Integer.parseInt(strQuantity);
					if (quantity < 0) {
						quantity = 1;
					}
				} catch (NumberFormatException e) {
					quantity = 1;
				}
				OrderItem item = new OrderItem();
				Product product = ProductDb.getProduct(product_Name);
				item.setProduct(product);
				item.setQuantity(quantity);
				if (quantity > 0) {
					cart.addItem(item);
				} else if (quantity <= 0) {
					cart.removeItem(item);
				}
				session.setAttribute("cart", cart);
			}
		}
		String url = "/cart.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}