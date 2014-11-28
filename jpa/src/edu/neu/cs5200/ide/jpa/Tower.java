package edu.neu.cs5200.ide.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity

public class Tower {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String name;
	private double height;
	private int sides;
	private Site siteId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getSides() {
		return sides;
	}
	public void setSides(int sides) {
		this.sides = sides;
	}
	
	// creates a foreign key in Tower Table
	@ManyToOne()
    @JoinColumn(name="siteId")
	public Site getSiteId() {
		return siteId;
	}
	public void setSiteId(Site siteId) {
		this.siteId = siteId;
	}
	
	public Tower() {
		super();
	}
	
	public Tower(int id, String name, double height, int sides, Site siteId) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.sides = sides;
		this.siteId = siteId;
	}
	public Tower(String name, double height, int sides, Site siteId) {
		super();
		this.name = name;
		this.height = height;
		this.sides = sides;
		this.siteId = siteId;
	}	

}
