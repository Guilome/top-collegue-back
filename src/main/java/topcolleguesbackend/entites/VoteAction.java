/**
 * 
 */
package topcolleguesbackend.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Integer id;
	@Column(name = "AVIS")
	private String avis;

	public VoteAction(String avis) {
		this.avis = avis;
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
	public String getAvis() {
		return avis;
	}

	/**
	 * Setter
	 * 
	 * @param avis
	 *            the avis to set
	 */
	public void setAvis(String avis) {
		avis = avis;
	}

}
