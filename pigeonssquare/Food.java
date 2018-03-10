import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Food implements ActionListener {

	/* 
	   ------------------------
	   --------ATTRIBUTS-------
	   ------------------------
	*/
	
	/* position de la nourriture */
	public int _posX;
	public int _posY;
	/* État de la nourriture : si isFresh est vrai, elle est fraiche */
	public boolean isFresh;
	// Timer avant que la nourriture ne pourrisse
	Timer t = new Timer(8000,this);


	/* 
	   ------------------------
	   ------CONSTRUCTORS------
	   ------------------------
	*/
	public Food(int posX, int posY) {
		
		_posX = posX;
		_posY = posY;
		isFresh = true;
		t.start();
	}
	
	
	/* 
	   ------------------------
	   ---------GETTERS--------
	   ------------------------
	*/
	public boolean getComestible() {
		return isFresh;
	}
	


	/* 
	   ------------------------
	   ---------METHODS--------
	   ------------------------
	*/	
	// Eatting method
	public synchronized void eat(Food f, Pigeon p) {
		
	}
/*
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// Si la nourriture est encore dans la liste, elle n'est plus comestible
		if(lo.listN.indexOf(this) != -1) {
			comestible = false;
			
			// Gestion de la concurrence pour les collections de nourritures
			synchronized(Main.objectLockN) {
				lo.remove(lo.listN, this);
			}
			synchronized(Main.objectLockN) {
				lo.add(lo.listNP,this);
			}

		} 
		t.stop();



	}*/


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
