package com.example.demo.restApi;


import com.example.demo.apiModel.UserApiModel;
import com.example.demo.constant.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
