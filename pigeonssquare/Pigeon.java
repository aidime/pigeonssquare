

public abstract class Pigeon extends Thread{

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
		double xDist = posX - _posX;
		double yDist = posY - _posY;
		double dist = Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));
		double xVel = xDist * _speed / dist;
		double yVel = yDist * _speed / dist;

		if (_posX < posX && (_posX + xVel) > posX) {
			_posX = posX;
		} else if (_posX != posX) {
			_posX += xVel;
		}
		if (_posY < posY && (_posY + yVel) > posY) {
			_posY = posY;
		} else if (_posY != posY) {
			_posY += yVel;
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void moveAfraid() {
		int cpt = 0;
		_speed *= 2;
		int x =(int)(Math.random()*1200);
		int y = (int)(Math.random()*800);
		while(cpt < 70) {
			cpt++;
			moveTowardsPos(x,y);
			moveTowardsPos(x,y);
			moveTowardsPos((int)(Math.random()*1200),(int)(Math.random()*800));
		}
		_speed /= 2;
	}
	
	@Override
	
	public void run() {

		while(true) {

		}
	}
}
