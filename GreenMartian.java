package application;

public class GreenMartian extends Martian implements ITeleporter{
	
	public GreenMartian(int id){
		super(id);
	}
	
	public String speak(){
		String s4 = "";
		s4 = "id=" + getId() + " Gobldy Grock" ; 
	return s4;
	}

	public String teleport(String dest){
		String s5 = "";
		s5 += "id=" + getId() + " teleporting to " + dest;
	return s5;
}

	@Override
	public String toString(){
		String s6 = "";
		s6 += "Green martian – id=" + getId() + ", vol=" + getVolume() + " / ";
	return s6;
	}

}
