package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.repository.ImageRepository;
import host.luke.FoodIntellectuals.biz.service.AsyncTaskService;
import host.luke.FoodIntellectuals.biz.tasks.AddHotDotTask;
import host.luke.FoodIntellectuals.biz.entity.Food;
import host.luke.FoodIntellectuals.common.dto.FoodDto;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Executor;

@Service
public class AsyncTaskServiceImpl implements AsyncTaskService {
  private final Executor executor;
  @Autowired
  ImageRepository imageRepository;
  @Autowired
  RocketMQTemplate rocketMQTemplate;

  public AsyncTaskServiceImpl(@Qualifier("asyncServiceExecutor") Executor executor) {
    this.executor = executor;
  }

  @Override
  public void addHotValue(FoodDto food, Integer value) {
    AddHotDotTask addHotDotTask = new AddHotDotTask(food, value, rocketMQTemplate, imageRepository);
    executor.execute(addHotDotTask);
  }

  @Override
  public void addHotValue(List<FoodDto> foodList, Integer value) {

  }
}
