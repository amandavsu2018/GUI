package application;

public abstract class Martian implements Comparable<Martian>,Cloneable {
	
	private int id;
	private int volume;
	
	public Martian(int id){
		this.id = id;
		volume = 1;
	}
	
	public Object clone() throws CloneNotSupportedException{ 
		return super.clone();
	}

	public int compareTo(Martian m){ 
		double diff = this.id - m.getId();
		
		if(diff < 0){
			return -1;
		}
		else if(diff > 0){
			return 1;
		}
		else{
			return 0;
		}
		
	}
	
	public boolean equals(Object o){
		Martian x = (Martian) o ;
		if(x.getId() == this.id){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int getId(){
		return id;
	}

	public int getVolume(){
		return volume;
	}

	public void setVolume(int level){
		volume = level;
	}

	public abstract String speak();
	
	public String toString(){
		String s = "";
		s += "id=" + id + ", vol=" + volume;
	return s;
	}
}
