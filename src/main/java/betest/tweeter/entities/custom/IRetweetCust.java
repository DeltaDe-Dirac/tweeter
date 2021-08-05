package betest.tweeter.entities.custom;
import java.sql.Timestamp;

public interface IRetweetCust {    
    String getContent();
    String getRetweet_user();
    Integer getTweet_id();
    String getTweet_user();
    Timestamp getTimestamp();
}