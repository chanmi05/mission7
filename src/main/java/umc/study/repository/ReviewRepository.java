package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // 필요 시 커스텀 쿼리도 여기에 추가 가능
}
