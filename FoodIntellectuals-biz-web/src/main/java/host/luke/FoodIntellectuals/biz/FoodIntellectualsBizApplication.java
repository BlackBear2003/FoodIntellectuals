package host.luke.FoodIntellectuals.biz;

import host.luke.FoodIntellectuals.common.FoodIntellectualsCommonConfig;
import host.luke.FoodIntellectuals.oss.FoodIntellectualsOssConfig;
import host.luke.FoodIntellectuals.rank.RankServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {FoodIntellectualsBizApplication.class,
    FoodIntellectualsCommonConfig.class, FoodIntellectualsOssConfig.class, RankServiceConfig.class})
public class FoodIntellectualsBizApplication {

  public static void main(String[] args) {
    SpringApplication.run(FoodIntellectualsBizApplication.class, args);
  }

}
