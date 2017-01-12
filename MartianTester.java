package application;

public class MartianTester {

	public static void main(String[] args) throws CloneNotSupportedException {

		// Test 0 – Create MartianManager and create some red and green martians
		// to be used in tests that follow.
		
		MartianManager mm = new MartianManager();
		
		String dest = "Mars";
		
		Martian m1 = new RedMartian(100);
		Martian m2 = new RedMartian(150);
		RedMartian m3 = new RedMartian(200);
		Martian m4 = new GreenMartian(300);
		Martian m5 = new GreenMartian(350);
		GreenMartian m6 = new GreenMartian(200);
		Martian m7 = new GreenMartian(250);
		Martian m8 = new RedMartian(400);
		Martian m9 = new GreenMartian(250);
		Martian m10 = new RedMartian(600);
		
		
		mm.addMartian(m1);
		mm.addMartian(m2);
		mm.addMartian(m3);
		mm.addMartian(m4);
		mm.addMartian(m5);
		mm.addMartian(m6);

		// Test 1 - Martian.toString()
		
		System.out.println("Martians: ");
		System.out.println("m1: " + m1.toString());
		System.out.println("m2: " + m2.toString());
		System.out.println("m3: " + m3.toString());
		System.out.println("m4: " + m4.toString());
		System.out.println("m5: " + m5.toString());
		System.out.println("m6: " + m6.toString() + "\n");
		
		
		System.out.println("Set m2 Volume to 2: ");
		m2.setVolume(2);
		System.out.println("m2: " + m2.toString());
		System.out.println("Set m4 Volume to 3: ");
		m4.setVolume(3);
		System.out.println("m4: " + m4.toString() + "\n");
		
		
		// Test 2 - Martian.equals()
		
		System.out.println("Are they equal?");
		System.out.println("m1 and m1 = " + m1.equals(m1));
		System.out.println("m3 and m2 = " + m3.equals(m2));
		System.out.println("m3 and m3 = " + m3.equals(m3));
		System.out.println("m5 and m4 = " + m5.equals(m4));
		System.out.println("m6 and m5 = " + m6.equals(m5));
		System.out.println("m1 and m6 = " + m1.equals(m6) + "\n");

		
		// Test 3 - Martian.compareTo()
		
		System.out.println("Comparisons: ");
		System.out.println("m1 and m1 = " + m1.compareTo(m1));
		System.out.println("m1 and m2 = " + m1.compareTo(m2));
		System.out.println("m3 and m1 = " + m3.compareTo(m1));
		System.out.println("m2 and m6 = " + m2.compareTo(m6));
		System.out.println("m5 and m5 = " + m5.compareTo(m5));
		System.out.println("m4 and m3 = " + m4.compareTo(m3) + "\n");

		// Test 4 - Martian.clone()
		
		System.out.println("Cloned Martians: ");
		System.out.println("m1 clone = " + m1.clone());
		System.out.println("m3 clone = " + m3.clone());
		System.out.println("m5 clone = " + m5.clone());
		System.out.println("m6 clone = " + m6.clone() + "\n");
		
		// Test 5 - MartianManager.addMartian()
		
		System.out.println("Adding Martians - Was it successful?");
		System.out.println("Add m7 = " + mm.addMartian(m7));
		System.out.println("Add m8 = " + mm.addMartian(m8));
		System.out.println("Add m9 = " + mm.addMartian(m9) + "\n");
		
		// Test 6 - MartianManager.groupSpeak()
		
		System.out.println("Group Speaking: ");
		System.out.println(mm.groupSpeak());
		
		// Test 7 - MartianManager.groupTeleport()
		
		System.out.println("Group teleporting to destination: ");
		System.out.println(mm.groupTeleport(dest) + "\n");
		
		// Test 8 - MartianManager.getMartianClosestToID()
		
		System.out.println("Martian closest to id: ");
		System.out.println("Martian closest to id 152 " + mm.getMartianClosestToId(152));
		System.out.println("Martian closest to id 255 " + mm.getMartianClosestToId(255));
		System.out.println("Martian closest to id 300 " + mm.getMartianClosestToId(300) + "\n");
		
		// Test 9 - MartianManager.removeMartian()
		
		System.out.println("Removing Martians - Was it successful?");
		System.out.println(mm.removeMartian(100));
		System.out.println(mm.removeMartian(250));
		System.out.println(mm.removeMartian(300));
		System.out.println(mm.removeMartian(200) + "\n");
				
		// Test 10 - MartianManager.sortedMartians()
		
		System.out.println("Sorted Martians: ");
		System.out.println(mm.sortedMartians() + "\n");
		
		// Test 11 - MartianManager.obliterateTeleporters()
		
		System.out.println("Martians in martians array after obliteration: ");
		mm.obliterateTeleporters();
		System.out.println("\n");
		
		// Test 12 - MartianManager.clone()
		
		System.out.println("Cloned Martian: ");
		Martian m1Clone = (Martian)m10.clone();
		
		System.out.println("Set Volume of Clone to 5");
		m1Clone.setVolume(5);
		System.out.println("Original " + m1);
		System.out.println("Clone " + m1Clone + "\n");
		
		MartianManager mmClone = (MartianManager) mm.clone();
		mmClone.addMartian(m1Clone);
		System.out.println("Cloned Martian Manager class: ");
		System.out.println("Clone: " + mmClone.toString());
		System.out.println("Original: " + mm.toString());
		
		
		mm.clearMartians();
		//mm.getMartian(id);
	}

}
