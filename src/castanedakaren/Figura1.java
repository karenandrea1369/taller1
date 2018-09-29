package castanedakaren;

public class Figura1 {

	// atributos
	private Main app;
	private int x, y;
	private int tam;
	private int cambio, col;

	public Figura1(Main app) {
		this.app = app;

		tam = 60;
		x = (int) app.random(25, app.width - tam - 2);
		y = (int) app.random(25, app.height - tam - 2);
		cambio = 1;
		col = (int) app.random(1, 360);
	}

	// metodos
	public void pintar() {
		switch (cambio) {
		case 1: //primer estado aros vacios
			app.stroke(50, 80, 80);
			app.noFill();
			app.ellipse(x, y, tam, tam);
			break;
		case 2://segundo estado aros rellenos
			app.stroke(50, 80, 80);
			app.noFill();
			app.ellipse(x, y, tam, tam);
			app.fill(col, 80, 80);
			app.noStroke();
			app.ellipse(x, y, tam - 10, tam - 10);
			break;
		}
	}

	public void validarCambio(int x1, int y1) {//me cambia el estado

		if (app.dist(x, y, x1, y1) < tam / 2) {
			cambio = 2;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getCambio() {
		return cambio;
	}

}
