package betest.tweeter.entities;

public class TweetNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 5104318650578009457L;

	public TweetNotFoundException(Integer id) {
		super("Could not find tweet with id: " + id);
	}
}