package host.luke.FoodIntellectuals.biz.vo;

import host.luke.FoodIntellectuals.biz.entity.Food;

public class FoodVo extends Food {
  private String imgUrl;

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }
}
