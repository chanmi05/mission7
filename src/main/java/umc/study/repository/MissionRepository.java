package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    // 커스텀 쿼리는 필요 시 추가
}
