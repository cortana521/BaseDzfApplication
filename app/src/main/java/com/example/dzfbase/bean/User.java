package com.example.dzfbase.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Android Studio.
 * User: daizhifeng1
 * Date: 2021/6/1
 * Time: 15:06
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long uId;
    private String name;
    @NotNull
    private String sex;
    @Generated(hash = 870568119)
    public User(Long uId, String name, @NotNull String sex) {
        this.uId = uId;
        this.name = name;
        this.sex = sex;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getUId() {
        return this.uId;
    }
    public void setUId(Long uId) {
        this.uId = uId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
}
