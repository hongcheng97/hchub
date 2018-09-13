package cn.xydata.entity.system;


import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_info")
public class Info {
    @Column(name = "ID")
    private int ID;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "PRESENTNAME")
    private String presentName;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "PHONE")
    private String phone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPresentName() {
        return presentName;
    }

    public void setPresentName(String presentName) {
        this.presentName = presentName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
