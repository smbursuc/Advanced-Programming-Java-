package com.bursucserban.lab3Compulsory;
import java.util.List;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.*;

public class App 
{
    public static void main( String[] args )
    {
    	Intersection[] intersections = IntStream.rangeClosed(0, 14)
    			 .mapToObj(i -> new Intersection("v" + i) )
    			 .toArray(Intersection[]::new);
    	
    	
    	Street[] streets = IntStream.rangeClosed(0, 8)
   			 .mapToObj(i -> new Street("nume",0) )
   			 .toArray(Street[]::new);
    	
    	List<Street> streetList = new LinkedList<>();
    	
    	for(int i=0;i<streets.length;i++)
    	{
    		streetList.add(streets[i]);
    	}
    	
    	streetList.sort((Street s1, Street s2) -> s1.getLength() < s2.getLength() ? 
    			1 : s2.getLength()<s1.getLength() ? -1 : 0);
    	
    	Set<Intersection> intersectionHashSet = new HashSet<>();
    	
    	for(int i=0;i<intersections.length;i++)
    	{
    		intersectionHashSet.add(intersections[i]);
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}
