package cn.wolfcode.mapper;

import cn.wolfcode.domain.Department;
import cn.wolfcode.query.QueryObject;

import java.util.List;

public interface DepartmentMapper {
    public abstract void insert(Department entry);
    public abstract void deleteByPrimaryKey(Long id);
    public abstract void updateByPrimaryKey(Department entry);
    public abstract Department selectByPrimaryKey(Long id);
    public abstract List<Department> selectAll();

    int queryForCount(QueryObject qo);

    List<Department> queryForList(QueryObject qo);
}
