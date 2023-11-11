package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.service.StoreService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.common.entity.Store;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController {

  private final StoreService storeService;

  public StoreController(StoreService storeService) {
    this.storeService = storeService;
  }

  @GetMapping("/findAll")
  public ResponseDto<List<Store>> findAll(int page, int size) {
    return new ResponseDto<>(200, null, storeService.findAll(page, size));
  }

  @GetMapping("/findByCanteenId")
  public ResponseDto<List<Store>> findByCanteenId(long canteenId, int page, int size) {
    return new ResponseDto<>(200, null, storeService.findByCanteenId(canteenId, page, size));
  }

  @GetMapping("/findByStoreId")
  public ResponseDto<Store> findByStoreId(long storeId) {
    return new ResponseDto<>(200, null, storeService.findByStoreId(storeId));
  }

  @GetMapping("/countLikeByStoreId")
  public ResponseDto<Long> countLikeByStoreId(long storeId) {
    return new ResponseDto<>(200, null, storeService.countLikeByStoreId(storeId));
  }

  @GetMapping("/countDislikeByStoreId")
  public ResponseDto<Long> countDislikeByStoreId(long storeId) {
    return new ResponseDto<>(200, null, storeService.countDislikeByStoreId(storeId));
  }
}
