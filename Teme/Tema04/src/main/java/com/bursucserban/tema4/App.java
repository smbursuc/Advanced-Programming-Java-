package com.bursucserban.tema4;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.*;
import com.github.javafaker.Faker;
import java.util.Random;

public class App 
{
	
    public static void main( String[] args )
    {
    	
    	Faker faker = new Faker();
    	Random random = new Random();
    	
    	Intersection[] intersections = IntStream.rangeClosed(0, 8)
    			 .mapToObj(i -> new Intersection(faker.name().name()) )
    			 .toArray(Intersection[]::new);
    	
    	
    	Street[] streets = IntStream.rangeClosed(0, 14)
   			 .mapToObj(i -> new Street(faker.address().streetAddress(),1+random.nextInt(3)) )
   			 .toArray(Street[]::new);
    	
    	List<Street> streetList = new LinkedList<>();
    	
    	for(int i=0;i<streets.length;i++)
    	{
    		streetList.add(streets[i]);
    	}
    	
    	streetList.sort((Street s1, Street s2) -> s1.getLength() < s2.getLength() ? 
    			-1 : s2.getLength()<s1.getLength() ? 1 : 0);
    	
    	Set<Intersection> intersectionHashSet = new HashSet<>();
    	
    	for(int i=0;i<intersections.length;i++)
    	{
    		intersectionHashSet.add(intersections[i]);
    	}
    	
    	City c1 = new City("New York");
    	c1.initializeLabExample();
    	
    	List<Street> wantedStreets = new ArrayList<>(); //list made to avoid duplicates
    	
    	c1.getStreets().stream()
    	.filter(s -> s.getLength()==3)
    	.forEach(s -> s.getAdjacentIntersections().stream()
    	.filter(i -> i.getAdjacentStreets().size()==4)
    	.forEach(str -> {if(!wantedStreets.contains(s)) wantedStreets.add(s);}));
    	
    	//.forEach(str -> System.out.println(s.getName()))); has duplicates
    	
    	System.out.println("The result from the Stream Query is:\n");
    	for(Street street : wantedStreets)
    	{
    		System.out.println(street.getName());
    	}
    	System.out.println();
    	
    	c1.findMST();
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}