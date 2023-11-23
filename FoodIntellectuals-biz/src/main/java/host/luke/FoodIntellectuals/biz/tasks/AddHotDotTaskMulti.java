package host.luke.FoodIntellectuals.biz.tasks;

import com.alibaba.fastjson.JSONObject;
import host.luke.FoodIntellectuals.biz.pojo.FoodRankItem;
import host.luke.FoodIntellectuals.biz.repository.ImageRepository;
import host.luke.FoodIntellectuals.common.entity.Food;
import host.luke.FoodIntellectuals.common.entity.Image;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ArrayList;
import java.util.List;

@EnableAsync
public class AddHotDotTaskMulti implements Runnable {
  private List<FoodRankItem> foodRankItems;
  private Integer value;
  private List<Food> foods;
  private final RocketMQTemplate rocketmqTemplate;
  private final ImageRepository imageRepository;

  void handleData() {
    for (Food food : foods) {
      FoodRankItem foodRankItem = new FoodRankItem();
      Image image = imageRepository.findImageByBelongIdAndAndBelongType(food.getId(), "Food");
      String url = image.getUrl();
      foodRankItem.setId(food.getId());
      foodRankItem.setUrl(url);
      foodRankItem.setValue(value);
      foodRankItem.setFoodName(food.getFoodName());
      foodRankItems.add(foodRankItem);
    }
  }

  public AddHotDotTaskMulti(List<Food> foods, Integer value, RocketMQTemplate rocketmqTemplate, ImageRepository imageRepository) {
    foodRankItems = new ArrayList<>();
    this.foods = foods;
    this.value = value;
    this.rocketmqTemplate = rocketmqTemplate;
    this.imageRepository = imageRepository;
  }

  private static final String topic = "FOOD_HUAHUO_TOPIC";


  @Override
  public void run() {
    handleData();
    for (FoodRankItem foodRankItem : foodRankItems) {
      String jsonString = JSONObject.toJSONString(foodRankItem);
      Message<String> msg = MessageBuilder.withPayload(jsonString).build();
      rocketmqTemplate.send(topic, msg);
    }

  }

}
