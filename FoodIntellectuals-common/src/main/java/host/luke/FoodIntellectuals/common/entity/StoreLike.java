package host.luke.FoodIntellectuals.common.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StoreLike")
public class StoreLike {
    @Id
    private Long id;
    private Long storeId;
    private Long userId;

    public StoreLike() {
    }

    public StoreLike(Long id, Long storeId, Long userId) {
        this.id = id;
        this.storeId = storeId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
