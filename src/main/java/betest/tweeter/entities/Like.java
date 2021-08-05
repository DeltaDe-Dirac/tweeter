package betest.tweeter.entities;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "likes")
public class Like {

	@Id
	private Integer postID;
	private String username;
	private Timestamp timestamp;

	public Like() {
	}

	public Like(Integer postID, String username, Timestamp timestamp) {

		this.setUsername(username);
		this.setPostID(postID);
		this.setTimestamp(timestamp);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPostID() {
		return postID;
	}

	public void setPostID(Integer postID) {
		this.postID = postID;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		StringBuilder like = new StringBuilder("Like [id=");

		like.append(this.postID);
		like.append(", username=");
		like.append(this.username);
		like.append(", timestamp=");
		like.append(this.timestamp);
		like.append("]");
		return like.toString();
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Like))
			return false;
		Like like = (Like) o;
		return Objects.equals(this.postID, like.postID) && Objects.equals(this.username, like.username)
				&& Objects.equals(this.timestamp, like.timestamp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.postID, this.username, this.timestamp);
	}
}
