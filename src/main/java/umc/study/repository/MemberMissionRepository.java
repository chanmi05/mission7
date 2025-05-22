package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    // 특정 memberId, missionId 조합으로 도전 여부 조회
    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);

    // 특정 멤버가 CHALLENGING 상태인 미션만 페이징 조회
    Page<MemberMission> findAllByMemberAndStatus(Member member, MissionStatus status, Pageable pageable);
}
