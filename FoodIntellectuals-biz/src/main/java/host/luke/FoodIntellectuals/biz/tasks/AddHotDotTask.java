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


@EnableAsync
public class AddHotDotTask implements Runnable {
  private FoodRankItem foodRankItem;
  private Integer value;
  private Food food;
  private final RocketMQTemplate rocketmqTemplate;
  private final ImageRepository imageRepository;
  void handleData() {
    Image image = imageRepository.findImageByBelongIdAndAndBelongType(food.getId(), "Food");
    String url = image.getUrl();
    foodRankItem.setId(food.getId());
    foodRankItem.setUrl(url);
    foodRankItem.setValue(value);
    foodRankItem.setFoodName(food.getFoodName());
  }
  public AddHotDotTask(Food food, Integer value, RocketMQTemplate rocketmqTemplate, ImageRepository imageRepository) {
    this.food = food;
    this.value = value;
    this.rocketmqTemplate = rocketmqTemplate;
    this.imageRepository = imageRepository;
    foodRankItem = new FoodRankItem();
  }
  private static final String topic = "FOOD_HUAHUO_TOPIC";
  @Override
  public void run() {
    handleData();
    String jsonString = JSONObject.toJSONString(foodRankItem);
    Message<String> msg = MessageBuilder.withPayload(jsonString).build();
    rocketmqTemplate.send(topic, msg);
  }
}
