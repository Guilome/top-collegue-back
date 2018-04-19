/**
 * 
 */
package topcolleguesbackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import topcolleguesbackend.entites.Collegue;

/**
 * @author GOBERT Guillaume
 *
 */
public interface CollegueRepository extends JpaRepository<Collegue, Integer> {

	Collegue findCollegueByPseudo(String pseudo);

	Boolean existsByPseudo(String pseudo);
}
