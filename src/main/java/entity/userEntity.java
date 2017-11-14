package entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by yangp on 2017/11/14.
 */
@Entity
@Table(name="c_user")
public class userEntity {

    private Long id;
    private String name;
    private Long age;
    private String cupsizt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getCupsizt() {
        return cupsizt;
    }

    public void setCupsizt(String cupsizt) {
        this.cupsizt = cupsizt;
    }
}
