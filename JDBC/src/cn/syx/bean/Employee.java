package cn.syx.bean;

import java.util.Date;

/**
 * @author:syx
 * @date:2021/5/2 15:14
 * @version:v1.0
 */
public class Employee {
    private int eid;
    private String ename;
    private String tel;
    private String gender;
    private double salary;
    private double commission_pct;
    private Date birthday;
    private Date hiredate;
    private int jobId;
    private String email;
    private int mid;
    private String address;
    private String native_place;
    private int did;

    public Employee(int eid, String ename, String tel, String gender, double salary, double commission_pct, Date birthday, Date hiredate, int jobId, String email, int mid, String address, String native_place, int did) {
        this.eid = eid;
        this.ename = ename;
        this.tel = tel;
        this.gender = gender;
        this.salary = salary;
        this.commission_pct = commission_pct;
        this.birthday = birthday;
        this.hiredate = hiredate;
        this.jobId = jobId;
        this.email = email;
        this.mid = mid;
        this.address = address;
        this.native_place = native_place;
        this.did = did;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(double commission_pct) {
        this.commission_pct = commission_pct;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", tel='" + tel + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", commission_pct=" + commission_pct +
                ", birthday=" + birthday +
                ", hiredate=" + hiredate +
                ", jobId=" + jobId +
                ", email='" + email + '\'' +
                ", mid=" + mid +
                ", address='" + address + '\'' +
                ", native_place='" + native_place + '\'' +
                ", did=" + did +
                '}';
    }
}
