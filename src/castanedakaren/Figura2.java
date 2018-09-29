package castanedakaren;

public class Figura2 {

	// atributos
	private Main app;
	private int x, y;
	private int anch, alt;
	private int r, g, b;
	private int col, col2, cambio;

	public Figura2(Main app) {
		this.app = app;
		cambio = 1;
		anch = 100;
		alt = 60;
		x = (int) app.random(25, app.width - anch);
		y = (int) app.random(25, app.height - alt);
		col = (int) app.random(1, 360);
		col2 = (int) app.random(1, 360);
	}

	// metodos
	public void pintar() {

		switch (cambio) {
		case 1: //primer estado color 1
			app.noStroke();
			app.fill(col, 80, 80);
			app.rect(x, y, anch, alt);
			app.stroke(col2, 80, 80);
			for (int i = 0; i < 4; i++) {
				app.line(x + 30 + (i * 10), y, x + 10 + (i * 10), y + alt);
			}

			break;
		case 2: //segundo estado color 2
			app.noStroke();
			app.fill(col2, 80, 80);
			app.rect(x, y, anch, alt);
			app.stroke(col, 80, 80);
			for (int i = 0; i < 4; i++) {
				app.line(x + 30 + (i * 10), y, x + 10 + (i * 10), y + alt);
			}
			break;
		}
	}

	public void validarCambio(int x1, int y1) {//me cambia el estado

		if (x1 > x && x1 < x + anch && y1 > y && y1 < y + alt) {
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
