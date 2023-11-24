package host.luke.FoodIntellectuals.auth;

import host.luke.FoodIntellectuals.common.FoodIntellectualsCommonConfig;
import host.luke.FoodIntellectuals.oss.FoodIntellectualsOssConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {FoodIntellectualsCommonConfig.class,
    FoodIntellectualsAuthApplication.class, FoodIntellectualsOssConfig.class})
public class FoodIntellectualsAuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(FoodIntellectualsAuthApplication.class, args);
  }
}
