/**
 * 
 */
package topcolleguesbackend.controller.vm;

/**
 * @author GOBERT Guillaume
 *
 */
public class CollegueIhm {

	private String matricule;
	private String pseudo;
	private String imageUrl;

	/**
	 * Getter
	 * 
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * Setter
	 * 
	 * @param matricule
	 *            the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
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
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Setter
	 * 
	 * @param imageUrl
	 *            the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
