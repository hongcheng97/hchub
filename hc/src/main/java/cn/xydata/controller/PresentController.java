package cn.xydata.controller;

import cn.xydata.entity.system.Present;
import cn.xydata.service.system.PresentService;
import oracle.jdbc.proxy.annotation.Pre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/present")
public class PresentController {
    @Autowired
    private PresentService presentService;
    @RequestMapping(value = "show")
    @ResponseBody
    public List<Present> showPresent(){
        List<Present> list=presentService.findAllPresent();
        return list;
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String updatePresent(int get,String presentName){
        int count = presentService.updatePresent(get,presentName);
        if(count==1){
            return "sysIndex";
        }else{
            return "shibai";
        }
    }

}
