package cn.xydata.controller;

import cn.xydata.common.controller.BaseController;
import cn.xydata.common.domain.result.Response;
import cn.xydata.common.domain.result.ResponseData;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author kaiqian
 * @CreateDate 2018/1/9
 */
@RestController
public class TestController extends BaseController {


    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    ResponseData hello(
            @RequestParam("name")String name
    ){
        Subject subject = SecurityUtils.getSubject();

        return new ResponseData(subject.getSession().getId());
    }


//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    ResponseData login(
//            @RequestParam("username")String username,
//            @RequestParam("password")String password
//    ) {
//
//        JSONObject jsonObject = new JSONObject();
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        try {
//            subject.login(token);
//            jsonObject.put("token", subject.getSession().getId());
//            jsonObject.put("msg", "登录成功");
//        } catch (IncorrectCredentialsException e) {
//            jsonObject.put("msg", "密码错误");
//        } catch (LockedAccountException e) {
//            jsonObject.put("msg", "登录失败，该用户已被冻结");
//        } catch (AuthenticationException e) {
//            jsonObject.put("msg", "该用户不存在");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return new ResponseData(jsonObject);
//    }
}
