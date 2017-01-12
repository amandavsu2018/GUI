package application;

public class RedMartian extends Martian {

	public RedMartian(int id){
		super(id);
	}
	
	public String speak(){
		String s2 = "";
		s2 += "id=" + getId() + " Rudbly Rock";
	return s2;
	}

	@Override
	public String toString(){
		String s3 = "";
		s3 += "Red martian – id=" + getId() + ", vol=" +  getVolume() + " / ";
	return s3;
	}

}

