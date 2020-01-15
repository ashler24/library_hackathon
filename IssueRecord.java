package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.core.sym.Name;

@Entity
@Table(name = "issue_record")
public class IssueRecord 
{
	private int id;
	private LocalDate issueDate, returnDueDate, returnDate;
	private double fineAmount;
	private Copies copy;
	private User user;
	
	public IssueRecord() 
	{
		System.out.println("in ctor of "+getClass().getName());
	}

	public IssueRecord(LocalDate issueDate, LocalDate returnDueDate, LocalDate returnDate, double fineAmount) {
		super();
		this.issueDate = issueDate;
		this.returnDueDate = returnDueDate;
		this.returnDate = returnDate;
		this.fineAmount = fineAmount;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getReturnDueDate() {
		return returnDueDate;
	}

	public void setReturnDueDate(LocalDate returnDueDate) {
		this.returnDueDate = returnDueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public double getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}
	@ManyToOne
	@JoinColumn(name = "copy_id")
	public Copies getCopy() {
		return copy;
	}

	public void setCopy(Copies copy) {
		this.copy = copy;
	}
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return String.format(
				"IssueRecord [id=%s, issueDate=%s, returnDueDate=%s, returnDate=%s, fineAmount=%s, copy=%s, user=%s]",
				id, issueDate, returnDueDate, returnDate, fineAmount, copy, user);
	}
	
}
