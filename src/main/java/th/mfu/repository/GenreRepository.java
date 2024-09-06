package th.mfu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.mfu.domain.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    // คุณสามารถเพิ่มเมธอดที่กำหนดเองได้
}

