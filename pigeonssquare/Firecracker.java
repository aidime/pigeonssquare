import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Firecracker extends Objet implements ActionListener {
	
	Timer t = new Timer(3000,this);
	
	public Firecracker(int coordX, int coordY, Objets objects) {		
		x = coordX;
		y = coordY;
		o = objects;
		t.start();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {		
		o.remove(o.firecrackers, this);
		t.stop();
	}
	
}