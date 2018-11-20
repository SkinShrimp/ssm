package cn.wolfcode.mapper;

import cn.wolfcode.domain.Employee;
import cn.wolfcode.query.EmployeeQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    public abstract int deleteByPrimaryKey(Long id);

    public abstract int insert(Employee record);

    public abstract Employee selectByPrimaryKey(Long id);

    public abstract List<Employee> selectAll();

    public abstract int updateByPrimaryKey(Employee record);

    public abstract int queryForCount(EmployeeQueryObject qo);

    public abstract List<Employee> queryForList(EmployeeQueryObject qo);

    public abstract Employee login(@Param("name") String name, @Param("password") String password);

    public abstract void deleteEmployeeRoleRelation(Long empId);

    public abstract void insertEmployeeRoleRelation(@Param("emplId") Long emplId, @Param("roleId") Long roleId);

    /**
     *通过员工ID查询员工的权限
     * @param employeeId
     * @return
     */
    public abstract List<String> selectPermissionsByEmployeeId(Long employeeId);
}