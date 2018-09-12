package castanedakaren;

import processing.core.PApplet;

public class Main extends PApplet{

	//atributos
	private Logica log;
	private int pantalla;
	
	public static void main(String[] args) {
		PApplet.main("castanedakaren.Main");
		
	}
	
	//metodos
	public void settings() {
		size(800, 500);
	}
	
	public void setup() {
		log = new Logica(this);
	}
	
	public void draw() {
		
	}
	
	public void mousePressed() {
		
	}

	public void mouseClicked() {
		
	}
	public void keyPressed() {
		
	}
}