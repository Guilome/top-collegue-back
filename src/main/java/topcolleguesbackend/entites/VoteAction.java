/**
 * 
 */
package topcolleguesbackend.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author GOBERT Guillaume
 *
 */
@Entity
@Table(name = "VOTE_ACTION")
public class VoteAction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Integer id;
	@Column(name = "AVIS")
	Avis avis;
	@OneToOne
	Collegue collegue;
	@Column(name = "SCORE")
	Integer score;

	public VoteAction() {

	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Getter
	 * 
	 * @return the avis
	 */
	public Avis getAvis() {
		return avis;
	}
	/**
	 * Setter
	 * 
	 * @param avis
	 *            the avis to set
	 */
	public void setAvis(Avis avis) {
		this.avis = avis;
	}

	/**
	 * Getter
	 * 
	 * @return the collegue
	 */
	public Collegue getCollegue() {
		return collegue;
	}

	/**
	 * Setter
	 * 
	 * @param collegue
	 *            the collegue to set
	 */
	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
	}

	/**
	 * Getter
	 * 
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * Setter
	 * 
	 * @param score
	 *            the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

}
