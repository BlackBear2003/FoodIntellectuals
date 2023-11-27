package host.luke.FoodIntellectuals.biz.util;

import cn.hutool.core.bean.BeanUtil;
import host.luke.FoodIntellectuals.biz.entity.Food;
import host.luke.FoodIntellectuals.biz.entity.FoodComment;
import host.luke.FoodIntellectuals.biz.entity.Review;
import host.luke.FoodIntellectuals.biz.entity.User;
import host.luke.FoodIntellectuals.common.dto.FoodCommentDto;
import host.luke.FoodIntellectuals.common.dto.FoodDto;
import host.luke.FoodIntellectuals.common.dto.ReviewDto;
import java.util.List;

public class DtoUtil {

  public static FoodDto foodToFoodDto(Food food, List<String> imgUrlList) {
    FoodDto dto = new FoodDto();
    BeanUtil.copyProperties(food, dto);
    dto.setImgUrlList(imgUrlList);
    return dto;
  }

  public static ReviewDto reviewToReviewDto(Review review, List<String> imgUrlList) {
    ReviewDto dto = new ReviewDto();
    BeanUtil.copyProperties(review, dto);
    dto.setImgUrlList(imgUrlList);
    return dto;
  }


  public static FoodCommentDto commentToDto(FoodComment comment, User user) {
    FoodCommentDto dto = new FoodCommentDto();
    BeanUtil.copyProperties(comment, dto);
    dto.setUsername(user.getUsername());
    dto.setAvatarUrl(user.getAvatarUrl());
    dto.setUnionId(user.getUnionId());
    return dto;
  }

}
