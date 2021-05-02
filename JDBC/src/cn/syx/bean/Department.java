package cn.syx.bean;

/**
 * @author:syx
 * @date: 2021/5/2 15:10
 * @version:v1.0
 */
public class Department {
    private int did;
    private String dname;
    private String description;

    public Department(int did, String dname, String description) {
        this.did = did;
        this.dname = dname;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
