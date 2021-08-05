package betest.tweeter.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import betest.tweeter.entities.ReTweet;

public interface ReTweetRepository extends JpaRepository<ReTweet, Integer> {
	
}

