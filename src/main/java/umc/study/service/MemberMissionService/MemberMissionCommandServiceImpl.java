package umc.study.service.MemberMissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.GeneralException;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.repository.MemberMissionRepository;
import umc.study.web.dto.MemberMissionRequestDTO;
import umc.study.web.dto.MemberMissionResponseDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public MemberMissionResponseDTO.CreateMissionResultDto challengeMission(MemberMissionRequestDTO.CreateMissionDto request) {

        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        // 중복 도전 검증은 커스텀 어노테이션으로 따로 처리됨

        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();

        MemberMission saved = memberMissionRepository.save(memberMission);
        return MemberMissionConverter.toCreateResultDTO(saved);
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

