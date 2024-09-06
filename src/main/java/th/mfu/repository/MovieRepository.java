package th.mfu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.mfu.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}

