package betest.tweeter;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import betest.tweeter.entities.Like;
import betest.tweeter.entities.Retweet;
import betest.tweeter.entities.Tweet;
import betest.tweeter.repos.LikeRepository;
import betest.tweeter.repos.RetweetRepository;
import betest.tweeter.repos.TweetRepository;

@SpringBootApplication
public class TweeterApplication {
	@Autowired
	private TweetRepository tweetRepo;
	@Autowired
	private RetweetRepository reTweetRepo;
	@Autowired
	private LikeRepository likeRepo;

	private static final Logger LOG = LoggerFactory.getLogger(TweeterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TweeterApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		List<Tweet> allTweets = this.tweetRepo.findAll();
		LOG.info(String.format("Found tweets: %s", allTweets.size()));
		
		List<Like> allLikes = this.likeRepo.findAll();
		LOG.info(String.format("Found likes: %s", allLikes.size()));
		
		List<Retweet> allRetweets = this.reTweetRepo.findAll();
		LOG.info(String.format("Found retweets: %s", allRetweets.size()));
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
