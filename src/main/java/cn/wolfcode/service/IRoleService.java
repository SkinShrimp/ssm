package cn.wolfcode.service;

import cn.wolfcode.domain.Role;
import cn.wolfcode.query.PageResult;
import cn.wolfcode.query.QueryObject;

import java.util.List;

public interface IRoleService {
    public abstract void save(Role entry);

    public abstract void delete(Long id);

    public abstract void update(Role entry);

    public abstract Role get(Long id);

    public abstract List<Role> listAll();

    //角色不支持高级查询
    public abstract PageResult<Role> query(QueryObject qo);

    public abstract void deleteRolePermission(Long roleId);

    public abstract void insertRolePermission(Long permissionId, Long roleId);

    public abstract void deleteRoleEmployee(Long roleId);
}
