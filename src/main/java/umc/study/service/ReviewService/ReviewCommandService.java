package umc.study.service.ReviewService;

import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

public interface ReviewCommandService {
    ReviewResponseDTO.CreateResultDto createReview(Long storeId, ReviewRequestDTO.CreateDto request);
}

