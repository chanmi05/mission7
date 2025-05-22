package umc.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.web.dto.MemberMissionResponseDTO;

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
}
