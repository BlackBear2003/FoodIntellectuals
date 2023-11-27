package host.luke.FoodIntellectuals.rank.service.impl;

import host.luke.FoodIntellectuals.biz.entity.Food;
import host.luke.FoodIntellectuals.biz.entity.Image;
import host.luke.FoodIntellectuals.biz.repository.FoodRepository;
import host.luke.FoodIntellectuals.biz.repository.ImageRepository;
import host.luke.FoodIntellectuals.common.dto.FoodRankItem;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.rank.service.RankService;
import host.luke.FoodIntellectuals.redis.api.RedisQueryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static host.luke.FoodIntellectuals.common.constant.HotValueConstant.MQ_HOT_VALUE_KEY;

@Service
public class RankServiceImpl implements RankService {
  private final FoodRepository foodRepository;
  private final RedisQueryApi redisQueryApi;
  private final ImageRepository imageRepository;

  public RankServiceImpl(RedisQueryApi redisQueryApi, FoodRepository foodRepository, ImageRepository imageRepository) {
    this.redisQueryApi = redisQueryApi;
    this.foodRepository = foodRepository;
    this.imageRepository = imageRepository;
  }

  @Override
  public ResponseDto<List<FoodRankItem>> getRankListByHotValue() {
    return ResponseDto.success(redisQueryApi.getTopFoodHotRank());
  }

  @Override
  public ResponseDto<List<FoodRankItem>> getRankListByLikeNum() {
    List<Food> topList = foodRepository.findTop10ByOrderByLikeNumDesc();
    List<FoodRankItem> itemList = new ArrayList<>();
    for (Food food : topList) {
      FoodRankItem foodRankItem = new FoodRankItem();
      Image foodImg = imageRepository.findImageByBelongIdAndAndBelongType(food.getId(), "Food");
      foodRankItem.setFoodName(food.getFoodName());
      foodRankItem.setValue(food.getLikeNum());
      foodRankItem.setId(food.getId());
      foodRankItem.setUrl(foodImg.getUrl());
      itemList.add(foodRankItem);
    }
    return ResponseDto.success(itemList);
  }
}
