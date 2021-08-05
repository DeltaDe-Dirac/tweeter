package betest.tweeter.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import betest.tweeter.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Integer> {
	
}

