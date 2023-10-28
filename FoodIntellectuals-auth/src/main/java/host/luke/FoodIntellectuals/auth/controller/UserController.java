package host.luke.FoodIntellectuals.auth.controller;

import host.luke.FoodIntellectuals.auth.entity.User;
import host.luke.FoodIntellectuals.auth.service.QiniuService;
import host.luke.FoodIntellectuals.auth.service.UserService;
import host.luke.FoodIntellectuals.auth.service.WechatService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;
  private final QiniuService qiniuService;
  private final WechatService wechatService;

  public UserController(UserService userService, QiniuService qiniuService,
      WechatService wechatService) {
    this.userService = userService;
    this.qiniuService = qiniuService;
    this.wechatService = wechatService;
  }

  @GetMapping("/unionId/if-registered")
  public ResponseDto<Boolean> isUnionIdRegistered(@RequestParam String unionId) {
    Boolean res = userService.isUnionIdRegistered(unionId);
    return new ResponseDto<>(200, null, res);
  }

  @GetMapping("/unionId")
  public ResponseDto<String> getUnionId(@RequestParam String jsCode) {

    String json = wechatService.getUnionIdByJsCode(jsCode);
    return new ResponseDto<>(200, null, json);
  }

  @GetMapping("")
  public ResponseDto<User> getUserByUnionId(@RequestParam String unionId) {
    User user = userService.findByUnionId(unionId);
    return new ResponseDto<>(200, null, user);
  }

  @PostMapping("")
  public ResponseDto<User> register(@RequestParam String unionId, @RequestParam String username,
      @RequestBody String avatar) {

    if (userService.isUnionIdRegistered(unionId)) {
      return new ResponseDto<>(403, "UnionId has been registered!", null);
    }

    User user = new User();
    user.setUnionId(unionId);
    user.setUsername(username);

    String avatarUrl = qiniuService.uploadImg(avatar);

    if (avatarUrl == null) {
      return new ResponseDto<>(500, "failed to upload", null);
    }

    user.setAvatarUrl(avatarUrl);

    User saved = userService.save(user);
    return new ResponseDto<>(200, null, saved);
  }

}
