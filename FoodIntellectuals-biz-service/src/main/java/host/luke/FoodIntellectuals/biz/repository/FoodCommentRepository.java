package host.luke.FoodIntellectuals.biz.repository;

import host.luke.FoodIntellectuals.biz.entity.FoodComment;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCommentRepository extends JpaRepository<FoodComment, Long> {

  List<FoodComment> findByFoodIdOrderByCommentTimeDesc(Long foodId, Pageable pageable);

}
