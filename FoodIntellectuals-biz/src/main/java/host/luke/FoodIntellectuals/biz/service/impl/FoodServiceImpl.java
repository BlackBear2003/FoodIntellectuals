package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.repository.FoodRepository;
import host.luke.FoodIntellectuals.biz.service.FoodService;
import host.luke.FoodIntellectuals.common.entity.Food;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

  private final FoodRepository foodRepository;

  public FoodServiceImpl(FoodRepository foodRepository) {
    this.foodRepository = foodRepository;
  }

  @Override
  public List<Food> findAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return foodRepository.findAll(pageable).getContent();
  }

  @Override
  public List<Food> findByStoreId(long storeId, int page, int size) {
    return foodRepository.findByStoreId(storeId, PageRequest.of(page, size));
  }

  @Override
  public Food findByFoodId(long foodId) {
    return foodRepository.getById(foodId);
  }
}
