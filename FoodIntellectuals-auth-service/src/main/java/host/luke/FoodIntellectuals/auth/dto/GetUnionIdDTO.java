package host.luke.FoodIntellectuals.auth.dto;

public class GetUnionIdDTO {

  private String errcode;
  private String errmsg;
  private String openid;
  private String unionid;
  private String sessionKey;

  public GetUnionIdDTO() {
  }

  public GetUnionIdDTO(String errcode, String errmsg, String openid, String unionid,
      String sessionKey) {
    this.errcode = errcode;
    this.errmsg = errmsg;
    this.openid = openid;
    this.unionid = unionid;
    this.sessionKey = sessionKey;
  }

  public String getErrcode() {
    return errcode;
  }

  public void setErrcode(String errcode) {
    this.errcode = errcode;
  }

  public String getErrmsg() {
    return errmsg;
  }

  public void setErrmsg(String errmsg) {
    this.errmsg = errmsg;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getUnionid() {
    return unionid;
  }

  public void setUnionid(String unionid) {
    this.unionid = unionid;
  }

  public String getSessionKey() {
    return sessionKey;
  }

  public void setSessionKey(String sessionKey) {
    this.sessionKey = sessionKey;
  }
}
