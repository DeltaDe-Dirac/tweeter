package betest.tweeter.conf;
import java.sql.Timestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import betest.tweeter.entities.Like;
import betest.tweeter.repos.LikeRepository;

@Configuration
class PreloadLikes {

	private static final Logger LOG = LoggerFactory.getLogger(PreloadLikes.class);

	@Bean
	CommandLineRunner initLikes(LikeRepository repository) {

		return args -> {
			LOG.info(repository.save(new Like(1, "Ester Marasigan", Timestamp.valueOf("2021-08-04 19:47:23"))).toString());
			
			LOG.info(repository.save(new Like(2, "Ryan Gosling", Timestamp.valueOf("2020-12-18 16:17:03"))).toString());
			LOG.info(repository.save(new Like(2, "Quentin Tarantino", Timestamp.valueOf("2020-12-18 16:18:12"))).toString());
			LOG.info(repository.save(new Like(2, "Julia Roberts", Timestamp.valueOf("2020-12-18 16:19:05"))).toString());
			LOG.info(repository.save(new Like(2, "Liv Tyler", Timestamp.valueOf("2020-12-18 17:17:47"))).toString());
			LOG.info(repository.save(new Like(2, "Jennifer Aniston", Timestamp.valueOf("2020-12-18 18:44:33"))).toString());			
		};
	}
}
