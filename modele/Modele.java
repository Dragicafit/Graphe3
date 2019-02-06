package modele;

import java.util.ArrayList;

import modele.point.Point;
import modele.segment.Segment;

public class Modele {
	private ArrayList<Point> points;
	private ArrayList<Segment> segments;
	
	public Modele() {
		this.points = new ArrayList<>();
		this.segments = new ArrayList<>();
	}

	public void addPoint(Point point) {
		points.add(point);
	}
	public void addSegment(Segment segment) {
		segments.add(segment);
	}
	public Point getPoint(int index) {
		return points.get(index);
	}
	public Segment getSegment(int index) {
		return segments.get(index);
	}
	public boolean containsPoint(Point p) {
		return points.contains(p);
	}
	public boolean containsSegment(Segment s) {
		return segments.contains(s);
	}
}
