package castanedakaren;

public class Figura4 {

	// atributos
	private Main app;
	private int x1, y1, x2, y2, x3, y3, x4, y4;
	private int col;
	private int lado;
	private boolean bola;

	public Figura4(Main app) {
		this.app = app;
		lado = 200;
		col = (int) app.random(0, 360);
		bola = false;

		x1 = (app.width - lado) / 2;
		y1 = (app.height - lado) / 2;

		x2 = x1 + lado;
		y2 = y1;

		x3 = x1 + 20;
		y3 = y2 + lado;

		x4 = x3 - lado;
		y4 = y2 + lado;

	}

	// metodos
	public void pintar() {
		app.noStroke();
		app.fill(col, 80, 80);
		app.quad(x1, y1, x2, y2, x3, y3, x4, y4);
		app.fill(1, 0, 0);

		if (x4 == x1) {//solo se pinte la bola cuando completa un cuadrado
			app.ellipse(app.width / 2, app.height / 2, 30, 30);
		}
	}

	public void mover(int iz, int de) {//depende de donde se mueva me cambia para un lado o para el otro

		if (app.keyCode == iz) {
			x3 -= 2;
			x4 -= 2;
			col = (int) app.random(0, 360);//me cambie los colores mientras se mueve para que la bola no sea visible tan facilmente
		}
		if (app.keyCode == de) {
			x3 += 2;
			x4 += 2;
			col = (int) app.random(0, 360);//me cambie los colores mientras se mueve para que la bola no sea visible tan facilmente
		}
	}

	public void bola(int x, int y) {//si da click sobre la bola, recibe para poner mouseX y mouseY
		if (app.dist(x, y, app.width / 2, app.height / 2) < 15) {
			bola = true;
		}
	}

	public boolean getBola() {
		return bola;
	}

}
