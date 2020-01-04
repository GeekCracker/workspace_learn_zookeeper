package com.learn.zookeeper.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_user")
public class User extends BaseEntity {

    /**用户名*/
    private String userName;

    /**年龄*/
    private Long age;

    /**联系方式*/
    private String userPhone;

    /**角色ID*/
    private String roleId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
