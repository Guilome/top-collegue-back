/**
 * 
 */
package topcolleguesbackend.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author GOBERT Guillaume
 *
 */
@Entity
@Table(name = "COLLEGUE")
public class Collegue {
	@Id
	@Column(name = "PSEUDO")
	private String pseudo;
	@Column(name = "SCORE")
	@Max(1000)
	@Min(-1000)
	private Integer score;
	@Column(name = "PHOTO")
	private String photo;

	/**
	 * Constructeur
	 *
	 */
	public Collegue() {
	}

	/**
	 * Getter
	 * 
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * Setter
	 * 
	 * @param pseudo
	 *            the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
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

	/**
	 * Getter
	 * 
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Setter
	 * 
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
