package com.example.demo.service;

import com.example.demo.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wym
 * @since 2021-05-14
 */
public interface IRoleService extends IService<Role> {

    Role getRoleById(Integer id);

    List<Role> getByLikeNameZh(String nameZh);

    List<Role> getRoleByIdGreaterThanAndLikeName(Integer id, String name);

    Role updateRoleById(Role role);

    Integer deleteById(Integer id);

}
