package umc.study.service.MemberMissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.exception.handler.GeneralException;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.web.dto.MemberMissionResponseDTO;
import umc.study.apiPayload.code.status.ErrorStatus;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMissionResponseDTO.ChallengingMissionListDTO getChallengingMissions(Member member, int page) {

        PageRequest pageable = PageRequest.of(page, 10);

        Page<MemberMission> missionPage = memberMissionRepository.findAllByMemberAndStatus(
                member,
                MissionStatus.CHALLENGING,
                pageable
        );

        return MemberMissionConverter.toChallengingMissionListDTO(missionPage);
    }

    @Override
    @Transactional
    public MemberMissionResponseDTO.CompleteMissionResultDTO completeMission(Long memberMissionId) {

        MemberMission memberMission = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_MISSION_NOT_FOUND));

        if (memberMission.getStatus() == MissionStatus.COMPLETE) {
            throw new GeneralException(ErrorStatus.MEMBER_MISSION_ALREADY_COMPLETED);
        }

        memberMission.setStatus(MissionStatus.COMPLETE);

        return MemberMissionConverter.toCompleteMissionResultDTO(memberMission);
    }
}
