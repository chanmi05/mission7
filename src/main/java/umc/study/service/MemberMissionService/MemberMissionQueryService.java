package umc.study.service.MemberMissionService;

import umc.study.domain.Member;
import umc.study.web.dto.MemberMissionResponseDTO;

public interface MemberMissionQueryService {

    MemberMissionResponseDTO.ChallengingMissionListDTO getChallengingMissions(Member member, int page);
    MemberMissionResponseDTO.CompleteMissionResultDTO completeMission(Long memberMissionId);
}
