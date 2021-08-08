package betest.tweeter.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import betest.tweeter.entities.Tweet;
import betest.tweeter.entities.custom.ITweetCust;
import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {
	@Query(value = "SELECT J.*, COUNT(R.POSTID) AS RETWEETS_COUNT FROM RETWEETS AS R "
			+ "RIGHT JOIN (SELECT T.ID, TEXT_CONTENT AS CONTENT, T.TIMESTAMP, T.USERNAME, COUNT(L.POSTID) AS LIKES_COUNT FROM TWEETS AS T "
			+ "LEFT JOIN LIKES AS L ON T.ID = L.POSTID GROUP BY POSTID, T.ID) J ON J.ID = R.POSTID GROUP BY R.POSTID, J.ID, J.CONTENT, J.TIMESTAMP, J.USERNAME, J.LIKES_COUNT ORDER BY J.ID", nativeQuery = true)
	List<ITweetCust> getTweetCustNative();
}