package betest.tweeter.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import betest.tweeter.entities.Tweet;
import betest.tweeter.entities.custom.ITweetCust;
import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {

	@Query(value = "SELECT T.ID, TEXT_CONTENT AS CONTENT, T.TIMESTAMP, T.USERNAME, COUNT(L.ID) AS LIKES_COUNT FROM TWEETS AS T "
			+ "LEFT JOIN LIKES AS L ON T.ID = POSTID GROUP BY POSTID ORDER BY T.ID", nativeQuery = true)
	List<ITweetCust> getTweetCustNative();

	@Query(value = "SELECT J.*, COUNT(R.POSTID) AS RETWEETS_COUNT FROM RETWEET AS R "
			+ "RIGHT JOIN (SELECT T.ID, TEXT_CONTENT AS CONTENT, T.TIMESTAMP, T.USERNAME, COUNT(L.ID) AS LIKES_COUNT FROM TWEETS AS T "
			+ "LEFT JOIN LIKES AS L ON T.ID = L.POSTID GROUP BY POSTID) J ON J.ID = R.POSTID GROUP BY R.POSTID ORDER BY J.ID", nativeQuery = true)
	List<ITweetCust> getTweetCust2Native();
}