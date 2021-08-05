package betest.tweeter.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import betest.tweeter.entities.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {
	
}