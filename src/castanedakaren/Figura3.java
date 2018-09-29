package castanedakaren;

public class Figura3 {

	// atributos
	private Main app;
	private int x, y;
	private int anch, alt, deg;
	private float ini, fin;
	private int col, col2, col3, col4;
	private int cambio;

	public Figura3(Main app) {
		this.app = app;
		x = app.width / 2;
		y = (app.height / 2) + 50;
		anch = 400;
		alt = 400;
		deg = 135;
		ini = app.PI;
		col = (int) app.random(1, 360);
		col2 = (int) app.random(1, 360);
		col3 = (int) app.random(1, 360);
		col4 = (int) app.random(1, 360);
		cambio = 1;
	}

	// metodos
	public void pintar1() {//a medida que se cambia de estado se completa el arcoiris
		switch (cambio) {
		case 1:
			app.noStroke();
			app.fill(col, 80, 80);
			app.arc(x, y, anch, alt, ini, app.PI + (app.PI) / 4);
			app.fill(0, 0, 100);
			app.ellipse(x, y, anch - 300, alt - 300);

			break;

		case 2:
			app.noStroke();
			app.fill(col, 80, 80);
			app.arc(x, y, anch, alt, ini, app.PI + app.HALF_PI);
			app.fill(col2, 80, 80);
			app.arc(x, y, anch - 75, alt - 75, ini, app.PI + app.HALF_PI);
			app.fill(0, 0, 100);
			app.ellipse(x, y, anch - 300, alt - 300);

			break;

		case 3:
			app.fill(col, 80, 80);
			app.arc(x, y, anch, alt, ini, app.PI + (3 * app.PI) / 4);
			app.fill(col2, 80, 80);
			app.arc(x, y, anch - 75, alt - 75, ini, app.PI + (3 * app.PI) / 4);
			app.fill(col3, 80, 80);
			app.arc(x, y, anch - 150, alt - 150, ini, app.PI + (3 * app.PI) / 4);
			app.fill(0, 0, 100);
			app.ellipse(x, y, anch - 300, alt - 300);

			break;

		case 4:
			app.fill(col, 80, 80);
			app.arc(x, y, anch, alt, ini, 2 * app.PI);
			app.fill(col2, 80, 80);
			app.arc(x, y, anch - 75, alt - 75, ini, 2 * app.PI);
			app.fill(col3, 80, 80);
			app.arc(x, y, anch - 150, alt - 150, ini, 2 * app.PI);
			app.fill(col4, 80, 80);
			app.arc(x, y, anch - 225, alt - 225, ini, 2 * app.PI);
			app.fill(0, 0, 100);
			app.ellipse(x, y, anch - 300, alt - 300);

			break;
		}
	}

	public void validarCambio(int x1, int y1) {//me cambia los estados, recibe variables que luego reemplazo con mouseX y mouseY

		if (app.dist(x, y, x1, y1) < 200) {
			if (cambio < 4) {
				cambio++;
			}
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
