package host.luke.FoodIntellectuals.biz;

import host.luke.FoodIntellectuals.biz.config.ExecutorConfig;
import host.luke.FoodIntellectuals.biz.tasks.AddHotDotTask;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Executor;

@SpringBootTest
public class TaskTest {
  @Autowired
  @Qualifier("asyncServiceExecutor")
  Executor executor;

  @Test
  void testTask() {
    AddHotDotTask addHotDotTask = new AddHotDotTask();
    executor.execute(addHotDotTask);
  }
}
