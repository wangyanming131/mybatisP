package com.example.demo.controller;


import com.example.demo.entity.Role;
import com.example.demo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wym
 * @since 2021-05-14
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    IRoleService roleService;


    /**
     * 指定ID的role
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "getRoleById/{id}")
    public Role getRoleById(@PathVariable(value = "id") Integer id) {
        return roleService.getRoleById(id);
    }

    /**
     * 模糊nameZh查
     *
     * @param nameZh
     * @return
     */
    @RequestMapping(value = "/getByLikeNameZh")
    public List<Role> getByLikeNameZh(@RequestParam(value = "nameZh") String nameZh) {
        return roleService.getByLikeNameZh(nameZh);
    }

    @GetMapping(value = "/getRoleByIdGreaterThanAndLikeName")
    public List<Role> getRoleByIdGreaterThanAndLikeName(Integer id, String name) {
        name = "%" + name + "%";
        return roleService.getRoleByIdGreaterThanAndLikeName(id, name);
    }

    @RequestMapping(value = "/updateRoleById")
    public Role updateRoleById(Integer id) {
        Role role = roleService.getRoleById(id);
        role.setName("ROLE_test14");
        roleService.updateRoleById(role);
        return role;
    }

    @RequestMapping(value = "/deleteRoleById")
    public Integer deleteRoleById(Integer id) {
        Integer rows = roleService.deleteById(id);
        return rows;
    }


}
