package host.luke.FoodIntellectuals.biz.tasks;

public class AddHotDotTask implements Runnable {
  private Integer hotValue;
  private Long foodId;
  @Override
  public void run() {
    System.out.println("run run run");
    //sendMQ
  }
}
