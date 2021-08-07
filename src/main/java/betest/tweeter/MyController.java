package betest.tweeter;

import java.sql.Timestamp;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import betest.tweeter.entities.Like;
import betest.tweeter.entities.Tweet;
import betest.tweeter.entities.custom.IRetweetCust;
import betest.tweeter.entities.custom.ITweetCust;
import betest.tweeter.entities.dto.TweetDto;
import betest.tweeter.repos.LikeRepository;
import betest.tweeter.repos.ReTweetRepository;
import betest.tweeter.repos.TweetRepository;

@RestController
public class MyController {
	private final TweetRepository tweetRepo;
	private final ReTweetRepository reTweetRepo;
	private final LikeRepository likeRepo;

	@Autowired
	private ModelMapper modelMapper;

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

	@PostMapping("/tweets")
	public Tweet newTweet(@RequestBody TweetDto newTweetTdo) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		modelMapper.typeMap(TweetDto.class, Tweet.class);
		Tweet newTweet = modelMapper.map(newTweetTdo, Tweet.class);
		newTweet.setTimestamp(new Timestamp(System.currentTimeMillis()));
		return tweetRepo.save(newTweet);
	}
}
