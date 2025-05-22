package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Mission;
import umc.study.domain.Store;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    // 특정 가게의 미션들을 페이징으로 조회
    Page<Mission> findAllByStore(Store store, Pageable pageable);
}
