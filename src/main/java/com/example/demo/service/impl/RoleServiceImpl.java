package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Role;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wym
 * @since 2021-05-14
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Role getRoleById(Integer id) {
        return roleMapper.selectById(id);
    }

    @Override
    public List<Role> getByLikeNameZh(String nameZh) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("nameZh", nameZh);
        return roleMapper.selectList(queryWrapper);
    }
}
