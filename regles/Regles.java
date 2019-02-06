package regles;

import modele.Modele;
import modele.point.*;
public class Regles{
	public Modele m = new Modele(); //A faire ailleurs
	boolean check_cote_soit;
	boolean check_cote_ennemi;
	boolean sur_ennemi;
	boolean estVide;
	
	public Regles(boolean check_soit, boolean check_ennemi, boolean sur_ennemi, boolean estVide) {
		this.check_cote_soit = check_soit;
		this.check_cote_ennemi = check_ennemi;
		this.sur_ennemi = sur_ennemi;
		this.estVide = estVide;
	}
	
	public boolean check_cote_soit(Point p) {
		for(int i=0; i< m.getSize_segments(); i++) {
			Point v = m.getSegment(i).getVoisin(p);
			if(v instanceof PointCouleur) {
				PointCouleur pc = (PointCouleur) v;
				/* ==== Need Joueur ==== */

				/*if(pc.getCouleur() == J.getCouleur()) {
					return true;
				}*/
			}
		}
		return false;
	}
	
	public boolean check_cote_ennemi(Point p) {
		for(int i=0; i< m.getSize_segments(); i++) {
			Point v = m.getSegment(i).getVoisin(p);
			if(v instanceof PointCouleur) {
				PointCouleur pc = (PointCouleur) v;
				/* ==== Need Joueur ==== */

				/*if(pc.getCouleur() != J.getCouleur()) {
					return true;
				}*/
			}
		}
		return false;
	}
	
	
	public boolean sur_ennemi(Point p) {
		PointCouleur ennemi;
		for(int i=0; i< m.getSize_segments(); i++) {
			if(m.getSegment(i).getPoint1() == p) {
				ennemi = (PointCouleur) m.getSegment(i).getPoint1();
				/* ==== Need Joueur ==== */

				/*if(ennemi.getCouleur() != J.getCouleur() ){
				 * 	return true;
				 * }
				 */
			}else if(m.getSegment(i).getPoint2() ==p) {
				ennemi = (PointCouleur) m.getSegment(i).getPoint2();
				/* ==== Need Joueur ==== */

				/*if(ennemi.getCouleur() != J.getCouleur() ){
				 * 	return true;
				 * }
				 */
			}
		}
		return false;
	}
	
	public boolean estVide(Point p) {
		for(int i=0; i< m.getSize_segments();i++) {
			if(m.getSegment(i).getPoint1() == p) {
				if(!(m.getSegment(i).getPoint1() instanceof PointCouleur )) {
					return true;
				}
			}else if(m.getSegment(i).getPoint2() == p) {
				if(!(m.getSegment(i).getPoint2() instanceof PointCouleur )) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean allAround(Point p) {
		for(int i =0; i< m.getSize_segments(); i++) {
			Point v = m.getSegment(i).getVoisin(p);
			if(v != null) {
				if(v != null && v instanceof PointCouleur) {
					PointCouleur pc = (PointCouleur) v;
					/* ==== Need Joueur ==== */

					/*if(pc.getCouleur() != J.getCouleur()){ 
				 	*		return false;
				 	* }
				 	*/
				}else if(v!=null){
					return false;
				}
			}
		}
		return true;
	}
	
	
}
