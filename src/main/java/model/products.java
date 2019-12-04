package model;

import java.io.Serializable;

public class products implements Serializable

{
		private int productid;
		private String name;
		private String category;
		private float price;
		private String brand;
		private int size;
		private String colour;
		private int quantity;
		private String description;
		
		public int getProductid() {
			return productid;
		}
		public void setProductid(int productid) {
			this.productid = productid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public String getColour() {
			return colour;
		}
		public void setColour(String colour) {
			this.colour = colour;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		} 
}
