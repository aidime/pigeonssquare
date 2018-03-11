import java.util.ArrayList;

public class Objets {

	// freshFood    : nourritures
	// notFresh     : nourritures pourries 
	// firecrackers : pétards
	ArrayList<Objet> freshFood, notFresh, firecrackers;
	
	public Objets() {		
		freshFood    = new ArrayList<Objet>();
		notFresh     = new ArrayList<Objet>();
		firecrackers = new ArrayList<Objet>();

	}

	public void add(ArrayList<Objet> al, Objet n) {		
		al.add(n);
	}
	
	public void remove(ArrayList<Objet> al, Objet n) {
		al.remove(n);
	}
	
	//Distance entre un pigeon et un objet
	public double distanceObjet(Pigeon p1, Objet n2) {		
		return Math.sqrt((Math.pow(n2.getX()-p1.getX(), 2)) + (Math.pow(n2.getY()-p1.getY(), 2)));
	}
}