package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
    // 필요 시 커스텀 쿼리 작성 가능
}
