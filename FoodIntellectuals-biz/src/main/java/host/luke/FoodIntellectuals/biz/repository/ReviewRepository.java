package host.luke.FoodIntellectuals.biz.repository;

import host.luke.FoodIntellectuals.common.entity.Review;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

  List<Review> findByStoreId(long storeId, Pageable page);

  List<Review> findByFoodId(long storeId, Pageable page);

  List<Review> findByUserId(long userId, Pageable page);

}
