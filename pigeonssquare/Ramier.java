
public class Ramier extends Pigeon {

	
	/* 
	   ------------------------
	   -------CONSTRUCTOR------
	   ------------------------
	*/
	public Ramier(int posX, int posY, int speed) {
		super(posX, posY, 1);
	}
	
	public Ramier(Objets o) {
		super(o);
		_speed = 1;
	}
}
