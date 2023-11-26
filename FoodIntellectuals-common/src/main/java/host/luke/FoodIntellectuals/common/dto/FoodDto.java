package host.luke.FoodIntellectuals.common.dto;

import java.util.List;

public class FoodDto {

  private Long id;
  private Long storeId;
  private String foodName;
  private Double price;
  private String intro;
  private List<String> imgUrlList;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getStoreId() {
    return storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }

  public String getFoodName() {
    return foodName;
  }

  public void setFoodName(String foodName) {
    this.foodName = foodName;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getIntro() {
    return intro;
  }

  public void setIntro(String intro) {
    this.intro = intro;
  }

  public List<String> getImgUrlList() {
    return imgUrlList;
  }

  public void setImgUrlList(List<String> imgUrlList) {
    this.imgUrlList = imgUrlList;
  }
}
