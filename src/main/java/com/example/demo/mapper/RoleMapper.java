package com.example.demo.mapper;

import com.example.demo.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wym
 * @since 2021-05-14
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 此种注解@select方式,必须使用@param否则参数无法赋值
     *
     * @param id
     * @param name
     * @return
     */
    @Select(value = "SELECT * FROM role t WHERE t.id > #{id} AND t.`name` LIKE #{name}")
    List<Role> getRoleByIdGreaterThanAndLikeName(@Param(value = "id") Integer id, @Param("name") String name);
}
