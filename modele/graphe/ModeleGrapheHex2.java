package modele.graphe;

import modele.Couleur;
import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.Segment;


public class ModeleGrapheHex2 extends ModeleGraphe{
	private static final long serialVersionUID = 106L;
	
	public ModeleGrapheHex2() {
		super("Petit Hex");
		
		PointCouleur red1 = new PointCouleur(100,360, Couleur.ROUGE);
		PointCouleur blue1 = new PointCouleur(600, 25, Couleur.BLEU);
		PointCouleur red2 = new PointCouleur(1100,360, Couleur.ROUGE);
		PointCouleur blue2 = new PointCouleur(600, 725, Couleur.BLEU);
		
		Point ligne1 = new Point(100,100);

				
		addPoint(red1);
		addPoint(red2);
		addPoint(blue1);
		addPoint(blue2);
		
		addPointSpeciaux("rouge1", red1);
		addPointSpeciaux("rouge2", red2);
		addPointSpeciaux("bleu1", blue1);
		addPointSpeciaux("bleu2", blue2);
		addSegment(new Segment(red1, ligne1));
		addSegment(new Segment(red2, ligne1));
		addSegment(new Segment(blue1, ligne1));
		addSegment(new Segment(blue2, ligne1));
	}
}
