package com.innominds.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import java.util.Date;

@Entity
@Table ( name = "useraddress")
public class Address implements Serializable {


	private String userAddressID ;
	private String address1;
	private String address2;
	private String phone; 
		
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	// Setters and Getters
	
	public void setUserAddressID ( String id )
	{
		this.userAddressID = id;
	}
	
	public String getUserAddressID ( )
	{
		return this.userAddressID;
	}
	
	public void setAddress1 ( String address )
	{
		this.address1 = address;
	}
	
	public String getAddress1 ( )
	{
		return this.address1;
	}
	
	public void setAddress2 ( String address )
	{
		this.address2 = address;
	}
	
	public String getAddress2 ( )
	{
		return this.address2;
	}
	
	public void setPhone ( String phone)
	{
		this.phone = phone;
	}
	
	public String getPhone ( )
	{
		return this.phone;
	}
	public String toString ( )
	{
		return " Address is " + this.address1 + "  " +  this.address2 + " Phone " + this.phone ;
	}

}
