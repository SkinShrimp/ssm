package cn.wolfcode.service.impl;

import cn.wolfcode.domain.Employee;
import cn.wolfcode.domain.Permission;
import cn.wolfcode.mapper.EmployeeMapper;
import cn.wolfcode.query.EmployeeQueryObject;
import cn.wolfcode.query.PageResult;
import cn.wolfcode.service.IEmployeeService;
import cn.wolfcode.util.LogicException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void save(Employee entry) {
        employeeMapper.insert(entry);
    }

    @Override
    public void delete(Long id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Employee entry) {
        employeeMapper.updateByPrimaryKey(entry);
    }

    @Override
    public Employee get(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> listAll() {
        return employeeMapper.selectAll();
    }

    @Override
    public PageResult<Employee> query(EmployeeQueryObject qo) {
        int totalCount = employeeMapper.queryForCount(qo);
        EmployeeQueryObject object = new EmployeeQueryObject();
        object.setPageSize(qo.getPageSize());
        if (totalCount == 0) {
            return new PageResult<Employee>(0, Collections.EMPTY_LIST, object);
        }
        List<Employee> result = employeeMapper.queryForList(qo);
        return new PageResult<Employee>(totalCount, result, qo);
    }

    /**
     * 检验用户登陆
     *
     * @param name
     * @param password
     */
    @Override
    public void login(String name, String password) {
        Employee employee = employeeMapper.login(name, password);
        //用户不存在的情况
        if (employee == null) {
            throw new LogicException("亲,您的账号或者密码错误!!!");
        }

        //将用户信息保存在SESSION中(在service层中，不应该出现HttpSession应该在Controller层出现的变量)
        ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).
                getRequest().getSession().setAttribute("EMP_IN_SESSION", employee);

        //查询当前用户拥有的权限表达式，再共享到Session中
        ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).
                getRequest().getSession().setAttribute("EXPRESSIONS_IN_SESSION", employeeMapper.selectPermissionsByEmployeeId(employee.getId()));

    }

    @Override
    public void deleteEmployeeRoleRelation(Long emplId) {
        employeeMapper.deleteEmployeeRoleRelation(emplId);
    }

    @Override
    public void insertEmployeeRoleRelation(Long emplId, Long roleId) {
        employeeMapper.insertEmployeeRoleRelation(emplId, roleId);
    }
}
