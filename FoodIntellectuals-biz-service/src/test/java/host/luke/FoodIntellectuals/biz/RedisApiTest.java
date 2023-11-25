package host.luke.FoodIntellectuals.biz;

import host.luke.FoodIntellectuals.redis.api.RedisQueryApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisApiTest {

  @Autowired
  RedisQueryApi redisQueryApi;

  @Test
  public void apiTest() {

  }

}
