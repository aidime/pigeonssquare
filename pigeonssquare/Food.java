import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Food extends Objet implements ActionListener {

	/* 
	   ------------------------
	   --------ATTRIBUTS-------
	   ------------------------
	*/
	
	/* �tat de la nourriture : si isFresh est vrai, elle est fraiche */
	public boolean _isFresh;
	// Timer avant que la nourriture ne pourrisse
	Timer t = new Timer(8000,this);


	/* 
	   ------------------------
	   ------CONSTRUCTORS------
	   ------------------------
	*/
	public Food(int posX, int posY, Objets objects) {
		
		o = objects;
		x = posX;
		y = posY;
		_isFresh = true;
		t.start();
	}
	
	
	/* 
	   ------------------------
	   ---------GETTERS--------
	   ------------------------
	*/
	public boolean getComestible() {
		return _isFresh;
	}
	


	/* 
	   ------------------------
	   ---------METHODS--------
	   ------------------------
	*/	
	// Eatting method
	public synchronized void eat() {
		synchronized(GUI.lockFresh) {
			o.remove(o.freshFood, this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Si la nourriture est encore dans la liste, elle n'est plus comestible
		try {
			if(o.freshFood.indexOf(this) != -1) {
				_isFresh= false;
				
				synchronized(GUI.lockFresh) {
					o.remove(o.freshFood, this);
				}
				synchronized(GUI.lockNF) {
					o.add(o.notFresh,this);
				}
			} 
			t.stop();
		} catch(Exception e) {
			
		}
	}
}
