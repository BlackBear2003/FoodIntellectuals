package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.repository.StoreRepository;
import host.luke.FoodIntellectuals.biz.service.StoreService;
import host.luke.FoodIntellectuals.biz.entity.Store;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

  private final StoreRepository storeRepository;

  public StoreServiceImpl(StoreRepository storeRepository) {
    this.storeRepository = storeRepository;
  }

  @Override
  public List<Store> findAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return storeRepository.findAll(pageable).getContent();
  }

  @Override
  public List<Store> findByCanteenId(long canteenId, int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return storeRepository.findByCanteenId(canteenId, pageable);
  }

  @Override
  public Store findByStoreId(long storeId) {
    return storeRepository.findById(storeId).orElse(null);
  }

  @Override
  public long countLikeByStoreId(long storeId) {
    return 0;
  }

  @Override
  public long countDislikeByStoreId(long storeId) {
    return 0;
  }
}
