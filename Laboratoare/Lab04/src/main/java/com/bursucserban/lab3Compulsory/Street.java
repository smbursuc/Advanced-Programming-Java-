package com.bursucserban.lab3Compulsory;
import java.util.ArrayList;

public class Street {

	private String name;
	private int length;
	private ArrayList<Intersection> adjacentIntersections = new ArrayList<>();
	
	public Street(String name, int length) {
		super();
		this.name = name;
		this.length = length;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

	public ArrayList<Intersection> getAdjacentIntersections() {
		return adjacentIntersections;
	}

	public void addAdjacentIntersection(Intersection intersection) {
		adjacentIntersections.add(intersection);
	}
	
	
	
	
	
}
