package th.mfu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.mfu.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // คุณสามารถเพิ่มเมธอดที่กำหนดเองได้
}

