package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "copies")
public class Copies 
{
	private int id, rack;
	private Status status;
	private Books book;
	private List<IssueRecord>listOfIssueRecords = new ArrayList<IssueRecord>();
	
	public Copies() 
	{
		System.out.println("in ctor of "+getClass().getName());
	}

	
	public Copies(int rack, Status status, Books book) {
		super();
		this.rack = rack;
		this.status = status;
		this.book = book;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRack() {
		return rack;
	}

	public void setRack(int rack) {
		this.rack = rack;
	}
	@Enumerated(EnumType.STRING)
	@Column(length = 40)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	@ManyToOne
	@JoinColumn(name = "book_id")
	@JsonIgnore
	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}
	@OneToMany(mappedBy = "copy", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	public List<IssueRecord> getListOfIssueRecords() {
		return listOfIssueRecords;
	}

	public void setListOfIssueRecords(List<IssueRecord> listOfIssueRecords) {
		this.listOfIssueRecords = listOfIssueRecords;
	}

	@Override
	public String toString() {
		return String.format("Copies [id=%s, rack=%s, status=%s, book=%s]", id, rack, status, book);
	}
	
	
}
