package com.cg.obms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/************************************************************************************
 *          @author         	TARUN KUMAR BANDARU 
 *          
 *          Description      	It is a entity class that have book title, book id, 
 *          					book author, book price, book ISBN, book category, 
 *          					that are mapped to book_tbl table in the database. 
 *                                                 
 *        	Version          	1.0
 *         
 *         	Created Date    	06-OCT-2020
 ************************************************************************************/

@Entity
@Table(name = "book_tbl")
public class Book {
	
	@Id
	@Column(name = "book_id")
	@GeneratedValue(generator = "book_seq",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "book_seq",sequenceName = "book_seq",allocationSize = 1)
	private int bookId;
	
	@Column(name = "book_title",length = 20)
	private String bookTitle;
	
	@Column(name = "book_author",length = 20)
	private String bookAuthor;
	
	@Column(name = "book_price")
	private double bookPrice;
	
	@Column(name = "book_isbn",length = 20)
	private String bookISBN;
	
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "category_id")
	private Category category;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	

}
