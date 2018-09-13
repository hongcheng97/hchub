package cn.xydata.entity.system;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "t_users")
public class Users {

        @Column(name = "USERNAME")
        private String userName;

        @Column(name = "PASSWORD")
        private String password;

        @Column(name = "TYPE")
        private int type;

        @Column(name = "PHONE")
        private String phone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
