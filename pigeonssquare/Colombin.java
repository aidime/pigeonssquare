public class Colombin extends Pigeon {

	
	/* 
	   ------------------------
	   -------CONSTRUCTOR------
	   ------------------------
	*/
	public Colombin(int posX, int posY, int speed) {
		super(posX, posY, 2);
	}
	
	public Colombin(Objets o) {
		super(o);
		_speed = 2;
	}
}
