package betest.tweeter.entities;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tweets")
public class Tweet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	private String textContent;
	private String username;
	private Timestamp timestamp;
	
	@OneToMany(mappedBy = "postID")
    private List<Like> likes;

	public Tweet() {
	}

	public Tweet(String textContent, String username, Timestamp timestamp) {

		this.setTextContent(textContent);
		this.setUsername(username);
		this.setTimestamp(timestamp);
	}

	
	
	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
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
		StringBuilder tweet = new StringBuilder("Tweet [id=");
		
		tweet.append(this.id);
		tweet.append(", username=");		
		tweet.append(this.username);
		tweet.append(", content=");
		tweet.append(this.textContent);
		tweet.append(", timestamp=");
		tweet.append(this.timestamp);
		tweet.append("]");
		return tweet.toString();
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Tweet))
			return false;
		Tweet tweet = (Tweet) o;
		return Objects.equals(this.id, tweet.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}
}

