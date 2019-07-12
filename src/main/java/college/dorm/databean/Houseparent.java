package college.dorm.databean;

/**
 * 对应数据表 宿管 其他循例
 * @author gzh
 *
 */
public class Houseparent {
    private Integer hpid;
    private String hpname;
    private String password;

    public Integer getHpid() {
        return hpid;
    }

    public void setHpid(Integer hpid) {
        this.hpid = hpid;
    }

    public String getHpname() {
        return hpname;
    }

    public void setHpname(String hpname) {
        this.hpname = hpname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Houseparent{" +
                "hpid=" + hpid +
                ", hpname=" + hpname +
                ", password='" + password + '\'' +
                '}';
    }
}
