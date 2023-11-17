package host.luke.FoodIntellectuals.auth.controller;

import host.luke.FoodIntellectuals.common.entity.User;
import host.luke.FoodIntellectuals.auth.entity.dto.GetUnionIdDTO;
import host.luke.FoodIntellectuals.auth.entity.vo.RegisterUserVO;
import host.luke.FoodIntellectuals.auth.service.QiniuService;
import host.luke.FoodIntellectuals.auth.service.UserService;
import host.luke.FoodIntellectuals.auth.service.WechatService;
import host.luke.FoodIntellectuals.common.dto.ResponseDTO;
import java.util.Objects;
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
  public ResponseDTO<Boolean> isUnionIdRegistered(@RequestParam String unionId) {
    Boolean res = userService.isUnionIdRegistered(unionId);
    return new ResponseDTO<>(200, null, res);
  }

  @GetMapping("/unionId")
  public ResponseDTO<GetUnionIdDTO> getUnionId(@RequestParam String jsCode) {

    GetUnionIdDTO res = wechatService.getUnionIdByJsCode(jsCode);
    return new ResponseDTO<>(200, null, res);
  }

  @GetMapping("")
  public ResponseDTO<User> getUserByUnionId(@RequestParam String unionId) {
    User user = userService.findByUnionId(unionId);
    if (Objects.isNull(user)) {
      return new ResponseDTO<>(404, "not such user", null);
    }
    return new ResponseDTO<>(200, null, user);
  }

  @PostMapping("")
  public ResponseDTO<User> register(@RequestBody RegisterUserVO registerUserVO) {

    if (userService.isUnionIdRegistered(registerUserVO.getUnionId())) {
      return new ResponseDTO<>(403, "UnionId has been registered!", null);
    }

    User user = new User();
    user.setUnionId(registerUserVO.getUnionId());
    user.setUsername(registerUserVO.getUsername());

    String avatarUrl = qiniuService.uploadImg(registerUserVO.getAvatarBase64());

    if (avatarUrl == null) {
      return new ResponseDTO<>(500, "failed to upload", null);
    }

    user.setAvatarUrl(avatarUrl);

    User saved = userService.save(user);
    return new ResponseDTO<>(200, null, saved);
  }

}
