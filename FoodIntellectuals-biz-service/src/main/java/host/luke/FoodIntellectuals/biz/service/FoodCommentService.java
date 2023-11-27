package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.biz.entity.FoodComment;
import host.luke.FoodIntellectuals.common.dto.FoodCommentDto;
import java.util.List;

public interface FoodCommentService {

  FoodCommentDto save(FoodComment comment);

  List<FoodCommentDto> findByFoodId(long foodId, int page, int size);

  FoodCommentDto findById(long id);

}
