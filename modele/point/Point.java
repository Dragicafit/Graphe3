package modele.point;

import java.io.Serializable;

public class Point implements Serializable {

	private double x;
	private double y;
	private double rayon;
	private boolean deplacable;

	public Point(double x, double y, double rayon, boolean deplacable) {
		this.x = x;
		this.y = y;
		this.rayon = rayon;
		this.deplacable = deplacable;
	}

	public Point(double x, double y, double rayon) {
		this(x, y, rayon, true);
	}

	public Point(double x, double y) {
		this(x, y, 15);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

	public boolean isDeplacable() {
		return deplacable;
	}

	public void setDeplacable(boolean deplacable) {
		this.deplacable = deplacable;
	}
}
