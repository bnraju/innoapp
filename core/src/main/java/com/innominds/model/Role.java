package com.innominds.model;

import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table ( name = "role")
public class Role implements Serializable  {

	String id;
	String name;
	String description;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	// Setters and Getters
	public void setId ( String id)
	{
		this.id = id;
	}
	
	public String getId ( )
	{
		return this.id;
	}
	
	public void setName ( String name)
	{
		this.name = name;
	}
	
	public String getName ( )
	{
		return this.name;
	}
	
	public void setDescription ( String description )
	{
		this.description = description;
	}
	
	public String getDescription ( )
	{
		return this.description;
	}
	
	public String toString ( )
	{
		return "Role name is " + this.name ;
	}
}
