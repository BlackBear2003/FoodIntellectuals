package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.repository.CanteenRepository;
import host.luke.FoodIntellectuals.biz.service.CanteenService;
import host.luke.FoodIntellectuals.common.entity.Canteen;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CanteenServiceImpl implements CanteenService {

  private final CanteenRepository canteenRepository;

  public CanteenServiceImpl(CanteenRepository canteenRepository) {
    this.canteenRepository = canteenRepository;
  }

  @Override
  public List<Canteen> findAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return canteenRepository.findAll(pageable).getContent();
  }
}
