package betest.tweeter.conf;
import java.sql.Timestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import betest.tweeter.entities.ReTweet;
import betest.tweeter.repos.ReTweetRepository;

@Configuration
class PreloadReTweets {

	private static final Logger LOG = LoggerFactory.getLogger(PreloadReTweets.class);

	@Bean
	CommandLineRunner initReTweets(ReTweetRepository repository) {

		return args -> {
			LOG.info(repository.save(new ReTweet(1, "John Doe", Timestamp.valueOf("2021-08-05 09:47:23"))).toString());
			
			LOG.info(repository.save(new ReTweet(2, "Quentin Tarantino", Timestamp.valueOf("2020-12-18 16:18:12"))).toString());
			LOG.info(repository.save(new ReTweet(2, "Julia Roberts", Timestamp.valueOf("2020-12-18 16:19:05"))).toString());
			LOG.info(repository.save(new ReTweet(2, "Jennifer Aniston", Timestamp.valueOf("2020-12-18 18:44:33"))).toString());	
			
			LOG.info(repository.save(new ReTweet(3, "AC8201", Timestamp.valueOf("2021-08-05 11:46:23"))).toString());			

		};
	}
}
