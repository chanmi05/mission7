package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    // 특정 memberId, missionId 조합으로 도전 여부 조회
    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
}
