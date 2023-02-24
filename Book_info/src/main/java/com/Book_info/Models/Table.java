package com.Book_info.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@jakarta.persistence.Table(name="book_info")


public class Table {
   
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BookId")
	private int bookid;
	@Column(name="Book_Name")
	private String bookname;
	@Column(name="Author_Name")
	private String authorname;
	@Column(name="Price")
	private int price;
	@Column(name="Published_Year")
	private int pub_year;
	@Column(name="Book_Volume")
	private int bookvolume;
	@Column(name="Quantity")
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPub_year() {
		return pub_year;
	}
	public void setPub_year(int pub_year) {
		this.pub_year = pub_year;
	}
	public int getBookvolume() {
		return bookvolume;
	}
	public void setBookvolume(int bookvolume) {
		this.bookvolume = bookvolume;
	}
	public Table(int bookid, String bookname, String authorname, int price, int pub_year,int bookvolume,int quantity) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.authorname = authorname;
		this.price = price;
		this.pub_year = pub_year;
		this.setBookvolume(bookvolume);
		this.quantity = quantity;
	}
	public Table()
	{
		
	}
}
	