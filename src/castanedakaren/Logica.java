package castanedakaren;

import java.util.ArrayList;

import javafx.scene.effect.Light.Distant;
import processing.core.PFont;

public class Logica {

	// Atributos---------------------------------------------------------------------
	private Main app;
	private int pantalla;
	private int cont1, cont2; // contador interacciones
	private String[] texto; // variable para guardar el texto
	private String cambiado; // crear una copia y modificar alli
	private ArrayList<Figura1> figuras1;
	private ArrayList<Figura2> figuras2;
	private ArrayList<Figura3> figuras3;
	private ArrayList<Figura4> figuras4;
	private boolean siguiente; // para el boton de siguiente
	private boolean click; // me valida si se hizo click para cambiar de pantalla
	private boolean esta;// variable para que el cambio de la interaccion 3 se ejecute una sola vez
	private String[] tres;// interaccion 3
	private String[] cuatro; // interaccion 4
	private PFont source; // para poner tipografía

	// Constructor
	// Logica-------------------------------------------------------------------------
	public Logica(Main app) {

		this.app = app;
		app.colorMode(app.HSB, 360, 100, 100);
		esta = false;
		pantalla = 1; // inicializacion de la variable que controla los switch
		texto = app.loadStrings("texto.txt"); // cargo el texto
		cambiado = texto[0]; // creo la copia del teto
		source = app.createFont("SourceCodePro-Regular.ttf", 16); // creo la fuente y pongo la que necesito

		// Inicializacion de los arraylist
		figuras1 = new ArrayList<Figura1>();
		figuras2 = new ArrayList<Figura2>();
		figuras3 = new ArrayList<Figura3>();
		figuras4 = new ArrayList<Figura4>();

		interpretar(); // metodo que me hace las interpretaciones del texto

	}

	// Metodo interpretar----------------------------------------------------------

	public void interpretar() {

		// primera interpretación--------------
		String guardar1 = texto[0];// copia temporal para la interpretacion1
		String[] uno = guardar1.split("a"); // divido cada que encuentre una a
		cont1 = uno.length - 1; // le asigno el tamaño del arreglo
		int div = cont1 / 10; // por cada 10 'a'

		for (int i = 0; i < div; i++) {// para que me pinte una por cada 10 'a'
			Figura1 fig1 = new Figura1(app);
			figuras1.add(fig1);
		}

		// segunda interpretacion--------------
		String guardar2 = texto[0];// copia temporal para la interpretacion2
		String[] dos = guardar2.split("s "); // corta donde encuentre una palabra terminada en 's'
		cont2 = dos.length - 1;
		int div2 = cont2 / 5;

		for (int i = 0; i < div2; i++) {
			Figura2 fig2 = new Figura2(app);
			figuras2.add(fig2);
		}

		// tercer objeto---------------
		Figura3 fig3 = new Figura3(app);
		figuras3.add(fig3);

		// cuarto objeto---------------
		Figura4 fig4 = new Figura4(app);
		figuras4.add(fig4);

	}

	// pintar-------------------------------------------------------------------
	public void pintar() {
		// Aqui se pintan todas las figuras, controlado por un switch

		switch (pantalla) {
		case 1: // --------------------------
			for (int i = 0; i < figuras1.size(); i++) {
				figuras1.get(i).pintar();
			}

			break;

		case 2: // --------------------------
			for (int i = 0; i < figuras2.size(); i++) {
				figuras2.get(i).pintar();
			}

			break;

		case 3: // --------------------------
			figuras3.get(0).pintar1();

			break;

		case 4: // --------------------------
			figuras4.get(0).pintar();
			app.fill(1, 0, 85);
			app.triangle(390, 450, 390, 480, 370, 465);
			app.triangle(410, 450, 410, 480, 430, 465);
			
			//*********Profe se demora en pasar a la siguiente pantalla, pero si funciona*********

			break;

		case 5: // --------------------------
			app.fill(1, 0, 0);
			app.textAlign(app.CENTER);
			app.textFont(source);
			// mensaje de final de juego
			app.text("¡Gracias por participar!", app.width / 2, 200);
			app.text("Te invito a leer Still I Rise, de Maya Angelou", app.width / 2, 250);
			app.text("El poema que inspiró este trabajo", app.width / 2, 270);
			
			System.out.println(cambiado);
			 

			break;
		}
	}

	// interaccion
	// mouse-------------------------------------------------------------
	public void interaccionMouse(int x1, int y1) {

		switch (pantalla) {
		case 1:

			for (int i = 0; i < figuras1.size(); i++) {
				figuras1.get(i).validarCambio(x1, y1);
			}

			break;

		case 2:

			for (int i = 0; i < figuras2.size(); i++) {
				figuras2.get(i).validarCambio(x1, y1);
			}

			break;

		case 3:
			figuras3.get(0).validarCambio(x1, y1);
			break;

		case 4:
			figuras4.get(0).bola(x1, y1);
			break;
		}

	}

