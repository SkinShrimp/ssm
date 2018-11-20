package cn.wolfcode.mapper;

import cn.wolfcode.domain.Role;
import cn.wolfcode.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    void selectRoles();

    int queryForCount(QueryObject qo);

    List<Role> queryForList(QueryObject qo);

    void deleteRolePermission(Long roleId);

    void insertRolePermission(@Param("permissionId") Long permissionId, @Param("roleId") Long roleId);

    void deleteRoleEmployee(Long roleId);
}