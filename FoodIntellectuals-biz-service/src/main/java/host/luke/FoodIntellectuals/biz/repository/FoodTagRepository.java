package host.luke.FoodIntellectuals.biz.repository;

import host.luke.FoodIntellectuals.biz.entity.FoodTag;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FoodTagRepository extends JpaRepository<FoodTag, Long> {

  List<FoodTag> findByFoodId(long foodId);

  List<FoodTag> findByTagId(long tagId);

  @Query("SELECT DISTINCT ft.foodId FROM FoodTag ft WHERE ft.tagId IN :tagIds")
  List<Long> findDistinctFoodIdByTagIds(@Param("tagIds") List<Long> tagIds);
}
