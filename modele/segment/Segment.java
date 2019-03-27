package modele.segment;

import java.io.Serializable;

import modele.point.Point;

public class Segment implements Serializable {
	private static final long serialVersionUID = 20L;

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

	public Point getVoisin(Point p) {
		if (point1 == p) {
			return point2;
		} else if (point2 == p) {
			return point1;
		}
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Segment) {
			Segment segment = (Segment) obj;
			return point1.equals(segment.point1) && point2.equals(segment.point2)
					|| point1.equals(segment.point2) && point2.equals(segment.point1);
		}
		return false;
	}
}
