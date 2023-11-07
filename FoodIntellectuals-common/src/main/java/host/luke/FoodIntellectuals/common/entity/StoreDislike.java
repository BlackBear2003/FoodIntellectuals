package host.luke.FoodIntellectuals.common.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StoreDislike")
public class StoreDislike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long storeId;
    private Long userId;

    public StoreDislike() {
    }

    public StoreDislike(Long id, Long storeId, Long userId) {
        this.id = id;
        this.storeId = storeId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public Long getUserId() {
        return userId;
    }
}
