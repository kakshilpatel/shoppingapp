package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import domain.Product;

public class ProductDb {
	public static Product getProduct(String product_Name) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs;
		String query = "SELECT product_Name, price FROM products WHERE product_Name=?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, product_Name);
			rs = ps.executeQuery();
			String name = "";
			Double price = 0.0;
			while (rs.next()) {
				name = rs.getString("product_Name");
				price = rs.getDouble("price");
			}
			Product product = new Product();
			product.setName(name);
			product.setPrice(price);
			return product;
		} catch (SQLException e) {
			return null;
		} finally {
			closeStatement((Statement) ps);
			pool.freeConnection(connection);
		}
	}

	public static ArrayList<Product> getProducts() {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs;
		ArrayList<Product> products;
		String query = "SELECT product_Name, price FROM Products;";
		try {
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			products = new ArrayList<Product>();
			while (rs.next()) {
				Product product = new Product();
				product.setName(rs.getString("product_Name"));
				product.setPrice(rs.getDouble("price"));
				products.add(product);
			}
			return products;
		} catch (SQLException e) {
			return null;
		} finally {
			closeStatement((Statement) ps);
			pool.freeConnection(connection);
		}
	}



	public static void closeStatement(Statement s) {
		try {
			if (s != null) {
				s.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}