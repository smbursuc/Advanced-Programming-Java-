
public class Main {

	public static void main(String[] args) {
		
		Event C1 = new Event(100,8,10,"C1");
		Event C2 = new Event(100,10,12,"C2");
		Event L1 = new Event(30,8,10,"L1");
		Event L2 = new Event(30,8,10,"L2");
		Event L3 = new Event(30,10,12,"L3");
		
		ComputerLab cl1 = new ComputerLab("401", 30, OperatingSystem.Windows_10);
		ComputerLab cl2 = new ComputerLab("403", 30, OperatingSystem.Windows_7);
		ComputerLab cl3 = new ComputerLab("405", 30, OperatingSystem.Windows_10);
		LectureHall lh4 = new LectureHall("309", 100, true);
		
		
		/*
		 * Clasa care stocheaza o problema de tip room assignment. Contine evenimentele si camerele.
		 * */
		RoomAssignment problem1 = new RoomAssignment(); //clasa care stocheaza o problema de tip room assignment
		
		problem1.add(C1);
		problem1.add(C2);
		problem1.add(L1);
		problem1.add(L2);
		problem1.add(L3);
		problem1.add(cl1);
		problem1.add(cl2);
		problem1.add(cl3);
		problem1.add(lh4);
		
		/*
		 * Clasa care stocheaza instante ale problemei room assignment si le rezolva.
		 * */
		RoomAssignmentSolver s1 = new RoomAssignmentSolver(); //clasa care stocheaza instante ale problemei room assignment si le rezolva
		s1.addProblem(problem1);
		s1.solve();

	}

}
