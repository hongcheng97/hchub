package cn.xydata.controller;

import cn.xydata.entity.system.Users;
import cn.xydata.service.system.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/zhuce")
    public String zhuce(){ return "zhuce"; }

    @RequestMapping(value = "/sysIndex")
    public String sysIndex(){ return "sysIndex";};

    @RequestMapping(value = "/persenalHistory")
    public String persenalHistory(){
        return "persenalHistory";
    }

    @RequestMapping(value = "/allRecord")
    public String allRecord(){
        return "allRecord";
    }

    @RequestMapping(value = "/login1",method = RequestMethod.GET)
    public String login1(String userName, String password){
        Users users=usersService.login(userName,password);
        if (users!=null) {
            if (users.getType() == 2) {
                return "usersIndex";
            } else if (users.getType() == 1) {
                return "sysIndex";
            } else {
                return "login";
            }
        }
        return "login";
    }
    @RequestMapping(value = "/zhuce1",method = RequestMethod.POST)
    public String zhuce1(Users users){
       int count= usersService.addUser(users);
       if (count==1) {
           return "successful";
       }else {
           return "zhuce";
       }
    }

    @RequestMapping(value = "successfulTwo")
    public String successfulTwo(){
        return "usersIndexTwo";
    }

}
