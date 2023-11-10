package host.luke.FoodIntellectuals.common.vo;

public class ImageVO {

  private String base64;
  private String belongType;
  private Long belongId;

  public ImageVO() {
  }

  public ImageVO(String base64, String belongType, Long belongId) {
    this.base64 = base64;
    this.belongType = belongType;
    this.belongId = belongId;
  }

  public String getBase64() {
    return base64;
  }

  public void setBase64(String base64) {
    this.base64 = base64;
  }

  public String getBelongType() {
    return belongType;
  }

  public void setBelongType(String belongType) {
    this.belongType = belongType;
  }

  public Long getBelongId() {
    return belongId;
  }

  public void setBelongId(Long belongId) {
    this.belongId = belongId;
  }
}
