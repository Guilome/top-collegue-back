/**
 * 
 */
package topcolleguesbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import topcolleguesbackend.entites.VoteAction;

/**
 * @author GOBERT Guillaume
 *
 */
public interface VoteRepository extends JpaRepository<VoteAction, Integer> {

	List<VoteAction> findByIdGreaterThan(Integer id);
}
