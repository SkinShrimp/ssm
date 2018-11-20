package cn.wolfcode.service;

import cn.wolfcode.domain.Department;
import cn.wolfcode.domain.Role;
import cn.wolfcode.query.PageResult;
import cn.wolfcode.query.QueryObject;

import java.util.List;

public interface IDepartmentService {
    public abstract void save(Department entry);

    public abstract void delete(Long id);

    public abstract void update(Department entry);

    public abstract Department get(Long id);

    public abstract List<Department> listAll();

    public abstract PageResult<Department> query(QueryObject qo);

}
