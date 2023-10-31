package host.luke.FoodIntellectuals.common.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Canteen")
public class Canteen {
    @Id
    private Long id;
    private String canteenName;
    private String intro;

    public Canteen() {
    }

    public Canteen(long id, String canteenName, String intro) {
        this.id = id;
        this.canteenName = canteenName;
        this.intro = intro;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCanteenName() {
        return canteenName;
    }

    public void setCanteenName(String canteenName) {
        this.canteenName = canteenName;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
