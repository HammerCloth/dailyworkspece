package cn.syx;

import cn.syx.bean.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * @author:syx
 * @date: 2021/5/2 16:11
 * @version:v1.0
 */
public class DepartmentDAOImpl extends BasicDAOImpl<Department> implements DepartmentDAO {
    @Override
    public void addDepartment(Department d) {
        String sql = "insert into t_department values(null,?,?)";
        try {
            update(sql,d.getDname(),d.getDescription());
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public void updateDepartment(Department d) {
        String sql = "update t_department set dname=?,description=? where did = ?";
        try {
            update(sql,d.getDname(),d.getDescription(),d.getDid());
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public void deleteDepartmentByDid(int did) {
        String sql = "delete from t_department where did =?";
        try {
            update(sql,did);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public Department getByDid(int did) {
        String sql = "select did,dname,description from t_department where did = ?";
        Department d = null;
        try {
            d = getBean(sql,1);
        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchFieldException throwables) {
            throw new RuntimeException(throwables);
        }
        return d;
    }

    @Override
    public List<Department> getAll() {
        String sql = "select did,dname,description from t_department";
        List<Department> list = null;
        try {
            list = getBeanList(sql);
        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchFieldException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
