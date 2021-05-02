package cn.syx;

import cn.syx.bean.Employee;

import java.util.List;

/**
 * @author:syx
 * @date: 2021/5/2 15:22
 * @version:v1.0
 */
public interface EmployeeDAO {
    void addEmployee(Employee e);
    void updateEmployee(Employee e);
    void deleteEmployee(Employee e);
    Employee getByEid(int eid);
    List<Employee> getAll();
}
