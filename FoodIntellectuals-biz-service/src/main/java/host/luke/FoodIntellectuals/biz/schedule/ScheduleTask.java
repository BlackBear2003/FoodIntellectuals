package host.luke.FoodIntellectuals.biz.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.sql.SQLException;

@EnableScheduling
@Configuration
public class ScheduleTask {

  @Scheduled(cron = " 0 0 12 * * ?")
  void synchronizedRedisLike() {

  }


}
