package com.ecommerce.app;

import java.sql.*;
import com.ecommerce.domain.Products;
import com.ecommerce.helper.ReadFromConsole;
import com.ecommerce.service.ProductsJDBCService;
import com.ecommerce.service.intf.ProductsServiceJDBCIntf;

public class ProductsJDBCApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int choice = 0;
		int prodId;
		String prodName;
		double price;
		int qty;
		String prodDesc;

		ProductsServiceJDBCIntf inventoryService = new ProductsJDBCService();
		Products prod = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/praveen", "root", "root");

			do {

				showMenu();
				choice = ReadFromConsole.readInt("Enter your choice [1-4]:");
				switch (choice) {
				case 1:
					prodName = ReadFromConsole.readString("Product Name:");
					prodDesc = ReadFromConsole.readString("Product Description:");
					price = ReadFromConsole.readDouble("Product Price:");
					qty = ReadFromConsole.readInt("Product Qty:");
					prod = new Products(prodName, price, qty, prodDesc);
					inventoryService.addInventory(con, prod);
					System.out.println("Product added successfully");
					break;
				case 2:
					prodId = ReadFromConsole.readInt("Product Id to search for:");
					prod = inventoryService.searchForProductId(con, prodId);
					break;
				case 3:
					System.out.println("============== ALL PRODUCTS LIST ===============");
					inventoryService.showAllProducts(con);

					break;
				case 4:
					System.out.println("You are Exit!");
					break;
				default:
					System.out.println("Selected option not available!");
					break;
				}

			} while (choice != 4);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private static void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("============== OPTIONS MENU ===============");
		System.out.println("\t1.Add product to inventory");
		System.out.println("\t2.Search a product");
		System.out.println("\t3.Show all products");
		System.out.println("\t4.Exit");
//		System.out.println("\t9.Search by name");
		System.out.println("===========================================");

	}

}
