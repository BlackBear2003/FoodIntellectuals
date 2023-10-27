package host.luke.FoodIntellectuals.auth.service;

import host.luke.FoodIntellectuals.auth.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public boolean isUnionIdRegistered(String unionId) {
    return userRepository.existsByUnionIdEquals(unionId);
  }
}
