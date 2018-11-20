package cn.wolfcode.service;

import cn.wolfcode.domain.Permission;
import cn.wolfcode.query.PageResult;
import cn.wolfcode.query.QueryObject;

import java.util.List;

public interface IPermissionService {
    public abstract void save(Permission entry);

    public abstract void delete(Long id);

    public abstract void update(Permission entry);

    public abstract Permission get(Long id);

    public abstract List<Permission> listAll();

    public abstract PageResult<Permission> query(QueryObject qo);

    public abstract void onload();

    void deletePermissonRole(Long permissonId);
}
