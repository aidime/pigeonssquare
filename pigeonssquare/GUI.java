//import java.util.LinkedList;
//import java.util.Map;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//private static Map<Food, LinkedList<Integer>> _food;

	public GUI() {

        initUI();
    }

    private void initUI() {
        
        setTitle("Pigeons Square");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            GUI ex = new GUI();
            ex.setVisible(true);
        });
    }
    
    public static void addFood(Food food) {
    	//TODO
    	
    	
    	//pos must be the position of the pointer on the JFrame    	
    	//_food.put(food,pos);
    }
}