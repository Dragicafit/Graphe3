package modele.segment;

import modele.point.Point;

public class Segment {

	private Point point1;
	private Point point2;
	private boolean oriente;

	public Segment(Point point1, Point point2, boolean oriente) {
		this.point1 = point1;
		this.point2 = point2;
		this.oriente = oriente;
	}

	public Segment(Point point1, Point point2) {
		this(point1, point2, false);
	}

	public Point getPoint1() {
		return point1;
	}

	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public void setPoint2(Point point2) {
		this.point2 = point2;
	}

	public boolean isOriente() {
		return oriente;
	}

	public void setOriente(boolean oriente) {
		this.oriente = oriente;
	}

}
