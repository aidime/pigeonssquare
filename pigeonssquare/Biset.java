public class Biset extends Pigeon {

	
	/* 
	   ------------------------
	   -------CONSTRUCTOR------
	   ------------------------
	*/
	public Biset(int posX, int posY, int speed) {
		super(posX, posY, 3);
	}
	
	public Biset(Objets o) {
		super(o);
		_speed = 3;
	}

}
