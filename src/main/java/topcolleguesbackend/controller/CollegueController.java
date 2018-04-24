/**
 * 
 */
package topcolleguesbackend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import topcolleguesbackend.controller.vm.ActionIhm;
import topcolleguesbackend.controller.vm.CollegueAPI;
import topcolleguesbackend.controller.vm.CollegueIhm;
import topcolleguesbackend.entites.Collegue;
import topcolleguesbackend.entites.VoteAction;
import topcolleguesbackend.repository.CollegueRepository;
import topcolleguesbackend.repository.VoteRepository;
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
	@Autowired
	private VoteRepository voteRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/collegues")
	public List<Collegue> listerCollegue() {
		return collegueRepo.findAll();
	}

	@RequestMapping(value = "/collegues/{pseudo}", method = RequestMethod.PATCH)
	public Collegue scoreCollegue(@PathVariable String pseudo, @RequestBody ActionIhm actionIhm) {
		Collegue updateCollegue = new Collegue();
		VoteAction voteSave = new VoteAction();
		if (collegueRepo.existsByPseudo(pseudo)) {
			updateCollegue = collegueRepo.findCollegueByPseudo(pseudo);
			voteSave.setAvis(actionIhm.getAction());
			voteSave.setCollegue(updateCollegue);
			updateCollegue = VoteService.GestionScore(actionIhm.getAction(), updateCollegue);
			voteSave.setScore(updateCollegue.getScore());
		}
		voteRepo.save(voteSave);
		collegueRepo.save(updateCollegue);
		return updateCollegue;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/collegues/{pseudo}")
	public Collegue getCollegue(@PathVariable String pseudo) {
		return collegueRepo.findCollegueByPseudo(pseudo);
	}

	@RequestMapping(value = "/collegues/creation", method = RequestMethod.PUT)
	public void saveCollegue(@RequestBody CollegueIhm collegue) {
		
		String matriculeTest = collegue.getMatricule();
		Collegue nouveauCollegue = new Collegue();
		
		RestTemplate restTemp = new RestTemplate();
		ResponseEntity<CollegueAPI[]> response = restTemp.getForEntity("http://collegues-api.cleverapps.io/collegues", CollegueAPI[].class);
		List<CollegueAPI> collegues = Arrays.asList(response.getBody());
		for (CollegueAPI collegueAPI : collegues) {
			if (collegueAPI.getMatricule().equals(collegue.getMatricule())) {
				nouveauCollegue.setPseudo(collegue.getPseudo());
				if (collegue.getImageUrl() == null) {
					nouveauCollegue.setPhoto(collegueAPI.getPhoto());
				} else {
					nouveauCollegue.setPhoto(collegue.getImageUrl());
				}
				nouveauCollegue.setNom(collegueAPI.getNom());
				nouveauCollegue.setPrenom(collegueAPI.getPrenom());
				nouveauCollegue.setEmail(collegueAPI.getEmail());
				nouveauCollegue.setAdresse(collegueAPI.getAdresse());
			}
		}
		collegueRepo.save(nouveauCollegue);
	}

}
