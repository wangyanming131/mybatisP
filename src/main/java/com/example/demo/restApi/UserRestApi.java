package com.example.demo.restApi;


import com.example.demo.apiModel.UserApiModel;
import com.example.demo.constant.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 1.@Api注解可以用来标记当前Controller的功能
 * 2.@ApiOperation注解用例标记一个方法的作用
 * 3.@ApiImplicitParam注解用来描述一个参数,可以配置参数的中文含义,也可以设置参数的默认值,避免调试接口是手动输入的麻烦
 * 4.如果有多个参数,则需要使用多个@ApiImplicitParam注解来描述,多个@ApiImplicitParam注解需要放在一个ApiImplicitParams注解中
 * 5.需要注意的是ApiImplicitParam注解虽然指定参数是必填的,但是不能代替@RequestParam(required = true),前者必填知识在Swagger2框架内必填,抛弃了@Swagger2,这个限制就没用了,所以如果开发者需要指定一个参数非空@RequestParam(required = true)不能省略
 * 6.如果参数是一个对象,对于参数的描述也可以放在实体类中@ApiModel,@ApiModelProperty
 */
@Controller
@Api(tags = "用户管理相关接口")
@RequestMapping(value = "/userRestApi")
public class UserRestApi {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "张三"),
            @ApiImplicitParam(name = "address", value = "地址", defaultValue = "北京市", required = true)
    })
    @ResponseBody
    public ResultInfo addUser(String username, @RequestParam(required = true) String address) {
        Integer code = 1;
        String message = "新增成功";
        System.out.println("username:" + username + ", address:" + address);
        ResultInfo resultInfo = new ResultInfo(code, message);
        return resultInfo;
    }

    @GetMapping(value = "/getUserById/{id}")
    @ApiOperation(value = "根据ID查询用户")
    @ApiImplicitParam(name = "id", value = "用户ID", defaultValue = "1", required = true)
    @ResponseBody
    public UserApiModel getUserById(@PathVariable(value = "id") Integer id) {
        System.out.println("id:" + id);
        UserApiModel user = new UserApiModel();
        user.setId(id);
        user.setUsername("陈雪");
        user.setAddress("北京市石景山区");
        return user;
    }

    @PutMapping(value = "/updateUserById")
    @ApiOperation("根据ID更新用户")
    @ResponseBody
    public UserApiModel updateUserById(@RequestBody UserApiModel user) {
        user.setId(user.getId() + 1);
        user.setUsername(user.getUsername() + 2);
        user.setAddress(user.getAddress() + 3);
        return user;

    }


}
