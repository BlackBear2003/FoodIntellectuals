package host.luke.FoodIntellectuals.common.dto;



import java.io.Serializable;


public class FoodRankItem implements Serializable {
   private Long id;
   private Integer value;
   private String url;
   private String foodName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public String getUrl() {
    return url;
  }

  public String getFoodName() {
    return foodName;
  }

  public void setFoodName(String foodName) {
    this.foodName = foodName;
  }

  public void setUrl(String url) {
    this.url = url;
  }



}
