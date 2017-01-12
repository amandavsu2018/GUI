package application;

import java.util.ArrayList;
import java.util.Collections;

public class MartianManager implements Cloneable {

	ArrayList<Martian> martians = new ArrayList<>();
	ArrayList<ITeleporter> teleporters = new ArrayList<>();
	
	public MartianManager() {
	}
	
	public boolean addMartian(Martian m){
		boolean result = false;
		if(!martians.contains(m)){
			martians.add(m);
			result = true;
			
			if(m instanceof GreenMartian){
			ITeleporter m2 = (GreenMartian) m;
			teleporters.add(m2);
			result = true;
		}
		}	
		else{
			result = false;
		}
	return result;
	}
	
	public Object clone() throws CloneNotSupportedException {
		MartianManager clonedMM = new MartianManager();
		for(Martian m : martians){
			clonedMM.addMartian( (Martian)m.clone());
		}
	return clonedMM;
	}

	
	public Martian getMartianClosestToId(int id){
		Martian temp = new GreenMartian(id);
		int diff = Integer.MAX_VALUE;
		for(Martian m : martians){
			if(diff > (Math.abs(id - m.getId()))){
				temp = m;
				diff = (Math.abs(id - m.getId()));
			}
		}
		return temp;
	}
		
	public String groupSpeak(){
		String s7 = "";
		for(Martian m : martians){
			s7 += m.speak() + "\n";
		}
	return s7;
	}

	public String groupTeleport(String dest){
		String s8 = "";
		for(Martian m : martians){
			if(m instanceof GreenMartian){
			s8 += m + " is traveling to " + dest + "\n";
			}
		}	
	return s8;
	}
	
	public void obliterateTeleporters(){
		teleporters.clear();
		for(int i = martians.size()-1; i >= 0; i--){
			if(martians.get(i) instanceof GreenMartian){
				martians.remove(i);
			}
		}
		System.out.println(martians);
	}
	
	public boolean removeMartian(int id){
		boolean result = false;
		Martian test = new GreenMartian(id);
		int index = martians.indexOf(test);
		Martian found = martians.get(index);
		martians.remove(found);
		if(found instanceof GreenMartian){
			teleporters.remove(found);
			result = true;
		}
		return result;
	}

	public ArrayList<Martian> sortedMartians() throws CloneNotSupportedException{
		ArrayList<Martian> clonedMartians2 = new ArrayList<Martian>();
		for(Martian m : martians){
			clonedMartians2.add( (Martian)m.clone());
		}
		Collections.sort(clonedMartians2);
		return clonedMartians2;
	}

	public String toString(){
		String s = "";
		for(Martian m : martians){
			s += m.toString();
		}
		return s;
	}

	public void clearMartians(){
		martians.clear();
		teleporters.clear();
		System.out.println(martians);
		System.out.println(teleporters);
	}

	public Martian getMartian(int id){
		System.out.println(martians.get(id));
		return martians.get(id);
	}
}
