package com.bursucserban.tema4;
import java.util.List;
import java.util.ArrayList;

public class Intersection {
	
	private String name;
	private List<Street> adjacentStreets = new ArrayList<>();

	public Intersection(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Street> getAdjacentStreets() {
		return adjacentStreets;
	}
	
	public void addAdjacentStreet(Street street)
	{
		adjacentStreets.add(street);
		street.addAdjacentIntersection(this);
	}
	
	
	
	

}