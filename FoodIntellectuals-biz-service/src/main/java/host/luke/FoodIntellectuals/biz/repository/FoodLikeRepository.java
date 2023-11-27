package host.luke.FoodIntellectuals.biz.repository;

import host.luke.FoodIntellectuals.biz.entity.FoodLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodLikeRepository extends JpaRepository<FoodLike, Long> {
}
