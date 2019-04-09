package modele.graphe;

import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.Segment;


public class ModeleGrapheHex2 extends ModeleGraphe{
	private static final long serialVersionUID = 106L;
	
	public ModeleGrapheHex2() {
		super("Petit Hex");
		
		PointCouleur red1 = new PointCouleur(100,360);
		PointCouleur blue1 = new PointCouleur(600, 25);
		PointCouleur red2 = new PointCouleur(1100,360);
		PointCouleur blue2 = new PointCouleur(600, 725);
		
		Point ligne1 = new Point(100,100);

				
		addPoint(red1);
		addPoint(red2);
		addPoint(blue1);
		addPoint(blue2);
		
		addPointSpeciaux("depart1", red1);
		addPointSpeciaux("arrive1", red2);
		addPointSpeciaux("depart2", blue1);
		addPointSpeciaux("arrive2", blue2);
		addPointSpeciaux("j00", red1);
		addPointSpeciaux("j01", red2);
		addPointSpeciaux("j10", blue1);
		addPointSpeciaux("j11", blue2);
		addSegment(new Segment(red1, ligne1));
		addSegment(new Segment(red2, ligne1));
		addSegment(new Segment(blue1, ligne1));
		addSegment(new Segment(blue2, ligne1));
	}
}
