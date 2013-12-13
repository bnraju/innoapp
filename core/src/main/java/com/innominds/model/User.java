package com.innominds.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "USER")
// @Table ( name = "user" , uniqueConstraints =
// {@UniqueConstraint(columnNames={"UserID"})})
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int userID;
	@Column(nullable = false, unique = true)
	private String userName;
	@Column(name="FIRST_NAME",nullable = false)
	private String firstName;
	@Column(name="LAST_NAME",nullable = false)
	private String lastName;
	@Column(name="DOB",nullable = false)
	private Date dob;
	@Column(name="DESIGNATION")
	private String designation;
	@Column(name="PASSWORD",length = 150, nullable = false)
	private String password;
	@Column(name="SALT",nullable = false)
	private String salt;
	@Embedded
	private Address address;
	@ManyToMany
	@JoinTable(name="USER_ROLE",
	joinColumns=@JoinColumn(name="USER_ID"),
	inverseJoinColumns=@JoinColumn(name="ROLE_ID"))
	private Collection<Role> roles;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
