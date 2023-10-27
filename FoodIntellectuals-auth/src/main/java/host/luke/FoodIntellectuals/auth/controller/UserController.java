package host.luke.FoodIntellectuals.auth.controller;

import host.luke.FoodIntellectuals.auth.entity.User;
import host.luke.FoodIntellectuals.auth.service.QiniuService;
import host.luke.FoodIntellectuals.auth.service.UserService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;
  private final QiniuService qiniuService;

  public UserController(UserService userService, QiniuService qiniuService) {
    this.userService = userService;
    this.qiniuService = qiniuService;
  }

  @GetMapping("/unionId/if-registered")
  public ResponseDto<Boolean> isUnionIdRegistered(String unionId) {
    Boolean res = userService.isUnionIdRegistered(unionId);
    return new ResponseDto<>(200, null, res);
  }

  @GetMapping("")
  public ResponseDto<User> getUserByUnionId(String unionId) {
    User user = userService.findByUnionId(unionId);
    return new ResponseDto<>(200, null, user);
  }

  @PostMapping("")
  public ResponseDto<User> register(String unionId, String username, String avatar) {
    User user = new User();
    user.setUnionId(unionId);
    user.setUsername(username);


    String avatarKey = qiniuService.uploadImg(avatar);

    if (avatarKey == null) {
      return new ResponseDto<>(500, "failed to upload", null);
    }

    String avatarUrl = "http://s36ic8bmr.hn-bkt.clouddn.com/" + avatarKey;
    user.setAvatarUrl(avatarUrl);

    User saved = userService.save(user);
    return new ResponseDto<>(200, null, saved);
  }

}
