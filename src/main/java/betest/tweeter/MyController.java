package betest.tweeter;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import betest.tweeter.entities.Like;
import betest.tweeter.entities.custom.IRetweetCust;
import betest.tweeter.entities.custom.ITweetCust;
import betest.tweeter.repos.LikeRepository;
import betest.tweeter.repos.ReTweetRepository;
import betest.tweeter.repos.TweetRepository;

@RestController
public class MyController {
	private final TweetRepository tweetRepo;
	private final ReTweetRepository reTweetRepo;
	private final LikeRepository likeRepo;

	MyController(TweetRepository tweetRepo, LikeRepository likeRepo, ReTweetRepository reTweetRepo) {
		this.tweetRepo = tweetRepo;
		this.reTweetRepo = reTweetRepo;
		this.likeRepo = likeRepo;
	}
	
	@GetMapping("/tweets")
	public List<ITweetCust> custTweets() {
		return tweetRepo.getTweetCustNative();
	}
	
	@GetMapping("/retweets")
	public List<IRetweetCust> custRetweets() {
		return reTweetRepo.getRetweetCustNative();
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
