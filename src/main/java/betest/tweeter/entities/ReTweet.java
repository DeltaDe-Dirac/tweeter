package betest.tweeter.entities;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "retweet")
public class ReTweet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer postID;
	private String username;
	private Timestamp timestamp;

	public ReTweet() {
	}

	public ReTweet(Integer postID, String username, Timestamp timestamp) {

		this.setPostID(postID);
		this.setUsername(username);
		this.setTimestamp(timestamp);
	}

	public Integer getPostID() {
		return this.postID;
	}

	public void setPostID(Integer postID) {
		this.postID = postID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		StringBuilder retweet = new StringBuilder("ReTweet [id=");

		retweet.append(this.postID);
		retweet.append(", username=");
		retweet.append(this.username);
		retweet.append(", timestamp=");
		retweet.append(this.timestamp);
		retweet.append("]");
		return retweet.toString();
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof ReTweet))
			return false;
		ReTweet retweet = (ReTweet) o;
		return Objects.equals(this.postID, retweet.postID) && Objects.equals(this.username, retweet.username)
				&& Objects.equals(this.timestamp, retweet.timestamp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.postID, this.username, this.timestamp);
	}
}
