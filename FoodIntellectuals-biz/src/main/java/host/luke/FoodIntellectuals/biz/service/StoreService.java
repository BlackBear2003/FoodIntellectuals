package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.common.entity.Store;
import java.util.List;

public interface StoreService {

  List<Store> findAll(int page, int size);

  List<Store> findByCanteenId(long canteenId, int page, int size);

  Store findByStoreId(long storeId);

  long countLikeByStoreId(long storeId);

  long countDislikeByStoreId(long storeId);
}
