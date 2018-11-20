package cn.wolfcode.service;

import cn.wolfcode.domain.Employee;
import cn.wolfcode.query.EmployeeQueryObject;
import cn.wolfcode.query.PageResult;

import java.util.List;

public interface IEmployeeService {
    public abstract void save(Employee entry);

    public abstract void delete(Long id);

    public abstract void update(Employee entry);

    public abstract Employee get(Long id);

    public abstract List<Employee> listAll();

    public abstract PageResult<Employee> query(EmployeeQueryObject qo);

    public abstract void login(String name, String password);

    public abstract void deleteEmployeeRoleRelation(Long emplId);

    public abstract void insertEmployeeRoleRelation(Long emplId, Long roleId);
}
