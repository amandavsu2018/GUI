package application;

import java.util.ArrayList;

public interface ITeleporter {

	ArrayList<ITeleporter> tel = new ArrayList<>();
	
	public abstract String teleport(String dest);

}
