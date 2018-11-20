package cn.wolfcode.service.impl;

import cn.wolfcode.domain.Permission;
import cn.wolfcode.mapper.PermissionMapper;
import cn.wolfcode.query.PageResult;
import cn.wolfcode.query.QueryObject;
import cn.wolfcode.service.IPermissionService;
import cn.wolfcode.util.RequiredPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.*;

@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    //注入spring上下文
    @Autowired
    private ApplicationContext ctx;

    @Override
    public void save(Permission entry) {
        permissionMapper.insert(entry);
    }

    @Override
    public void delete(Long id) {
        permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Permission entry) {
        permissionMapper.updateByPrimaryKey(entry);
    }

    @Override
    public Permission get(Long id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Permission> listAll() {
        return permissionMapper.selectAll();
    }

    @Override
    public PageResult<Permission> query(QueryObject qo) {
        int totalCount = permissionMapper.queryForCount(qo);
        if (totalCount == 0) {
            return new PageResult<Permission>(0, Collections.EMPTY_LIST, qo);
        }
        List<Permission> result = permissionMapper.queryForList(qo);
        return new PageResult<Permission>(totalCount, result, qo);
    }

    /**
     * 当用户更新权限的时候自动生成权限列表
     */
    @Override
    public void onload() {

        List<String> list = permissionMapper.selectAllExpression();

        //1.获取到Spring容器对象
        Map<String, Object> beansWithAnnotation = ctx.getBeansWithAnnotation(Controller.class);
        //2.从容器中获取到所有的Controller对象
        Collection<Object> values = beansWithAnnotation.values();
        //3.获取Controller对象中的所有的方法
        for (Object value : values) {
            String controllerName = value.getClass().getName();
            Method[] methods = value.getClass().getDeclaredMethods();
            for (Method method : methods) {
                //4.判断每个方法是否有贴@RequiredPermission注解
                if (method.isAnnotationPresent(RequiredPermission.class)) {
                    RequiredPermission annotation = method.getAnnotation(RequiredPermission.class);
                    String methodName = method.getName();
                    String permissionName = annotation.value();
                    //贴了:生成权限信息
                    String expression = controllerName+":"+methodName;
                    if(list.contains(expression)){
                        continue;
                    }
                    Permission permission = new Permission();
                    permission.setName(permissionName);
                    permission.setExpression(expression);
                    //5.将权限信息保存到数据库中
                    permissionMapper.insert(permission);
                }
            }
        }

    }

    @Override
    public void deletePermissonRole(Long permissonId) {
        permissionMapper.deletePermissonRole(permissonId);
    }
}