	// interaccion teclado--------------------------------------------------
	public void interaccionTeclado(int iz, int de) {
		switch (pantalla) {
		case 4:
			figuras4.get(0).mover(iz, de);
			break;
		}
	}

	// metodo hacer cambio---------------------------------------------------
	public void hacerCambio() {

		switch (pantalla) {
		case 1:
			int cont = 0;
			for (int i = 0; i < figuras1.size(); i++) {

				if (figuras1.get(i).getCambio() == 2) {
					cont++;
				}

				if (cont == figuras1.size()) {
					cambiado = cambiado.replace('a', 'o'); // solo se hace el cambio cuando todos los aros estan
															// rellenos

					// BOTON--------------
					app.fill(0, 0, 0);
					app.rect(app.width - 170, app.height - 60, 150, 40);
					app.fill(0, 0, 100);
					app.text("Siguiente", app.width - 120, app.height - 35);
					siguiente = true;
				}
			}

			break;

		case 2:

			int cont2 = 0;
			for (int i = 0; i < figuras2.size(); i++) {

				if (figuras2.get(i).getCambio() == 2) {
					cont2++;
				}

				if (cont2 == figuras2.size()) {
					cambiado = cambiado.replace("s ", " "); // cuando ya cambiaron de color, se hace el cambio

					// BOTON--------------
					app.fill(0, 0, 0);
					app.noStroke();
					app.rect(app.width - 170, app.height - 60, 150, 40);
					app.fill(0, 0, 100);
					app.text("Siguiente", app.width - 120, app.height - 35);
					siguiente = true;
				}
			}

			break;

		case 3:

			if (figuras3.get(0).getCambio() == 4) {
				
				if (esta == false) {
					String guardar3 = cambiado;
					tres = guardar3.split(" ");// los parte donde encuentre un espacio

					for (int i = 0; i < tres.length; i++) {
						String temp = tres[i].trim();// borrar los espacios

						if (temp.length() % 2 != 0) {// a partir de aqui si la cantidad de letras de la palabra es
														// impar----------
							StringBuilder tem = new StringBuilder(temp);
							tem.reverse();// voltearla
							temp = tem.toString();// volver a String
						} // ------------------------------------------------------------------------------------------------------

						tres[i] = temp + " "; // le vuelvo a poner el espacio
					}
					StringBuffer unir = new StringBuffer();

					for (int i = 0; i < tres.length; i++) {
						unir.append(tres[i]);
					}
					cambiado = unir.toString(); // guardar de nuevo en cambiado
					esta = true;// para que deje de ejecutarse
				}

				// BOTON--------------
				app.fill(0, 0, 0);
				app.rect(app.width - 170, app.height - 60, 150, 40);
				app.fill(0, 0, 100);
				app.text("Siguiente", app.width - 120, app.height - 35);
				siguiente = true;

			}

			break;

		case 4:
			String guardar4 = cambiado;
			cuatro = guardar4.split(" ");

			if (figuras4.get(0).getBola()) {
				for (int i = 0; i < cuatro.length; i++) {
					String temp = cuatro[i];

					// a partir de aqui si contiene la letra E
					if (temp.contains("e")) {
						char[] c;
						c = temp.toCharArray();
						if (c[1] == 'e') {// si la segunda es la E
							c[1] = 'E';
						}
						temp = String.valueOf(c);// me vuelva el arreglo de char un strin
					} // -------------------------------------

					cuatro[i] = temp;
				}

				StringBuffer unir = new StringBuffer();
				for (int i = 0; i < cuatro.length; i++) {
					unir.append(cuatro[i] + " ");
				}
				cambiado = unir.toString(); // guardar los cambios en cambiado

				// BOTON--------------
				app.fill(0, 0, 0);
				app.rect(app.width - 170, app.height - 60, 150, 40);
				app.fill(0, 0, 100);
				app.text("Siguiente", app.width - 120, app.height - 35);
				siguiente = true;
			}
			break;
		}
	}

	// metodo validar click cambio de
	// PANTALLA----------------------------------------------------
	public void validarClick() {
		if (siguiente) {
			if (app.mouseX > app.width - 170 && app.mouseX < app.width - 20 && app.mouseY > app.height - 60
					&& app.mouseY < app.height - 20) {
				click = true; // si se da click
			} else {
				click = false;
			}

			if (click) {// entonces me haga el cmabio de pantalla
				pantalla++;
				siguiente = false;
			}
		}
	}

}
