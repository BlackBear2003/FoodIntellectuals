package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.entity.FoodComment;
import host.luke.FoodIntellectuals.biz.entity.User;
import host.luke.FoodIntellectuals.biz.repository.FoodCommentRepository;
import host.luke.FoodIntellectuals.biz.repository.UserRepository;
import host.luke.FoodIntellectuals.biz.service.AsyncTaskService;
import host.luke.FoodIntellectuals.biz.service.FoodCommentService;
import host.luke.FoodIntellectuals.biz.util.DtoUtil;
import host.luke.FoodIntellectuals.common.dto.FoodCommentDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class FoodCommentServiceImpl implements FoodCommentService {

  private final FoodCommentRepository foodCommentRepository;
  private final UserRepository userRepository;
  private final AsyncTaskService asyncTaskService;

  public FoodCommentServiceImpl(FoodCommentRepository foodCommentRepository,
      UserRepository userRepository, AsyncTaskService asyncTaskService) {
    this.foodCommentRepository = foodCommentRepository;
    this.userRepository = userRepository;
    this.asyncTaskService = asyncTaskService;
  }

  @Override
  public FoodCommentDto save(FoodComment comment) {
    FoodComment save = foodCommentRepository.save(comment);
    User user = userRepository.findById(comment.getUserId()).orElse(new User());

    return DtoUtil.commentToDto(save, user);
  }

  @Override
  public List<FoodCommentDto> findByFoodId(long foodId, int page, int size) {
    return foodCommentRepository.findByFoodIdOrderByCommentTimeDesc(foodId,
            PageRequest.of(page, size)).stream()
        .map(fc -> DtoUtil.commentToDto(fc, userRepository.findById(fc.getUserId()).orElse(new User())))
        .collect(Collectors.toList());
  }

  @Override
  public FoodCommentDto findById(long id) {
    FoodComment fc = foodCommentRepository.findById(id).orElse(new FoodComment());
    return DtoUtil.commentToDto(fc, userRepository.findById(fc.getUserId()).orElse(new User()));
  }
}
