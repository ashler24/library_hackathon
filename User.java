package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User 
{
	private int id;
	private String name, email, phone, password;
	private Role role;
	List<IssueRecord>listOfIssueRecords = new ArrayList<>();
	/* List<Payments>listOfPayments = new ArrayList<>(); */
	
	public User() 
	{
		System.out.println("in ctor of "+getClass().getName());
	}

	public User(String name, String email, String phone, String password, Role role) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.role = role;
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
	@Column(length = 40, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length = 40, unique = true)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(length = 40, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length = 40)
	@Enumerated(EnumType.STRING)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	public List<IssueRecord> getListOfIssueRecords() {
		return listOfIssueRecords;
	}

	public void setListOfIssueRecords(List<IssueRecord> listOfIssueRecords) {
		this.listOfIssueRecords = listOfIssueRecords;
	}
	/*
	 * @OneToMany(mappedBy = "user", fetch = FetchType.EAGER) public List<Payments>
	 * getListOfPayments() { return listOfPayments; }
	 * 
	 * public void setListOfPayments(List<Payments> listOfPayments) {
	 * this.listOfPayments = listOfPayments; }
	 */

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, email=%s, phone=%s, password=%s, role=%s]", id, name, email, phone,
				password, role);
	}
	
	
}
