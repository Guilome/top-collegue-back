/**
 * 
 */
package topcolleguesbackend.service;

import topcolleguesbackend.entites.Avis;
import topcolleguesbackend.entites.Collegue;

/**
 * @author GOBERT Guillaume
 *
 */
public class VoteService {

	public static Collegue GestionScore(Avis avis, Collegue collegue) {
		if (avis.equals(Avis.AIMER)) {
			Integer score = collegue.getScore();
			collegue.setScore(score + 10);
		}
		if (avis.equals(Avis.DETESTER)) {
			Integer score = collegue.getScore();
			collegue.setScore(score - 5);
		}
		return collegue;
	}
}
