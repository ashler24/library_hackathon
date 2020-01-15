package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payments 
{
	private int id;
	private double amount;
	private Mode modeOfPayment;
	private LocalDateTime transactionTime;
	private LocalDate nextpayment_duedate;
	private User user;
	
	public Payments() 
	{
		System.out.println("in ctor of "+getClass().getName());
	}

	public Payments(double amount, Mode modeOfPayment, LocalDateTime transactionTime, LocalDate nextpayment_duedate) {
		super();
		this.amount = amount;
		this.modeOfPayment = modeOfPayment;
		this.transactionTime = transactionTime;
		this.nextpayment_duedate = nextpayment_duedate;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Enumerated(EnumType.STRING)
	@Column(length = 40)
	public Mode getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(Mode modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}

	public LocalDate getNextpayment_duedate() {
		return nextpayment_duedate;
	}

	public void setNextpayment_duedate(LocalDate nextpayment_duedate) {
		this.nextpayment_duedate = nextpayment_duedate;
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
				"Payments [id=%s, amount=%s, modeOfPayment=%s, transactionTime=%s, nextpayment_duedate=%s, user=%s]",
				id, amount, modeOfPayment, transactionTime, nextpayment_duedate, user);
	}
	
}
