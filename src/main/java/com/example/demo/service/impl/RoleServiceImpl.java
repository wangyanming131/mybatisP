package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Role;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类,RedisCache使用
 * RedisCache自动配置会自动提供一个RedisCacheManager的Bean,这个bean间接实现了Spring中的Cache接口,
 * 有这个bean就可以使用Spring中缓存注解和接口了,而缓存数据会被自动存储到Redis上,如果是Redis集群,这个bean还需要开发者提供(单机Redis不需要)
 *
 * @author wym
 * @since 2021-05-14
 */
@Service
// 用来描述该类中所有方法的缓存名称c1,在配置文件中已配置,此处引用,当然也可以不是此注解,直接在具体的缓存注解上使用该名称
@CacheConfig(cacheNames = "c1")
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


    /**
     * 该注解一般加在查询方法上,表示一个方法的返回值缓存起来,默认情况下,缓存的key就是方法的参数,
     * 缓存的value就是方法的返回值,当有多个参数是,默认使用多个参数来做key,比如传值id=1,name=%test%时,key=c1::SimpleKey [2,%test%],
     * 如果需要一个参数做key,可以在@Cacheable中,通过key属性来指定key,指定"#id"时,key=#id::SimpleKey [2,%test%],
     * 如果对key有复杂要求,可以使用KeyGenerator
     *
     * @param id
     * @param name
     * @return
     */
    @Cacheable("#id")
    @Override
    public List<Role> getRoleByIdGreaterThanAndLikeName(Integer id, String name) {
        List<Role> roles = roleMapper.getRoleByIdGreaterThanAndLikeName(id, name);
        return roles;
    }

    /**
     * 注解@CachePut一般用在更新方法上,当数据库中数据更新后,缓存中的数据也要跟着更新,使用该注解,可以将方法的返回值自动更新到已经存在的key上
     *
     * @param role
     * @return
     */
    @Override
    // 设置key=c1::18即id=18即可
    @CachePut(key = "#role.id")
    public Role updateRoleById(Role role) {
        roleMapper.updateById(role);
        return role;
    }

    /**
     * 注解@CacheEvict这个注解一般用在删除方法上,当数据库中的数据删除后,相关的缓存数据也要自动清除,
     * 该注解使用的时候也可也配置安装某种条件删除或配置清除所有缓存
     *
     * @param id
     * @return
     */
    @Override
    @CacheEvict
    public Integer deleteById(Integer id) {
        Integer rows = roleMapper.deleteById(id);
        return rows;
    }


}
