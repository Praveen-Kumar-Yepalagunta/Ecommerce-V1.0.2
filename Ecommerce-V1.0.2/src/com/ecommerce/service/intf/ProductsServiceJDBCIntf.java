package com.ecommerce.service.intf;

import java.sql.Connection;
import com.ecommerce.domain.Products;

public interface ProductsServiceJDBCIntf {
	public Products addInventory(Connection con, Products prod);

//		public void showAProduct(Product prod);
	public void showAllProducts(Connection con);

	public Products searchForProductId(Connection con, int prodId);
//		public Product updateProductUsingId(Connection con,int prodId,int qty,double price);
//		public boolean deleteProduct(Connection con,Product prod);

}
