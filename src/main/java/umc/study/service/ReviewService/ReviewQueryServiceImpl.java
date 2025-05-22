package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.repository.ReviewRepository;
import umc.study.web.dto.ReviewResponseDTO;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public ReviewResponseDTO.MyReviewPreviewListDTO getReviewListByMember(Member member, int page) {

        PageRequest pageable = PageRequest.of(page, 10); // 한 페이지당 10개
        Page<Review> reviewPage = reviewRepository.findAllByMember(member, pageable);

        return ReviewConverter.toMyReviewPreviewListDTO(reviewPage);
    }
}
