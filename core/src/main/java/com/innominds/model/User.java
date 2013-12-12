package com.innominds.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity()
@Table ( name = "user" , uniqueConstraints = {@UniqueConstraint(columnNames={"UserID"})})
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String userID;
	private String userName;
	private String firstName;
	private String lastName;
	private Date dob;
	private String designation;
	private String password ;
	private String salt;
	
	/*private Address address;
	private Role role;*/
	
	// Setter and Getters
	public void setUserID ( String uid )
	{
		this.userID = uid;
	}
	
	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO)
	@Column ( name = "UserID" , unique = true , nullable = false)	
	
	public String getUserID  ( )
	{
		return this.userID;
		
	}
	
	public void setUserName ( String username )
	{
		this.userName = username;
	}
	
	@Column ( name = "UserName" , unique = true , nullable = false)
	public String getUserName ( )
	{
		return this.userName;
	}
	
	public void setFirstName ( String firstname )
	{
		this.firstName = firstname;
	}
	@Column ( name = "FirstName" , unique = false , nullable = true)
	public String getFirstName ( )
	{
		return this.firstName;
	}
	
	public void setLastName ( String lastname )
	{
		this.lastName = lastname;
	}
	
	@Column ( name = "LastName" , unique = false , nullable = true)
	public String getLastName ( )
	{
		return this.lastName;
	}
	
	public void setDesignation ( String designation )
	{
		this.designation = designation;
	}
	@Column ( name = "Designation" , unique = false , nullable = true)
	public String getDesignation ( )
	{
		return this.designation ;
	}
	
	public void setPassword ( String password )
	{
		this.password = password;
	}
	
	@Column ( name = "Password" , unique = false , nullable = false)
	public String getPassword ( )
	{
		return this.password;
	}
	
	public void setDob ( Date dob)
	{
		this.dob = dob;
	}
	@Column ( name = "DOB" , unique = false , nullable = true)
	public Date getDob ( )
	{
		return this.dob;
	}
	
	public void setSalt ( String salt )
	{
		this.salt = salt;
	}
	
	@Column ( name = "Salt" , unique = false , nullable = true)
	public String getSalt ( )
	{
		return this.salt;
	}
	
	/*public void setAddress ( Address address )
	{
		this.address = address;
	}
	
	
	public Address getAddress ( )
	{
		return this.address;
	}
	
	
	public void setRole ( Role role)
	{
		this.role = role;
	}
	
	
	public Role getRole ( )
	{
		return this.role;
	}*/
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public String toString ( ) 
	{
		return "Firstname " + this.firstName ;
	}

}
