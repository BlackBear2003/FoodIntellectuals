package host.luke.FoodIntellectuals.auth.service;

import host.luke.FoodIntellectuals.common.entity.User;
import host.luke.FoodIntellectuals.auth.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public boolean isUnionIdRegistered(String unionId) {
    return userRepository.existsByUnionIdEquals(unionId);
  }

  public User findByUnionId(String unionId) {
    return userRepository.findByUnionId(unionId);
  }

  public User save(User user) {
    return userRepository.save(user);
  }
}
