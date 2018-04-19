/**
 * 
 */
package topcolleguesbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import topcolleguesbackend.controller.vm.ActionIhm;
import topcolleguesbackend.entites.Collegue;
import topcolleguesbackend.repository.CollegueRepository;
import topcolleguesbackend.service.VoteService;

/**
 * @author GOBERT Guillaume
 *
 */
@RestController
@CrossOrigin
public class CollegueController {

	@Autowired
	private CollegueRepository collegueRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/collegues")
	public List<Collegue> listerCollegue() {
		return collegueRepo.findAll();
	}

	@RequestMapping(value = "/collegues/{pseudo}", method = RequestMethod.PATCH)
	public Collegue scoreCollegue(@PathVariable String pseudo, @RequestBody ActionIhm actionIhm) {
		Collegue updateCollegue = new Collegue();
		if (collegueRepo.existsByPseudo(pseudo)) {
			updateCollegue = collegueRepo.findCollegueByPseudo(pseudo);
			updateCollegue = VoteService.GestionScore(actionIhm.getAction(), updateCollegue);
		}
		collegueRepo.save(updateCollegue);
		return updateCollegue;
	}
}