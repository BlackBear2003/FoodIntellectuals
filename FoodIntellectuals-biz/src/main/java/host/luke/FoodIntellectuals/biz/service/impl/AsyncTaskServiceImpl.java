package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.service.AsyncTaskService;
import host.luke.FoodIntellectuals.biz.tasks.AddHotDotTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;

@Service
public class AsyncTaskServiceImpl implements AsyncTaskService {
  private final Executor executor;

  public AsyncTaskServiceImpl(@Qualifier("asyncServiceExecutor") Executor executor) {
    this.executor = executor;
  }

  @Override
  public void addHotValue(Long foodId) {
    AddHotDotTask task = new AddHotDotTask();
    executor.execute(task);
  }
}
