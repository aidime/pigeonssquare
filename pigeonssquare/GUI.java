import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame{

	private static final long serialVersionUID = 1L;
	final static int nbPigeon = 10;
	private Window window = new Window();
	static Pigeon[] tabPigeon = new Pigeon[nbPigeon];
	static Objets objects;
	
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
		
		window.setBackground(Color.GREEN);
		
		setLayout(new BorderLayout());        
        setTitle("Pigeons Square");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		add("Center", window);
		setResizable(false);
		setVisible(true);
		
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
    }
	
	//Fen�tre d'affichage
	private class Window extends JPanel {
		
		private static final long serialVersionUID = 1L;
		Image pigeon = new ImageIcon("Icons/Pigeon.png").getImage();
		Image burger = new ImageIcon("Icons/Burger.png").getImage();
		Image burgerNoir = new ImageIcon("Icons/BurgerNoir.png").getImage();
		Image bombe = new ImageIcon("Icons/Bomb.png").getImage();
		
		// Fonction principale de dessin
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			
			for(Pigeon p : tabPigeon) {
				g.drawImage(pigeon,
						    (int) (p.getX()-(pigeon.getWidth(window)/2)),
						    (int) (p.getY()-(pigeon.getHeight(window)/2)),
						    this);
			}
			
			//Concurrence
			synchronized(lockFresh){
				for(Objet n : objects.freshFood) {
					g.drawImage(burger,
							    n.getX()-(burger.getWidth(window)/2),
							    n.getY()-(burger.getHeight(window)/2),
							    this);
				}
			}
			synchronized(lockNF) {
				for(Objet np : objects.notFresh) {
					g.drawImage(burgerNoir,
							    np.getX()-(burgerNoir.getWidth(window)/2),
							    np.getY()-(burgerNoir.getHeight(window)/2),
							    this);
					}
				}
			
			for(Objet b: objects.firecrackers) {
				g.drawImage(bombe,
						    b.getX()-(bombe.getWidth(window)/2),
						    b.getY()-(bombe.getHeight(window)/2),
						    this);
			}

			repaint();
		}
		
	}
}