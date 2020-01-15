package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "books")
public class Books 
{
	private int id;
	private String name, author, subject;
	private double price;
	private String isbn;
	private List<Copies>listOfCopies = new ArrayList<Copies>();
	
	public Books() 
	{
		System.out.println("in ctor of "+getClass().getName());
	}

	public Books(String name, String author, String subject, double price, String isbn) {
		super();
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.price = price;
		this.isbn = isbn;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(length = 40)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 40)
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	@Column(length = 40)
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	public List<Copies> getListOfCopies() {
		return listOfCopies;
	}
	@Column(length = 40, nullable = false)
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setListOfCopies(List<Copies> listOfCopies) {
		this.listOfCopies = listOfCopies;
	}

@Override
	public String toString() {
		return String.format("Books [id=%s, name=%s, author=%s, subject=%s, price=%s, isbn=%s]", id,
				name, author, subject, price, isbn);
	}

	//helpers	
	public void addCopies(Copies c)
	{
		listOfCopies.add(c);
		c.setBook(this);
	}
}
