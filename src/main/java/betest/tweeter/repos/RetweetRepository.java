package betest.tweeter.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import betest.tweeter.entities.Retweet;
import betest.tweeter.entities.custom.IRetweetCust;

public interface RetweetRepository extends JpaRepository<Retweet, Integer> {
	@Query(value = "SELECT T.TEXT_CONTENT AS CONTENT, R.USERNAME AS RETWEET_USER, T.ID AS TWEET_ID, T.USERNAME AS TWEET_USER, R.TIMESTAMP FROM TWEETS AS T "
			+ "INNER JOIN RETWEETS R ON T.ID = R.POSTID", nativeQuery = true)
	List<IRetweetCust> getRetweetCustNative();
}
