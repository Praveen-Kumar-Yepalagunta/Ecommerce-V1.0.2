package com.ecommerce.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ecommerce.domain.Products;
import com.ecommerce.service.intf.ProductsServiceJDBCIntf;

public class ProductsJDBCService implements ProductsServiceJDBCIntf {

	public Products addInventory(Connection con, Products prod) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into products values(?,?,?,?,?)");
			ps.setInt(1, prod.getId());
			ps.setString(2, prod.getProductName());
			ps.setString(3, prod.getProdDesc());
			ps.setDouble(4, prod.getPrice());
			ps.setInt(5, prod.getQty());

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prod;
	}

	public void showAProduct(Products prod) {
		System.out.println("Product Id:" + prod.getId());
		System.out.println("Product Name:" + prod.getProductName());
		System.out.println("Product Description:" + prod.getProdDesc());
		System.out.println("Product Price :" + prod.getPrice());
		System.out.println("Product Qty :" + prod.getQty());
//		System.out.println("Stock value of the product:"+prod.getStockValue());
	}

	public void showAllProducts(Connection con) {
		try {
			Statement stmt = con.createStatement();
			String s = "SELECT * from products";

			ResultSet rs = stmt.executeQuery(s);
			System.out.println("Product id\tProduct Name\tProduct Description\tPrice\tQuantity");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", "
						+ rs.getDouble(4) + ", " + rs.getInt(5));
			}
			rs.close();
			stmt.close();
//		  con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Products searchForProductId(Connection con, int prodId) {
		Products prod = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from products where prod_id=?");
			ps.setInt(1, prodId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
						+ rs.getDouble(4) + "\t" + rs.getInt(5));

			}
			rs.close();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prod;
	}

	public Products updateProductUsingId(Connection con, int prodId, int qty, double price) {

		return null;

	}

	public boolean deleteProduct(Connection con, Products prod) {

		return false;

	}

}
