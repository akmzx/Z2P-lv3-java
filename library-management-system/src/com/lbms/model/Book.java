package com.lbms.model;

import java.time.LocalDate;

public class Book {
	private int code;
	private LocalDate publish_date;
	private String title;
	private Author author = new Author();
	private Category category = new Category();
	private String available;
	private Librarian created_by = new Librarian();
	private Member borrowed_by = new Member();
	private LocalDate borrowed_date;
	private LocalDate due_date;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(LocalDate publish_date) {
		this.publish_date = publish_date;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String avaiable) {
		this.available = avaiable;
	}
	public Librarian getCreated_by() {
		return created_by;
	}
	public void setCreated_by(Librarian created_by) {
		this.created_by = created_by;
	}
	public Author getAuthor() {
		return author;
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
	public String getAuthorName() {
		return author.getName();
	}
	public String getCategoryName() {
		return category.getName();
	}
	public String getLibrarianName() {
		return created_by.getName();
	}
	public Member getBorrowed_by() {
		return borrowed_by;
	}
	public void setBorrowed_by(Member borrowed_by) {
		this.borrowed_by = borrowed_by;
	}
	public LocalDate getBorrowed_date() {
		return borrowed_date;
	}
	public void setBorrowed_date(LocalDate borrowed_date) {
		this.borrowed_date = borrowed_date;
	}
	public LocalDate getDue_date() {
		return due_date;
	}
	public void setDue_date(LocalDate due_date) {
		this.due_date = due_date;
	}
}
