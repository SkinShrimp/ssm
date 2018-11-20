package cn.wolfcode.service.impl;

import cn.wolfcode.domain.Department;
import cn.wolfcode.mapper.DepartmentMapper;
import cn.wolfcode.query.PageResult;
import cn.wolfcode.query.QueryObject;
import cn.wolfcode.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void save(Department entry) {
        departmentMapper.insert(entry);
    }

    @Override
    public void delete(Long id) {
        departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Department entry) {
        departmentMapper.updateByPrimaryKey(entry);
    }

    @Override
    public Department get(Long id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Department> listAll() {
        return departmentMapper.selectAll();
    }

    @Override
    public PageResult<Department> query(QueryObject qo) {
        int totalCount = departmentMapper.queryForCount(qo);
        if (totalCount == 0) {
            return new PageResult<Department>(0, Collections.EMPTY_LIST, qo);
        }
        List<Department> result = departmentMapper.queryForList(qo);
        return new PageResult<Department>(totalCount, result, qo);
    }
}


