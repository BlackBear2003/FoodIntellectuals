package host.luke.FoodIntellectuals.common;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackageClasses = FoodIntellectualsCommonConfig.class)
public class FoodIntellectualsCommonConfig {

}
