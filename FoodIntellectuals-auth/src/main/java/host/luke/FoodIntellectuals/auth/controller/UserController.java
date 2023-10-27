package host.luke.FoodIntellectuals.auth.controller;

import host.luke.FoodIntellectuals.auth.service.UserService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/unionId/if-registered")
  public ResponseDto<Boolean> isUnionIdRegistered(String unionId) {
    Boolean res = userService.isUnionIdRegistered(unionId);
    // Boolean res = true;
    return new ResponseDto<>(200, null, res);
  }

}
