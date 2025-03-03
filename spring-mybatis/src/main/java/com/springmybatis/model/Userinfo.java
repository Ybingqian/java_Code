package com.springmybatis.model;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.Date;


@Data
public class Userinfo {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Integer gender;
    private String phone;
    private Integer deleteflag;
    private Date createtime;
    private Date updatetime;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public Integer getGender() {
//        return gender;
//    }
//
//    public void setGender(Integer gender) {
//        this.gender = gender;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public Integer getDeleteflag() {
//        return deleteflag;
//    }
//
//    public void setDeleteflag(Integer deleteflag) {
//        this.deleteflag = deleteflag;
//    }
//
//    public Date getCreatetime() {
//        return createtime;
//    }
//
//    public void setCreatetime(Date createtime) {
//        this.createtime = createtime;
//    }
//
//    public Date getUpdatetime() {
//        return updatetime;
//    }
//
//    public void setUpdatetime(Date updatetime) {
//        this.updatetime = updatetime;
//    }
//
//    @Override
//    public String toString() {
//        return "Userinfo{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", age=" + age +
//                ", gender=" + gender +
//                ", phone='" + phone + '\'' +
//                ", deleteflag=" + deleteflag +
//                ", createtime=" + createtime +
//                ", updatetime=" + updatetime +
//                '}';
//    }
}
