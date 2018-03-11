

public abstract class Pigeon extends Thread {

	/* 
	   ------------------------
	   --------ATTRIBUTS-------
	   ------------------------
	*/

	//position du pigeon dans la grille de jeu
	private int _posX;
	private int _posY;
	//vitesse du pigeon
	protected int _speed;
	
	public Objets objects;

	public static Object objectLock = new Object();


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
	
	public Pigeon(Objets objects){
		_posX = (int) (Math.random()*500);
		_posY = (int) (Math.random()*500);
		this.objects = objects;
	}


	/* 
	   ------------------------
	   ---------GETTERS--------
	   ------------------------
	*/

	public int getX() {
		return _posX;
	}

	public int getY() {
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
	
	private Food findClosestFood() {
		//TODO finds the position of the closest food
		Food f = (Food) objects.freshFood.get(0);
		double min = objects.distanceObjet(this, f);
		
		for(Objet comestible : objects.freshFood) {
			if(objects.distanceObjet(this, comestible) < min ) {
				f = (Food) comestible;
				min = (objects.distanceObjet(this, comestible));
			}
		}
		
		return f;
	}
	/*
	private void eatFood() {
		//TODO eats the food on his position if there is any
	}
	*/
	
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
			Food f = null;
			
			try {				
				// Tant qu'il reste des pétards
				while(!(objects.firecrackers.isEmpty())) {
					//les pigeons sont effrayés
					moveAfraid();
				}
				
				//S'il y a de la nourriture sur le terrain,
				//on calcule la nourriture la plus proche (min) ...
				if(!(objects.freshFood.isEmpty())) {
					f = findClosestFood();
	
					//Si la nourriture est à proximité la manger
					if (objects.distanceObjet(this, f) < 20) {
						f.eat();
					}
					//Sinon s'approcher
					else {
						moveTowardsPos(f.getX(), f.getY());
					}
	
				}
				
				//Sinon ne rien faire
				else {
					synchronized(objectLock) {
						try {
							objectLock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			} catch(Exception e) {
				
			}
		}
	}
}
