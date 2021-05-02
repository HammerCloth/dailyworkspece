package cn.syx;

import cn.syx.bean.Department;

import java.util.List;

/**
 * @author:syx
 * @date:2021/5/2 15:08
 * @version:v1.0
 */
public interface DepartmentDAO {
    void addDepartment(Department d);
    void updateDepartment(Department d);
    void deleteDepartmentByDid(int did);
    Department getByDid(int did);
    List<Department> getAll();
}
