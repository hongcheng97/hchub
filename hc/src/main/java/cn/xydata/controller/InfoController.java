package cn.xydata.controller;

import cn.xydata.entity.system.Info;
import cn.xydata.service.system.InfoService;
import io.swagger.models.auth.In;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("info")
public class InfoController {
    @Autowired
    private  InfoService infoService;

    @RequestMapping("find1")
    @ResponseBody
    public List<Info> findAll(Integer pageStart){
        int count=infoService.count();
        int total=count%5==0?count/5:count/5+1;
       List<Info> list =  infoService.findAllInfo(pageStart);
        System.out.println("sssssssssssss"+list.get(0).getID());
        return list;
    }
    @RequestMapping(value = "findOne")
    @ResponseBody
    public List<Info>  findOne(String userName){
        List<Info> list = infoService.findOne(userName);

        return list;
    }

    @RequestMapping(value = "add")
    public String addInfo(String userName, String presentName, String phone, Date date){
        infoService.addInfo(userName,presentName,phone,date);
        return "addSuccess";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping("delete")
    @ResponseBody
    public int deleteInfo(String userName){
       int count = infoService.deleteInfo(userName);
       return count;
    }

    @RequestMapping(value = "chart")
    @ResponseBody
    public void chartFileName(HttpSession session) throws IOException {
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        dcd.addValue(2, "04008", "Centos");
        dcd.addValue(3, "04008", "web");
        dcd.addValue(1, "04008", "Android");
        JFreeChart chart = ChartFactory.createBarChart("ITAEM member", "ITAEM", "number", dcd, PlotOrientation.VERTICAL,
                true, true, true);
//        FileOutputStream out =new FileOutputStream(new File("C:\\LLLLLLLLLLLLLLLLLLL\\itaem.png"));
//        ChartUtilities.writeChartAsPNG(out,chart,700,500);
    }
}
