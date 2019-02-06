import java.awt.Color;

import modele.Modele;
import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.Segment;
import modele.segment.SegmentCouleur;

public class Main {
	public static void main(String[] args) {
		Modele modele = new Modele();
		Point point1 = new Point(21, 39);
		Point point2 = new PointCouleur(11, 21, new Color(0, 25, 251));
		Point point3 = new PointCouleur(23, 1, new Color(36, 64, 65));

		modele.addPoint(point1);
		modele.addPoint(point2);
		modele.addPoint(point3);

		modele.addSegment(new Segment(point1, point2));
		modele.addSegment(new SegmentCouleur(point1, point3, new Color(21, 29, 23)));
		modele.addSegment(new Segment(point1, point3, true));
	}
}
