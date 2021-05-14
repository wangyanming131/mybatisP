package com.example.demo.controller;


import com.example.demo.entity.Role;
import com.example.demo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "getByLikeNameZh")
    public List<Role> getByLikeNameZh(@RequestParam(value = "nameZh") String nameZh) {
        return roleService.getByLikeNameZh(nameZh);
    }


}
