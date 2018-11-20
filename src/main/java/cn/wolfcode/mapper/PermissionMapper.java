package cn.wolfcode.mapper;

import cn.wolfcode.domain.Employee;
import cn.wolfcode.domain.Permission;
import cn.wolfcode.query.EmployeeQueryObject;
import cn.wolfcode.query.QueryObject;

import java.util.List;

public interface PermissionMapper {
    public abstract int deleteByPrimaryKey(Long id);

    public abstract int insert(Permission record);

    public abstract Permission selectByPrimaryKey(Long id);

    public abstract List<Permission> selectAll();

    public abstract int updateByPrimaryKey(Permission record);

    public abstract int queryForCount(QueryObject qo);

    public abstract List<Permission> queryForList(QueryObject qo);

    public abstract List<String> selectAllExpression();

    public abstract void deletePermissonRole(Long permissonId);
}