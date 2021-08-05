package betest.tweeter.entities.custom;

import java.sql.Timestamp;

public interface ITweetCust {

    Integer getId();
    String getContent();
    String getUsername();
    Timestamp getTimestamp();
    Integer getLikes_count();
    Integer getRetweets_count();
}