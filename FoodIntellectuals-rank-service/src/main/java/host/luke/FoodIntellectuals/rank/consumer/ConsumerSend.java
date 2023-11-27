package host.luke.FoodIntellectuals.rank.consumer;

import com.alibaba.fastjson.JSONObject;
import host.luke.FoodIntellectuals.common.dto.FoodRankItem;
import host.luke.FoodIntellectuals.redis.api.RedisQueryApi;
import host.luke.FoodIntellectuals.redis.api.RedisRecordApi;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

import static host.luke.FoodIntellectuals.common.constant.HotValueConstant.MQ_HOT_VALUE_KEY;


@Service
@Slf4j
@RocketMQMessageListener(topic = "FOOD_HUAHUO_TOPIC", consumerGroup = "Con_Group_Two")
public class ConsumerSend implements RocketMQListener<String> {

  private final RedisRecordApi redisRecordApi;

  public ConsumerSend(RedisRecordApi redisRecordApi) {
    this.redisRecordApi = redisRecordApi;
  }

  public static int randomMultiplyAndRound(int value) {
    Random random = new Random();
    double multiplier = 0.8 + (1.5 - 0.8) * random.nextDouble(); // 生成0.8到1.5之间的随机乘数
    double result = value * multiplier;
    return (int) Math.round(result); // 对乘积进行四舍五入并转换为整数返回
  }

  @Override
  public void onMessage(String str) {
    log.info("ROCKET MQ 收到消息 ==> {}", str);
    FoodRankItem foodRankItem = JSONObject.parseObject(str, FoodRankItem.class);
    try {
      redisRecordApi.addZs(MQ_HOT_VALUE_KEY, foodRankItem, randomMultiplyAndRound(foodRankItem.getValue()));
      log.info("ROCKET MQ 消息消费成功 ==> {}", str);
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
  }
}



