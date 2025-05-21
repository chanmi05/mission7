package umc.study.service.ReviewService;

import umc.study.domain.Member;
import umc.study.web.dto.ReviewResponseDTO;

public interface ReviewQueryService {

    ReviewResponseDTO.MyReviewPreviewListDTO getReviewListByMember(Member member, int page);
}
