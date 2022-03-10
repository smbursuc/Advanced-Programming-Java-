import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class RoomAssignmentSolver {

	/*
	 * Vector in care sunt stocate toate problemele.
	 * */
	private ArrayList<RoomAssignment> RAproblems;
	
	/*
	 * Lista de pair-uri: staga - numele salii, dreapta - ora la care se termina activitatea din ea. Foloseste clasa definita Pair.
	 * */
	private ArrayList<Pair<String,Integer>> occupiedUntil; //

	public RoomAssignmentSolver() {
		RAproblems = new ArrayList<>();
		occupiedUntil = new ArrayList<Pair<String,Integer>>();
	}

	public void addProblem(RoomAssignment ra) {
		RAproblems.add(ra);
	}
	
	
	/*
	 * Arata o lista in care in stanga se afla nr salii si in dreapta ora in care se termina activitatea prezenta in ea.
	 * */
	public void showOccupiedUntil() //
	{
		for(int i=0;i<occupiedUntil.size();i++)
		{
			System.out.println(occupiedUntil.get(i).getKey() + " " + occupiedUntil.get(i).getValue());
		}
		System.out.println("");
	}
	
	/**
	 * Rezolvarea este una de tip Greedy.
	 * Algoritmul functioneaza astfel:
	 * 
	 * - parcurgem toate instantele ale problemei stocate in clasa.
	 * - pentru fiecare problema sortam evenimentele in ordinea in care se termina (cele care se termina cel mai devreme vor fi primele in lista)
	 * - gasim camere candidate pentru evenimente (care nu au un eveniment cand in ele cand incepe evenimentul care itereaza)
	 * - dintre camerele candidate alegem o camera care incape cel mai bine pentru un eveniment (nu se vor pune evenimente de 30 in sala de 100)
	 * - afisam primul match gasit si reiteram
	 * */
	public void solve() {
		
		for (RoomAssignment ra : RAproblems)
		{
			Collections.sort(ra.getEvents(), new Comparator<Event>() { //sortare a evenimentelor dupa ora de terminare. lista va contine evenimentele in ordinea desfasurarii lor necesar pentru greedy.
				@Override
				public int compare(Event e1, Event e2) {
					return e1.getEnd() < e2.getEnd() ? -1 : (e2.getEnd() < e1.getEnd()) ? 1 : 0;
				}
			});
			
			for(Room r : ra.getRooms()) //initializarea listei sala-ora terminare. unde sala este libera se pune 0 (nu exista ora 0 ci ora 00)
			{
				Pair<String,Integer> pair = new Pair<String,Integer>(r.getName(),0);
				occupiedUntil.add(pair);
			}
			
			for(Event e : ra.getEvents()) //iterare a tuturor evenimentelor
			{	
				ArrayList<Integer> candidateRooms = new ArrayList<>(); //stocare a salilor candidat (indexul lor din arraylistul alocat camerelor). o sala este candidat daca este libera sau daca evenimentul din sala se termina la ora in care incepe evenimentul care itereaza
				for(int i=0;i<occupiedUntil.size();i++)
				{
					if(occupiedUntil.get(i).getValue()==0 || occupiedUntil.get(i).getValue()<=e.getStart())
					{
						candidateRooms.add(i);
					}
				}
				
				Collections.sort(candidateRooms, new Comparator<Integer>() { //sortare pentru a evita situatii de "overkill". un overkill se intampla atunci cand o sala este ocupata de un numar mult mai mic decat capacitatea ei maxima.
					//o sala este adecvata daca diferenta dintre capacitatea ei si sizeul evenimentului este apropriata de 0, adica se poate umple aproape la fix o sala cu un eveniment
					@Override
					public int compare(Integer i1, Integer i2) {
						return ra.getRooms().get(i1).getCapacity()-e.getSize() < ra.getRooms().get(i2).getCapacity()-e.getSize()
						? -1 : ra.getRooms().get(i1).getCapacity()-e.getSize() > ra.getRooms().get(i2).getCapacity()-e.getSize() ? 1 : 0;
					}
				});
				
				
				for(int i=0;i<candidateRooms.size();i++) //parcurgere camere candidat
				{
					if(ra.getRooms().get(candidateRooms.get(i)).getCapacity()-e.getSize()>=0) //trebuie verificat daca la diferenta de mai devreme da diferenta negativa. diferenta negativa inseamna ca sala nu are capacitatea de a incape un eveniment
					{
						System.out.println("Event " + e.getName() + " -> " + ra.getRooms().get(candidateRooms.get(i)).getName());
						occupiedUntil.get(candidateRooms.get(i)).setValue(e.getEnd());
						i=candidateRooms.size()+1; //odata gasit o sala pentru un eveniment iesim din for pentru a evita plasarea evenimentului in mai multe sali
					}
				}
				
				//showOccupiedUntil();
			}
			
		}
		
	}

}
