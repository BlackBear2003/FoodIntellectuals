package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.entity.Food;
import host.luke.FoodIntellectuals.biz.entity.Image;
import host.luke.FoodIntellectuals.biz.repository.FoodRepository;
import host.luke.FoodIntellectuals.biz.service.FoodService;
import host.luke.FoodIntellectuals.biz.service.ImageService;
import host.luke.FoodIntellectuals.biz.util.DtoUtil;
import host.luke.FoodIntellectuals.common.dto.FoodDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

  private final FoodRepository foodRepository;
  private final ImageService imageService;

  public FoodServiceImpl(FoodRepository foodRepository, ImageService imageService) {
    this.foodRepository = foodRepository;
    this.imageService = imageService;
  }

  @Override
  public List<FoodDto> findAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    List<Food> foodList = foodRepository.findAll(pageable).getContent();
    return foodList.stream().map(food -> DtoUtil.foodToFoodDto(food,
            imageService.findUrlListByBelongTypeAndId("Food", food.getId())))
        .collect(Collectors.toList());
  }

  @Override
  public List<FoodDto> findByStoreId(long storeId, int page, int size) {

    List<Food> foodList = foodRepository.findByStoreId(storeId, PageRequest.of(page, size));
    return foodList.stream().map(food -> DtoUtil.foodToFoodDto(food,
            imageService.findUrlListByBelongTypeAndId("Food", food.getId())))
        .collect(Collectors.toList());
  }

  @Override
  public FoodDto findByFoodId(long foodId) {
    Food food = foodRepository.findById(foodId).orElse(new Food());

    return DtoUtil.foodToFoodDto(food,
        imageService.findUrlListByBelongTypeAndId("Food", food.getId()));
  }

}
