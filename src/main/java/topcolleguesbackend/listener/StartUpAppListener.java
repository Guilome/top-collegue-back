/**
 * 
 */
package topcolleguesbackend.listener;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import topcolleguesbackend.entites.Collegue;
import topcolleguesbackend.entites.VoteAction;

/**
 * @author GOBER Guillaume
 *
 */
@Component
public class StartUpAppListener {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("collegues.xml", "votes.xml");

		Stream.of(Collegue.class, VoteAction.class).flatMap(classe -> context.getBeansOfType(classe).values().stream())
				.forEach(em::persist);
	}
}
