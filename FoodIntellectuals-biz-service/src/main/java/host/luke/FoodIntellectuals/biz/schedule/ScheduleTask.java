package host.luke.FoodIntellectuals.biz.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@EnableScheduling
@Configuration
public class ScheduleTask {

  @Scheduled(cron = "0/30 * * * * ?")
  void synchronizedRedisLike() {

  }


}
