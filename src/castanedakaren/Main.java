package castanedakaren;

import processing.core.PApplet;

public class Main extends PApplet {

	// atributos
	private Logica log;//creo una nueva variable de tipo logica
	private int pantalla;
	
	//constructor Main
	public static void main(String[] args) {
		PApplet.main("castanedakaren.Main");
	}

	// metodos
	public void settings() {
		size(800, 500);
	}

	public void setup() {
		log = new Logica(this);//inicializo logica
	}

	public void draw() {
		background(0, 0, 100);
		log.pintar();
		log.hacerCambio();
	}

	public void mousePressed() {
		log.interaccionMouse(mouseX, mouseY);
	}

	public void mouseClicked() {
		log.validarClick();

	}

	public void keyPressed() {
		log.interaccionTeclado(LEFT, RIGHT);
	}
}