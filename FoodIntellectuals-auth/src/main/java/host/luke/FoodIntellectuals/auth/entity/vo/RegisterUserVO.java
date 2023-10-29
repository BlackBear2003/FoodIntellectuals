package host.luke.FoodIntellectuals.auth.entity.vo;

public class RegisterUserVO {

  private String unionId;
  private String username;
  private String avatarBase64;

  public RegisterUserVO() {
  }

  public RegisterUserVO(String unionId, String username, String avatarBase64) {
    this.unionId = unionId;
    this.username = username;
    this.avatarBase64 = avatarBase64;
  }

  public String getUnionId() {
    return unionId;
  }

  public void setUnionId(String unionId) {
    this.unionId = unionId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getAvatarBase64() {
    return avatarBase64;
  }

  public void setAvatarBase64(String avatarBase64) {
    this.avatarBase64 = avatarBase64;
  }
}
