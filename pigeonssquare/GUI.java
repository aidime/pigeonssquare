import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import java.util.TimerTask;
//import java.util.Timer;

//import java.awt.Image;
//import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame implements MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;
	final static int nbPigeon = 10;
	//private Window window = new Window();
	private PlayZone playzone = new PlayZone();
	static Pigeon[] tabPigeon = new Pigeon[nbPigeon];
	static Objets objects;
	
	public static double firecrackersSpawnRate = Math.random();
	
	
	
	int MouseX;
	int MouseY;
	
	//Verrous pour la nourriture
	static Object lockFresh = new Object();
	static Object lockNF = new Object();

	public GUI() {
        initUI();
    }

    private void initUI() {		
		objects = new Objets();
		
		//window.setBackground(Color.GREEN);
		playzone.setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());        
        setTitle("Pigeons Square");
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		//add("Center", window);
        add("Center", playzone);
		setResizable(false);
		setVisible(true);
		
		playzone.addMouseListener(this);
        addMouseListener(this);
        
		
		//window.addMouseListener(this);
    }

    public static void main(String[] args) {
    	new GUI();
		
		// Creation et lancements des threads pigeons 
		for(int i=0; i < nbPigeon/3; i++) {
			tabPigeon[i] = new Biset(objects);
		}
		for(int i=nbPigeon/3; i < 2*nbPigeon/3; i++) {
			tabPigeon[i] = new Colombin(objects);
		}
		for(int i=2*nbPigeon/3 ; i < nbPigeon; i++) {
			tabPigeon[i] = new Ramier(objects);
		}
		
		for(Pigeon p : tabPigeon) {
			p.start();
		}
		
		/*TimerTask task = new TimerTask() {
		      @Override
		      public void run() {
		  		while(true) {
		  			double isSpawning = Math.random();
		  			
		  			if(isSpawning < firecrackersSpawnRate) {
		  				Firecracker fc = new Firecracker((int) Math.random()*1000, (int) Math.random()*1000, objects);
		  				
		  				objects.firecrackers.add(fc);
		  				
		  				synchronized(Pigeon.objectLock) {
		  					Pigeon.objectLock.notifyAll();
		  				}
		  			}
		  			
		  		}
		  	}
		};
		
		Timer t = new Timer();
		
		long delay = 0;
		long intervalPeriod = 1000;
		
		t.scheduleAtFixedRate(task,delay,intervalPeriod);*/
    }
	
    
	private class PlayZone extends JPanel {
			
			private static final long serialVersionUID = 1L;
			
			// Fonction principale de dessin
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				
				for(Pigeon p : tabPigeon) {
					g.setColor(Color.blue);
					g.drawOval(p.getX(), p.getY(), 10, 10);
				}
				
				//Concurrence
				synchronized(lockFresh){
					for(Objet n : objects.freshFood) {
						g.setColor(Color.green);
						g.drawOval(n.getX(), n.getY(), 10, 10);
					}
				}
				synchronized(lockNF) {
					for(Objet np : objects.notFresh) {
						g.setColor(Color.black);
						g.drawOval(np.getX(), np.getY(), 10, 10);
						}
					}
				
				for(Objet b: objects.firecrackers) {
					g.setColor(Color.red);
					g.drawOval(b.getX(), b.getY(), 10, 10);
				}
	
				repaint();
			}
			
		}

	@Override
	public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			MouseX = e.getX();
			MouseY = e.getY();
			System.out.println("Ics: "+MouseX+"\nIgrek :"+MouseY);
			
			Food food = new Food(MouseX,MouseY,objects);
			
			objects.freshFood.add(food);
			
			synchronized(Pigeon.objectLock) {
				Pigeon.objectLock.notifyAll();
			}
		}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}