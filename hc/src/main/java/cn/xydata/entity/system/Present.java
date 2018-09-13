package cn.xydata.entity.system;



import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "t_present")
public class Present {

    @Column(name = "PRESENTNAME")
    private String presentName;

    @Column(name = "PRESENTTYPE")
    private  int presentType;

    @Column(name = "GET")
    private int get;

    @Column(name = "TIMES")
    private int times;

    public String getPresentName() {
        return presentName;
    }

    public void setPresentName(String presentName) {
        this.presentName = presentName;
    }

    public int getPresentType() {
        return presentType;
    }

    public void setPresentType(int presentType) {
        this.presentType = presentType;
    }

    public int getGet() {
        return get;
    }

    public void setGet(int get) {
        this.get = get;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
