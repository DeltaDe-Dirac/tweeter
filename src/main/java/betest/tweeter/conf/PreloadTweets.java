package betest.tweeter.conf;

import java.sql.Timestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import betest.tweeter.entities.Tweet;
import betest.tweeter.repos.TweetRepository;

@Configuration
class PreloadTweets {

	private static final Logger LOG = LoggerFactory.getLogger(PreloadTweets.class);

	@Bean
	CommandLineRunner initTweets(TweetRepository repository) {

		return args -> {
			LOG.info(repository.save(new Tweet("Coding is amazing!", "Igor Shevtsov", Timestamp.valueOf("2021-08-04 19:30:55"))).toString());			
			LOG.info(repository.save(new Tweet("Thank you all for warm wishes!", "Brad Pitt", Timestamp.valueOf("2020-12-18 16:17:03"))).toString());
			LOG.info(repository.save(new Tweet("Congrats! You have been accepted!", "AC8200", Timestamp.valueOf("2021-08-05 10:12:47"))).toString());
		};
	}
}
