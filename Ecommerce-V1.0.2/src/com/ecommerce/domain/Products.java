package com.ecommerce.domain;

public class Products {

	int id;
	String productName;
	double price;
	int qty;
	String prodDesc;

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(String productName, double price, int qty, String prodDesc) {
		super();
		// this.id = id;
		this.productName = productName;
		this.price = price;
		this.qty = qty;
		this.prodDesc = prodDesc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public double getStockValue() {
		return price * qty;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + "\t" + productName + "\t" + prodDesc + "\t" + price + "\t" + qty + "\t" + getStockValue();
	}
}
