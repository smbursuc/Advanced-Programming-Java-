
public class Main {

	public static void main(String[] args) {
		
		Event C1 = new Event(100,8,10,"C1");
		Event C2 = new Event(100,10,12,"C2");
		Event L1 = new Event(30,8,10,"L1");
		Event L2 = new Event(30,8,10,"L2");
		Event L3 = new Event(30,10,12,"L3");
		
		Room r1 = new Room("401",30,RoomType.lab);
		Room r2 = new Room("403",30,RoomType.lab);
		Room r3 = new Room("405",30,RoomType.lab);
		Room r4 = new Room("309",100,RoomType.lecture_hall);
		
		System.out.println(C1);
		System.out.println(C2);
		System.out.println(L1);
		System.out.println(L2);
		System.out.println(L3);
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
		

	}

}
