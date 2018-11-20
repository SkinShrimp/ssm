package cn.wolfcode.service.impl;

import cn.wolfcode.domain.Role;
import cn.wolfcode.mapper.RoleMapper;
import cn.wolfcode.query.PageResult;
import cn.wolfcode.query.QueryObject;
import cn.wolfcode.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void save(Role entry) {
        roleMapper.insert(entry);
    }

    @Override
    public void delete(Long id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Role entry) {
        roleMapper.updateByPrimaryKey(entry);
    }

    @Override
    public Role get(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> listAll() {
        return roleMapper.selectAll();
    }

    @Override
    public void deleteRolePermission(Long roleId) {
        roleMapper.deleteRolePermission(roleId);
    }

    @Override
    public void insertRolePermission(Long permissionId, Long roleId) {
        roleMapper.insertRolePermission(permissionId, roleId);
    }

    @Override
    public void deleteRoleEmployee(Long roleId) {
        roleMapper.deleteRoleEmployee(roleId);
    }

    @Override
    public PageResult<Role> query(QueryObject qo) {
        int totalCount = roleMapper.queryForCount(qo);
        if (totalCount == 0) {
            return new PageResult<Role>(0, Collections.EMPTY_LIST, qo);
        }
        List<Role> result = roleMapper.queryForList(qo);
        return new PageResult<Role>(totalCount, result, qo);
    }
}
