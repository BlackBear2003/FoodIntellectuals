package host.luke.FoodIntellectuals.biz.service.impl;

import cn.hutool.core.bean.BeanUtil;
import host.luke.FoodIntellectuals.biz.entity.Food;
import host.luke.FoodIntellectuals.biz.repository.FoodRepository;
import host.luke.FoodIntellectuals.biz.service.FoodService;
import host.luke.FoodIntellectuals.biz.service.ImageService;
import host.luke.FoodIntellectuals.common.constant.ImageType;
import host.luke.FoodIntellectuals.common.dto.FoodDto;
import java.util.ArrayList;
import java.util.List;
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
    return foodListToFoodDtoList(foodList);
  }

  @Override
  public List<FoodDto> findByStoreId(long storeId, int page, int size) {

    List<Food> foodList = foodRepository.findByStoreId(storeId, PageRequest.of(page, size));
    return foodListToFoodDtoList(foodList);
  }

  @Override
  public FoodDto findByFoodId(long foodId) {
    Food food = foodRepository.findById(foodId).orElse(new Food());
    return foodToFoodDto(food);
  }

  private List<FoodDto> foodListToFoodDtoList(List<Food> foodList) {
    List<FoodDto> dtoList = new ArrayList<>();
    for (Food f : foodList) {
      dtoList.add(foodToFoodDto(f));
    }
    return dtoList;
  }

  private FoodDto foodToFoodDto(Food food) {
    List<String> images = imageService.findByBelongTypeAndId(ImageType.Food.name(),
        food.getId());
    FoodDto dto = new FoodDto();
    BeanUtil.copyProperties(food, dto);
    dto.setImages(images);

    return dto;
  }
}
