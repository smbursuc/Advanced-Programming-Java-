package com.bursucserban.tema4;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.HashSet;

public class City {
	
	private List<Street> streets = new LinkedList<>();
	private Set<Intersection> intersections = new HashSet<>();
	private String name;
	
	public City(String name)
	{
		this.name=name;
	}
	
	public List<Street> getStreets()
	{
		return streets;
	}
	
	public Set<Intersection> getIntersections()
	{
		return intersections;
	}

	public void setStreets(List<Street> streets) {
		this.streets = streets;
	}

	public void setIntersections(Set<Intersection> intersections) {
		this.intersections = intersections;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addStreet(Street street)
	{
		streets.add(street);
	}
	
	public void addIntersection(Intersection intersection)
	{
		intersections.add(intersection);
	}
	
	public void displayStreetsAndIntersections()
	{
		System.out.println("Streets:\n");
    	for(Street street : streets)
    	{
    		System.out.println(street.getName() + " " + street.getLength());
    	}
    	System.out.println();
    	
    	System.out.println("Intersections:\n");
    	for(Intersection intersection : intersections)
    	{
    		System.out.println(intersection.getName());
    	}
    	System.out.println();
	}
	
	public void initializeLabExample()
	{
		Intersection[] intersections = IntStream.rangeClosed(0, 8)
   			 .mapToObj(i -> new Intersection("i" + i) )
   			 .toArray(Intersection[]::new);
		
		Street[] streets = IntStream.rangeClosed(0, 15)
	   			 .mapToObj(i -> new Street("s" + i,0) )
	   			 .toArray(Street[]::new);
		
		intersections[0].addAdjacentStreet(streets[0]);
		intersections[0].addAdjacentStreet(streets[1]);
		intersections[0].addAdjacentStreet(streets[2]);
		
		intersections[1].addAdjacentStreet(streets[2]);
		intersections[1].addAdjacentStreet(streets[3]);
		intersections[1].addAdjacentStreet(streets[4]);
		
		intersections[2].addAdjacentStreet(streets[1]);
		intersections[2].addAdjacentStreet(streets[3]);
		intersections[2].addAdjacentStreet(streets[5]);
		intersections[2].addAdjacentStreet(streets[8]);
		intersections[2].addAdjacentStreet(streets[9]);
		
		intersections[3].addAdjacentStreet(streets[0]);
		intersections[3].addAdjacentStreet(streets[7]);
		intersections[3].addAdjacentStreet(streets[8]);
		
		intersections[4].addAdjacentStreet(streets[6]);
		intersections[4].addAdjacentStreet(streets[7]);
		intersections[4].addAdjacentStreet(streets[11]);
		intersections[4].addAdjacentStreet(streets[12]);
		
		intersections[5].addAdjacentStreet(streets[4]);
		intersections[5].addAdjacentStreet(streets[5]);
		intersections[5].addAdjacentStreet(streets[6]);
		intersections[5].addAdjacentStreet(streets[13]);
		
		intersections[6].addAdjacentStreet(streets[12]);
		intersections[6].addAdjacentStreet(streets[13]);
		intersections[6].addAdjacentStreet(streets[14]);
		intersections[6].addAdjacentStreet(streets[15]);
		
		intersections[7].addAdjacentStreet(streets[9]);
		intersections[7].addAdjacentStreet(streets[10]);
		intersections[7].addAdjacentStreet(streets[15]);
		
		intersections[8].addAdjacentStreet(streets[10]);
		intersections[8].addAdjacentStreet(streets[11]);
		intersections[8].addAdjacentStreet(streets[14]);
		
		
		for(int i=0;i<streets.length;i++)
		{
			if(i==3 || i==9 || i==11 || i==10 || i==14 || i==15 || i==6)
			{
				streets[i].setLength(1);
			}
			else if(i==0 || i==1 || i==2 || i==8 || i==5 || i==12)
			{
				streets[i].setLength(2);
			}
			else
				streets[i].setLength(3);
		}
		
		for(Street street : streets)
		{
			this.streets.add(street);
		}
		
		for(Intersection intersection : intersections)
		{
			this.intersections.add(intersection);
		}
		
		
	}
	
	public void showStreetIntersections()
	{
		for(Street  street : streets)
		{
			System.out.print(street.getName() + ": ");
			for(int i=0;i<street.getAdjacentIntersections().size();i++)
			{
				System.out.print(street.getAdjacentIntersections().get(i).getName() + " ");
			}
			System.out.println();
		}
	}
	
	
	public static boolean equalSets(ArrayList<Intersection> i1, Set<Intersection> i2)
	{
		return i1.containsAll(i2) && i2.containsAll(i1);
	}
	
	public void findMST()
	{
		ArrayList<Intersection> visited = new ArrayList<>();
		ArrayList<Intersection> notVisited = new ArrayList<>();
		ArrayList<Street> MST = new ArrayList<>();
		
		for(Intersection intersection : intersections)
		{
			notVisited.add(intersection);
		}
		
		List<Intersection> intersectionsList = new ArrayList<>(intersections);
		
		
		streets.sort((Street s1, Street s2) -> s1.getLength() < s2.getLength() ? 
    			-1 : s2.getLength()<s1.getLength() ? 1 : 0);
		
		visited.add(intersectionsList.get(0));
		notVisited.remove(intersectionsList.get(0));
		
		//U visited
		//V-U not visited
		//V vertices
		while(!equalSets(visited,intersections))
		{
			//let (u, v) be the lowest cost edge such that u ∈ U and v ∈ V - U;
			Street lowestCost = null;
			int minimum = 9999;
			
			boolean uv = true;
			
			for(Street street : streets)
			{
				Intersection u = street.getAdjacentIntersections().get(0);
				Intersection v = street.getAdjacentIntersections().get(1);
				if(street.getLength()<minimum && visited.contains(u) && notVisited.contains(v))
				{
					uv = true;
					lowestCost = street;
					minimum = street.getLength();
				}
				else if(street.getLength()<minimum && visited.contains(v) && notVisited.contains(u))
				{
					lowestCost = street;
					uv = false;
					minimum = street.getLength();
				}
			}
			
			MST.add(lowestCost);
			if(uv)
			{
				visited.add(lowestCost.getAdjacentIntersections().get(1));
				notVisited.remove(lowestCost.getAdjacentIntersections().get(1));
			}
			else
			{
				visited.add(lowestCost.getAdjacentIntersections().get(0));
				notVisited.remove(lowestCost.getAdjacentIntersections().get(0));
			}
		
		
		}
		
		System.out.println("MST of the given city is:\n");
		for(Street street : MST)
		{
			System.out.println(street.getName());
		}
	}
	
	
	
	
	

}
