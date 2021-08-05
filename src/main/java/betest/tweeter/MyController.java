package betest.tweeter;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import betest.tweeter.entities.Like;
import betest.tweeter.entities.Tweet;
import betest.tweeter.entities.custom.ITweetCust;
import betest.tweeter.repos.LikeRepository;
import betest.tweeter.repos.TweetRepository;

@RestController
public class MyController {
	private final TweetRepository tweetRepo;
	private final LikeRepository likeRepo;

	MyController(TweetRepository tweetRepo, LikeRepository likeRepo) {
		this.tweetRepo = tweetRepo;
		this.likeRepo = likeRepo;
	}

	@GetMapping("/tweets")
	public List<Tweet> allTweets() {
		return tweetRepo.findAll();
	}
	
	@GetMapping("/ctweets")
	public List<ITweetCust> custTweets() {
		return tweetRepo.getTweetCustNative();
	}
	
	@GetMapping("/ctweets2")
	public List<ITweetCust> custTweets2() {
		return tweetRepo.getTweetCust2Native();
	}
	
	@GetMapping("/likes")
	public List<Like> allLikes() {
		return likeRepo.findAll();
	}

	@RequestMapping("/")
	public String home() {
		return "Hello World, I am coming fully charged!";
	}
}
