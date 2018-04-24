/**
 * 
 */
package topcolleguesbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import topcolleguesbackend.entites.VoteAction;
import topcolleguesbackend.repository.VoteRepository;

/**
 * @author GOBERT Guillaume
 *
 */
@RestController
@CrossOrigin
public class VoteController {

	@Autowired
	private VoteRepository voteRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/votes")
	public List<VoteAction> listerVotes() {
		return voteRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/votes", params = { "since" })
	public List<VoteAction> listerVotesSince(@RequestParam Integer since) {
		return voteRepo.findByIdGreaterThan(since);
	}
}
