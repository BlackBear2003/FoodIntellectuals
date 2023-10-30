package host.luke.FoodIntellectuals.auth.repository;

import host.luke.FoodIntellectuals.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  boolean existsByUnionIdEquals(String unionId);

  User findByUnionId(String unionId);
}
