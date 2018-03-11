public class Biset extends Pigeon {

	
	/* 
	   ------------------------
	   -------CONSTRUCTOR------
	   ------------------------
	*/
	public Biset(int posX, int posY, int speed) {
		super(posX, posY, 8);
	}
	
	public Biset(Objets o) {
		super(o);
		_speed = 8;
	}

}
