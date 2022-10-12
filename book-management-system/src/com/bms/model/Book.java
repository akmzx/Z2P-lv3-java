package com.bms.model;

public class Book {

	private int id;
	private String title;
	private double price;
	private Author author = new Author();
	private Category category = new Category();
	private User created_by = new User();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Author getAuthor() {
		return author;
	}
	public String getAuthorName() { // authorName
		return author.getName();
	}
	public String getCategoryName() {
		return category.getName();
	}
	public String getUserName() {
		return created_by.getEmail();
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getCreated_by() {
		return created_by;
	}
	public void setCreated_by(User created_by) {
		this.created_by = created_by;
	}
	
	
}