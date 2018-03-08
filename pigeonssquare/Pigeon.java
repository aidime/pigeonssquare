

public abstract class Pigeon {

	/* 
	   ------------------------
	   --------ATTRIBUTS-------
	   ------------------------
	*/

	//position du pigeon dans la grille de jeu
	private int _posX;
	private int _posY;
	//vitesse du pigeon
	private int _speed;


	/* 
	   ------------------------
	   ------CONSTRUCTORS------
	   ------------------------
	*/

	public Pigeon(int posX, int posY, int speed) {
		_posX = posX;
		_posY = posY;
		_speed = speed;
	}


	/* 
	   ------------------------
	   ---------GETTERS--------
	   ------------------------
	*/

	public int getPosX() {
		return _posX;
	}

	public int getPosY() {
		return _posY;
	}

	public int getSpeed() {
		return _speed;
	}

	/* 
	   ------------------------
	   ---------METHODS--------
	   ------------------------
	*/
	
	private int[] findClosestFood() {
		//TODO finds the position of the closest food
		int [] res = new int[2];
		return res;
	}
	
	private void eatFood() {
		//TODO eats the food on his position if there is any
	}
	
	private void moveTowardsPos(int posX, int posY) {
		//TODO moves towards the point that has posX,posY as coordinates
	}
}
