package com.lbms.model;

import java.time.LocalDate;

public class Transaction {

	private int id;
	private int card_id;
	private int book_id;
	private LocalDate borrow_date;
	private LocalDate due_date;
	private int fees;
	private int lib_ib;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public LocalDate getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(LocalDate borrow_date) {
		this.borrow_date = borrow_date;
	}
	public LocalDate getDue_date() {
		return due_date;
	}
	public void setDue_date(LocalDate due_date) {
		this.due_date = due_date;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public int getLib_ib() {
		return lib_ib;
	}
	public void setLib_ib(int lib_ib) {
		this.lib_ib = lib_ib;
	}
}
